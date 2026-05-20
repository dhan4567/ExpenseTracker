package com.expenseTracker.controller;


import com.expenseTracker.dto.UserRequestDto;
import com.expenseTracker.dto.UserResponseDto;
import com.expenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    public UserResponseDto getUserById( Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping
    public UserResponseDto updateUserById( Long userId, UserRequestDto dto) {
        return userService.updateUserById(userId, dto);
}

    @DeleteMapping
    public String deleteUser( Long userId) {
        userService.deleteUser(userId);
        return "user deleted successfully";
    }
}
