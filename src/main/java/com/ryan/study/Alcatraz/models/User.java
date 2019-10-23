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

@Entity
@Table(name = "users")
public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Size(min=5,max=200)
	 @NotNull
	 @Email(message="Email must be valid")
	 private String email;
	 @NotNull
	 @Size(min=5,max=200,message="name must be greater than 5 char")
	 private String name;
	 @NotNull
	 @Size(min=5, max=200, message="Password must be greater than 5 char")
	 private String password;
	 @NotNull
	 @Transient
	 private String passwordConfirmation;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_pools_id")
	 private UserPool userpool;
	 private Date createdAt;
	 private Date updatedAt;
	 
	 public User(){
		 
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

	public UserPool getUserpool() {
		return userpool;
	}

	public void setUserpool(UserPool userpool) {
		this.userpool = userpool;
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
