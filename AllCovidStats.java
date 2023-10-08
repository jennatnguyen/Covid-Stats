import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllCovidStats {
	
	//create the data members
	private ArrayList<StateCovidStats> stateList = new ArrayList<StateCovidStats>();
	private String diseaseName;
	private String dateOfStat;

/*******************************************************************************/
	
	//default constructor 
	public AllCovidStats() {
		diseaseName = "none";
		dateOfStat = "none";
	}
	
	public AllCovidStats(String dName, String statsDate) {
		diseaseName = dName;
		dateOfStat = statsDate;
	}
	
/*******************************************************************************/
	
	//will load the ArrayList "StateList" with data from a given file
	public void loadData(String filename) {
		
		String line = "";  
		String splitBy = ","; 
		
		try   
		{  
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader(filename));  
			
		//READ THE TXT FILE UNTIL THERE IS NOTHING LEFT
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				
		//PARSE EACH LINE OF CODE TO GET THE STATE, CASES, AND DEATHS
				//split = when you have a string and you want to separate it you use .split and split by is the delimiter
				String[] record = line.split(splitBy);    // use comma as separator  
				String state = record[1]; //after first comma is the state
				int cases = Integer.parseInt(record[3]); //2nd comma = cases, then convert the String to int
				int deaths = Integer.parseInt(record[4]); //3rd comma = deaths, then convert the String to int
				
		//ADD THE INFORMATION INTO AN ARRAY
				//creates array list using each line that was parsed
				StateCovidStats newState = new StateCovidStats(state, cases, deaths); 
				stateList.add(newState); //store it in the arraylist
			
			}//end of while
			
		}//end of try
		
		//catch the exception
				catch (IOException e)   
				{  
					e.printStackTrace();  
				}  
				
			
	}//end of loadData
	
/*******************************************************************************/
//made a method for avg cases
	public int avgCases() {

		return totalCases() / stateList.size();
		
	}
/*******************************************************************************/
	public int avgDeaths() {
		
		 return totalDeaths() / stateList.size();
		 
	}
/*******************************************************************************/
	
	//return total # of cases 
	public int totalCases() {
		int total = 0;
		for (int i = 0; i < stateList.size(); i++) {
			total += stateList.get(i).getCases();
		}
		return total;
	}
	
/*******************************************************************************/
	
	//return total # of deaths 
	public int totalDeaths() {
		int total = 0;
		for (int i = 0; i < stateList.size(); i++) {
			total += stateList.get(i).getDeaths();
		}
		return total;
	}
	
/*******************************************************************************/
	
	//display info for state w min cases
	public void displayMinCases() {
		int min = Integer.MAX_VALUE;
		String state = "";
		//get the min amount of cases 
		for (int i = 0; i < stateList.size(); i++) {
			if (stateList.get(i).getCases() < min) {
				min = stateList.get(i).getCases();
				state = stateList.get(i).getStateName();
			}
		}//end of for
		
		System.out.println("State with Min # of Cases: " + state + ", #cases = "+min);
		
	}
	
/*******************************************************************************/
	
	//display info for state w max cases
	public void displayMaxCases() {
		int max = Integer.MIN_VALUE;
		String state = "";
		
		//get the max amount of cases 
			for (int i = 0; i < stateList.size(); i++) {
				if (stateList.get(i).getCases() > max) {
					max = stateList.get(i).getCases();
					state = stateList.get(i).getStateName();
				}
			}
			
		System.out.println("State with Max # of Cases: " + state + ", #cases = "+max);	
	}
	
/*******************************************************************************/
	//display info for state w min deaths
	public void displayMinDeaths() {
		int min = Integer.MAX_VALUE;
		String state = "";
		
		//get the min amount of deaths 
			for (int i = 0; i < stateList.size(); i++) {
				if (stateList.get(i).getDeaths() < min) {
					min = stateList.get(i).getDeaths();
					state = stateList.get(i).getStateName();
				}
			}
			
		System.out.println("State with Min # of Deaths: " + state + ", #deaths = "+min);
			
	}
	
/*******************************************************************************/
		
	//display info for state w max deaths
	public void displayMaxDeaths() {
		int max = Integer.MIN_VALUE;
		String state = "";
		
		//get the max amount of deaths 
		for (int i = 0; i < stateList.size(); i++) {
			if (stateList.get(i).getDeaths() > max) {
				max = stateList.get(i).getDeaths();
				state = stateList.get(i).getStateName();
			}
		}
		
		System.out.println("State with Max # of Deaths: " + state + ", #deaths = "+max);
		
	}
	
