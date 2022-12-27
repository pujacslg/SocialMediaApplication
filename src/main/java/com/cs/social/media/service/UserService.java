package com.cs.social.media.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.social.media.entity.SocialMediaUser;
import com.cs.social.media.exception.SocialMediaAppUserAlreadyExistsException;
import com.cs.social.media.exception.SocialMediaAppUserDoesNotExistException;
import com.cs.social.media.model.UserOperationsDto;
import com.cs.social.media.repository.UserDetailsRepo;

@Component
public class UserService {
	@Autowired
	private UserDetailsRepo userRepo;

	public void createUsers(List<SocialMediaUser> userDetails) {
		List<SocialMediaUser> existingUsers = userRepo.findAll();
		for (SocialMediaUser user : userDetails) {
			if (!existingUsers.stream().anyMatch(l -> l.getUserId().equals(user.getUserId())))
				userRepo.save(user);
			else
				throw new SocialMediaAppUserAlreadyExistsException(user.getUserId());
		}

	}

	public void followUsers(UserOperationsDto userDetails) {
		SocialMediaUser user;
		SocialMediaUser toFollow;
		if (userRepo.findById(userDetails.getUserId()).isPresent())
			user = userRepo.findById(userDetails.getUserId()).get();
		else
			throw new SocialMediaAppUserDoesNotExistException();
		if (userRepo.findById(userDetails.getFollowerId()).isPresent()) {
			toFollow = userRepo.findById(userDetails.getFollowerId()).get();
			user.addFollower(toFollow);
			userRepo.save(user);
		} else
			throw new SocialMediaAppUserDoesNotExistException();

	}

	public void unfollowUsers(UserOperationsDto userDetails) {
		SocialMediaUser user;
		SocialMediaUser toUnfollow;

		if (userRepo.findById(userDetails.getUserId()).isPresent())
			user = userRepo.findById(userDetails.getUserId()).get();
		else
			throw new SocialMediaAppUserDoesNotExistException();
		if (userRepo.findById(userDetails.getFollowerId()).isPresent()) {
			toUnfollow = userRepo.findById(userDetails.getFollowerId()).get();
			user.removeFollower(toUnfollow);
			userRepo.save(user);
		}

	}

	public List<SocialMediaUser> getUsers() {
		return userRepo.findAll();
	}

}
