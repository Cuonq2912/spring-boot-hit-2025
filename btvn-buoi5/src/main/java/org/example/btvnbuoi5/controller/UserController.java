package org.example.btvnbuoi5.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.btvnbuoi5.base.RestApiV1;
import org.example.btvnbuoi5.base.VsResponseUtil;
import org.example.btvnbuoi5.constant.UrlConstant;
import org.example.btvnbuoi5.domain.dto.UserCreateDto;
import org.example.btvnbuoi5.domain.dto.UserUpdateDto;
import org.example.btvnbuoi5.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @GetMapping(UrlConstant.User.GET_USERS)
    public ResponseEntity<?> getUsers() {
        return VsResponseUtil.ok(userService.getAllUser());
    }

    @GetMapping(UrlConstant.User.GET_USER)
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return VsResponseUtil.ok(userService.getUserById(userId));
    }

    @PostMapping(UrlConstant.User.CREATE_USER)
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        return VsResponseUtil.ok(userService.createUser(userCreateDto));
    }
    
    @PutMapping(UrlConstant.User.UPDATE_USER)
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserUpdateDto userUpdateDto, @PathVariable Long userId) {
        return VsResponseUtil.ok(userService.updateUser(userId, userUpdateDto));
    }

    @DeleteMapping(UrlConstant.User.DELETE_USER)
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return VsResponseUtil.ok(userService.deleteUser(userId));
    }
}
