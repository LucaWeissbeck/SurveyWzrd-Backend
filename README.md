# Survey Wzrds Repo for the Backend

## Backend

Technology: Spring Boot (2.4.3)

Developed by: Kathrin and Daniel

Tested by: Mauritz, Kathrin and Daniel

## Local testing instructions
Java 15 required to run the program.
You can run the application using the docker image (as descirbed below). Before building the docker image
the jar file needs to be built.

All the commands should be executed from the root folder of this project.
You first have to potentially create the **gradlew file executable** with:
```
chmod +x gradlew
```
**Run project with:**
````
./gradlew bootRun
````

**Build executable Jar file with:**
```
./gradlew bootJar
```

**Build the Docker Image:**

```
docker build -t surveywzrd .
```

**Run the Docker Image**
```
docker run -p 8080:8080 surveywzrd
```

Access on http://localhost:8080
## Database
You can either fill in new Database information in the application.properties file or use the one we provide you with the source code.
In case you want to create a new one, make sure the database exists and you can connect to it. On the first run, Hibernate will generate all tables for you.
