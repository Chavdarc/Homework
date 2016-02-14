package carFactory;

public class FrameLine extends Thread{
	
	private int id;
	
	public FrameLine(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("Frame Line");
		System.out.println(Thread.currentThread().getName() + " has started building frame " + id);
		System.out.println("----------------------");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has finished building frame " + id);
		System.out.println("----------------------");
	}

}
