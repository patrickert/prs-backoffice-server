FROM gradle as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/backoffice-1.jar .
CMD ["java", "-jar", "backoffice-1.jar"]