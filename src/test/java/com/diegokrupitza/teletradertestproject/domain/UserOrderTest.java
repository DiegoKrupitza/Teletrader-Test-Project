package com.diegokrupitza.teletradertestproject.domain;

import com.diegokrupitza.teletradertestproject.persistence.UserOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;


import java.math.BigDecimal;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOrderTest {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Test
    public void setPersistenceTimeStamp() {
        UserOrder userOrder1 = UserOrder.builder()
                .amount(10)
                .orderTyp(OrderTyp.BUY)
                .price(10.2)
                .build();

        UserOrder savedUserOrder = userOrderRepository.save(userOrder1);

        assertThat(userOrder1.getPersistenceTimeStamp()).isNotNull();
        log.info("Timestamp: {}", userOrder1.getPersistenceTimeStamp());

    }
}