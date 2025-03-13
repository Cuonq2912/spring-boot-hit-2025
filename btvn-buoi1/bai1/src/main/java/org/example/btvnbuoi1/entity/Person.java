package org.example.btvnbuoi1.entity;

import org.example.btvnbuoi1.service.Engine;
import org.example.btvnbuoi1.service.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private final Vehicle vehicle;
    private final Engine engine;

    @Autowired
    public Person(@Qualifier("car") Vehicle vehicle, @Qualifier("gasolineEngine")Engine engine){
        this.vehicle = vehicle;
        this.engine = engine;
    }
   public void driveVehicle(){
        vehicle.drive();
   }
   public void useEngine(){
       engine.use();
   }

}
