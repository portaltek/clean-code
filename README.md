## AWS Template Project

#### TODO 
    - Load balancer.
    - Consul.
    - IAM
        - Separate accounts to access certain env resources.
    - RDS 
        - Migrate to a better server specs.
        - Add more readonly replicas. 
        - Tutorials point 
        
    - SumoLogic:
        - Installation with ansible-aws/bastion.yml template    

#### Commands to Initialize any project:

```shell
mkdir <PROJECT_NAME>
cd <PROJECT_NAME>/
gradle init
git init
stree .
idea .
```

#### Create project structure under <PROJECT_NAME> folder:

```shell
└── src
    └── main
        └── java    
        └── resources
    └── test
        └── java    
        └── resources
```


Update file build.gradle by adding:
```shell
apply plugin: 'java'
```
Click load gradle changes. 


#### Set SSH Keys and AWS Profile
```shell
#SET SSH KEY 
eval $(ssh-agent) | ssh-add ~/.ssh/projects/ansible_tutorial/ansible_tutorial.pem | ssh-add -l

#REMOVE ALL SSH KEYS
ssh-add -D

#SET PROFILES AND DISPLAY CURRENT PROFILE
export AWS_PROFILE=ansible_tutorial && aws configure list

#ALL IN ONE
ssh-add -D && eval $(ssh-agent) && ssh-add ~/.ssh/projects/ansible_tutorial/ansible_tutorial.pem && ssh-add -l 
export AWS_PROFILE=ansible_tutorial && aws configure list

```

#### Ansible Scripts
```shell
# VPC Tier
ansible-playbook -e "env=dv" cloud-infra/ansible/create-vpc.yml
ansible-playbook -e "env=dv" cloud-infra/ansible/create-log-bucket.yml
# Consul Tier
ansible-playbook -e "env=dv" cloud-infra/ansible/create-consul.yml
#Not required:
ansible-playbook -e "env=dv" cloud-infra/ansible/create-bastionhost.yml




```

