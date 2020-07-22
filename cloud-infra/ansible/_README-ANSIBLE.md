# ANSIBLE SCRIPTS

Set SSH Keys and AWS Profile.

    # REMOVE ALL SSH KEYS
    ssh-add -D

    # SET SSH KEY 
    eval $(ssh-agent) | ssh-add ~/.ssh/projects/cleancode/ccd-dv_keypair_us-east-2.pem | ssh-add -l
    
    # SET PROFILES AND DISPLAY CURRENT PROFILE
    export AWS_PROFILE=cleancode && aws configure list

    # ALL-IN-ONE WITH ALIASES
    cleancode.aws


Ansible Scripts.

    cd cloud-infra/ansible/
    
    # 0- Initialization scripts.
    ansible-playbook -e "env=dv" _create-log-bucket.yml
    ansible-playbook -e "env=dv" _create-credentials-bucket.yml
        
        
    # 1- VPC Tier
    ansible-playbook -e "env=dv" create-vpc-tier.yml
    
    # 2- Consul Tier
    ansible-playbook -e "env=dv" create-consul-tier.yml
    
    # 3- Database Tier
    ansible-playbook -e "env=dv" create-database-tier.yml
    
    # 4- Setup Consul Tier
    ansible-playbook -e "env=dv" setup-consul-tier.yml
        
    # X- CREATE ALL Script
    ansible-playbook -e "env=dv" create-all.yml        
        
    # TODO
    - Create a db-cluster script.
    
    # Remember to add AWS profile and add PEM keypair.
    ansible-inventory -i inventory/aws_ec2.yml --graph
    ansible-playbook -e "env=dv" setup-consul-tier.yml
    ssh -F ansible_ssh_config ubuntu@172.16.3.45
    
    
    ansible-playbook -e "env=qa" setup-consul-tier.yml

OPTIONAL:

    ansible-playbook -e "env=dv" create-bastionhost.yml
    
    aws ec2 describe-instances --filters "Name=tag:Name,Values=ccd-dv-bastion-host" "Name=instance-state-name,Values=running" | jq -r .Reservations[].Instances[].PublicDnsName
    aws ec2 describe-instances | jq -r .Reservations[].Instances[].PublicDnsName
    
 Ansible-vault  
 
     echo 'myPassword' > vault/vault-key.txt #Usually this file can be stored in AWS S3
     echo 'password' > vault/encrypted-file.txt 
     ansible-vault --vault-password-file=vault/vault-key.txt encrypt vault/encrypted-file.txt 
     
     ansible-vault --vault-password-file=vault/vault-key.txt view vault/encrypted-file.txt 
     
     
 DB-Cluster
 
    - Research how to send parameters to create DB for the first time.
    - Enable automated snaptshots and backtrack feature.
    - Upgrade MySQL version to 8.0???
    - Upgrade DBTypeClass.
    
      ansible --list-hosts all
      aws s3 cp s3://ccd-dv-credentials-bucket/vault-key.txt -
    

Consul-Cluster

    # Get the desired DB-Cluster endpoint for QA env:
    aws rds describe-db-clusters | jq --arg env qa -r '.DBClusters | map(select(.Endpoint | startswith($env))) | sort_by(.ClusterCreateTime) | reverse | map(.Endpoint)[0]'
    
    # Output for QA env:
    qa-db-dbcluster-1mpbmkvw1luni.cluster-cijbgtbkerbk.us-east-1.rds.amazonaws.com
    
        
    # Check AWS Web console the CONSUL ips or 
    # check any host under tab_Name_{{ENV}}_consul_server:
    ansible-inventory -i inventory/aws_ec2.yml --graph
    
    # Extract IP from Consul server dns name: ip-172-21-4-116.ec2.internal 
    ssh -F ansible_ssh_config ubuntu@172.21.4.116
    
    # Save the following output to do a validation at the end.
    curl http://localhost:8500/v1/kv/beacon/studio/DB_HOSTNAME?format=text
    
    # Use curl to setup the database cluster.
    curl \
        --request PUT \
        --data 'qa-db-dbcluster-1mpbmkvw1luni.cluster-cijbgtbkerbk.us-east-1.rds.amazonaws.com' \
        http://localhost:8500/v1/kv/beacon/studio/DB_HOSTNAME
        
    # Validate the value changed.
    curl http://localhost:8500/v1/kv/beacon/studio/DB_HOSTNAME?format=text