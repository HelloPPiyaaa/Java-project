package com.spring.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Games {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer game_id;
	private String game_name;
	private String game_content;
	private String image;
	private Integer game_view;
	private String developBy;
	private String distributorsBy;
	private Integer user_id;
	
	
	
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public String getGame_content() {
		return game_content;
	}
	public void setGame_content(String game_content) {
		this.game_content = game_content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getGame_view() {
		return game_view;
	}
	public void setGame_view(Integer game_view) {
		this.game_view = game_view;
	}
	public String getDevelopBy() {
		return developBy;
	}
	public void setDevelopBy(String developBy) {
		this.developBy = developBy;
	}
	public String getDistributorsBy() {
		return distributorsBy;
	}
	public void setDistributorsBy(String distributorsBy) {
		this.distributorsBy = distributorsBy;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
}
