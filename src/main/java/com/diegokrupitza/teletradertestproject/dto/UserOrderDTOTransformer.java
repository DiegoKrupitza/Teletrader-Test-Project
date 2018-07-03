package com.diegokrupitza.teletradertestproject.dto;

import com.diegokrupitza.teletradertestproject.domain.OrderTyp;
import com.diegokrupitza.teletradertestproject.domain.UserOrder;
import com.diegokrupitza.teletradertestproject.helpers.DTOTransformer;
import org.springframework.stereotype.Component;

/**
 * Project: teletrader-test-project
 * Document: UserOrderDTOTransformer.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Component
public class UserOrderDTOTransformer implements DTOTransformer<UserOrder, UserOrderDTO> {

    @Override
    public UserOrder toLocal(UserOrderDTO object) {
        return UserOrder.builder()
                .amount(object.getAmount())
                .price(object.getPrice())
                .orderTyp(OrderTyp.valueOf(object.getOrderType()))
                .build();
    }

    @Override
    public UserOrderDTO toRemote(UserOrder object) {
        return UserOrderDTO.builder()
                .amount(object.getAmount())
                .orderType(object.getOrderTyp().getOrdertype())
                .price(object.getPrice())
                .build();
    }
}
