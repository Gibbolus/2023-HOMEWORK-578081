package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	
	private Stanza stanzaIngresso;
	private Stanza stanzaFinale;
	
	public Labirinto() {
		init();
	}
	
	
	   /**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void init() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo osso = new Attrezzo("osso", 1);
		Attrezzo libro = new Attrezzo("libro", 2);
		Attrezzo spada = new Attrezzo("spada", 7);
		Attrezzo chiave = new Attrezzo("chiave", 2);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* stanze particolari */
		StanzaMagica mensa = new StanzaMagica("Mensa");
		StanzaBuia bagno = new StanzaBuia("Bagno", "lanterna"); 
		StanzaBloccata stanzino = new StanzaBloccata("Stanzino", "est", "chiave");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("nord", mensa);
		aulaN11.impostaStanzaAdiacente("sud", stanzino);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("sud", bagno);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		biblioteca.impostaStanzaAdiacente("est", mensa);
		mensa.impostaStanzaAdiacente("sud", aulaN11);
		mensa.impostaStanzaAdiacente("ovest", biblioteca);
		bagno.impostaStanzaAdiacente("nord", laboratorio);
		bagno.impostaStanzaAdiacente("ovest", stanzino);
		stanzino.impostaStanzaAdiacente("nord", aulaN11);
		stanzino.impostaStanzaAdiacente("est", bagno);

        /* pone gli attrezzi nelle stanze */		/* ATTENZIONE StanzaBuia */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(chiave);
		aulaN11.addAttrezzo(spada);
		laboratorio.addAttrezzo(libro);
		

		// il gioco comincia nell'atrio
		setStanzaCorrente(atrio);  
		setStanzaVincente(biblioteca);
    }

	public Stanza getStanzaVincente() {
		return stanzaFinale;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIngresso;
	}
	
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIngresso = stanzaCorrente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaFinale = stanzaVincente;
	}
	
	
}
