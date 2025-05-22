package main;

public class Principal {
	public static void main(String[] args) {
		Barbearia barbearia = new Barbearia(3); // 3 cadeiras na sala de espera
		
	    Barbeiro barbeiro = new Barbeiro(barbearia);
	    barbeiro.start();

	    for (int i = 1; i <= 10; i++) {
	        Cliente cliente = new Cliente(barbearia, "Cliente " + i);
	        cliente.start();

	        try {
	            Thread.sleep(1000); // intervalo entre chegadas
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
