package com.example.demo.repository;

import com.example.demo.entity.DebtOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by TuanPM on 2020-10-22.
 **/
@Repository
public interface DebtRepository extends JpaRepository<DebtOrder, Long> {

    @Query("select d from DebtOrder d where d.orderId = orderId")
    DebtOrder findByIdOrderId(Long orderId);
}
