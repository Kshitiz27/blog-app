package com.kshitiz.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryDto {

	private int catId;
	@NotEmpty(message = "cannot be empty value")
	private String catTitle;
	@NotEmpty(message = "cannot be empty value")
	private String catDesc;
	
}
