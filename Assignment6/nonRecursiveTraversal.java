public class nonRecursiveTraversal() extends LinkedStackClass<T>
{
	// method for Nonrecursive Inorder Traversal
	public void nonRecursiveInTraversal()
	{
		LinkedStackClass<BinaryTreeNode<T> > stack
					= new LinkedStackClass<BinaryTreeNode<T> >();
					
		BinaryTreeNode<T> current;
		
		current = root;
		
		while (current != null)
			if (current != null)
			{
				stack.push(current);
				current = current.lLink;
			
			}
			else
			{
				current = (BinaryTreeNode<T>) stack.peek();
				stack.pop();
				System.out.print(current.info + " ");
				current = current.rLink;
			}
		System.out.println();
	}
	
	
	
	// method for Nonrecursive Preorder Traversal
	public void nonRecursivePreTraversal()
	{
		LinkedStackClass<BinaryTreeNode<T> > stack
					= new LinkedStackClass<BinaryTreeNode<T> >();
					
		BinaryTreeNode<T> current;
		
		current = root;
		
		while (current != null) || (!stack.isEmpty()))
			if (current != null)
			{
				System.out.print(current.info + " ");
				stack.push(current);
				current = current.lLink;
			
			}
			else
			{
				current = (BinaryTreeNode<T>) stack.peek();
				stack.pop();
				current = current.rLink;
			}
		System.out.println();
	}
	
	
		// method for Nonrecursive Postorder Traversal
	public void nonRecursivePostTraversal()
	{
		LinkedStackClass<BinaryTreeNode<T> > stack
					= new LinkedStackClass<BinaryTreeNode<T> >();
					
		BinaryTreeNode<T> current;
		

		current = root;
		v = 0;
		
		if (current = null) || (!stack.isEmpty())) 
		{
			System.out.print("The binary tree is empty ");
			
		}
		
		if (current != null)
		{
			stack.push(current);
			stack.push(1);
			current = current.lLink;
		}
		
		while (!stack.isEmptyStack())
			if (current = !null && v = 0)
			{
				stack.push(current);
				stack.push(1);
				current = current.lLink;
			}
			else
			{
				current = (BinaryTreeNode<T>) stack.peek();
				stack.pop();
				stack.pop(v);
				if (v == 1)
				{
					stack.push(current);
					stack.push(2)
					current = current.rLink;
					v = 0;
				}
				else
					System.out.print(current.info + " ");
			}
			

		System.out.println();
	}
}