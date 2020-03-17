package it.polito.tdp.alien.model;

public class TraduzioneNonMemorizzataException extends ParoleException {

	@Override
	public String toString() {
		return super.toString()+"La Parola non e' presente nel nostro database!";
	}
}
