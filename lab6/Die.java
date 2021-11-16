package labb6;

import java.util.Scanner;

public class Die {
  private int numberOfSides;
  private int value;

  public Die() {
      this.numberOfSides = 6;
  }

  public Die(int numberOfSides) {

      if (numberOfSides < 1 || numberOfSides > 6)
      {
    	  throw new IllegalArgumentException("Illegal number of sides for die");
      }
      this.numberOfSides = numberOfSides;
  }

  public int roll() {
    this.value = (int) (Math.random() * numberOfSides) + 1;
    return this.get();
  }

  public int get() {
      return value;
  }
  
  public String toString() 
  {
	 return "Die(" + this.numberOfSides + ") is " + this.value;
  }
  
  public boolean equals(Die otherDie) {
	  return this.value == otherDie.value;
  }

  
    public static void main(String [] args) {
	     Scanner sc = new Scanner(System.in);
	     System.out.print("Number of sides: ");
	     int sides = sc.nextInt();
	     Die d = new Die(sides);
	     System.out.println("Alea iacta est: " + d.roll());
    }
}