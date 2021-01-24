# ArSpringBootEmpApi

java -jar  
./mvnw clean package  
sudo docker build -f Dockerfile -t ar-springboot-emp-api-img .  
sudo docker images  
sudo docker run -p 8777:8777 ar-springboot-emp-api-img  
After running the docker image, it will be running locally at http://localhost:8777/
