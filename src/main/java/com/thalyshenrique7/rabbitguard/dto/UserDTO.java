package com.thalyshenrique7.rabbitguard.dto;

import com.thalyshenrique7.rabbitguard.enums.Role;

public class UserDTO {

	private Long id;

	private String email;
	private String firstName;
	private String lastName;
	private String username;

	private Role role;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", role=" + role + "]";
	}

}
