/***********
Jesus Antonio Carranza
CMPSC 261 - 2976 Eveninig 
Assignment7 (Extra Credit)
Problem 7, Page 1425 in textbook

/////AVLTreeADT/////
 -create an ADT class
 - to creat the ADT make sure it is exteded form cloneable 
 -create comments to know what the ADT methods do
 -add the following ADT mehtods clone, copyTree, and Traversal algorithms 
 -(note: I do not need to implement the delete operation)
 -create comments to the ADT methods added
*/

public interface AVLTreeADT<T> extends Cloneable //the class AVLTreeADT is derived from Cloneable
{
	public Object clone();
		//Returns a clone of this AVL tree.
		//This method clones only the references stored in the
		//nodes of the AVL tree. The objects that AVL tree
		//nodes point to are not cloned.
	
    public boolean isEmpty();
		//Method to determine whether the AVL tree is empty.
		//Postcondition: Returns true if the AVL tree is
		//               empty; otherwise, returns false.

    public void insert(T newItem);
       //Method to insert insertItem in the AVL tree.
       //Postcondition: If no node in the AVL tree has the
       //               same info as insertItem, a node with the
       //               info insertItem is created and inserted
       //               in the AVL search tree.

    public void inorderTraversal();
		//Method to do an inorder traversal of the AVL tree.
		//Postcondition: The nodes of the AVL tree are
        //               output in the inorder sequence.

    public void preorderTraversal();
		//Method to do a preorder traversal of the AVL tree.
		//Postcondition: The nodes of the AVL tree are output
		//               in the preorder sequence.

    public void postorderTraversal();
		//Method to do a postorder traversal of the AVL tree.
		//Postcondition: The nodes of the AVL tree are output
		//               in the postorder sequence.

    public boolean search(T searchItem);
       //Method to determine whether searchItem is in the AVL
       //tree.
       //Postcondition: Returns true if searchItem is found
       //               in the AVL tree;
       //               otherwise, returns false.  
	   
	public int treeHeight();
		//Method to determine the height of the AVL tree.
       //Postcondition: The height of the AVL tree is
       //               returned.

}