package carFactory;

public class EngineLine extends Thread{
	
	private int id;

	public EngineLine(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("Engine Line");
		System.out.println(Thread.currentThread().getName() + " has started building engine " + id);
		System.out.println("----------------------");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has finished building engine " + id);
		System.out.println("----------------------");
	}
}
