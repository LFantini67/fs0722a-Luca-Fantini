package com.epicode.gad.auth.utente;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.epicode.gad.auth.roles.Role;
import com.epicode.gad.dispositivo.Dispositivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Utenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@Column(length = 40)
	private String firstName;

	@Column(length = 40)
	private String lastName;

	@Column(length = 40)
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@OneToMany
	@Column(length = 20)
	@JoinTable(name = "utente_dispositivi", joinColumns = @JoinColumn(name = "utente_id"), inverseJoinColumns = @JoinColumn(name = "dispositivo_id"))
	private Set<Dispositivo> dispositivi = new HashSet<Dispositivo>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "utente_ruoli", joinColumns = @JoinColumn(name = "utente_id"), inverseJoinColumns = @JoinColumn(name = "ruoli_id"))
	private Set<Role> roles = new HashSet<Role>();

	public Utente(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
