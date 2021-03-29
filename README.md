Hello Candidate,

Welcome to AnyCompany Entertainment.

Here is our mostly complete system for placing orders.

The developer who created this system did not follow any specific development methodology, 
but attempted to implement some patterns. Unfortunately he has now left the company.

The system should do the following:

 * Place an order, linked to a customer
 * Retrieve a customer with their linked order(s)  
 * Load all customers and their linked orders

Please do not change any of the existing static class declarations to be non-static.

Please refactor the solution according to your own best practices.

**Please fork this repository and submit your attempt via a pull request**

Details on how to do this can be found in the [Github help pages](https://help.github.com/en/articles/creating-a-pull-request-from-a-fork)

Best regards

John
CEO




*************************
## Application technology stack
[![Maven](./anycompany/src/main/resources/images/maven.png)](https://http://maven.apache.org/guides/)
[![Springboot](./anycompany/src/main/resources/images/spring-boot.jpg)](https://spring.io/guides)
[![H2](./anycompany/src/main/resources/images/h2-logo-2.png)](http://h2database.com/html/quickstart.html)
[![Swagger](./anycompany/src/main/resources/images/swagger.png)](https://swagger.io/docs/)
[![Java](./anycompany/src/main/resources/images/java8.jpg)](https://docs.oracle.com/en/java/javase/08/)


This is a service to enable customers to place orders and map orders for each customer. Functionality available is to 
pull all the orders per customer.

## Example of the customer orders retrieved from the service

To interact with the application using Swagger UI interface, you can use this 
URL: http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
 
To view H2 Database you can any database navigation tool or the following 
URL: http://localhost:8080/h2-console

<strong>Incoming Request</strong>
```js 
curl -X GET "http://localhost:8080/api/customer/v1/findAllCustomersOrders" -H  "accept: */*"
```
<strong>Outgoing Response</strong>
```json5

[
  {
    "name": "Wanted",
    "surname": "Lepota",
    "orders": [
      {
        "amount": 1500,
        "vat": 15
      }
    ]
  }
]

```
## Configuration profiles

* application.properties    (local development configuration)

```
## How to run the project using maven on local environment

```shell
mvn spring-boot:run
```
## Building and running the Spring Boot application on local environment

To build the executable jar you can execute the following command:

```shell
mvn clean package
```
The executable jar is located in the target/anycompany-1.0.jar directory and you can run it by executing the following command:

```shell
java -jar target/anycompany-1.0.jar
```
________________________________________________________________________________
Maintainers: <br>
* [@WantedLepota](https://github.com/MrWanted/TechTestJava)

Contributors: <br>
* https://github.com/MrWanted/TechTestJava/graphs/contributors



