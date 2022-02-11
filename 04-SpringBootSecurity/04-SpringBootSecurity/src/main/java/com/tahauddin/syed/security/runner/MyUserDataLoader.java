package com.tahauddin.syed.security.runner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.tahauddin.syed.security.domain.Authority;
import com.tahauddin.syed.security.domain.MyUser;
import com.tahauddin.syed.security.repo.AuthorityRepo;
import com.tahauddin.syed.security.repo.MyUserRepo;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class MyUserDataLoader implements CommandLineRunner {
	
	@Autowired
	private MyUserRepo userRepo;
	
	@Autowired
	private AuthorityRepo authorityRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {

		if(authorityRepo.count() == 0) {
			loadData();
		}
	}

	private void loadData() {
		Authority admin = authorityRepo.save(Authority.builder().role("ROLE_ADMIN").build());
		Authority employee = authorityRepo.save(Authority.builder().role("ROLE_EMPLOYEE").build());
		Authority it = authorityRepo.save(Authority.builder().role("ROLE_IT").build());
		
		userRepo.save(
				MyUser.builder()
					.username("Syed")
					.password(passwordEncoder.encode("Tahauddin"))
					.authority(admin)
					.build()
					);
		
		userRepo.save(
				MyUser.builder()
					.username("Mohd")
					.password(passwordEncoder.encode("Khaleeq"))
					.authority(employee)
					.build()
					);
		
		userRepo.save(
				MyUser.builder()
					.username("Mohammad")
					.password(passwordEncoder.encode("Asad"))
					.authority(it)
					.build()
					);
	}

}
