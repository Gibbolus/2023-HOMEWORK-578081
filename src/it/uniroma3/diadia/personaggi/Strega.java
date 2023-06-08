package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	private Stanza stanzaConPiuAttrezzi;
	private Stanza stanzaConMenoAttrezzi;
	
	private static final String messaggioPositivo = "Per avermi salutato ti meriti una stanza piena di attrezzi!";
	private static final String messaggioNegativo = "Per non avermi salutato ti meriti una stanza con meno attrezzi possibili!";
	
	private static final String MESSAGGIO_REGALO = "Muahahahahahah!!";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();

		Stanza maxAtrezzi = stanzeAdiacenti.get(0);
		Stanza minAtrezzi = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxAtrezzi.getNumeroAttrezzi())
					maxAtrezzi = s;
				if(s.getNumeroAttrezzi() < minAtrezzi.getNumeroAttrezzi())
					minAtrezzi = s;
			}
		}
		if(haSalutato()) {
			partita.setStanzaCorrente(stanzaConPiuAttrezzi);
			msg = messaggioPositivo;
		}
		else {
			partita.setStanzaCorrente(stanzaConMenoAttrezzi);
			msg = messaggioNegativo;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = MESSAGGIO_REGALO;
		return msg;
	}

}
			
