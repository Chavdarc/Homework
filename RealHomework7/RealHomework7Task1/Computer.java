
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
	
	Computer(int year, double price, double hardDiskMermory, double freeMemory){
		this();
		this.year = year; 
		this.price = price;
		this.hardDiskMermory = (int) hardDiskMermory;
		this.freeMemory = (int) freeMemory;
		
	}
	
	Computer(int year, double price, double hardDiskMermory, double freeMemory, String operatingSystem, boolean isNoteBook){
		this(year, price, hardDiskMermory, freeMemory);
		this.isNotebook = isNoteBook;
		this.operatingSystem = operatingSystem;
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
