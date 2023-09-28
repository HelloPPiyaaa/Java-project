package com.spring.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Platform {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer platform_id;
	private String name;
	private Integer price;
	private Integer game_id;
	
	
	public Integer getPlatform_id() {
		return platform_id;
	}
	public void setPlatform_id(Integer platform_id) {
		this.platform_id = platform_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	
}
