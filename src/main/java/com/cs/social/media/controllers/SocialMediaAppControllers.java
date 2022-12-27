package com.cs.social.media.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.social.media.entity.SocialMediaUser;
import com.cs.social.media.model.PostDto;
import com.cs.social.media.model.UserOperationsDto;
import com.cs.social.media.service.PostService;
import com.cs.social.media.service.UserService;

@RestController
@RequestMapping("/socialMediaApp/services")
public class SocialMediaAppControllers {
	@Autowired
	private UserService userDao;
	@Autowired
	private PostService postDao;

	@PostMapping("/createPost")
	public ResponseEntity createPost(@RequestBody PostDto postDetails) {
		postDao.createPost(postDetails);
		return new ResponseEntity("Post Created Successfully", HttpStatus.CREATED);
	}

	@PostMapping("/follow")
	public ResponseEntity followUser(@RequestBody UserOperationsDto userDetails) {
		userDao.followUsers(userDetails);
		return new ResponseEntity("Followed User Successfully", HttpStatus.CREATED);
	}

	@PostMapping("/unfollow")
	public ResponseEntity unfollowUser(@RequestBody UserOperationsDto userDetails) {
		userDao.unfollowUsers(userDetails);
		return new ResponseEntity("Unfollowed User Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getNewsFeed")
	public ResponseEntity getNewsFeed(@RequestBody PostDto postDetails) {

		return new ResponseEntity(postDao.getNewsFeed(postDetails), HttpStatus.CREATED);
	}

	@PostMapping("/createUser")
	public ResponseEntity createUser(@RequestBody List<SocialMediaUser> userDetailsList) {
		userDao.createUsers(userDetailsList);
		return new ResponseEntity("Users Created Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getUsers")
	public ResponseEntity getUsers() {

		return new ResponseEntity(userDao.getUsers(), HttpStatus.CREATED);
	}

}
