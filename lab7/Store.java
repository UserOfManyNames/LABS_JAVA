package labb7;


public class Store {
	private Register registers[]; //- kassorna i varuhuset

    private int openRegisters;  //antalet öppna kassor 
	private int step;  // tiden i kassan	
	
	public Store() {
		this.registers = new Register[3];
		for(int i=0; i < this.registers.length; ++i)
		{
		  this.registers[i] = new Register();
		}
		
		
		this.openRegisters = 0;
		this.step = 0;
		
	}

    public int getAverageQueueLength() { //- vad är snittlängden för alla kassor i varuhuset?
    	
		int sumOfQueueLenght = 0;
		int sizeOfRegistersArray = this.registers.length;
		
    	for(int i=0; i < sizeOfRegistersArray; ++i){    
    		  		
    		sumOfQueueLenght = sumOfQueueLenght + this.registers[i].getQueueLength();
    		
    		}   
    	return sumOfQueueLenght/sizeOfRegistersArray;
    }
    
    public int shortestQueueIndex() {
    	
		int shortestQueueIndex = 0;
		int sizeOfRegistersArray = this.registers.length;
		int storedData = 0;
		
    	for(int i=0; i < sizeOfRegistersArray-1; ++i){    
    		  		
    		int length1 = this.registers[i].getQueueLength();
    		int length2 = this.registers[i+1].getQueueLength();
    		
    		if (length1 < length2) {
    			shortestQueueIndex = length1;
    		}
    		else if (length1 == length2) {
    			shortestQueueIndex = length1;
    		}
    		else {
    			shortestQueueIndex = length2; // uppdatera shortestQueueIndex
    		} 
    		if (i == 0) {
    			storedData = shortestQueueIndex;
    		}
    		if (shortestQueueIndex > storedData) {
    			shortestQueueIndex = storedData;
    		}
    	}	
    	return shortestQueueIndex;	
    }
    
    
    public void newCustomer(Customer c) {//- ställ kunden c i den kortaste kön.
    	
    	int shortestQueueIndex = shortestQueueIndex();
    	
    	Register r = this.registers[shortestQueueIndex];
    	r.addToQueue(c);
    }
    
    public int step() { //- tiden går ett steg i varuhuset. 
    	this.step = this.step + 1;
    	return this.step;
    }  
    
    public void openNewRegister() {//- öppna en ny kassa (om det går).
   
		int sizeOfRegistersArray = this.registers.length;
		
		boolean stayInLoop = true;
		int i = 0;
    	while(stayInLoop && i < sizeOfRegistersArray){    
    		  		
    		if(this.registers[i].isOpen() == false) {
    			this.registers[i].open();
    			this.openRegisters = this.openRegisters + 1;
    			stayInLoop = false;
    		}   
    		++i;
    	}
    }
    
    public void getDoneCustomers(){ //- returnera alla kunder som är klara i det nuvarande tidssteget.
    	

		int sizeOfRegistersArray = this.registers.length;
    	Customer customers[] = new Customer[sizeOfRegistersArray];
    	
    	for(int i=0; i < sizeOfRegistersArray; ++i){    
    		  		
    		if (this.registers[i].hasCustomers()) {
    		
    			if (this.registers[i].currentCustomerIsDone()) {
    				customers[i] = this.registers[i].removeCurrentCustomer();
    			}
    			else {
    				customers[i] = null;
    			}
    		} 
    		else {
    			customers[i] = null;
    		}
    	}
    }
}
