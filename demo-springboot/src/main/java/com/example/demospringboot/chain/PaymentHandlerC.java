package com.example.demospringboot.chain;

import org.springframework.stereotype.Component;

@Component
public class PaymentHandlerC implements PaymentHandler {
    @Override
    public void handlePayment(String orderNo) {
        System.out.println("PaymentHandlerC:"+orderNo);
    }
}
