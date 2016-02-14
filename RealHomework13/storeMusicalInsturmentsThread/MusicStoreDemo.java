package storeMusicalInsturmentsThread;

public class MusicStoreDemo {

	public static void main(String[] args) {
		MusicStore ikonomov = new MusicStore("Ikonomov");
		
		Client client = new Client(ikonomov, "Bionce");
		Client clientJz = new Client(ikonomov, "JZ");
		
		ikonomov.start();
		client.start();
		clientJz.start();
		
	}

}
