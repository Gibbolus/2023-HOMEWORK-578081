package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza corrente;
	private Stanza vincente;
	
	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
		corrente = new Stanza("corrente");
		labirinto.setStanzaCorrente(corrente);
		vincente = new Stanza("vincente");
		labirinto.setStanzaVincente(vincente);
	}

	@Test
	void testGetStanzaCorrente() {
		assertEquals(corrente, labirinto.getStanzaCorrente());
	}

	@Test
	void testGetStanzaVincente() {
		assertEquals(vincente, labirinto.getStanzaVincente());
	}
	
	
	@Test
	void testLabirintoNotNull() {
		assertNotNull(this.labirinto);
	}
	
	
}
