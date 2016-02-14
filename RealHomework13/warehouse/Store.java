package warehouse;

import java.util.ArrayList;
import java.util.Random;
import java.util.Map.Entry;
import java.util.TreeMap;

import warehouse.Warehouse.Type;

public class Store extends Thread {
	
	private static int MIN_QTY = 5;

	private String name;
	private Warehouse warehouse;
	private TreeMap<Type, TreeMap<String, Integer>> products;

	public Store(String name, Warehouse warehouse) {
		this.name = name;
		this.warehouse = warehouse;
		products = new TreeMap<>();
		products.put(Warehouse.Type.WINES, new TreeMap<String, Integer>());
		products.get(Warehouse.Type.WINES).put("Castra Rubra", 10);
		products.put(Warehouse.Type.VEGIES, new TreeMap<String, Integer>());
		products.get(Warehouse.Type.VEGIES).put("Kartof", 15);
		products.put(Warehouse.Type.MEAT, new TreeMap<String, Integer>());
		products.get(Warehouse.Type.MEAT).put("Teueshko", 15);
	}

	public synchronized void sell(Type type, String product) {
		Random r = new Random();
		if (hasProductInStock(type, product)) {
			Integer currentQty = products.get(type).get(product);
			Integer soldQty = r.nextInt(4) + 1;
			products.put(type, new TreeMap<>());
			products.get(type).put(product, currentQty - soldQty);
			System.out.println(name + " has just sold " + soldQty +" from " + product );
			notifyAll();
		} else {
			System.out.println("You ain't buying nothing kiddo.");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean hasProductInStock(Type type, String prod){ 
		if(products.get(type).get(prod) <= MIN_QTY) { 
			return false;
		}
		
		return true;
	}

	public synchronized void supply() {
		ArrayList<String> zeroStocks = getZeroStocks();
		if(zeroStocks.size() > 0) { 
			askForZeroStock(zeroStocks);
			notifyAll();
		} else { 
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ArrayList<String> getZeroStocks() {
		ArrayList<String> productsFromSupplier = new ArrayList<>();
		for (Entry<Warehouse.Type, TreeMap<String, Integer>> prd : this.products.entrySet()) {
			for (Entry<String, Integer> subPrd : prd.getValue().entrySet()) {
				if (subPrd.getValue() <= MIN_QTY) {
					productsFromSupplier.add(subPrd.getKey());
				}
			}
		}
	
		return productsFromSupplier;
	}

	private void askForZeroStock(ArrayList<String> productToGet) { 
		
		for (String stock : productToGet) { 
			this.warehouse.supplyStores(stock);
			System.out.println(name + " has delivered 15 " + stock + " from the Warehouse to the store.");
			
		}
		for (String s: productToGet) { 
			for(TreeMap<String, Integer> subPrds: products.values()) { 
				if (subPrds.containsKey(s)) { 
					subPrds.put(s, subPrds.get(s)+ 15);
					
				}
			}
		}
	}
	
	public TreeMap<Type, TreeMap<String, Integer>> getProducts() {
		return products;
	}

	public String getStoreName() {
		return name;
	}

	@Override
	public void run() {
		while(true) { 
			this.supply();
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
