#Usamos el patron builder para optimizar la imagen
#Usamos una vefrsion de java alpine que es mas liviana
#Le damos a esta construccion un nombre, en este caso es el builder
#FROM openjdk:17-jdk-alpine as builder

ARG MSVC_NAME=demo

FROM openjdk:jdk-buster as builder

ARG MSVC_NAME
WORKDIR /app/$MSVC_NAME

COPY ./pom.xml /app
COPY ./$MSVC_NAME/.mvn ./.mvn
COPY ./$MSVC_NAME/mvnw .
COPY ./$MSVC_NAME/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./$MSVC_NAME/src ./src

RUN ./mvnw clean package -DskipTests


#FROM openjdk:17-jdk-alpine
FROM openjdk:jdk-buster
ARG MSVC_NAME

WORKDIR /app
#Creamos el directorio de los logs
RUN mkdir ./logs

#Creamos nuevamente la imagen
#docker build . -t usuarios -f ./msvc-usuarios/Dockerfile
#Vemos los logs en nuestra maquina local
# docker cp f20a:/app/logs ./logsimon
ARG TARGET_FOLDER=/app/$MSVC_NAME/target
COPY --from=builder $TARGET_FOLDER/demo-0.0.1-SNAPSHOT.jar .
#COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
#CRREAMOS una variable de ambiente PORT y asignamos un valor por defecto
#Este es el valor interno de nuestro puerto de nuestra aplicacion
#Definimos un argumentos para el puerto
#Podemos sobreescribir el puerto al crear la imagen con el arg
#docker build . -t usuarios -f ./msvc-usuarios/Dockerfile --build-arg PORT_APP=8080
#Asi no funciona porque el .env va a sobreescribir el arg
# docker run -p 8001:8080 --env-file ./msvc-usuarios/.env -d --rm --name msvc-usuarios --network spring usuarios
#Quedaria asi
# docker run -p 8001:8080  -d --rm --name msvc-usuarios --network spring usuarios
#ARG es tiempo de construccion de la imagen
#ENV es tiempo de ejecucion del contenedor

ARG PORT_APP=8080
ENV PORT $PORT_APP
#Aca usamos la variable de ambiente $PORT declarada en ENV
EXPOSE $PORT
#Creamos el nuevo contenedor usando el puerto interno 8000
# docker run -p 8001:8000 -d --rm --name msvc-usuarios --network spring usuarios
#Cambiamods el puerto interno al crear nuevamente la imagen, sobreescrivimos el valor de dockerFile del puerto y
#La agregamos de forma dinamica
# docker run -p 8001:8090 --env PORT=8090 -d --rm --name msvc-usuarios usuarios

#El ENTRYPOINT ES mas estricto. No  nos deja modificar la linea de comandos
#ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
#Lo sustituimos por este.
#SI NO SE INGRESA UN NUEVO COMANDO, ACEPTARA ESTE POR DEFECTO
#Este comando reemplazara al CMD
#docker run -p 8001:8001 --rm -it usuarios /bin/sh
#Esto solo se ejecuta en el contenedor
CMD sleep 20 && java -jar demo-0.0.1-SNAPSHOT.jar
#CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
#docker build -t usuarios . -f .\msvc-usuarios\Dockerfile

#El comportamiento por defecto de docker start nombreDelContenedor es detached(Modo separado del; terminal que es el predeterminado) que corre en segundo plano, por lo tanto deja liberada el terminal para realizar otras
#tareas
#Cuando creas un contenedor con una imagen pero sin attachment a la consola que es el que viene por defect'
#docker run -d -p 8081:8001 usuarios
#Esa instruccion levanta el contenedor con la imagen pero en background por la d'
#para ver un contendor attached a la consola para ver su ejecucion, solo ejecutamos esta instruccipon
#docker attach nombreDelContendor
#Parar un comntenedor : docker stop idContenedordocxker
#docker logs idContenedor, muestra el log hasta el momento del contenedor
#docker logs -f idContenedor, queda attachado por console el log
#docker start -a nombreDelContenedor, atachamos la salida del contenedor al terminal
#Para deliminar contenedores separados popr espacio
#docker rm inspiring_taussig jovial_jang
#Remueve todos los contenedores:  docker container prune
#Para borrar imagenes: docker rmi nomImagen nomImgen
#docker image --help
#Con docker image prune, eliminq todas las imagenes que no tengan contenedores
#Copiar un archivo de mi pc directamente al contenedor
# docker cp ./Login.java 24097ac09cfb:/app/Login.java
#Se puede copoiar un archivo del contenedor al  pc
#docker cp 24097ac09cfb:/app/Login.java ./simonLogin.java
#Pasa toda la carpeta del contenedor docker a una carpeta de mi maquina local llamada tedstsimon que si no existe
#entonces la crea
#docker cp 24097ac09cfb:/app ./tedstsimon
#Para inspeccionar una imagen
#docker image inspect usuarios
#Para inspeccionar container
# docker inspect f20a
#Colocar nombre al contenedor
#docker run -p 8001:8001 --rm -d --name nombreDeMiContenedor usuarios:latest
#Setear variables internas de dockerFile como PORT de manera dinamica en la instruccion al generra un contenedor
#Con cierta imgen
#docker run -p 8001:8090 -e PORT=8090 -d --rm --name msvc-usuarios --network spring usuarios
#Creamos la imagen con la nueva variable ARG para crear la imagen. Solo para crear imagen se usa ARGH
#docker build . -t usuarios -f ./msvc-usuarios/Dockerfile
#Correidno el demo
#docker build . -t demo -f ./demo/Dockerfile 
#docker build . -t itemsng -f ./angular/Dockerfile
 
#Levantamos el contenedor
#docker run -p 8080:8080 -d --rm --name democtn --network spring demo:latest
#docker run -p 8080:8080  --name democtn --network spring demo:latest

