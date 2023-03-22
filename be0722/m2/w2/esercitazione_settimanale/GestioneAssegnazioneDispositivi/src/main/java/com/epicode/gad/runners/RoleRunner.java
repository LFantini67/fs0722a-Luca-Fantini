package com.epicode.gad.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.gad.auth.roles.ERole;
import com.epicode.gad.auth.roles.Role;
import com.epicode.gad.auth.roles.RoleRepository;

@Component
public class RoleRunner implements ApplicationRunner {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		
		roleRepository.save(user);
		
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		
		roleRepository.save(admin);
		
	}

}
