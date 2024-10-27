package com.user.User_Details.controller;

import com.user.User_Details.entity.Customer;
import com.user.User_Details.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base_dtl")
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/create_Customer")
    public ResponseEntity<Customer> createCustomerResponseEntity(@RequestBody Customer customer){
        Customer customer1 = userServiceImpl.createCustomer(customer);

        return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public  ResponseEntity<Customer> getCustomerResponseEntity(@PathVariable Long id){
        Customer customer = userServiceImpl.getCustomer(id);
        return new ResponseEntity<Customer>(customer, HttpStatus.FOUND);

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> allCustomer = userServiceImpl.getAllCustomer();
        return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.OK);
    }
    @GetMapping("get/{vehicleId}")
public ResponseEntity<List<Customer>> getCustomerByVehId(@PathVariable Long vehicleId){
    List<Customer> allCustomerByVehId = userServiceImpl.getAllCustomerByVehId(vehicleId);
    return new ResponseEntity<List<Customer>>(allCustomerByVehId, HttpStatus.OK);
}
}
