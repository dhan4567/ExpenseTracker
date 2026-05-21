package com.expenseTracker.repository;


import com.expenseTracker.entity.PassBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassbookRepository extends JpaRepository<PassBook, Long> {

}

