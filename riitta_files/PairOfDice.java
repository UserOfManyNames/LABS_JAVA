package labb6;

import java.util.Scanner;


public class PairOfDice {
	Die a; // = new Die();
	Die b;
  
	public PairOfDice(int sides) {
		this.a = new Die(sides);
		this.b = new Die(sides);
	}
	
	public int roll() {
		
		return a.roll() + b.roll();
	}
	 public int getFirst() {
	      return a.get();
	 }
	 public int getSecond() {
	      return b.get();
	 }
	 
	 public String toString() {
		 return "Pair " + a.toString() + ", " + b.toString();
	 }
	 
	  public boolean equals() {

		  return a.equals(b);
	  }
	 
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println(a.toString());
	     System.out.print("Number of sides: ");
	      int sides = sc.nextInt();
	      
	      PairOfDice n = new PairOfDice(sides);
          //n.roll();
          System.out.println("Alea iacta est: " + n.roll()); 
          System.out.println(n.toString());
          
          if(n.equals())
          {
        	  System.out.println("equal");
          }
          else {
        	  System.out.println("not equal");
          }
          
/*
	      Die a = new Die(sides);
	      //System.out.println(a.toString());	      
	      a.roll();
	      System.out.println(a.toString());	      
	      Die b = new Die(sides);
	      //System.out.println(b.toString());	      
	      b.roll();
	      System.out.println(b.toString());
*/
	      /*
	      System.out.println(d.toString());
	      int bd = d.roll();
	      System.out.println(d.toString());
	      Die a = new Die(ad);
	      Die b = new Die(bd);*/
	      // Ask about fixing equals function
	      
	      // if (a.equals(b)) {
	      //if (a == b) {  
	      
	      
	    /*  if (a.equals(b)) {  
	    	  System.out.println("Snake eyes!");
	      }
    	  else {
    		  System.out.println("You loose.");
    	  }*/
	 }
	
	
}