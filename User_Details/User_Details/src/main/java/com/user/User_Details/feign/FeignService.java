package com.user.User_Details.feign;

import com.user.User_Details.entity.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:1111/base", name = "FeignClient")

public interface FeignService {

   // @GetMapping("/base/getCar/{userId}")

  //  public List<Car> getCarByUserIds(@PathVariable Long userId);

    @GetMapping("/getCar/{userId}")
    public List<Car> getCarByUserIds(@PathVariable Long userId);

}
