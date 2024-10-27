package com.car.Rent_a_Car.service;

import com.car.Rent_a_Car.entity.Car;

import java.util.List;

public interface CarService {

    // for adding
    public Car addCar(Car car);
    //for getting

    public Car getCar(Long id);

    public List<Car> getAllCar();

    public  String deleteCar(Long id);

    public  Car updateCar(Long id, Car car);

    public List<Car> getCarByUserId(Long userId);




}
