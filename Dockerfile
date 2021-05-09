FROM openjdk:15
COPY build/libs/surveywzrd-0.0.1-SNAPSHOT.jar /opt/

CMD ["java", "-jar","/opt/surveywzrd-0.0.1-SNAPSHOT.jar"]
