FROM adoptopenjdk/openjdk11
ARG JAR_FILE
VOLUME /tmp
RUN mkdir -p /opt/envopts-springboot-example
COPY build/libs/${JAR_FILE} /opt/envopts-springboot-example/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/envopts-springboot-example/app.jar"]
