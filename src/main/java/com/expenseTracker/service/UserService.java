package com.expenseTracker.service;

import com.expenseTracker.dto.UserRequestDto;
import com.expenseTracker.dto.UserResponseDto;
import com.expenseTracker.entity.User;
import com.expenseTracker.repository.FamilyRepository;
import com.expenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        User user= new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setMobNo(dto.getMobNo());
        user.setRole(dto.getRole());

        User savedFamily=userRepository.save(user);
        return ConvertToResponseDto(savedFamily);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::ConvertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NoSuchElementException("user not found" +userId));
        return ConvertToResponseDto(user);
    }

    @Override
    public UserResponseDto updateUserById(Long userId, UserRequestDto dto) {
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
    public void deleteUser(Long userId) {
        if(!userRepository.existsById(userId)){
            throw new NoSuchElementException("user not found" +userId);
        }
        userRepository.deleteById(userId);


    }
    private UserResponseDto ConvertToResponseDto(User savedUser) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setUserId(savedUser.getUserId());
        responseDto.setUserName(savedUser.getUserName());
        responseDto.setEmail(savedUser.getEmail());
        responseDto.setMobNo(savedUser.getMobNo());
        responseDto.setRole(savedUser.getRole());

        return responseDto;
    }
}
