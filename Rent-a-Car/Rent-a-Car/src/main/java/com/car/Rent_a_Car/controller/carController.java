package com.car.Rent_a_Car.controller;

import com.car.Rent_a_Car.entity.Car;
import com.car.Rent_a_Car.service.CarServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base")
public class carController {

    private CarServiceImpl carServiceImpl;

    public carController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car car1 = carServiceImpl.addCar(car);
        return new ResponseEntity<>(car1, HttpStatus.CREATED);
    }
    @GetMapping("/getCarById/{id}")
    public ResponseEntity<Car> getCar( @PathVariable("id") Long id){
        Car car = carServiceImpl.getCar(id);
        return new ResponseEntity<>(car, HttpStatus.FOUND);
    }

    @GetMapping("/getallCar")
    public ResponseEntity<List<Car>> getListCar(){
        List<Car> allCar = carServiceImpl.getAllCar();
        return new ResponseEntity<>(allCar, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteCar/{id}")
    public  ResponseEntity<String> deleteCar( @PathVariable Long id){
        String s = carServiceImpl.deleteCar(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PutMapping("/updateCar/{id}/{up}")
    public  ResponseEntity<Car> updateCar( @PathVariable Long id, @RequestBody Car car){
        Car car1 = carServiceImpl.updateCar(id, car);
        return new ResponseEntity<>(car1, HttpStatus.OK);
    }

    @GetMapping("/getCar/{userId}")
    public ResponseEntity<List<Car>> getCarByUserIds(@PathVariable Long userId){
        List<Car> carByUserId = carServiceImpl.getCarByUserId(userId);
        return new ResponseEntity<>(carByUserId, HttpStatus.OK);
    }
}
