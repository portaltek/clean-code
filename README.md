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

    
    mkdir MY_PROJECT | cd MY_PROJECT/
    gradle init 
    git init
    mkdir src src/main src/main/java src/main/resources 
    mkdir src/test src/test/java src/test/resources
    mkdir app app/api app/api/rest 
    mkdir app/core
    mkdir app/spi app/spi/repo app/spi/mongo 
    idea .

Optional     
    
    stree .
    
Update .gitignore with:
    
    
    HELP.md
    .gradle
    build/
    !gradle/wrapper/gradle-wrapper.jar
    !**/src/main/**
    !**/src/test/**
    
    ### STS ###
    .apt_generated
    .classpath
    .factorypath
    .project
    .settings
    .springBeans
    .sts4-cache
    
    ### IntelliJ IDEA ###
    .idea
    *.iws
    *.iml
    *.ipr
    out/
    
    ### NetBeans ###
    /nbproject/private/
    /nbbuild/
    /dist/
    /nbdist/
    /.nb-gradle/
    
    ### VS Code ###
    .vscode/
    **.DS_Store
    *.DS_Store
    .DS_Store
    .DS_Store?
    

Update file build.gradle by adding:
    
    plugins {
        id 'org.springframework.boot' version '2.3.0.RELEASE'
        id "io.spring.dependency-management" version "1.0.6.RELEASE"
        id 'java'
        id 'idea'
    }
    
    description = rootProject.name
    sourceCompatibility = 15
    targetCompatibility = 15
    
    dependencies {
        implementation(
                'org.springframework.boot:spring-boot-starter-web'
        )
    }
    
    repositories {
        mavenCentral()
    }
    test {
        useJUnitPlatform()
    }
    
    bootJar {
        archiveBaseName = rootProject.name
        archiveVersion = '1.0.0'
        archiveFileName = rootProject.name + '.jar'
    }


    
    # Click load gradle changes. 
    
    
    
Create project structure under MY_PROJECT folder:

    └── src
        └── main
            └── java    
            └── resources
        └── test
            └── java    
            └── resources
  
    ######################################################################################################
    
    mkdir src src/main src/main/java src/main/resources src/test src/test/java src/test/resources 
    mkdir src/main/java/mycompany  src/main/java/mycompany/myproject
    touch src/main/java/mycompany/myproject/MyProject.java
    
    ######################################################################################################
    # Paste the following code on the main class.
    
    package mycompany.myproject;
    
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @SpringBootApplication
    @RestController
    public class MyProject {
    
        @GetMapping("/rest/open/hello")
        public String helloWorld(){
            return "Hello World!!!";
        }
    
        public static void main(String[] args) {
            SpringApplication.run(MyProject.class, args);
        }
    
    }


Add to .gitignore file:

    HELP.md
    .gradle
    build/
    !gradle/wrapper/gradle-wrapper.jar
    !**/src/main/**
    !**/src/test/**
    
    ### STS ###
    .apt_generated
    .classpath
    .factorypath
    .project
    .settings
    .springBeans
    .sts4-cache
    
    ### IntelliJ IDEA ###
    .idea
    *.iws
    *.iml
    *.ipr
    out/
    
    ### NetBeans ###
    /nbproject/private/
    /nbbuild/
    /dist/
    /nbdist/
    /.nb-gradle/
    
    ### VS Code ###
    .vscode/
    **.DS_Store
    *.DS_Store
    .DS_Store
    .DS_Store?










