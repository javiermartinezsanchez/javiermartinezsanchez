package es.uned.aw.ped2025.controller.dto;

import java.time.LocalDateTime;

public class UserConectedDTO {
	String userName;
	LocalDateTime loginTime;
	public UserConectedDTO(String userName){
		this.userName = userName;
		this.loginTime = LocalDateTime.now();
	}
	public String getUserName() {
		return this.userName;
	}
	public LocalDateTime getLoginTime() {
		return this.loginTime;
	}
}
