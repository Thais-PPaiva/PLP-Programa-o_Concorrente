package produtorConsumidor;

import java.util.Random;

public class Producer extends Thread {
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			this.buffer.insert(random.nextInt(100));
		}
	}
}
