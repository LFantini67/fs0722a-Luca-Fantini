package com.epicode.gad.auth.roles;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	public Role postRole(Role role) {
		if (roleRepository.existsByRoleName(role.getRoleName())) {
			throw new EntityNotFoundException("ruolo gia esistente");
		}
		return roleRepository.save(role);
	}

	public Role putRole(Long id, Role role) {
		if (!roleRepository.existsById(id)) {
			throw new EntityNotFoundException("ruolo non trovato");
		}
		Role r = roleRepository.findById(id).get();
		r.setRoleName(role.getRoleName());
		
		return roleRepository.save(r);
	}

	public void deleteRole(Long id) {
		if (!roleRepository.existsById(id)) {
			throw new EntityNotFoundException("ruolo non trovato");
		}
		roleRepository.deleteById(id);
	}

}
