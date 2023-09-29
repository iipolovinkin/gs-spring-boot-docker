#./mvnw clean package -X

mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

docker build -t springio/gs-spring-boot-docker .

#docker run -p 8080:8080 -t springio/gs-spring-boot-docker
#docker run -p 8084:8084 -t springio/gs-spring-boot-docker

#image springio/gs-spring-boot-docker

#./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker