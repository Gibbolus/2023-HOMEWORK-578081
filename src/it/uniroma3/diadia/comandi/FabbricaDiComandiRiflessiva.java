package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	@Override
	public AbstractComando costruisciComando(String istruzione, IO io) throws Exception {
		Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
		String nomeComando = null; // es. ‘vai’
		String parametro = null; // es. ‘sud’
		AbstractComando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
		try {
		StringBuilder nomeClasse 
		= new StringBuilder("it.uniroma3.diadia.comandi.Comando");
//		if(nomeComando.charAt(0))
		
		nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) ); 
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’
		
		nomeClasse.append( nomeComando.substring(1) ) ;
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoVai’
		comando = (AbstractComando)Class.forName(nomeClasse.toString()).newInstance();
		}
		catch (Exception e) {
			comando = new ComandoNonValido();
		}
		comando.setParametro(parametro);
		comando.setIo(io);
		
		return comando;
	}
}
