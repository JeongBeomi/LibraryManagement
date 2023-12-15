FROM openjdk:17-alpine
ARG JAR_FILE=build/libs/LibraryManagement-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} LibraryManagement.jar
ENTRYPOINT ["java", "-jar", "/LibraryManagement.jar"]