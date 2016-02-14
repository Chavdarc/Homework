
public class AllWork {
	
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	
	public AllWork() {
		freePlacesForTasks = 10;
		tasks = new Task[freePlacesForTasks];
	}
	
	public int getCurrentUnassignedTask() {
		return currentUnassignedTask;
	}
	
	public void addTask(Task newTask){
		if(freePlacesForTasks > 0 && newTask.getWorkingHours() > 0 ){
			this.tasks[tasks.length - freePlacesForTasks--] = newTask;
			
		}else if(freePlacesForTasks == 0){
			System.out.println("There is no more place for tasks.");
		}else{
			System.out.println("Task \"" + newTask.getName() + "\" parameters are incorrect.");
		}
		
	}
	
	public Task getNextTask(){
		if(currentUnassignedTask < tasks.length - 1 && tasks[currentUnassignedTask] != null){
			return tasks[currentUnassignedTask++];
		}else if(currentUnassignedTask == tasks.length - 1){
			return tasks[currentUnassignedTask++];
		}else{
			return null;
		}
	}
	
	public boolean isAllWorkDone(){
		boolean workDone = true; 
		
		for(int i = 0; i <= tasks.length - freePlacesForTasks - 1; i++){
			if(tasks[i] != null){
				if(tasks[i].getWorkingHours() > 0){
					workDone = false;
					break;
				}
			}else{
				break;
			}
		}
		return workDone;
	}

}
