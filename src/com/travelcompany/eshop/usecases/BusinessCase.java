package com.travelcompany.eshop.usecases;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;
import com.travelcompany.eshop.repository.*;

import java.math.BigDecimal;
import java.util.*;

public class BusinessCase {
    public static final Scanner scanner = new Scanner(System.in);

    public static void changeAddress() {

        int userChoose = Integer.MIN_VALUE;
        do {
            System.out.println("\tGive customer ID from 1-9.");
            System.out.println("\tPress -1: To exit.");
            try {
                userChoose = scanner.nextInt();
            }
            catch (InputMismatchException ex) {
                String badInput = scanner.next();
                System.out.println("Bad input: '" + badInput + "' Please try again.");
                System.out.println();
                continue;
            }
        } while (userChoose != 1 && userChoose != 2 && userChoose != 3 && userChoose != 4 && userChoose != 5 &&
                userChoose != 6 && userChoose != 7 && userChoose != 8 && userChoose != 9 && userChoose != -1);

        System.out.println("Give new address.");
        String newAddress = scanner.next();



    }

    public static void customerService(){
        System.out.println("--- Welcome to TravelCompany Customer Service ---");
        System.out.println();
        int userChoose = Integer.MIN_VALUE;
        do {
            System.out.println("Choose how you want to start:");
            System.out.println("\tPress 0: To change Customer address.");
            System.out.println("\tPress -1: To exit.");
            try {
                userChoose = scanner.nextInt();
            }
            catch (InputMismatchException ex) {
                String badInput = scanner.next();
                System.out.println("Bad input: '" + badInput + "' Please try again.");
                System.out.println();
                continue;
            }
        } while (userChoose != 0 && userChoose != -1);

        switch (userChoose) {
            case 0 -> {
                System.out.println("You want to change Customer address.");
                changeAddress();
            }
            case -1 -> System.out.println("Exiting...");
        }
    }

    /**
     * Returns a hashtable with key the customer id and value the cost of tickets that he purchased.
     *
     * @param tickets all the tickets of TravelCompany.
     * @return a hashtable with customerId and cost of tickets that purchased each.
     */
    private static Hashtable<Integer, Integer> collectionOfTickersWithPaymentAmount(TicketRepository tickets) {
        // Creating collection of Hashtable.
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (Ticket ticket : tickets.readTickets()) {
            if (hashtable.containsKey(ticket.getPassengerId())){
                int value = hashtable.get(ticket.getPassengerId());
                hashtable.put(ticket.getPassengerId(), value + ticket.getPaymentAmount());
            } else {
                hashtable.put(ticket.getPassengerId(), ticket.getPaymentAmount());
            }
        }
        return hashtable;
    }

    /**
     * Returns a hashtable with key the customer id and value the number of tickets that he purchased.
     *
     * @param tickets all the tickets of TravelCompany.
     * @return a hashtable with customerId and number of tickets that purchased each.
     */
    private static Hashtable<Integer, Integer> collectionOfTicketsWithCustomers(TicketRepository tickets) {
        // Creating collection of Hashtable.
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (Ticket ticket : tickets.readTickets()) {
            if (hashtable.containsKey(ticket.getPassengerId())){
                int value = hashtable.get(ticket.getPassengerId());
                hashtable.put(ticket.getPassengerId(), value + 1);
            } else {
                hashtable.put(ticket.getPassengerId(), 1);
            }
        }
        return hashtable;
    }

    /**
     * TotalCostAndNumberOfTickets() method prints out a report for the total cost of tickets and total number of tickets.
     *
     * @param tickets all tickets of TravelCompany.
     */
    private static void totalCostAndNumberOfTickets(TicketRepository tickets) {
        // Creating Report.
        System.out.println("List of the total number and cost of tickets for all customers.");
        System.out.println("The total number of tickets are " + tickets.readTickets().size());

        // Calculating the total cost of all tickets.
        int totalCost = 0;
        for (Ticket ticket : tickets.readTickets())
            totalCost += ticket.getPaymentAmount();
        System.out.println("The total cost of tickets are " + totalCost + "\n");

    }

