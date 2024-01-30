package com.chengannagari.s.dashboard.Entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="firstName", length=50,nullable = false)
	@NotNull
	private String firstName;
	
	@Column(name="lastName", length=50,nullable = false)
	@NotNull
	private String lastName;
	
	@Column(name="userName", length=50,nullable = false)
	@NotNull
	private String userName;
	
	@Column(name="gender", length=50,nullable = false)
	@NotNull
	private String gender;
	
	@Column(name="country", length=50,nullable = false)
	@NotNull
	private String country;
	
	@Column(name="state", length=50,nullable = false)
	@NotNull
	private String state;
	
	@Column(name="district", length=50,nullable = false)
	@NotNull
	private String district;
	
	@Column(name="address", length=50,nullable = false)
	@NotNull
	private String address;
	
	@Column(name="phoneNumber", length=10,nullable = false)
	@NotNull
	private long phoneNumber;
	
	@Column(name="email", length=50, nullable = false)
	@NotNull
	private String email;
	
	@Column(name="password",nullable = false)
	@NotNull
	private String password;
	
	@Column(name="image",nullable = false)
	@NotNull
	public String image;
	
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
	public User(int userId, String firstName, String lastName, String userName, String gender, String country,
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
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", gender=" + gender + ", country=" + country + ", state=" + state + ", district="
				+ district + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", password=" + password + ", image=" + image + "]";
	}
	
	

}
