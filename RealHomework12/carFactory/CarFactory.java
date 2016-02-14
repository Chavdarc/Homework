package carFactory;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CarFactory {

	private CountDownLatch countDownLatch;
	
	public CarFactory() {
	}
	
	public void produceCar(int numberOfCars){
		
		CountDownLatch countDownLatch= new CountDownLatch(numberOfCars);
		int carNum = 1;
		
		while(countDownLatch.getCount() > 0) {
			
			ExecutorService executor = Executors.newFixedThreadPool(3);
			
			long startTime = System.currentTimeMillis();
			executor.submit(new EngineLine(1));
			executor.submit(new FrameLine(1));
			
			for (int i = 0; i < 5; i++) { 
				executor.submit(new SeatLine(i));
			}
			
			for (int i = 0; i < 4; i++) { 
				executor.submit(new TyreLine(i));
			}
			
			executor.shutdown();
			
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("All tasks submitted. You will soon have a brand new Great Wall supercar " + carNum +  ".");
			System.out.println("---------------------------------------------------------------------------");
			
			try {
				executor.awaitTermination(5, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Supercar " + carNum++ + " creation time: " + (endTime - startTime));
			System.out.println("----------------------");
			countDownLatch.countDown();
		}
	}
	
	
	
}
