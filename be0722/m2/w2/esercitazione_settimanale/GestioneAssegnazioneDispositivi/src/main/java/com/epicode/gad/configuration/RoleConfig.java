package com.epicode.gad.configuration;


import org.springframework.context.annotation.Configuration;

import com.epicode.gad.auth.roles.Role;

@Configuration
public class RoleConfig {

	public Role nuovoRuolo() {
		return new Role();
	}
}
