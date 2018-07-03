package com.diegokrupitza.teletradertestproject.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: teletrader-test-project
 * Document: TeletraderBackendExpetion.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Data
public class TeletraderBackendExpetion extends Exception {

    private String message;

    public TeletraderBackendExpetion(String message) {
        super(message);
        this.message = message;
    }
}
