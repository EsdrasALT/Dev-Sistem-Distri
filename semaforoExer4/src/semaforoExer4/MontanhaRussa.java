package semaforoExer4;

import java.util.concurrent.Semaphore;

class MontanhaRussa {
    Semaphore mutex = new Semaphore(1);
    Semaphore podeEmbarcar = new Semaphore(0);
    Semaphore podeDesembarcar = new Semaphore(0);
    Semaphore todosEmbarcaram = new Semaphore(0);
    Semaphore todosDesembarcaram = new Semaphore(0);

    int passageirosEmbarcados = 0;
    int passageirosDesembarcados = 0;

    public void carregar(int capacidade) throws InterruptedException {
        // Libera vagas para embarcar
        podeEmbarcar.release(capacidade);
        // Espera todos embarcarem
        todosEmbarcaram.acquire();
    }

    public void andar() {
        System.out.println("Carro está andando com os passageiros.");
        try {
            Thread.sleep(10000); // Simula o passeio
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void descarregar(int capacidade) throws InterruptedException {
        // Libera passageiros para desembarcar
        podeDesembarcar.release(capacidade);
        // Espera todos desembarcarem
        todosDesembarcaram.acquire();
    }

    public void embarcar() throws InterruptedException {
        mutex.acquire();
        passageirosEmbarcados++;
        System.out.println("Passageiro embarcou. Total: " + passageirosEmbarcados);
        if (passageirosEmbarcados == MontanhaRussaMain.CAPACIDADE_CARRO) {
            todosEmbarcaram.release(); // Libera o carro
        }
        mutex.release();
    }

    public void desembarcar() throws InterruptedException {
        mutex.acquire();
        passageirosDesembarcados++;
        System.out.println("Passageiro desembarcou. Total: " + passageirosDesembarcados);
        if (passageirosDesembarcados == MontanhaRussaMain.CAPACIDADE_CARRO) {
            passageirosEmbarcados = 0;
            passageirosDesembarcados = 0;
            todosDesembarcaram.release(); // Libera o carro para o próximo passeio
        }
        mutex.release();
    }
}
