

**INITIAL COMMANDS:**

```shell
mkdir <PROJECT_NAME>
cd <PROJECT_NAME>/
gradle init
git init
stree .
idea .
```

**Create project structure under <PROJECT_NAME> folder:**

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


```shell
#SET SSH KEY 
eval $(ssh-agent) | ssh-add ~/.ssh/projects/ansible_tutorial/ansible_tutorial.pem | ssh-add -l

#REMOVE ALL SSH KEYS
ssh-add -D

#SET PROFILES AND DISPLAY CURRENT PROFILE
export AWS_PROFILE=ansible_tutorial && aws configure list

```