package main;

public class Barbeiro extends Thread {
	private final Barbearia barbearia;
	
	public Barbeiro(Barbearia barbearia) {
	    this.barbearia = barbearia;
	}

	public void run() {
	    try {
	        while (true) {
	            barbearia.cortarCabelo();
	        }
	    } catch (InterruptedException e) {
	        System.out.println("Barbeiro encerrando turno.");
	    }
	}

}
