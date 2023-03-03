package model.Mezzo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Ticket.Ticket;

@Entity
@Table(name="Mezzo")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Mezzo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private int capienza;
	@Enumerated(EnumType.STRING)
	private disponibilita disponibilita;
	private int periodoServizio;
	private int periodoManutenzione;
	private int bigliettiConvalidati;
	private Date partenza;
	
	@ManyToOne(cascade = { CascadeType.REMOVE})
	@JoinColumn(name="trattaId")
	
	private Tratta idTratta;
	
	@OneToMany(mappedBy="mezzo_id",cascade = { CascadeType.REMOVE})
	private List<Ticket> ticketes = new ArrayList<>();
	
	private double numeroGiri;
	
	public Mezzo(Long id, int capienza, model.Mezzo.disponibilita disponibilita, int periodoServizio,
			int periodoManutenzione, int bigliettiConvalidati, double numeroGiri,Date partenza) {
		super();
		this.id = id;
		this.capienza = capienza;
		this.disponibilita = disponibilita;
		this.periodoServizio = periodoServizio;
		this.periodoManutenzione = periodoManutenzione;
		this.bigliettiConvalidati = bigliettiConvalidati;
		this.numeroGiri = numeroGiri;
		this.partenza = partenza;
	}

	public Mezzo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public disponibilita getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(disponibilita disponibilita) {
		this.disponibilita = disponibilita;
	}

	public int getPeriodoServizio() {
		return periodoServizio;
	}

	public void setPeriodoServizio(int periodoServizio) {
		this.periodoServizio = periodoServizio;
	}

	public int getPeriodoManutenzione() {
		return periodoManutenzione;
	}

	public void setPeriodoManutenzione(int periodoManutenzione) {
		this.periodoManutenzione = periodoManutenzione;
	}

	public Long getId() {
		return id;
	}

	public int getCapienza() {
		return capienza;
	}

	public int getBigliettiConvalidati() {
		return bigliettiConvalidati;
	}

	public Tratta getIdTratta() {
		return idTratta;
	}

	public void setIdTratta(Tratta idTratta) {
		this.idTratta = idTratta;
	}

	public List<Ticket> getTicketes() {
		return ticketes;
	}

	public void setTicketes(List<Ticket> ticketes) {
		this.ticketes = ticketes;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public void setBigliettiConvalidati(int bigliettiConvalidati) {
		this.bigliettiConvalidati = bigliettiConvalidati;
	}

	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", capienza=" + capienza + ", disponibilita=" + disponibilita + ", periodoServizio="
				+ periodoServizio + ", periodoManutenzione=" + periodoManutenzione + ", bigliettiConvalidati="
				+ bigliettiConvalidati + "]";
	}


	public double getNumeroGiri() {
		return numeroGiri;
	}

	public void setNumeroGiri(double risultato) {
		this.numeroGiri = risultato;
	}

	public Date getPartenza() {
		return partenza;
	}

	public void setPartenza(Date partenza) {
		this.partenza = partenza;
	}

}
