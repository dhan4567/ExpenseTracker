package com.expenseTracker.service;

import com.expenseTracker.dto.FamilyRequestDto;
import com.expenseTracker.dto.FamilyResponseDto;
import com.expenseTracker.dto.UserRequestDto;
import com.expenseTracker.entity.Family;
import com.expenseTracker.entity.User;
import com.expenseTracker.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FamilyService implements FamilyServiceImp {

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public FamilyResponseDto createFamily(FamilyRequestDto dto) {
        Family family = new Family();
        family.setFamilyName(dto.getFamilyName());
        family.setDescription(dto.getDescription());
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
        List<UserRequestDto> memberDtos = (family.getMembers() == null) ?
                List.of() :
                family.getMembers().stream()
                        .map(this::convertUserToDto)
                        .collect(Collectors.toList());

        return new FamilyResponseDto(
                family.getFamily_id(),
                family.getFamilyName(),
                family.getDescription(),
                memberDtos
        );
    }

    //HELPER METHOD TO CONVERT USER ENTITY TO USER DTO
    private UserRequestDto convertUserToDto(User user) {
        return new UserRequestDto(

                user.getUserName(),
                user.getEmail(),
                user.getMobNo(),
                user.getRole()

        );
    }
}
