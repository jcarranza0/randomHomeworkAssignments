/***********
Jesus Antonio Carranza
CMPSC 261 - 2976 Eveninig 
Final Exam Part 2
Problem 16, Page 1329 in textbook


Algorithm 
1. Wirte def. of the methods of the class Canidate
	-that where not given in the program, they located in in "Program example Election Results" 
	-so create the method compareTo
2. Write the def. of the methods processVotes and printResults
	-both methods are located int the class ElectionResults
	-use while loop to get data from text files
	- for loop to make sure all canidates are compared
		- if state to compare the name in the temp array to the cList to find the 
3. write a program that ouputs  the data in the same format as in the example 
	-example is shown in on page 1321 of text

//Thank you Mr. Zmora for the great year. I learned so much and i appreciate your patience.
***///
import java.io.*; //used to input files
import java.util.*;
public class ElectionResult //test Program
{
    static final int NO_OF_CANDIDATES = 6;

    public static void main(String[] args)
    {
        OrderedArrayList<Candidate> candidateList =
               new OrderedArrayList<Candidate>(NO_OF_CANDIDATES);

        Candidate temp;

        try
        {
           Scanner inFile = new Scanner
                     (new FileReader("f:\\candData.txt"));

           fillNames(inFile, candidateList);

           inFile = null;

           inFile = new Scanner
                     (new FileReader("f:\\voteData.txt"));

           processVotes(inFile, candidateList);

           addVotes(candidateList);

           printHeading();
           printResults(candidateList);
        }
        catch (FileNotFoundException fnfe)
        {
           System.out.println(fnfe.toString());
        }
        catch (IOException ioe)
        {
           System.out.println(ioe.toString());
        }
    }

    public static void fillNames(Scanner inFile,
                       OrderedArrayList<Candidate> cList)
    {
        String firstN;
        String lastN;
		

        Candidate temp;

        for (int i = 0; i < NO_OF_CANDIDATES; i++)
        {
            firstN = inFile.next();
            lastN = inFile.next();
			
            temp  = new Candidate();
            temp.setName(firstN, lastN);
            cList.insert(temp);
        }
    }
	//Method to process Votes
    public static void processVotes(Scanner inFile,
                                    OrderedArrayList<Candidate> cList)
    {
		//Variables
        String firstN;// Declare the the string variable for the first name
		String lastN;// Declare the String variable for the last name
		
		int rgn;// Declare the int variable for the region votes
		int votes;// Declare the int variable for the votes in each region
		
		Candidate temp; 
		
		while(inFile.hasNext()) //while loop that loops while file has next data
		{//start while loop
			firstN = inFile.next(); //firstN is set to the next String in input file
			lastN = inFile.next(); //lastN is set to the next String in input file
			
			rgn = inFile.nextInt();//rgn is set to set to the next int in input file
			votes = inFile.nextInt();//votes is set to the next ine in input file
			
			temp = new Candidate(); //create new list
			temp.setName(firstN, lastN);//set firs and last names into the array list
			temp.updateVotesByRegion(rgn, votes);//updates votes by region
			
			for( int i = 0; i < NO_OF_CANDIDATES; i++)//create loop that executes
			{//start for loop											//loops continues until all canidates have gone throught the loop
				if(temp.getLastName().equals(cList.retrieveAt(i).getLastName()))//compare the name in the temp array to the cList to find the 
				{//start if statement																//puts everything in the right place for votes
					cList.retrieveAt(i).updateVotesByRegion(rgn, votes);//update votes in clist inputed from file to correct array list
				}//end if statement
			
			} //end for loop
		} //end while loop
    }//end method processVotes

    public static void addVotes(OrderedArrayList<Candidate> cList)
    {
        Candidate temp;

        for (int i = 0; i < NO_OF_CANDIDATES; i++)
        {
            temp = (Candidate) cList.retrieveAt(i);
            temp.calculateTotalVotes();
        }
    }

    public static void printHeading()
    {
        System.out.println("--------------------Election Results"
                         + "-----------------\n");
        System.out.println("\t\t       "
                         + "Votes By Region");
        System.out.println("Candidate Name  Rgn#1 \tRgn#2 \t"
                         + "Rgn#3 \tRgn#4 \tTotal");
        System.out.println("--------------  ----- \t----- "
                         + "\t----- \t----- \t-----");
    }

    public static void printResults(OrderedArrayList<Candidate> cList) //method to print out the results
    {
		//variables (all are int and all are being set to zero)
       int sumVotes = 0;
	   int largestVotes = 0;
	   int winLoc = 0;
	   
	   Candidate temp; 
	   
	   for( int i = 0; i < NO_OF_CANDIDATES; i++)//for loop will loop until all canidaes have been processed
	   {
			temp = cList.retrieveAt(i);//temp is = to location in cList
			cList.retrieveAt(i).printData();//calls on the printData() method to show the voting data from the candidate
			
			sumVotes = sumVotes + temp.getTotalVotes();//sumVotes to all the votes
			
			if(largestVotes < temp.getTotalVotes())//if statement is used to compare candidates votes
			{
				largestVotes = temp.getTotalVotes();//set largestVotes = to candidtates total votes
				winLoc = i;//sets location of the winning candidates
			}//end if statement

		}//end fot loop
	
		System.out.println(); //prints out a blank line// makes it easier to read for the user
		System.out.println("Winner: " + cList.retrieveAt(winLoc).getFirstName() + " " + cList.retrieveAt(winLoc).getLastName() + ",   " + //print out the winner first name and last name
							"Votes Received: " + cList.retrieveAt(winLoc).getTotalVotes()); // then lets the user know what going to be shown, in this case the total votes recieved for the winner
		
		System.out.println();//skip a line to make the output user to read on command prompt
		
		System.out.println("Total votes polled: " + sumVotes); //letting the user know what the total votes where and the variable sumVotes is the sum of all the votes
   }//end printResults
}