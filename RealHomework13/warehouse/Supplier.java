package warehouse;

public class Supplier extends Thread{
	
	String name;
	private Warehouse warehouse;
	
	public Supplier(String name, Warehouse warehouse) {
		this.name = name;
		this.warehouse = warehouse;
	}
	
	@Override
	public void run() {
		while(true){ 
			warehouse.getFromSuppliers();
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
