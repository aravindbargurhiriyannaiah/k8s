#!/bin/zsh
set -x
set -e
cd ../../
./gradlew clean build
docker build -t aravindbargurbh/krishna:0.0.1 .
docker push aravindbargurbh/krishna:0.0.1
cd -
kubectl apply -f deployment.yaml
kubens dev
kubectl get all
