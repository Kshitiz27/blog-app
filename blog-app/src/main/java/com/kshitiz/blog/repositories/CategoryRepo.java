package com.kshitiz.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshitiz.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
