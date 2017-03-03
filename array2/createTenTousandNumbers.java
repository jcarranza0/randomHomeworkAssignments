import java.io.*;
import java.util.*;
 
 public class createTenThousandNumbers
 {
	
	public static void main (String[] args)
								throws FileNotFoundException // if no file it wont crash
	{
	
		//create file to save to saver on drive
		PrintWriter outFile = new PrintWriter("f:\\outputs.txt");
		
		 for (int count = 0; count < 10000; count++)      
        {
            num = (int) (Math.random() * 10000); //creates a random number = num              
			System.out.println(); // a skipped line to make it easier to read
			//outfiles are going to be made into txt file on f:
			outFile.print("" + num); 
			outFile.println(""); 
			
		}
		outFile.close();//closes outfile
	}
 }//end GuessTheNumber