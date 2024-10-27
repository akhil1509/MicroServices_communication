package com.user.User_Details.service;

import com.user.User_Details.entity.Customer;
import com.user.User_Details.exception.ResourceNotFoundException;
import com.user.User_Details.feign.FeignService;
import com.user.User_Details.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

   private FeignService feignService;

    public UserServiceImpl(UserRepository userRepository, FeignService feignService) {
        this.userRepository = userRepository;
        this.feignService = feignService;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return userRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found  on id : " + id));
       customer.setCars(feignService.getCarByUserIds(customer.getId()));
       return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> all = userRepository.findAll();
        all.stream().map(e ->
        {
            e.setCars(feignService.getCarByUserIds(e.getId()));
            return  e;
        }
        ).collect(Collectors.toList());
        return all;
    }

    @Override
    public List<Customer> getAllCustomerByVehId(Long vehicleId) {
      return userRepository.findByVehicleId(vehicleId);

    }



}
