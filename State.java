
public class State {
	private String stateName;
	//other variables that were not used
	private String TimeZone;
	private int Population;
	private double Density;
	
	public State() { //initialize to none if no parameter
		stateName = "none";
	}
	
	public State(String theName) { //make the stateName the inputed name
		stateName = theName;
	}
	
	public String getName() { //return the statename
		return stateName;
	}
	
	public void setName(String theName) {
		stateName = theName;
	}

}
