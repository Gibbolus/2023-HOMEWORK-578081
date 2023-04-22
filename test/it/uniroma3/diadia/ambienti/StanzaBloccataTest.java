package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;
	private Attrezzo chiave;
	private String direzioneBloccata = "nord";
	private String attrezzoSbloccante = "chiave";
	
	@BeforeEach
	public void setUp() {
		stanzaBloccata = new StanzaBloccata("stanzaBloccata", this.direzioneBloccata , this.attrezzoSbloccante);
		stanzaAdiacente = new Stanza("stanzaAdiacente");
		stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
		stanzaAdiacente.impostaStanzaAdiacente("sud", stanzaBloccata);
		chiave = new Attrezzo("chiave", 1);
		
		
	}
	
	
	@Test
	void testConAttrezzo() {
		stanzaBloccata.addAttrezzo(chiave);
		assertEquals(this.stanzaAdiacente, stanzaBloccata.getStanzaAdiacente(this.direzioneBloccata));
	}
	
	
	@Test
	void testSenzaAttrezzo() {
		assertEquals(this.stanzaBloccata, stanzaBloccata.getStanzaAdiacente(this.direzioneBloccata));
	}
	
	
	@Test
	void testStampeDirezioneFail() {
		assertEquals("\nDirezione bloccata: " + direzioneBloccata, stanzaBloccata.infoDirezione());
	}
	 
	
	@Test
	void testStampeAttrezzoFail() {
		assertEquals("\nAttrezzo sbloccante: " + this.attrezzoSbloccante, stanzaBloccata.infoAttrezzoSbloccante());
	}
	 
	 
	 
}
