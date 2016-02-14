package storeMusicalInsturmentsAdvanced;

public class Client{
	
	private MusicStore store; 
	
	public Client(MusicStore store) {
		this.store = store;
	}
	
	public void purchase(String name, int quantity) { 
		this.store.sellInsturment(name, quantity);
	}
	
}
