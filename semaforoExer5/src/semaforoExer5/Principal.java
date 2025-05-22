package semaforoExer5;

public class Principal {
    public static void main(String[] args) {
        LeitoresEscritores controle = new LeitoresEscritores();

        // Cria e inicia leitores
        for (int i = 1; i <= 5; i++) {
            new Leitor(controle, "Leitor-" + i).start();
        }

        // Cria e inicia escritores
        for (int i = 1; i <= 2; i++) {
            new Escritor(controle, "Escritor-" + i).start();
        }
    }
}
