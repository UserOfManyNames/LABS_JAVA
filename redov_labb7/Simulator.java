//package labb7;

public class Simulator{

    public static void main(String[] args) throws InterruptedException{
        int steps = 20; //100;
        Simulation s = new Simulation(); /*//  Add parameters!*/
        for(int i = 0; i < steps; i++){
            System.out.print("\033[2J\033[;H");
            s.step(); 
            Store butik = s.getStore();
    		Register registers[] = butik.getRegisters();
    		System.out.println("\n\n");
    		for(int j = 0; j < registers.length; j++) {
    			if (registers[j].isOpen()) {
    				if (registers[j].hasCustomers()) {
    					Customer first = registers[j].getQueue().first();
    					int shoppings = first.getShoppings();
    					int queueLength = registers[j].getQueueLength();
    					String queueSymbols = "";
    					
    					while(queueLength-1 > 0) {
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
            
            
            
            System.out.println("\nNumber of customers served: " + s.getServedCustomers());
            System.out.println("Max wait-time: " + s.getMaxWaitTime());            
            System.out.println("Average wait-time: " + s.averageWaitTime() + "\n\n");            
            
            
            //s.clearResults();
       
            System.out.println(s);
            Thread.sleep(500);
        }
        System.out.println("");
        System.out.println("Simulation finished!");
    }
}