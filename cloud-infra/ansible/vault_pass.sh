#! /bin/sh
if [ -z "$ENV" ]; then
 ENV='dev';
fi
APP=cleancode
aws s3 cp s3://$APP-$ENV-credentials-bucket/vault-key.txt -


