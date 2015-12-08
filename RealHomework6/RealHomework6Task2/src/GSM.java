
public class GSM {
	
	String model;
	boolean hasSimCard;
	String simMobileNumber;
	int outgoingCallsDuration;
	String lastIncomingCall;
	String lastOutgoingCall;
	
	void insertSimCard(String newSim){
		
		boolean isDigit = true;
		
		for(int i = 0; i < newSim.length(); i++){
			if(newSim.charAt(i)< '0' || newSim.charAt(i)> '9'){
				isDigit = false;
			}
		}
		
		if((newSim.length() == 10) && (newSim.startsWith("08") && isDigit)){
			simMobileNumber = newSim;
			hasSimCard = true;
		}else{
			System.out.println("Invalid SIM");
		}
		
	}
	
	void removeSimCard(){
		hasSimCard = false;
	}
	
	void call(GSM receiver, int duration){
		
		if(duration <= 0 || receiver.simMobileNumber.equals(simMobileNumber) || !(receiver.hasSimCard) || !(hasSimCard)){
			System.out.println("Invaid Call");
		}else{
			Call phonecall = new Call();
			phonecall.receiver = receiver.simMobileNumber;
			phonecall.caller = simMobileNumber;
			phonecall.duration = duration;
			lastOutgoingCall = receiver.simMobileNumber;
			receiver.lastIncomingCall = simMobileNumber;
			
			outgoingCallsDuration += duration;
		}
	}
	
	void getSumForCall(){
		System.out.printf("The current account ballance is %.2flv \n", outgoingCallsDuration*Call.priceForAMinute);
	}
	
	void printInfoForTheLastOutgoingCall(){
		
		if(lastOutgoingCall != null){
			System.out.println(lastOutgoingCall);
		}else{
			System.out.println("No outgoing calls");
		}
	}
	
	void printInfoForTheLastIncomingCall(){
		
		if(lastIncomingCall != null){
			System.out.println(lastIncomingCall);
		}else{
			System.out.println("No incoming calls");
		}
	}

}
