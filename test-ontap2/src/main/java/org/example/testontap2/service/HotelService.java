package org.example.ontap2.service;

import org.example.ontap2.domain.dto.pagination.PaginationRequestDTO;
import org.example.ontap2.domain.dto.pagination.PaginationResponseDTO;
import org.example.ontap2.domain.dto.reponse.HotelResponseDTO;

public interface HotelService {
    PaginationResponseDTO<HotelResponseDTO> getAllHotels(PaginationRequestDTO paginationRequestDTO);
 }
