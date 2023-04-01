package it.uniroma3.diadia;

import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi + <nomeAttrezzo>", "posa + <nomeAttrezzo>"};

	private Partita partita;
	public static IOConsole iO;

	public DiaDia() {
		this.partita = new Partita();
		
	}

	public void gioca() {
		String istruzione;
		iO.showMsg(MESSAGGIO_BENVENUTO);		
		do {
			istruzione = null;
			istruzione = iO.readLine();
		}
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		}
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			iO.showMsg("Comando sconosciuto");
		
		
		if (this.partita.vinta()) {
			iO.showMsg("Hai vinto!");
			return true;
		}
		else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			iO.showMsg(elencoComandi[i]);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			iO.showMsg("Dove vuoi andare?");
			direzione = iO.readLine(); 
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			iO.showMsg("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		iO.showMsg(partita.getStanzaCorrente().getDescrizione());
	}

	
	private void prendi(String attrezzo) {
		if(attrezzo==null) {
			iO.showMsg("Che attrezzo vuoi prendere?");
			attrezzo = iO.readLine();
		}
		
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		if(stanzaCorrente.hasAttrezzo(attrezzo)) {
			Attrezzo cercato = stanzaCorrente.getAttrezzo(attrezzo);
			if(borsa.addAttrezzo(cercato))
				stanzaCorrente.removeAttrezzo(cercato);

			iO.showMsg("Attrezzo preso");
		}
		else 
			iO.showMsg("Attrezzo non trovato");
		iO.showMsg(borsa.toString());
	}

	
	private void posa(String attrezzo) {
		if(attrezzo==null) {
			iO.showMsg("Che attrezzo vuoi posare?");
			attrezzo = iO.readLine();
		}
		
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		if(borsa.hasAttrezzo(attrezzo)) {
			Attrezzo cercato = borsa.getAttrezzo(attrezzo);
			borsa.removeAttrezzo(attrezzo);
			stanzaCorrente.addAttrezzo(cercato);
		}
		else 
			iO.showMsg("Attrezzo inesistente");
		iO.showMsg(borsa.toString());
		iO.showMsg(stanzaCorrente.getDescrizione());
	}
	
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		iO.showMsg("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		iO = new IOConsole();
		gioco.gioca();
		
	}
}