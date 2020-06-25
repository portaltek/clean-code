

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

IMPORTANT CHANGE MADE IN MASTER
MINOR CHANGE MADE IN MASTER