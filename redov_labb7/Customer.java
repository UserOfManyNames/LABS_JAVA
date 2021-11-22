//package labb7;

public class Customer {
	private int bornTime;
	private int groceries;
	//private int storedGroceries;

	public Customer(int bornTime, int groceries) {
		this.bornTime = bornTime;
		this.groceries = groceries;
		//this.storedGroceries = groceries;
	}
	
	public int serve(/*int groceries*/) {
		this.groceries = this.groceries - 1;
		return this.groceries;
	}
	
    public int getShoppings() {
	      return groceries;
	}
	
    public int getBornTime() {
    	return bornTime;
    }
/*
	public int getStoredShoppings(){
		return storedGroceries;
	}
 */   
	public boolean isDone() {
		int value = this.groceries;
		if (value == 0) {
			return true;
		}
		return false;
	}
	/*
	public void reduceGroceries() {
		this.groceries = this.groceries - 1;
	}
    */
}