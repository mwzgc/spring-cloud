cd ../
mvn clean package
docker-compose build
docker rmi $(docker images -f "dangling=true" -q)