package com.gl.blogApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.blogApp.model.Post;
import com.gl.blogApp.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/posts")
public class PostController {
	
	private final PostService postService;
	
	@GetMapping
	public String fetchAllPosts(Model model) {
		List<Post> posts = this.postService.findAllPost();
		model.addAttribute("posts", posts);
		return "admin/posts";
	}
}
