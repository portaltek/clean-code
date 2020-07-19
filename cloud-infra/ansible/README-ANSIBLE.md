# ANSIBLE SCRIPTS

Set SSH Keys and AWS Profile.

    # REMOVE ALL SSH KEYS
    ssh-add -D

    # SET SSH KEY 
    eval $(ssh-agent) | ssh-add ~/.ssh/projects/ansible_tutorial/ansible_tutorial.pem | ssh-add -l
    
    # SET PROFILES AND DISPLAY CURRENT PROFILE
    export AWS_PROFILE=ansible_tutorial && aws configure list


    
    # ALL-IN-ONE
    ssh-add -D && eval $(ssh-agent) && ssh-add ~/.ssh/projects/ansible_tutorial/ansible_tutorial.pem && ssh-add -l 
    export AWS_PROFILE=ansible_tutorial && aws configure list


Ansible Scripts.

    # Initialization scripts.
    ansible-playbook -e "env=dv" cloud-infra/ansible/_create-log-bucket.yml
    ansible-playbook -e "env=dv" cloud-infra/ansible/_create-db-cluster.yml
        
    # VPC Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-vpc-tier.yml
    
    # Consul Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-consul-tier.yml
    
    # Database Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-database-tier.yml
    # TODO
    - Create a db-cluster script.
 
    

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
 
    Conditions:
      UseDbSnapshot: !Not
        - !Equals
          - !Ref DBSnapshotIdentifier
          - ''  
          
        SnapshotIdentifier: !If
        - UseDbSnapshot
        - !Ref DBSnapshotIdentifier
        - !Ref 'AWS::NoValue'      