package com.hrd.test.service;

import java.util.List;

import com.hrd.test.model.User;

public interface Userservice{
	public List<User> findAll();
	public boolean save(User user);
	public boolean delete(String user_hash);
	public boolean update(User user);
	public User findOne(String user_hash);
	public int countMale(String gender);
	public int countFemale(String gender);

}
