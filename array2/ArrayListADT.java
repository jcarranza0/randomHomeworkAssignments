public interface ArrayListADT<T> extends Cloneable
{
    public boolean isEmpty();
      //Method to determine whether the list is empty.
      //Postcondition: Returns true if the list is empty;
      //               otherwise, returns false.

    public boolean isFull();
      //Method to determine whether the list is full.
      //Postcondition: Returns true if the list is full;
      //               otherwise, returns false.

    public int listSize();
      //Method to return the number of elements in the list.
      //Postcondition: Returns the value of length.

    public int maxListSize();
      //Method to return the maximum size of the list.
      //Postcondition: Returns the maximum number of elements
      //               that can be inserted in the list.

    public void print();
      //Method to output the elements of the list.
      //Postcondition: Elements of the list are output on the
      //               standard output device.

    public Object clone();
      //Returns a copy of objects data in store.
      //This method clones only the references stored in
      //the array. The objects that the array references
      //point to are not cloned.

    public boolean isItemAtEqual(int location, T item);
      //Method to determine whether item is the same as the
      //item in the list at the position specified by location.
      //Postcondition: Returns true if the element in the list
      //               at the position specified by location is
      //               the same as item;
      //               otherwise, returns false.

    public void insertAt(int location, T insertItem);
      //Method to insert insertItem in the list at the position
      //specified by location.
      //Postcondition: Starting at location, the elements of
      //               the list are shifted to make room for
      //               insertItem; insertItem is inserted at
      //               the position specified by location and
      //               the length of the list is incremented
      //               by 1. If the list is full or location
      //               is out of range, an appropriate message
      //               is output.

    public void insertEnd(T insertItem);
      //Method to insert insertItem at the end of the list.
      //Postcondition: insertItem is inserted at the end of the
      //               list and the length of the list is
      //               incrmented by 1.
      //               If the list is full, an appropriate
      //               message is output.

    public void removeAt(int location);
      //Method to remove the item from the list at the
      //position specified by location.
      //Postcondition: The element at the position specified by
      //               location is removed from the list and
      //               the length of the list is decremented by 1.
      //               If location is out of range, an
      //               appropriate message is output.

    public T retrieveAt(int location);
      //Method to retrieve the element from the list at the
      //position specified by location.
      //Postcondition: A reference of the element at the
      //               position specified by location is
      //               returned. If location is out of range,
      //               an appropriate message is output and
      //               null is returned.

    public void replaceAt(int location, T repItem);
      //Method to replace the element in the list at
      //the position specified by location with repItem.
      //Postcondition: repItem is inserted in the list at the
      //               position specified by location.
      //               If location is out of range, an
      //               appropriate message is output.

    public void clearList();
      //Method to remove all the elements from the list.
      //Postcondition: The length of the list is 0.

    public int seqSearch(T searchItem);
      //Method to determine whether searchItem is in the list.
      //Postcondition: If searchItem is found, returns the
      //               location in the array where searchItem
      //               is found; otherwise, returns -1.

    public void remove(T removeItem);
      //Method to remove an item from the list.
      //The parameter removeItem specifies the item to
      //be removed.
      //Postcondition: If removeItem is found in the list, it
      //               is removed from the list and length is
      //               decremented by one.
}
