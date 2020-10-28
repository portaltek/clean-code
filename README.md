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

    
    mkdir myapp | cd myapp/
    gradle init 
    git init
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
    
    ext {
        springBootVersion = "2.3.4.RELEASE"
    }
    
    dependencies {
        implementation(
                "org.springframework.boot:spring-boot-starter-web:$springBootVersion",
                "org.springframework.boot:spring-boot-starter-test:$springBootVersion",
        )
    }
    
    repositories {
        mavenCentral()
    }
    test {
        useJUnitPlatform()
    }
    
    bootJar {
        archiveBaseName.set(rootProject.name)
        archiveVersion.set('1.0.0')
        archiveFileName = rootProject.name + "-" + archiveVersion.get() + ".jar"
    }


    
    # Click load gradle changes. 
    
    
    
Create project structure under myapp folder:

    └── src
        └── main
            └── java    
            └── resources
        └── test
            └── java    
            └── resources
  
    ######################################################################################################
    
    mkdir app app/api app/api/rest app/core app/spi app/spi/repo
    mkdir src src/main src/main/java src/main/resources 
    mkdir src/test src/test/java src/test/resources
    
    cd src/main/java/ 
    mkdir mycompany  mycompany/myapp 
    touch mycompany/myapp/MyApp.java
    
    ######################################################################################################
    # Paste the following code on the main class.
    
    package portaltek.myapp;
    
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @SpringBootApplication
    @RestController
    class MyApp {
    
        @GetMapping("/rest/open/hello")
        public String helloWorld(){
            return "Hello World!!!\n";
        }
    
        public static void main(String[] args) {
            SpringApplication.run(MyApp.class, args);
        }
    
    }

Run the app and execute on terminal:

     curl localhost:8080/rest/open/hello


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










