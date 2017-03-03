public class UnorderedArrayList<T> extends ArrayListClass<T>
{
    public UnorderedArrayList(int size)
    {
        super(size);
    }

    public UnorderedArrayList()
    {
        super();
    }

        //Method to determine whether searchItem is in the list.
        //Postcondition: If searchItem is found, returns the location
        //               in the array where the searchItem is found;
        //               otherwise, returns -1.
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

        //Method to insert insertItem at the end
        //of the list. However, first the list is searched to
        //see whether the item to be inserted is already in the list.
        //Postcondition: list[length] = insertItem and length++
        //           If insertItem is already in the list or the list
        //           is full, an appropriate message is output.
   	public void insert(T insertItem)
    {
        int loc;

        if (length == 0)          //list is empty
            list[length++] = insertItem;  //insert insertItem
                                          //and increment the length
        else
            if (length == maxSize)
                System.err.println("Cannot insert in a full list.");
            else
            {
                loc = seqSearch(insertItem);

                if (loc == -1)   //the item to be inserted
                                 //does not exist in the list
                    list[length++] = insertItem;
                else
                    System.err.println("The item to be inserted is already in "
                                     + "the list. No duplicates are allowed.");
            }
    } //end insert

        //Method to remove an item from the list.
        //The parameter removeItem specifies the item to
        //be removed.
        //Postcondition: If removeItem is found in the list, it is
        //               removed from the list and length is
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


    public void sort()
    {
		SearchSortAlgorithms<T> sortObject
		                = new SearchSortAlgorithms<T>();

        sortObject.quickSort(list, length);
	}
}