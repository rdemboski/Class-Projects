package package_5;

import javax.swing.JOptionPane;

public class MethodPractice2
   {

      public static void main(String[] args)
         {
            //Write a method that takes a character input and prints out
            //the name of the corresponding playing card. 
            //If the card is not a face card simply print "not a face card"  
            //i.e. 'K' would print out "King", 'Q' would print "Queen"
            
            char cardName;
            String cardNameStr;
            
            cardNameStr = JOptionPane.showInputDialog("Enter Card Name/Value");
            cardName = cardNameStr.charAt(0);
            
            printCardName(cardName);
            

         }
      
      public static void printCardName(char cardName)
      {
    	  if(cardName == 'K')
    	  {
    		  System.out.print("King");
    	  }
    	  
    	  else if(cardName == 'Q')
    	  {
    		  System.out.print("Queen");
    	  }
    	  
    	  else if(cardName == 'J')
    	  {
    		  System.out.print("Jack");
    	  }
    	  
    	  else if(cardName == 'A')
    	  {
    		  System.out.print("Ace");
    	  }
    	  
    	  else
    	  {
    		  System.out.print("Not a face card");
    	  }
      }

   }