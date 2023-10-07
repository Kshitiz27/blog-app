package com.kshitiz.blog.services;

import java.util.List;

import com.kshitiz.blog.entities.Post;
import com.kshitiz.blog.payloads.PostDto;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//getAll
	List<PostDto> getAllPost();
	
	//single post
	PostDto getPostById(Integer postId);
	
	//get post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get post by user
	List<PostDto> getPostsByUser(Integer userId);
}
