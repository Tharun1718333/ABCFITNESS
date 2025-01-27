Hi Team at ABC Fitness , here is the info on my approach to the Project (Pictures are not loaded please see the doc in the project for more info) 
( I have included how to setup at the end of the doc)
I have decided to use the spring boot framework in java as there is a time constraint for the project
For the DB part , I have used JSON file with import jackson.databind library act as a temporary DB


I started with the reading the requirements and designing the DB , I have settled on creating three tables 
One for classes, one for Members, and one for Bookings 
here are the table structures for member class and booking  

   
Once I have created these, I have made dto’s for class and booking for the controller to expect while inserting data
  
made similar dto’s for search query and search result for the search bookings api
After this I have started using the available spring annotations to make the end points in controller and service and repository files 

After I made the end points , I have added a base repository that other repositories can use to 
handle the data injection and extraction from JSON files (I have made this generic so that It can be used by other people as well)

Project setup :- 
Follow this guide and setup a basic spring project as described in this documentation (https://spring.io/guides/gs/spring-boot)
After installing the dependencies clone this project to make sure that all the dependencies are installed correctly (https://github.com/spring-guides/gs-spring-boot)
Once properly setup this is the command line I get When I press the run using debugger extenstion in VS Code 
 
I have changed the above cloned project to finish up my project so once the above project is running correctly , you can unzip and run my project as well

All my changes are in this folder :- Path_where_you_extracted\ABCFitness\gs-spring-boot\initial\src\main\java\com\example\springboot
you can find the following folders :- models repositories , controllers , service files 
you can also find the DB (JSON files) at :- Path_where_you_ extracted \ABCFitness\gs-spring-boot\DatabaseFiles 

Attaching POSTMAN screen shots for further validation if chose not to setup :-

Add classes :-
 
Add booking api:-
 
Search booking api:-
 
