package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPosaTest {
	
	private Comando comando;
	private Borsa borsa;
	private Attrezzo attrezzo;
	private Stanza stanza;

	
	@BeforeEach
	public void setUp() {
		this.comando = new ComandoPosa();
		Partita partita = new Partita();
		this.stanza = new Stanza("stanza");
		partita.setStanzaCorrente(stanza);
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.borsa = partita.getGiocatore().getBorsa();
		this.borsa.addAttrezzo(attrezzo);
		this.comando.setParametro("attrezzo");
		this.comando.esegui(partita);
	}

	@Test
	void testEseguiNotNull() {
		assertNotNull(this.comando);
	}
	
	@Test
	void testEsegui() {
		assertTrue(this.stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testGetNome() {
		assertEquals("posa", this.comando.getNome());
	}
	
	@Test
	void testGetParmetro() {
		assertEquals("attrezzo", this.comando.getParametro());
	}

	
}

