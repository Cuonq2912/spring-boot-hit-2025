package org.example.btvnbuoi5.service.work;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.constant.CommonConstant;
import org.example.btvnbuoi5.constant.CommonMessage;
import org.example.btvnbuoi5.constant.ErrorMessage;
import org.example.btvnbuoi5.domain.dto.PositionCreateDto;
import org.example.btvnbuoi5.domain.dto.PositionDto;
import org.example.btvnbuoi5.domain.dto.PositionUpdateDto;
import org.example.btvnbuoi5.domain.dto.response.CommonResponseDto;
import org.example.btvnbuoi5.domain.entity.Position;
import org.example.btvnbuoi5.domain.mapper.PositionMapper;
import org.example.btvnbuoi5.exception.NotFoundException;
import org.example.btvnbuoi5.repository.PositionRepository;
import org.example.btvnbuoi5.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PositionWork implements PositionService {

    PositionRepository positionRepository;
    PositionMapper positionMapper;

    @Override
    public List<PositionDto> getAllPosition() {
        return positionRepository.findAll().stream()
                .map(positionMapper::toPositionDto)
                .toList();
    }

    @Override
    public PositionDto getPositionById(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        checkPositionNotFound(position, id);
        return positionMapper.toPositionDto(position.get());

    }

    @Override
    public PositionDto createPosition(PositionCreateDto positionDto) {
        Position position = positionMapper.toPosition(positionDto);
        return positionMapper.toPositionDto(positionRepository.save(position));
    }

    @Override
    public PositionDto updatePosition(Long id, PositionUpdateDto positionDto) {
        Optional<Position> position = positionRepository.findById(id);
        checkPositionNotFound(position, id);
        positionMapper.updatePositionFromDto(positionDto, position.get());
        return positionMapper.toPositionDto(positionRepository.save(position.get()));
    }

    @Override
    public CommonResponseDto deletePosition(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        checkPositionNotFound(position, id);
        positionRepository.deleteById(id);
        return new CommonResponseDto(CommonConstant.TRUE, CommonMessage.DELETE_SUCCESS);
    }

    private void checkPositionNotFound(Optional<Position> position, Long id){
        if(position.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Position.ERR_NOT_FOUND_ID, id));
        }
    }
}
