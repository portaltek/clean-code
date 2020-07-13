FROM openjdk:8-jdk-alpine

ENV MAIN_CLASS=portaltek.cleancode.api.web.CleanCodeApplication
ENV APP_DEPENDENCY=build/dependency


RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY ${APP_DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${APP_DEPENDENCY}/META-INF /app/META-INF
COPY ${APP_DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT java -cp app:app/lib/* ${MAIN_CLASS}
