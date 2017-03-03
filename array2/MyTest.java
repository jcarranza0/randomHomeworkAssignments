import java.io.*;
import java.util.*;
 
 public class MyTest
 {
	
	public static void main (String[] args)
								throws FileNotFoundException // if no file it wont crash
	{
	
		Integer[] intList = new Integer[10000];
		Long startTime, endTime, totalTime;
		
		Scanner inFile = new Scanner(new FileReader("f:\\10kNumbers.txt"));
		
		int count = 0; 
		while (inFile.hasNext())
		{
			intList[count++] = inFile.nextInt();
		}// end while - reading  from textbook
		
		inFile.close();
		System.out.println(count);
		
		//
		
		SearchSortAlgorithms<Integer> intObject = new SearchSortAlgorithms<Integer>();
		
		print(intList, intList.length);//unordered list
		startTime = System.currentTimeMillis();
		intObject.quickSort(intList, intList.length);
		endTime = System.currentTimeMillis();
		print(intList, intList.length);//sorted list
		System.out.println(startTime);
		System.out.println(endTime);
		totalTime = endTime - startTime;
		System.out.println("quickSort sorted the list in: " + totalTime + "milliseconds.");
		
	}//end main
	
	//print method from textbook
	
	public static <T> void print(T[] list, int length)
	{
		for(int i = 0; i < length;i++)
		{	
			System.out.print(list[i] + "");
			if ((i + 1) % 20 == 0)
			{
				System.out.println();
			}
		}
		System.out.println();
	
	}
 }//end 
 
 
 
 //class System
 //ti