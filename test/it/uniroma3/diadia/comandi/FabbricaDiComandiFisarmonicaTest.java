package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica factory;
	
	@BeforeEach
	public void setUp() {
		factory = new FabbricaDiComandiFisarmonica();		
	}
	
	@Test
	void testComandoNonValido() {
		Comando comando = factory.costruisciComando("");
		assertNull(comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void testComandoVai() {
		Comando comando = factory.costruisciComando("vai sud");
		assertEquals("vai", comando.getNome());
		assertEquals("sud", comando.getParametro());
	}
	
	@Test
	void testComandoPrendi() {
		Comando comando = factory.costruisciComando("prendi attrezzo");
		assertEquals("prendi", comando.getNome());
		assertEquals("attrezzo", comando.getParametro());
	}
	
	@Test
	void testComandoPosa() {
		Comando comando = factory.costruisciComando("posa osso");
		assertEquals("posa", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}
	
	@Test
	void testComandoFine() {
		Comando comando = factory.costruisciComando("fine");
		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void testComandoGuarda() {
		Comando comando = factory.costruisciComando("guarda");
		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
}