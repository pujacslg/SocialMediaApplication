package com.cs.social.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.social.media.entity.Post;

public interface PostDetailsRepo extends JpaRepository<Post, String> {
	List<Post> findByUserUserId(String userId);

}
