package semaforoExer3;

public class TesteContador {
    public static void main(String[] args) {
        ContadorLimitado contador = new ContadorLimitado(0, 5, 2);

        Runnable incrementador = () -> {
            try {
                while (true) {
                    contador.incrementa();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable decrementador = () -> {
            try {
                while (true) {
                    contador.decrementa();
                    Thread.sleep(700);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(incrementador).start();
        new Thread(decrementador).start();
    }
}
