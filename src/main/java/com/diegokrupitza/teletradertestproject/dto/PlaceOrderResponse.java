package com.diegokrupitza.teletradertestproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: teletrader-test-project
 * Document: PlaceOrderResponse.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderResponse {

    private boolean success;

    private String errorMessage;

    private String uuid;

}
