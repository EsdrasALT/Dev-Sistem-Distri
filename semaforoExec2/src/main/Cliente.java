package main;

public class Cliente extends Thread {
	private final Barbearia barbearia;
	private final String nome;
	
	public Cliente(Barbearia barbearia, String nome) {
	    this.barbearia = barbearia;
	    this.nome = nome;
	}

	public void run() {
	    try {
	        barbearia.esperarCorte(nome);
	    } catch (InterruptedException e) {
	        System.out.println(nome + " foi interrompido.");
	    }
	}
}
