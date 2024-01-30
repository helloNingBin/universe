package com.example.demospringboot.chain;

import org.springframework.stereotype.Component;

@Component
public class PaymentHandlerB implements PaymentHandler {
    @Override
    public void handlePayment(String orderNo) {
        System.out.println("PaymentHandlerB:"+orderNo);
    }
}
