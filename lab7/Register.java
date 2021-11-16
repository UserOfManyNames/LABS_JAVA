package labb7;


public class Register {
	private boolean open; // true om kassan är öppen, annars false
	private Queue queue; // En kö av kunderna som väntar på att behandlas. Kunden som står 
	    // längst fram i kön är den som får sina varor behandlade.	
	private int step;  // tiden i kassan
	
	public Register() {
		this.open = false; 
		this.queue = null;   
		this.step = 0;
	}
	
	


    public void open() { //- öppna kassan.
    	this.open = true;
    }
    
    public void close() {//- stäng kassan.
    	this.open = false;
    }
    
    public boolean isOpen() {//- är kassan öppen?
    	
    	boolean isOpen = this.open;
    	if (isOpen == true) {
    		return true;
    	}
    	return false;	
    }
    
    public int step() { //- låt tiden gå ett steg i kassan. 
    	                // Det betyder att kunden som står först i kön får en vara registrerad.
    	this.step = this.step + 1;
    	return this.step;
    }                   
   
    
    public boolean hasCustomers() { // - har kassan några kunder?
    	Queue q = this.queue;
    	
    	int l = q.length();
    	if (l == 0) {
    		return false;
    	}
    	return true;
    }

    
    public boolean currentCustomerIsDone() {//- är kunden som står längst fram i kön klar?
    	
    	Queue q = this.queue; 
    	
    	Customer c = q.getFirst().element; // using get in Queue class to get first		
    	
    	
    	
    	int shoppings = c.getShoppings();      // using get in Customer class to get groceries
    	int steps = this.step;
    	if (shoppings == steps) {
    		this.step = 0;  // no more time needs to be used for this customer
    		return true;
    	}
    	return false;
    }
    
    
    public void addToQueue(Customer c) { //- ställ kunden c sist i kön.
    	
    	if (this.queue == null) {
    		Queue q = new Queue();
    		this.queue = q;
    		q.enqueue(c);
    	}
    	else {
        	Queue q = this.queue;
        	q.enqueue(c);	
    	}

    }
    
    
    
    public Customer removeCurrentCustomer() { //- ta bort (och returnera) kunden som står först i kön.
    	Queue q = this.queue;
    	Customer c = q.dequeue();
    	return c;
    }
    
    public int getQueueLength() { //- hur lång är kön?.
    	// get to length in Queue class
    	Queue q = this.queue;
    	
    	int l = q.length();
    	
    	return l; //queueLength;
    }

	

}
