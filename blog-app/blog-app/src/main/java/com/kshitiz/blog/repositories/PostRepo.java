package com.kshitiz.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshitiz.blog.entities.Category;
import com.kshitiz.blog.entities.Post;
import com.kshitiz.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findbyUser(User user);
	List<Post> findbyCategory(Category category);
	
}
