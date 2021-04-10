package package_6;

import javax.swing.JOptionPane;

public class InvestmentChoiceLab
{
    private static final int N_CONST = 1;
   
    public static void main(String[] args)
    {
      // TODO Auto-generated method stub
      
      String startingAmount;
      String rateOfReturn;
      String numOfYears, interestOnly, finalResultStr;
      
      double principle, rate, interest, finalResult;
      
      int time, precision = 2;
      
      
      startingAmount = JOptionPane.showInputDialog("Enter the Starting Amount");
      rateOfReturn = JOptionPane.showInputDialog("Enter the rate of return");
      numOfYears = JOptionPane.showInputDialog("Enter the number of years");
      
      principle = Double.parseDouble(startingAmount);
      rate = Double.parseDouble(rateOfReturn);
      time = Integer.parseInt(numOfYears);
      
      startingAmount = setPrecision(principle, precision);
      
      interest = computeInterestOnly(principle, rate, time, N_CONST);
      interestOnly = setPrecision(interest, precision);
      
      finalResult =  computeInterest(principle, rate, time, N_CONST);
      finalResultStr = setPrecision(finalResult, precision);
      
      printResult(startingAmount, interestOnly, finalResultStr);
    }
   
   private static void printResult( String startingValue, String outValueInterest, String outValue )
   {
      System.out.println("The starting balance was: " + "$" + startingValue);
      System.out.println("The amount of growth is: " + "$" + outValueInterest);
      System.out.println("The new balance is: " + "$" + outValue);
   }
   
   private static double computeInterest( double principle, double rate, int time, int numCompoundPerYear )
   {
      double base;
      double exponent;
      double total, parenth;
      
      rate = rate / 100;
      base = (1 + (rate / numCompoundPerYear));
      exponent = (numCompoundPerYear * time);
      parenth = Math.pow(base, exponent);
      total = principle * parenth;
      
      return (total);
   }
   
   private static double computeInterestOnly( double principle, double rate, int time, int numCompoundPerYear)
   {
      double base;
      double exponent;
      double end, parenth;
      
      rate = rate / 100;
      base = (1 + (rate / numCompoundPerYear));
      exponent = (numCompoundPerYear * time);
      parenth = Math.pow(base, exponent);
      end = principle * (parenth - 1);
      
      return (end);
      
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
