package com.cs.social.media.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.social.media.entity.Post;
import com.cs.social.media.entity.SocialMediaUser;
import com.cs.social.media.exception.SocialMediaAppUserDoesNotExistException;
import com.cs.social.media.model.PostDto;
import com.cs.social.media.repository.PostDetailsRepo;
import com.cs.social.media.repository.UserDetailsRepo;

@Component
public class PostService {

	@Autowired
	private PostDetailsRepo postRepo;
	@Autowired
	private UserDetailsRepo userRepo;

	public void createPost(PostDto postDetails) {
		SocialMediaUser user;

		if (userRepo.findById(postDetails.getUserId()).isPresent()) {
			user = userRepo.findById(postDetails.getUserId()).get();
			Post newPost = new Post(postDetails.getPostId(), postDetails.getContent(), LocalDateTime.now(), user);
			postRepo.save(newPost);
		} else {
			throw new SocialMediaAppUserDoesNotExistException();
		}

	}

	public List<String> getNewsFeed(PostDto postDetails) {

		List<String> userIds = new ArrayList<String>();
		if (userRepo.findById(postDetails.getUserId()).isPresent()) {
			SocialMediaUser user = userRepo.findById(postDetails.getUserId()).get();
			Set<SocialMediaUser> followees = user.getFollowing();
			List<String> followeeIds = followees.stream().map(k -> k.getUserId()).toList();//
			userIds.add(user.getUserId());
			List<Post> posts = Stream.of(userIds, followeeIds).flatMap(l -> l.stream())
					.flatMap(id -> postRepo.findByUserUserId(id).stream()).toList();
			return posts.stream().sorted((c1, c2) -> c2.getTimestamp().compareTo(c1.getTimestamp())).limit(20)
					.map(post -> post.getPostId()).toList();
		}

		else {
			throw new SocialMediaAppUserDoesNotExistException();
		}

	}

}
