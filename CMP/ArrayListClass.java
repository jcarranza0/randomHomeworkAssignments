public abstract class ArrayListClass<T>
                      implements ArrayListADT<T>, Cloneable
{
    protected int length;  //to store the length of the list
    protected int maxSize; //to store the maximum size of
                           //the list
    protected T[] list;    //array to hold the list elements


       //Default constructor
       //Creates an array of size 100
       //Postcondition: list points to the array, length = 0,
       //               and maxSize = 100
    public ArrayListClass()
    {
        maxSize = 100;

        length = 0;
        list = (T[]) new Object[maxSize];
    }

       //Constructor with a parameter
       //Creates an array of the size specified by the
       //parameter size.
       //Postcondition: list points to the array, length = 0,
       //               and maxSize = size
    public ArrayListClass(int size)
    {
        if (size <= 0)
        {
            System.err.println("The array size must be positive. "
                             + "Creating an array of size 100. ");
             maxSize = 100;
        }
        else
            maxSize = size;

        length = 0;
        list = (T[]) new Object[maxSize];
    }

       //Method to determine whether the list is empty.
       //Postcondition: Returns true if the list is empty;
       //               otherwise, returns false.
    public boolean isEmpty()
    {
        return (length == 0);
    }

       //Method to determine whether the list is full.
       //Postcondition: Returns true if the list is full;
       //               otherwise, returns false.
    public boolean isFull()
    {
        return (length == maxSize);
    }

       //Method to return the number of elements in the list.
       //Postcondition: Returns the value of length.
    public int listSize()
    {
        return length;
    }

       //Method to return the maximum size of the list.
       //Postcondition: Returns the value of maxSize.
    public int maxListSize()
    {
        return maxSize;
    }

       //Method to output the elements of the list.
       //Postcondition: Elements of the list are output on the
       //standard output device.
    public void print()
    {
        for (int i = 0; i < length; i++)
            System.out.println(list[i]);
        System.out.println();
    }

       //Returns a copy of objects data in store.
       //This method clones only the references stored in
       //the array. The objects that the array references
       //point to are not cloned.
    public Object clone()
    {
        ArrayListClass<T> copy = null;

        try
        {
            copy = (ArrayListClass<T>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }

        copy.list = (T[]) list.clone();

        return copy;
    }

       //Method to determine whether item is the same as the item
       //in the list at the position specified by location.
       //Postcondition: Returns true if list[location] is the
       //               same as item; otherwise, returns false.
    public boolean isItemAtEqual(int location, T item)
    {
        if (location < 0 || location >= length)
        {
            System.err.println("The location of the item to "
                             + "be compared is out of range.");
            return false;
        }

        return (list[location].equals(item));
    }

       //Method to remove all the elements from the list.
       //Postcondition: length = 0
    public void clearList()
    {
        for (int i = 0; i < length; i++)
            list[i] = null;

          length = 0;

        System.gc();   //invoke garbage collector
    } //end clearList

       //Method to remove the item from the list at the position
       //specified by location.
       //Postcondition: The list element at list[location] is
       //               removed and length is decremented by 1.
       //               If location is out of range, an
       //               appropriate message is output.
    public void removeAt(int location)
    {
        if (location < 0 || location >= length)
            System.err.println("The location of the item to "
                             + "be removed is out of range.");
        else
        {
            for (int i = location; i < length - 1; i++)
                  list[i] = list[i + 1];

            list[length - 1] = null;

            length--;
        }
    } //end removeAt

       //Method to retrieve the element from the list at the
       //position specified by location.
       //Postcondition: A reference of the element at the
       //               position specified by location is
       //               returned. If location is out of range,
       //               an appropriate message is output and
       //               null is returned.
    public T retrieveAt(int location)
    {
        if (location < 0 || location >= length)
        {
            System.err.println("The location of the item to be "
                             + "retrieved is out of range.");
            return null;
        }
        else
            return list[location];
    } //end retrieveAt


       //Method to insert insertItem in the list at the position
       //specified by location.
       //Postcondition: Starting at location, the elements of
       //               the list are shifted to make room for
       //               insertItem, list[location] = insertItem;,
       //               and length++;
       //               If the list is full or location is out
       //               of range, an appropriate message is
       //               output.
    public abstract void insertAt(int location, T insertItem);

       //Method to insert insertItem at the end of the list.
       //Postcondition: list[length] = insertItem; and length++;
       //               If the list is full, an appropriate
       //               message is output.
    public abstract void insertEnd(T insertItem);

        //Method to replace the element in the list at
        //the position specified by location with repItem.
        //Postcondition: list[location] = repItem
        //               If location is out of range, an
        //               appropriate message is output.
    public abstract void replaceAt(int location, T repItem);

       //Method to determine whether searchItem is in the list.
       //Postcondition: If searchItem is found, returns the
       //               location in the array where searchItem
       //               is found; otherwise, returns -1.
    public abstract int seqSearch(T searchItem);

       //Method to remove an item from the list.
       //The parameter removeItem specifies the item to
       //be removed.
       //Postcondition: If removeItem is found in the list, it
       //               is removed from the list and length is
       //               decremented by one.
    public abstract void remove(T removeItem);
}