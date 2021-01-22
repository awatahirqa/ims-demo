Coverage: 57.1%


# Inventory Management System Application by Waleed Tahir


This is an  **Inventory Management System Application** that was build using Java and can be run with a Command-Line Interface. The inventory management system connects to a database and allows the user to easily **Create,Read,Update and Delete Customers,Items and Orders**. This application can also be used too calculate the cost of an order. 

## Table of contents
* [Prerequisite](#Prerequisite)
* [Installing](#Installing)
* [Testing](#Testing)
* [Creating JAR file](#Creating_JAR_file)
* [Deployment](#Deployment)
* [Built With](#Built_With)
* [Versioning](#Versioning)
* [Authors](#Authors)
* [License](#License)
* [Acknowledgments](#Acknowledgments)





## Getting Started

The following instructions will get you allow you to access a copy of the project up as well as running it on your local machine for development and testing purposes. See deployment for info on how to deploy the project on a live system.


## Prerequisite
* [Git Bash](https://git-scm.com/downloads)
* [Java JRE 14.1](https://www.eclipse.org/downloads/)
* [Eclipse or other IDE](https://www.eclipse.org/downloads/)
* [MySQL](https://www.mysql.com/downloads/)
* [Maven](http://maven.apache.org/download.cgi)
* [GCP](http://maven.apache.org/download.cgi)



### Installing

*1. You will need to clone down the repo, here is a link to the repo
*2. Git Bash in the destination folder you'd like to clone to.
*3.Clone the repo to your local system using command Git clone and the Repository URL
*4.Launch the project in your IDE of choice 
*5.set up JDBCconnection url so that it connects to your database

## Testing

All testing of this program was done using unit tests. 
JUnit and Mockito were used to write the tests.


#### Creating JAR file:

1. Right Click on the folder of the directory containing the repository
2. Select Git Bash
3. Write the following

```
mvn clean package
```

4. This will now run all of teh applications testing, ensuring it all passes, you'll then get JAR file produced in the project target folder.

## Deployment

To deploy this software to a cloud database such as Google Cloud Platform (GCP) you will need to do the following;

**Open the project**

1. In the main folder 'src/main/java' Open > Ims.java
2. Scroll down until you see init("jdbc:mysql:// declaring your connection point
3. change the connection point to your desired Database location

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

Version Control System: Git
Source Code Management: GitHub
Database Management System: MySQL Server 5.7 (local or GCP instance)

[Maven Versioning](http://maven.apache.org/download.cgi)  incremental, Minor & Major was used to update the version.


## Authors

* **Chris Perrins** - *Initial work* 

* **Waleed Tahir** - *From intitial to completion* 

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* I would like to say a massive thank you to ;
*Nicholas Johnson - trainer
*Aswene Sivaraj - trainer
*Vinesh Ghela - trainer

