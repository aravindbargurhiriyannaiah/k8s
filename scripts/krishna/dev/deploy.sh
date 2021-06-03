#!/bin/zsh
set -x
kubectl apply -f namespace.yaml
kubens dev
cd ../../../krishna
./gradlew clean build
docker build -t aravindbargurbh/krishna:0.0.1 .
docker push aravindbargurbh/krishna:0.0.1
cd -
kubectl apply -f deployment.yaml
kubectl get all
