package org.example.bai2.service.impl;

import org.example.bai2.service.Order;
import org.springframework.stereotype.Component;

@Component
public class HealthyFoodOrder implements Order {
    @Override
    public void placeOrder() {
        System.out.println("Đặt món ăn lành mạnh...");
    }
}
