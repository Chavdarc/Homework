
public class Computer {
	
	int year; 
	double price;
	boolean isNotebook;
	int hardDiskMermory;
	int freeMemory;
	String operatingSystem;
	
	void changeOperatingSystem(String newOS){
		operatingSystem = newOS; 
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
