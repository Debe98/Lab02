package it.polito.tdp.alien.model;

public class NonLettereException extends ParoleException {

	@Override
	public String toString() {
		return super.toString()+"Le parole inserite devono essere formate solo da lettere (a-z, A-Z)!";
	}
}
