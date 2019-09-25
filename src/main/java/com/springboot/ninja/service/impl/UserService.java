package com.springboot.ninja.service.impl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.springboot.ninja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.ninja.entity.UserRole;


@Service("userService")

public class UserService implements UserDetailsService{

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.springboot.ninja.entity.User user =userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user,authorities);
	}
	
	private User buildUser(com.springboot.ninja.entity.User user,List<GrantedAuthority> authorities) {
	return new User(user.getUsername(), user.getPassword(), user.isEnable(),true,true,true,authorities);		
	}
	
	
	//transformara nuestro ser 
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		Set<GrantedAuthority> auths= new HashSet<GrantedAuthority>();
		
		for(UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
		
	}

	
}
