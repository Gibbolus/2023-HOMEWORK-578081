package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	
	private String risposta;
	private String oggetto;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		if(oggetto == null) {
			io.showMsg("Cosa vuoi guardare?");
			oggetto = io.readLine();
		}
		if(oggetto.equals("stanza"))
			io.showMsg(partita.getStanzaCorrente().getDescrizione());
		else if(oggetto.equals("borsa")) {
			io.showMsg("0-Ordinamento");
			io.showMsg("1-Ordinamento per peso");
			io.showMsg("2-Ordinamento per nome");
			io.showMsg("3-Raggruppamento per peso");
			this.risposta = io.readLine();
			if(risposta.equals("0"))
				io.showMsg(partita.getGiocatore().getBorsa().toString());
			else if(risposta.equals("1"))
				io.showMsg(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerPesoNome().toString());
			else if(risposta.equals("2"))
				io.showMsg(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString());
			else if(risposta.equals("3"))
				io.showMsg(partita.getGiocatore().getBorsa().getContenutoRaggruppatoPerPeso().toString());
		}
		else
			io.showMsg("Oggetto Inesistente");
	}

	@Override
	public void setParametro(String parametro) {
		this.oggetto = parametro;
	}

	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}	
	
	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
