package org.example.btvnonline1.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnonline1.constant.CommonConstant;
import org.example.btvnonline1.constant.CommonMessage;
import org.example.btvnonline1.constant.ErrorMessage;
import org.example.btvnonline1.domain.dto.pagination.PaginationRequestDTO;
import org.example.btvnonline1.domain.dto.pagination.PaginationResponseDTO;
import org.example.btvnonline1.domain.dto.pagination.PagingMeta;
import org.example.btvnonline1.domain.dto.request.HotelCreateDTO;
import org.example.btvnonline1.domain.dto.request.HotelSearchRequestDTO;
import org.example.btvnonline1.domain.dto.request.HotelUpdateDTO;
import org.example.btvnonline1.domain.dto.response.CommonResponseDTO;
import org.example.btvnonline1.domain.dto.response.HotelResponseDTO;
import org.example.btvnonline1.domain.entity.Hotel;
import org.example.btvnonline1.domain.mapper.HotelMapper;
import org.example.btvnonline1.exception.NotFoundException;
import org.example.btvnonline1.exception.ResourceNotFoundException;
import org.example.btvnonline1.repository.HotelRepository;
import org.example.btvnonline1.service.HotelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HotelServiceImpl implements HotelService {

    HotelRepository hotelRepository;
    HotelMapper hotelMapper;

    @Override
    public PaginationResponseDTO<HotelResponseDTO> getAllHotels(PaginationRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(
                requestDTO.getPageNum(),
                requestDTO.getPageSize(),
                Sort.by("createdDate").descending());
        Page<Hotel> result = hotelRepository.findAll(pageable);

        checkPageHotelIsEmpty(result);

        List<HotelResponseDTO> hotelResponseDTOList = hotelMapper.toHotelResponseDtoList(result.getContent());
        PaginationResponseDTO<HotelResponseDTO> responseDTO = new PaginationResponseDTO<>(
                hotelResponseDTOList,
                new PagingMeta(
                        result.getTotalElements(),
                        result.getTotalPages(),
                        requestDTO.getPageNum() + 1,
                        requestDTO.getPageSize(),
                        "createdDate",
                        "desc")
        );
        return responseDTO;
    }

    @Override
    public HotelResponseDTO getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        checkHotelNotFound(hotel, id);
        return hotelMapper.toHotelResponseDto(hotel.get());
    }

    @Override
    public HotelResponseDTO createHotel(HotelCreateDTO hotelCreateDTO) {
        Hotel hotel = hotelMapper.toHotel(hotelCreateDTO);
        LocalDateTime nowTime = LocalDateTime.now();
        hotel.setCreatedDate(nowTime);
        hotel.setLastModifiedDate(nowTime);
        return hotelMapper.toHotelResponseDto(hotelRepository.save(hotel));
    }

    @Override
    public HotelResponseDTO updateHotel(Long id, HotelUpdateDTO hotelUpdateDTO) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        checkHotelNotFound(hotel, id);
        hotelMapper.updateHotelFromDTO(hotelUpdateDTO, hotel.get());
        hotel.get().setCreatedDate(LocalDateTime.now());
        return hotelMapper.toHotelResponseDto(hotelRepository.save(hotel.get()));
    }

    @Override
    public CommonResponseDTO deleteHotel(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        checkHotelNotFound(hotel, id);
        hotelRepository.delete(hotel.get());
        return new CommonResponseDTO(CommonConstant.TRUE, CommonMessage.DELETE_SUCCESS);
    }

    @Override
    public PaginationResponseDTO<HotelResponseDTO> searchHotels(HotelSearchRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(
                requestDTO.getPageNum(),
                requestDTO.getPageSize(),
                Sort.by("createdDate").descending());
        Page<Hotel> result = hotelRepository.searchHotels(
                requestDTO.getName(),
                requestDTO.getLocation(),
                requestDTO.getPrice(),
                pageable
        );
        checkPageHotelIsEmpty(result);

        List<HotelResponseDTO> hotelResponseDTOs = hotelMapper.toHotelResponseDtoList(result.getContent());
        PaginationResponseDTO<HotelResponseDTO> responseDTO = new PaginationResponseDTO<>(
                hotelResponseDTOs,
                new PagingMeta(
                        result.getTotalElements(),
                        result.getTotalPages(),
                        requestDTO.getPageNum() + 1,
                        requestDTO.getPageSize(),
                        "createdDate",
                        "desc"
                )
        );
        return responseDTO;
    }

    private void checkHotelNotFound(Optional<Hotel> hotel, Long id){
        if(hotel.isEmpty()){
            throw new NotFoundException(ErrorMessage.Hotel.ERR_NOT_FOUND_ID, id);
        }
    }

    private void checkPageHotelIsEmpty(Page<Hotel> hotels){
        if(hotels.isEmpty()){
            throw new ResourceNotFoundException(ErrorMessage.Hotel.ERR_NOT_FOUND);
        }
    }
}
