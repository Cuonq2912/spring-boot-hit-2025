package org.example.btvnbuoi1.service.impl;

import org.example.btvnbuoi1.service.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class Motorbike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding the motorbike ");
    }
}
