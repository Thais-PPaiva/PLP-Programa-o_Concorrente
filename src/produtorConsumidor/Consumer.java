package produtorConsumidor;

public class Consumer extends Thread {
	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		for (int i=0; i<5; i++) {
			this.buffer.remove();
		}
	}
}
