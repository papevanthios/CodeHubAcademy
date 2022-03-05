# TravelCompany Project by CodeHub
A Java project for Individual Application Exercise Specification Document February 2022.

---
### Description: 
The TravelCompany program implements the below:
* User Interaction - Simple form of reading and writing at the console.
* Data Modeling - Implementation of necessary domain classes for the core modeling of the system.
* Ordering and discount policy - Based on the system’s requirements, customers are categorized into individual and business. They can buy tickets by paying either with cash or by using a credit card.
  * You need to make sure that the system distinguishes between the purchase methods and customer categories, because the following discounts will apply upon the basic price when buying a ticket:
    * Business customers get a discount of 10%.
    * Individual customers are subject to surcharge of 20% for all services.
    * There is a 10% discount when the customer pays by credit card.
    * There is no discount when the customer pays by cash. \
  * The discounts are cumulative. For example, a business customer purchasing a ticket using his/her credit card will receive a price reduction of 20% (10% as a business customer discount + 10% for paying with a credit card).
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
### Steps for the project to run.
After copying the files on your local machine. Then you only need to run the MainApplication class and the rest of 
the program will take you forth. The program will ask you for preferred actions to take, to see the complete project
and all the lists of Reporting we suggest making the chooses (first '0' -> to start, and then second '4' -> to generate
all the lists together).

---
### How it works based on methods inside BusinessCase Class:

After we run the MainApplication, we go to the class BusinessCase inside the public method of userInterface(). \
UserInterface() method display a welcome message and some actions for the user. When the user choose the action then the system will start generating
data, or it will exit. \
If the user choose to start the generating of the tickets (by choosing '0') then the system will go to the private
method startingBusiness(). \
StartingBusiness() method will generate Customers, Itineraries and Tickets based on generateCustomers() method, generatedItineraries() method and
generateTickets() method. \
GenerateCustomers() method will create the list of customers from repository package lists, and with correct exception handling
we make sure to generate by hand the customer and check for email exception and customer data missing. \
GenerateItineraries() method will create the list of itineraries from repository package lists, and with correct exception handling
we make sure to generate by hand the itinerary and check for airport code missing for departure and destination and also for itinerary data missing. \
GenerateTickets() method will get the payment amount based on the variables that is given to it. After calculating the payment amount then we will create the
tickets by handling for missing ticket data. \
After all that we display the tickets at the console for the user. \
At the end of the startingBusiness() method we ask again the user to choose an action. He can decide to generate a list or all of the or exit the program. \
When the user make a choose, his preferred list or lists will be displayed and that will end the program.
---
### Requirements
TravelCompany requires the following to run:
* JDK 17 or newer.

---
### Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

After we run the MainApplication, we go to the class BusinessCase inside the public method of userInterface(). \
UserInterface() method display a welcome message and some actions for the user. When the user choose the action then the system will start generating
data, or it will exit. \
If the user choose to start the generating of the tickets (by choosing '0') then the system will go to the private
method startingBusiness(). \
StartingBusiness() method will generate Customers, Itineraries and Tickets based on generateCustomers() method, generatedItineraries() method and
generateTickets() method. \
GenerateCustomers() method will create the list of customers from repository package lists, and with correct exception handling
we make sure to generate by hand the customer and check for email exception and customer data missing. \
GenerateItineraries() method will create the list of itineraries from repository package lists, and with correct exception handling
we make sure to generate by hand the itinerary and check for airport code missing for departure and destination and also for itinerary data missing. \
GenerateTickets() method will get the payment amount based on the variables that is given to it. After calculating the payment amount then we will create the
tickets by handling for missing ticket data. \
After all that we display the tickets at the console for the user. \
At the end of the startingBusiness() method we ask again the user to choose an action. He can decide to generate a list or all of the or exit the program. \
When the user make a choose, his preferred list or lists will be displayed and that will end the program.
---

