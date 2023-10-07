package com.kshitiz.blog.services;

import java.util.List;



import com.kshitiz.blog.payloads.CategoryDto;


public interface CategoryServices {

	//create
	
	CategoryDto createCat(CategoryDto catdto);
	
	//update
	
	CategoryDto updateCat(CategoryDto catdto, Integer catId);
	
	//delete
	
	void dltCat(Integer catId);
	
	//get by id
	
	CategoryDto getCat(Integer catId);
	
	//get all
	
	List<CategoryDto> getAll();
	
}
