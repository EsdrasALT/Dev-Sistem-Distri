package semaforoExer4;

public class MontanhaRussaMain {
    public static final int NUM_PASSAGEIROS = 10;
    public static final int CAPACIDADE_CARRO = 4;

    public static void main(String[] args) {
        MontanhaRussa montanhaRussa = new MontanhaRussa();

        Carro carro = new Carro(montanhaRussa, CAPACIDADE_CARRO);
        carro.start();

        for (int i = 0; i < NUM_PASSAGEIROS; i++) {
            new Passageiro(montanhaRussa).start();
        }
    }
}
