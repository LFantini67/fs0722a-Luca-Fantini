package com.epicode.gad.auth.utente;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.epicode.gad.auth.roles.ERole;
import com.epicode.gad.auth.roles.Role;
import com.epicode.gad.auth.roles.RoleRepository;

@Service
public class UtenteService {
	@Autowired
	UtenteRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public List<Utente> getAllUser() {

		return userRepository.findAll();
	}

	public Utente findById(Long id) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("Utente non trovato");
		}
		return userRepository.findById(id).get();
	}

	public Utente postUser(Utente utente) {
		if (userRepository.existsByUsername(utente.getUsername())) {
			throw new EntityNotFoundException("Utente gia esistente");
		}
		utente.setPassword(passwordEncoder.encode(utente.getPassword()));

		if(utente.getRoles().isEmpty()) {
		Role r = roleRepository.findByRoleName(ERole.ROLE_USER).get();
		Set<Role> ruoliDiDefault = new HashSet<Role>();
		ruoliDiDefault.add(r);

		utente.setRoles(ruoliDiDefault);
		}
		
		return userRepository.save(utente);
	}

	public Utente putUser(Long id, Utente utente) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("utente non trovato");
		}

		Utente u = userRepository.findById(id).get();
		u.setUsername(utente.getUsername());
		u.setFirstName(utente.getFirstName());
		u.setLastName(utente.getLastName());
		u.setEmail(utente.getEmail());
		u.setPassword(utente.getPassword());
		u.setDispositivi(utente.getDispositivi());
		u.setRoles(utente.getRoles());

		return userRepository.save(u);
	}

	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("utente non trovato");
		}
		userRepository.deleteById(id);
	}

	public List<UtenteResponse> getAllUsersBasicInformations() {
		return userRepository.findAll().stream()
				.map(user -> UtenteResponse.builder().userName(user.getUsername())
						.role(user.getRoles().stream().findFirst().get().getRoleName().name()).build())
				.collect(Collectors.toList());
	}

	public UtenteResponse getUserBasicInformations(String userName) {
		Utente user = userRepository.findByUsername(userName).get();

		return UtenteResponse.builder().userName(userName)
				.role(user.getRoles().stream().findFirst().get().getRoleName().name()).build();

	}

}
