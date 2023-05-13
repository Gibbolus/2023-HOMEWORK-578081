package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

class BorsaTest {
	
	private Borsa borsa;
	private Borsa borsaPiena;
	private Borsa borsaVuota;
	private Borsa borsaSorted;
	private Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
	private Attrezzo attrezzoPesante = new Attrezzo("attrezzoPesante", 10);
	private Attrezzo A = new Attrezzo("A", 4);
	private Attrezzo B = new Attrezzo("B", 1);
	private Attrezzo C = new Attrezzo("C", 1);
	private Attrezzo D = new Attrezzo("D", 1);
	
	@BeforeEach
	public void setUp() {
		/* setUp borse*/
		this.borsa = new Borsa();
		this.borsaPiena = new Borsa();
		this.borsaVuota = new Borsa();
		this.borsaSorted = new Borsa();
		
		/*add attrezzo*/
		this.borsa.addAttrezzo(attrezzo);
		
		this.borsaPiena.addAttrezzo(attrezzoPesante);
		
		this.borsaSorted.addAttrezzo(D);
		this.borsaSorted.addAttrezzo(C);
		this.borsaSorted.addAttrezzo(B);
		this.borsaSorted.addAttrezzo(A);

	}
	
	@Test
	void testAddAttrezzo() {
		assertFalse(this.borsaPiena.addAttrezzo(attrezzoPesante));
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	void testGetAttrezzo() {
		assertEquals(this.attrezzoPesante, this.borsaPiena.getAttrezzo("attrezzoPesante"));
	}

	@Test
	void testGetPeso() {
		assertEquals(10, this.borsaPiena.getPeso());
		assertEquals(0, this.borsaVuota.getPeso());
	}

	@Test
	void testRemoveAttrezzo() {
		assertTrue(this.borsa.removeAttrezzo("attrezzo"));
	}
	
	@Test
	void testHasAttrezzo() {
		assertTrue(this.borsa.hasAttrezzo("attrezzo"));
	}

	@Test
	void testIsEmpty() {
		assertTrue(this.borsaVuota.isEmpty());
		assertFalse(this.borsaPiena.isEmpty());
	}
	
	@Test
	void testAddAttrezzoDoppione() {
		assertEquals(1, this.borsa.getAttrezzi().size());
		assertFalse(borsa.addAttrezzo(attrezzo));
	}
	
	/*
	 * 
	 * ORDINAMENTI
	 * 
	 */

	@Test
	void testOrdinamentoPerNome() {
		List<Attrezzo> lista = Arrays.asList(new Attrezzo("A", 4),  new Attrezzo("B", 1), new Attrezzo("C", 1), new Attrezzo("D", 1));
		assertEquals(lista.toString(), this.borsaSorted.getContenutoOrdinatoPerNome().toString()); 
	}
	
	
	@Test
	void testOrdinamentoPerPesoNome() {
		List<Attrezzo> lista = Arrays.asList(new Attrezzo("B", 1),  new Attrezzo("C", 1), new Attrezzo("D", 1), new Attrezzo("A", 4));
		assertEquals(lista.toString(), this.borsaSorted.getContenutoOrdinatoPerPesoNome().toString());
	}
	
	@Test
	void testRaggruppamentoPerPeso() {
	//	List<Attrezzo> lista = Arrays.asList(new Attrezzo("B", 1),  new Attrezzo("C", 1), new Attrezzo("D", 1), new Attrezzo("A", 4));
		assertEquals("{1=[B (1kg), C (1kg), D (1kg)], 4=[A (4kg)]}", this.borsaSorted.getContenutoRaggruppatoPerPeso().toString());
	}
	
	
	@Test
	void testSortedSetOrdinatoPerPeso() {
		List<Attrezzo> lista = Arrays.asList(new Attrezzo("B", 1),  new Attrezzo("C", 1), new Attrezzo("D", 1), new Attrezzo("A", 4));
		assertEquals(lista.toString(), this.borsaSorted.getSortedSetOrdinatoPerPeso().toString());
	}
	
	
	
}
