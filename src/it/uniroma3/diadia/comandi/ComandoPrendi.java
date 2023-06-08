package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	private final static String NOME = "prendi";

	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaIniziale().getAttrezzo(this.getParametro());
		if(a==null) {
			this.getIo().showMsg("Attrezzo non presente nella stanza!");
		} 
		else {
			if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				partita.getLabirinto().getStanzaIniziale().removeAttrezzo(a);
			} 
			else
				this.getIo().showMsg("Attrezzo troppo pesante per entrare nella borsa!");
			}
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
