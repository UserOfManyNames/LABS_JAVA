package labb7;

import java.util.Random;
public class Simulation {
	private Random random;
    private Store store; // - varuhuset som simuleras
    private int time; // - antalet tidssteg sedan simuleringen startade
    private int intensity; // - sannolikheten (i procent) att det ska komma en ny kund vid varje tidssteg.
    private int maxGroceries; // - maxantalet varor som en kund kan ha när hen kommer till kassan.
    private int thresholdForNewRegister; // - vid vilken snittlängd en ny kassa öppnas.

	
	public Simulation() {
    	this.random = new Random();
    	this.store = new Store();
		this.time = -1;
		this.intensity = 95;
		this.maxGroceries = 4;
		this.thresholdForNewRegister = 5;
		
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
				
			}
		}
		System.out.println("Number of served customers at this time step is " + calculator +"\n");
	}
	
	
	
	
}
