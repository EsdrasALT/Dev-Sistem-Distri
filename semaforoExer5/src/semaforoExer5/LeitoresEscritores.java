package semaforoExer5;
import java.util.concurrent.Semaphore;

public class LeitoresEscritores {
    private int leitoresAtivos = 0;

    private final Semaphore mutex = new Semaphore(1); // Protege o contador de leitores
    private final Semaphore db = new Semaphore(1);    // Protege o acesso ao recurso compartilhado
    private final Semaphore fila = new Semaphore(1);  // Garante ordem justa

    public void iniciarLeitura(String nome) throws InterruptedException {
        fila.acquire(); // Entra na fila
        mutex.acquire();
        leitoresAtivos++;
        if (leitoresAtivos == 1) {
            db.acquire(); // Primeiro leitor bloqueia escritores
        }
        mutex.release();
        fila.release(); // Libera para outros leitores ou escritores
        System.out.println(nome + " está LENDO.");
    }

    public void terminarLeitura(String nome) throws InterruptedException {
        mutex.acquire();
        leitoresAtivos--;
        System.out.println(nome + " terminou de LER.");
        if (leitoresAtivos == 0) {
            db.release(); // Último leitor libera escrita
        }
        mutex.release();
    }

    public void iniciarEscrita(String nome) throws InterruptedException {
        fila.acquire();  // Garante ordem justa
        db.acquire();    // Acesso exclusivo ao recurso
        System.out.println(nome + " está ESCREVENDO.");
    }

    public void terminarEscrita(String nome) {
        System.out.println(nome + " terminou de ESCREVER.");
        db.release();
        fila.release();  // Libera para próximo da fila
    }
}
