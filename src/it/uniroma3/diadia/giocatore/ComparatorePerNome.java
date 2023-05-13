package it.uniroma3.diadia.giocatore;

import java.util.Comparator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComparatorePerNome implements Comparator<Attrezzo>{

	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		if(a1.getNome().compareTo(a2.getNome())<0)
			return -1;
		if(a1.getNome().compareTo(a2.getNome())>0)
			return 1;
		else
			return 0;
	}

}
