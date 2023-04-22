package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	public static IO io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		io.showMsg("Grazie di aver giocato!");
		return;
	}

	@Override
	public void setParametro(String parametro) {		
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