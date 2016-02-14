package storeMusicalInsturmentsAdvanced;

import java.util.HashMap;
import java.util.Map.Entry;

public class SupplierMusicalInstruments{
	
	private HashMap<MusicalInstrument, Integer> instrumentsToSupply; //Instrument and the delivery time in weeks
	
	
	public SupplierMusicalInstruments() {
		instrumentsToSupply = new HashMap<>();
		instrumentsToSupply.put(new MusicalInstrument.PercussionInstrument("Yamaha drums", 401, 100), 2);
		instrumentsToSupply.put(new MusicalInstrument.StringInstrument("Ibanez guitar", 106, 10), 3);
		instrumentsToSupply.put(new MusicalInstrument.WindInstrument("Hohner Harmonica", 76, 3), 1);
		instrumentsToSupply.put(new MusicalInstrument.KeyboardInstrument("Kawai", 213, 11), 4);
		instrumentsToSupply.put(new MusicalInstrument.ElectronicInstrument("Korg", 314, 3), 10);
		instrumentsToSupply.put(new MusicalInstrument.ElectronicInstrument("Yamaha DGX", 470, 3), 5);
	}
	
	public boolean checkForStock(String name, int quantity){ 
		for (Entry<MusicalInstrument, Integer> e : instrumentsToSupply.entrySet()) { 
			if (e.getKey().getName().equals(name)) { 
				return true;
			}
		}
		return false;
	}
	
	public int getDeliveryTime (String name) { 
		int weeksToWait = 0;
		for (Entry<MusicalInstrument, Integer> e : instrumentsToSupply.entrySet()) { 
			if (e.getKey().getName().equals(name)) { 
				weeksToWait =  e.getValue();
				break;
			}
		}
		return weeksToWait;
	}
	
}
