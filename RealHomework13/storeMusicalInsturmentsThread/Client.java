package storeMusicalInsturmentsThread;

import java.util.Random;

public class Client extends Thread{
	
	private MusicStore store; 
	
	public Client(MusicStore store, String name) {
		super(name);
		this.store = store;
	}
	
	private synchronized void purchase() { 
		Random r = new Random();
		if(!store.getInsturmentsInStore().isEmpty()) { 
			for (MusicalInstrument instrument : store.getInsturmentsInStore()) { 
				if (r.nextInt(7) == 4){ 
					this.store.sellInsturment(instrument.getName(), 1);
					System.out.println(Thread.currentThread().getName() + " has purchased 1ea from " + instrument.getName());
				}
			}
		} else { 
			System.out.println("Add instruments to the store");
		}
		
	}
	
	@Override
	public void run() {
		while(true) { 
			this.purchase();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
