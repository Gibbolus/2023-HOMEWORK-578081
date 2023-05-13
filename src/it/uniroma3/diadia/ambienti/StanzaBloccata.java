package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza{
	
	private String direzioneBloccata;
	private String nomeAttrezzo;
	
	/**
	 * Una classe che estende Stanza. La stanza bloccata blocca la una delle direzioni.
	 * @param nome nome della stanza bloccata.
	 * @param direzioneBloccata direzione bloccata della stanza.
	 * @param nomeAttrezzo nome dell'attrezzo per sbloccare la direzione.
	 * @see Stanza
	 */
	public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzo) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.nomeAttrezzo = nomeAttrezzo;
	}
	

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(this.nomeAttrezzo))
			return this;
		return super.getStanzaAdiacente(direzione);
	}
	
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(nomeAttrezzo)) {
			return super.getDescrizione() + this.infoDirezione() + this.infoAttrezzoSbloccante(); 
		}
		return super.getDescrizione();			
	}
	
	public String infoDirezione() {
		return "\nDirezione bloccata: " + this.direzioneBloccata;
	}
	
	public String infoAttrezzoSbloccante() {
		return "\nAttrezzo sbloccante: " + this.nomeAttrezzo;
	}
	

}
