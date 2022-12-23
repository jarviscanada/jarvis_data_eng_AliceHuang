# Introduction
This application is a practice project before jumping into developing a trading platform. It is a spring framework Java app that used to post, show, or delete twit on Twitter through command line.

# Quick Start
- General Usage
```bash
- TwitterApp post|show|delete [options]
```
- Post
```bash
- TwitterApp post "tweet_text" "latitude:longitude"
```
- Show
```bash
- TwitterApp show "tweet_id" "field1,fields2"
```

- Delete
```bash
- TwitterApp delete "id1,id2,.."
```

# Design
## UML diagram
![TwitterCLISpringBoot](./TwitterCLISpringBoot.png)
## TwitterCLIApp
As a component that has dependency on Controller, this app run from this class.
## Twitter Controller
A Controller has dependency on service, interacts and parsers user input (CLI args in this APP).
## Service
A Service  handles business logic and calls DAO layer in order to interact with the underlying storage/service which is the Twitter REST API in this app.
## TwitterDAO
A DAO has dependency on HttpHelper, as HttpHelper help create OATH connection to Twitter, the DAO layer create/show/delete tweet(s).
## Models
Models are implemented with POJOs which is a class with private member variables and public getter and setters.In this application, we use Data Transfer Model (or DTO) and Data access model (or domain model).
## Spring
In this app we used SpringFramework to manage dependencies. `TwitterCLIApp` depends on `TwitterController` depends on `TwitterService`  depends on `TwitterDao` depends on `TwitterHttpHelper`, we crate a IOC container which is the `TwitterCLIComponentScan`, to configure and connect all the beams together. We would also define which one is the Controller, Service, Repository and Components as well.

# Test
We use Junit to test TwitterController, TwitterDao and TwitterService to check if those classes can run functionally, then we use MockitoJUnit to check if it works under mocking actual enviroment.

## Deployment (In-testing)
Dockerize the app.

# Improvements
- Add UPDATE methods for this app in order to fulfill CRUD manipulations.
- we could add user inputs to help user understand the options efficiently, for example, the user would only need to input post, show and delete, we will prompt out the options they need to enter.