package com.restservice.dao;

import org.springframework.data.repository.Repository;

import com.restservice.entity.User;

public interface IUserDAO extends Repository<User, Integer> {
	
	public User findUserById(int id);
	
	public Integer modifyUser(int id, User user);
	
	public void saveUser(User user);
	
	public Integer deleteUserById(int id);

}
