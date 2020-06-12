# airline-ticketing-service
Simple airline ticketing service project that includes ticket purchasing, price adjustment, defining airfields, flights, flight routes and flight companies. 

# How To Build and Run

### What you'll need  

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org)
- An internet connection :) 

## 1 - On A Docker Container

  We can build the docker image by using Spring version 2.3.0's latest feature  
`./mvnw spring-boot:build-image`  
Then run the container as such  
`docker run --tty --publish 8080:8080 ticket-service:0.0.1-SNAPSHOT`

## 2 - On your local OS
  Get a maven build  
`mvn clean install`  
Then run the project from TicketServiceApplication as your main class.  

### Project is served on port `8080` as default.

# Documentation

This project is documented with Swagger 2.Swagger url has been redirected from `/swagger-ui.html` to  `/` to make ease of use  

