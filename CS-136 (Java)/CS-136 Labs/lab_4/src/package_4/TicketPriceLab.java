package package_4;

import javax.swing.JOptionPane;

public class TicketPriceLab
   {
      //create constants for all discounts, ages and prices
    final static double TICKET_PRICE = 40.00;
    final static double ELDER_DISCOUNT = 25.0;
    final static double WEEKDAY_DISCOUNT = 10.0;
    final static double CHILD_DISCOUNT = 100.0;
    final static double NO_DISCOUNT = 0.0;
    final static int ELDER_AGE = 64;
    final static int CHILD_AGE = 6;

      public static void main(String[] args)
         {
    	  int age;
    	  double discount, finalPrice;

          String ageInput = JOptionPane.showInputDialog("Enter age");
          String dayOfWeek = JOptionPane.showInputDialog("Enter day of the week");
          
          age = Integer.parseInt(ageInput);
            
          discount = getDiscount(age, dayOfWeek);
          
          finalPrice = getFinalPrice(discount, TICKET_PRICE);   
          
          //call printResult to print out results
          printResult(age, dayOfWeek, discount, finalPrice);  
                
         }
            
   
    public static double getDiscount( int age, String dayWeek )
       {
    	  double discount;
    	
    	  if(age < CHILD_AGE)
          {
    		  discount = CHILD_DISCOUNT;
          }
    	
    	  else if(age > ELDER_AGE)
    	  {
    		  discount = ELDER_DISCOUNT;
    	  }
    	
    	  else
    	  {
    		  discount = getDayDiscount(dayWeek);
    	  }
    	
    		
    	return discount;
        
       }
    
    public static double getFinalPrice( double discount, double ticketPrice )
       {
    	int discountMultiplier = 100;
    	return ticketPrice - ((discount / discountMultiplier) * ticketPrice);
       }
    
    public static double getDayDiscount( String day )
       {
    	  double discount;
    	  
    	  if (day.compareTo("Friday") != 0 && day.compareTo("Saturday") != 0 && 
    			  day.compareTo("Sunday") != 0)
    	  {
    		  discount = WEEKDAY_DISCOUNT;
    	  }
    	  
    	  else
    	  {
    		  discount = NO_DISCOUNT;
    	  }
          
          return discount;
          
       }
    
    public static void printResult( int age, String dayOfWeek, double discount, double finalPrice )
       {
    	  System.out.println("The customer's age is: " + age);
    	  System.out.println("The day of the week is: " + dayOfWeek);
    	  System.out.format("Their discount is: %.1f", discount);
    	  System.out.println("%");
    	  System.out.format("Their total price is: $%.2f", finalPrice);
    	
    	  //use System.out.format and %.2f to format double for two decimal places
   
       }
}