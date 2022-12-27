package com.cs.social.media.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cs.social.media.entity.Post;
import com.cs.social.media.entity.SocialMediaUser;
import com.cs.social.media.repository.UserDetailsRepo;

@SpringBootApplication
@EntityScan(basePackageClasses = { SocialMediaUser.class, Post.class })
@EnableJpaRepositories("com.cs.social.media.repository")
@ComponentScan("com.cs.social.media.*")
public class SocialMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
	}

}
