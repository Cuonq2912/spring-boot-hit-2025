package org.example.bai2.entity;

import org.example.bai2.service.Order;
import org.example.bai2.service.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Customer {
    private final Order order;
    private final PaymentMethod paymentMethod;

    @Autowired
    public Customer(@Qualifier("fastFoodOrder") Order order, @Qualifier("paypalPayment") PaymentMethod paymentMethod){
        this.order = order;
        this.paymentMethod = paymentMethod;
    }

    public void orderFood(){
        order.placeOrder();
    }

    public void makePayment(){
        paymentMethod.pay();
    }
}
