package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza{
	
	private String attrezzo;

	/**
	 * Una classe che estende Stanza. La stanza buia non permette di vedere 
	 * la descrizione di tale ammeno che non ci sia un attrezzo specifico dentro.
	 * @param nome nome della stanza buia.
	 * @param attrezzo attrezzo per illuminare la stanza buia.
	 * @see Stanza
	 */
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzo))
			return super.getDescrizione();
		else
			return "Qui c'è buio pesto";
	}

}
