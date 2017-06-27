package com.hrd.test.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hrd.test.model.User;

@Repository
public interface UserRepository {

	@Select("SELECT "
			+ "	id, "
			+ "	username, "
			+ "	email, "
			+ "	gender, "
			+ " phonenumber,"
			+ "	user_hash"
			+ " FROM "
			+ "users")
	public List<User> findAll();
	
	@Insert("INSERT INTO users ("
			+ "	username, "
			+ "	email,"
			+ "	gender, "
			+ " phonenumber,"
			+ "	user_hash"
			+ "	) VALUES ("
			+ "	#{user.username},"
			+ "	#{user.email},"
			+ "	#{user.gender},"
			+ "	#{user.phonenumber},"
			+ "	#{user.user_hash}"
			+ ")")
	public boolean save(@Param("user") User user);	
	
	@Delete("DELETE FROM users WHERE user_hash=#{user_hash}")
	public boolean delete(@Param("user_hash") String user_hash);
	
	@Update("UPDATE users SET "
			+ "username=#{user.username},"
			+ "email=#{user.email},"
			+ "gender=#{user.gender},"
			+ "phonenumber=#{user.phonenumber}"
			+ " WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
	
	@Select("SELECT id, username, gender,email,phonenumber,user_hash FROM users WHERE user_hash=#{user_hash}")
	User findOne(@Param("user_hash") String user_hash);
	
	@Select("SELECT COUNT(gender) WHERE gender=#{gender}")
	User findmale(@Param("gender") String gender);
	
	@Select("SELECT COUNT(username) FROM users WHERE gender='m'")
	public int countMale(@Param("gender") String gender);
	
	@Select("SELECT COUNT(username) FROM users WHERE gender='f'")
	public int countFemale(@Param("gender") String gender);
	
}
