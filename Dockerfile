FROM adoptopenjdk:11-jdk-hotspot AS build

WORKDIR /app
COPY . .
RUN apt-get update \
    && apt-get install --yes \
        unzip

RUN ./gradlew distZip
RUN unzip build/distributions/dreamteam-1.0-SNAPSHOT.zip

FROM adoptopenjdk:11-jdk-hotspot AS execute

WORKDIR /app

# Copy build directory containing build artifacts
COPY --from=build /app/dreamteam-1.0-SNAPSHOT .

RUN pwd \
    && ls -R \
    && ls -l ./bin/dreamteam

# Code file to execute when the docker container starts up (`entrypoint.sh`)
ENTRYPOINT ["./bin/dreamteam"]