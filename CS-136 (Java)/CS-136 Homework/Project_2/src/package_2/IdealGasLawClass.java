package package_2;

import javax.swing.JOptionPane;

public class IdealGasLawClass
   {
    private static final char ENDLINE_CHAR = '\n';
    private static final char SPACE = ' ';
    private static final char DIVIDER = '|';
    private static final char EQUALS = '=';
    private static final char HYPHEN = '-';
     
      public static void main(String[] args)
         {
          // declare variables
          String chosenMols;
          String chosenTemp;
          String chosenVol;
          
          int blockSize;
          int numChars;
          int numPrecision;
          
          
          double molsDouble;
          double temperatureDouble;
          double volumeDouble;
          double endPressureDouble;
          
          final double numerator = 8.314;
          
          // get input from user
          chosenMols = JOptionPane.showInputDialog("Enter number of mols");
          chosenTemp = JOptionPane.showInputDialog("Enter temperature (K)");
          chosenVol = JOptionPane.showInputDialog("Enter volume (N/m^2)");
          
          // translate to double values
          molsDouble = Double.parseDouble(chosenMols);
          temperatureDouble = Double.parseDouble(chosenTemp);
          volumeDouble = Double.parseDouble(chosenVol);
          
          // calculate results
          endPressureDouble = (molsDouble * numerator * temperatureDouble) / volumeDouble;
          
          // Display top/title line
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 36;
          printChars(numChars,EQUALS);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          numChars = 1;
          printChars(numChars,DIVIDER);
          blockSize = 20;
          printCenterJustifiedString("Value Name", blockSize);
          numChars = 1;
          printChars(numChars,DIVIDER);
          blockSize = 15;
          printCenterJustifiedString("Value", blockSize);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          // display number of moles line
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 20;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 15;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          numChars = 1;
          printChars(numChars,DIVIDER);
          printChars(numChars,SPACE);
          blockSize = 19;
          printLeftJustifiedString("Number of mols", blockSize);
          numChars = 1;
          printChars(numChars,EQUALS);
          blockSize = 14;
          numPrecision = 2;
          printRightJustifiedDouble(molsDouble, numPrecision, blockSize);
          numChars = 1;
          printChars(numChars,SPACE);
          printChars(numChars,DIVIDER);
          printEndLine();
          
          // display temperature line
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 20;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 15;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          numChars = 1;
          printChars(numChars,DIVIDER);
          printChars(numChars,SPACE);
          blockSize = 19;
          printLeftJustifiedString("Temperature", blockSize);
          numChars = 1;
          printChars(numChars,EQUALS);
          blockSize = 14;
          numPrecision = 2;
          printRightJustifiedDouble(temperatureDouble, numPrecision, blockSize);
          numChars = 1;
          printChars(numChars,SPACE);
          printChars(numChars,DIVIDER);
          printEndLine();
          
          // display volume line
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 20;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 15;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          numChars = 1;
          printChars(numChars,DIVIDER);
          printChars(numChars,SPACE);
          blockSize = 19;
          printLeftJustifiedString("Volume", blockSize);
          numChars = 1;
          printChars(numChars,EQUALS);
          blockSize = 14;
          numPrecision = 2;
          printRightJustifiedDouble(volumeDouble, numPrecision, blockSize);
          numChars = 1;
          printChars(numChars,SPACE);
          printChars(numChars,DIVIDER);
          printEndLine();
          
          // display pressure line
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 20;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 15;
          printChars(numChars,HYPHEN);
          numChars = 1;
          printChars(numChars,DIVIDER);
          printEndLine();
          
          numChars = 1;
          printChars(numChars,DIVIDER);
          printChars(numChars,SPACE);
          blockSize = 19;
          printLeftJustifiedString("Pressure (Result)", blockSize);
          numChars = 1;
          printChars(numChars,EQUALS);
          blockSize = 14;
          numPrecision = 2;
          printRightJustifiedDouble(endPressureDouble, numPrecision, blockSize);
          numChars = 1;
          printChars(numChars,SPACE);
          printChars(numChars,DIVIDER);
          printEndLine();
          
          numChars = 1;
          printChars(numChars,DIVIDER);
          numChars = 36;
          printChars(numChars,EQUALS);
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