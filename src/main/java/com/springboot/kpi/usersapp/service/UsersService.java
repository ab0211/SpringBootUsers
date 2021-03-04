package com.springboot.kpi.usersapp.service;

import java.util.List;

import com.springboot.kpi.usersapp.entity.Users;

public interface UsersService {
	
	public List<Users> getUsers();
	public Users getUserById(int id);
	public Users saveUser(Users user);
	public void deleteUser(int id);

}
