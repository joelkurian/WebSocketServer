package com.leoj.glitch.pojo;

public class Device {

	private String id;
	private User user;

	public Device(User user) {
		super();
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
