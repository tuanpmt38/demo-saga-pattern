package com.example.demo.service.impl;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TuanPM on 2020-11-02.
 **/

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findCarsAfterYear(Integer year_in) {
        return carRepository.findCarsAfterYear(year_in);
    }
}
