package com.diegokrupitza.teletradertestproject.service;

import com.diegokrupitza.teletradertestproject.dto.OrderBook;
import com.diegokrupitza.teletradertestproject.domain.OrderTyp;
import com.diegokrupitza.teletradertestproject.domain.UserOrder;
import com.diegokrupitza.teletradertestproject.helpers.TeletraderBackendExpetion;
import com.diegokrupitza.teletradertestproject.persistence.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Project: teletrader-test-project
 * Document: UserOrderServiceImpl.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    protected UserOrderRepository userOrderRepository;

    @Override
    public boolean placeNewOrder(UserOrder userOrder) throws TeletraderBackendExpetion {
        if (Objects.nonNull(userOrder)) {
            userOrderRepository.save(userOrder);
            return true;
        } else {
            throw new TeletraderBackendExpetion("Null Order ist not allowed to persist");
        }
    }

    @Override
    public List<UserOrder> getAllBuyOrders() {
        return userOrderRepository.findAllByOrOrderTyp(OrderTyp.BUY);
    }

    @Override
    public List<UserOrder> getAllSellOrders() {
        return userOrderRepository.findAllByOrOrderTyp(OrderTyp.SELL);
    }

    @Override
    public OrderBook getOrderBook(int topNumber) {
        return OrderBook.builder()
                .topBuyOrders(getOrderBookBuy(topNumber))
                .topSellOrders(getOrderBookSell(topNumber))
                .build();
    }

    /**
     * Gives the top buy List Sorted for the orderbook
     *
     * @param topNumber the number of maximal tops
     * @return List with Top Buy Orders
     */
    private List<UserOrder> getOrderBookBuy(int topNumber) {
        // i did it this way on purpose because i wanted to show how to use Java8 streams in this project
        // the best way would be to sort it and limit it on the database, because it is more performance friendly

        return userOrderRepository.findAllByOrOrderTyp(OrderTyp.BUY).stream()
                .sorted(Comparator.comparingDouble(UserOrder::getPrice).reversed())
                .limit(topNumber)
                .collect(Collectors.toList());
    }

    /**
     * Gives the top sell List Sorted for the orderbook
     *
     * @param topNumber the number of maximal tops
     * @return List with Sell Buy Orders
     */
    private List<UserOrder> getOrderBookSell(int topNumber) {
        // i did it this way on purpose because i wanted to show how to use Java8 streams in this project
        // the best way would be to sort it and limit it on the database, because it is more performance friendly

        return userOrderRepository.findAllByOrOrderTyp(OrderTyp.SELL).stream()
                .sorted(Comparator.comparingDouble(UserOrder::getPrice))
                .limit(topNumber)
                .collect(Collectors.toList());
    }
}
