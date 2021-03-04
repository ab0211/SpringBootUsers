package com.springboot.kpi.usersapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.kpi.usersapp.dao.UsersDao;
import com.springboot.kpi.usersapp.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDao dao;

	@Override
	@Transactional
	public List<Users> getUsers() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Users getUserById(int id) {
		Users user=null;
		Optional<Users> userOpt= dao.findById(id);
		if(userOpt.isPresent()) {
			user=userOpt.get();
		}
		return user;
	}

	@Override
	@Transactional
	public Users saveUser(Users user) {
		return dao.save(user);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		dao.deleteById(id);
	}

}
