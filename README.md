Coverage: 58%
Inventory Management System

The overall objective of the project is the following: 

To create a functional Inventory Managment service application, using supporting tools, methodologies, and technologies, that encapsulates all fundamental modules covered during training.

The project document folder contains my...

Getting Started
The following instructions will get you allow you to access a copy of the project up as well as running it on your local machine for development and testing purposes. See deployment for info on how to deploy the project on a live system.

Step one fork and clone this repository
Step two Launch the project in your IDE of choice 
Step three set up JDBCconnection url so that it connects to your database
Prerequisites
The things you need to install for the software and how to install them
* Git Bash
* Java JRE
* Eclipse or other IDE
* Maven 

Installing
A step by step series of examples that tell you how to get a development env running

Say what the step will be

Give the example
And repeat

until finished
End with an example of getting some data out of the system or using it for a little demo

Running the tests
Explain how to run the automated tests for this system. Break down into which tests and what they do

Unit Tests
Unit testing tests individual parts of the program to check they are correct

Each of the classes have its own respective partner in the src/test/java folder  
If you wish to run the tests:
*Right click on the class in the test folder -> *Then 'run as'->*Select 'JUnit test'  
Integration Tests
Explain what these tests test, why and how to run them

Give an example
And coding style tests
Here we have SonarQube, this tests the viability of our whole source code.
It gives us a break down of 'code smells', 'vunerability', 'Bugs' and 'Security Hotspots'.

Give an example
Deployment
Once the repo has been forked/cloned,

open a CLI in the folder where the project is located
Run the mvn clean
This has removed the target folder, now you want to run mvn package to create the jar file
After this you can see the targt folder is back run cd target
In order to run the program java -jar sam-ims-0.0.1-jar-with-dependencies.jar tab will also autocomplete
Built With
Maven - Dependency Management
Versioning
We use SemVer for versioning.

Authors
Chris Perrins - Initial work - christophperrins
Waleed Tahir 
License
This project is licensed under the MIT license - see the LICENSE.md file for details

For help in Choosing a license

Acknowledgments
Hat tip to anyone whose code was used
Inspiration
etc
