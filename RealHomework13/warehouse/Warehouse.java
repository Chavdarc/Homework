package warehouse;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Warehouse {

	public enum Type {
		VEGIES, WINES, MEAT
	}

	private static int MIN_QTY = 0;

	private TreeMap<Type, TreeMap<String, Integer>> products;

	public Warehouse() {
		products = new TreeMap<Type, TreeMap<String, Integer>>();
		products.put(Warehouse.Type.MEAT, new TreeMap<String, Integer>());
		products.get(Warehouse.Type.MEAT).put("Pueshko", 15);
		products.get(Warehouse.Type.MEAT).put("Teueshko", 15);
		products.get(Warehouse.Type.MEAT).put("Govejdo", 15);

		products.put(Warehouse.Type.VEGIES, new TreeMap<String, Integer>());
		products.get(Warehouse.Type.VEGIES).put("Kartof", 15);
		products.get(Warehouse.Type.VEGIES).put("Morkof", 15);
		products.get(Warehouse.Type.VEGIES).put("Luk", 15);

		products.put(Warehouse.Type.WINES, new TreeMap<String, Integer>());
		products.get(Warehouse.Type.WINES).put("Castra Rubra", 15);
		products.get(Warehouse.Type.WINES).put("Quantum", 15);
		products.get(Warehouse.Type.WINES).put("Todoroff", 15);
	}

	public synchronized void supplyStores(String product) {
		if (containsProduct(product)) {
			take(product);
			notifyAll();
		} else {
			try {
				System.out.println("---------------------------");
				System.out.println("No such product.");
				System.out.println("---------------------------");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void take(String product) {
		for (Entry<Warehouse.Type, TreeMap<String, Integer>> prd: products.entrySet()) { 
			for (Entry<String, Integer> subPrd : prd.getValue().entrySet()) { 
				if(product.equals(subPrd.getKey())) {
					Integer currentQty = subPrd.getValue();
					products.put(prd.getKey(), new TreeMap<>());
					products.get(prd.getKey()).put(product, currentQty - 15);
				}
			}
		}
		
	}

	private boolean containsProduct(String product) {
		for (TreeMap<String, Integer> subPrd : products.values()) {
			if (subPrd.containsKey(product)) {
				return true;
			}
		}
		return false;
	}

	public synchronized void getFromSuppliers() {
		ArrayList<String> productsBelowMin = getLowProducts();
		if (productsBelowMin.size() > 0) {
			getProducts(productsBelowMin);
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void getProducts(ArrayList<String> productsBelowMin) {
		for ( String prod: productsBelowMin) { 
			for ( TreeMap<String, Integer> subPrd : products.values()) { 
				if ( subPrd.containsKey(prod)) { 
					subPrd.put(prod, subPrd.get(prod) + 30);
					System.out.println("---------------------------");
					System.out.println("The supplier just suppleid 30 from " + prod + " to the Warehouse.");
					System.out.println("---------------------------");
				}
			}
		}
	}

	private ArrayList<String> getLowProducts() {
		ArrayList<String> temp = new ArrayList<>();
		for (Entry<Warehouse.Type, TreeMap<String, Integer>> prd : products.entrySet()) {
			for (Entry<String, Integer> subPrd : prd.getValue().entrySet()) {
				if (subPrd.getValue() < MIN_QTY) {
					temp.add(subPrd.getKey());
					System.out.println("---------------------------");
					System.out.println(subPrd.getKey() + " is below the minimum value.");
				}
			}
		}
		return temp;
	}
	

}
