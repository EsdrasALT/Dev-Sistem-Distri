import java.util.List;
import java.util.ListIterator;

public class Pesquisa extends Thread {
	
	private List<Integer> lista = null;
	private int elemento = 0;
	private boolean direto = false;
	private Pesquisa colega = null;
	
	private boolean encontrado = false;
	
	public Pesquisa(List<Integer> lista, int elemento, boolean direto) {
		super();
		this.lista = lista;
		this.elemento = elemento;
		this.direto = direto;
	}
	
	public void setColega(Pesquisa colega) {
		this.colega = colega;
	}
	
	public boolean isEncontrado() {
		return this.encontrado;
	}

	@Override
	public void run() {
		ListIterator<Integer> it = lista.listIterator(direto ? 0 : lista.size());
		
		if(direto) {
			// Pesquisa no sentido direto
			while(it.hasNext()) {
				if(this.isInterrupted())
					break;
				int e = it.next();
				if(this.elemento == e) {
					colega.interrupt();
					this.encontrado = true;
					break;
				}
			}
		}
		else {
			// Pesquisa no sentido reverso
			while(it.hasPrevious()) {
				if(this.isInterrupted())
					break;
				int e = it.previous();
				if(this.elemento == e) {
					colega.interrupt();
					this.encontrado = true;
					break;
				}
			}
		}
	}

}
