/**
 Jesus Antonio Carranza
 CS4450
 Final 
 
 O-[]-[   ]-[]-O
 	   / \
 	 (noise)
 */


//importing the header files from the directory io in java 
//" * "  means every file in that io directory is imported 
import java.io.*; 
//imports all the classes in the java.util-package including java.util.Scanner
import java.util.*;

  public class cs4450
  {
	  static Scanner console = new Scanner(System.in);
	  public static void main(String args[]) throws IOException
	  {
		  //Reads text from a character-input stream 
		  //buffering characters so as to provide for the efficient reading of characters, arrays, and lines
		  BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		 
		  //output message
		  //prompt user to enter a character
		  System.out.print("Insert characters or message to convert to ASCII: ");
		  
		  //Reads characters into a portion of an array. 
		  //This method will block until some input is available
		  //an I/O error occurs
		  //or the end of the stream is reached
		  //set characters as strings
		  String str = buffer.readLine();
		  
		  System.out.println("Characer | ASCII Code \n---------------------");
		  //for loop stops when no more characters are in the string
		  //converting character to its ASCII code
		  for ( int i = 0; i < str.length(); ++i )
		  {
			  char character = str.charAt(i);
			  int ascii = (int) character;
			  System.out.println("    " + character + "     |    " + ascii);
		  }
		  
		  //insert empty line to make program easier to read
		  System.out.println("");
		  
		  //inform user how to use program
		  System.out.print("!!!When insterting ASCII code please include a space inbetween codes!!! "
		  		+ "\n  ->> To terminate program please insert terminate code: 101110100 <<- " 
				+ "\n Insert ASCII code to convert to characters: ");
		  
		  //variable int
		  int ascii;
			
		  	//next integer inserted is assigned as variable ascii
			ascii = console.nextInt();
			
			//while user does not assign 101110100 to variable ascii program will continue to run
			//character to ascii code
			 while (ascii != 101110100)
			 {
				 //converting ascii to characer 
				 String aChar = new Character((char) ascii).toString();
				 //used to organize output
				 System.out.println("    " + ascii + "   |    " + aChar);
				 //next integer inserted is assigned to variable ascii
				 ascii = console.nextInt();
			 }
			 //message to let user know program is terminated
			System.out.print("Program terminated");			
	  }
  }