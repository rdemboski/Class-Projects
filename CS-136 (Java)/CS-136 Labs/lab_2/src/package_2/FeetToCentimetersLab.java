package package_2;

import javax.swing.JOptionPane;

public class FeetToCentimetersLab
   {
    private static final char ENDLINE_CHAR = '\n';
    private static final char SPACE = ' ';
    private static final char DIVIDER = '|';
    private static final char EQUALS = '=';
    private static final char HYPHEN = '-';
    
    
      public static void main(String[] args)
         {
          // declare variables
    	  String height;
        String inches;
        double centimeters;
    	  int blockSize;
    	  int numChars;
    	  int precision;
    	  
          // get input from user
    	  height = JOptionPane.showInputDialog("Enter height in feet");
    	  inches = JOptionPane.showInputDialog("Enter height in inches");
                      
          // translate to integer values
    	  double Height = Double.parseDouble(height);
          double Inches = Double.parseDouble(inches);
          // calculate results
          centimeters = ( Height * 30.48) + ( Inches * 2.54);

          // display results
          
          //First Row
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 23;
          printChars(numChars,EQUALS);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 10;
          printChars(numChars,EQUALS);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 12;
          printChars(numChars,EQUALS);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          //Second Row
          numChars = 1;
          printChars(numChars,DIVIDER);
          blockSize = 23;
          printCenterJustifiedString("Input  Name", blockSize);
          numChars = 1;
          printChars(numChars,DIVIDER);
          blockSize = 10;
          printCenterJustifiedString("Feet", blockSize);
          numChars = 1;
          printChars(numChars,DIVIDER);
          blockSize = 12;
          printCenterJustifiedString("Inches", blockSize);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          //Third Row
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 22;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,SPACE);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 10;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 12;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          //Fourth Row
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 1;
          printChars(numChars,SPACE);
          blockSize = 22;
          printLeftJustifiedString("Height", blockSize);
          numChars = 1;
          printChars(numChars,DIVIDER);
          blockSize = 9;
          precision = 1;
          setPrecision(Height, 1);
          printRightJustifiedDouble(Height, precision, blockSize);
          numChars = 1;
          printChars(numChars,SPACE);
          numChars = 1;
          printChars(numChars,DIVIDER);
          blockSize = 11;
          precision = 1;
          setPrecision(Inches, 1);
          printRightJustifiedDouble(Inches, precision, blockSize);
          numChars = 1;
          printChars(numChars,SPACE);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          //Fifth Row
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 22;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,SPACE);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 10;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 12;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          //Sixth Row
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 1;
          printChars(numChars,SPACE);
          blockSize = 22;
          printLeftJustifiedString("Height in Centimeters", blockSize);
          numChars = 1;
          printChars(numChars,DIVIDER);
          blockSize = 9;
          precision = 2;
          setPrecision(Height, precision);
          printRightJustifiedDouble(centimeters, precision, blockSize);
          numChars = 1;
          printChars(numChars,SPACE);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          //Seventh Row
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 22;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,SPACE);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 10;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
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