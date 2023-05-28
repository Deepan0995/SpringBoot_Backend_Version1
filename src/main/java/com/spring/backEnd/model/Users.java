package com.spring.backEnd.model;



import jakarta.persistence.*;

@Entity
public class Users
{
	@Column (name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long userId;
	
	@Column (name = "user_name")
	public String userName;
	@Column (name = "password")
	public String password;
	@Column (name = "mobile")
	public String mobile;
	@Column (name = "address")
	public String address;
	@Column (name = "role_name")
	public String roleName;
	
	public Long getUserId () {
		return userId;
	}
	
	public void setUserId (Long userId) {
		this.userId = userId;
	}
	
	public String getUserName () {
		return userName;
	}
	
	public void setUserName (String userName) {
		this.userName = userName;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public String getMobile () {
		return mobile;
	}
	
	public void setMobile (String mobile) {
		this.mobile = mobile;
	}
	
	public String getAddress () {
		return address;
	}
	
	public void setAddress (String address) {
		this.address = address;
	}
	
	public String getRoleName () {
		return roleName;
	}
	
	public void setRoleName (String roleName) {
		this.roleName = roleName;
	}
}
