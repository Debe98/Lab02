package it.polito.tdp.alien.model;

public class Parola {
	
	private String parolaAliena;
	private String traduzione;
	
	public Parola(String parolaAliena, String traduzione) {
		super();
		this.parolaAliena = parolaAliena;
		this.traduzione = traduzione;
	}

	public String getParolaAliena() {
		return parolaAliena;
	}

	public String getTraduzione() {
		return traduzione;
	}
	
	
}
