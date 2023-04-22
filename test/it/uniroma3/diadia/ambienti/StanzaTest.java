package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
	
	@BeforeEach
	public void setUp() {
		this.stanza = new Stanza("stanza");
		this.stanzaAdiacente = new Stanza("stanzaAdiacente");
		stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
		this.stanza.addAttrezzo(attrezzo);
	}
	

	@Test
	void testGetStanzaAdiacente() {
		assertEquals("stanzaAdiacente", this.stanza.getStanzaAdiacente("nord").getNome());
	}

	@Test
	void testGetNome() {
		assertEquals("stanza", this.stanza.getNome());
	}

	@Test
	void testHasAttrezzo() {
		assertTrue(stanza.hasAttrezzo("attrezzo"));
	}

	@Test
	void testGetAttrezzo() {
		assertEquals(attrezzo, this.stanza.getAttrezzo("attrezzo"));
	}

}
