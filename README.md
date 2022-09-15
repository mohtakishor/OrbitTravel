# OrbitTravel Automation

#Project DescriptionThis project is based upon the web application of Orbitz where a user can book his traveling itnerary from E2E,whether its flights or stays or renting cars.

#Tech Stacks

The following project is related to testing Flight product scenarios and validating Home Page and Flight serach page.
Test cases followed for assertion.
1-In Home Page i am validating 2 products which are Stays and Flight are their are not as its really important critical test cases
2-In Flight search Query i am validating the signIn button is being clickable or not then if the user is new its able to get a text as "Create a new account".
3-In Flight search Query i am going to destination as the destination should be as per user query.
4-In Flight search Query i am validating whether he can change the date or not by clicking on flexible date and then also validating whether the calendar is being displayed or not.

Prerequisites for running the following test cases are:- 1-Java version: 1.8 2-Maven:-3.6.0 3-TestNG For Automation purposes, I have used Selenium version 4.1.3 and for reporting purposes, I have used an allure report,also this script takes screen shot of the last page and store it in the directory.

#FrameWork description This framework consists of several implementations which are TestNG, POM, and Builders Design pattern.We have used TestNG to implement the runner for the tests, POM as a structure where we have implemented while having different classes for each page and Steps to be considered to keep the project more understandable and easy to modify, and then we have builder pattern which helps us in giving each method or step to be called as in a method chaining format.

#To run the test 1-you can directly from TestNG XML or from test\BasicTestCases 2-You can also run from the maven command :- mvn clean install
