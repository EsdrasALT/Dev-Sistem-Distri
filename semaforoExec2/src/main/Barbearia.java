package main;

public class Barbearia extends Thread {
	
	private final int numCadeiras;
	private int clientesEsperando = 0;

	public Barbearia(int numCadeiras) {
	    this.numCadeiras = numCadeiras;
	}

	public synchronized void cortarCabelo() throws InterruptedException {
	    while (clientesEsperando == 0) {
	        System.out.println("Barbeiro dormindo...");
	        wait();
	    }

	    // Há cliente esperando
	    clientesEsperando--;
	    System.out.println("Barbeiro cortando cabelo...");
	    Thread.sleep(3000); // simula tempo de corte
	    System.out.println("Corte finalizado.");
	}

	public synchronized void esperarCorte(String nomeCliente) throws InterruptedException {
	    if (clientesEsperando == numCadeiras) {
	        System.out.println(nomeCliente + " foi embora. Sem cadeiras disponíveis.");
	        return;
	    }

	    clientesEsperando++;
	    System.out.println(nomeCliente + " está esperando. Clientes na sala: " + clientesEsperando);
	    notify(); // acorda o barbeiro
	}

}
