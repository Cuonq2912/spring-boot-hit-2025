package org.example.btvnonline1.domain.mapper;

import org.example.btvnonline1.domain.dto.request.HotelCreateDTO;
import org.example.btvnonline1.domain.dto.request.HotelUpdateDTO;
import org.example.btvnonline1.domain.dto.response.HotelResponseDTO;
import org.example.btvnonline1.domain.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    Hotel toHotel(HotelCreateDTO hotelCreateDTO);
    HotelResponseDTO toHotelResponseDto(Hotel hotel);
    List<HotelResponseDTO> toHotelResponseDtoList(List<Hotel> hotelList);
    void updateHotelFromDTO(HotelUpdateDTO hotelUpdateDTO, @MappingTarget Hotel hotel);
}
