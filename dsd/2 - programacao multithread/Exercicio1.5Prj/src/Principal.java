import java.util.LinkedList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		final int TAMANHO = 10000;
		
		List<Integer> lista = new LinkedList<Integer>();
		
		for(int i = 0; i < TAMANHO; i++)
			lista.add(i);
		
//		ListIterator<Integer> it = lista.listIterator();
//		while(it.hasNext())
//			System.out.println(it.next());
		
		int elemento = -5000;
		
		Pesquisa direto = new Pesquisa(lista, elemento, true);
		Pesquisa reverso = new Pesquisa(lista, elemento, false);
		
		direto.setColega(reverso);
		reverso.setColega(direto);
		
		direto.start();
		reverso.start();
		
		try {
			direto.join();
			reverso.join();
		}
		catch (InterruptedException e) {}
		
		boolean diretoEncontrou = direto.isEncontrado();
		boolean reversoEncontrou = reverso.isEncontrado();
		
//		if(diretoEncontrou)
//			System.out.println("Thread direta encontrou o elemento");
//		else
//			System.out.println("Thread direta não encontrou o elemento");
//		
//		if(reversoEncontrou)
//			System.out.println("Thread reversa encontrou o elemento");
//		else
//			System.out.println("Thread reversa não encontrou o elemento");
		
		if(diretoEncontrou || reversoEncontrou)
			System.out.println("Elemento " + elemento + " foi encontrado na lista");
		else
			System.out.println("Elemento " + elemento + " não foi encontrado na lista");

	}

}
