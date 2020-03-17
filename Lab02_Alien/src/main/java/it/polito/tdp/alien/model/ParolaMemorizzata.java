package it.polito.tdp.alien.model;

import java.util.*;

public class ParolaMemorizzata {
	
	private String parolaAliena;
	private List <String> traduzioni;
	
	public ParolaMemorizzata(Parola p) {
		super();
		traduzioni = new ArrayList<>();
		this.parolaAliena = p.getParolaAliena();
		traduzioni.add(p.getTraduzione());
	}

	public String getParolaAliena() {
		return parolaAliena;
	}

	public String getTraduzione() {
		String ritorno = "";
		for (String s : traduzioni)
			ritorno+=s+"\n";
		return ritorno;
	}
	
	public boolean cercaTraduzione (Parola p) {
		for (String s : traduzioni)
			if (s.equals(p.getTraduzione()))
					return true;
		return false;
	}
	
	public void mergeTraduzioni (Parola p) {
		traduzioni.add(p.getTraduzione());
	}

	@Override
	public String toString() {
		return parolaAliena+":\n"+getTraduzione();
	}
	
	
}
