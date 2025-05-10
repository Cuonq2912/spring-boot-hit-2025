package org.example.btvnbuoi5.service.work;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.constant.CommonConstant;
import org.example.btvnbuoi5.constant.CommonMessage;
import org.example.btvnbuoi5.constant.ErrorMessage;
import org.example.btvnbuoi5.domain.dto.UserCreateDto;
import org.example.btvnbuoi5.domain.dto.UserDto;
import org.example.btvnbuoi5.domain.dto.UserUpdateDto;
import org.example.btvnbuoi5.domain.dto.response.CommonResponseDto;
import org.example.btvnbuoi5.domain.entity.User;
import org.example.btvnbuoi5.domain.mapper.UserMapper;
import org.example.btvnbuoi5.exception.NotFoundException;
import org.example.btvnbuoi5.repository.UserRepository;
import org.example.btvnbuoi5.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserWork implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        checkUserNotFound(user, id);
        return userMapper.toUserDto(user.get());

    }

    @Override
    public UserDto createUser(UserCreateDto userDto) {
        User user = userMapper.toUser(userDto);
        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userDto) {
        Optional<User> user = userRepository.findById(id);
        checkUserNotFound(user, id);
        userMapper.updateUserFromDto(userDto, user.get());
        return userMapper.toUserDto(userRepository.save(user.get()));
    }

    @Override
    public CommonResponseDto deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        checkUserNotFound(user, id);
        userRepository.deleteById(id);
        return new CommonResponseDto(CommonConstant.TRUE, CommonMessage.DELETE_SUCCESS);
    }

    private void checkUserNotFound(Optional<User> user, Long id) {
        if(user.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.User.ERR_NOT_FOUND_ID, id));
        }
    }
}
