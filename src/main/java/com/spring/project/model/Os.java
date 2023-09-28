package com.spring.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Os {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer os_id;
	private String os_name;
	private Integer game_id;
	
	
	public Integer getOs_id() {
		return os_id;
	}
	public void setOs_id(Integer os_id) {
		this.os_id = os_id;
	}
	public String getOs_name() {
		return os_name;
	}
	public void setOs_name(String os_name) {
		this.os_name = os_name;
	}
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	
	
}
