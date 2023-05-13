package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */


public class ComandoAiuto implements Comando{

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi + <nomeAttrezzo>", "posa + <nomeAttrezzo>", "guarda"};
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.showMsg(elencoComandi[i]);
	}

	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}	

	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}
	
}
