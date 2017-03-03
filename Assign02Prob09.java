/* 
Jesus Antonio Carranza
CMPS 205- 3035 Evening class
Assign02Prob09 
Problem 9, Page 109 of textbook

	Algorithm
		1. Get first decimal number(num1) 
		2. Get second decimal number(num2)
		3. Get third decimal number(num3)
		4. Get fourth decimal number (num4)
		5. Get fith decimal number (num5)
		6  Get all decimals to the nearest integer
		6. Get the sum of all five decimal numbers
		7. This is done by adding all five of the dcimals 
			after they've been made into an integer =(sum)
		8. Get the average by using the (sum) and dividing by
			five, five comes from the number of integers = (average)
		9. Output(to the screen) the sum and the average
		
************/

import java.util.*; // used to input
public class Assign02Prob09
{
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args)
	{
		//variables
		float num1;
		float num2;
		float num3;
		float num4;
		float num5;
		int sum;
		double average;
		
		System.out.println("Please enter five decimal numbers followd by spaces: ");
		
		//these are the inputs
		num1 = console.nextFloat(); 
		num2 = console.nextFloat();
		num3 = console.nextFloat();
		num4 = console.nextFloat();
		num5 = console.nextFloat();
		
		System.out.println();//skip a line (esier to read)
		
		//prints score
		System.out.println("Decimal number 1: " + (int) num1);
		System.out.println("Decimal nunber 2: " + (int) num2);
		System.out.println("Decimal number 3: " + (int) num3);
		System.out.println("Decimal number 4: " + (int) num4);
		System.out.println("Decimal number 5: " + (int) num5);
		
		//adds up all scores and gives you the sum
		sum = (int)num1 + (int)num2 + (int)num3 + (int)num4 + (int)num5;
		System.out.println();
		System.out.println("The Sum is: " + sum);
	
		//finds the average of the five integers
		average = (double)sum / 5;
		System.out.println("The Average is: " + average);
		
	}//end main
}//end Assign02Prob09
		
		
		
		