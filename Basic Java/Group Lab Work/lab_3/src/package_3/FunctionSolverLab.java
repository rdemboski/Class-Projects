package package_3;

import javax.swing.JOptionPane;

public class FunctionSolverLab
   {
    private static final char ENDLINE_CHAR = '\n';
    private static final char SPACE = ' ';
    private static final char VERTICAL_LINE = '|';
    private static final char SINGLE_HORIZONTAL_LINE = '-';
    private static final char EQUALS_SIGN = '=';

      public static void main(String[] args)
         {
          // declare variables
          int numChars;
          int precision = 2;
          int blockSize;
          String answerInput;
          double x_value;
          double denominator;
          double numerator;
          double finalResult;
          
          //get input from user
          answerInput = JOptionPane.showInputDialog("Enter X");
          
          //get coefficient X value from user, translate to double    
          x_value = Double.parseDouble(answerInput);
          
          //find numerator
          numerator = calcNumerator(x_value);
          
          //find denominator
          denominator = calcDenom(x_value);
          
          //find final result
          finalResult = calcResult(numerator, denominator);
          
          //Display top/title line
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          numChars = 41;
          printChars(numChars, EQUALS_SIGN);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
          printChars(numChars, VERTICAL_LINE);
          blockSize = 41;
          printCenterJustifiedString("Function Solver Program", blockSize);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
          //display X value line
          printChars(numChars, VERTICAL_LINE);
          numChars = 25;
          printChars(numChars, SINGLE_HORIZONTAL_LINE);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          numChars = 15;
          printChars(numChars, SINGLE_HORIZONTAL_LINE);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
         
          printChars(numChars, VERTICAL_LINE);
          printChars(numChars, SPACE);
          blockSize = 24;
          printLeftJustifiedString("X Value", blockSize);
          printChars(numChars, EQUALS_SIGN);
          printChars(numChars, SPACE);
          blockSize = 13;
          printRightJustifiedDouble(x_value, precision, blockSize);
          printChars(numChars, SPACE);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
          //display Result line
          printChars(numChars, VERTICAL_LINE);
          numChars = 25;
          printChars(numChars, EQUALS_SIGN);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          numChars = 15;
          printChars(numChars, EQUALS_SIGN);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          printEndLine(); 
          
          printChars(numChars, VERTICAL_LINE);
          printChars(numChars, SPACE);
          blockSize = 24;
          printLeftJustifiedString("Function (result)", blockSize);
          printChars(numChars, EQUALS_SIGN);
          printChars(numChars, SPACE);
          blockSize = 13;
          printRightJustifiedDouble(finalResult, precision, blockSize);
          printChars(numChars, SPACE);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
          //display Bottom border
          printChars(numChars, VERTICAL_LINE);
          numChars = 25;
          printChars(numChars, EQUALS_SIGN);
          numChars = 1;
          printChars(numChars, EQUALS_SIGN);
          numChars = 15;
          printChars(numChars, EQUALS_SIGN);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          printEndLine(); 
          
         }
            
    //Use these methods to solve for numerator, denominator 
    //and final result
    public static double calcNumerator( double x)
       {
        //Code to calculate numerator
        double XCubed = x * x * x;
        double XSquared = x * x;
        
        return ((XCubed - 2 * XSquared) + x - 6.3); //you will need to change this to return the result
       }
    
    
    public static double calcDenom( double x )
       {
        //Code to calculate denominator
        double XSquared = x * x;
         
        return ((XSquared) + (0.05005 * x) - 3.14); //you will need to change this to return the result
       }
    
    
    public static double calcResult( double numerator, double denominator)
       {
        //Code to calculate result 
        return (numerator / denominator); //you will need to change this to return the result
       }
    
    
    // Supporting Methods - DO NOT MAKE ANY CHANGES TO THESE METHODS ///////////////

    public static void printEndLine()
       {
        System.out.print( ENDLINE_CHAR );
       }
          
    public static void printChars( int numChars, char outChar )
       {
        if( numChars > 0 )
           {
            printChars( numChars - 1, outChar );
                
            System.out.print( outChar );
           }
       }     
      
    public static void printCenterJustifiedString( String outString, 
                                                                 int blockSize )
       {
        int preSpaces = blockSize / 2 - outString.length() / 2;
        int postSpaces = blockSize - preSpaces - outString.length();
        
        printChars( preSpaces, SPACE );
        System.out.print( outString );
        printChars( postSpaces, SPACE );
       }
    
    public static void printLeftJustifiedString( String outString, 
                                                                 int blockSize )
       {
        int postSpaces = blockSize - outString.length();
        
        System.out.print( outString );
        printChars( postSpaces, SPACE );
       }

    public static void printRightJustifiedString( String outString, 
                                                                 int blockSize )
       {
        int preSpaces = blockSize - outString.length();
        
        printChars( preSpaces, SPACE );
        System.out.print( outString );
       }

    public static void printCenterJustifiedDouble( double outVal, 
                                                  int precision, int blockSize )
       {
        String outStr = setPrecision( outVal, precision );

        printCenterJustifiedString( outStr, blockSize );
       }

    public static void printLeftJustifiedDouble( double outVal, 
                                                  int precision, int blockSize )
       {
        String outStr = setPrecision( outVal, precision );

        printLeftJustifiedString( outStr, blockSize );
       }

    public static void printRightJustifiedDouble( double outVal, 
                                                  int precision, int blockSize )
       {
        String outStr = setPrecision( outVal, precision );
        
        printRightJustifiedString( outStr, blockSize );
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