
public class GSM {
	
	String model;
	boolean hasSimCard;
	String simMobileNumber;
	int outgoingCallsDuration;
	Call lastIncomingCall;
	Call lastOutgoingCall;
	
	void insertSimCard(String newSim){
		
		boolean isDigit = true;
		
		for(int i = 0; i < newSim.length(); i++){
			if(newSim.charAt(i)< '0' || newSim.charAt(i)> '9'){
				isDigit = false;
			}
		}
		
		if((newSim.length() == 10) && (newSim.startsWith("08") && isDigit && !hasSimCard)){
			simMobileNumber = newSim;
			hasSimCard = true;
		}else{
			System.out.println("There is a SIM card already installed or this SIM is invalid.");
		}
		
	}
	
	void removeSimCard(){
		hasSimCard = false;
	}
	
	void call(GSM receiverPhone, int duration){
		
		if(duration <= 0 || receiverPhone.simMobileNumber.equals(simMobileNumber) || !(receiverPhone.hasSimCard) || !(hasSimCard)){
			System.out.println("Invaid Call");
		}else{
			Call phonecall = new Call();
			phonecall.receiver = receiverPhone;
			phonecall.caller = this;
			phonecall.duration = duration;
			lastOutgoingCall = phonecall;
			receiverPhone.lastIncomingCall = phonecall;
			
			outgoingCallsDuration += duration;
		}
	}
	
	void getSumForCall(){
		System.out.printf("The current account ballance is %.2flv \n", outgoingCallsDuration*Call.priceForAMinute);
	}
	
	void printInfoForTheLastOutgoingCall(){
		
		if(lastOutgoingCall != null){
			System.out.println("Diealed number: " +  lastOutgoingCall.receiver.simMobileNumber);
			System.out.println("Duration: " + lastOutgoingCall.duration + "min");
		}else{
			System.out.println("No outgoing calls");
		}
	}
	
	void printInfoForTheLastIncomingCall(){
		
		if(lastIncomingCall != null){
			System.out.println("Received call from: " + lastIncomingCall.caller.simMobileNumber);
			System.out.println("Duration " + lastIncomingCall.duration + "min");
		}else{
			System.out.println("No incoming calls");
		}
	}

}
