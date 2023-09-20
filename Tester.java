import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		
		AllCovidStats stats = new AllCovidStats();
		int count = 0; //keep track of total states
		
		//load the data 
		stats.loadData("src/sampleDataOld2021.txt");
		
				
		//display everything
		
		stats.displayMinCases();
		stats.displayMaxCases();
		System.out.println();
		stats.displayMinDeaths();
		stats.displayMaxDeaths();
		
		System.out.println();
		stats.showTotalCases();
		stats.showTotalDeaths();
		
		System.out.println("Avg State Cases: "+ stats.avgCases());
		System.out.println("Avg State Deaths: "+ stats.avgDeaths()+"\n");
		
		stats.showTop(10);
		
		
		
		

	}

}
