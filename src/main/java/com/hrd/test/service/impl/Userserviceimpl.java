package com.hrd.test.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrd.test.model.User;
import com.hrd.test.repository.UserRepository;
import com.hrd.test.service.Userservice;

@Service
public class Userserviceimpl implements Userservice{
	private UserRepository userRepository;

	@Autowired
	public Userserviceimpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
		
	}
	@Override
	public boolean save(User user) {
		String userHash = UUID.randomUUID().toString();
		user.setUser_hash(userHash);
		boolean status = userRepository.save(user);
		if (status) {
			System.out.println("USER ID : " + user.getId());
			System.out.println("User has been inserted!");
		} else {
			System.out.println("User has not been inserted!.");
		}
		return status;
		
	}
	@Override
	public boolean delete(String user_hash) {
		
		boolean status=userRepository.delete(user_hash);
				return status;
	}

	@Override
	public boolean update(User user) {
		// TODO: update user from database by userHash
		boolean status = userRepository.update(user);
		if (status) {
			System.out.println("User has been updated!");
		} else {
			System.out.println("User has not been updated!");
		}
		return status;
	}
	@Override
	public User findOne(String user_hash) {	
		return userRepository.findOne(user_hash);
	}
	@Override
	public int countMale(String gender) {
		return userRepository.countMale(gender);

	}
	@Override
	public int countFemale(String gender) {
		return userRepository.countFemale(gender);

	}
	
}
