package package_5;

import javax.swing.JOptionPane;

public class MethodPractice3
   { 
          public static void main(String args[]) 
         { 
              double principle, rate, compoundInterest;
              int numCompoundPerYear, time, decimalPoints;
              String principleStr, rateStr, timeStr, numCompoundPerYearStr, compoundInterestStr;
              
              //Get user input
              //For testing use P = 5000, r = 4.25, years = 10 and compounds = 12
              //Result should be $7642.21
              principleStr = JOptionPane.showInputDialog("Enter principle investment amount");
              rateStr = JOptionPane.showInputDialog("Enter interest rate");
              timeStr = JOptionPane.showInputDialog("Enter time");
              numCompoundPerYearStr = JOptionPane.showInputDialog("Enter number of times"
              		+ " it is compounded per year");
              
              //Convert to correct data type
              principle = Double.parseDouble(principleStr);
              rate = Double.parseDouble(rateStr);
              time = Integer.parseInt(timeStr);
              numCompoundPerYear = Integer.parseInt(numCompoundPerYearStr);
              
        
              // Calculate compound interest 
              compoundInterest = calcCompoundInterest(principle, rate, time, 
            		  numCompoundPerYear);
              
              
              //Create output value with 2 decimal places as a string
              System.out.print(compoundInterest);
              
              
          } 
          
          
          // Create method to compute interest
          public static double calcCompoundInterest(double principle, double rate, int time, 
        		  int numCompoundPerYear)
          	{
        	  rate = rate / 100;
        	  double compoundInterest;
        	  int power = numCompoundPerYear * time;
        	  double base = principle * (1 + (rate/numCompoundPerYear));
        	  
        	  compoundInterest = Math.pow(base, power);
        	  
        	  return compoundInterest;
          	}
          
          
          public static String setPrecision( double outVal, int precision )
             {
              int tempPrecision = precision + 1;
              int wkgIntVal, outValInt = (int)outVal;
              double outValFraction = Math.abs( outVal - outValInt );
              String outValStr = "";
              
              while( tempPrecision > 1 )
                 {
                  outValFraction *= 10;
                  
                  wkgIntVal = (int)outValFraction;
                  
                  outValStr += wkgIntVal;
                  
                  outValFraction -= wkgIntVal;
                  
                  tempPrecision--;
                 }

              outValFraction *= 100;
              
              if( outValFraction > 45 )
                 {
                  wkgIntVal = Integer.parseInt( outValStr ) + 1;
                  
                  outValStr = Integer.toString( wkgIntVal );
                 }
              
              outValStr = Integer.toString( outValInt ) + "." + outValStr;
              
              return outValStr;
             }
       
   }