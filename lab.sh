#!/bin/bash

DIR=/home/ubuntu/lab1
FILE=/home/ubuntu/lab1/output
container_name=SQL-Injection
if [ -d "$DIR" ];
then
printf '%s\n' "SQL-Injection dir ($DIR)"
rm -rf "$DIR"
else
echo "now no SQL-Injection a dir"
fi
echo "cloning a SQL-Injection dir"
sudo git clone https://github.com/srikanthreddy-lectures/SQL-Injection.git
cd /home/ubuntu/lab1/SQL-Injection/
sudo ant -d clean compile dist
result=$( sudo docker images -q sql-injection_web )
if [[ -n "$result" ]]; then
echo "image exists"
sudo docker-compose down --volume --rmi all
else
echo "No such image"
fi
echo "change the dir"

echo "delete output file"
echo "build the docker image"
sudo docker-compose up >> $FILE
