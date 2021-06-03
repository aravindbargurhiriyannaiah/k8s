#!/bin/zsh
set -x
kubectl apply -f namespace.yaml
kubens dev
cd ../../../arjuna
./gradlew clean build
docker build -t aravindbargurbh/arjuna:0.0.1 .
docker push aravindbargurbh/arjuna:0.0.1
cd -
kubectl apply -f deployment.yaml
kubectl get all
