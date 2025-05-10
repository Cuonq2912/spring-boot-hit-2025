package org.example.btvnbuoi5.domain.mapper;

import org.example.btvnbuoi5.domain.dto.UserCreateDto;
import org.example.btvnbuoi5.domain.dto.UserDto;
import org.example.btvnbuoi5.domain.dto.UserUpdateDto;
import org.example.btvnbuoi5.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreateDto userDto);
    UserDto toUserDto(User user);
    void updateUserFromDto(UserUpdateDto userDto, @MappingTarget User user);
}
