package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

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
	void testImpostaStanzaAdiacente() {
		Stanza stanza = new Stanza("stanzaProva");
		this.stanza.impostaStanzaAdiacente("sud", stanza);
		assertEquals("stanzaProva", this.stanza.getStanzaAdiacente("sud").getNome());
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
	void testAddAttrezzo() {
		Attrezzo prova = new Attrezzo("prova", 1);
		assertTrue(stanza.addAttrezzo(prova));
	}

	@Test
	void testGetAttrezzo() {
		assertEquals(attrezzo, this.stanza.getAttrezzo("attrezzo"));
	}
	
	@Test
	void testGetAttrezzi() {
		assertEquals(1, this.stanza.getAttrezzi().size());
	}
	
	@Test
	void testAddAttrezzoDoppione() {
		this.stanza.addAttrezzo(attrezzo);
		assertEquals(1, this.stanza.getAttrezzi().size());
		assertFalse(stanza.addAttrezzo(attrezzo));
	}

}
