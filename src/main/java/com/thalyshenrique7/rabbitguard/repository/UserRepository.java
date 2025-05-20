package com.thalyshenrique7.rabbitguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thalyshenrique7.rabbitguard.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
