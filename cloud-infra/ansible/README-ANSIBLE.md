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

    # VPC Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-vpc.yml
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-log-bucket.yml
    
    # Consul Tier
    ansible-playbook -e "env=dv" cloud-infra/ansible/create-consul.yml


OPTIONAL:

    ansible-playbook -e "env=dv" cloud-infra/ansible/create-bastionhost.yml