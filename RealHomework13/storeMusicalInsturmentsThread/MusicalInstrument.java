package storeMusicalInsturmentsThread;

public abstract class MusicalInstrument {
	
	private String name;
	private String type;
	private double price;
	private boolean isInStore;
	private int stockInStore;
	
	public MusicalInstrument(String name, double price, int stockInStore) {
		if(name == null || name.trim().length() == 0) { 
			throw new IllegalArgumentException("Invalid input for name of the insturment.");
		}
		this.name = name;
		if(price <= 0) { 
			throw new IllegalAccessError("This is not a charity fund. Please enter a value above 0 for a sale price.");
		}
		this.price = price;
		if(stockInStore <= 0) { 
			throw new IllegalAccessError("Please add quantity that actually make sense.");
		}
		this.stockInStore = stockInStore;
		this.isInStore = true;
	}

	public Boolean isInStore() {
		return isInStore;
	}

	public void setInStore(boolean isInStore) {
		this.isInStore = isInStore;
	}

	public Double getPrice() {
		return price;
	}

	public int getStockInStore() {
		return stockInStore;
	}

	public void setStockInStore(int stockInStore) {
		this.stockInStore = stockInStore;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Model: " + name + "\nType: " + type + "\nPrice: " + price + "\nIn Stock: " + (isInStore ? "Yes": "No")
				+ "\nQuantity: " + stockInStore + "";
	}
	
	static class StringInstrument extends MusicalInstrument {

		public StringInstrument(String name, double price, int stockInStore) {
			super(name, price, stockInStore);
			super.type = "String Instrument";
		} 
		
	}
	
	static class PercussionInstrument extends MusicalInstrument {

		public PercussionInstrument(String name, double price, int stockInStore) {
			super(name, price, stockInStore);
			super.type = "Percussion Instrument";
		} 
		
	}
	
	static class WindInstrument extends MusicalInstrument {

		public WindInstrument(String name, double price, int stockInStore) {
			super(name, price, stockInStore);
			super.type = "Wind Instrument";
		}
		
	}
	
	static class KeyboardInstrument extends MusicalInstrument {

		public KeyboardInstrument(String name, double price, int stockInStore) {
			super(name, price, stockInStore);
			super.type = "Keyoard Instrument";
		}
		
	}
	
	static class ElectronicInstrument extends MusicalInstrument {

		public ElectronicInstrument(String name, double price, int stockInStore) {
			super(name, price, stockInStore);
			super.type = "Electronic Instrument";
		} 
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicalInstrument other = (MusicalInstrument) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
