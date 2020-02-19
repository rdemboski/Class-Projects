package package_3;

import javax.swing.JOptionPane;

public class QuadraticSolverClass
   {
    private static final char ENDLINE_CHAR = '\n';
    private static final char SPACE = ' ';
    private static final char VERTICAL_LINE = '|';
    private static final char DOUBLE_HORIZONTAL_LINE = '=';
    private static final char SINGLE_HORIZONTAL_LINE = '-';
    private static final char EQUALS_SIGN = '=';

      public static void main(String[] args)
         {
          // declare variables
          String coeffA;
          String coeffB;
          String coeffC;
          
          int numChars;
          int precision = 2;
          int blkSize;
          
          double coeffADouble;
          double coeffBDouble;
          double coeffCDouble;
          
          double discriminant;
          double denominator;
          
          double rootOne;
          double rootTwo;
          double positiveDiscrim;
          double negativeDiscrim;
          
          // get input from user
          coeffA = JOptionPane.showInputDialog("Enter coefficient A");
          coeffB = JOptionPane.showInputDialog("Enter coefficient B");
          coeffC = JOptionPane.showInputDialog("Enter coefficient C");
          
            // get coefficient A from user, translate to double
          coeffADouble = Double.parseDouble(coeffA);
            // get coefficient B from user, translate to double
          coeffBDouble = Double.parseDouble(coeffB);  
            // get coefficient C from user, translate to double
          coeffCDouble = Double.parseDouble(coeffC);
          
            // find discriminant
          discriminant = calcDiscrim(coeffADouble, coeffBDouble, coeffCDouble);
            // find square root of discriminant
          positiveDiscrim = -coeffBDouble + Math.sqrt(discriminant);
          negativeDiscrim = -coeffBDouble - Math.sqrt(discriminant);
          
            // find denominator
          denominator = calcDenom(coeffADouble);

              // find root one
          rootOne = calcRoot(positiveDiscrim, denominator);  
              // find root two
          rootTwo = calcRoot(negativeDiscrim, denominator);  
          // display roots with user input

              // Display top/title line
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          numChars = 41;
          printChars(numChars, DOUBLE_HORIZONTAL_LINE);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
          printChars(numChars, VERTICAL_LINE);
          blkSize = 41;
          printCenterJustifiedString("Quadratic Root Solver Program", blkSize);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
              // display coefficient A line
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
          blkSize = 24;
          printLeftJustifiedString("Coefficient A", blkSize);
          printChars(numChars, EQUALS_SIGN);
          printChars(numChars, SPACE);
          blkSize = 13;
          printRightJustifiedDouble(coeffADouble, precision, blkSize);
          printChars(numChars, SPACE);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();  
          
              // display coefficient B line
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
          blkSize = 24;
          printLeftJustifiedString("Coefficient B", blkSize);
          printChars(numChars, EQUALS_SIGN);
          printChars(numChars, SPACE);
          blkSize = 13;
          printRightJustifiedDouble(coeffBDouble, precision, blkSize);
          printChars(numChars, SPACE);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
              // display coefficient C line
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
          blkSize = 24;
          printLeftJustifiedString("Coefficient C", blkSize);
          printChars(numChars, EQUALS_SIGN);
          printChars(numChars, SPACE);
          blkSize = 13;
          printRightJustifiedDouble(coeffCDouble, precision, blkSize);
          printChars(numChars, SPACE);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
              // display Root One line
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          numChars = 25;
          printChars(numChars, DOUBLE_HORIZONTAL_LINE);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          numChars = 15;
          printChars(numChars, DOUBLE_HORIZONTAL_LINE);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
          printChars(numChars, VERTICAL_LINE);
          printChars(numChars, SPACE);
          blkSize = 24;
          printLeftJustifiedString("Root One (result)", blkSize);
          printChars(numChars, EQUALS_SIGN);
          printChars(numChars, SPACE);
          blkSize = 13;
          printRightJustifiedDouble(rootOne, precision, blkSize);
          printChars(numChars, SPACE);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
          numChars = 1;
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
          
              // display Root Two line
          printChars(numChars, VERTICAL_LINE);
          printChars(numChars, SPACE);
          blkSize = 24;
          printLeftJustifiedString("Root Two (result)", blkSize);
          printChars(numChars, EQUALS_SIGN);
          printChars(numChars, SPACE);
          blkSize = 13;
          printRightJustifiedDouble(rootTwo, precision, blkSize);
          printChars(numChars, SPACE);
          printChars(numChars, VERTICAL_LINE);
          printEndLine();
          
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          numChars = 41;
          printChars(numChars, DOUBLE_HORIZONTAL_LINE);
          numChars = 1;
          printChars(numChars, VERTICAL_LINE);
          printEndLine();  
         }

      
    public static double calcDiscrim( double coeffA, double coeffB, 
                                                             double coeffC )
       {
        double discrim = ((coeffB * coeffB) - 4 * coeffA * coeffC);
        
        return discrim;
       }
      
      
    public static double calcDenom( double coeffA )
       {
        return (2 * coeffA);
       }
      
      
    public static double calcRoot( double numerator, double denominator )
       {
        return (numerator / denominator);
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