package it.epicode.gi;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class Subject {

	private List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer obs) {
		this.getObservers().add(obs);
	}

	public void notifyObservers() {
		this.getObservers().forEach(elem -> elem.update(this));
	}

	public boolean removeObserver(Observer obs) {
		return this.getObservers().remove(obs);
	}

}
