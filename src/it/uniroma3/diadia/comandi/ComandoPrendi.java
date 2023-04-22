package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando{
	private String attrezzo;
	public static IO io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		if(this.attrezzo==null) {
			io.showMsg("Che attrezzo vuoi prendere?");
			this.attrezzo = io.readLine();
		}
		if(stanzaCorrente.hasAttrezzo(this.attrezzo)) {
			Attrezzo cerato = stanzaCorrente.getAttrezzo(this.attrezzo);
			if(borsa.addAttrezzo(cerato))
				stanzaCorrente.removeAttrezzo(cerato);
			io.showMsg("Attrezzo preso");
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
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}
	
}
