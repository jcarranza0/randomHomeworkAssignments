/*
GroceryList class
responsible for keeping the list of the GroceryItemOrder
 */

public class GroceryList{

    private GroceryItemOrder [] orderList;
    private int noOfItems;

    /*
      Constructor
      Sets the noOfItems and create a list
     */
    public GroceryList(){
	noOfItems=0;
	orderList= new GroceryItemOrder[10];
    }

    /*
      Function: add
      Adds a new item to the list
      item: a new item to be added
    */
    public void add(GroceryItemOrder item){
    
	if(noOfItems < 10){
	    System.out.println("adding a new item");
	    orderList[noOfItems]=item;
	    noOfItems++;
	}
	    
    }

    /*
      Function getTotalCost
      Returns the summation of costs from all items 
      in the list
     */
    public double getTotalCost(){
    
	double sum=0;
	//loop over all items
	for(int i=0; i< noOfItems; i++){
	    sum+=orderList[i].getCost();
	}
	return sum;
    }

}