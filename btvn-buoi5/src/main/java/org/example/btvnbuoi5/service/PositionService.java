package org.example.btvnbuoi5.service;

import org.example.btvnbuoi5.domain.dto.PositionCreateDto;
import org.example.btvnbuoi5.domain.dto.PositionDto;
import org.example.btvnbuoi5.domain.dto.PositionUpdateDto;
import org.example.btvnbuoi5.domain.dto.response.CommonResponseDto;

import java.util.List;

public interface PositionService {

    List<PositionDto> getAllPosition();
    PositionDto getPositionById(Long id);
    PositionDto createPosition(PositionCreateDto positionDto);
    PositionDto updatePosition(Long id, PositionUpdateDto positionDto);
    CommonResponseDto deletePosition(Long id);

}
