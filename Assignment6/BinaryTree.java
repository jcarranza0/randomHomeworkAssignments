/***********
Jesus Antonio Carranza
CMPSC 261 - 2976 Eveninig 
Assignment6
Problem 6, Page 1425 in textbook



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
import java.util.NoSuchElementException;

public abstract class BinaryTree<T> implements BinaryTreeADT<T>
{
         //Definition of the node
    protected class BinaryTreeNode<T> implements Cloneable
    {
        public T info;
        public BinaryTreeNode<T> lLink;
        public BinaryTreeNode<T> rLink;

           //Default constructor
           //Postcondition: info = null; link = null;
        public BinaryTreeNode()
        {
            info = null;
            lLink = null;
            rLink = null;
        }

           //Constructor with parameters
           //Sets info to point to the object elem points to and
           //lLink and rLink are set to point to the objects left
           //and right, respectively.
           //Postcondition:  info = elem; lLink = left;
        public BinaryTreeNode(T elem, BinaryTreeNode<T> left,
                                      BinaryTreeNode<T> right)
        {
            info = elem;
            lLink = left;
            rLink = right;
        }

           //Returns a clone of this binary tree.
           //This method clones only the references stored in
           //the nodes of the binary tree. The objects that binary
           //tree nodes point to are not cloned.
        public Object clone()
        {
            BinaryTreeNode<T> copy = null;

            try
            {
                copy = (BinaryTreeNode<T>) super.clone();

            }
            catch (CloneNotSupportedException e)
            {
                return null;
            }

            return copy;
        }

           //Method to return the info as a string.
           //Postcondition: info as a String object is
           //               returned.
        public String toString()
        {
            return info.toString();
        }
    } // end class BinaryTreeNode


    protected BinaryTreeNode<T> root;

       //Default constructor
       //Postcondition: root = null;
    public BinaryTree()
    {
         root = null;
    }

       //Returns a clone of this binary tree.
       //This method clones only the references stored in
       //the nodes of the binary tree. The objects that binary
       //tree nodes point to are not cloned.
    public Object clone()
    {
        BinaryTree<T> copy = null;  //new BinaryTree<T>();

        try
        {
            copy = (BinaryTree<T>) super.clone();

        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }

        if (root != null)
            copy.root = copyTree(root);

        return copy;
    }

       //Method to determine whether the binary tree is empty.
       //Postcondition: Returns true if the binary tree is
       //               empty; otherwise, returns false.
    public boolean isEmpty()
    {
         return (root == null);
    }

       //Method to do an inorder traversal of the binary tree.
       //Postcondition: The nodes of the binary tree are output
       //               in the inorder sequence.
    public void inorderTraversal()
    {
         inorder(root);
    }

       //Method to do a preorder traversal of the binary tree.
       //Postcondition: The nodes of the binary tree are output
       //               in the preorder sequence.
    public void preorderTraversal()
    {
         preorder(root);
    }

       //Method to do a postorder traversal of the binary tree.
       //Postcondition: The nodes of the binary tree are output
       //               in the postorder sequence.
    public void postorderTraversal()
    {
         postorder(root);
    }

       //Method to determine the height of the binary tree.
       //Postcondition: The height of the binary tree is
       //               returned.
    public int treeHeight()
    {
         return height(root);
    }

       //Method to determine the number of nodes in the
       //binary tree.
       //Postcondition: The number of nodes in the binary tree
       //               is returned.
    public int treeNodeCount()
    {
         return nodeCount(root);
    }

       //Method to determine the number of leaves in the
       //binary tree.
       //Postcondition: The number of leaves in the binary tree
       //               is returned.
    public int treeLeavesCount()
    {
         return leavesCount(root);
    }

       //Method to destroy the binary tree.
       //Postcondition: root = null
    public void destroyTree()
    {
        root = null;
    }


	   //Method to determine whether searchItem is in the
	   //binary search tree.
	   //Postcondition: Returns true if searchItem is found
	   //               in the binary search tree;
	   //               otherwise, returns false.
    public abstract boolean search(T searchItem);

	   //Method to insert insertItem in the binary search tree.
	   //Postcondition: If no node in the binary search tree has
	   //               the same info as insertItem, a node with
	   //               the info insertItem is created and
	   //               inserted in the binary search tree.
	public abstract void insert(T insertItem);

	   //Method to delete deleteItem from the binary search
	   //tree.
	   //Postcondition: If a node with the same info as
	   //               deleteItem is found, it is deleted
	   //               from the binary search tree.
	public abstract void deleteNode(T deleteItem);


       //Method to do an inorder traversal of the binary
       //tree to which p points.
       //Postcondition: The nodes of the binary tree to which p
       //               points are output in the inorder
       //               sequence.
    private void inorder(BinaryTreeNode<T> p)
    {
         if (p != null)
         {
            inorder(p.lLink);
            System.out.print(p.info + " ");
            inorder(p.rLink);
         }
    }

       //Method to do a preorder traversal of the binary
       //tree to which p points.
       //Postcondition: The nodes of the binary tree to which p
       //               points are output in the preorder
       //               sequence.
    private void preorder(BinaryTreeNode<T> p)
    {
         if (p != null)
         {
            System.out.print(p.info + " ");
            preorder(p.lLink);
            preorder(p.rLink);
         }
    }

       //Method to do a postorder traversal of the binary
       //tree to which p points.
       //Postcondition: The nodes of the binary tree to which p
       //               points are output in the postorder
       //               sequence.
    private void postorder(BinaryTreeNode<T> p)
    {
         if (p != null)
         {
            postorder(p.lLink);
            postorder(p.rLink);
            System.out.print(p.info + " ");
         }
    }

       //Method to determine the height of the binary tree
       //to which p points.
       //Postcondition: The height of the binary tree to
       //               which p points is returned.
    private int height(BinaryTreeNode<T> p)
    {
        if (p == null)
            return 0;
        else
            return 1 + Math.max(height(p.lLink),
                                height(p.rLink));
    }


       //Method to determine the number of nodes in the binary
       //tree to which p points.
       //Postcondition: The number of nodes in the binary tree
       //               to which p points is returned.
    private int nodeCount(BinaryTreeNode<T> p)
    {
        System.out.println("See Programming Exercise 1.");
        return 0;
    }
       //Method to determine the number of leaves in the binary
       //tree to which p points.
       //Postcondition: The number of leaves in the binary tree
       //               to which p points is returned.
    private int leavesCount(BinaryTreeNode<T> p)
    {
        System.out.println("See Programming Exercise 2.");
        return 0;
    }

        //Method to make a copy of the binary tree to
        //which otherTreeRoot points.
        //Postcondition: A copy of the binary tree to which
        //               otherTreeRoot is created and the reference of
        //               the root node of the copied binary tree
        //               is returned.
    private BinaryTreeNode<T> copyTree
                       (BinaryTreeNode<T> otherTreeRoot)
    {
         BinaryTreeNode<T> temp;

         if (otherTreeRoot == null)
            temp = null;
         else
         {
            temp = new BinaryTreeNode<T>();
            temp.info = otherTreeRoot.info;
            temp.lLink = copyTree(otherTreeRoot.lLink);
            temp.rLink = copyTree(otherTreeRoot.rLink);
         }

         return temp;
    }//end copyTree

	//Method to Traverse a binary tree in order
	//Postcondition: The binary tree will be printed out in order 
	//				from least to greatest
    //NonRecursive inorder traversal algorithm
    public void nonRecursiveInTraversal()	//Left Node Right //inOrder gives you the tree in order
    {
        LinkedStackClass<BinaryTreeNode<T> > stack	//create a stacklist named stack
                        = new LinkedStackClass<BinaryTreeNode<T> >();
        BinaryTreeNode<T> current;
        current = root; //sets current to the root of the Binary tree, starts the traversal at the root

        while ((current != null) || (!stack.isEmptyStack()))//while current is not null or stack is not empty the following will happen
            if (current != null)							//if current is not null then puch current onto the stack
            {
                stack.push(current); //push current 
                current = current.lLink; //guides current to be pushed to the left link
            }
            else //if current is null
            {
                current = (BinaryTreeNode<T>) stack.peek(); //current will peek to the noede then it pops the node that is null
                stack.pop();								//makeing it so the node goes back to the upper node
                System.out.print(current.info + " ");		//prints out the nodes info then it
                current = current.rLink;					//makes current go to the right link
            }

        System.out.println(); //skip a line
    }
	
	//Method to Traverse a binary tree in preorder
	//Postcondition: The binary tree will be printed out in a node, left, right link
    //NonRecursive Preorder traversal algorithm
	public void nonRecursivePreTraversal() //Node Left Right
	{
		LinkedStackClass<BinaryTreeNode<T> > stack						//creates a stack
					= new LinkedStackClass<BinaryTreeNode<T> >();
					
		BinaryTreeNode<T> current;
		
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
				current = (BinaryTreeNode<T>) stack.peek();  ///pop stack into current
				stack.pop();
				current = current.rLink;//prepare to visit the
			}							//right subtree
		System.out.println(); //prints a blank line also used to skip a line
	}
	
	//Method to Traverse a binary tree in postorder
	//Postcondition: The binary tree will be printed out in a Left, Right, Node order
    //		NonRecursive Postorder traversal algorithm
	public void nonRecursivePostTraversal()//Left Right Node
	{
		LinkedStackClass<BinaryTreeNode<T> > stack					//creates a stack 
					= new LinkedStackClass<BinaryTreeNode<T> >();
		
		LinkedStackClass<Integer> vStack						//create a second stack named vStack
					= new LinkedStackClass<Integer>();
					
					
		BinaryTreeNode<T> current;

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
				current = (BinaryTreeNode<T>) stack.peek();
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