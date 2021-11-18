package labb7;

public class Simulator{

    public static void main(String[] args) throws InterruptedException{
        int steps = 5; //100;
        Simulation s = new Simulation(); // TODO: Add parameters!
        for(int i = 0; i < steps; i++){
            System.out.print("\033[2J\033[;H");
            s.step();
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
