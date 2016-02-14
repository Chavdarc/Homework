package carFactory;

public class SeatLine extends Thread{

	private int id;
	public SeatLine(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("Seat Line");
		System.out.println(Thread.currentThread().getName() + " has started building seat " + id);
		System.out.println("----------------------");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has finished building seat " + id);
		System.out.println("----------------------");
	}
}
