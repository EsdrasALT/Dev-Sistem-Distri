package main;

import java.util.ArrayList;
import java.util.List;

import pesquisa.Pesquisa;

public class Main {

	public static void main(String[] args) {
		int tamanhoLista = 2000;
        int qtdeThreads = 5;
        int intervalo = tamanhoLista / qtdeThreads;
        int valorProcurado = 50;

        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < tamanhoLista; i++) {
            lista.add(i);
        }

        Thread[] threads = new Thread[qtdeThreads];
        
        for (int i = 0; i < qtdeThreads; i++) {
            int inicio = i * intervalo;
            int fim = (i == qtdeThreads - 1) ? tamanhoLista : inicio + intervalo; //operador ternario 

            threads[i] = new Pesquisa(lista, inicio, fim, valorProcurado, threads);
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Pesquisa finalizada!");
	}

}
