package com.kshitiz.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.kshitiz.blog.entities.Category;
import com.kshitiz.blog.entities.Post;
import com.kshitiz.blog.entities.User;
import com.kshitiz.blog.exceptions.ResourceNotFoundExcpetion;
import com.kshitiz.blog.payloads.PostDto;
import com.kshitiz.blog.repositories.CategoryRepo;
import com.kshitiz.blog.repositories.PostRepo;
import com.kshitiz.blog.repositories.UserRepo;
import com.kshitiz.blog.services.PostService;

public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	
	@Autowired
	private ModelMapper mdlmap;

	@Override
	public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId) {
		
		Category cat = this.catRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundExcpetion("Category","Id",categoryId));
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundExcpetion("User","Id",userId));
		
		Post post = this.mdlmap.map(postDto, Post.class);
		post.setImgName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(cat);
		
		Post newPost = this.postRepo.save(post);
		return this.mdlmap.map(newPost, PostDto.class);
		
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
