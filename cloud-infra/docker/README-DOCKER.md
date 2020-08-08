# DOCKER
#### Basic image commands.
    docker image ls
    docker images
    docker rmi IMAGE_ID|REPOSITORY
    docker rmi $(docker images -q)
    
#### Basic containers commands.
    docker ps -a
    docker stop $(docker ps -aq)
    docker rm CONTAINER_ID|NAMES
    docker rm $(docker ps -aq)

#### STOP and REMOVE ALL containers and images.
    docker stop $(docker ps -aq) & docker rm $(docker ps -aq) & docker rmi $(docker images -q) 
    
#### BUILD images and RUN
    mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
    docker build -t portaltek/docker:1.0.0 -f cloud-infra/docker/build.dockerfile .
    docker run --rm -p 8080:8080 portaltek/docker:1.0.0
    docker run --rm -e "SPRING_PROFILES_ACTIVE=PR" -p 8080:8080 -t portaltek/docker:1.0.0

#### DEBUG A DOCKER CONTAINER
    docker run --rm -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t portaltek/docker:1.0.0
    
#### OPTIONAL: create docker image with gradle. Additional research required.
    ./gradlew docker

#### Check running container.
    docker exec -ti 25e1bfa93acc /bin/sh


#### LINUX: List groups and users.
    echo "--------- GROUPS: ---------" && groups && echo "--------- USERS: ---------" && awk -F: '{ print $1}' /etc/passwd

#### RUN docker java app manually.
    docker run --rm -ti --entrypoint /bin/sh -p 8080:8080 portaltek/docker:1.0.0
    java -cp app:app/lib/* portaltek.cleancode.CleanCodeApp
    
    
    
#### Upload docker image to AWS ECR.
    $(aws ecr get-login --no-include-email --region us-east-2)
    aws ecr create-repository --repository-name cleancode-app --region us-east-2
    docker tag be5ca67ab234 793628107353.dkr.ecr.us-east-2.amazonaws.com/clean-code:dv
    docker push 793628107353.dkr.ecr.us-east-2.amazonaws.com/clean-code:dv
    docker logout
    
    