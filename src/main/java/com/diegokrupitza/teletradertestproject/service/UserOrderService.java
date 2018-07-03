package com.diegokrupitza.teletradertestproject.service;

import com.diegokrupitza.teletradertestproject.dto.OrderBook;
import com.diegokrupitza.teletradertestproject.domain.UserOrder;
import com.diegokrupitza.teletradertestproject.helpers.TeletraderBackendExpetion;

import java.util.List;

/**
 * Project: teletrader-test-project
 * Document: UserOrderService.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
public interface UserOrderService {

    /**
     * Place new userOrder.
     *
     * @param userOrder the userOrder
     * @return the boolean
     */
    boolean placeNewOrder(UserOrder userOrder) throws TeletraderBackendExpetion;

    /**
     * Gets all buy orders.
     *
     * @return the all buy orders
     */
    List<UserOrder> getAllBuyOrders();

    /**
     * Gets all sell orders.
     *
     * @return the all sell orders
     */
    List<UserOrder> getAllSellOrders();

    /**
     * Gets order book with n tops.
     *
     * @param topNumber the top number how many top x you want
     * @return the order book
     */
    OrderBook getOrderBook(int topNumber);
}
