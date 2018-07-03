package com.diegokrupitza.teletradertestproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: teletrader-test-project
 * Document: UserOrderDTO.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrderDTO {

    private double price;

    private int amount;

    private String orderType;

    private String uuid;

}
