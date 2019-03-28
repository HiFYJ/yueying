package com.fyj.service;

import com.fyj.pojo.User;

public interface UserService {
	User getUserById(long userId);
	boolean checkUser(String userName,String password);
	boolean register(String userName,String password);
}

