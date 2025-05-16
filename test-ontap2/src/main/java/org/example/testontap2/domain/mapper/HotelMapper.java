package org.example.ontap2.domain.mapper;

import org.example.ontap2.domain.dto.reponse.HotelResponseDTO;
import org.example.ontap2.domain.entity.Hotel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    List<HotelResponseDTO> toDoListHotelResponseDTO(List<Hotel> hotels);
}
