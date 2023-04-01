package it.uniroma3.diadia.IOConsole;

import java.util.Scanner;

public class IOConsole {
	
	
	public void showMsg(String msg) {
		System.out.println(msg);
	}
	
	
	public String readLine() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}