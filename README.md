<h1 align="center"> Persistance Java </h1> <br>

## Table of Contents

- [Introduction](#introduction)
- [This&nbsp;respository](#thisrepository)
- [Dependencies](#dependencies)
- [Run&nbsp;Code](#runcode)
- [Platzi&nbsp;Course](#platzicourse)
- [Notes](#notes)

## Introduction

Data persistence can occur in two ways:
- In RAM memory, it is volatile information that is lost when the application ends
- On hard disk, they are files and databases that store information until it is eliminated 

#### CRUD 
It is an acronym for CREATE, READ, UPDATE and DELETE which are basic functions of persistent storage.

#### API 
It is an acronym for Application Programing Interface. For offline applications, API provides librarys or way to communciate to some its features. In the online case, the applications uses API in order to obtain access to resources, for that, the API use the HTTP (Hypertext Transfer Protocol) protocol, which is using for web browsing. For APIs that use HTTP usually implement four methods:

- GET. Method is used to retrieve data.
- POST. Method sends data in order to create a new resource. 
- PUT. Method is most often used to update an existing resource.
- DELETE. Method is used to delete a resource.


## This&nbsp;repository
This repository contains two projects, first one is desktop application about messages, which are stored in a MySQL database. This project implements a CRUD interface and it can does:
- Creates a new message
- Lists the messages
- Deletes the messages
- Edits a message


Secod project is a desktop application that consumes a Cat API (https://thecatapi.com/), this project shows images of random cats and allows to save your favorite cat images. 

## Dependencies
- Install JDK 16
- Install Apache NetBeans or another IDE.
- Install MySQL
- Add mysql-connector-java-8.0.25.jar


## Run&nbsp;Code
You have put your apikey in the FavoriteCats class and run the project using NetBeans.


## Platzi&nbsp;Course

Check out [Platzi's Persistence Java course](https://platzi.com/clases/java-persistencia/).


## Notes

Most commits correspond to sections of the course in which the project code was changed.
