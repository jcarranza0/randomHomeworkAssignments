/***********
Jesus Antonio Carranza
CMPSC 261 - 2976 Eveninig 
Assignment7 (Extra Credit)
Problem 7, Page 1425 in textbook


Algorithm 
1. Import java.util.*
2. Make main method // this is where you will test the methods
3. declare variables 
4. class to test methods is AVLTestProgram
5. Import Scanner
6. in the main method
 -create while loop to get integers into the AVL Tree
7. Test methods 
-treeRoot.nonRecursiveInTraversal()
-treeRoot.nonRecursivePreTraversal()
-treeRoot.nonRecursivePostTraversal()
-treeRoot.treeHeight(); //lets user know the height of the AVL Tree
-insert - insert numeber to the AVL tree
-isEmpty - determine whether the AVL tree is empty.
//make sure results are printed out correctly



/////AVLTreeADT/////
 -create an ADT class
 - to creat the ADT make sure it is exteded form cloneable 
 -create comments to know what the ADT methods do
 -add the following ADT mehtods clone, copyTree, and Traversal algorithms 
 -(note: I do not need to implement the delete operation)
 -create comments to the ADT methods added
 
 /////AVLTree & AVLSeaarchTree////
 -write the def. of the classt that implements an AVltree as an ADT
 -import java.util.NoSuchElementException; 
 -creaet methods needed for an AVLTRee
 - make sure AVLSearchTree<T> extends AVLTree<T>

***///


//Data: 65 78 34 22 40 89 50 75 80 100 90 97 -333 //data i will input to test if program works

import java.util.*;

public class AVLTreeProgram //AVLTreeProgram class is the test program
{
	static Scanner console = new Scanner(System.in); //used so user can inpute data into Command Prompt
	 
    public static void main(String[] args) //main method
    {
        AVLSearchTree<Integer> treeRoot =  
                 new AVLSearchTree<Integer>(); 

        Integer num; //variable
		System.out.println("");//skip line
		System.out.println("Hello welcome to the AVL Program \n");//welcom user to program
		System.out.println("The AVL tree empty: " + treeRoot.isEmpty()); //since isEmpty method is a boolean then it will return true if it is empty
																			// and false it is not empty
		System.out.println();//skip line
		System.out.println("Enter integers ending with -333 to create AVL tree"); //letting user know to insert integers
		
        num = console.nextInt();  //num is the next number inserted

        while (num != -333) //while loop to inert a list of integers and will keep looping until -333 is inserted
        {
            treeRoot.insert(num);  //inserting numeber into list
            num = console.nextInt(); //next int inserted becomes num
        }//end while
		System.out.println(); //skip line
		System.out.println("The AVL tree empty: " + treeRoot.isEmpty()); //since isEmpty method is a boolean then it will return true if it is empty
																			// and false it is not empty
		
               
		System.out.println(); //skip a line

        System.out.println("treeRoot nodes using nonrecursive " //letting the user know whats going to be printed
                         + "inorder traversal method: ");
        treeRoot.nonRecursiveInTraversal(); // print out AVLtree nonRecursive in order Traversal
		
		System.out.println("treeRoot nodes using nonrecursive "	//letting the user know whats going to be printed
                         + "Preorder traversal method: ");
        treeRoot.nonRecursivePreTraversal(); // print out AVLtree nonRecursivePreTraversal
		
		System.out.println();	//skip a line
		
		System.out.println("treeRoot nodes using nonrecursive "	//letting the user know whats going to be printed
                         + "Postorder traversal method: ");
        treeRoot.nonRecursivePostTraversal(); //print out AVLtree in nonRecursivePostTraversal
		
		System.out.println();	//skip a line
		
		
        System.out.println("treeRoot Height: " //letting the user know whats going to be printed
                          + treeRoot.treeHeight()); //treeHeight is going to be outputted
		
		System.out.println("number 99 is being added to AVL Tree "); //letting user what going to happen next //letting user know what is going on
		treeRoot.insert(99);//inserting 99 into the AVL tree
		
		System.out.println(); //skip a line

        System.out.println("treeRoot nodes using nonrecursive " //letting the user know whats going to be printed
                         + "inorder traversal method\n after 99 is added to the list: ");
        treeRoot.nonRecursiveInTraversal(); // print out AVLtree nonRecursive in order Traversal
		
		System.out.println();	//skip a line
		
		System.out.println("treeRoot nodes using nonrecursive "	//letting the user know whats going to be printed
                         + "Preorder traversal method\n after 99 is added to the list: ");
        treeRoot.nonRecursivePreTraversal(); // print out AVLtree nonRecursivePreTraversal
		
		System.out.println();	//skip a line
		
		System.out.println("treeRoot nodes using nonrecursive "	//letting the user know whats going to be printed
                         + "Postorder traversal method\n after 99 is added to the list: ");
        treeRoot.nonRecursivePostTraversal(); //print out AVLtree in nonRecursivePostTraversal
		
		System.out.println();	//skip a line
		
		System.out.println("treeRoot Height: " //letting the user know whats going to be printed
                          + treeRoot.treeHeight()); //treeHeight is going to be outputted
    }
}
    
