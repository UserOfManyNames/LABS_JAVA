package labb7;


public class Queue {

	private Node first; // Noden som håller det första elementet
	private Node last;  // Noden som håller det sista elementet
	private int length; // Antalet kunder i kön just nu
	
	public Queue() {
		this.first = null; // null?
		this.last = null;    // null?
		this.length = 0; 
	}
	
	class Node {
		Customer element; // Kunden som står på just den platsen i kön
		Node next;	      // Noden för platsen bakom den nuvarande.
		//Node iter;
		
		Node() {
			this.element = null;
			this.next = null;
			//this.iter = iter;
		}
	}

	
    public Node getFirst() {
    	return first;
	}
    
    public int getLength() {
    	return length;
    }
    

	
	
	public void enqueue(Customer c){  // Ställ en kund sist i kön
		Node n = new Node();
		if (this.length != 0) {
			Node p = this.last;
			p.next = n;
		}			
		n.element =  c;
		n.next = null;
		this.last = n;
		if (this.length == 0) {
			this.first = n;
		}
		this.length = this.length + 1;
	}

	public int length() {     // Hur lång är kön?
		int l = this.length;
		return l;
	}
	
	
	public Customer first(){  // Returnera (men ta inte bort) kunden som står först i kön.
		Node n = this.first;
		Customer c = n.element;
		return c;		
	}	

	
	public Customer dequeue(){  // Ta bort (och returnera) kunden som står först i kön.	
		Customer c = first();
		this.first = this.first.next;
		this.length = this.length - 1;
		return c;
	}	


}
