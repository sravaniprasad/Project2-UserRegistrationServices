package com.chengannagari.s.dashboard.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chengannagari.s.dashboard.Entity.Login;
import com.chengannagari.s.dashboard.Entity.User;
import com.chengannagari.s.dashboard.Entity.UserDTO;
import com.chengannagari.s.dashboard.Helper.ExcelHelper;
import com.chengannagari.s.dashboard.Reposiyory.UserRepository;
import com.chengannagari.s.dashboard.service.UserService;
import com.chengannagari.s.dashboard.service.UserServiceExcel;
import com.chengannagari.s.dashboard.serviceImplementation.UserServiceImplementation;

@RestController
@RequestMapping("/api/user")
@CrossOrigin()
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserServiceExcel excel;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImplementation userServiceImpl;
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDTO userDTO) {
		String id= userService.addUser(userDTO);
		return id;
		
	}
	
	@PostMapping("/data/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws Exception{
		
		Thread.sleep(5000);
		if(file.isEmpty()) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not inserted!!! pease upload the file");
			throw new Exception("file is not uploaded!! upload the file to see the records");
		}
		else if(ExcelHelper.checkExcelFormat(file)) {
			
			this.excel.save(file);
			
			return ResponseEntity.ok(Map.of("message","File is Uploaded. Records are inserted into DataBase"));	
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data not inserted due to BADREQUEST");
		}
	
	//to read all data in db
	 @GetMapping("/all")
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	 
	 //search with firstname
	 @GetMapping("/name/{firstName}")
		public ResponseEntity<User> getEmployeeById(@PathVariable("firstName") String firstName){
			
			return new ResponseEntity<User>(userService.getUserByName(firstName), HttpStatus.OK);
		}
	 @PutMapping("/update/{firstName}")
		public ResponseEntity<?> UpdateEmployee(@PathVariable ("firstName") String firstName,@RequestBody User user){
			
		  userService.updateUser(user,firstName);
	  	 return ResponseEntity.ok(Map.of("message","Details of "+firstName+ " are Updated"));
			
		}
	
	

}
