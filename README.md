# Survey Wzrds Repo for the Backend

## Backend

Technology: Spring Boot (2.4.3)

Developed by: Kathrin and Daniel

Tested by: Mauritz

## Local testing instructions
Java 15 required or Docker image in the attached Dockerfile should be used.

All the commands should be executed from the root folder of this project.
You first have to potentially make the gradlew file executable with:
```
chmod +x gradlew
```
Run project with:
````
./gradlew bootRun
````

Build executable Jar file with:
```
./gradlew bootJar
```

Then, you can also build and run the Docker image:

```
docker build -t surveywzrd .
```
```
docker run -p8080:8080 surveywzrd
```

You can either fill in new Database information in the application.properties file or use the one we provide you with the source code.
In case you want to create a new one, make sure the database exists and you can connect to it. On the first run, Hibernate will completely generate all tables for you.
