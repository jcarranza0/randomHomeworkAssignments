/************
Jesus Antonio Carranza
CMPS 261 - Section 2976
Page 1328, Problems 12

Design class Carranza
1)The class Carranza is created to as a test class to use quickSort
	//quickSort sorts by divides the list into smaller parts and sorts the two list  and then combines the list
2)make sure the class sorts an array of 10000 elements using the quickSort algorithm
3)create and array of 10000 using a for loop, and make sure it save to a text file
4)Sort the array using the pivot as the middle element of the array... the middile number
5) make it so the array is sorted by using the pivot as the median of the first, last, and middle elements of the array.
		this means that if you have a list ex) 1 5 7 4 8 45 23 57 75 itcompares the first last and mid so in this example it compares 1 75 and 8 and takes the middle number
6)When the list has been sorted to the last twenty, sort the list using insertion sort.
7)Then calculate and print the CPU time
	a)use the method currentTimeMills of the class System to find the current time of the System in in millisecond as a long value.
	b)Since the method of the system in milliseconds is a static method, so System.currentTimeMillis() will return the time in as a long instead of an int or double
	c)this package is part of the java.lang


**************/


import java.io.*; //needed to use File Reader
import java.util.*; 
 
 public class Carranza
 {
	
	public static void main (String[] args)
								throws FileNotFoundException // if no file is foung the program wont crash it wont crash
	{
	
		Integer[] intList = new Integer[10000]; //this is to make an array of 10000
		Long startTime, endTime, totalTime; //variables for System.currentTimeMillis();
		
		Scanner inFile = new Scanner(new FileReader("f:\\10kNumbers.txt"));//reads the file with the intgers, for this case it reads them from f:\\10kNumbers.txt
		
		int count = 0; //makes the count 0
		
		//this while loop is to get the files from f:\\10kNumbers.txt and puts them in an array list
		while (inFile.hasNext())
		{
			intList[count++] = inFile.nextInt(); //the count++ makes it so the list always has space to add numbers
		}// end while - reading  from textbook
		
		inFile.close(); //closes the infile 
		
		System.out.println(count); //prints out the lsit of numbers
		
		//
		
		SearchSortAlgorithms<Integer> intObject = new SearchSortAlgorithms<Integer>();
		
		print(intList, intList.length);//pritns the unordered list unordered list
		
		startTime = System.currentTimeMillis();//this starts the time System.currentTimeMillis(); but it is a timer thats been running since the 70's
		
		intObject.quickSort(intList, intList.length);//sorts the array list 
		
		endTime = System.currentTimeMillis();//this stops the timer in System.currentTimeMillis();
		
		print(intList, intList.length);//prints out the sorted list
		
		System.out.println(startTime);//prints out he the start time that going to be a big button 
									//the time has been running for a long time
		
		System.out.println(endTime);//prints out the endTime
		
		totalTime = endTime - startTime;//to get the total time you must get your endtime and subtract startTime 
										//total time represent the time it took to sort the list
		System.out.println("The list sorted in: " + totalTime + "milliseconds.");//pritn out the time it took to sort the list
		
	}//end main
	
	//print method from textbook
	
	public static <T> void print(T[] list, int length)
	{
		for(int i = 0; i < length;i++) // it will keep printing until i becomes greater then the length
		{	
			System.out.println(list[i] + " ");
			if ((i + 1) % 20 == 0) // this makes it so when it prints their is a space after every 20 numbers
			{
				System.out.println(); //skip a line
			}
		}
		System.out.println();//prints a blank line so it is the same as skipping line
	
	}//end print
 }//end
 
