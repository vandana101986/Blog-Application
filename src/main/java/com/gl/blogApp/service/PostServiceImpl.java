package com.gl.blogApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.blogApp.dao.PostRepository;
import com.gl.blogApp.exception.InvalidPostException;
import com.gl.blogApp.model.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;
	
	@Override
	public Post createPost(Post post) {
		Post updatedPost = this.postRepository.save(post);
		return updatedPost;
	}

	@Override
	public Post findPostById(long id) {
		return this.postRepository.findById(id)
				.orElseThrow(() -> new InvalidPostException("Invalid post"));
	}

	@Override
	public List<Post> findAllPost() { 
		return this.postRepository.findAll();
	}

	@Override
	public Post updatePost(long id, Post updatedPost) {
		Post post = this.findPostById(id);
		post.setContent(updatedPost.getContent());
		post.setShortDescription(updatedPost.getShortDescription());
		return this.postRepository.save(post);
	}

	@Override
	public void deletePost(long id) {
		this.postRepository.deleteById(id);

	}

}
