//package labb7;


public class Store {
	private Register registers[]; //- kassorna i varuhuset

    private int openRegisters;  //antalet öppna kassor 
	//private int step;  // tiden i kassan	
	
	public Store() {
		this.registers = new Register[4];
		for(int i=0; i < this.registers.length; ++i)
		{
		  this.registers[i] = new Register();
		}
		
		
		this.openRegisters = 0;
		//this.step = 0;
		
	}

    public int getAverageQueueLength() { //- vad är snittlängden för alla kassor i varuhuset?
    	
		int sumOfQueueLenght = 0;
		int sizeOfRegistersArray = this.registers.length;
		int openRegisters = 0;
		
    	for(int i=0; i < sizeOfRegistersArray; ++i){    
    		
    		if (this.registers[i].isOpen()) {  		
    			
    			sumOfQueueLenght = sumOfQueueLenght + this.registers[i].getQueueLength();
    			openRegisters = openRegisters + 1;
    		}
    	}   
    	if (openRegisters == 0) {
    		return 0;
    	}
    	return sumOfQueueLenght/openRegisters;
    }
    
    
    public int findFirstOpenRegister(int start, int end) {
    	int firstOpenRegisterIndex = 0;
    	for(int i=0; i < end; ++i){    
    		
    		if (this.registers[i].isOpen()) {  		
    			firstOpenRegisterIndex = i;
    			return firstOpenRegisterIndex;
    		}
    	}
    	return -1;
    }
    
    public int findShortestQueueIndex(int start, int end) {
    	int firstResult = this.registers[start].getQueueLength();
    	int previousIndex = start;
    	int secondResult = 0;
    	int storedIndex = 0;
    	
    	for(int i = start + 1; i < end; ++i){    
    		
    		if (this.registers[i].isOpen()) {  		
    			secondResult = this.registers[i].getQueueLength();
    			if (firstResult <= secondResult) {
    				storedIndex = previousIndex;
    			}
    			else {
    				firstResult = secondResult;
    				previousIndex = i;
    				storedIndex = i;
    			} 				 			
    		}
    	}
    	return storedIndex;			
    }
    
    
    public int shortestQueueIndex() {
    	
		int sizeOfRegistersArray = this.registers.length;
		
		if (this.openRegisters == 0) { // at least one register should be open
			this.registers[0].open();
		}
		
		int firstOpenRegisterIndex = findFirstOpenRegister(0, sizeOfRegistersArray);		
		int result = findShortestQueueIndex(firstOpenRegisterIndex, sizeOfRegistersArray-1);
		
    	return result;	
    }
    
    
    public void newCustomer(Customer c) {//- ställ kunden c i den kortaste kön.
    	
    	int shortestQueueIndex = shortestQueueIndex();
    	
    	Register r = this.registers[shortestQueueIndex];
    	r.addToQueue(c);
    }
    
    public void step() { //- tiden går ett steg i varuhuset. 
		int sizeOfRegistersArray = this.registers.length;
		int i = 0;
    	while(i < sizeOfRegistersArray){    
    		if(this.registers[i].isOpen() == true) {
    			if (this.registers[i].hasCustomers()) {		
    				if (this.registers[i].currentCustomerIsDone()) {
    					this.registers[i].removeCurrentCustomer();
    				}
    				else {
    					this.registers[i].step();
    				}
    			} 

    		}   
    		++i;
    	}    	
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
    
   // public void getDoneCustomers(){ //- returnera alla kunder som är klara i det nuvarande tidssteget.
    public Customer[] getDoneCustomers(){ //- returnera alla kunder som är klara i det nuvarande tidssteget.	

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
    	return customers;
    }
    
    public Register[] getRegisters() {
    	return registers;
    }
}
