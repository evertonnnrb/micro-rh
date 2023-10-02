package com.microrh.payrpoll.service;

import com.microrh.payrpoll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long idWorker, int days){
        return new Payment("Bob",200.0, days);
    }
}
