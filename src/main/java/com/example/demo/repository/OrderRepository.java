package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TuanPM on 2020-10-22.
 **/
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
