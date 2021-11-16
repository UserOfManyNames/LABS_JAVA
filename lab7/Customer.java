package labb7;

public class Customer {
	private int bornTime;
	private int groceries;	

	public Customer(int bornTime, int groceries) {
		this.bornTime = bornTime;
		this.groceries = groceries;
	}
	
	public int serve(/*int groceries*/) {
		this.groceries = (int) groceries - 1;
		return this.groceries;
	}
	
    public int getShoppings() {
	      return groceries;
	}
	
	public boolean isDone(/*int groceries*/) {
		int value = this.groceries;
		if (value == 0) {
			return true;
		}
		return false;
	}

}
