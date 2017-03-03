/************************
Jesus Antonio Carranza
CMPS 205 - 3035 Evening class
Assign02Prob11
Problem 11, Page 109 of textbook

Algorithm
1.Make it so the user can input integers (data inserted = seconds)
2.Convert seconds inputed to hours, minutes, and seconds (HHMMSS)
3.Get hours by dividing seconds inputed by 3600 
4.Get min. for output by by using the remiander of hours 
5.Divide remainder by 60 to get the output minutes
6.Get the seconds by divideing the remainder (remainder1) by 60 and that reamainder is the seconds(secondsOut)
7.Output (to screen) the hours, minutes, and seconds (HH:MM:SS)


*************/

 import java.util.*;
 public class Assign02Prob11
 {
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args)
	{
		
		int secondsIn;
		int hours;
		int remainder1;
		int minutes;
		int secondsOut;
		String str;
		
		System.out.println();
		
		//to input seconds
		System.out.println("Enter number of sceonds: " );
		secondsIn = console.nextInt();
		System.out.println();
		
		
		//to get hours
		hours = secondsIn / 3600;
		
		remainder1 = secondsIn % 3600;
		
		//to get min.
		minutes = remainder1 / 60;
		
		//to get sec.
		secondsOut = remainder1 % 60;
		
		//to apear in hr:min:sec format
		str = hours + ":" + minutes + ":" + secondsOut;
		System.out.println("The hours, minutes, and seconds are: " + str);
		
		
	}//end main
 }//end Assign02Prob11
 