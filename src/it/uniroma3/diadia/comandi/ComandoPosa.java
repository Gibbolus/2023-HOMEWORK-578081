package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando{
	private String attrezzo;
	private IO io;
	
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		if(this.attrezzo==null) {
			io.showMsg("Che attrezzo vuoi posare?");
			this.attrezzo = io.readLine();
		}
		if(borsa.hasAttrezzo(this.attrezzo)) {
			Attrezzo cercato = borsa.getAttrezzo(this.attrezzo);
			if(borsa.removeAttrezzo(attrezzo))
				io.showMsg("Attrezzo rimosso dalla borsa");
				stanzaCorrente.addAttrezzo(cercato);
		}
		else
			io.showMsg("Attrezzo non trovato");
		io.showMsg(borsa.toString());
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;	
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}	

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}

}
