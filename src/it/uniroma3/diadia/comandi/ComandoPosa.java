package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{

	private final static String NOME = "posa";


	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		if(a==null) {
			this.getIo().showMsg("Attrezzo non presente nella borsa!");
			return;
		}
		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getLabirinto().getStanzaIniziale().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
		}
		else {
			this.getIo().showMsg("Non c'e' spazio nella stanza per poter inserire questo attrezzo!");
		}
	}

	@Override
	public String getNome() {
		return NOME;

	}
}
