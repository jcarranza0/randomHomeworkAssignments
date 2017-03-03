/***********
Jesus Antonio Carranza
CMPSC 261 - 2976 Eveninig 
Assignment6
Problem 6, Page 1425 in textbook


Algorithm
1. Import java.util.*
2. Make main method // this is where you will test the methods
3. Create binary search tree myTree
4. Declare int variable num
5. Test the program using user input
6. Prompt user to input a set of integers
7. make while loop to insert integers in myTree
8. Print out the inorder traversal
9. Print out the preorder traversal
10. Print out the postorder traversal


/////BinaryTree/////
1.Create a binary tree, i will use Scanner so the user can input the numbers from command prompt
2.Write a definition of the method to implement the nonrecursive inorder traversal alogithm 
	this one is already in the text so i can use it from there, but i have to make sure i understand it.
	understand that in a inorder traversal it visits the node in a left, node, right order
3.Write the definition  of the  method to implement the nonrecursive preorder traversal algorithm.
	since the order of a preorder traversal is Node, Left, Right 
	- so it the list is not empty or null
	- the order it will go throught the binary tree is first the node then it will go to the left link
	- after it goes to the left and the left is null it will go to the right link
4.Write the definition  of the  method to implement the nonrecursive postorder traversal algorithm.
	- for this method you will need to create to seperate stacks that are (parallel)
	- one will save the reference to a node, and another to save the int value (1 or 2).
	- In this method the left and right subtree are visited before the node
	- after visiting the left subtree of a node  and before visiting the node  we must tell the node that the right subtree needs to be visited 
	- and same goes for the right, we also save the value int 1 before moving to the left subtree
	- we also save the value int 2 before moving to the right subtree
	- and the int value assosiated with the reference is popped
	- the integer value lets you know if the left or right subtree have been visited.

***///
//Data: 65 78 34 22 40 89 50 75 80 100 90 97 45 120 105 -333 //data i will input to test if program works

import java.util.*;

public class BinarySearchTreeProgram
{
    static Scanner console = new Scanner(System.in); //scanner is used so user can input data

    public static void main(String[] args) //main method
    {
        BinarySearchTree<Integer> treeRoot =  //creates binary tree but nothing is in it
                 new BinarySearchTree<Integer>();

        Integer num; //variable num

        System.out.println("Enter integers ending with -333 to create binary tree"); //let let the user know that he should insert numbers to creae binary tree

        num = console.nextInt(); //num will be the next number inserted

        while (num != -333) //numbers insered will keep being variable num until -333 is inserted
        {
            treeRoot.insert(num); //insert number into the binary tree 
            num = console.nextInt();// the next numeber insered will go to the binary tree // num = next input
        }

        System.out.println(); //skip a line, prints out blank line

        System.out.println("treeRoot nodes using nonrecursive " //prints out the massage
                         + "inorder traversal method: ");
        treeRoot.nonRecursiveInTraversal(); //uses the method on the binary tree // Intorder traversal
        
		System.out.println();	//skip a line, prints out blank line
		
		System.out.println("treeRoot nodes using nonrecursive "	//prints out the massage
                         + "Preorder traversal method: ");
        treeRoot.nonRecursivePreTraversal(); //uses method one the binary tree // Pretorder traversal
		
		System.out.println();	//skip a line, prints out blank line
		
		System.out.println("treeRoot nodes using nonrecursive "	//prints out the massage
                         + "Postorder traversal method: ");
        treeRoot.nonRecursivePostTraversal(); //uses method on binary tree // Postorder traversal
    }
}