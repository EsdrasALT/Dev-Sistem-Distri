package main;

public class LetraAB implements Runnable {
    private final String letra;

    public LetraAB(String letra) {
        this.letra = letra;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread " + letra);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}