    /**
     * TotalItinerariesPerDestinationAndDeparture() method prints out the total itineraries per destination and per departure.
     *
     * @param itineraries all itineraries of TravelCompany.
     */
    private static void totalItinerariesPerDestinationAndDeparture(ItineraryRepository itineraries) {
        // Creating Report.
        System.out.println("List of the total offered itineraries per destination and departure.");

        // Getting the departure airport code and tickets with hashtable.
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        for (Itinerary itinerary : itineraries.readItineraries())
            if (hashtable.containsKey(itinerary.getDepartureAirportCode())){
                int value = hashtable.get(itinerary.getDepartureAirportCode());
                hashtable.put(itinerary.getDepartureAirportCode(), value + 1);
            } else {
                hashtable.put(itinerary.getDepartureAirportCode(), 1);
            }

        // Printing all Departure Airport Code with total of itineraries each.
        hashtable.forEach((k, v) -> {
            System.out.println("Itinerary per Departures is '" + k + "' has total of " + v + " itineraries.");
        });

        Hashtable<String, Integer> hashtable2 = new Hashtable<>();
        for (Itinerary itinerary : itineraries.readItineraries())
            if (hashtable2.containsKey(itinerary.getDestinationAirportCode())){
                int value = hashtable2.get(itinerary.getDestinationAirportCode());
                hashtable2.put(itinerary.getDestinationAirportCode(), value + 1);
            } else {
                hashtable2.put(itinerary.getDestinationAirportCode(), 1);
            }

        // Printing all Departure Airport Code with total of itineraries each.
        hashtable2.forEach((k, v) -> {
            System.out.println("Itinerary per Destination is '" + k + "' has total of " + v + " itineraries.");
        });
        System.out.println();
    }

    /**
     * CustomersWithMostTicketsAndCostOfPurchases() method prints out the customers with most tickets sold and the customers
     * with the most cost of purchases.
     *
     * @param tickets all the tickets of TravelCompany.
     * @param customers all the customers of TravelCompany.
     */
    private static void customersWithMostTicketsAndCostOfPurchases(TicketRepository tickets, CustomerRepository customers) {
        // Creating Report.
        System.out.println("List of the customers who purchased the most tickets and the cost of purchases.");

        // Getting the customer and tickets with hashtable.
        Hashtable<Integer, Integer> hashtable = collectionOfTicketsWithCustomers(tickets);

        // Finding maximum tickets sold from hashtable. And then iterating through hashtable and printing all customers
        // with maximum amount of tickets sold to them.
        int maxValueInMap=(Collections.max(hashtable.values()));
        for (Map.Entry<Integer, Integer> entry : hashtable.entrySet())
            if (entry.getValue()==maxValueInMap)
                for (Customer customer : customers.readCustomers())
                    if (customer.getId() == entry.getKey())
                        System.out.println("Customer with most tickets purchased is '" + customer.getName()
                                + "' with total tickets of " + maxValueInMap + ".");

        // Getting the payment amount and tickets with hashtable2.
        Hashtable<Integer, Integer> hashtable2 = collectionOfTickersWithPaymentAmount(tickets);

        // Finding the maximum cost of tickets purchased by the customers. And then iterating through hashtable2 and printing
        // all customers with maximum amount of cost of purchased of tickets.
        maxValueInMap=(Collections.max(hashtable2.values()));
        for (Map.Entry<Integer, Integer> entry : hashtable2.entrySet())
            if (entry.getValue()==maxValueInMap)
                for (Customer customer : customers.readCustomers())
                    if (customer.getId() == entry.getKey())
                        System.out.println("Customer with most cost of purchased tickets is '" + customer.getName()
                                + "' with total cost of " + maxValueInMap + ".");
        System.out.println();
    }

    /**
     * CustomersWithNoPurchased() method prints out a report of the customers that made no purchased.
     *
     * @param tickets all the tickets of TravelCompany.
     * @param customers all the customers of TravelCompany.
     */
    private static void customersWithNoPurchases(TicketRepository tickets, CustomerRepository customers) {
        // Creating Report.
        System.out.println("List of the customers who have not purchased any tickets.");

        // Getting the customer and tickets with hashtable.
        Hashtable<Integer, Integer> hashtable = collectionOfTicketsWithCustomers(tickets);

        // Checking which customerId is missing from our hashtable, and then we insert him on our list.
        List<String> customersWithNoPurchase = new ArrayList<>();
        for (Customer customer : customers.readCustomers())
            if (!hashtable.containsKey(customer.getId()))
                System.out.println(customer.getName());
        System.out.println();

    }

