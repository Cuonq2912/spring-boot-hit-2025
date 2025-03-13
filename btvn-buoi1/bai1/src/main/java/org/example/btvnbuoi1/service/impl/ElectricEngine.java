package org.example.btvnbuoi1.service.impl;

import org.example.btvnbuoi1.service.Engine;
import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine {
    @Override
    public void use() {
        System.out.println("Use electricEngine ");
    }
}
