package com.cs.social.media.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class SocialMediaUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String userId;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();

	@JoinTable(name = "followers", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "followerUserId") })
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SocialMediaUser> following = new HashSet<>();

	public void addFollower(SocialMediaUser toFollow) {
		following.add(toFollow);

	}

	public void removeFollower(SocialMediaUser toFollow) {
		following.remove(toFollow);

	}

	public Set<SocialMediaUser> getFollowing() {
		return following;
	}

	public void setFollowing(Set<SocialMediaUser> following) {
		this.following = following;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
