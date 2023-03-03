package model.Mezzo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Tratta")
public class Tratta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String zonaPartenza;
	private String capolinea;
	private int tempoPercorrenza;
	
	@OneToMany(mappedBy="idTratta",cascade = { CascadeType.REMOVE})
	List<Mezzo> mezzi = new ArrayList<>();
	
	public Tratta(Long id, String zonaPartenza, String capolinea, int tempoPercorrenza) {
		super();
		this.id = id;
		this.zonaPartenza = zonaPartenza;
		this.capolinea = capolinea;
		this.tempoPercorrenza = tempoPercorrenza;
	}
	
	public Tratta() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<Mezzo> getMezzi() {
		return mezzi;
	}

	public void setMezzi(List<Mezzo> mezzi) {
		this.mezzi = mezzi;
	}

	public String getZonaPartenza() {
		return zonaPartenza;
	}

	public void setZonaPartenza(String zonaPartenza) {
		this.zonaPartenza = zonaPartenza;
	}

	public String getCapolinea() {
		return capolinea;
	}

	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}

	public int getTempoPercorrenza() {
		return tempoPercorrenza;
	}

	public void setTempoPercorrenza(int tempoPercorrenza) {
		this.tempoPercorrenza = tempoPercorrenza;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tratta [id=" + id + ", zonaPartenza=" + zonaPartenza + ", capolinea=" + capolinea
				+ ", tempoPercorrenza=" + tempoPercorrenza + "]";
	}

}
