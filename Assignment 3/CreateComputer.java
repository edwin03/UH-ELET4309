  //Program Name : CreateComputer.java
  //Assignment No :3
  //Name : Edwin Rubio
  //Date : 02/28/2011

import java.io.*;
import java.util.*;

/* Class CPU*/
class CPU {
	String type; 	//type String
	float speed; 	//type float
	int cache; 		//type int
	int FSB; 		//type int
	
	// Default Constructor
	CPU() {
		type = "";
		speed = 0;
		cache = 0;
		FSB = 0;
	}
	
	// Parameterized Constructor
	CPU(String type, float speed, int cache, int FSB) {
		this.type = type;
		this.speed = speed;
		this.cache = cache;
		this.FSB = FSB;
	}
	
	//Mutator for type
	public void setType(String type) {
		this.type = type;
	}
	
	//Mutator for speed
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	//Mutator for cache
	public void setCache(int cache) {
		this.cache = cache;
	}
	
	//Mutator for FSB
	public void setFSB(int FSB) {
		this.FSB = FSB;
	}
	
	//Accessor for type
	public String getType() {
		return type;
	}
	//Accessor for speed
	public float getSpeed() {
		return speed;
	}
	
	//Accessor for cache
	public int getCache() {
		return cache;
	}
	
	//Accessor for FSB
	public int getFSB() {
		return FSB;
	}
}

/*Abstarct Class Computer*/
abstract class Computer {

	// Instance fields
	String manufacturer;	//type String
	String model;			//type String
	CPU cpu = new CPU();	//type CPU class
	int hardDrive;			//type int
	String color;			//type string
	double price;			//type double (in dollars)
	private boolean isPowerOn; // check if power is on or off
	
	// Default Constructor
	Computer() {
		manufacturer = "";
		model = "";
		hardDrive = 0;
		color = "";
		price = 0.0;
		isPowerOn = false;
		
	}
	
	//Mutator for manufacturer
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	//Mutator for model
	public void setModel(String model) {
		this.model = model;
	}
	
	//Mutator for hardDrive
	public void setHardDrive(int hardDrive) {
		this.hardDrive = hardDrive;
	}
	
	//Mutator for color
	public void setColor(String color) {
		this.color = color;
	}
	
	//Mutator for price
	public void setPrice(double price) {
		this.price = price;
	}
	
	//Accessor for manufacturer
	public String getManufacturer() {
		return manufacturer;
	}
	
	//Accessor for model
	public String getModel() {
		return model;
	}
	
	//Accessor for hardDrive
	public int getHardDrive() {
		return hardDrive;
	}
	
	//Accessor for color
	public String getColor() {
		return color;
	}
	
	//Accessor for price
	public double getPrice() {
		return price;
	}
	
	// Instance methods
	//Method to start the computer
	public void start() {
		isPowerOn = true;
	}
	
	//Method to shutdown the computer
	public void shutdown() {
		isPowerOn = false;
	}
	
	//Method to check the status of the computer
	public boolean status() {
		return isPowerOn;
	}
	
	
}

class Desktop extends Computer {
	int raidLevel;
	
	//Mutator for noOfTyres
	public void setRaidLevel(int raidLevel) {
		this.raidLevel = raidLevel;
	}
	
	//Accessor for raidLevel
	public int getRaidLevel() {
		return raidLevel;
	}
	
	/* toString method to print the information of Desktop */
	public String toString(){
		String output = "\n*********************************";
		output = output + "\nDesktop Computer";
		output = output + "\nManufacturer: " + manufacturer;
		output = output + "\nModel: " + model;
		output = output + "\nCPU:";
		output = output + "\nType: " + cpu.getType();
		output = output + "\nSpeed: " + cpu.getSpeed() + "GHZ";
		output = output + "\nCache: " + cpu.getCache() + "MB";
		output = output + "\nFSB: " + cpu.getFSB() + "MHZ";
		output = output + "\nHard Drive: " + hardDrive + "GB";
		output = output + "\nRaid Level: " + raidLevel;
		output = output + "\nColor: " + color;
		output = output + "\nPrice:$" + price;
		output = output + "\n*********************************";
		return output ;		
	}
    
	
}

