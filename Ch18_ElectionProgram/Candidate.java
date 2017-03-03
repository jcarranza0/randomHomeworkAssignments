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
public class Candidate extends Person
{
    private final int NO_OF_REGIONS = 4;
    private int[] votesByRegion;
    private int totalVotes;

       //Default constructor
       //Postcondition: Creates the array votesByRegion and
       //               sets totalVotes to zero.
    Candidate()
    {
        super();
        totalVotes = 0;
        votesByRegion = new int[NO_OF_REGIONS];
    }

       //Method to set the votes of a candidate for a
       //particular region.
       //Postcondition: The votes specified by the parameter votes
       //               are assigned to the region specified by the
       //               parameter region.
    public void setVotes(int region, int votes)
    {
        votesByRegion[region - 1] = votes;
    }

       //Method to update the votes of a candidate for a
       //particular region.
       //Postcondition: The votes specified by the parameter votes
       //               are added to the region specified by the
       //               parameter region.
    public void updateVotesByRegion(int region, int votes)
    {
        votesByRegion[region - 1] = votesByRegion[region - 1]
                                    + votes;
    }

        //Method to calculate the total votes received by a
       //candidate.
       //Postcondition: The votes received in each region are added.
    public void calculateTotalVotes()
    {
        totalVotes = 0;

        for (int i = 0; i < NO_OF_REGIONS; i++)
            totalVotes += votesByRegion[i];
    }

       //Method to return the total votes received by a
       //candidate.
       //Postcondition: The total votes received by the candidate
       //               are returned.
    public int getTotalVotes()
    {
        return totalVotes;
    }

       // Method to output the candidate’s name, the votes
       //received in each region, and the total votes received.
    public void printData()
    {
        System.out.printf("%-14s ", super.toString());

        for (int i = 0; i < NO_OF_REGIONS; i++)
             System.out.printf("%6d  ", votesByRegion[i]);

        System.out.printf("%5d%n", totalVotes);
    }

    public boolean equals(Object otherElement)
    {
        Candidate temp = (Candidate) otherElement;

        return (this.getFirstName().equals(temp.getFirstName())
                && this.getLastName().equals(temp.getLastName()));
    }
	
	//Method 
    public int compareTo(Object otherElement)
    {
        Candidate temp = (Candidate) otherElement;
		
		if (this.getFirstName().equals(temp.getFirstName())
			&& this.getLastName().equals(temp.getLastName()))
			return 0;
		else
			if((this.getLastName().compareTo(temp.getLastName()) < 0)
					|| ((this.getLastName().equals(temp.getLastName()) 
					&& (this.getFirstName().compareTo(temp.getFirstName()) < 0))))
				return -1;
			else
				return 1;
    }
}

















