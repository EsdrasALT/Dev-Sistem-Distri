package semaforoExer3;
import java.util.concurrent.Semaphore;

public class ContadorLimitado {
    private int valorAtual;
    private final int minimo;
    private final int maximo;

    // Semáforos para controlar incremento e decremento
    private final Semaphore podeIncrementar;
    private final Semaphore podeDecrementar;

    public ContadorLimitado(int minimo, int maximo, int valorInicial) {
        if (minimo > valorInicial || valorInicial > maximo) {
            throw new IllegalArgumentException("Valor inicial fora dos limites.");
        }
        this.minimo = minimo;
        this.maximo = maximo;
        this.valorAtual = valorInicial;

        // Semáforo com número de permissões baseados nos limites
        this.podeIncrementar = new Semaphore(maximo - valorInicial);
        this.podeDecrementar = new Semaphore(valorInicial - minimo);
    }

    public void incrementa() throws InterruptedException {
        // Espera permissão para incrementar
        podeIncrementar.acquire();
        synchronized (this) {
            valorAtual++;
            System.out.println("Incrementado: " + valorAtual);
        }
        // Libera uma permissão de decremento
        podeDecrementar.release();
    }

    public void decrementa() throws InterruptedException {
        // Espera permissão para decrementar
        podeDecrementar.acquire();
        synchronized (this) {
            valorAtual--;
            System.out.println("Decrementado: " + valorAtual);
        }
        // Libera uma permissão de incremento
        podeIncrementar.release();
    }

    public synchronized int getValorAtual() {
        return valorAtual;
    }
}

