/*
Jesus Antonio Carranza 
Cs 3100
Assignment2

The Assignment problem is as follows. You are going to use the Array<E> class in java. 
Unlike the regular arrays, ArrayList is a resizable-array, i.e., can keep adding elements at the end of the array. 
You will need to do the following.

1-write down a new class PrintArrayOperation that inherits the ArrayList class

2-the new class will overide teh following ArrayList functions:

         a) add(E)

         b) get(i)

         c) remove(i)

          d) set(i,e)

3-in the new functions you will need to call the original function and add a print statement showing what you currently added/retreived/removed/changed for example, when calling add(10) the function will add10 to the end of the array and print "I added 10"

4-you will need to provide sample code showing how your new class is working
*/

/*
The definition of a class that uses a class from the Java Class Library must be preceded by import statement.
ex) to use the class ArraysList you need 
		import java.util.ArraysList;
you can also replace ArrayList in the statement with a asterisk(*) to make all java.util available 
*/
import java.util.ArrayList;

//To indicate that the class PrintArrayOperation is a subclass of Arraylist we write it as shown below 
//allows classPrintArrayOperation to use methods from class ArrayList 
//creating the object
public class PrintArrayOperation<Item> extends ArrayList<Item> 
{
	/* 
	Override the method (useful for two reasons)
	1-so that you can take advantage of the compiler checking to make sure you actually are overriding a method 
	when you think you are. This way, if you make a common mistake of misspelling of a method name 
	or not correctly matching the parameters, you will be warned that you method does not actually override 
	as you think it did. 
	2-it makes your code easier to understand because it is more obvious when methods are overwritten.
	*/
    @Override
	/* 
	Precondition: nothing happens and array stays the same
	postcondition: an item is added to the array and output message saying what was added to the array
	*/
    public boolean add(Item e) {
        //print statement here
        System.out.println("I added "+ e + " to the array");
        //actually add the element in here
        return super.add(e);
		// means I am invoking the ArrayList's add function
    }
    //Override method
    @Override
	/* 
	Precondition: nothing happens and array stays the same
	postcondition: sets the item specified by the index to be changed
		ex) if in index 2 their is a 3 and you specify index 2 to be 4 it changes the item
	*/
    public Item set(int index, Item e)
    {
        //print statement here
        System.out.println("I set index " + index + " to " + e + " in the array");
        //actually set the elements in the index wanted
        return super.set(index,e);
		// means I am invoking the ArrayList's set function
    }
	//override method
	@Override
	/* 
	Precondition: nothing happens and array stays the same
	postcondition: gets the index asked for but does nothing to the index it just gets it
	*/
	public Item get(int index)
	{
		//print statement here
		System.out.println("get index " + index + " from the array");
		//actually set the get the index
		return super.get(index);
		// means I am invoking the ArrayList's get function
	}
	//overriding the method
	@Override
	/* 
	Precondition: nothing happens and array stays the same
	postcondition: removes the index from the array getting rid of the entire slot in the array
	*/
	public Item remove(int index)
	{
		//print statement here
		System.out.println("index "+ index + " is removed from array");
		//actually remove index from array
		return super.remove(index);
		// means I am invoking the ArrayList's remove function
	}
	
    //Main 
	//to test methods 
    public static void main(String []args)
    {
		//which creates an object of type PrintArrayOperation
        PrintArrayOperation<Integer> list = new PrintArrayOperation();
		System.out.println("Cs 3100 Assignment 2");
		//calls the method add. adds to the ints to list
        list.add(5);
		list.add(6);
		list.add(8);
		list.add(45);
		list.add(100);
		//calls the method set. and sets the the item in the index specified in the list
        list.set(0,1);
		list.set(4,6);
		//calls the method get. gets the int from the index specified and hold on to it
		list.get(1);
		//calls the method remove to remove from list by selecting an index.
		list.remove(0);
		//prints the list
		System.out.print(list);
    }
    
    
}