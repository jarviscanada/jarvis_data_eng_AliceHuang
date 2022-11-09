#! /bin/sh

#capture CLI arguments
cmd=$1
db_username=$2
db_password=$3

#Start docker
sudo systemctl status docker || sudo systemctl start docker

#check container status
container_status=$(docker container inspect jrvs-psql)

#User switch case to handle create|stop|start opetions
case $cmd in
  create)

  # Check if the container is already created
  if [ "$container_status" != "[]" ]; then
		echo 'Container already exists'
		exit 1
	fi

  #check # of CLI arguments
  if [ $# -ne 3 ]; then
    echo 'Create requires username and password'
    exit 1
  fi

  #Create container
  docker volume create pgdata
	docker run --name jrvs-psql -e POSTGRES_PASSWORD=$PGPASSWORD -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres:9.6-alpine
	exit 0
	;;

  start|stop)
  #check instance status; exit 1 if container has not been created
  if [ "$container_status" == "[]" ]; then
    echo 'Container has not been created'
    exit 1
  fi

  #Start or stop the container
	docker container $cmd jrvs-psql
	exit 0
	;;

  *)
	echo 'Illegal command'
	echo 'Commands: start|stop|create'
	exit 1
	;;
esac