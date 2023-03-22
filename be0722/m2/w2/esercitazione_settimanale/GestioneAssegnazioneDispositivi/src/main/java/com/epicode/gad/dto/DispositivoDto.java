package com.epicode.gad.dto;


import com.epicode.gad.dispositivo.StatoDispositivo;
import com.epicode.gad.dispositivo.TipoDispositivo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoDto {

	private Long id;
	private TipoDispositivo tipologia;
	private StatoDispositivo stato;
}
