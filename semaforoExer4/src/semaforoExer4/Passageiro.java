package semaforoExer4;

class Passageiro extends Thread {
    MontanhaRussa montanhaRussa;

    public Passageiro(MontanhaRussa montanhaRussa) {
        this.montanhaRussa = montanhaRussa;
    }

    public void run() {
        try {
            while (true) {
                montanhaRussa.podeEmbarcar.acquire(); // Espera o carro permitir embarque
                montanhaRussa.embarcar();

                montanhaRussa.podeDesembarcar.acquire(); // Espera o carro permitir desembarque
                montanhaRussa.desembarcar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
