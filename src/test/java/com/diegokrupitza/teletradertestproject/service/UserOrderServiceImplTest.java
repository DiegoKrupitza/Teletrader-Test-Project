package com.diegokrupitza.teletradertestproject.service;

import com.diegokrupitza.teletradertestproject.TestFixtures;
import com.diegokrupitza.teletradertestproject.domain.OrderTyp;
import com.diegokrupitza.teletradertestproject.domain.UserOrder;
import com.diegokrupitza.teletradertestproject.dto.OrderBook;
import com.diegokrupitza.teletradertestproject.helpers.TeletraderBackendExpetion;
import com.diegokrupitza.teletradertestproject.persistence.UserOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOrderServiceImplTest {

    @Autowired
    private UserOrderServiceImpl userOrderService;

    @Autowired
    private UserOrderRepository userOrderRepository;

    public static final int TOP_NUMBER = 3;

    @Before
    public void setUp() {

        log.info("Inserting Data");
        userOrderRepository.safe(TestFixtures.userOrderBuyList);
        userOrderRepository.safe(TestFixtures.userOrderSellList);

        long count = userOrderRepository.count();
        assertThat(count).isEqualTo(50);
    }

    @After
    public void cleanUp() {
        userOrderRepository.deleteAll();

        long count = userOrderRepository.count();
        assertThat(count).isEqualTo(0);
        log.info("Finished with cleanUp");
    }

    @Test
    public void placeNewOrder() throws TeletraderBackendExpetion {
        long before = userOrderRepository.count();

        UserOrder dummyOrder = UserOrder.builder().price(17.19).amount(20).orderTyp(OrderTyp.BUY).build();
        userOrderService.placeNewOrder(dummyOrder);

        long after = userOrderRepository.count();

        assertThat(after).isEqualTo(before - 1);
    }

    @Test
    public void getOrderBook() {
        OrderBook orderBook = userOrderService.getOrderBook(TOP_NUMBER);
        log.debug("{}", orderBook);

        assertThat(orderBook.getTopBuyOrders()).isSortedAccordingTo((item1, item2) -> Double.compare(item2.getPrice(), item1.getPrice()));
        assertThat(orderBook.getTopSellOrders()).isSortedAccordingTo((item1, item2) -> Double.compare(item1.getPrice(), item2.getPrice()));
        assertThat(orderBook.getTopBuyOrders().size()).isEqualTo(TOP_NUMBER);
        assertThat(orderBook.getTopSellOrders().size()).isEqualTo(TOP_NUMBER);
    }
}