#FROM openjdk:8-jdk-alpine AS builder
#ARG DEPENDENCY=build/dependency
#WORKDIR $DEPENDENCY
#ARG JAR=build/libs/*.jar
#COPY "clean-code.jar" "app.jar"
#
#
#FROM openjdk:8-jre-alpine
#VOLUME /tmp
#ENV MAIN_CLASS=portaltek.cleancode.CleanCodeApp
#ENV DEPENDENCY=build/dependency
#COPY --from=builder $DEPENDENCY/BOOT-INF/lib      /app/lib
#COPY --from=builder $DEPENDENCY/META-INF          /app/META-INF
#COPY --from=builder $DEPENDENCY/BOOT-INF/classes  /app
#
#ENTRYPOINT java -cp app:app/lib/* $MAIN_CLASS


FROM openjdk:8-jdk-alpine
COPY "clean-code.jar" "app.jar"
ENTRYPOINT java -jar app.jar