package com.api.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

//	@NotBlank(message = "Name is require")
//	@NotNull(message = "Ente valid name")
	@NotEmpty
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String name;

	@NotBlank(message = "Email is require")
	@Email(message = "Enter valid Email")
	private String email;

	@NotBlank(message = "Enter valid username") // field detail is mendetory
	@NotNull(message = "UserName is require") // means field is mendetory
	private String username;

	@NotBlank(message = "Password is require")
	@NotNull(message = "Enter valid password")
	private String password;

	@NotBlank(message = "Mobile is require")
	@NotNull(message = "Enter valid MObile Number")
	private String mobile;

	@NotBlank(message = "Address is require")
	private String address;

	private Date createDate;

	private Date updateDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
