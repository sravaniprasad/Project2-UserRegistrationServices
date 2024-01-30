package com.chengannagari.s.dashboard.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengannagari.s.dashboard.Entity.User;
import com.chengannagari.s.dashboard.Entity.UserDTO;
import com.chengannagari.s.dashboard.Reposiyory.UserRepository;
import com.chengannagari.s.dashboard.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public String addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		User user=new User(
				userDTO.getUserId(),
				userDTO.getFirstName(),
				userDTO.getLastName(),
				userDTO.getUserName(),
				userDTO.getGender(),
				userDTO.getCountry(),
				userDTO.getState(),
				userDTO.getDistrict(),
				userDTO.getAddress(),
				userDTO.getPhoneNumber(),
				userDTO.getEmail(),
				userDTO.getPassword(),
				userDTO.getImage()
				
				);
		

		if(!userRepository.existsByFirstName(user.getFirstName())) {
			userRepository.save(user);
			return user.getFirstName()+" is saved";
		}
		else {
			return "User already exists";
		}
			}
	@Override
	public User getUserByName(String firstName) {
		// TODO Auto-generated method stub
		Optional <User> u=userRepository.findByFirstName(firstName);
		User user=null;
		if(u.isPresent()) {
			user=u.get();
		}
		return user;
	} 
	
	

	public User delete(String lastName) {
		Optional <User> u=userRepository.findByFirstName(lastName);
		User user=null;
		if(u.isPresent()) {
			user=u.get();
			userRepository.save(user);
		}
		return user;
	}
	@Override
	public User updateUser(User user, String firstName) {
		// TODO Auto-generated method stub
		User existingUser=userRepository.findByFirstName(firstName).orElse(user);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setUserName(user.getUserName());
		existingUser.setGender(user.getGender());
		existingUser.setCountry(user.getCountry());
		existingUser.setState(user.getState());
		existingUser.setDistrict(user.getDistrict());
		existingUser.setAddress(user.getAddress());
		existingUser.setPhoneNumber(user.getPhoneNumber());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setImage(user.getImage());
		userRepository.save(existingUser);
		return existingUser;
	}
	
	
}
