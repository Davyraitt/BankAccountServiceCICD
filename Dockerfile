FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#This Dockerfile is very simple,
#but it is all you need to run a Spring Boot app with no frills:
#just Java and a JAR file.
#The build creates a spring user and a spring group to run the application.
#It is then copied (by the COPY command) the project JAR file into the container as app.jar,
#which is run in the ENTRYPOINT.
#The array form of the Dockerfile ENTRYPOINT is used so that there is no shell wrapping the
#Java process. The Topical Guide on Docker goes into this topic in more detail.

# RUN FROM ROOT FOLDER:
#WE CAN BUILD WITH: docker build -t springio/gs-spring-boot-docker .
#WE CAN RUN WITH: docker run -p 8080:8080 springio/gs-spring-boot-docker
