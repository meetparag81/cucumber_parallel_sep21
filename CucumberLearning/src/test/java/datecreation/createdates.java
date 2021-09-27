package datecreation;

import java.time.LocalDate;
import java.util.Random;

public class createdates {
	
	public static void main(String[] args) {
		GenerateRandomDate(LocalDate.now(),"past");
	}
	
	public static void GenerateRandomDate(LocalDate StartRange, String dateType)
    {
        // dateType = "past";
           
          Random rand = new Random();
        
        LocalDate todaysDate = StartRange;
        int randomNum = rand.nextInt((15 - 1) + 1) + 1;
		
		if (dateType.equals("past")){
        	
           
			todaysDate = todaysDate.minusDays(randomNum);
        
        }
        else if (dateType.equals("future" ))
        {
            todaysDate = todaysDate.plusDays(randomNum);
        }
        else if (dateType.equals("current") || dateType.equals(""))
        {
             todaysDate = LocalDate.now();
        }
        
    }

}
