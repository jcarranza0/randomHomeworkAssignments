/*
GroceryItemOrder class:
Responsible for storing information about each groceryitem
This is a tentative class without the complete code 
*/

public class GroceryItemOrder{

    private String name;             //item name
    private int quantity;            //number of units
    private double pricePerUnit;

    /*Constructor
    name: item name
    quantity: item quantity
    pricerPerUnit: the price per unit
    */
    public GroceryItemOrder(String name, int quantity, double pricePerUnit){
	this.name=name;
	this.quantity=quantity;
	this.pricePerUnit=pricePerUnit;
	System.out.println(this.name+" "+this.quantity+" "+this.pricePerUnit);
    }

    /*Function:getCost
      Returns the total cost of the item
     */
    public double getCost(){
    
	return quantity*pricePerUnit;
    }

    /*
      Function:setQuantity
      quantity: the new quantity of the item
     */
    public void setQuantity(int quantity){
    
	this.quantity=quantity;
    }

}