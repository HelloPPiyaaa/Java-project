package com.spring.project.model;

import jakarta.persistence.Entity;


public class CommentGamesUsers {
	private Integer game_id ;
	private String username ;
	private String comment_content;
	
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	
	
	
}
