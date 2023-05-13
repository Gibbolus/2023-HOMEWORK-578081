package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{
	
	static final protected int SOGLIA_MAGICA_DEAFULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	/**
	 * Una classe che estende Stanza. La stanza magica una volta che un attrezzo viene posato per 
	 * un numero determinato di volte , il nome viene invertito.
	 * @param nome nome della stanza magica.
	 * @see Stanza
	 */
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEAFULT);
	}
	
	
	/**
	 * Una classe che estende Stanza. La stanza magica una volta che un attrezzo viene posato per 
	 * un numero determinato di volte , il nome viene invertito.
	 * @param nome nome della stanza magica.
	 * @param soglia numero di volte che l'oggetto deve essere posto per avere l'effetto magico.
	 * @see Stanza
	 */
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if(this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}
	
	/**
	 * Un metodo che inverte il nome dell'attrezzo.
	 * @param attrezzo una variabile Attrezzo dell'attrezzo da modificare.
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
		
	}
	
	
	public boolean isMagica() {
	    return this.sogliaMagica != SOGLIA_MAGICA_DEAFULT;
	}

}
