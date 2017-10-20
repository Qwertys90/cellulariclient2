package it.dstech.models;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	
	private String username;
	
	private String password;
	
	private UserProfileType profileType;
	
	private List<Cellulare> listaCellulari;

	
	
	public User() {
		this.listaCellulari = new ArrayList<Cellulare>();
	}

	public int getId() {
		return id;
	}

	public List<Cellulare> getListaCellulari() {
		return listaCellulari;
	}

	public void setListaCellulari(List<Cellulare> listaCellulari) {
		this.listaCellulari = listaCellulari;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfileType getProfileType() {
		return profileType;
	}

	public void setProfileType(UserProfileType userProfileType) {
		this.profileType = userProfileType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userProfileType="
				+ profileType + ", listaCellulari=" + listaCellulari + "]";
	}


}
