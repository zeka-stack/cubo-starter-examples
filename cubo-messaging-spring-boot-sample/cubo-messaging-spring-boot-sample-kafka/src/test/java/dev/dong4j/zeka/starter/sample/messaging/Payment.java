package dev.dong4j.zeka.starter.sample.messaging;

import lombok.Data;

@Data
public class Payment {
    // Getters
    private String id;
    private double amount;

    public Payment(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

}
