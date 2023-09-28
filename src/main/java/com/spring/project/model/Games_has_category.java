package com.spring.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Games_has_category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer game_id;
	private Integer category_id;
	
	
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	
	
}
