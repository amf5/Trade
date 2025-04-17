package com.trade.trading.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.trade.trading.domain.USER_ROLE;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String fullName;

private String email;
@JsonProperty(access = Access.WRITE_ONLY)
private  String password;
@Embedded
private TwoFactorAuth twoFactorAuth=new TwoFactorAuth();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public TwoFactorAuth getTwoFactorAuth() {
	return twoFactorAuth;
}

public void setTwoFactorAuth(TwoFactorAuth twoFactorAuth) {
	this.twoFactorAuth = twoFactorAuth;
}

public USER_ROLE getRole() {
	return role;
}

public void setRole(USER_ROLE role) {
	this.role = role;
}

private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;

}
