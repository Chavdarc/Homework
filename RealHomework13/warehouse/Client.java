package warehouse;

import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class Client extends Thread{
	
	private String name;
	private Store store;
	private boolean hasMoney;
	
	public Client(String name, Store store) {
		this.name = name;
		this.store = store;
		
	}
	
	private void writesALoanPaper(String text) {
		Singleton.getInstance().writeToFile(text);
	}
	
	private synchronized void randomPurchase() { 
		Random r = new Random();
		for (Entry<Warehouse.Type, TreeMap<String, Integer>> product: store.getProducts().entrySet()) { 
			for (Entry<String, Integer> subProdcut: product.getValue().entrySet()) {
				if(r.nextInt(3) == 2) { 
				store.sell(product.getKey(), subProdcut.getKey());
				}
			}
		}
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		
		while(true) { 
			Random r = new Random();
			hasMoney = r.nextBoolean();
			randomPurchase();
			if (hasMoney) {
				System.out.println(Thread.currentThread().getName() + " has just made a purchase with " + store.getStoreName());
			} else { 
				System.out.println(Thread.currentThread().getName() + " has just made a purchase with " + store.getStoreName()+ " but forgot his money and owns 25lv. to the old lady owner.");
				writesALoanPaper(Thread.currentThread().getName() + " has just made a purchase with " + store.getStoreName()+ " but forgot his money and owns 25lv. to the old lady owner.");
			}
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
