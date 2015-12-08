
public class Task2 {

	public static void main(String[] args) {
		
		GSM one = new GSM();
		GSM two = new GSM();
		
		one.model = "Nokia 3310";
		one.insertSimCard("0889391852");
		
		System.out.println("one`s mobile number: ");
		System.out.println(one.simMobileNumber);
		System.out.println();
		
		System.out.println("Does one have a sim: ");
		System.out.println(one.hasSimCard);
		System.out.println();
//		one.removeSimCard();
		
		two.model = "iPhone 5S";
		two.insertSimCard("0893251865");
		
		System.out.println("two's mobile number");
		System.out.println(two.simMobileNumber);
		System.out.println();
		
//		two.removeSimCard();
		
		System.out.println("Does two have a sim: ");
		System.out.println(two.hasSimCard);
		System.out.println();
		
		System.out.println("Lets make a call: ");
		one.call(two, 130);
		System.out.println();
		
		System.out.println("The calls for GSM one: ");
		one.printInfoForTheLastIncomingCall();
		one.printInfoForTheLastOutgoingCall();
		System.out.println();
		
		System.out.println("The calls for GSM two: ");
		two.printInfoForTheLastIncomingCall();
		two.printInfoForTheLastOutgoingCall();
		System.out.println();
		
		System.out.println("Amount of money that one needs to pay: ");
		one.getSumForCall();
		System.out.println();
		
		System.out.println("Amount of money that two needs pay: "); // 
		two.getSumForCall();
		System.out.println();
		
		System.out.println("Last outging call duration in minutes for one: ");
		System.out.println(one.outgoingCallsDuration);
		System.out.println();
		
		System.out.println("Last outging call duration in minutes for two: ");
		System.out.println(two.outgoingCallsDuration);
		System.out.println();
		
		
	}

}
