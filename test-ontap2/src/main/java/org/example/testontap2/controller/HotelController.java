package org.example.ontap2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.ontap2.domain.dto.pagination.PaginationRequestDTO;
import org.example.ontap2.domain.dto.pagination.PaginationResponseDTO;
import org.example.ontap2.domain.dto.reponse.HotelResponseDTO;
import org.example.ontap2.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotels")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelController {

    HotelService hotelService;

    @Operation(summary = "Get all hotel")
    @GetMapping("getAll")
    public ResponseEntity<PaginationResponseDTO<HotelResponseDTO>> getAllHotels(
            @Parameter(description = "So trang(bat dau tu 0)") @RequestParam int page,
            @Parameter(description = "Kich thuoc trang") @RequestParam int size){
        PaginationRequestDTO requestDTO = new PaginationRequestDTO(page, size);
        return ResponseEntity.ok(hotelService.getAllHotels(requestDTO));
    }

}
