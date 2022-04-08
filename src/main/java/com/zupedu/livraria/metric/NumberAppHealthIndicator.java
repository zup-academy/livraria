package com.zupedu.livraria.metric;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberAppHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        int number = getRandomNumber();

        if (number > 5) {
            builder.up().build();
        } else {
            builder.down().withDetail("error", "Number was less than 5").build();
        }
    }

    private int getRandomNumber() {
        return new Random().ints(1, 10).findFirst().orElseThrow(() -> new RuntimeException("Failed to generate random number"));
    }
}
