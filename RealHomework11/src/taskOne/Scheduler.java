package taskOne;

import java.util.LinkedList;
import java.util.Queue;

public class Scheduler{
	
	private Queue<Task> taskQ;
	
	
	public Scheduler() {
		this.taskQ = new LinkedList<Task>();
		
	}
	
	public void push(Task newTask){
		this.taskQ.offer(newTask);
	}
	
	public static void main(String[] args){
		Scheduler schdude = new Scheduler();
		
		schdude.push(new Task() {
			@Override
			public void doWork() {
				System.out.println( "Washing the kitchen.");
			}
		});
		
		schdude.push(new Task() {
			@Override
			public void doWork() {
				System.out.println( "The vino needs to be cool.");
			}
		});
		
		schdude.push(() -> System.out.println("Lambda working.")); 
		schdude.push(() -> System.out.println("Laundry is ready for pick up.")); 
		
		while(!schdude.taskQ.isEmpty()) {
			schdude.taskQ.poll().doWork();
		}
	}

}
