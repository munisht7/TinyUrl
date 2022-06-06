# Tiny Url Project

## Pre-requisites for Setup Configuration
The following components are required to get started with automation:

* Install Java(JDK)
* Install IntelliJ/Eclipse
* Install Maven

## Getting Started

* Copy the repository into your local machine using the github url -> 
* Checkout master branch for the latest changes.

## Built With
* Maven - Dependency management
* Junit - Junit framework


## CI CD integration using Jenkins and Dockers
* Run the Docker on your local.
* Use the command docker-compose up to get the jenkins run on localhost :8080.
* Container start running with the name my-jenkins-3.
* Pipeline TinyUrl created on jenkins and it runs with the pipeline using Jenkinsfile in the project.
* Pipeline runs in two stages : compile and test.
* For Deployment stage refer to the comment section in Jenkinsfile

## Run tests locally
* Right click one of the feature files at src/test/java/com.demo/TinyUrlProcessingTests and src/test/java/com.demo/TinyUrlStatsProcessingTests
* Select "Run" or "Debug" to start the test.

## Run tests using terminal
* Execute the test cases through terminal using maven by using the following command : mvn test

## Referred to the following links for the project
* Maven Download : https://maven.apache.org/download.cgi
* Maven Documentation : https://maven.apache.org/guides/