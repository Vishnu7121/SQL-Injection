#!/bin/bash

DIR=./srikanth
[ -d $DIR ] && echo "Directory Exists" || mkdir $DIR
fi
cd ./srikanth/
echo "cloning a SQL-Injection"
sudo git clone https://github.com/srikanthreddy-lectures/SQL-Injection.git
cd ./srikanth/SQL-Injection/
sudo ant -d clean compile dist
result=$( sudo docker images -q sql-injection_web )
if [[ -n "$result" ]]; then
echo "image exists"
sudo docker-compose down --volume --rmi all
else
echo "No such image"
fi
echo "build the docker image"
sudo docker-compose up -d
