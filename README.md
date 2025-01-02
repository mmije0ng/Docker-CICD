![docker drawio (3)](https://github.com/user-attachments/assets/c73db315-d938-406f-b9c6-6d7f459c9bee)
&nbsp;

docker-compose.yml 파일로 실행되는 컨테이너는 총 3개
- Spring Boot 컨테이너 1 (spring-app-1)
- Spring Boot 컨테이너 2 (spring-app-2)
- Nginx 컨테이너 (nginx-container)

컨테이너 간 통신은 app-network를 통해 이루어짐

+) nginx.conf 파일은 Docker Compose 실행 전에 호스트 파일 시스템(docker-compose.yml이 존재하는 디렉터리)에 미리 존재해야 한다.
