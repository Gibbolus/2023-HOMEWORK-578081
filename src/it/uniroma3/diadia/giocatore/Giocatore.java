package it.uniroma3.diadia.giocatore;


public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;	
	private Borsa borsa;
	
	private int cfu = CFU_INIZIALI;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa(20);
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public boolean isVivo() {
		if(this.cfu == 0)
			return false;
		else
			return true;
	}
	
}
