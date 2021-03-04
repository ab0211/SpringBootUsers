package com.springboot.kpi.usersapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kpi.usersapp.entity.Users;
import com.springboot.kpi.usersapp.exception.InvalidRequestParamException;
import com.springboot.kpi.usersapp.exception.UserNotFoundException;
import com.springboot.kpi.usersapp.service.UsersServiceImpl;

@RestController
@RequestMapping("/api")
public class UsersRestController {
	
	@Autowired
	private UsersServiceImpl service;
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable int id) {
		
		List<Users> list=service.getUsers();
		int count=0;
		for(Users user:list) {
			if(user.getId()==id) {
				count++;
				break;
			}
		}
		
		if(id<=0 || count==0) {
			throw new UserNotFoundException("Invalid User ID!");
		}
		
		return service.getUserById(id);
	}
	
	@PostMapping("/users")
	public Users enterUser(@RequestBody Users user) {
		user.setId(0);
		
		if(user.getAge()<=0) {
			throw new InvalidRequestParamException("Invalid Age!");
		}
		
		if(user.getSex()!='M' &&  user.getSex()!='F') {
			throw new InvalidRequestParamException("Invalid Gender!");
		}
		
		return service.saveUser(user);
	}
	
	@PutMapping("/users")
	public Users updateUser(@RequestBody Users user) {
		if(user.getAge()<=0) {
			throw new InvalidRequestParamException("Invalid Age!");
		}
		
		if(user.getSex()!='M' && user.getSex()!='F') {
			throw new InvalidRequestParamException("Invalid Gender!");
		}
		
		return service.saveUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		List<Users> list=service.getUsers();
		int count=0;
		for(Users user:list) {
			if(user.getId()==id) {
				count++;
				break;
			}
		}
		
		if(id<=0 || count==0) {
			throw new UserNotFoundException("Invalid User ID!");
		}
		service.deleteUser(id);
		return "Deleted User having ID:"+id;
	}

}
