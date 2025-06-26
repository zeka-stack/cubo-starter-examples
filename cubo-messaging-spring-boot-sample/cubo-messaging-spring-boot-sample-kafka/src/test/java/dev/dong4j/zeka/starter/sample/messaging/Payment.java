package dev.dong4j.zeka.starter.sample.messaging;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Payment {
    // Getters
    private Long id;
    private Double amount;

    public Payment(Long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

}
