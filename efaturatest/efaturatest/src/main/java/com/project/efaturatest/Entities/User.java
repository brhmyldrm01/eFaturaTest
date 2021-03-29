package com.project.efaturatest.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findByEmail",query = "select u from User u where u.email= ?1")
@NamedQuery(name = "User.isExists",query = "select count(u) from User u where u.email= ?1")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tckn_vkn;
	private String email;
	private String username;
	private String user_password;
	
	public User() {}	

	public User(String tckn_vkn, String email, String username, String user_password) {
		super();
		this.tckn_vkn = tckn_vkn;
		this.email = email;
		this.username = username;
		this.user_password = user_password;
	}





	public String getTckn_vkn() {
		return tckn_vkn;
	}




	public void setTckn_vkn(String tckn_vkn) {
		this.tckn_vkn = tckn_vkn;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return " User {id=" + id + ", tckn_vkn=" + tckn_vkn + ", email=" + email + ", username=" + username
				+ ", user_password=" + user_password + "}  ";
	}

	







	
	
	
	
	
	
	
	
}
