package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	private final static String NOME = "guarda";


	@Override
	public void esegui(Partita partita) {
		this.getIo().showMsg(partita.getStanzaCorrente().getDescrizione());
		this.getIo().showMsg("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		this.getIo().showMsg(partita.getGiocatore().getBorsa().toString());

	}

	@Override
	public String getNome() {
		return NOME;
	}
}
