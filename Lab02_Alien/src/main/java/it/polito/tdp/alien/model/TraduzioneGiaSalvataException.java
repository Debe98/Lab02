package it.polito.tdp.alien.model;

public class TraduzioneGiaSalvataException extends ParoleException {

	@Override
	public String toString() {
		return super.toString()+"La traduzione era gia' presente nel database!";
	}

}
