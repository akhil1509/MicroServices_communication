package com.car.Rent_a_Car.service;

import com.car.Rent_a_Car.entity.Car;
import com.car.Rent_a_Car.exception.ResourceNotFoundException;
import com.car.Rent_a_Car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        Car save = carRepository.save(car);

        return save;
    }

    @Override
    public Car getCar(Long id) {

        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find on this id=  " + id));
        return car;
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public String deleteCar(Long id) {
         carRepository.deleteById(id);
         return "user is deleted successfully";
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Car car1 = carRepository.findById(id).get();
        car1.setModel(car.getModel());
        car1.setType(car.getType());
        Car save = carRepository.save(car1);
        return save;


    }

    @Override
    public List<Car> getCarByUserId(Long userId) {
        return carRepository.findByUserId(userId);
    }
}
