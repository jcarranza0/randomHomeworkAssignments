/***********
Jesus Antonio Carranza
CMPSC 261 - 2976 Eveninig 
Assignment7 (Extra Credit)
Problem 7, Page 1425 in textbook

/////AVLTree & AVLSeaarchTree////
 -write the def. of the classt that implements an AVltree as an ADT
 -import java.util.NoSuchElementException; 
 -creaet methods needed for an AVLTRee
 - make sure AVLSearchTree<T> extends AVLTree<T>
*/


public class AVLSearchTree<T> extends AVLTree<T> //the class AVLSearchTree is derived from AVLTree
{
       //Default constructor
       //Postcondition: root = null;
    public AVLSearchTree()
    {
        super();
    }

       //Method to determine whether searchItem is in the
       //binary search tree.
       //Postcondition: Returns true if searchItem is found
       //               in the AVL search tree;
       //               otherwise, returns false.
    public boolean search(T searchItem)
    {
        AVLNode<T> current;
        boolean found = false;

        if (root == null)
            System.out.println("Cannot search an empty tree.");
        else
        {
            current = root;

            while (current != null && !found)
            {
                Comparable<T> temp =
                         (Comparable<T>) current.info;

                if (temp.compareTo(searchItem) == 0)
                    found = true;
                else if (temp.compareTo(searchItem) > 0)
                    current = current.lLink;
                else
                    current = current.rLink;
            }//end while
        }//end else

        return found;
    }//end search


}