#! /bin/sh

# Make sure to use all our CPUs, because Consul can block a scheduler thread
export GOMAXPROCS=`nproc`

BOOTSTRAP_EXPECT=3
URL="http://instance-data/latest/"
ID=$(curl -s $URL/meta-data/instance-id)
IP_ADDRESS=$(curl -s $URL/meta-data/local-ipv4)
REGION=$(curl -s $URL/dynamic/instance-identity/document | jq -r .region)
ENV=$(aws --region $REGION ec2 describe-tags --filters "Name=resource-id,Values=$ID" "Name=key,Values=Environment" --region $REGION | jq -r .Tags[].Value)

SERVERS=$(aws --region $REGION ec2 describe-instances --filters "Name=tag:Name,Values=${ENV}-consul-server" "Name=instance-state-name,Values=running" | jq -r '.Reservations[].Instances[].PrivateIpAddress')

if [ $(echo "$SERVERS" | wc -l) -lt $BOOTSTRAP_EXPECT ];then
    echo "Not enough peers, expected $BOOTSTRAP_EXPECT nodes but got $SERVERS"
    exit 1
fi

/usr/bin/consul agent -config-dir="/etc/consul.d" ${CONSUL_FLAGS} -advertise=$IP_ADDRESS $(echo "$SERVERS" | sed 's/^/ -retry-join /' | tr -d '\n')