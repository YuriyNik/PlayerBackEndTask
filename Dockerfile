FROM gradle:7.6.4-jdk17 as builder

WORKDIR /app
COPY --chown=gradle:gradle . .

RUN gradle build --no-daemon --refresh-dependencies

FROM openjdk:17

WORKDIR /app

COPY --from=builder /app/build/libs/PlayerBackEndTask-0.0.1-SNAPSHOT.jar /app/playerApp-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "playerApp-0.0.1-SNAPSHOT.jar"]