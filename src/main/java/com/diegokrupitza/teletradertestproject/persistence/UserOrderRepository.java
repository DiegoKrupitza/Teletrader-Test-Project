package com.diegokrupitza.teletradertestproject.persistence;

import com.diegokrupitza.teletradertestproject.domain.OrderTyp;
import com.diegokrupitza.teletradertestproject.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project: teletrader-test-project
 * Document: OrderRepository.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

    List<UserOrder> findAllByOrOrderTyp(OrderTyp orderTyp);

    default void safe(List<UserOrder> orderList) {
        orderList.forEach(this::save);
    }
}
