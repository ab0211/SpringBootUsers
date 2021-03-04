package com.springboot.kpi.usersapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.kpi.usersapp.entity.Users;

@Repository
public interface UsersDao extends JpaRepository<Users,Integer> {

}
