
public class StateCovidStats extends State implements Comparable { //extends because it inherits from state
	//create the variables
	private int cases;
	private int deaths;
	
	//constructor w no parameter
	public StateCovidStats() {
		super(); //use super in order to inherit from state
		cases = 0;
		deaths = 0;
	}
	
	//constructor with parameter
	public StateCovidStats(String theName, int caseCount, int deathCount) {
		super(theName);
		cases = caseCount;
		deaths = deathCount;
	}
	
	public void displayStats() { //output stats (project did not specify what should be within this method)
		System.out.println(getStateName() + " Cases: " + cases + " Deaths: "+deaths);
	}
	
	//Getters
	public String getStateName() { //get the stateName from State
		return super.getName();
	}
	
	public int getCases() {
		return cases;
	}
	
	public int getDeaths() {
		return deaths;
	}
	
	//Setters
	
	public void setStateName(String newName) { //set the stateName from super
		super.setName(newName);
	}
	
	public void setCases(int caseCount) {
		cases = caseCount;
	}
	
	public void setDeaths(int deathCount) {
		deaths = deathCount;
	}
	
	public String toString() { //to String
		return getStateName() + " Cases: " + cases + " Deaths: "+deaths;
	}

	//create a comparable method to sort cases
	
	@Override
	public int compareTo(Object obj) {
		
		StateCovidStats obj1 = (StateCovidStats) obj;
		
		// return -1 if the cases are greater
		if (this.getCases() > obj1.getCases()) {
		return -1;
		
		}
		
		// return 1 if the cases are less
		else if (this.getCases() < obj1.getCases()) {
			return 1;
			}
		//if they are equal
		else {
			return 0;
		}
		
	}//end of compareTo
	
	
}
