package com.example.hackerrank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hackerrank.Model.User;

public interface UserRepository extends JpaRepository <User, Long> {
    
}
