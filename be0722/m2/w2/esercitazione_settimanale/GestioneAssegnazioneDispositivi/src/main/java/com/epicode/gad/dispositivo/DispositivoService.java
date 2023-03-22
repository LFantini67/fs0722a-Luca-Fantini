package com.epicode.gad.dispositivo;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

	@Autowired
	DispositivoRepository dispositivoRepository;

	public List<Dispositivo> getAllDevice() {
		return dispositivoRepository.findAll();
	}

	public Dispositivo findById(Long id) {
		if (!dispositivoRepository.existsById(id)) {
			throw new EntityNotFoundException("dispositivo non trovato");
		}
		return dispositivoRepository.findById(id).get();
	}

	public Dispositivo postDevice(Dispositivo dispositivo) {
		return dispositivoRepository.save(dispositivo);
	}

	public Dispositivo putDevice(Long id, Dispositivo dispositivo) {
		if (!dispositivoRepository.existsById(id)) {
			throw new EntityNotFoundException("dispositivo non trovato");
		}
		Dispositivo d = dispositivoRepository.findById(id).get();
		d.setStato(dispositivo.getStato());
		d.setTipologia(dispositivo.getTipologia());
		
		return dispositivoRepository.save(d);
	}

	public void deleteDevice(Long id) {
		if (!dispositivoRepository.existsById(id)) {
			throw new EntityNotFoundException("dispositivo non trovato");
		}
		dispositivoRepository.deleteById(id);
	}
}
