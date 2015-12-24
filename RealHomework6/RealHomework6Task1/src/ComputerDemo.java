
public class ComputerDemo {

	public static void main(String[] args) {
		
		Computer oldPc = new Computer();
		oldPc.price = 2500.03;
		Computer moderatePc = new Computer(1999, 199.99, 10, 3);
		Computer stellarPc = new Computer(2015, 2000.59, 1000, 900, "Linux", true);
		
		int priceIndicator = oldPc.comparePrice(moderatePc);
		if(priceIndicator > 0){
			System.out.println("oldPc is cheaper than moderatePc.");
		}else if(priceIndicator == 0){
			System.out.println("poth computers have the same price");
		}else{
			System.out.println("oldPc is more expensive than moderatePc");
		}
		
		priceIndicator = moderatePc.comparePrice(stellarPc);
		if(priceIndicator > 0){
			System.out.println("moderatePc is cheaper than stellarPc.");
		}else if(priceIndicator == 0){
			System.out.println("poth computers have the same price");
		}else{
			System.out.println("moderatePc is more expensive than stellarPc");
		}
		
		
		priceIndicator = stellarPc.comparePrice(oldPc);
		if(priceIndicator > 0){
			System.out.println("stellarPc is cheaper than oldPc.");
		}else if(priceIndicator == 0){
			System.out.println("poth computers have the same price");
		}else{
			System.out.println("stellarPc is more expensive than oldPc");
		}
		
		System.out.println(moderatePc.operatingSystem);
	}

}
