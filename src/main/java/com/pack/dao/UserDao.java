package com.pack.dao;

import com.pack.model.User;

public interface UserDao {
	User getUserByToken(String token);
}
