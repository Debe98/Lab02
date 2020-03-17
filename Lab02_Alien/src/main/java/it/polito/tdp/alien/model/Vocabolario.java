package it.polito.tdp.alien.model;

import java.util.*;
import java.util.regex.Pattern;

public class Vocabolario {

	private List <ParolaMemorizzata> parole = new ArrayList<>();
	
	
	public String traduci (String s) throws ParoleException {
		s = s.toLowerCase();
		String[] elementi = s.split(" ");
		
		if (elementi.length == 1)
			return "Le traduzioni sono:\n"+traduzioneParola(s);
		else if (elementi.length == 2)
			return "Nuovo significato inserito!\n\nTraduzioni memorizzate per "+memorizza(new Parola(elementi[0], elementi[1])).toString();
		else throw new FormatoInputNonValidoException();
	}
	
	public String traduzioneParola(String s) throws ParoleException {
		s = s.trim();
		if (s.contains("?"))
			return ricercaWildcard(s);
		if (!verLettere(s))
			throw new NonLettereException();
		for (ParolaMemorizzata pm : parole)
			if (pm.getParolaAliena().equals(s))
				return pm.getTraduzione();
		throw new TraduzioneNonMemorizzataException();
	}

	public ParolaMemorizzata memorizza (Parola p) throws ParoleException {		
		if (!parolaValida(p))
			throw new NonLettereException();
		
		for (ParolaMemorizzata pm : parole)
			if (pm.getParolaAliena().equals(p.getParolaAliena())) {
				if (pm.cercaTraduzione(p))
					throw new TraduzioneGiaSalvataException();
				else {
					pm.mergeTraduzioni(p);
					return pm;
				}
			}
		ParolaMemorizzata pm = new ParolaMemorizzata(p);
		parole.add(pm);
		return pm;
	}
	
	public boolean parolaValida (Parola p) {
		if (verLettere(p.getParolaAliena()) && verLettere(p.getTraduzione()))
			return true;
		return false;	
	}
	
	public boolean verLettere(String s) {
		for (int i = 0; i<s.length(); i++) {
			if (!Character.isLetter(s.charAt(i)))
				return false;
		}
		return true;
	}

	public String ricercaWildcard(String s) throws ParoleException {
		String ritorno = "";
		List <ParolaMemorizzata> fitWord = new ArrayList<>();
		String[] elementi = s.split(Pattern.quote("?"));
		if (s.indexOf("?") != s.lastIndexOf("?"))
			throw new FormatoInputNonValidoException();
		if (s.charAt(0) == '?') {
			for (ParolaMemorizzata pm : parole)
				if(condizioniFitFine(pm, elementi[1]))
					fitWord.add(pm);
		}
		else if (s.charAt(s.length()-1) == '?') {
			for (ParolaMemorizzata pm : parole)
				if(condizioniFitInizio(pm, elementi[0]))
					fitWord.add(pm);
		}
		else if (elementi.length == 2) {
			for (ParolaMemorizzata pm : parole)
				if(condizioniFit(pm, s.length(), elementi[0], elementi[1]))
					fitWord.add(pm);
		}
		else throw new FormatoInputNonValidoException();
		if (fitWord.isEmpty()) throw new TraduzioneNonMemorizzataException();
		for (ParolaMemorizzata pm : fitWord)
			ritorno += pm.toString()+"\n";
		return ritorno;
	}
	
	public boolean condizioniFit(ParolaMemorizzata p, int l, String inizio, String fine) {
		String parola = p.getParolaAliena();
		if (parola.length() != l) return false;
		if (!parola.substring(0, inizio.length()).equals(inizio)) return false;
		if (!parola.substring(inizio.length()+1, l).equals(fine)) return false;
		return true;
	}
	public boolean condizioniFitInizio(ParolaMemorizzata p, String inizio) {
		String parola = p.getParolaAliena();
		if (parola.length() != inizio.length()+1) return false;
		if (!parola.substring(0, inizio.length()).equals(inizio)) return false;
		return true;
	}
	
	public boolean condizioniFitFine(ParolaMemorizzata p, String fine) {
		String parola = p.getParolaAliena();
		if (parola.length() != fine.length()+1) return false;
		if (!parola.substring(1, fine.length()+1).equals(fine)) return false;
		return true;
	}
}
