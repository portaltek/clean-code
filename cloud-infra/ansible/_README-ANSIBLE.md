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

    # 0- Initialization scripts.
    ansible-playbook -e "env=dv" cloud-infra/ansible/_create-log-bucket.yml
        
        
    # 1- VPC Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-vpc-tier.yml
    
    # 2- Consul Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-consul-tier.yml
    
    # 3- Database Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-database-tier.yml
    
    # 4- Setup Consul Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/setup-consul-tier.yml
        
    # X- CREATE ALL Script
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-all.yml        
        
    # TODO
    - Create a db-cluster script.
 
    ansible-inventory -i demo.aws_ec2.yml --graph
    ansible-inventory -i cloud-infra/ansible/aws_ec2.yml --graph

OPTIONAL:

    ansible-playbook -e "env=dv" cloud-infra/ansible/create-bastionhost.yml
    
    aws ec2 describe-instances --filters "Name=tag:Name,Values=ccd-dv-bastion-host" "Name=instance-state-name,Values=running" | jq -r .Reservations[].Instances[].PublicDnsName
    aws ec2 describe-instances | jq -r .Reservations[].Instances[].PublicDnsName
    
 Ansible-vault  
 
     cd cloud-infra/ansible/
     echo 'myPassword' > vault/password-file.txt #Usually this file can be stored in AWS S3
     echo 'HELLO WORLD!!!' > vault/encrypted-file.txt 
     ansible-vault --vault-password-file=./vault/password-file.txt encrypt vault/encrypted-file.txt 
     
     ansible-vault --vault-password-file=./vault/password-file.txt view vault/encrypted-file.txt 
     
     
 DB-Cluster
 
    - Research how to send parameters to create DB for the first time.
    - Enable automated snaptshots and backtrack feature.
    - Upgrade MySQL version to 8.0???
    - Upgrade DBTypeClass.