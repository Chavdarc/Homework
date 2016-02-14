

public class Task {
	
	private String name; 
	private int workingHours;
	private static int automaticNameGeneratorID = 1; 
	
	
	public Task(String name, int workingHours){
		if(name.matches(".*\\d+.*" ) || name.trim().length() < 2){
			System.out.println("Invalid name input. The name must consist from more than two letters");
			this.name = "Task" + automaticNameGeneratorID++;
			System.out.println("Autoamtic name: \"" + this.name + "\" was assaigned for that task");
		}else{
			this.name = name;
		}
		if(workingHours < 1){
			System.out.println("Hours for \"" + this.name + "\" task can't be less than 1. Please assaign a correct value");
			this.workingHours = -1;
		}else{
			this.workingHours = workingHours;
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name.matches(".*\\d+.*" ) || name.trim().length() < 2){
			System.out.println("Invalid name input. The name must consist from more than two letters");
			System.out.println("Autoamtic generated name: \"" + this.name + "\"is currently assaigned for that task");
		}else{
			this.name = name;
		}
	}


	public int getWorkingHours() {
		return workingHours;
	}


	public void setWorkingHours(int workingHours) {
		if(workingHours < 0){
			System.out.println("Hours for a new task can't be less than 1. Please assaign a correct value");
		}else{
			this.workingHours = workingHours;
		}
	}

}
