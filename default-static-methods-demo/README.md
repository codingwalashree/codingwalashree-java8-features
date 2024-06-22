# Java8 Features - Default and Static Methods
This is a maven based project to demonstrate different scenarios of 
Default and Static Methods in Java 8.

### Pre-requisites
- Appetite for learning :) -- _Good start!! You already have it!!!_
- Java 8 or above -- [Download from here](https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html)
- Maven 3.9.5 -- [Download from here](https://maven.apache.org/download.cgi)

### Generate empty maven project from scratch

- Make sure you are running below maven command on EMPTY directory to generate project skeleton
- If you are using Windows Powershell use command:

```sh
mvn archetype:generate 
    "-DarchetypeGroupId=org.apache.maven.archetypes" 
    "-DarchetypeArtifactId=maven-archetype-quickstart" 
    "-DgroupId=codingvoding.org"  
    "-DartifactId=java8-features-demo" 
    -B
```

- On Linux or Mac:
```sh
mvn archetype:generate
  -DarchetypeGroupId=org.apache.maven.archetypes
  -DarchetypeArtifactId=maven-archetype-quickstart
  -DgroupId=codingvoding.org
  -DartifactId=java8-features-demo
  -B
```