# Time Tracker
A personal time tracking application.

## Purpose
- To allow an individual to track the time spent working on various aspects of a personal or professional project.
- Be able to persist and review previous time entries.
- Be able to break down time entries to determine time spent per day, on a particular project, etc.

## Technologies

### Back-End
- Java 8
- Spring Boot 1.5
- Spring Data, Hibernate JPA for persistence.
- Embeddable DB such as HSQLDB as the database.

### Front End
- React
- Redux
- Typescript

## Modules

### tracker-data
- Defines the entities we'll persist as POJOs with JPA/Hibernate annotations.

### tracker-persistence
- Persistence library with data source setup, spring data repositories, etc.

### tracker-api
- API for managing (CRUD) time entries.

### tracker-ui
- Application UI.