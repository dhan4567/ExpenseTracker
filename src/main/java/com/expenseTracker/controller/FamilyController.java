package com.expenseTracker.controller;

import com.expenseTracker.dto.FamilyRequestDto;
import com.expenseTracker.dto.FamilyResponseDto;
import com.expenseTracker.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/families")
@CrossOrigin(origins = "*")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @PostMapping
    public FamilyResponseDto createFamily(@RequestBody FamilyRequestDto dto) {
        return familyService.createFamily(dto);
    }

    @GetMapping
    public List<FamilyResponseDto> getAllFamilies() {
        return familyService.getAllFamilies();

    }

    @GetMapping("/{id}")
    public FamilyResponseDto getFamilyById(@PathVariable Long id) {
        return familyService.getFamilyById(id);
    }

    @PutMapping("/{id}")
    public FamilyResponseDto updateFamily(@PathVariable Long id, @RequestBody FamilyRequestDto dto) {
        return familyService.updateFamily(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteFamily(@PathVariable Long id) {
        familyService.deleteFamily(id);
        return "family deleted successfully";
    }

}
