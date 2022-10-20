# UI Automation Challenge

## Prerequisites

- [JDK 11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html) (Environment variable)
- [Maven](https://maven.apache.org/download.cgi) (Environment variable)
- [Allure](https://docs.qameta.io/allure-report/#_installing_a_commandline) (Environment variable)
- IDE (ex. [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows))

## Scenarios to test

- **Scenario**: Successful Login  
  **GIVEN** the user wants to log in  
  **WHEN** the user enters the credentials  
  **THEN** the user should be able to log in


- **Scenario**: Failed Login  
  **GIVEN** the user wants to log in  
  **WHEN** the user submits invalid credentials  
  **THEN** the user should see a red error message  
  **AND** the user should see two more error messages


- **Scenario**: Successful Search  
  **GIVEN** the user wants to search for a movie  
  **WHEN** the user enters the title ‘Fight Club’  
  **THEN** the user should see the movie as the first result


- **Scenario**: Verify Movie Genre Filter  
  **Given** the user wants to see the top-rated movies  
  **AND** the user wants to filter for ‘action’ movies  
  **WHEN** the user applies the ‘action’ filter  
  **AND** the user selects any movie  
  **THEN** the user should see the genre of the movie includes ‘action’


- **Scenario**: Validate Acting Timeline  
  **Given** the user selects a movie with actors  
  **AND** the user selects an actor from the top billed cast  
  **WHEN** the user checks the actor’s acting timeline  
  **THEN** the title of the movie should be in the timeline

## Run project
```
mvn clean verify
```

## Open allure report
```
allure serve target/allure-results
```