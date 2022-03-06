/**
 * The CustomerRepository interface specify the behavior of the CustomerRepositoryImpl class.
 *
 * @author Evanthios Papadopoulos
 * @since 02-Mar-22
 */

package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.exception.CustomerException;
import com.travelcompany.eshop.model.Customer;

import java.util.List;

public interface CustomerRepository {
    //CRUD

    boolean createCustomer(Customer customer) throws CustomerException;

    Customer readCustomer(int id) throws CustomerException;

    List<Customer> readCustomers();

    boolean updateCustomer(int id, String newAddress) throws CustomerException;

    boolean deleteCustomer(int id) throws CustomerException;
}
