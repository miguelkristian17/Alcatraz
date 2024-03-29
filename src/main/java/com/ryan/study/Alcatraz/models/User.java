package com.ryan.study.Alcatraz.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "users")
public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @NotNull
	 @Email(message ="Email must be Valid!")
	 private String email;
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long userID = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	 @NotNull
	 @Size(min=5,max=200,message="name must be greater than 5 char")
	 private String name;
	 @NotNull
	 @Size(min=5, max=200, message="Password must be greater than 5 char")
	 private String password;
	 @Transient
	 private String passwordConfirmation;
	 @JsonBackReference

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_pools_id")
	 private UserPool userpools;
	 
	 private String token;

	 private Date createdAt;
	 private Date updatedAt;
	public User() {
		
	}
	public User(String email,String name, String password ){
		this.email = email;
		this.name = name;
		this.password = password;
	 }
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public UserPool getUserpools() {
		return userpools;
	}

	public void setUserpools(UserPool userpools) {
		this.userpools = userpools;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	 
}
