1. `mvn clean package`
2. bash: `run.sh`  build docker image `gs-spring-boot-docker`
3. Every get request increment metric `hello_success`
4. cd C:\work\iip\projects\Docker-Compose-Prometheus-and-Grafana
5. `docker-compose up -d`
6. http://localhost:8084/
7. http://localhost:3000/ - choose `hello_dashboard` with metric `hello_success`