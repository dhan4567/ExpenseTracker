package com.expenseTracker.repository;

import com.expenseTracker.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family,Long> {
    Family findByFamilyName(String familyName);
}

