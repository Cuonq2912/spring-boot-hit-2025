package org.example.btvnonline1.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnonline1.base.RestApiV1;
import org.example.btvnonline1.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HotelController {

    HotelService hotelService;

    @GetMapping()
    public ResponseEntity<?> getAllHotel(){

    }

}
