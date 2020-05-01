# starter
## Description: SPRING BOOT STARTER TEMPLATE..!!

<!-- Project configuration -->
## Java SpringBoot using Gradle
### Versions
- Java: jdk-11.0.7
- org.springframework.boot: 2.2.6.RELEASE
- io.spring.dependency-management: 1.0.9.RELEASE
- JUnit: 5

<!-- Developer guide -->
## Run application locally
- Extract **_application.yml_** file
    - This is required to run the app locally
    - This file is password protected
    - Do you need **_password_**? [Contact developer](mailto:kcshettar@gmail.com)
```
$ sh extract_application-yml.sh 
```
- Run the application
```
$ ./gradlew bootRun
```
- Run the tests
```
$ ./gradlew test
```
- Clean, assemble & test
```
$ ./gradlew clean build
```

## Database
### In memory h2 database
```
http://localhost:{{server.port}}/h2-console
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: <BLANK>
```

## Documentation
- Hello World..