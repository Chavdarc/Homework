
public class Task1 {

	public static void main(String[] args) {
		
		Computer firstComputer = new Computer();
		Computer secondComputer = new Computer();
		
		firstComputer.year = 2012; 
		firstComputer.price = 1100.99;
		firstComputer.hardDiskMermory = 350; 
		firstComputer.freeMemory = 130;
		firstComputer.operatingSystem = "Windows";
		firstComputer.useMemory(100);
		
		secondComputer.year = 2014;
		secondComputer.price = 1499.99; 
		secondComputer.hardDiskMermory = 450;
		secondComputer.freeMemory = 150;
		secondComputer.operatingSystem = "iOS";
		secondComputer.isNotebook = true;
		secondComputer.changeOperatingSystem("Linux");
		
		System.out.println("Tech specs of the first computer:");
		firstComputer.printSpecs();
		System.out.println("Tech specs of the second computer:");
		secondComputer.printSpecs();
		
	}

}
