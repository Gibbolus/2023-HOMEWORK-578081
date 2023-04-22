package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

	public static IO io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		io.showMsg("Comando non valido");
		return;
	}

	@Override
	public void setParametro(String parametro) {	
	}

	@Override
	public String getNome() {
		return null;
	}

	@Override
	public String getParametro() {
		return null;
	}

}
