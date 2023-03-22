package com.epicode.gad.dto;

import java.util.HashSet;
import java.util.Set;

import com.epicode.gad.auth.roles.Role;
import com.epicode.gad.dispositivo.Dispositivo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDto {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Set<Dispositivo> dispositivi = new HashSet<Dispositivo>();
	private Set<Role> roles = new HashSet<Role>();
}
