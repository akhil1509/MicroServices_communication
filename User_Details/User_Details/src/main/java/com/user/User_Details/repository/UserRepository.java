package com.user.User_Details.repository;

import com.user.User_Details.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByVehicleId(Long vehicleId);
}
