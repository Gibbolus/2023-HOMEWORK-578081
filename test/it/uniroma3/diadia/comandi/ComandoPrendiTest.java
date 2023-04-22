package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	private Comando comando;
	private Partita partita;
	private Attrezzo attrezzo;
	private Stanza stanza;
	
	
	@BeforeEach
	public void setUp() {
		this.comando = new ComandoPrendi();
		this.stanza = new Stanza("stanza");
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.stanza.addAttrezzo(attrezzo);
		this.partita = new Partita();
		this.partita.setStanzaCorrente(stanza);
		this.comando.setParametro("attrezzo");
		this.comando.esegui(partita);
	}
	
	
	@Test
	void testEseguiNotNull() {
		assertNotNull(this.comando);
	}

	@Test
	void testEsegui() {
		assertFalse(this.stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testGetNome() {
		assertEquals("prendi", this.comando.getNome());
	}
	
	@Test
	void testGetParametro() {
		assertEquals("attrezzo", this.comando.getParametro());
	}
}
