
public class Computer {
	
	int year; 
	double price;
	boolean isNotebook;
	int hardDiskMermory;
	int freeMemory;
	String operatingSystem;
	
	Computer() {
		isNotebook = false;
		operatingSystem = "Win XP";
	}
	
	Computer(int newYear, double newPrice, double newHardDiskMermory, double newFreeMemory){
		this();
		this.year = newYear; 
		this.price = newPrice;
		this.hardDiskMermory = (int) newHardDiskMermory;
		this.freeMemory = (int) newFreeMemory;
		
	}
	
	Computer(int newYear, double newPrice, double newHardDiskMermory, double newFreeMemory, String newOperatingSystem, boolean newIsNoteBook){
		this(newYear, newPrice, newHardDiskMermory, newFreeMemory);
		this.isNotebook = newIsNoteBook;
		this.operatingSystem = newOperatingSystem;
	}
	
	int comparePrice(Computer c){
		if(this.price > c.price){
			return -1;
		}else if(this.price < c.price){
			return 1;
		}else{
			return 0;
		}
	}
	
	void changeOperatingSystem(String newOs){
		operatingSystem = newOs; 
	}
	
	void useMemory(int memory){
		if(memory > freeMemory){
			System.out.println("Not Enough Memory!");
		}else{
			freeMemory -= memory;
		}
	}
	
	void printSpecs(){
		System.out.printf("Year: %d \nPrice: %.2f \n%s \nHDD memory: %dGB \nFree memory: %dGB \nOS: %s\n\n", year, price, (isNotebook)? "Notebook" : "PC", hardDiskMermory, freeMemory, operatingSystem);
	}

}
