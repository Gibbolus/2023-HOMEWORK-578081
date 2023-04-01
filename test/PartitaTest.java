

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.Partita;

class PartitaTest {
	
	private Partita partita;

	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		Stanza finale = new Stanza("finale");
		this.partita.setStanzaCorrente(finale);
		this.partita.setStanzaVincente(finale);
	}
	

	@Test
	void testVinta() {
		assertTrue(this.partita.vinta());
	}
	
	
	@Test
	void testIsFinita() {
		assertTrue(this.partita.vinta());
	}

	@Test
	void testGetStanzaVincente() {
		assertEquals("finale", partita.getStanzaVincente().getNome());
	}

	@Test
	void testGetStanzaCorrente() {
		assertEquals("finale", partita.getStanzaCorrente().getNome());
	}



}
