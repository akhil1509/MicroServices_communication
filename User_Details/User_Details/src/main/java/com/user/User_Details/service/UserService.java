package com.user.User_Details.service;

import com.user.User_Details.entity.Customer;

import java.util.List;

public interface UserService {
    public Customer createCustomer(Customer customer);

    public  Customer getCustomer(Long id);

    public List<Customer> getAllCustomer();

    public List<Customer> getAllCustomerByVehId(Long vehicleId);
}
