package com.invoice;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users") 
public class User {

    @Id
    @GeneratedValue
    private Long id;
    
   

    private String username;
    private String password;
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
}
