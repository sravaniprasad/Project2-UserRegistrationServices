package com.chengannagari.s.dashboard.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chengannagari.s.dashboard.Entity.Login;
import com.chengannagari.s.dashboard.Entity.User;
import com.chengannagari.s.dashboard.Entity.UserDTO;
@Service
public interface UserService {

	//String addUser(UserDTO userDTO);

	String addUser(UserDTO userDTO);

	User getUserByName(String firstName);

	User updateUser(User user, String firstName);

}
