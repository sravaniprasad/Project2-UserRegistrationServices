package com.chengannagari.s.dashboard.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Login {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String userName;
	    private String password;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return userName;
		}
		public void setUsername(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Login(Long id, String userName, String password) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
		}
		public Login() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
	    
	    
	
}
