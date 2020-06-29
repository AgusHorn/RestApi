package com.restservice.dao;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.restservice.entity.User;

@Repository
public class UserDAO implements IUserDAO {
	
	private List<User> users;
	
	public UserDAO() {
		this.users = new ArrayList<User>();
	}

	@Override
	public User findUserById(int id) {
		for (User user : this.users) { 
		    if (user.getId() == id) {
		    	return user;
		    }
		}
		return new User();
	}

	@Override
	public Integer modifyUser(int id, User user) {
		if (user != null ) {
			User oldUser = this.findUserById(id);
			if (oldUser.getId() == id) {
				user.setId(oldUser.getId());
				this.users.remove(oldUser);
				this.users.add(user);
				return id;
			} else {
				return -1;
			}
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		if (user != null) {
			this.users.add(user);
		}
	}

	@Override
	public Integer deleteUserById(int id) {
		User oldUser = this.findUserById(id);
		if (oldUser.getId() == id) {
			this.users.remove(oldUser);
			return id;
		} 
		return -1;
	}
}
