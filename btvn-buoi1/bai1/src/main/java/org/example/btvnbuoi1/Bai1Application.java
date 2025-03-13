package org.example.btvnbuoi1;

import org.example.btvnbuoi1.entity.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Bai1Application {

    public static void main(String[] args) {

//      ApplicationContext context = SpringApplication.run(Bai1Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.btvnbuoi1");
        Person person = context.getBean(Person.class);
        person.driveVehicle();
        person.useEngine();
    }
}
