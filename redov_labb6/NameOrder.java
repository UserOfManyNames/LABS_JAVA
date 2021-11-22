//package lab17;

import java.util.Scanner;

public class NameOrder {

   public static void main(String args[])
    {
	   Scanner sc = new Scanner(System.in);
	      System.out.print("First name: ");
	      String myStr1 = sc.nextLine();
	      while (myStr1.length() == 0) 
	      {
	    	  System.out.print("Please give a name: ");
	    	  myStr1 = sc.nextLine();
	      }
	      
	      System.out.print("second name: ");
	      String myStr2 = sc.nextLine();
	      while (myStr2.length() == 0) 
	      {
	    	  System.out.print("Please give a name: ");
	    	  myStr2 = sc.nextLine();
	      }
  
        char[] ch1 = new char[myStr1.length()];
        char[] ch2 = new char[myStr2.length()];
        int strLength = 0;
        int i = 0;
        if (myStr2.length() <= myStr1.length()) {
        	strLength = myStr2.length();
        }
        if (myStr2.length() > myStr1.length()) {
        	strLength = myStr1.length();
        }
        
		while (i < strLength) 
        {
        	ch1[i] = myStr1.charAt(i);
            ch2[i] = myStr2.charAt(i);
            char char1 = ch1[i];
            String str1 = Character.toString(char1);
            char char2 = ch2[i];
            String str2 = Character.toString(char2);
            int answer = str1.compareTo(str2);
            if (answer != 0)
            {
            	int ascii1 = (int) char1;
            	int ascii2 = (int) char2;
            	if (ascii1<ascii2)
            	{
            		System.out.print(myStr1 + "\n");
            		System.out.print(myStr2 + "\n");
            	}
            	else
            	{
            		System.out.print(myStr2 + "\n");
            		System.out.print(myStr1 + "\n");
            	}
            	break;
            }
            i++;

        }
    }
}


