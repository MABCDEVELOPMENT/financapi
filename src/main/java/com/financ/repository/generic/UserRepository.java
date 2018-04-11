package com.financ.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financ.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
