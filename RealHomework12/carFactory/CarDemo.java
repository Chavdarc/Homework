package carFactory;

public class CarDemo {
	
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		CarFactory greatWall = new CarFactory();
		greatWall.produceCar(3);
		long endTime = System.currentTimeMillis();
		System.out.println("Supercars creation time: " + (endTime - startTime));
	}

}
