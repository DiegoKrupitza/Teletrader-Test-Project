package com.diegokrupitza.teletradertestproject.dto;

import com.diegokrupitza.teletradertestproject.domain.UserOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Project: teletrader-test-project
 * Document: OrderBook.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderBook {

    private List<UserOrder> topBuyOrders;

    private List<UserOrder> topSellOrders;
}
