package org.example.btvnonline1.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelUpdateDTO {

    String name;
    String location;
    Double price;
    LocalDate creatDate;
    LocalDate lastModifiedDate;

}
