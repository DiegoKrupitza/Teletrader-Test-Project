package com.diegokrupitza.teletradertestproject;

import com.diegokrupitza.teletradertestproject.domain.OrderTyp;
import com.diegokrupitza.teletradertestproject.domain.UserOrder;
import com.diegokrupitza.teletradertestproject.persistence.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: teletrader-test-project
 * Document: StartUp.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Component
public class StartUp {

    public static List<UserOrder> userOrderBuyList = new ArrayList<UserOrder>() {{
        add(UserOrder.builder().amount(100).orderTyp(OrderTyp.BUY).price(23.1).build());
        add(UserOrder.builder().amount(10).orderTyp(OrderTyp.BUY).price(3.1).build());
        add(UserOrder.builder().amount(10).orderTyp(OrderTyp.BUY).price(1.1).build());
        add(UserOrder.builder().amount(320).orderTyp(OrderTyp.BUY).price(2.1).build());
        add(UserOrder.builder().amount(230).orderTyp(OrderTyp.BUY).price(223.1).build());
        add(UserOrder.builder().amount(1560).orderTyp(OrderTyp.BUY).price(2243.1).build());
        add(UserOrder.builder().amount(10450).orderTyp(OrderTyp.BUY).price(345.1).build());
        add(UserOrder.builder().amount(1450).orderTyp(OrderTyp.BUY).price(243.1).build());
        add(UserOrder.builder().amount(1320).orderTyp(OrderTyp.BUY).price(133.1).build());
        add(UserOrder.builder().amount(15620).orderTyp(OrderTyp.BUY).price(2673.1).build());
        add(UserOrder.builder().amount(15670).orderTyp(OrderTyp.BUY).price(73.1).build());
        add(UserOrder.builder().amount(12340).orderTyp(OrderTyp.BUY).price(63.1).build());
        add(UserOrder.builder().amount(1780).orderTyp(OrderTyp.BUY).price(53.1).build());
        add(UserOrder.builder().amount(100).orderTyp(OrderTyp.BUY).price(43.1).build());
        add(UserOrder.builder().amount(16780).orderTyp(OrderTyp.BUY).price(53.1).build());
        add(UserOrder.builder().amount(10450).orderTyp(OrderTyp.BUY).price(73.1).build());
        add(UserOrder.builder().amount(10890).orderTyp(OrderTyp.BUY).price(83.1).build());
        add(UserOrder.builder().amount(2300).orderTyp(OrderTyp.BUY).price(93.1).build());
        add(UserOrder.builder().amount(3400).orderTyp(OrderTyp.BUY).price(26773.1).build());
        add(UserOrder.builder().amount(5).orderTyp(OrderTyp.BUY).price(2553.1).build());
        add(UserOrder.builder().amount(15460).orderTyp(OrderTyp.BUY).price(3443.1).build());
        add(UserOrder.builder().amount(980).orderTyp(OrderTyp.BUY).price(33.1).build());
        add(UserOrder.builder().amount(560).orderTyp(OrderTyp.BUY).price(73.1).build());
        add(UserOrder.builder().amount(680).orderTyp(OrderTyp.BUY).price(83.1).build());
        add(UserOrder.builder().amount(980).orderTyp(OrderTyp.BUY).price(93.1).build());
    }};

    public static List<UserOrder> userOrderSellList = new ArrayList<UserOrder>() {{
        add(UserOrder.builder().amount(100).orderTyp(OrderTyp.SELL).price(23.1).build());
        add(UserOrder.builder().amount(10).orderTyp(OrderTyp.SELL).price(3.1).build());
        add(UserOrder.builder().amount(10).orderTyp(OrderTyp.SELL).price(1.1).build());
        add(UserOrder.builder().amount(320).orderTyp(OrderTyp.SELL).price(2.1).build());
        add(UserOrder.builder().amount(230).orderTyp(OrderTyp.SELL).price(223.1).build());
        add(UserOrder.builder().amount(1560).orderTyp(OrderTyp.SELL).price(2243.1).build());
        add(UserOrder.builder().amount(10450).orderTyp(OrderTyp.SELL).price(345.1).build());
        add(UserOrder.builder().amount(1450).orderTyp(OrderTyp.SELL).price(243.1).build());
        add(UserOrder.builder().amount(1320).orderTyp(OrderTyp.SELL).price(133.1).build());
        add(UserOrder.builder().amount(15620).orderTyp(OrderTyp.SELL).price(2673.1).build());
        add(UserOrder.builder().amount(15670).orderTyp(OrderTyp.SELL).price(73.1).build());
        add(UserOrder.builder().amount(12340).orderTyp(OrderTyp.SELL).price(63.1).build());
        add(UserOrder.builder().amount(1780).orderTyp(OrderTyp.SELL).price(53.1).build());
        add(UserOrder.builder().amount(100).orderTyp(OrderTyp.SELL).price(43.1).build());
        add(UserOrder.builder().amount(16780).orderTyp(OrderTyp.SELL).price(53.1).build());
        add(UserOrder.builder().amount(10450).orderTyp(OrderTyp.SELL).price(73.1).build());
        add(UserOrder.builder().amount(10890).orderTyp(OrderTyp.SELL).price(83.1).build());
        add(UserOrder.builder().amount(2300).orderTyp(OrderTyp.SELL).price(93.1).build());
        add(UserOrder.builder().amount(3400).orderTyp(OrderTyp.SELL).price(26773.1).build());
        add(UserOrder.builder().amount(5).orderTyp(OrderTyp.SELL).price(2553.1).build());
        add(UserOrder.builder().amount(15460).orderTyp(OrderTyp.SELL).price(3443.1).build());
        add(UserOrder.builder().amount(980).orderTyp(OrderTyp.SELL).price(33.1).build());
        add(UserOrder.builder().amount(560).orderTyp(OrderTyp.SELL).price(73.1).build());
        add(UserOrder.builder().amount(680).orderTyp(OrderTyp.SELL).price(83.1).build());
        add(UserOrder.builder().amount(980).orderTyp(OrderTyp.SELL).price(93.1).build());
    }};

    @Autowired
    private UserOrderRepository userOrderRepository;

    @PostConstruct
    public void initDummyData() {
        userOrderRepository.safe(userOrderBuyList);
        userOrderRepository.safe(userOrderSellList);
    }
}
