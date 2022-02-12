package com.tahauddin.syed.security.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tahauddin.syed.security.domain.Authority;
import com.tahauddin.syed.security.domain.MyUser;
import com.tahauddin.syed.security.repo.MyUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MyUserRepo userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser user = userRepo.findByUsername(username).orElseThrow(() -> {
			return new UsernameNotFoundException("Username Not Found : " + username);
		});
		
		return new User(user.getUsername(), 
				user.getPassword(),
				user.isEnabled(),
				user.isAccountNonExpired(), 
				user.isCredentialsNonExpired(),
				user.isAccountNonLocked(), 
				convertToSpringAuthorities(user.getAuthorities()));
	}

	public Collection<? extends GrantedAuthority> convertToSpringAuthorities(Set<Authority> authorities) {
		
		
		
		if(authorities != null && authorities.size() > 0) {
			return authorities.stream()
					.map(Authority :: getRole)
					.map(SimpleGrantedAuthority :: new)
			//		.map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toSet());
		}else {
			SimpleGrantedAuthority newJoinee = new SimpleGrantedAuthority("NEW JOINEE");
			HashSet<GrantedAuthority> grantedAuthority = new HashSet<>();
			grantedAuthority.add(newJoinee);
			return grantedAuthority;
		}
	}
	
	

}
