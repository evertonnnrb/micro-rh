package com.microrh.payrpoll.service;

import com.microrh.payrpoll.entities.Payment;
import com.microrh.payrpoll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-wroker.host}")
    private String workerHost;

    public Payment getPayment(Long idWorker, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + idWorker);
        Worker worker = restTemplate
                .getForObject(workerHost + "/worker/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
