package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	
	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo;
	
	
	@BeforeEach
	public void setUp() {
		this.stanzaMagica = new StanzaMagica("stanzaMagica");
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.stanzaMagica.addAttrezzo(attrezzo);
	}

	@Test
	void testStanzaMagicaNotNull() {
		assertNotNull(this.stanzaMagica);
	}
	
	
	@Test
	void testAttrezzoNotNull() {
		assertNotNull(this.attrezzo);
	}
	
	
	@Test
	void testIsMagic() {
		for(int i=0; i<StanzaMagica.SOGLIA_MAGICA_DEAFULT; i++) {
			this.stanzaMagica.removeAttrezzo(attrezzo);
			this.stanzaMagica.addAttrezzo(attrezzo);
		}
		assertTrue(this.stanzaMagica.hasAttrezzo("ozzertta"));
		assertEquals(2, this.stanzaMagica.getAttrezzo("ozzertta").getPeso());
	}
	
	@Test
	void testIsNotMagica() {
		assertTrue(this.stanzaMagica.addAttrezzo(this.attrezzo));
	}
	
	
	@Test
	void testAddAttrezzo() {
		for(int i=0; i<StanzaMagica.SOGLIA_MAGICA_DEAFULT-1; i++)
			assertTrue(this.stanzaMagica.addAttrezzo(attrezzo));
	}
	

}
