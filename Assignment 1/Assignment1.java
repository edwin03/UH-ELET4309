/**
 * ELET4309
 * Assignment 1
 * Name: Edwin Rubio
 */

import java.util.Scanner;
public class Assignment1 
{
	public static void main(String[] args) 
	{
		String input;
		char input2;
		int a = 0;
		double tempc, tempf;
		
		do
		{
		System.out.println("=====================================================\n");
		System.out.println("Please choose an option for temperature conversion:");
		System.out.println("1: Fahrenheit to Celsius");
		System.out.println("2: Celsius to Fahrenheit");
		System.out.println("x: Exit\n");
		System.out.println("=====================================================");
		
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		input2 = input.charAt(0);
		
		switch (input2)
		{
		case '1': 
			System.out.println("Please enter a number in Fahrenheit to convert: ");
			double x = in.nextDouble();
			tempc = (x-32)*(.555);
			System.out.printf("Celsius = %.1f\n", tempc);
			break;
			
		case '2':
			System.out.println("Please enter a number in Celsius to convert: ");
			double y = in.nextDouble();
			tempf = (y*(1.8))+ 32;
			System.out.printf("Fahrenheit = %.1f\n", tempf);
			break;
			
		case 'x':
			System.out.println("Exiting the program.\n");
			a = 1;
			System.exit(0);
			break;
			
		default:
			System.out.println("Invalid Selection.\n");
			break;
		}
		}while(a == 0);
		
		
	}

}
