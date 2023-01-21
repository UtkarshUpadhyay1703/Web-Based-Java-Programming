package com.dal;

import com.pojo.User;

public interface UserDAL {
	public User validateUser(String email,String password);
}
