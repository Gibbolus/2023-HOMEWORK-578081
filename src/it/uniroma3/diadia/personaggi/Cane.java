package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private static final String MESSAGGGIO_MORSO = "Il cane ti ha morso!, hai perso 1 cfu.";

	private static final String PRESENTAZIONE = "wof wof";

	private static final String MESSAGGIO_REGALO = "Il cane si è mangiato ciò che gli hai dato! Ha buttato un attrezzo nella stanza";
	private Attrezzo palla = new Attrezzo("palla", 1);
	
	private String ciboPreferito = "croccantini";
	
	
	public Cane(String nome, String prestazione) {
		super(nome, prestazione);
	}

	@Override
	public String saluta() {
		return PRESENTAZIONE;
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGGIO_MORSO;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(ciboPreferito)) {
			 partita.getStanzaCorrente().addAttrezzo(palla);	 
		}
		else {
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			this.agisci(partita);
		}
		return MESSAGGIO_REGALO;
	}

}
