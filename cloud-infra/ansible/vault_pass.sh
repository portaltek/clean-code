#! /bin/sh
if [ -z "$ENV" ]; then
 ENV='dv';
fi
APP=ccd
aws s3 cp s3://$APP-$ENV-credentials-bucket/vault-key.txt -


