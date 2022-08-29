# Personal Site 

This repository is the code for my personal website.
It is built using the Vaadin framework with Spring Boot with java.

## Continuous Integration Checks
![https://github.com/H1ppx/PersonalSite/actions/workflows/maven.yml](https://github.com/H1ppx/PersonalSite/actions/workflows/maven.yml/badge.svg) ![https://github.com/H1ppx/PersonalSite/actions/workflows/codeql-analysis.yml](https://github.com/H1ppx/PersonalSite/actions/workflows/codeql-analysis.yml/badge.svg) [![CircleCI](https://dl.circleci.com/status-badge/img/gh/H1ppx/PersonalSite/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/H1ppx/PersonalSite/tree/main)

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/personalsite-1.0-SNAPSHOT.jar`
