package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Set<Attrezzo> attrezzi;
	private int pesoMax;
	
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
		this.attrezzi = new HashSet<Attrezzo>();
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
	}

	/**
	 * Aggiunge un attrezzo nella borsa.
	 * @param attrezzo il nome della variabile Attrezzo dell'attrezzo da aggiungere.
	 * @return ritorna True se l'attrezzo viene aggiunto, altrimenti False.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) 
			return false;
		return this.attrezzi.add(attrezzo);
	}
	
	/**
	 * Fornisce il peso massimo che può avere la borsa.
	 * @return ritorna un intero pari al peso massimo della borsa.
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	 * Restituisce il Set di attrezzi.
	 */
	public Set<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}
	
	/**
	 * Restituisce l'attrezzo basandosi sul nome.
	 * @param nomeAttrezzo il nome dell'attrezzo da ottenere.
	 * @return ritorna l'attrezzo cercato.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoTrovato = null;
		for(Attrezzo attrezzo : attrezzi)
			if (attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoTrovato = attrezzo;
		return attrezzoTrovato;
	}

	/**
	 * Fornisce il peso totale della borsa.
	 * @return ritorna un intero pari al peso della borsa.
	 */
	public int getPeso() {
		int peso = 0;
		for(Attrezzo attrezzo : attrezzi)
				peso += attrezzo.getPeso();
		return peso;
	}
	
	/**
	 * Controlla se la borsa è vuota.
	 * @return ritorna True se la borsa è vuota, altrimenti False.
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	/**
	 * Controlla se un attrezzo è presente nella borsa.
	 * @param nomeAttrezzo il nome dell'attrezzo da rimuovere.
	 * @return ritorna True se l'attrezzo è presente nella borsa, altrimenti False.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	
	/**
	 * Rimuove un attrezzo dalla borsa.
	 * @param nomeAttrezzo il nome dell'attrezzo da rimuovere.
	 * @return ritorna True se l'attrezzo viene rimosso, altrimenti False.
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		while(this.attrezzi.iterator().hasNext()) {
			if(this.attrezzi.iterator().next().getNome().equals(nomeAttrezzo)) {
				this.attrezzi.remove(this.attrezzi.iterator().next());
				return true;
			}
		}
		return false;
	}
	

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for(Attrezzo attrezzo : attrezzi)
				if(attrezzo!=null)
					s.append(attrezzo.toString()+" ");
			
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	/*
	 * 
	 * ORDINAMENTI
	 * 
	 */
	
	/**
	 * Ordina una Set di attrezzi basandosi su un comparatore esterno. 
	 * Ordinamento in base al peso, in caso di parità in base al nome.
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPesoNome(){
		ComparatorePerPesoNome comparatore = new ComparatorePerPesoNome();
		List<Attrezzo> attrezziOrdinatiPerPeso = new ArrayList<Attrezzo>();
		attrezziOrdinatiPerPeso.addAll(this.attrezzi);
		Collections.sort(attrezziOrdinatiPerPeso, comparatore);
		return attrezziOrdinatiPerPeso;
	}
	
	
	/**
	 * Ordina una Set di attrezzi basandosi su una comparazione che avviene nella classe "Attrrezzo". 
	 * Ordinamento in base al nome.
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<Attrezzo>(this.attrezzi);
		return attrezziOrdinati;
	}
	
	
	/**
	 * Raggruppa una Set di attrezzi. 
	 * Raggruppamento per peso.
	 */
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();
		Set<Attrezzo> attrezziRaggruppati = new HashSet<Attrezzo>();
		for(Attrezzo a : this.attrezzi) {
			attrezziRaggruppati = mappa.get(a.getPeso());
			if(attrezziRaggruppati == null)
				attrezziRaggruppati = new HashSet<Attrezzo>();
			attrezziRaggruppati.add(a);
			mappa.put(a.getPeso(), attrezziRaggruppati);
		}
		return mappa;
	}
	
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		ComparatorePerPesoNome comparatore = new ComparatorePerPesoNome();
		SortedSet<Attrezzo> attrezziOrdinatiPerPeso = new TreeSet<Attrezzo>(comparatore);
		attrezziOrdinatiPerPeso.addAll(this.attrezzi);
		return attrezziOrdinatiPerPeso;
	}
	
	
	
	

}