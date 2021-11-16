package labb7;

public class Store {
	private Register registers[]; //- kassorna i varuhuset
    private int registerNumber; //antalet kassor 
    private int openRegisters;  //antalet öppna kassor 
	private int step;  // tiden i kassan	
	
	public Store() {
		this.registers[] = {};
		this.registerNumber = 0;
		this.openRegisters = 1;
		this.step = 0;
		
	}

	

    public int getAverageQueueLength() { //- vad är snittlängden för alla kassor i varuhuset?
    	
    	for(Register r : registers){    
    		//code to be executed    
    		}   
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
