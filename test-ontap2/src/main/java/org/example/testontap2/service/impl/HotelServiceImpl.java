package org.example.ontap2.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.ontap2.constant.ErrorMessage;
import org.example.ontap2.domain.dto.pagination.PaginationRequestDTO;
import org.example.ontap2.domain.dto.pagination.PaginationResponseDTO;
import org.example.ontap2.domain.dto.pagination.PagingMeta;
import org.example.ontap2.domain.dto.reponse.HotelResponseDTO;
import org.example.ontap2.domain.entity.Hotel;
import org.example.ontap2.domain.mapper.HotelMapper;
import org.example.ontap2.exception.ResourceNotFoundException;
import org.example.ontap2.repository.HotelRepository;
import org.example.ontap2.service.HotelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HotelServiceImpl implements HotelService {
    HotelRepository hotelRepository;
    HotelMapper hotelMapper;

    @Override
    public PaginationResponseDTO<HotelResponseDTO> getAllHotels(PaginationRequestDTO paginationRequestDTO) {
        Pageable pageable = (Pageable) PageRequest.of(paginationRequestDTO.getPageNum(), paginationRequestDTO.getPageSize(), Sort.by("createDate").descending());
        Page<Hotel> pageResult = hotelRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        if(pageResult.isEmpty()){
            throw new ResourceNotFoundException(ErrorMessage.Hotel.ERR_NOT_FOUND);
        }
        List<HotelResponseDTO> hotelResponseDTOs = hotelMapper.toDoListHotelResponseDTO(pageResult.getContent());
        return new PaginationResponseDTO<>(
                hotelResponseDTOs,
                new PagingMeta(pageResult.getTotalElements(), pageResult.getTotalPages(),
                        paginationRequestDTO.getPageNum() + 1, paginationRequestDTO.getPageSize(),
                        "createDate", "desc")
        );
    }

}
