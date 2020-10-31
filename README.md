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
    
    mkdir app app/api app/api/rest app/core app/spi app/spi/repo app/util
    
    
    export folders="src src/main src/main/java src/main/resources src/test src/test/java src/test/resources"
    mkdir modules $folders; 
    mkdir src/main/java/myapp; touch src/main/java/myapp/MyApp.java
    mkdir modules/util; cd modules/util; touch build.gradle; mkdir $folders; cd ../.. 
    mkdir modules/core; cd modules/core; touch build.gradle; mkdir $folders; cd ../.. 
    mkdir modules/api modules/api/rest; cd modules/api/rest; touch build.gradle; mkdir $folders; cd ../../.. 
    mkdir modules/spi modules/spi/repo; cd modules/spi/repo; touch build.gradle; mkdir $folders; cd ../../.. 
    

    
    ######################################################################################################
    # Paste the following code on the main class.
    
    package mycompany.myapp;
    
    import mycompany.myapp.api.rest.RestApiHelloWorld;
    import mycompany.myapp.util.Sleep;
    import mycompany.myapp.util.UtilHelloWorld;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    import static org.springframework.boot.SpringApplication.run;
    
    @SpringBootApplication
    @RestController
    class MyApp {
    
        @GetMapping("/rest/open/hello")
        public String helloWorld() {
            var utilHelloWorld = new UtilHelloWorld();
            var restApiHelloWorld = new RestApiHelloWorld();
            Sleep.sleep(1000);
            return utilHelloWorld.hello() + restApiHelloWorld.hello();
        }
    
        public static void main(String[] args) {
            run(MyApp.class, args);
        }
    
    }

Run the app and execute on terminal:

     curl localhost:8080/rest/open/hello
     curl localhost:8080/rest/open/controller


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