    /**
     * Returns the ticket that has been made.
     *
     * @param ticketId  takes the ticket id.
     * @param customer  takes the customer.
     * @param itinerary takes the itinerary.
     * @param paymentMethod takes the payment method.
     * @return the ticket with the appropriate parameters.
     */
    private static Ticket ticketService(int ticketId, Customer customer, Itinerary itinerary, String paymentMethod) {
        // Creating Ticket.
        String categoryOfCustomer = customer.getCategory();
        BigDecimal basicPriceOfTicket = new BigDecimal(itinerary.getBasicPrice());

        //  Checking for Ordering and Discount policy based on Customer Category and Payment Method.
        BigDecimal discount = new BigDecimal(1);
        if (categoryOfCustomer.equals("Business"))
            discount = discount.add(new BigDecimal("-0.1"));
        if (categoryOfCustomer.equals("Individual"))
            discount = discount.add(new BigDecimal("0.2"));
        if (paymentMethod.equals("Credit Cart"))
            discount = discount.add(new BigDecimal("-0.1"));

        return new Ticket(ticketId, customer.getId(), itinerary.getId(), paymentMethod, basicPriceOfTicket.multiply(discount).intValue());
    }

    /**
     * Returns all the Customers of TravelCompany.
     *
     * @return the customers of TravelCompany
     */
    private static CustomerRepository generateCustomers() {
        // Creating Customers.
        CustomerRepository customers = new CustomerRepositoryImpl();
        customers.createCustomer(new Customer(1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", "Individual"));
        customers.createCustomer(new Customer(2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", "Individual"));
        customers.createCustomer(new Customer(3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", "Business"));
        customers.createCustomer(new Customer(4, "Antonio Molinari", "amolinari@mail.com", "Milan", "Italian", "Individual"));
        customers.createCustomer(new Customer(5, "Frederico Rossi", "frossi@mail.com", "Milan", "Italian", "Individual"));
        customers.createCustomer(new Customer(6, "Mario Conti", "mconti@mail.com", "Rome", "Italian", "Business"));
        customers.createCustomer(new Customer(7, "Nathan Martin", "nmartin@mail.com", "Lyon", "French", "Business"));
        customers.createCustomer(new Customer(8, "Enzo Collin", "ecollin@mail.com", "Lyon", "French", "Individual"));
        customers.createCustomer(new Customer(9, "Frederic Michel", "fmichel@mail.com", "Athens", "French", "Individual"));

        return customers;
    }

    /**
     * Returns all the Itineraries of TravelCompany.
     *
     * @return the itineraries of TravelCompany
     */
    private static ItineraryRepository generateItineraries() {
        // Creating Itineraries.
        ItineraryRepository itineraries = new ItineraryRepositoryImpl();
        itineraries.createItinerary(new Itinerary(1, "ATH", "PAR", "2022-02-22 13:35:00", "SkyLines", 300));
        itineraries.createItinerary(new Itinerary(2, "ATH", "LON", "2022-02-22 13:40:00", "SkyLines", 420));
        itineraries.createItinerary(new Itinerary(3, "ATH", "AMS", "2022-02-22 13:45:00", "SkyLines", 280));
        itineraries.createItinerary(new Itinerary(4, "ATH", "PAR", "2022-02-22 14:20:00", "SkyLines", 310));
        itineraries.createItinerary(new Itinerary(7, "ATH", "DUB", "2022-02-22 14:35:00", "SkyLines", 880));
        itineraries.createItinerary(new Itinerary(8, "ATH", "FRA", "2022-02-22 14:55:00", "SkyLines", 380));
        itineraries.createItinerary(new Itinerary(9, "ATH", "FRA", "2022-02-22 15:35:00", "SkyLines", 350));
        itineraries.createItinerary(new Itinerary(10, "ATH", "MEX", "2022-02-22 16:00:00", "SkyLines", 1020));
        itineraries.createItinerary(new Itinerary(11, "ATH", "DUB", "2022-02-22 16:35:00", "SkyLines", 770));

        return itineraries;
    }

    /**
     * StartBusiness() will generate Customers from generateCustomers() method, Itineraries from
     * generateItineraries() method and Tickets from ticketsService() method.
     * After the generation of Customers, Itineraries and Tickets. The StartBusiness() method will continue with
     * the Reporting part or exit the program.
     * 0    ->  To get a list of total number and cost of tickets for all customers.
     * 1    ->  To get a list of the total offered itineraries per destination and departure.
     * 2    ->  To get a list of the customers who purchased the most tickets and number of purchases.
     * 3    ->  To get a list of the customers who have not purchased any tickets.
     * 4    ->  To get all the above lists.
     * -1   ->  To exit the program.
     * This method check for exceptions for a bad user input, and it handles it.
     */
    private static void startBusiness() {
        // Generating the Customers and Itineraries.
        CustomerRepository customers = generateCustomers();
        ItineraryRepository itineraries = generateItineraries();
        System.out.println("Customers and Itineraries Generated...");
        System.out.println("Tickets Generated...\n");

        // Generating the Tickets.
        TicketRepository tickets = new TicketRepositoryImpl();
        tickets.createTicket(ticketService(1, customers.readCustomer(1), itineraries.readItinerary(2), "Cash"));
        tickets.createTicket(ticketService(2, customers.readCustomer(2), itineraries.readItinerary(3), "Cash"));
        tickets.createTicket(ticketService(3, customers.readCustomer(3), itineraries.readItinerary(3), "Credit Cart"));
        tickets.createTicket(ticketService(4, customers.readCustomer(2), itineraries.readItinerary(4), "Credit Cart"));
        tickets.createTicket(ticketService(5, customers.readCustomer(3), itineraries.readItinerary(4), "Cash"));
        tickets.createTicket(ticketService(6, customers.readCustomer(4), itineraries.readItinerary(7), "Credit Cart"));
        tickets.createTicket(ticketService(7, customers.readCustomer(5), itineraries.readItinerary(7), "Credit Cart"));
        tickets.createTicket(ticketService(8, customers.readCustomer(2), itineraries.readItinerary(10), "Cash"));
        tickets.createTicket(ticketService(9, customers.readCustomer(1), itineraries.readItinerary(3), "Cash"));

        // Printing the Tickets.
        for (Ticket ticket : tickets.readTickets())
            System.out.println("Ticket" + ticket.getId() + " with PassengerId:'" + ticket.getPassengerId() + "' with ItineraryId:'"
                    + ticket.getItineraryId() + "' with PaymentMethod:'" + ticket.getPaymentMethod()
                    + "' the Total Cost is:'" + ticket.getPaymentAmount() + "'.");

        // We check how the user want to continue. Handling the user's input if he doesn't give the correct input.
        int userChoose = Integer.MIN_VALUE;
        do {
            System.out.println("\nChoose how you want to continue.");
            System.out.println("\tPress 0: To get a list of total number and cost of tickets for all customers.");
            System.out.println("\tPress 1: To get a list of the total offered itineraries per destination and departure.");
            System.out.println("\tPress 2: To get a list of the customers who purchased the most tickets and number of purchases.");
            System.out.println("\tPress 3: To get a list of the customers who have not purchased any tickets.");
            System.out.println("\tPress 4: To get all the above lists.");
            System.out.println("\tPress -1: To exit.");
            try {
                userChoose = scanner.nextInt();
            }
            catch (InputMismatchException ex) {
                String badInput = scanner.next();
                System.out.println("Bad input: '" + badInput + "' Please try again.\n");
                continue;
            }
        } while (userChoose != 0 && userChoose != 1 && userChoose != 2 && userChoose != 3 && userChoose != 4 && userChoose != -1);

        // Based on the user choose we report back or exit the program.
        switch (userChoose) {
            case 0 -> totalCostAndNumberOfTickets(tickets);
            case 1 -> totalItinerariesPerDestinationAndDeparture(itineraries);
            case 2 -> customersWithMostTicketsAndCostOfPurchases(tickets, customers);
            case 3 -> customersWithNoPurchases(tickets, customers);
            case 4 -> {
                totalCostAndNumberOfTickets(tickets);
                totalItinerariesPerDestinationAndDeparture(itineraries);
                customersWithMostTicketsAndCostOfPurchases(tickets, customers);
                customersWithNoPurchases(tickets, customers);
            }
            case -1 -> System.out.println("Exiting...");
        }
    }

    /**
     * BusinessInterfaceStart() will start our program with a welcome note of the TravelCompany, and then
     * it will wait for the user to select preferred action or exit the program.
     * Actions of selection are:
     *  0   ->  To generate Customers, Itineraries and Tickets.
     *  -1  ->  To exit the program.
     *  This method check for exceptions for a bad user input, and it handles it.
     */
    public static void businessInterfaceStart() {
        // Starting the program.
        System.out.println("--- Welcome to TravelCompany ---\n");

        // We check how the user want to start. Handling the user's input if he doesn't give the correct input.
        int userChoose = Integer.MIN_VALUE;
        do {
            System.out.println("Choose how you want to start:");
            System.out.println("\tPress 0: To Generate Tickets.");
            System.out.println("\tPress -1: To exit.");
            try {
                userChoose = scanner.nextInt();
            }
            catch (InputMismatchException ex) {
                String badInput = scanner.next();
                System.out.println("Bad input: '" + badInput + "' Please try again.\n");
                continue;
            }
        } while (userChoose != 0 && userChoose != 1 && userChoose != -1);

        // Based on the user choose we start generating or exiting the program.
        switch (userChoose) {
            case 0 -> {
                System.out.println("You want to generate tickets.");
                startBusiness();
            }
            case -1 -> System.out.println("Exiting...");
        }
    }
}
