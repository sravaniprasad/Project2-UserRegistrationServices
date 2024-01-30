package com.chengannagari.s.dashboard.Entity;

import jakarta.persistence.Column;

public class UserDTO {

	
private int userId;
	
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String gender;
	
	private String country;
	
	private String state;
	
	private String district;
	
	private String address;
	
	private long phoneNumber;
	
	private String email;
	
	private String password;
	
	public String image;

	public UserDTO(int userId, String firstName, String lastName, String userName, String gender, String country,
			String state, String district, String address, long phoneNumber, String email, String password,
			String image) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.gender = gender;
		this.country = country;
		this.state = state;
		this.district = district;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.image = image;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", gender=" + gender + ", country=" + country + ", state=" + state + ", district="
				+ district + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", password=" + password + ", image=" + image + "]";
	}
	
	
	
}
