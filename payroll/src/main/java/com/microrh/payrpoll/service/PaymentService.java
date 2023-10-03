package com.microrh.payrpoll.service;

import com.microrh.payrpoll.entities.Payment;
import com.microrh.payrpoll.entities.Worker;
import com.microrh.payrpoll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long idWorker, int days) {
        Worker worker = workerFeignClient.getById(idWorker).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
