package storeMusicalInsturmentsAdvanced;

public class MusicStoreDemo {

	public static void main(String[] args) {
		MusicStore ikonomov = new MusicStore();
		ikonomov.addInstrumentForSale(new MusicalInstrument.StringInstrument("Ibanez guitar", 106, 10));
//		ikonomov.addInstrumentForSale(new MusicalInstrument.PercussionInstrument("Yamaha drums", 401, 2));
//		ikonomov.addInstrumentForSale(new MusicalInstrument.PercussionInstrument("Yamaha drums", 401, 1));
		ikonomov.addInstrumentForSale(new MusicalInstrument.WindInstrument("Hohner Harmonica", 76, 3));
		ikonomov.addInstrumentForSale(new MusicalInstrument.KeyboardInstrument("Kawai", 213, 11));
		ikonomov.addInstrumentForSale(new MusicalInstrument.ElectronicInstrument("Korg", 314, 3));
		ikonomov.addInstrumentForSale(new MusicalInstrument.ElectronicInstrument("Yamaha DGX", 470, 3));
		ikonomov.addInstrumentForSale(new MusicalInstrument.ElectronicInstrument("s", 470, 3));
		
		Client client = new Client(ikonomov);
		
//		client.purchase("Yamaha DGX", 3);
//		client.purchase("Kawai", 10);
//		client.purchase("nqkoiSi", 15);
		client.purchase("Yamaha drums", 3);
		System.out.println();
		
//		ikonomov.generateCatalog(MusicStore.catalogSort.BY_AVAILABILITY);
//		ikonomov.generateCatalog(MusicStore.catalogSort.BY_NAME);
//		ikonomov.generateCatalog(MusicStore.catalogSort.BY_PRICE_HIGH_LOW);
//		ikonomov.generateCatalog(MusicStore.catalogSort.BY_PRICE_LOW_HIGH);
//		ikonomov.generateCatalog(MusicStore.catalogSort.BY_TYPE);
//		ikonomov.generateCatalog(MusicStore.catalogSort.BY_TYPE_KEY_VALUE);
		
//		ikonomov.generateReport();
	}

}
