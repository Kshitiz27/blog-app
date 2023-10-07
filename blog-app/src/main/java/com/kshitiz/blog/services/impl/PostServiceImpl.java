package com.kshitiz.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(cat);
		
		Post newPost = this.postRepo.save(post);
		return this.mdlmap.map(newPost, PostDto.class);
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		Post post = this.postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundExcpetion("Post","Id",postId));
				
				post.setContent(postDto.getContent());
				post.setTitle(postDto.getTitle());
				
				Post svPost = this.postRepo.save(post);
				return this.mdlmap.map(svPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundExcpetion("Post","Id",postId));
		
		this.postRepo.delete(post);
				
		
	}

	@Override
	public List<PostDto> getAllPost() {
		
		List<Post> posts = this.postRepo.findAll();
		List<PostDto> postdtos = posts.stream().map((post) -> this.mdlmap.map(post,PostDto.class))
				.collect(Collectors.toList());
		return postdtos;
		
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post = this.postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundExcpetion("Post","Id",postId));
		
		return this.mdlmap.map(post, PostDto.class);
		
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		Category cat = this.catRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundExcpetion("Category","Id",categoryId));
		List<Post> posts = this.postRepo.findbyCategory(cat);
		List<PostDto> postdtos = posts.stream().map((post) -> this.mdlmap.map(post,PostDto.class))
				.collect(Collectors.toList());
		return postdtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		
		User usr = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundExcpetion("User","Id",userId));
		List<Post> posts = this.postRepo.findbyUser(usr);
		List<PostDto> postdtos = posts.stream().map((post) -> this.mdlmap.map(post,PostDto.class))
				.collect(Collectors.toList());
		return postdtos;
	}
	}

	

