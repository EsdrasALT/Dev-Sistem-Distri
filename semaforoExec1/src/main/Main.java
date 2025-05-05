package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Início da impressão");

        Thread letraA = new Thread(new LetraAB("A"));
        Thread letraB = new Thread(new LetraAB("B"));
        Thread letraC = new Thread(new LetraC());

        letraA.start();
        letraB.start();
        letraC.start();
    }
}