class Notebook extends Computer {
	int screenSize;
	
	//Mutator for screenSize
	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}
	
	//Accessor for screenSize
	public int getScreenSize() {
		return screenSize;
	}
	/* toString method to print the the information of Notebook*/
    public String toString(){
		String output = "\n*********************************";
		output = output + "\nNotebook Computer";
		output = output + "\nManufacturer: " + manufacturer;
		output = output + "\nModel: " + model;
		output = output + "\nCPU:";
		output = output + "\nType: "+ cpu.getType();
		output = output + "\nSpeed: "+ cpu.getSpeed() +"GHZ";
		output = output + "\nCache: " + cpu.getCache() + "MB";
		output = output + "\nFSB: " + cpu.getFSB() + "MHZ";
		output = output + "\nHard Drive: " + hardDrive + "GB";
		output = output + "\nScreen Size: " + screenSize + "inches";
		output = output + "\nColor: " + color;
		output = output + "\nPrice:$" + price;
		output = output + "\n*********************************";
		return output ;		
	}
}

/*Main class*/
public class CreateComputer {
        
    public static void main(String[] args) {
    	
    	//Creating Desktop and Notebook objects
    	Desktop desk = new Desktop();
		Notebook note = new Notebook();
		
		//Arraylist to store the objects of Computers
		ArrayList<Computer> compList = new ArrayList<Computer>();
		
    	//Enter field as command line argument
    	Scanner line = new Scanner(System.in);
    	char answer = 'a';
    	String option;
    	String choice;
    	
    	//Loop will continue till 'q' or 'Q' is pressed
    	while ( Character.toLowerCase(answer) != 'q'){
    	    
    	    //Displaying the option for the user to select	
	    	System.out.println("\nChoose one of the following options: ");
	    	System.out.println("i (Input Computer info)");
			System.out.println("d (Display Computer info)");
			System.out.println("s (Start a computer)");
			System.out.println("u (Shut down a computer)");
			System.out.println("q (Quit program)");
		
		   	//user input using a keyboard
	    	option = line.nextLine();
	    	answer = option.charAt(0);
	    	
	    	//Checking if user enters option i
	    	if ( option.equals("i") || option.equals("I") ){
	    		
	    		//Prompt the user to enter computer details
	    		System.out.println("Choose one of the computer types listed below:");
	    		System.out.println("1. desktop computer");
	    		System.out.println("2. notebook computer");
	    		choice = line.nextLine();
	    		int ch = Integer.parseInt(choice);
	    		
	    		if ( ch == 1 ){
	    			//Prompt user to enter Desktop details
    				System.out.print("Enter manufacturer:");
	    			String mnf = line.nextLine();
	    			desk.setManufacturer(mnf);
	    			
	    			System.out.print("Enter model:");
	    			String model = line.nextLine();
	    			desk.setModel(model);
	    			
	    			System.out.print("Enter CPU type:");
	    			String type = line.nextLine();
	    			desk.cpu.setType(type);
	    			
	    			System.out.print("Enter CPU speed (GHZ):");
	    			String speed = line.nextLine();
	    			float sp = Float.parseFloat(speed);
	    			desk.cpu.setSpeed(sp);
	    			
	    			System.out.print("Enter CPU cache (MB):");
	    			String cache = line.nextLine();	
					int che = Integer.parseInt(cache);
					desk.cpu.setCache(che); 
						
					System.out.print("Enter FSB (MHZ):");
					String FSB = line.nextLine();
					int fsb = Integer.parseInt(FSB);
					desk.cpu.setFSB(fsb);
					
									
					System.out.print("Enter hard drive capacity (GB):");
					String  hDrive = line.nextLine();
					int hardDrive = Integer.parseInt(hDrive);
					desk.setHardDrive(hardDrive);
					 
					System.out.print("Enter color:");
					String color = line.nextLine();
					desk.setColor(color);
						
					System.out.print("Enter raid level:");
					String rLevel = line.nextLine();
					int raidLevel = Integer.parseInt(rLevel);
					desk.setRaidLevel(raidLevel);
						
					System.out.print("Enter price ($):");
					String amount = line.nextLine();
					double price = Double.parseDouble(amount);
					desk.setPrice(price);
					
					//Adding desktop in arraylist
					compList.add(desk);
				
					System.out.print( "\n" + desk.getManufacturer() + "  " + desk.getModel() 
									+ " was built successfully!"); 	// message at the end of each desktop computer creating
					 
				} else if( ch == 2 ){
					//Prompt user to enter Notebook details
					System.out.print("Enter manufacturer:");
	    			String mnf = line.nextLine();
	    			note.setManufacturer(mnf);
	    			
	    			System.out.print("Enter model:");
	    			String model = line.nextLine();
	    			note.setModel(model);
    			
	    			System.out.print("Enter CPU type:");
	    			String type = line.nextLine();
	    			note.cpu.setType(type);
	    			
	    			System.out.print("Enter CPU speed (GHZ):");
	    			String speed = line.nextLine();
	    			float sp = Float.parseFloat(speed);
	    			note.cpu.setSpeed(sp);
	    			
	    			System.out.print("Enter CPU cache (MB):");
	    			String cache = line.nextLine();	
					int che = Integer.parseInt(cache);
					note.cpu.setCache(che); 
						
					System.out.print("Enter FSB (MHZ):");
					String FSB = line.nextLine();
					int fsb = Integer.parseInt(FSB);
					note.cpu.setFSB(fsb);
					
					System.out.print("Enter hard drive capacity (GB):");
					String  hDrive = line.nextLine();
					int hardDrive = Integer.parseInt(hDrive);
					note.setHardDrive(hardDrive);
					 
					System.out.print("Enter color:");
					String color = line.nextLine();
					note.setColor(color);
						
					System.out.print("Enter screen Size:");
					String sSize = line.nextLine();
					int screenSize = Integer.parseInt(sSize);
					note.setScreenSize(screenSize);
						
					System.out.print("Enter price ($):");
					String amount = line.nextLine();
					double price = Double.parseDouble(amount);
					note.setPrice(price);
					
					//Adding notebook in arraylist
					compList.add(note);
				
					System.out.print("\n" + note.getManufacturer() + " " + note.getModel()
									+ " was built successfully!"); // message at the end of each notebook computer creating
					
				}
			
    		} else if( option.equals("d") || option.equals("D") ){ 		//Checking if user enters option d  
    			System.out.print("Enter a computer number to be displayed:");
    			choice = line.nextLine();
	    		int ch = Integer.parseInt(choice);
	    		if( compList.size() == 0){
	    			System.out.println("*********************************");
					System.out.println("No computer has been created.");
					System.out.println("*********************************");
	    		}else{
	    			System.out.println(compList.get(ch));
	    		}
	    		
    			
    		} else if( option.equals("s") || option.equals("S") ){		//Checking if user enters option s
    		
    			boolean power = desk.status();
    			System.out.print("Enter a computer number you wish to start: ");
				choice = line.nextLine();
    			int ch = Integer.parseInt(choice);
    			if( power == false){
    				if( compList.size() == 0){
		    			System.out.println("*********************************");
						System.out.println("No computer has been created.");
						System.out.println("*********************************");
	    			}else{
    					compList.get(ch).start();
    					System.out.print("\nManufacturer" + note.getManufacturer() 
    								+ " Model " + note.getModel() + " has been started" );
	    			}
    				
    				
    			}else {
    				System.out.println("\nCan't start ; Computer is currently on. ");
    			}
    			
    		} else if( option.equals("u") || option.equals("U") ){		//Checking if user enters option u
    		
    			boolean power = desk.status();
    			System.out.print("Enter a computer number you wish to shut down: ");
				choice = line.nextLine();
    			int ch = Integer.parseInt(choice);
	    			
    			if( power == true){
    				if( compList.size() == 0){
		    			System.out.println("*********************************");
						System.out.println("No computer has been created.");
						System.out.println("*********************************");
	    			}else{
    					compList.get(ch).shutdown();
    					System.out.print("\nShutting Down....");
	    			}
    				
    			}else {
    				System.out.println("\nCan't stop ; Computer is already in power off mode. ");
    			}
    			
    		}
    			
    	
    	}
    	
    }
}
