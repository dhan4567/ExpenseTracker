package com.expenseTracker.service;

import com.expenseTracker.dto.FamilyRequestDto;
import com.expenseTracker.dto.FamilyResponseDto;
import com.expenseTracker.dto.UserRequestDto;
import com.expenseTracker.dto.UserResponseDto;
import com.expenseTracker.entity.Family;
import com.expenseTracker.entity.User;
import com.expenseTracker.repository.FamilyRepository;
import com.expenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FamilyService implements FamilyServiceImp {

    private final FamilyRepository familyRepository;
    private final UserRepository userRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository, UserRepository userRepository) {
        this.familyRepository = familyRepository;
        this.userRepository = userRepository;
    }


    @Override
    public FamilyResponseDto createFamily(FamilyRequestDto dto) {

        // Check if user exists, if not create a new user
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + dto.getUserId()));

        Family family = new Family();
        family.setFamilyName(dto.getFamilyName());
        family.setDescription(dto.getDescription());
        family.setUser(user); // Set the owner/creator of the family
        Family savedFamily = familyRepository.save(family);
        return convertToResponseDto(savedFamily);
    }

    @Override
    public List<FamilyResponseDto> getAllFamilies() {
        return familyRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());

    }
    @Override
    public FamilyResponseDto getFamilyById(Long family_id) {
        Family family = familyRepository.findById(family_id)
                .orElseThrow(() -> new NoSuchElementException("family not found:" + family_id));
        return convertToResponseDto(family);
    }

    @Override
    public FamilyResponseDto updateFamily(Long family_id,FamilyRequestDto dto) {
        Family family = familyRepository.findById(family_id)
                .orElseThrow(() -> new NoSuchElementException("family not found:" + family_id));
        family.setFamilyName(dto.getFamilyName());
        family.setDescription(dto.getDescription());
        Family updatedFamily = familyRepository.save(family);
        return convertToResponseDto(updatedFamily);

    }
    @Override
    public void deleteFamily(Long family_id) {
        if(!familyRepository.existsById(family_id)) {
            throw new NoSuchElementException("family not found:" + family_id);
        }
        familyRepository.deleteById(family_id);
    }
    //HELPER METHOD TO CONVERT ENTITY TO DTO
    private FamilyResponseDto convertToResponseDto(Family family) {
        // Convert family owner/creator user


        // Convert family members
        List<UserResponseDto> memberDtos = (family.getMembers() == null) ?
                List.of() :
                family.getMembers().stream()
                        .map(this::convertUserToResponseDto)
                        .collect(Collectors.toList());

        return new FamilyResponseDto(
                family.getFamily_id(),
                family.getFamilyName(),
                family.getDescription(),
                memberDtos
        );
    }

    //HELPER METHOD TO CONVERT USER ENTITY TO USER DTO
    private UserResponseDto convertUserToResponseDto(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getMobNo(),
                user.getRole()
        );
    }
}
