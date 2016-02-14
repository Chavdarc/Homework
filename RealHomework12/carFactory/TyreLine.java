package carFactory;

public class TyreLine extends Thread{
	
	private int id;

	public TyreLine(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName("Tyre Line");
		System.out.println(Thread.currentThread().getName() + " has started building tyre " + id);
		System.out.println("----------------------");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has finished building tyre " + id);
		System.out.println("----------------------");
	}
}
