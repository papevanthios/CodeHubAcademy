# TravelCompany Project by CodeHub
A Java project for Individual Application Exercise Specification Document February 2022.

---
### Description: 
The TravelCompany program implements the below:
* User Interaction - Simple form of reading and writing at the console.
* Data Modeling - Implementation of necessary domain classes for the core modeling of the system.
* Ordering and discount policy - Based on the system’s requirements, customers are categorized into individual and business. They can buy tickets by paying either with cash or by using a credit card.
* Exception Handling - Design custom exceptions:
  * when creating a customer: the email of the customer is <whatever>@travelcompany.com.
  * when issuing a ticket: 
    * the requested itinerary does not exist.
    * the given customer code does not exist.
  * when creating an itinerary: the airport code does not exist.
* Reporting - Based on the purchases of each customer, the system must support the following reporting:
  * List of the total number and cost of tickets for all customers.
  * List of the total offered itineraries per destination and departure.
  * List of the customers who purchased the most tickets and the number of purchases.
  * List of the customers who have not purchased any tickets.

---
### Requirements
TravelCompany requires the following to run:
* JDK 17 or newer.

---
### Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.



