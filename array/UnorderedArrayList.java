public class UnorderedArrayList<T> extends ArrayListClass<T>
{
	   //Default constructor
    public UnorderedArrayList()
    {
        super();
    }

       //Constructor with a parameter
    public UnorderedArrayList(int size)
    {
        super(size);
    }

       //Method to determine whether searchItem is in the list.
       //Postcondition: If searchItem is found, returns the
       //               location in the array where searchItem
       //               is found; otherwise, returns -1.
    public int seqSearch(T searchItem)
    {
        int loc;
        boolean found = false;

        for (loc = 0; loc < length; loc++)
            if (list[loc].equals(searchItem))
            {
                found = true;
                break;
            }

        if (found)
            return loc;
        else
            return -1;
    } //end seqSearch

       //Method to insert insertItem in the list at the position
       //specified by location.
       //Postcondition: Starting at location, the elements of
       //               the list are shifted to make room for
       //               insertItem, list[location] = insertItem;,
       //               and length++;
       //               If the list is full or location is out
       //               of range, an appropriate message is
       //               output.
    public void insertAt(int location, T insertItem)
    {
        if (location < 0 || location >= maxSize)
            System.err.println("The position of the item to "
                             + "be inserted is out of range.");
        else if (length >= maxSize)  //list is full
            System.err.println("Cannot insert in a full list.");
        else
        {
            for (int i = length; i > location; i--)
                list[i] = list[i - 1];  //move the elements down

            list[location] = insertItem;
            length++;   //increment the length
        }
    } //end insertAt

       //Method to insert insertItem at the end of the list.
       //Postcondition: list[length] = insertItem; and length++;
       //               If the list is full, an appropriate
       //               message is output.
    public void insertEnd(T insertItem)
    {
        if (length >= maxSize)  //the list is full
            System.err.println("Cannot insert in a full list.");
        else
        {
              list[length] = insertItem;  //insert the
                                          //item at the end
              length++; //increment the length
        }
    } //end insertEnd


       //Method to replace the element in the list at
       //the position specified by location with repItem.
       //Postcondition: list[location] = repItem
       //               If location is out of range, an
       //               appropriate message is output.
    public void replaceAt(int location, T repItem)
    {
        if (location < 0 || location >= length)
            System.err.println("The location of the item to "
                             + "be replaced is out of range.");
        else
            list[location] = repItem;
    } //end replaceAt

       //Method to remove an item from the list.
       //The parameter removeItem specifies the item to
       //be removed.
       //Postcondition: If removeItem is found in the list, it
       //               is removed from the list and length is
       //               decremented by one.
    public void remove(T removeItem)
    {
        int loc;

        if (length == 0)
            System.err.println("Cannot delete from an "
                             + "empty list.");
        else
        {
            loc = seqSearch(removeItem);

            if (loc != -1)
                removeAt(loc);
            else
                System.out.println("The item to be deleted "
                                 + "is not in the list.");
        }
    } //end remove
}