package com.perennial.sme_payroll.dao;

import com.perennial.sme_payroll.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