/*******************************************************************************/
	public void sortByStateName() {
	    int n = stateList.size();

	    for (int i = 1; i < n; i++) {
	        StateCovidStats key = stateList.get(i);
	        int j = i - 1;

	        // Compare state names and swap if needed
	        while (j >= 0 && stateList.get(j).getStateName().compareTo(key.getStateName()) > 0) {
	            stateList.set(j + 1, stateList.get(j));
	            j = j - 1;
	        }

	        stateList.set(j + 1, key);
	    }
	}

	
/*******************************************************************************/
	
	public void sortByDeath() {
		//using insertion sort, courtesy of zybooks
		
		//variables:
		int i;
		int j;
		StateCovidStats temp = new StateCovidStats();     

		      for (i = 1; i < stateList.size(); ++i) {
		         j = i;
		         
		         // sort states by death
		         // stopping once i in the correct position

		         
		         while (j > 0 && stateList.get(j).getDeaths() > stateList.get(j - 1).getDeaths() ) {

		        	 // set temp to j
		            temp.setStateName(stateList.get(j).getStateName() ); 
		            temp.setCases(stateList.get(j).getCases() ); 
		            temp.setDeaths(stateList.get(j).getDeaths() ); 
		            
		            // set j to j - 1
		            stateList.get(j).setStateName(stateList.get(j - 1).getStateName()); 
		            stateList.get(j).setCases(stateList.get(j - 1).getCases()); 
		            stateList.get(j).setDeaths(stateList.get(j - 1).getDeaths()); 
		            
		           // set j - 1 to temp
		            stateList.get(j-1).setStateName( temp.getStateName()); 
		            stateList.get(j-1).setCases( temp.getCases()); 
		            stateList.get(j-1).setDeaths( temp.getDeaths()); 
		            
		            --j;
		            
		         }// end while
		         
		      }//end for 
		      
		   
	}

/*******************************************************************************/

	public void sortByCases() {
		//using the compare method from StateCovidStats
	Collections.sort(stateList);
	}
/*******************************************************************************/


	//list top # of stats
	public void showTop(int number) {
		int count = 1;
		int counter = 1;
		int total = 0;
		int total2 = 0;
		//display header
		System.out.println("Top " +number+ " States for Cases\n");
		
		//sort the method
		sortByCases();
		
		//print it out
		for (int i = 0; i < number; i++) {
			//make a variable for each wicked statement to make printing easier
			String statename = stateList.get(i).getStateName();
			int gettingCases = stateList.get(i).getCases();
			//align the formatting using print f
			System.out.printf("%8d    %-20s %15d %n", count, statename, gettingCases);
			count++; //add the count for every state
		}
		
		System.out.println("\n-------------------------------------------------");
		
		//get total deaths for specific number 
		for (int i = 0; i < number; i++) {
			total += stateList.get(i).getCases();
		}
		//print it out
		System.out.printf("%-8s %39d %n","Total", total);
		
		
		//do it for deaths
		System.out.println("\nTop " +number+ " States for Deaths\n");
		
		//sort the deaths
		sortByDeath();
		
		//print it out
				for (int i = 0; i < number; i++) {
					
					//make a variable for each wicked statement to make printing easier
					String statename1 = stateList.get(i).getStateName();
					int gettingDeaths = stateList.get(i).getDeaths();
					//align the formatting using print f
					System.out.printf("%8d    %-20s %15d %n", counter, statename1, gettingDeaths);
					counter++; //add the count for every state
				}
				
				System.out.println("\n-------------------------------------------------");
				
				//get total deaths for specific number 
				for (int i = 0; i < number; i++) {
					total2 += stateList.get(i).getDeaths();
				}
				//print it out
				System.out.printf("%-8s %39d %n","Total", total2);
		
		
	}
	
/*******************************************************************************/
	
	public void showTotalCases() {
		
		System.out.println("Total US Cases: "+totalCases());
		
	}
	
/*******************************************************************************/
	
	public void showTotalDeaths() {
		
		System.out.println("Total US Deaths: "+totalDeaths());
		
	}
	
/*******************************************************************************/
	
	//Getters
	
	public StateCovidStats[] getStateList() {
		//covert stateList into an array
		//must cast it
		StateCovidStats[] state = (StateCovidStats[]) stateList.toArray();
		return state;
	}
	
	public String getDiseaseName() {
		return diseaseName;
	}
	
	public String getDateOfStat() {
		return dateOfStat;
	}
	
/*******************************************************************************/
	
	//Setters
	
	public void setdiseaseName(String dName) {
		diseaseName = dName;
	}
	
	
	public void setDateOfStat(String date) {
		dateOfStat = date;
	}
	
	
	

}//end of class
