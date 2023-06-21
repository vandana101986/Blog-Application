package com.gl.blogApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.blogApp.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	
}
