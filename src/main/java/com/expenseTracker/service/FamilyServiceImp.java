package com.expenseTracker.service;

import com.expenseTracker.dto.FamilyRequestDto;
import com.expenseTracker.dto.FamilyResponseDto;

import java.util.List;

public interface FamilyServiceImp {

    FamilyResponseDto createFamily(FamilyRequestDto dto) ;

    List<FamilyResponseDto> getAllFamilies();

    FamilyResponseDto getFamilyById(Long family_id);

    FamilyResponseDto updateFamily(Long family_id,FamilyRequestDto dto);

    void deleteFamily(Long family_id);


}
