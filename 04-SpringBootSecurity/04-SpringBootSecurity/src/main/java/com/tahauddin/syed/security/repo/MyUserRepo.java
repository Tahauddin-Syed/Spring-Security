package com.tahauddin.syed.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tahauddin.syed.security.domain.MyUser;

public interface MyUserRepo extends JpaRepository<MyUser, Integer> {
	
	Optional<MyUser> findByUsername(String username);

}
