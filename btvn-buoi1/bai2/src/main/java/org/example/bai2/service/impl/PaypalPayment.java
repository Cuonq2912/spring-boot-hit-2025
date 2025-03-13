package org.example.bai2.service.impl;

import org.example.bai2.service.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PaypalPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Thanh toán qua Paypal..");
    }
}
