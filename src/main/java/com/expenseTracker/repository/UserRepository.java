package com.expenseTracker.repository;

import com.expenseTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User FindByUserName(String userName);

}
