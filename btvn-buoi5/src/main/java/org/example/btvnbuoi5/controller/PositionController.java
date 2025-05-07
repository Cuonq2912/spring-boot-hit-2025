package org.example.btvnbuoi5.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.base.RestApiV1;
import org.example.btvnbuoi5.base.VsResponseUtil;
import org.example.btvnbuoi5.constant.UrlConstant;
import org.example.btvnbuoi5.domain.dto.PositionCreateDto;
import org.example.btvnbuoi5.domain.dto.PositionUpdateDto;
import org.example.btvnbuoi5.service.PositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestApiV1
public class PositionController {

    PositionService positionService;

    @GetMapping(UrlConstant.Position.GET_POSITIONS)
    public ResponseEntity<?> getPosition(){
        return VsResponseUtil.ok(positionService.getAllPosition());
    }

    @GetMapping(UrlConstant.Position.GET_POSITION)
    public ResponseEntity<?> getPositionById(@PathVariable Long positionId){
        return VsResponseUtil.ok(positionService.getPositionById(positionId));
    }

    @PostMapping(UrlConstant.Position.CREATE_POSITION)
    public ResponseEntity<?> createPosition(@Valid PositionCreateDto positionCreateDto){
        return VsResponseUtil.ok(positionService.createPosition(positionCreateDto));
    }

    @PutMapping(UrlConstant.Position.UPDATE_POSITION)
    public ResponseEntity<?> updatePosition(@Valid PositionUpdateDto positionUpdateDto, @PathVariable Long positionId){
        return VsResponseUtil.ok(positionService.updatePosition(positionId, positionUpdateDto));
    }

    @DeleteMapping(UrlConstant.Position.DELETE_POSITION)
    public ResponseEntity<?> deletePosition(@PathVariable Long positionId){
        return VsResponseUtil.ok(positionService.deletePosition(positionId));
    }


}
