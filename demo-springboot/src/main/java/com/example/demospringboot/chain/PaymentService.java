package com.example.demospringboot.chain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private List<PaymentHandler> paymentHandlerList;

    @PostConstruct
    public void print(){
        System.out.println(paymentHandlerList);
        paymentHandlerList.forEach(p->{
            p.handlePayment("123");
        });
    }
}
