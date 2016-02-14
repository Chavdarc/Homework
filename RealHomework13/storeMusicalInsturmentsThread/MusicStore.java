package storeMusicalInsturmentsThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.sound.midi.Instrument;

public class MusicStore extends Thread{

	public enum catalogSort {
		BY_TYPE, BY_NAME, BY_PRICE_HIGH_LOW, BY_PRICE_LOW_HIGH, BY_AVAILABILITY, BY_TYPE_KEY_VALUE
	}

	private double cashboxAmount;
	private HashSet<MusicalInstrument> insturmentsInStore;
	private HashMap<MusicalInstrument, Integer> soldInsturments; // for the type of the instrument and ea sold
	private SupplierMusicalInstruments supplier;

	public MusicStore(String name) {
		super(name);
		this.cashboxAmount = 0;
		insturmentsInStore = new HashSet<>();
		soldInsturments = new HashMap<>();
		supplier = new SupplierMusicalInstruments();
		
		insturmentsInStore.add(new MusicalInstrument.StringInstrument("Ibanez guitar", 106, 10));
		insturmentsInStore.add(new MusicalInstrument.PercussionInstrument("Yamaha drums", 401, 2));
		insturmentsInStore.add(new MusicalInstrument.PercussionInstrument("Yamaha drums", 401, 1));
		insturmentsInStore.add(new MusicalInstrument.WindInstrument("Hohner Harmonica", 76, 3));
		insturmentsInStore.add(new MusicalInstrument.KeyboardInstrument("Kawai", 213, 11));
		insturmentsInStore.add(new MusicalInstrument.ElectronicInstrument("Korg", 314, 3));
		insturmentsInStore.add(new MusicalInstrument.ElectronicInstrument("Yamaha DGX", 470, 3));
		insturmentsInStore.add(new MusicalInstrument.ElectronicInstrument("s", 470, 3));
	}
	
	public HashSet<MusicalInstrument> getInsturmentsInStore() {
		return insturmentsInStore;
	}

	public void setInsturmentsInStore(HashSet<MusicalInstrument> insturmentsInStore) {
		this.insturmentsInStore = insturmentsInStore;
	}

	public void addInstrumentForSale(MusicalInstrument insturment) {
		for (MusicalInstrument instrumentInStore : insturmentsInStore) {
			if (instrumentInStore.equals(insturment)) {
				if ( instrumentInStore.getPrice().equals(insturment.getPrice())) {
					if (instrumentInStore.getStockInStore() == 0) {
						instrumentInStore.setInStore(true);
					}
					int newQuantity = instrumentInStore.getStockInStore() + insturment.getStockInStore();
					instrumentInStore.setStockInStore(newQuantity);
					instrumentInStore.setInStore(true);
					return;
				} else if (!instrumentInStore.getPrice().equals(insturment.getPrice())) {
					return;
				}
			}
		}
		insturment.setInStore(true);
		this.insturmentsInStore.add(insturment);
	}

	public synchronized void sellInsturment(String name, Integer quantity) {
		boolean notExistingInStore = true;
		if (quantity <= 0 || name.trim().length() == 0 || name == null) {
			throw new IllegalArgumentException("Invalid purchase. Please recheck purchase details.");
		} else {
			for (MusicalInstrument instrument : insturmentsInStore) {
				if (instrument.getName().equalsIgnoreCase(name) && instrument.isInStore()
						&& instrument.getStockInStore() >= quantity) {
					cashboxAmount += quantity * instrument.getPrice();

					int newStock = instrument.getStockInStore() - quantity;
					if (newStock == 0) {
						instrument.setInStore(false);
						System.out.println("There is no more from " + instrument.getName() + " in the store");
					}
					instrument.setStockInStore(newStock);
					notExistingInStore = false;
					addToSold(instrument, quantity);
					notifyAll();

				} else if (instrument.getName().equalsIgnoreCase(name) && instrument.getStockInStore() < quantity) {
					System.out.println("Not enough quantity available from " + instrument.getName());
					System.out.println("The current quantity instock of " + instrument.getName() + " is "
							+ instrument.getStockInStore());
					int inquiredQuantitiy = quantity - instrument.getStockInStore();
					inquireFromSupplier(name, inquiredQuantitiy);
					notExistingInStore = false;
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				} 
			}
			if (notExistingInStore) {
				if (supplier.checkForStock(name, quantity)) { 
					inquireFromSupplier(name, quantity);
					notExistingInStore = false;
				} else { 
					System.out.println("No records for " + name + " in the store. And could not supply from partners.");
				}
			}
		}
			
	}

	private  void addToSold(MusicalInstrument isntrument, Integer quantity) {
		if (soldInsturments.containsKey(isntrument)) {
			Integer newQty = quantity + soldInsturments.get(isntrument);
			soldInsturments.put(isntrument, newQty);
		} else {
			soldInsturments.put(isntrument, quantity);
		}
	}
	
