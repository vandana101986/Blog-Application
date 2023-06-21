package com.gl.blogApp.service;

import java.util.List;

import com.gl.blogApp.model.Post;

public interface PostService {
	
	Post createPost(Post post);
	
	Post findPostById(long id);
	
	List<Post> findAllPost();
	
	Post updatePost(long id, Post updatedPost);
	
	void deletePost(long id);
}
