
package com.cs.social.media.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String postId;
	private String content;
	private LocalDateTime timestamp;
	@ManyToOne
	@JoinColumn(name = "userId", insertable = true, updatable = true)
	private SocialMediaUser user;

	public Post() {
		super();
	}

	public Post(String postId, String content, LocalDateTime timestamp, SocialMediaUser user) {
		super();
		this.postId = postId;
		this.content = content;
		this.timestamp = timestamp;
		this.user = user;
	}

	

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public SocialMediaUser getUser() {
		return user;
	}

	public void setUser(SocialMediaUser user) {
		this.user = user;
	}

}
