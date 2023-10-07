package com.kshitiz.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshitiz.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
