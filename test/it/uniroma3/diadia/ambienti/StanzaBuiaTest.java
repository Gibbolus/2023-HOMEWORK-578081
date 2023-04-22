package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private StanzaBuia stanza;
	private Stanza stanzaNormale;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp() {
		stanzaNormale = new Stanza("stanza");
		stanza = new StanzaBuia("stanza", "luce");
		attrezzo = new Attrezzo("luce", 1);

	}
	
	
	@Test
	void testStanzaNotNull() {
		assertNotNull(this.stanza);
	}
	
	@Test
	void testAttrezzoNotNull() {
		assertNotNull(this.attrezzo);
	}

	
	@Test
	void testStanzaBuia() {	
		assertEquals("Qui c'è buio pesto", this.stanza.getDescrizione());
	}
	
	
	@Test
	void testStanzaBuiaLuce() {
		stanza.addAttrezzo(attrezzo); //aggiungo la luce nella stanza buia
		stanzaNormale.addAttrezzo(attrezzo); //aggiungo attrezzo senno la descrizione è diversa
		assertEquals(this.stanzaNormale.getDescrizione(), this.stanza.getDescrizione());
	}
	
}
