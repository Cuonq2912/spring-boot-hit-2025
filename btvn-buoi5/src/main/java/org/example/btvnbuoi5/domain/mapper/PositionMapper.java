package org.example.btvnbuoi5.domain.mapper;

import org.example.btvnbuoi5.domain.dto.PositionCreateDto;
import org.example.btvnbuoi5.domain.dto.PositionDto;
import org.example.btvnbuoi5.domain.dto.PositionUpdateDto;
import org.example.btvnbuoi5.domain.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    Position toPosition(PositionCreateDto positionDto);
    PositionDto toPositionDto(Position position);
    void updatePosition(@MappingTarget Optional<Position> position, PositionUpdateDto positionDto);

}
