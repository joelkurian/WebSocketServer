package com.leoj.glitch.pojo;

import java.util.Set;

public class User {

	private String id;
	private String email;
	private String passwd;
	private Set<Device> deviceSet;

	public User(String email, String passwd, Set<Device> deviceSet) {
		super();
		this.email = email;
		this.passwd = passwd;
		this.deviceSet = deviceSet;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Set<Device> getDeviceSet() {
		return deviceSet;
	}

	public void setDeviceSet(Set<Device> deviceSet) {
		this.deviceSet = deviceSet;
	}

}
