package com.diegokrupitza.teletradertestproject.sockets;

import com.diegokrupitza.teletradertestproject.domain.UserOrder;
import com.diegokrupitza.teletradertestproject.dto.OrderBook;
import com.diegokrupitza.teletradertestproject.dto.PlaceOrderResponse;
import com.diegokrupitza.teletradertestproject.dto.UserOrderDTO;
import com.diegokrupitza.teletradertestproject.dto.UserOrderDTOTransformer;
import com.diegokrupitza.teletradertestproject.helpers.TeletraderBackendExpetion;
import com.diegokrupitza.teletradertestproject.service.UserOrderService;
import com.diegokrupitza.teletradertestproject.service.UserOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * Project: teletrader-test-project
 * Document: UserOrderSocketController.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@Controller
@Slf4j
public class UserOrderSocketController {

    private static final int TOP_NUMBER = 10;

    @Autowired
    private UserOrderDTOTransformer userOrderDTOTransformer;

    @Autowired
    private UserOrderServiceImpl userOrderService;

    @Autowired
    private SimpMessagingTemplate messageTemplate;

    @MessageMapping("/placeOrder")
    @SendTo("/topic/replies")
    public PlaceOrderResponse placeOrder(UserOrderDTO userOrderDTO) {
        log.info("New Order Placed from: {}", userOrderDTO.getUuid());

        PlaceOrderResponse placeOrderResponse = new PlaceOrderResponse();
        placeOrderResponse.setUuid(userOrderDTO.getUuid());

        UserOrder userOrder = userOrderDTOTransformer.toLocal(userOrderDTO);
        try {
            userOrderService.placeNewOrder(userOrder);
            placeOrderResponse.setSuccess(true);
        } catch (TeletraderBackendExpetion teletraderBackendExpetion) {
            teletraderBackendExpetion.printStackTrace();
            placeOrderResponse.setSuccess(false);
            placeOrderResponse.setErrorMessage(teletraderBackendExpetion.getMessage());
        }
        return placeOrderResponse;
    }


    @MessageMapping("/orderBook")
    @Scheduled(fixedDelay = 1000)
    public OrderBook getOrderBook() {
        OrderBook orderBook = userOrderService.getOrderBook(TOP_NUMBER);
        messageTemplate.convertAndSend("/topic/orderBook", orderBook);
        return orderBook;
    }

}
