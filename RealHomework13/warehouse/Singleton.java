package warehouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Singleton {
	private static final Singleton inst = new Singleton();
	
	private Singleton() { 
		
	}
	
	public synchronized void writeToFile(String text) { 
		File file = new File("DlajniciBook.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));) {
			bw.write(text);
		} catch (IOException e) {
			System.out.println("Some text to handle the exception.");
			e.printStackTrace();
		}
		
	}
	
	public static Singleton getInstance() { 
		return inst;
	}

}
