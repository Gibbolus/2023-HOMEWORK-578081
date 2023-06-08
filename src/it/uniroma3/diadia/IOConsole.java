package it.uniroma3.diadia;

import java.util.Scanner;



public class IOConsole implements IO{
	
	
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
	}
	
	
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