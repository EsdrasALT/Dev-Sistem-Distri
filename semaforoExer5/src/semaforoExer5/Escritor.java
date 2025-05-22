package semaforoExer5;

public class Escritor extends Thread {
    private final LeitoresEscritores controle;
    private final String nome;

    public Escritor(LeitoresEscritores controle, String nome) {
        this.controle = controle;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                controle.iniciarEscrita(nome);
                Thread.sleep((int) (Math.random() * 25000)); // Simula tempo de escrita
                controle.terminarEscrita(nome);
                Thread.sleep((int) (Math.random() * 25000)); // Simula espera até próxima escrita
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
