package org.example.bai2;

import org.example.bai2.entity.Customer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MainApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.bai2");
        Customer customer = context.getBean(Customer.class);
        customer.orderFood();
        customer.makePayment();
    }

}
