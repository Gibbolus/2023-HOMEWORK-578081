package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza{
	
	private String direzioneBloccata;
	private String nomeAttrezzo;
	
	
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
