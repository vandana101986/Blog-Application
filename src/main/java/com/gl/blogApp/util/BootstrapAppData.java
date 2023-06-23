package com.gl.blogApp.util;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.github.javafaker.Faker;
import com.gl.blogApp.dao.PostRepository;
import com.gl.blogApp.model.Post;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {
	
	private final PostRepository postRepository;
	private final Faker faker = new Faker();
	@Value("${post.count}")
	private int count;
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void onReady(ApplicationReadyEvent event) {
		
		IntStream.range(0, count).forEach(index -> {
		Post post = Post.builder()
						.title(faker.book().title())
						.url(faker.internet().domainName())
						.content(faker.chuckNorris().fact())
						.shortDescription(faker.book().publisher())
						.build();
		this.postRepository.save(post);
		
		});
	}
	
}
