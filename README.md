README.md

===============================================================================================================
mkdir <PROJECT_NAME>
cd <PROJECT_NAME>/
gradle init
git init
stree .
idea .

===============================================================================================================
Create project structure under <PROJECT_NAME> folder:
<PROJECT_NAME>
└── src
    └── main
        └── java    
        └── resources
    └── test
        └── java    
        └── resources

===============================================================================================================
Update file build.gradle by adding:
apply plugin: 'java'


And click load gradle changes. 