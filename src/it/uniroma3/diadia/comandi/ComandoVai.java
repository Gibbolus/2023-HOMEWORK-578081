package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai extends AbstractComando {
	
	private final static String NOME = "vai";

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.getParametro() == null) {
			this.getIo().showMsg("Dove vuoi andare? Devi specificare una direzione");
		}
		if(this.getParametro()!=null )// && (Direzione.valueOf(this.getParametro()).getClass() != Direzione.class))
			try {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
			} catch(IllegalArgumentException e) {
				this.getIo().showMsg("Direzione inesistente");
				return;
			}
			
			if (prossimaStanza == null) {
			this.getIo().showMsg("Direzione inesistente");
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		this.getIo().showMsg(partita.getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}

	@Override
	public String getNome() {
		return NOME;
	}

}