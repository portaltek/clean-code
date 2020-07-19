# AWS Template Project

TODO List:
    
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

Commands to Initialize any project:

    mkdir <PROJECT_NAME>
    cd <PROJECT_NAME>/
    gradle init
    git init
    stree .
    idea .


Create project structure under <PROJECT_NAME> folder:

    └── src
        └── main
            └── java    
            └── resources
        └── test
            └── java    
            └── resources



Update file build.gradle by adding:
    
    apply plugin: 'java'

Click load gradle changes. 







Conditions:
  UseDbSnapshot: !Not
    - !Equals
      - !Ref DBSnapshotIdentifier
      - ''