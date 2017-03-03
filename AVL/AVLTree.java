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

import java.util.NoSuchElementException;

public abstract class AVLTree<T> implements AVLTreeADT<T> //implements is used because this is how you build a class on top
{															//of classes that are interfaces
         //Definition of the class implementing AVL nodes
	protected class AVLNode<T>
	{
		public T info;
		public int bfactor;
		public AVLNode<T> lLink; //the left link
		public AVLNode<T> rLink; //the right link 

		//Default constructor
		//Postcondition: info = null; bfactor = 0;
		//               lLink = null; rLink = null;
		public AVLNode()
		{
			info = null;
			bfactor = 0;
			lLink = null;
			rLink = null;
		}

       //Constructor with parameters
       //Sets info to point to the object elem points to,
       //bfactor is set to bf; lLink is set to point to the
       //object left points to, and rLink is set to point to
       //the object right points to.
       //Postcondition: info = elem;  bfactor = bf;
       //               lLink = left; rLink = right;
		public AVLNode(T elem, int bf, AVLNode<T> left,
                   AVLNode<T> right)
		{
			info = elem;
			bfactor = bf;
			lLink = left;
			rLink = right;
		}

	       //Returns a clone of this AVL tree.
	       //This method only clone the references stored in the
	       //nodes of the binary tree. The objects that AVL tree
	       //nodes point to are not cloned.
	    public Object clone()
	    {
	        AVLNode<T> copy = null;

	        try
	        {
	            copy = (AVLNode<T>) super.clone();

	        }
	        catch (CloneNotSupportedException e)
	        {
	            return null;
	        }

	        return copy;
	    }

		
       //Method to return the info as a string.
       //Postcondition: info as a String object is returned.
		public String toString()
		{
			return info.toString();
		}
	}
	
     //Instance variables
	protected AVLNode<T> root;
	
       //Default constructor
       //Postcondition: root = null;
    public AVLTree()
    {
         root = null;
    }	
	
	    //Returns a clone of this AVL tree.
       //This method clones only the references stored in the nodes
       //of the AVL tree. The objects that binary tree nodes
       //point to are not cloned.
    public Object clone()
    {
        AVLTree<T> copy = null;

        try
        {
            copy = (AVLTree<T>) super.clone();

        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }

        if (root != null)
            copy.root = copyTree(root);

        return copy;
    }

	protected boolean isTaller;
	
	
	private AVLNode<T> rotateToLeft(AVLNode<T> root)
	{
		AVLNode<T> p; //reference variable to the root of
					  //the right subtree of root

		if (root == null)
			System.err.println("Error in the tree."); //err because with no data their can't be a tree
		else
			if (root.rLink == null)
				System.err.println("Error in the tree: "
								+ "No right subtree to rotate.");
			else
			{
				p = root.rLink;
				root.rLink = p.lLink; //the left subtree of p
									  //becomes the right
                                  //subtree of root
				p.lLink = root;
				root = p;   //make p the new root node
			}

		return root;
	}//end rotateToLeft

	private AVLNode<T> rotateToRight(AVLNode<T> root)
	{
		AVLNode<T> p;  //reference variable to the root of the
                   //left subtree of root

		if (root == null)
			System.err.println("Error in the tree.");
		else
			if (root.lLink == null)
				System.err.println("Error in the tree: "
								+ "No left subtree to rotate.");
			else
			{
				p = root.lLink;
				root.lLink = p.rLink; //the right subtree of p
									  //becomes the left subtree of root
				p.rLink = root;
				root = p;    //make p the new root node
			}

		return root;
	}//end rotateToRight

	private AVLNode<T> balanceFromLeft(AVLNode<T> root)
	{
		AVLNode<T> p;
		AVLNode<T> w;

		p = root.lLink;   //p points to the left subtree
						  //of root

		switch (p.bfactor)
		{
		case -1: root.bfactor = 0;
				p.bfactor = 0;
				root = rotateToRight(root);
				break;
		case 0:  System.err.println("Error: Cannot balance "
								+ "from the left.");
				break;
		case 1:  w = p.rLink;
				switch (w.bfactor)  //adjust the balance factors
				{
				case -1: root.bfactor = 1;
						p.bfactor = 0;
						break;
				case 0:  root.bfactor = 0;
						p.bfactor = 0;
						break;
				case 1:  root.bfactor = 0;
						p.bfactor = -1;
				}//end switch

				w.bfactor = 0;
				p = rotateToLeft(p);
				root.lLink = p;
				root = rotateToRight(root);
		}//end switch;

		return root;
	}//end balanceFromLeft

