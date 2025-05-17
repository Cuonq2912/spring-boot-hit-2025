package org.example.btvnonline1.controller;

import com.cloudinary.Url;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnonline1.base.RestApiV1;
import org.example.btvnonline1.constant.UrlConstant;
import org.example.btvnonline1.domain.dto.pagination.PaginationRequestDTO;
import org.example.btvnonline1.domain.dto.request.HotelCreateDTO;
import org.example.btvnonline1.domain.dto.request.HotelSearchRequestDTO;
import org.example.btvnonline1.domain.dto.request.HotelUpdateDTO;
import org.example.btvnonline1.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HotelController {

    HotelService hotelService;

    @Operation(summary = "Api get all hotel")
    @GetMapping(UrlConstant.Hotel.GET_HOTELS)
    public ResponseEntity<?> getAllHotel(
            @Parameter(description = "Page number") @RequestParam int page,
            @Parameter(description = "Size of page") @RequestParam int size
    ){
        PaginationRequestDTO requestDTO = new PaginationRequestDTO(page, size);
        return ResponseEntity.ok(hotelService.getAllHotels(requestDTO));
    }

    @Operation(summary = "Api get hotel by id")
    @GetMapping(UrlConstant.Hotel.GET_HOTEL)
    public ResponseEntity<?> getHotelById(@PathVariable Long hotelId){
        return ResponseEntity.ok(hotelService.getHotelById(hotelId));
    }

    @Operation(summary = "Api search hotel")
    @GetMapping(UrlConstant.Hotel.GET_HOTELS + "/search")
    public ResponseEntity<?> searchHotel(
            @Parameter(description = "Page number") @RequestParam int page,
            @Parameter(description = "Size of page") @RequestParam int size,
            @Parameter(description = "Hotel's name") @RequestParam(required = false) String name,
            @Parameter(description = "Hotel's location") @RequestParam(required = false) String location,
            @Parameter(description = "Hotel's price") @RequestParam(required = false) Double price
    ){
        HotelSearchRequestDTO requestDTO = new HotelSearchRequestDTO(page, size);
        requestDTO.setName(name);
        requestDTO.setLocation(location);
        requestDTO.setPrice(price);
        return ResponseEntity.ok(hotelService.searchHotels(requestDTO));
    }

    @Operation(summary = "Api create new hotel")
    @PostMapping(UrlConstant.Hotel.CREATE_HOTEL)
    public ResponseEntity<?> createHotel(
            @Parameter(description = "New hotel's information") @Valid @RequestBody HotelCreateDTO hotelCreateDTO) {
        return ResponseEntity.ok(hotelService.createHotel(hotelCreateDTO));
    }

    @Operation(summary = "Api update hotel by id")
    @PutMapping(UrlConstant.Hotel.UPDATE_HOTEL)
    public ResponseEntity<?> updateHotel(
            @PathVariable long hotelId,
            @Parameter(description = "hotel's information to update") @Valid @RequestBody HotelUpdateDTO hotelUpdateDTO) {
        return ResponseEntity.ok(hotelService.updateHotel(hotelId,  hotelUpdateDTO));
    }

    @Operation(summary = "Api delete hotel by id")
    @DeleteMapping(UrlConstant.Hotel.DELETE_HOTEL)
    public ResponseEntity<?> deleteHotel(@PathVariable long hotelId){
        return ResponseEntity.ok(hotelService.deleteHotel(hotelId));
    }


}
