# Player DB Microservice
Implemented using Spring Boot framework, H2 as temporary Db and Gradle is a build system.

## Main point of the solution

CSV file is upladed into H2 via CSV uploader.
REST api is documented via Swagger http://localhost:8080/swagger-ui/index.html

## Instruction how to build and run it
you can clone repository on your local machine, make sure you have Java 17,Gradle and Docker installed.
Run next command
```shell
docker build -t player-api-app .
```
Now you can start your docker container locally.
```shell
docker run -p 8080:8080 player-api-app
```
## Notes
few notes about the solution we have. i have a limited time to work on it, i focused on main requirements.
This is more like POC quality solution.
i think that at least next point have to be improved
1) Error handling and logging to be added
2) H2 db can be replaced with PGSQL, DTO mapping layer added.
3) Security to be added
4) More tests added to verify data model



