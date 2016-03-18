
  //Program Name : AutoSales.java
  //Assignment No :2
  //Name : Edwin Rubio
  //Date : 02/17/2011


import java.io.*;
import java.util.*;


public class AutoSales {
    //main method    
    public static void main(String[] args) {
    	
    	//Enter filename as command line argument
    	Scanner keyboard = new Scanner(System.in);
    	String[] line = null;
    	String manuFacturer; // manufacturer name
	int[] monthlySalesFigure = new int[12]; // 12 sales figures
	String[] arrMonth = new String[13]; //month name
	int annualSales; //Yearly Sales
        int avgMonthSales = 0; //Average monthly Sales
    	
    	try{
    		//Prompt user to input file name
        	System.out.print("Enter file name: ");
        	String userFile = keyboard.nextLine();
        	File file = new File(userFile);
	        Scanner scanner = new Scanner(file);
	        
	        /*Read the first line of the file and store it in array */
        	String string = scanner.nextLine();
        	int highestSales = 0;
        	int index = 0;
        	//Store all the month of header line in array
        	arrMonth = string.split(",");
        	//Check till end of file
			while (scanner.hasNext()) {
				//Read next line in the file
				string = scanner.nextLine();
				/*Split the line when gets "," delimeter and store the contents
				  in an array */
				line = string.split(",");
				int i = 0;
				annualSales = 0;
        		String monthName = " ";
        		//manufacturer for each line
				manuFacturer = line[i];
				highestSales = Integer.valueOf(line[1]);
				for(i = 1; i < line.length ; i++){
					/*Checking the highest sale in the array*/
	        		if(Integer.valueOf(line[i]) > highestSales){  
						highestSales = Integer.valueOf(line[i]);
						index = i;  
					}
					monthlySalesFigure[i-1] = Integer.valueOf(line[i]);
					//Calculating total sales of the year
					annualSales = annualSales + monthlySalesFigure[i-1];
					//Storing the month which contains highest sale
					monthName = arrMonth[index];
				}
         		
				//Calculating average monthly Sales
	        	avgMonthSales = annualSales/12;
	        	
	        	//Printing 
	        	System.out.println("\n************************************************");
	        	System.out.println("Manufacturer: " + manuFacturer);
	        	System.out.println("Total Yearly Sales: " + annualSales);
	        	System.out.println("Average Monthly Sales:" + avgMonthSales);
	        	System.out.println(monthName + " has the Highest Sales:" + highestSales);
	        	System.out.println("************************************************");
         			
         		
			}
         scanner.close();
        }catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
    }
    
}
