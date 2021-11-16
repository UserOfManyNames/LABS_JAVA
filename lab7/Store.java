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
		
		
		this.openRegisters = 1;
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
    
    public void newCustomer(Customer c) {//- ställ kunden c i den kortaste kön.
    
    }
    
    public int step() { //- tiden går ett steg i varuhuset. 
    	this.step = this.step + 1;
    	return this.step;
    }  
    
    public void openNewRegister() {//- öppna en ny kassa (om det går).
    	
    }
    
    public void getDoneCustomers(){ //- returnera alla kunder som är klara i det nuvarande tidssteget.
    	
    }
}