	public void generateCatalog(catalogSort sorting) {
		ArrayList<MusicalInstrument> sorted = new ArrayList<>(insturmentsInStore);
		switch (sorting) {
		case BY_AVAILABILITY:
			Collections.sort(sorted, (o1, o2) -> -o1.isInStore().compareTo(o2.isInStore()));
			break;
		case BY_NAME:
			Collections.sort(sorted, (o1, o2) -> o1.getName().compareTo(o2.getName()));
			break;
		case BY_PRICE_HIGH_LOW:
			Collections.sort(sorted, (o1, o2) -> -o1.getPrice().compareTo(o2.getPrice()));
			break;
		case BY_PRICE_LOW_HIGH:
			Collections.sort(sorted, (o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
			break;
		case BY_TYPE:
			Collections.sort(sorted, (o1, o2) -> o1.getClass().getName().compareTo(o2.getClass().getName()));
			break;
		case BY_TYPE_KEY_VALUE:
			TreeMap<String, ArrayList<MusicalInstrument>> sortedMap = new TreeMap<>();
			for (MusicalInstrument musicalInstrument : sorted) {
				if (!sortedMap.containsKey(musicalInstrument.getType())) {
					sortedMap.put(musicalInstrument.getType(), new ArrayList<>());
				}
				sortedMap.get(musicalInstrument.getType()).add(musicalInstrument);
			}

			for (Entry<String, ArrayList<MusicalInstrument>> e : sortedMap.entrySet()) {
				System.out.println(e.getKey());
				System.out.println("--------------------");
				for (MusicalInstrument m : e.getValue()) {
					System.out.println(m);
					System.out.println();
				}
				System.out.println("\n");
			}
			return;
		}

		for (MusicalInstrument m : sorted) {
			System.out.println(m);
			System.out.println();
		}

	}

	public void generateReport() {
		if (!soldInsturments.isEmpty()) {
			generateSoldInstruments(soldInsturments);
			calcualteSales(soldInsturments);
			soldTheMost(soldInsturments);
			soldTheLeast(soldInsturments);
			typeSoldTheMost(soldInsturments);
			mostIncome(soldInsturments);
		} else { 
			System.out.println("No sales.");
		}	
	}

	private void calcualteSales(HashMap<MusicalInstrument, Integer> sales) {
		System.out.println("--------------------TOTAL SALES--------------------");
		double totalSales = 0;
		for (Entry<MusicalInstrument, Integer> e : sales.entrySet()) {
			totalSales += e.getKey().getPrice() * e.getValue();
		}
		System.out.println("Total sales amount: " + totalSales);
		System.out.println();
	}

	private void generateSoldInstruments(HashMap<MusicalInstrument, Integer> sales) {
		TreeMap<Integer, ArrayList<MusicalInstrument>> sold = new TreeMap<>();
		for (Entry<MusicalInstrument, Integer> e : sales.entrySet()) {
			if (!sold.containsKey(e.getValue())) {
				sold.put(e.getValue(), new ArrayList<MusicalInstrument>());
			}
			sold.get(e.getValue()).add(e.getKey());
		}
		System.out.println("--------------------SOLD BY QUANTITY--------------------");
		for (Entry<Integer, ArrayList<MusicalInstrument>> e : sold.entrySet()) {
			System.out.println(e.getKey() + "ea sold.");
			System.out.println("--------------------");
			for (MusicalInstrument instrument : e.getValue()) {
				System.out.println(instrument);
				System.out.println();
			}
		}
		System.out.println();
	}

	private void soldTheMost(HashMap<MusicalInstrument, Integer> sales) {
		ArrayList<MusicalInstrument> soldTheMostInstrument = new ArrayList<>();
		int soldTheMost = 0;
		for (Entry<MusicalInstrument, Integer> e : sales.entrySet()) {
			if (e.getValue() == soldTheMost) {
				soldTheMostInstrument.add(e.getKey());
				soldTheMost = e.getValue();
			} else if (e.getValue() > soldTheMost) {
				soldTheMostInstrument.removeAll(soldTheMostInstrument);
				soldTheMostInstrument.add(e.getKey());
				soldTheMost = e.getValue();
			}
		}
		if (soldTheMostInstrument.size() > 1) {
			System.out.println("--------------------THE MOST SOLD INSTRUMENTS ARE--------------------");
			for (MusicalInstrument instrument : soldTheMostInstrument) {
				System.out.println(instrument);
				System.out.println();
			}
			System.out.println("Total sales: " + soldTheMost + "ea" + " per isntrument,");
		} else {
			System.out.println("--------------------THE MOST SOLD INSTRUMENT IS--------------------");
			System.out.println(soldTheMostInstrument.get(0));
			System.out.println("Total sales: " + soldTheMost + "ea");
		}
	}

	private void soldTheLeast(HashMap<MusicalInstrument, Integer> sales) {
		ArrayList<MusicalInstrument> soldTheLeastInstrument = new ArrayList<>();
		int soldLeast = -1;
		for (Entry<MusicalInstrument, Integer> e : sales.entrySet()) {
			if (e.getValue() == soldLeast) {
				soldTheLeastInstrument.add(e.getKey());
			} else if (e.getValue() < soldLeast) {
				soldTheLeastInstrument.removeAll(soldTheLeastInstrument);
				soldTheLeastInstrument.add(e.getKey());
			}
			if(soldLeast == - 1) { 
				soldTheLeastInstrument.add(e.getKey());
				soldLeast = e.getValue();
			}
		}
		if (soldTheLeastInstrument.size() > 1) {
			System.out.println("--------------------THE LEAST SOLD INSTRUMENTS ARE--------------------");
			for (MusicalInstrument instrument : soldTheLeastInstrument) {
				System.out.println(instrument);
				System.out.println();
				
				System.out.println("Total sales: " + soldLeast + "ea" + " per isntrument,");
			}
		} else {
			System.out.println("--------------------THE LEAST SOLD INSTRUMENT IS--------------------");
			System.out.println(soldTheLeastInstrument.get(0));
			System.out.println("Total sales: " + soldLeast + "ea");
		}
	}

	private void typeSoldTheMost(HashMap<MusicalInstrument, Integer> sales) {
		TreeMap<String, Integer> typesMostSold = new TreeMap<>();
		for ( Entry<MusicalInstrument, Integer> e: sales.entrySet()) { 
			if (!typesMostSold.containsKey(e.getKey().getType())) { 
				typesMostSold.put(e.getKey().getType(), e.getValue());
			} else {
				int newQuantity = typesMostSold.get(e.getKey().getType()) + e.getValue();
				typesMostSold.put(e.getKey().getType(), newQuantity);
			}
		}
		System.out.println("--------------------TYPE SOLD THE MOST--------------------");
		String theMostSoldTypeInstrument = null;
		int timesSold = 0;
		for ( Entry<String, Integer> e: typesMostSold.entrySet()) { 
			if (e.getValue() > timesSold) { 
				timesSold = e.getValue();
				theMostSoldTypeInstrument = e.getKey();
			}
		}
		System.out.println(theMostSoldTypeInstrument + " " + timesSold + "ea sold.");
	}

	private void mostIncome(HashMap<MusicalInstrument, Integer> sales) {
		TreeMap<String, Double> mostIncomeGneeretaed = new TreeMap<>();
		for (Entry<MusicalInstrument, Integer> e : sales.entrySet()) { 
			if (!mostIncomeGneeretaed.containsKey(e.getKey().getType())) {
				mostIncomeGneeretaed.put(e.getKey().getType(), e.getValue()*e.getKey().getPrice());
			} else { 
				double newIncome = mostIncomeGneeretaed.get(e.getKey()) + e.getValue()*e.getKey().getPrice();
				mostIncomeGneeretaed.put(e.getKey().getType(), newIncome);
			}
		}
		
		Map<String, Double> filteredByIncome = arrangeByValue(mostIncomeGneeretaed);
		System.out.println("--------------------INCOME GENERATED FROM SALES BY TYPE--------------------");
		for (Entry<String, Double> e: filteredByIncome.entrySet()) { 
			System.out.println(e.getKey() + " " + "income: " + e.getValue());
		}
	}

	private LinkedHashMap<String, Double> arrangeByValue(TreeMap<String, Double> map) {
		Map<String, Double> result = new LinkedHashMap<>();
		Stream<Entry<String, Double>> st = map.entrySet().stream();
		st.sorted(Comparator.comparing(e -> e.getValue())).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return (LinkedHashMap<String, Double>) result;
	}
	
	
	
	private void inquireFromSupplier(String name, int inquiredQuantitiy) {
		if (supplier.checkForStock(name, inquiredQuantitiy)) {
			System.out.println("We can deliver " + inquiredQuantitiy +  " " + name + " in " + supplier.getDeliveryTime(name) + " weeks");
		} else { 
			System.out.println("There wont be any more deliveries from " + name);
		}
	}
	
	private synchronized void getFromSupplier() { 
		ArrayList<MusicalInstrument> zeroStocks  = getZeroStocks();
		if(zeroStocks.size() > 0) { 
			fillStock(zeroStocks);
			notifyAll();
		} else { 
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void fillStock(ArrayList<MusicalInstrument> zeroStocks) {
		for(MusicalInstrument m : zeroStocks) { 
			for ( MusicalInstrument instrument: insturmentsInStore) { 
				if(m.equals(instrument)) {
					instrument.setStockInStore(10);
					instrument.setInStore(true);
					System.out.println("----------------------------------");
					System.out.println(getName() + " has supplied 10ea " + instrument.getName());
					System.out.println("----------------------------------");
				}
			}
		}
	}

	private ArrayList<MusicalInstrument> getZeroStocks() {
		ArrayList<MusicalInstrument> temp = new ArrayList<>();
		for (MusicalInstrument m: insturmentsInStore) { 
			if (m.getStockInStore() == 0) { 
//			if (!m.isInStore()) { 
				temp.add(m);
			}
		}
		return temp;
	}

	@Override
	public void run() {
		while(true) { 
			getFromSupplier();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		ArrayList<MusicalInstrument> outOfStock = getOutOfStock();
//		if(outOfStock.size() > 0) { 
//			supplier.supply(outOfStock);
//			notifyAll();
//		} else { 
//			wait();
//		}
	}

}
