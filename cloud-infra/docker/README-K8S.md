# K8S
### Install Kubectl in MAC
    brew install kubectl
    kubectl version --client
    kubectl cluster-info
    kubectl get all

### Install Kubectl in MAC
    brew install kind
    kind create cluster

### Run specific docker file.
    docker build -t portaltek/docker:1.0.0 -f Dockerfile .
    docker run --rm -p 8080:8080 portaltek/docker:1.0.0
    
    docker build -t portaltek/k8s:1.0.0 -f docker.k8s.dockerfile .
    docker run --rm -p 8080:8080 portaltek/k8s:1.0.0
    docker run --rm -ti --entrypoint /bin/sh -p 8080:8080 portaltek/k8s:1.0.0
    docker run -ti -p 8080:8080 portaltek/k8s:1.0.0

### Validate docker container app is running.
    curl localhost:8080/hello



### Create k8s deployment.yaml
    kubectl create deployment demo --image=portaltek/k8s:1.0.0 --dry-run=client -o=yaml > deployment.yaml
    echo --- >> deployment.yaml
    kubectl create service clusterip demo --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml

    kubectl apply -f deployment.yaml
    kubectl get all