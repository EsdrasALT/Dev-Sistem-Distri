package pesquisa;

import java.util.List;

public class Pesquisa extends Thread {
    private List<Integer> array;
    private int inicio;
    private int fim;
    private int buscarValor;
    private Thread[] outrasThreads;
    private boolean encontrado = false;

    public Pesquisa(List<Integer> array, int inicio, int fim, int valorProcurado, Thread[] threads) {
        this.array = array;
        this.inicio = inicio;
        this.fim = fim;
        this.buscarValor = valorProcurado;
        this.outrasThreads = threads;
    }
    
    public boolean isEncontrado() {
        return this.encontrado;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fim; i++) {
            if (this.isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " interrompida.");
                return;
            }

            int e = array.get(i);
            System.out.println(Thread.currentThread().getName() + " processando índice " + i + " valor: " + e);

            if (this.buscarValor == e) {
                System.out.println("Valor encontrado pela " + Thread.currentThread().getName() + " no índice " + i);
                
                for (Thread essa : outrasThreads) {
                    if (essa != this) {
                    	essa.interrupt();
                    }
                }
            }	
        }
    }
}
