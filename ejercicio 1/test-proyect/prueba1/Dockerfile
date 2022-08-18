FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/prueba1

COPY ./pom.xml /app
COPY ./prueba1/.mvn ./.mvn
COPY ./prueba1/mvnw .
COPY ./prueba1/pom.xml .

#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

RUN ./mvnw dependency:go-offline

COPY ./prueba1/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/prueba1/target/test1-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

CMD sleep 20 && java -jar test1-0.0.1-SNAPSHOT.jar

#ENTRYPOINT ["java", "-jar", "test1-0.0.1-SNAPSHOT.jar"]