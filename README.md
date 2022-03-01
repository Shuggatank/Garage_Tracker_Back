<h1 align="center">Garage_Tracker_API</h1>


<h3 align="center"> Tracking the history of your car maintenance</h3>

<p align="center"><img alt="Garage" height="80%" width="80%" src="img/MVP_0195.jpg"/> </p> 


## Table of Contents
* [User Stories](#User-Stories)
* [Tools Used](#Tools-Used)
* [Installation](#Installation)
* [POM Dependencies](#POM-Dependencies)
* [Entity Relationship Diagram (ERD)](#Entity-Relationship-Diagram)
* [Model View Controller System Design](#Model-View-Controller-System-Design)
* [API Endpoints](#Endpoints)
* [Database Layout](#Database-Layout)
* [Sample of Output](#Sample-of-Output)
* [Project File Structure](#Project-Structure)
* [Project Class Diagram](#Class-Diagram)

This project is just one part of a two part project. This backend API holds the data for the garage.
Data can be written to and read from the database from the front end component of the project. 
The user would be able to store their vehicle data such as make, model, year, as well as VIN. 
Each vehicle can contain records of work done on the vehicle such as oil changes, gas fill ups, 
and any other maintenance records. 

### The Approach
I first started with the ERD to flush out how the API would be structured. 
This made the subsequent work much easier because the planning was done ahead of touching any code.
The first thing I did was set up the folder structure ahead of time because I knew what I wanted and how I wanted to structure the project.
I started creating the models first since they are the basis of the other components. For each model I first created the repository
then created the service, then the controller. I found this make more sense because 
the controller relies on the service which relies on the repository which relies on the model. 




### Unsolved Problems or Major Hurdles
One issue I ran into was a Cross-Origin Resource Sharing (CORS) error. 
While working fine with getting data with Postman, when I connected my front-end application to the back-end api I ran into the CORS issue. 
After a bit of research I found a solution, which was to include `@CrossOrigin(origins = {"https://garagetracker.herokuapp.com", "http://localhost:4200"})` 
which seems to have solved the issue. At first, I had only the localhost but when deployed I ran into the same issue, so I added the address of the deployed site as well.

### Todo
- [ ] Add user role to save data per user.
- [ ] Add login and signup
- [ ] Add security
- [ ] Add more integration and unit testing

## User Stories
- [x] As a user I would like to add vehicles
- [x] As a user I would like to log my oil changes
- [x] As a user I would like to log my gas fills
- [x] As a user I would like to log any maintenance done
- [x] As a user I would each record to be associated with a vehicle
- [x] As a user I would like a way to see all the records of a particular type
- [ ] As a user I would like to create an account

## Tools Used

|                                                                              |               |
|:----------------------------------------------------------------------------:|:-------------:|
|   <img alt="Spring-Boot logo" height="50" src="img/spring-boot-logo.png"/>   |  Spring Boot  |
| <img alt="IntelliJ-idea logo" height="50" src="img/intellij-idea-logo.png"/> | IntelliJ IDEA |
|          <img alt="Java logo" height="50" src="img/java-logo.png"/>          |     Java      |
|        <img alt="Maven logo" height="35" src="img/apache-maven.png"/>        | Apache Maven  |
|      <img alt="PostgreSQL" height="65" src="img/postgresql-logo.png"/>       |  PostgreSQL   |
|         <img alt="Postman" height="50" src="img/postman-logo.png"/>          |    Postman    |
|        <img alt="testcontainers" height="50" src="img/heroku2.png"/>         |    Heroku     |
|       <img alt="Lucid charts" height="33" src="img/lucidcharts.png"/>        |  Lucidcharts  |


## Installation
- Install [PostgreSQL](https://www.postgresql.org/download/). Using the localhost with port 5432, create a database named garage.
- Update application-dev.properties with your username and password. 
- Update datasource to match your local database
- To test endpoints use [Postman](https://www.postman.com/). 




## POM Dependencies
```xml
<dependencies>
        <dependency>
            <groupId>org.springframework.session</groupId>
            <artifactId>spring-session-core</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>2.6.3</version>
        </dependency>
    </dependencies>
```
## Entity Relationship Diagram


### Initial ERD
![Initial ERD](img/ERD.png)
### Project ERD
![Project ERD](img/Final_ERD.png)

## Model View Controller System Design

## Endpoints

## Database Layout

## Sample of Output


## Project Structure