package labb7;

import java.util.Random;
public class Simulation {
	private Random random;
    private Store store; // - varuhuset som simuleras
    private int time; // - antalet tidssteg sedan simuleringen startade
    private int intensity; // - sannolikheten (i procent) att det ska komma en ny kund vid varje tidssteg.
    private int maxGroceries; // - maxantalet varor som en kund kan ha när hen kommer till kassan.
    private int thresholdForNewRegister; // - vid vilken snittlängd en ny kassa öppnas.
    
    private int numberOfCustomersServed;
    private int sumOfWaitTimeForServedCustomers;
    private int maxWaitTime;
	
	public Simulation() {
    	this.random = new Random();
    	this.store = new Store();
		this.time = -1;
		this.intensity = 70;
		this.maxGroceries = 4;
		this.thresholdForNewRegister = 4;
		
	    this.numberOfCustomersServed = 0;
	    this.sumOfWaitTimeForServedCustomers = 0;
	    this.maxWaitTime = 0;
		
	}
	
	
	public void step() {
		this.time = this.time + 1;
		
		int newCustomerPossibility = this.random.nextInt(100);
		
		int min = 1;
		int max = this.maxGroceries;
		int groceriesNumber = this.random.nextInt(max-min) + min;
		
		if (newCustomerPossibility < this.intensity) {
			Customer c = new Customer(this.time, groceriesNumber);
			this.store.newCustomer(c);
		}
		
		int queueAverageLength = this.store.getAverageQueueLength();
		if (queueAverageLength > thresholdForNewRegister) {
			this.store.openNewRegister();
		}

				
		// + Hämta alla kunder som är klara och samla in statistik från dem.
		Customer customers[] = this.store.getDoneCustomers();
		int servedCustomers = customers.length;
		
		int calculator = 0;
		
		for(int i = 0; i < servedCustomers; i++) {
			if (customers[i] != null) {
				calculator = calculator + 1;
				this.numberOfCustomersServed = this.numberOfCustomersServed + 1;
			}
		}
	
		for(int j = 0; j < servedCustomers; j++) {
			if (customers[j] != null) {
				Customer c = customers[j];
				int waitTime = this.time - c.getBornTime();
				this.sumOfWaitTimeForServedCustomers = this.sumOfWaitTimeForServedCustomers + waitTime;				
			}			
		}

		
		for(int j = 0; j < servedCustomers; j++) {
			if (customers[j] != null) {
				Customer c = customers[j];
				int waitTime = this.time - c.getBornTime();
				if (waitTime > this.maxWaitTime) {
					this.maxWaitTime = waitTime;
				}								
			}					
		}
		
		Register registers[] = this.store.getRegisters();
		System.out.println("\n\n");
		for(int j = 0; j < registers.length; j++) {
			if (registers[j].isOpen()) {
				if (registers[j].hasCustomers()) {
					Customer first = registers[j].getQueue().first();
					int shoppings = first.getShoppings();
					int queueLength = registers[j].getQueueLength();
					String queueSymbols = "";
					
					while(queueLength-1 >= 0) {
						queueSymbols = "@" + queueSymbols;
						queueLength = queueLength - 1;
					}
					System.out.println("	["+shoppings+"]" + queueSymbols + "\n");
				}
				else {
					System.out.println("	[ ]\n");
				}
			}
			else {
				System.out.println(" X	[ ]\n");	
			}					
		}		
		
		
		//System.out.println("\nNumber of served customers at this time step is " + calculator);
	}
	
    public int getServedCustomers() {
	      return numberOfCustomersServed;
	}
	
    public int getMaxWaitTime() {
    	return maxWaitTime;
    }
    
	public int averageWaitTime() {
		if (this.numberOfCustomersServed == 0) {
			return 0;
		}
		int averageWaitTime = this.sumOfWaitTimeForServedCustomers / this.numberOfCustomersServed;
		return averageWaitTime;
	}
	
	
	/*
	public void clearResults() {
		this.sumOfWaitTimeForServedCustomers = 0;
		this.numberOfCustomersServed = 0;
	}
	*/
}
