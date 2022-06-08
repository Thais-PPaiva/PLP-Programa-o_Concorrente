package produtorConsumidor;
import java.util.concurrent.Semaphore;

public class Buffer {
	private int item;
	
	private Semaphore semFull;
	private Semaphore semEmpty;
	
	public Buffer() {
		this.semFull = new Semaphore(0);
		this.semEmpty = new Semaphore(5);
	}
	
	public void insert(int novoItem) {
		try {
			semEmpty.acquire();
			this.item = novoItem;
			System.out.println("PRODUZIDO(" + this.item+")");
			semFull.release();
			
		}catch(InterruptedException ex) {
			System.out.println("BUFFER: Erro ao inserir" + ex.getMessage());
		}
	}
	
	public void remove() {
		try {
			semFull.acquire();
			System.out.println("CONSUMIDO (" + this.item + ")");
			semEmpty.release();
			
		}catch(InterruptedException ex) {
			System.out.println("BUFFER: Erro ao retirar" + ex.getMessage());
		}
	}
}
