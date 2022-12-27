package com.cs.social.media.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.social.media.entity.SocialMediaUser;


public interface UserDetailsRepo extends JpaRepository<SocialMediaUser, String> {
	Optional<SocialMediaUser> findById(String id);

}
