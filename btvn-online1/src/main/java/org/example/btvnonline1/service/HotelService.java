package org.example.btvnonline1.service;

import org.example.btvnonline1.domain.dto.pagination.PaginationRequestDTO;
import org.example.btvnonline1.domain.dto.pagination.PaginationResponseDTO;
import org.example.btvnonline1.domain.dto.request.HotelCreateDTO;
import org.example.btvnonline1.domain.dto.request.HotelSearchRequestDTO;
import org.example.btvnonline1.domain.dto.request.HotelUpdateDTO;
import org.example.btvnonline1.domain.dto.response.CommonResponseDTO;
import org.example.btvnonline1.domain.dto.response.HotelResponseDTO;

public interface HotelService {

    PaginationResponseDTO<HotelResponseDTO> getAllHotels(PaginationRequestDTO requestDTO);
    HotelResponseDTO getHotelById(Long id);
    HotelResponseDTO createHotel(HotelCreateDTO hotelCreateDTO);
    HotelResponseDTO updateHotel(Long id, HotelUpdateDTO hotelUpdateDTO);
    CommonResponseDTO deleteHotel(Long id);
    PaginationResponseDTO<HotelResponseDTO> searchHotels(HotelSearchRequestDTO requestDTO);
}
