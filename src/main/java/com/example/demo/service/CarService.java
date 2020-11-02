package com.example.demo.service;

import com.example.demo.entity.Car;

import java.util.List;

/**
 * Created by TuanPM on 2020-11-02.
 **/
public interface CarService {

    List<Car> findCarsAfterYear(Integer year_in);
}
