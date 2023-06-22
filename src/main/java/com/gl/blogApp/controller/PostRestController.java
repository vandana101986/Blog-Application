package com.gl.blogApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.blogApp.model.Post;
import com.gl.blogApp.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/admin/posts")
public class PostRestController {
	
	private final PostService postService;
	
	//API call feeder/entry point - returns Object format
	@GetMapping
	public List<Post> fetchAllPost(){
		List<Post> posts = this.postService.findAllPost();
		return posts;
	}

}