	private AVLNode<T> balanceFromRight(AVLNode<T> root)
	{
		AVLNode<T> p;
		AVLNode<T> w;

		p = root.rLink;  //p points to the right
						//subtree of root

		switch (p.bfactor)
		{
		case -1: w = p.lLink;
				switch (w.bfactor) //adjust the balance factors
				{
				case -1: root.bfactor = 0;
						p.bfactor = 1;
						break;
				case 0:  root.bfactor = 0;
						p.bfactor = 0;
						break;
				case 1:  root.bfactor = -1;
						p.bfactor = 0;
				}//end switch

				w.bfactor = 0;
				p = rotateToRight(p);
				root.rLink = p;
				root = rotateToLeft(root);
				break;
		case 0: System.err.println("Error: Cannot balance "
								+ "from the right.");
				break;
		case 1:  root.bfactor = 0;
				p.bfactor = 0;
				root = rotateToLeft(root);
		}//end switch;

		return root;
	}//end balanceFromRight

	private AVLNode<T> insertIntoAVL(AVLNode<T>  root,
									AVLNode<T>  newNode)
	{
		if (root == null)
		{
			root = newNode;
			isTaller = true;
		}
		else
			if (root.info.equals(newNode.info))
				System.err.println("No duplicates are allowed.");
			else
			{
            Comparable<T> temp = (Comparable<T>) root.info;

				if (temp.compareTo(newNode.info) > 0) //newNode
													  //goes in the left subtree
				{
					root.lLink = insertIntoAVL(root.lLink,
												newNode);
	
					if (isTaller)    //after insertion, the
									//subtree grew in height
						switch (root.bfactor)
						{
						case -1: root = balanceFromLeft(root);
								isTaller = false;
								break;
						case 0:  root.bfactor = -1;
								isTaller = true;
								break;
						case 1:  root.bfactor = 0;
								isTaller = false;
						}//end switch
				}//end if
				else
				{
					root.rLink = insertIntoAVL(root.rLink,
												newNode);

					if (isTaller)       //after insertion, the
										//subtree grew in height
						switch (root.bfactor)
						{
						case -1: root.bfactor = 0;
								isTaller = false;
								break;
						case 0:  root.bfactor = 1;
								isTaller = true;
								break;
						case 1:  root = balanceFromRight(root);
								isTaller = false;
						}//end switch
				}//end else
			}

		return root;
	}//end insertIntoAVL
	
