package semaforoExer5;

public class Leitor extends Thread {
    private final LeitoresEscritores controle;
    private final String nome;

    public Leitor(LeitoresEscritores controle, String nome) {
        this.controle = controle;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                controle.iniciarLeitura(nome);
                Thread.sleep((int) (Math.random() * 5000)); // Simula tempo de leitura
                controle.terminarLeitura(nome);
                Thread.sleep((int) (Math.random() * 5000)); // Simula espera até próxima leitura
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
