package org.example.ontap2.domain.dto;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hotel {
    String id;
    String name;
    String location;
    Double price;
}
