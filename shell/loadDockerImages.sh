#!/bin/bash

#create VM and start it
vagrant up --provider=virtualbox

#create docker network
vagrant ssh -c 'docker network create parcelconfig-net'

for var in "$@"
do
   	#save docker image as tar file, so we can transfer it to remote machine
	docker save -o $var $var
	
	#ssh command to load packed docker image in registry on remote machine
	vagrant ssh -c 'docker load -i /vagrant/'$var

done

#install mysql docker container and load it
docker save -o parcel-mysql mysql/mysql-server:5.7.21

vagrant ssh -c 'docker load -i /vagrant/parcel-mysql'

