package package_7;

import javax.swing.JOptionPane;

public class InvestmentChoiceLab2
   {
      
      private static final char ENDLINE_CHAR = '\n';
      private static final char SPACE = ' ';
      private static final char VERTICAL_LINE = '|';
      private static final char DOUBLE_HORIZONTAL_LINE = '=';
      private static final char SINGLE_HORIZONTAL_LINE = '-';
      private static final char EQUALS_SIGN = '=';
      private static final int SINGLE_LINE = 1001;
      private static final int DOUBLE_LINE = 2002;
      
      private static final int VERTICAL_LINE_COUNT = 1;
      private static final int EQUALS_SIGN_COUNT = 1;
      private static final int SINGLE_SPACE_COUNT = 1;
      private static final int NUM_COMPOUNDS_PER_YEAR = 1;
      
      private static final int FULL_LINE_BLOCK_SIZE = 41;
      private static final int LEFT_SIDE_BLOCK_SIZE = 24;
      private static final int RIGHT_SIDE_BLOCK_SIZE = 14;
      private static final int STANDARD_PRECISION = 2;
    
      
      public static void main(String args[]) 
      { 
    	  
    	double startingAmount;
  		double rateOfReturn;
  		double numOfYears;
  		
  		double interestOnly, finalResult;
  		

  		startingAmount = getStartingValues("Starting Amount");
  		rateOfReturn = getStartingValues("rate of return");
  		numOfYears = getStartingValues("nnumber of years");
  		

  		finalResult = computeInterest(startingAmount,rateOfReturn, numOfYears, NUM_COMPOUNDS_PER_YEAR);
  		interestOnly = computeInterestOnly(startingAmount,rateOfReturn, numOfYears, NUM_COMPOUNDS_PER_YEAR);
		

		printResult(startingAmount, interestOnly, finalResult);
		       
       } 
       
      
       //Method returns the double value corresponding to the string parameter passed in
       private static double getStartingValues(String valueStr)
          {
    	    String resultStr;
    	    double result;
    	    resultStr = JOptionPane.showInputDialog("Enter the " + valueStr);
    	    
     		result = Double.parseDouble(resultStr);
     		return result;
          }
       
       
       //Method prints out the the results in table form using the supplied methods
       private static void printResult( double startingBalance, double growth, 
             double newBalance )
          {
    	   printDividerLine(DOUBLE_LINE);
    	   printTableTitle();
    	   printDividerLine(SINGLE_LINE);
    	   
    	   printDataDisplayLine("Starting Balance:", startingBalance );
    	   printDividerLine(SINGLE_LINE);
    	   printDataDisplayLine("Amount of growth:", growth );
    	   printDividerLine(SINGLE_LINE);
    	   printDataDisplayLine("New Balance:", newBalance );
    	   printDividerLine(DOUBLE_LINE);
    	   	 
          }
       
       
       //Method computes interest and returns original balance plus interest
       private static double computeInterest( double principle, double rate, 
             double time, int numCompoundPerYear )
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
       
       
       //Method computes interest and returns interest only
       private static double computeInterestOnly( double principle, double rate, 
             double time, int numCompoundPerYear )
          {
    	   double base;
   		   double exponent;
   		   double total, parenth;
   		
   		   rate = rate / 100;
   		   base = (1 + (rate / numCompoundPerYear));
   		   exponent = (numCompoundPerYear * time);
   		   parenth = Math.pow(base, exponent);
   		   total = principle * (parenth - 1);
   		
   		   return (total);    
          }
       
       
       
       // Supporting Methods - DO NOT MAKE ANY CHANGES TO THESE METHODS ///////////////

       /**
        * Prints double value center justified
        * 
        * @param outVal double value to be printed
        * 
        * @param precision integer value specifying number of digits
        * to the right of the decimal point
        * 
        * @param blockSize integer size of text block within which
        * to place double value
        */
       public static void printCenterJustifiedDouble( double outVal, 
                                                     int precision, int blockSize )
          {
           String outStr = setPrecision( outVal, precision );

           printCenterJustifiedString( outStr, blockSize );
          }

       /**
        * Prints String value center justified
        * 
        * @param outString String value to be printed
        * 
        * @param blockSize integer size of text block within which
        * to place String value
        */
       public static void printCenterJustifiedString( String outString, 
                                                                    int blockSize )
          {
           int preSpaces = blockSize / 2 - outString.length() / 2;
           int postSpaces = blockSize - preSpaces - outString.length();
           
           printChars( preSpaces, SPACE );
           System.out.print( outString );
           printChars( postSpaces, SPACE );
          }
       
       /**
        * Prints a specified number of characters
        * 
        * @param numChars integer number of characters to be printed
        * 
        * @param outChar character value to be printed
        */
       public static void printChars( int numChars, char outChar )
          {
           if( numChars > 0 )
              {
               printChars( numChars - 1, outChar );
                   
               System.out.print( outChar );
              }
          }     

       /**
        * Prints data line with double result
        */
       public static void printDataDisplayLine( String prompt, double value )
          {
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
           printChars( SINGLE_SPACE_COUNT, SPACE );
           printLeftJustifiedString( prompt, LEFT_SIDE_BLOCK_SIZE );
           printChars( EQUALS_SIGN_COUNT, EQUALS_SIGN );
           printRightJustifiedDouble( value, 
                                      STANDARD_PRECISION, RIGHT_SIDE_BLOCK_SIZE );
           printChars( SINGLE_SPACE_COUNT, SPACE );
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
           printEndLine();          
          }

       /**
        * Prints internal table divider line with single or double line
        * depending on line type control integer; line has vertical lines
        * on each end and a vertical line character divider
        * 
        * @param lineType integer flag indicating whether to use
        * single or double divider lines
        */
       public static void printDividerLine( int lineType )
          {
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );

           if( lineType == SINGLE_LINE )
              {
               printChars( FULL_LINE_BLOCK_SIZE, SINGLE_HORIZONTAL_LINE );
              }
           
           else
              {
               printChars( FULL_LINE_BLOCK_SIZE, DOUBLE_HORIZONTAL_LINE );
              }
           
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );

           printEndLine();
          }

       /**
        * Ends text line on output screen
        */
       public static void printEndLine()
          {
           System.out.print( ENDLINE_CHAR );
          }
             
       /**
        * Prints double value justified to the left
        * 
        * @param outVal double value to be printed
        * 
        * @param precision integer value specifying number of digits
        * to the right of the decimal point
        * 
        * @param blockSize integer size of text block within which
        * to place double value
        */
       public static void printLeftJustifiedDouble( double outVal, 
                                                     int precision, int blockSize )
          {
           String outStr = setPrecision( outVal, precision );

           printLeftJustifiedString( outStr, blockSize );
          }

       /**
        * Prints String value justified to the left
        * 
        * @param outString String value to be printed
        * 
        * @param blockSize integer size of text block within which
        * to place String value
        */
       public static void printLeftJustifiedString( String outString, 
                                                                    int blockSize )
          {
           int postSpaces = blockSize - outString.length();
           
           System.out.print( outString );
           printChars( postSpaces, SPACE );
          }

       /**
        * Prints double value justified to the right
        * 
        * @param outVal double value to be printed
        * 
        * @param precision integer value specifying number of digits
        * to the right of the decimal point
        * 
        * @param blockSize integer size of text block within which
        * to place double value
        */
       public static void printRightJustifiedDouble( double outVal, 
                                                     int precision, int blockSize )
          {
           String outStr = setPrecision( outVal, precision );
           
           printRightJustifiedString( outStr, blockSize );
          }
        
       /**
        * Prints String value justified to the right
        * 
        * @param outString String value to be printed
        * 
        * @param blockSize integer size of text block within which
        * to place String value
        */
       public static void printRightJustifiedString( String outString, 
                                                                    int blockSize )
          {
           int preSpaces = blockSize - outString.length() - 1;
           
           printChars( preSpaces, SPACE );
           System.out.print( "$" + outString );
          }

       /**
        * Prints a solid double line, using equals sign characters
        */
       public static void printSolidDoubleLine()
          {
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
           printChars( FULL_LINE_BLOCK_SIZE, DOUBLE_HORIZONTAL_LINE );
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
           printEndLine();
          }
       
       /**
        * Prints data line with double result
        */
       public static void printStringDisplayLine( String prompt, String rightSide )
          {
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
           printChars( SINGLE_SPACE_COUNT, SPACE );
           printLeftJustifiedString( prompt, LEFT_SIDE_BLOCK_SIZE );
           printChars( EQUALS_SIGN_COUNT, EQUALS_SIGN );
           printRightJustifiedString( rightSide, RIGHT_SIDE_BLOCK_SIZE );
           printChars( SINGLE_SPACE_COUNT, SPACE );
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
           printEndLine();          
          }

       /**
        * Prints formatted table title
        */
       public static void printTableTitle()
          {
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
           printCenterJustifiedString( 
                           "Investment Growth Chart", FULL_LINE_BLOCK_SIZE );
           printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
           printEndLine();        
          }
       
       /**
        * Accepts double value and precision (i.e., number of digits to the right
        * of the decimal point); returns String representation of value
        * with specified precision
        * 
        * @param outVal double value to be processed
        * 
        * @param precision integer value specifying precision
        * as specified in description
        * 
        * @return String value holding input value with specified precision
        */
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