package com.springboot.ninja.repository;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ninja.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Serializable> {

	public abstract User findbyUsername(String username);
	
}
