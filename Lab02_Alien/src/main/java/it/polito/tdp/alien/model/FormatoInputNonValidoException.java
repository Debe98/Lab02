package it.polito.tdp.alien.model;

public class FormatoInputNonValidoException extends ParoleException {

	@Override
	public String toString() {
		return super.toString()+"Il formato non è valido, usare uno dei seguenti:\n<Parola aliena> <Traduzione> (nuovo significato)\n<Parola aliena> (ottieni significati)\n<Parola><?><aliena> (ottieni significati parole che coincidono)";
	}
}
