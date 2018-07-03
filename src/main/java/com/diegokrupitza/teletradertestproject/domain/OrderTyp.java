package com.diegokrupitza.teletradertestproject.domain;

/**
 * Project: teletrader-test-project
 * Document: OrderTyp.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
public enum OrderTyp {
    BUY("Buy"),
    SELL("Sell");

    private String ordertype;

    OrderTyp(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getOrdertype() {
        return ordertype;
    }
}
