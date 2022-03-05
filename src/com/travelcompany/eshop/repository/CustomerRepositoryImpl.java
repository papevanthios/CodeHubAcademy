package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.exception.CustomerException;
import com.travelcompany.eshop.model.Customer;

import java.util.ArrayList;
import java.util.List;


public class CustomerRepositoryImpl implements CustomerRepository{
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public boolean createCustomer(Customer customer) throws CustomerException{
        if (customer == null || customer.getName() == null || customer.getEmail() == null
                || customer.getAddress() == null || customer.getNationality() == null || customer.getCategory() == null)
            throw new CustomerException("Customer data missing.");
        customers.add(customer);
        return true;
    }

    @Override
    public Customer readCustomer(int id) throws CustomerException{
        for (Customer customer: customers)
            if (customer.getId() == id)
                return customer;
        throw new CustomerException("Customer does not exist.");
    }

    @Override
    public List<Customer> readCustomers() {
        List<Customer> returnCustomers = new ArrayList<>();
        returnCustomers.addAll(customers);
        return returnCustomers;
    }

    @Override
    public boolean updateCustomer(int id, String newAddress) throws CustomerException {
        Customer customer = readCustomer(id);
        if (customer == null)
            throw new CustomerException("Customer does not exist.");
        customer.setAddress(newAddress);
        return true;
    }

    @Override
    public boolean deleteCustomer(int id) throws CustomerException {
        Customer customer = readCustomer(id);
        if (customer == null)
            throw new CustomerException("Customer does not exist.");
        customers.remove(customer);
        return true;
    }
}