       //Method to determine whether the AVL tree is empty.
       //Postcondition: Returns true if the AVL tree is
       //               empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return(root == null);
	}

       //Method to do an inorder traversal of the AVL tree.
       //Postcondition: The nodes of the AVL tree are output
       //               in the inorder sequence.
    public void inorderTraversal()
    {
         inorder(root);
    }

       //Method to do a preorder traversal of the AVL tree.
       //Postcondition: The nodes of the AVL tree are output
       //               in the preorder sequence.
    public void preorderTraversal()
    {
         preorder(root);
    }

       //Method to do a postorder traversal of the AVL tree.
       //Postcondition: The nodes of the AVL tree are output
       //               in the postorder sequence.
    public void postorderTraversal()
    {
         postorder(root);
    }

	   //Method to determine whether searchItem is in the AVL
	   //tree.
	   //Postcondition: Returns true if searchItem is found
	   //               in the AVL tree;
	   //               otherwise, returns false.
    public abstract boolean search(T searchItem);

	//method to insert a new number into the AVL tree
	public void insert(T newItem)
	{
		isTaller = false;
		AVLNode<T>  newNode;

		newNode = new AVLNode<T>(newItem, 0, null, null);

		root = insertIntoAVL(root, newNode);
	}
	
	    //Method to determine the height of the AVL tree.
       //Postcondition: The height of the AVL tree is
       //               returned.
    public int treeHeight()
    {
         return height(root);
    }
		
	    //Method to do an inorder traversal of the AVL
       //tree to which p points.
       //Postcondition: The nodes of the AVL tree to which p
       //               points are output in the inorder
       //               sequence.
    private void inorder(AVLNode<T> p)
    {
        if (p != null)
        {
            inorder(p.lLink);
            System.out.print(p.info + " ");
            inorder(p.rLink);
        }
    }

       //Method to do a preorder traversal of the AVL
       //tree to which p points.
       //Postcondition: The nodes of the AVL tree to which p
       //               points are output in the preorder
       //               sequence.
    private void preorder(AVLNode<T> p)
    {
        if (p != null)
        {
            System.out.print(p.info + " ");
            preorder(p.lLink);
            preorder(p.rLink);
        }
    }

       //Method to do a postorder traversal of the AVL
       //tree to which p points.
       //Postcondition: The nodes of the AVL tree to which p
       //               points are output in the postorder
       //               sequence.
    private void postorder(AVLNode<T> p)
    {
        if (p != null)
        {
            postorder(p.lLink);
            postorder(p.rLink);
            System.out.print(p.info + " ");
        }
    }

       //Method to determine the height of the AVL tree
       //to which p points.
       //Postcondition: The height of the AVL tree to
       //               which p points is returned.
    private int height(AVLNode<T> p)
    {
        if (p == null)
            return 0;
        else
            return 1 + Math.max(height(p.lLink),
                                height(p.rLink));
    }

        //Method to make a copy of the AVL tree to which
        //otherTreeRoot points.
        //Postcondition: A copy of the AVL tree to which
        //               otherTreeRoot is created and the reference of
        //               the root node of the copied AVL tree
        //               is returned.
    private AVLNode<T> copyTree
                       (AVLNode<T> otherTreeRoot)
    {
        AVLNode<T> temp;

        if (otherTreeRoot == null)
            temp = null;
        else
        {
            temp = (AVLNode<T>) otherTreeRoot.clone();
            temp.lLink = copyTree(otherTreeRoot.lLink);
            temp.rLink = copyTree(otherTreeRoot.rLink);
        }

        return temp;
    }//end copyTree
	
	//Method to Traverse a AVL tree in order
	//Postcondition: The AVL tree will be printed out in order 
	//				from least to greatest
    //NonRecursive inorder traversal algorithm
    public void nonRecursiveInTraversal()	//Left Node Right //inOrder gives you the tree in order
    {
        LinkedStackClass<AVLNode<T> > stack	//create a stacklist named stack
                        = new LinkedStackClass<AVLNode<T> >();
						
        AVLNode<T> current;
		
        current = root; //sets current to the root of the Binary tree, starts the traversal at the root

        while ((current != null) || (!stack.isEmptyStack()))//while current is not null or stack is not empty the following will happen
            if (current != null)							//if current is not null then puch current onto the stack
            {
                stack.push(current); //push current 
                current = current.lLink; //guides current to be pushed to the left link
            }
            else //if current is null
            {
                current = (AVLNode<T>) stack.peek(); //current will peek to the noede then it pops the node that is null
                stack.pop();								//makeing it so the node goes back to the upper node
                System.out.print(current.info + " ");		//prints out the nodes info then it
                current = current.rLink;					//makes current go to the right link
            }

        System.out.println(); //skip a line
    }
	
	//Method to Traverse a AVL tree in preorder
	//Postcondition: The AVL tree will be printed out in a node, left, right link
    //NonRecursive Preorder traversal algorithm
	public void nonRecursivePreTraversal() //Node Left Right
	{
		LinkedStackClass<AVLNode<T> > stack						//creates a stack
					= new LinkedStackClass<AVLNode<T> >();
					
		AVLNode<T> current;
		
		current = root;//start the traversal at the root node and sets current to root
		
		while ((current != null) || (!stack.isEmptyStack())) //while current is not null or stack is not empty the following will happen
			if (current != null)							//if current is not null
			{														// print the node info  
				System.out.print(current.info + " ");
				stack.push(current);								//push the current to the left link
				current = current.lLink;
			
			}
			else//if current is null
			{
				current = (AVLNode<T>) stack.peek();  //pop stack into current
				stack.pop();
				current = current.rLink;//prepare to visit the
			}							//right subtree
		System.out.println(); //prints a blank line also used to skip a line
	}
	
	//Method to Traverse a AVL tree in postorder
	//Postcondition: The AVL tree will be printed out in a Left, Right, Node order
    //		NonRecursive Postorder traversal algorithm
	public void nonRecursivePostTraversal()//Left Right Node
	{
		LinkedStackClass<AVLNode<T> > stack					//creates a stack 
					= new LinkedStackClass<AVLNode<T> >();
		
		LinkedStackClass<Integer> vStack						//create a second stack named vStack
					= new LinkedStackClass<Integer>();
					
					
		AVLNode<T> current;

		current = root;//start the traversal ar the root node so it sets curretn to root
	
		
		int v = 0; //sets variable to 0
		
		if (current == null) //if current is null; then prints out "The Binary tree is empty"
		{
			System.out.print("The binary tree is empty ");
			
		}
		else//if it is not empty it does the following
		{									
			stack.push(current); 		//push current onto the stack
			vStack.push(1);				//puch 1 onto vStack
			current = current.lLink;	//then for stack it will set it to the left link
		}
		
		while (!stack.isEmptyStack()) //while the stack is not empty it will go to the if statement
			if (current != null && v == 0) //if current is not null and v is 0 the following will happen
			{
				stack.push(current);		//current will be pushed in the binary tree for stack
				vStack.push(1);				//1 will be pushed into vstack
				current = current.lLink;	//current in stack will go to the left child
			}
			else//if current is null and v is not 0 do the following
			{
				current = (AVLNode<T>) stack.peek();
				v = vStack.peek();								//it will peek to see what v is  and then pop it
				stack.pop();									//if current is null stack will pop the null in the binary tree
				vStack.pop();									
				if (v == 1)						//if v is 1
				{
					stack.push(current);		//if v = 1 then stack will push current 
					vStack.push(2);				//if v = 1 then vStack will push 2 to the vstack
					current = current.rLink;	// stack will guide the push to the right link
					v = 0; 						//v is set to 0
				}
				else	//if v is not 1 currents info will be printed
					System.out.print(current.info + " ");
			}
			

		System.out.println(); //print a blank line, used to skip line
		
		
	}
}