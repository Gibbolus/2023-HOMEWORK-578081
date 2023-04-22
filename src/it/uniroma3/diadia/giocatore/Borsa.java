package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	public final static int NUMERO_MAX_ATTREZZI = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private static IOConsole iO = new IOConsole();
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[NUMERO_MAX_ATTREZZI]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			iO.showMsg("Borsa troppo pesante!");
			return false;
		}
		if(this.numeroAttrezzi==NUMERO_MAX_ATTREZZI)
			return false;
		for(int i=0; i<NUMERO_MAX_ATTREZZI; i++) {
			if(attrezzi[i]==null) {
				attrezzi[i]=attrezzo;
				this.numeroAttrezzi++;
				return true;
			}
		}
		return false;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i=0; i<NUMERO_MAX_ATTREZZI; i++)
			if(attrezzi[i]!=null) {
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
			}
		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<NUMERO_MAX_ATTREZZI; i++) {
			if(attrezzi[i]!=null) {
				peso += this.attrezzi[i].getPeso();
			}
		}
		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public boolean removeAttrezzo(String nomeAttrezzo) {
		if(numeroAttrezzi==0) {
			iO.showMsg("La borsa è vuota, nessun attrezzo da rimuovere");
			return false;
		}
		for (int i=0; i<NUMERO_MAX_ATTREZZI; i++) {
			if(attrezzi[i]!=null) {
				if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
					attrezzi[i]=null;
					numeroAttrezzi--;
					iO.showMsg("Attrezzo rimosso dalla borsa");
					return true;
				}
			}
		}
		iO.showMsg("Nessun attrezzo con questo nome trovato");
		return false;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<NUMERO_MAX_ATTREZZI; i++)
				if(attrezzi[i]!=null)
					s.append(attrezzi[i].toString()+" ");
			
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

}