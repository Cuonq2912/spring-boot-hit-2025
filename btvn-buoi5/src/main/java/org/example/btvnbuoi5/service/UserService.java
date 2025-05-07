package org.example.btvnbuoi5.service;

import org.example.btvnbuoi5.domain.dto.UserCreateDto;
import org.example.btvnbuoi5.domain.dto.UserDto;
import org.example.btvnbuoi5.domain.dto.UserUpdateDto;
import org.example.btvnbuoi5.domain.dto.response.CommonResponseDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUser();
    UserDto getUserById(Long id);
    UserDto createUser(UserCreateDto userDto);
    UserDto updateUser(Long id, UserUpdateDto userDto);
    CommonResponseDto deleteUser(Long id);



}
