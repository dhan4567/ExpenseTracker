package com.expenseTracker.service;

import com.expenseTracker.dto.UserRequestDto;
import com.expenseTracker.dto.UserResponseDto;
import com.expenseTracker.entity.User;
import com.expenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto createFamily(UserRequestDto dto) {
        User user= new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setMobNo(dto.getMobNo());
        user.setRole(dto.getRole());
        User savedFamily=userRepository.save(user);
        return ConvertToResponseDto(savedFamily);
    }

    @Override
    public List<UserResponseDto> getAllFamilies() {
        return userRepository.findAll()
                .stream()
                .map(this::ConvertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getFamilyById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NoSuchElementException("user not found" +userId));
        return ConvertToResponseDto(user);
    }

    @Override
    public UserResponseDto updateFamilyById(Long userId, UserRequestDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NoSuchElementException("user not found" +userId));
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setMobNo(dto.getMobNo());
        user.setRole(dto.getRole());
        User updatedUser = userRepository.save(user);
        return ConvertToResponseDto(updatedUser);
    }

    @Override
    public void deleteFamily(Long userId) {
        if(!userRepository.existsById(userId)){
            throw new NoSuchElementException("user not found" +userId);
        }
        userRepository.deleteById(userId);


    }
    private UserResponseDto ConvertToResponseDto(User savedFamily) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setUserId(savedFamily.getUserId());
        responseDto.setUserName(savedFamily.getUserName());
        responseDto.setEmail(savedFamily.getEmail());
        responseDto.setMobNo(savedFamily.getMobNo());
        responseDto.setRole(savedFamily.getRole());
        return responseDto;
    }


}
