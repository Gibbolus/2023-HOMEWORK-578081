package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {

	private Comando comando;
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		this.comando = new ComandoVai();
		this.partita = new Partita();
		Stanza stanzaCorrente = new Stanza("inizio");
		this.partita.setStanzaCorrente(stanzaCorrente);
		Stanza stanzaFinale = new Stanza("fine");
		this.partita.setStanzaVincente(stanzaFinale);
		stanzaCorrente.impostaStanzaAdiacente("nord", stanzaFinale);
		this.comando.setParametro("nord");
		this.comando.esegui(partita);
	}
	
	
	@Test
	void testEseguiNotNull() {
		assertNotNull(this.comando);
	}
	
	@Test
	void testEsegui() {
		assertEquals("fine", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	void testGetNome() {
		assertEquals("vai", this.comando.getNome());
	}
	
	@Test
	void testGetParametro() {
		assertEquals("nord", this.comando.getParametro());
	}
	

}
