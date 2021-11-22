////package labb7;

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
		this.time = 0;
		this.intensity = 70;
		this.maxGroceries = 8;
		this.thresholdForNewRegister = 4;
		
	    this.numberOfCustomersServed = 0;
	    this.sumOfWaitTimeForServedCustomers = 0;
	    this.maxWaitTime = 0;
		
	}
	
	
	public void step() {
		
		
		Register registers[] = this.store.getRegisters();
		

		
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
		
		//int calculator = 0;
		
		for(int i = 0; i < servedCustomers; i++) {
			if (customers[i] != null) {
				//calculator = calculator + 1;
				this.numberOfCustomersServed = this.numberOfCustomersServed + 1;
			}
		}
	
		for(int j = 0; j < servedCustomers; j++) {
			if (customers[j] != null) {
				Customer c = customers[j];
				//int storedShoppings = c.getStoredShoppings();
				int waitTime = this.time /*- storedShoppings */ - c.getBornTime();
				this.sumOfWaitTimeForServedCustomers = this.sumOfWaitTimeForServedCustomers + waitTime;				
			}			
		}

		
		for(int j = 0; j < servedCustomers; j++) {
			if (customers[j] != null) {
				Customer c = customers[j];
				//int storedShoppings = c.getStoredShoppings();
				int waitTime = this.time /*- storedShoppings */ - c.getBornTime();
				if (waitTime > this.maxWaitTime) {
					this.maxWaitTime = waitTime;
				}								
			}					
		}
		
		//System.out.println("\nNumber of served customers at this time step is " + calculator);
		for(int j = 0; j < registers.length; j++) {
			registers[j].step();
		}
		this.time = this.time + 1;
		
		
	}
	
    public int getServedCustomers() {
	      return numberOfCustomersServed;
	}
	
    public int getMaxWaitTime() {
    	return maxWaitTime;
    }
    
    // this method copied from https://www.baeldung.com/java-round-decimal-number
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    
	public double averageWaitTime() {
		if (this.numberOfCustomersServed == 0) {
			return 0;
		}
		double averageWaitTime = (this.sumOfWaitTimeForServedCustomers * 1.0) / (this.numberOfCustomersServed * 1.0 );

		double result = roundAvoid(averageWaitTime, 2);
		return result;
	}
	
	public int getTime() {
		return time;
	}
	
	public Store getStore() {
		return store;
	}

}