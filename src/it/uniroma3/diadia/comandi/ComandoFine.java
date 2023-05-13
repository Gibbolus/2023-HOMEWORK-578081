package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.showMsg("Grazie di aver giocato!");
		return;
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
		return "fine";
	}

	@Override
	public String getParametro() {
		return null;
	}
 
}
