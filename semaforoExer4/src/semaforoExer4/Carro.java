package semaforoExer4;

class Carro extends Thread {
    MontanhaRussa montanhaRussa;
    int capacidade;

    public Carro(MontanhaRussa montanhaRussa, int capacidade) {
        this.montanhaRussa = montanhaRussa;
        this.capacidade = capacidade;
    }

    public void run() {
        try {
            while (true) {
                montanhaRussa.carregar(capacidade);
                montanhaRussa.andar();
                montanhaRussa.descarregar(capacidade);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
