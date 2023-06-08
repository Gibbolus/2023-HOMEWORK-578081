package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza{
	
	private Direzione direzioneBloccata;
	private String attrezzoSbloccante;;
	
	/**
	 * Una classe che estende Stanza. La stanza bloccata blocca la una delle direzioni.
	 * @param nome nome della stanza bloccata.
	 * @param i direzione bloccata della stanza.
	 * @param nomeAttrezzo nome dell'attrezzo per sbloccare la direzione.
	 * @see Stanza
	 */
	public StanzaBloccata(String nome, Direzione i, String nomeAttrezzo) {
		super(nome);
		this.direzioneBloccata = i;
		this.attrezzoSbloccante = nomeAttrezzo;
	}
	

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSbloccante + " e posalo nella stanza";

		if(!this.hasAttrezzo(attrezzoSbloccante))
			return bloccata;
		return super.getDescrizione();
	}
	
	public String infoDirezione() {
		return "\nDirezione bloccata: " + this.direzioneBloccata;
	}
	
	public String infoAttrezzoSbloccante() {
		return "\nAttrezzo sbloccante: " + this.attrezzoSbloccante;
	}
	

}
