package com.spring.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Likes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer likes_id;
	private String like_YN;
	private Integer user_id;
	private Integer game_id;
	
	
	public Integer getLikes_id() {
		return likes_id;
	}
	public void setLikes_id(Integer likes_id) {
		this.likes_id = likes_id;
	}
	public String getLike_YN() {
		return like_YN;
	}
	public void setLike_YN(String like_YN) {
		this.like_YN = like_YN;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	
	
}
