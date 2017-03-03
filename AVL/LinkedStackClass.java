
public class LinkedStackClass<T> implements StackADT<T>
{
        //Definition of the node
    private class StackNode<T>
    {
        public T info;
        public StackNode<T> link;

           //Default constructor
           //Postcondition: info = null; link = null;
        public StackNode()
        {
            info = null;
            link = null;
        }

           //Constructor with parameters
           //Sets info point to the object elem points to
           //and link is set to point to the object ptr
           //points to.
           //Postcondition:  info = elem; link = ptr
        public StackNode(T elem, StackNode<T> ptr)
        {
            info = elem;
            link = ptr;
        }

           //Method to return the info as a string.
           //Postcondition: info as a String object is
           //               returned.
        public String toString()
        {
            return info.toString();
        }
    }

        //Instance variable
    private StackNode<T> stackTop;  //reference variable to the
                                    //top element of the stack

        //Default constructor
        //Postcondition: stackTop = null
    public LinkedStackClass()
    {
        stackTop = null;
    }

        //Method to initialize the stack to an empty state.
        //Postcondition: stackTop = null
    public void initializeStack()
    {
        stackTop = null;
    }// end initializeStack

        //Method to determine whether the stack is empty.
        //Postcondition: Returns true if the stack is empty;
        //               otherwise, returns false.
    public boolean isEmptyStack()
    {
        return (stackTop == null);
    }

        //Method to determine whether the stack is full.
        //Postcondition: Returns true if the stack is full;
        //               otherwise, returns false.
    public boolean isFullStack()
    {
        return false;
    }

        //Method to add newItem to the stack.
        //Postcondition: The stack is changed and newItem
        //               is added to the top of stack.
    public void push(T newElement)
    {
        StackNode<T> newNode; //reference variable to create
                              //the new node

        newNode = new
                  StackNode<T>(newElement, stackTop); //create
                                          //newNode and insert
                                          //before stackTop

        stackTop = newNode; //set stackTop to point to
                            //the top element
    } //end push


        //Method to return a refernece to the top element of
        //the stack.
        //Precondition: The stack exists and is not empty.
        //Postcondition: If the stack is empty, the method throws
        //               StackUnderflowException; otherwise, a
        //               reference to a copy of the top element
        //               of the stack is returned.
    public T peek() throws StackUnderflowException
    {
        if (stackTop == null)
            throw new StackUnderflowException();

        return (T) stackTop.info;
    }//end top


        //Method to remove the top element of the stack.
        //Precondition: The stack exists and is not empty.
        //Postcondition: The stack is changed and the top
        //               element is removed from the stack.
        //               If the stack is empty, the method throws
        //               StackUnderflowException
    public void pop()throws StackUnderflowException
    {
        if (stackTop == null)
            throw new StackUnderflowException();

        stackTop = stackTop.link;  //advance stackTop to the
                                   //next node
    }//end pop
}