# EventTrackerProject

## Description
This application allows a user to track information related to a job application. Including company details and contact information. 

## Technologies Used
Spring Tool Suite, Spring Data JPA/REST, MySQL Workbench, Gradle, Java.
JavaScript. Angular

## Lessons Learned

This project was my first using Spring REST and the JPA Repository Interface.
Along with that came the implementation of JSON and testing through Postman.
I continued learning about CRUD operations and the relationship between parent/child dependencies. Most of my trouble shooting involved Delete operations when child dependencies existed. 
I really enjoy the building of more complicated  controller operations and ServiceImpl methods.

This was my first implementation of JavaScript in a project. Using Event Listeners on delete, update, and add buttons to communicate to the Java Controllers and perform CRUD operations on the Company entity. I also used JavaScript to dynamically  build a company display table. I would like to improve my function syntax to better use a single function for multiple uses. 

I made the addition of an Angular front end using typescript and Visual Studio Code. I made use of Components to hold my function logic and work with the Service through the subscribe method. Models, which held my entity. Pipes, which I used to manipulate data to calculate the active count. And, a Service which I used to communicate to the back end through HttpClient.   

## Paths

| HTTP Verb | URI                  | Request Body          | Response Body |
|-----------|----------------------|-----------------------|---------------|
| GET | `/api/contacts`      | list all contacts               | 
| GET | `/api/contact/1`   |    find single contact                | 
| Get | `/api/contact/search/name/M`| search contacts by last name                    | 
| Get | `/api/contact/search/company/1`   | search by company                 |
| POST| `/api/add/contact`   |   create contact                  | 
| PUT | `/api/update/contact/2`  | update contact |
| DELETE| `/api/delete/contact/2`| delete contact|
|GET|`/api/questions`| view all questions|
|GET|`api/questions/category/1`| view all questions by category|
|GET|`/api/company/1/questions`| view all questions asked by company|
|POST|`/api/add/question`| create question|
|DELETE|`/api/delete/question/1`| delete question| 
|GET|`/api/offers`| view all offers|
|GET|`/api/offer/company/1`| view offer by company|
|POST|`/api/company/2/offer`| create offer for company|
|PUT|`/api/update/offer/1`| update offer|
|DELETE|`api/delete/offer/1`| delete offer|
|GET|`/api/companies`| view all companies|
|GET|`/api/company/search/active/true`| view all active companies|
|GET|`/api/company/1`| view company by id|
|POST|`/api/company`| create company|
|PUT|`/api/company`| update company
|DELETE|`/api/company/1`| delete company