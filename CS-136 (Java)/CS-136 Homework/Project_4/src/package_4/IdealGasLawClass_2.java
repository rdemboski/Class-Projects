package package_4;

import javax.swing.JOptionPane;

public class IdealGasLawClass_2
   {
    private static final double CONSTANT_R = 8.314; // J / mol * K
    private static final int PRESSURE_RESULT = 1001;
    private static final int TEMPERATURE_RESULT = 2002;
    private static final int VOLUME_RESULT = 3003;
    private static final int FAILED_INPUT = 4004;
    
    
    public static void main( String[] args )
       {
        // declare variables, initialize as needed
        String userChoice;
        String tempStr;
        String pressureStr;
        String volumeStr; 
        String molsStr; 
          
        int chosenFlag;
        
        double mols = 0;
        double temp = 0;
        double volume = 0;
        double pressure = 0;
        double calculatedResult;
        
        // show title
           // function: System.out.println
        System.out.println( "Ideal Gas Law Program" );
        System.out.println( "=====================\n" );
        
        // prompt user for which item to find (pressure, temperature, volume)
           // function: JOptionPane.showInputDialog
        userChoice = JOptionPane.showInputDialog( "Enter name of value"
              + " to be found (e.g, Pressure, Temperature, Volume)" );
        
        // find result flag
           // function: findResultFlag
        chosenFlag = findResultFlag( userChoice );
        
        // get the appropriate inputs - ONLY ONE INPUT OPERATION FOR EACH ITEM
        
        if ( ! ( ( chosenFlag ) == PRESSURE_RESULT ) )
           {
            pressureStr = JOptionPane.showInputDialog( "Enter pressure"
                  + " (N/m^2)" );
            pressure = Double.parseDouble(pressureStr);
           }
        
        if ( !( ( chosenFlag ) == TEMPERATURE_RESULT ) )
           {
            tempStr = JOptionPane.showInputDialog( "Enter temperature (K)" );
            temp = Double.parseDouble(tempStr);
           }
        
        if ( !( ( chosenFlag ) == VOLUME_RESULT ) )
           {
            volumeStr = JOptionPane.showInputDialog( "Enter volume (m^3)" );
            volume = Double.parseDouble(volumeStr);
           }
        
        molsStr = JOptionPane.showInputDialog( "Enter number of mols" );
        
        mols = Double.parseDouble(molsStr);
        
        
        calculatedResult = findResult(chosenFlag, pressure, temp, volume, 
                                                                    mols);
        displayResult(chosenFlag, pressure, temp, volume, mols, 
                                                           calculatedResult);  
       }

    /**
     * Converts an upper case letter to lower case;
     * does not modify any other characters
     * 
     * @param testChar character value to be tested and converted to lower
     * case as appropriate
     * 
     * @return character set to lower case, 
     * only if it was an upper case letter to start with
     */
    private static char charToLowerCase( char testChar )
       {
        if( testChar >= 'A' && testChar <= 'Z' )
           {
            return (char)( testChar - 'A' + 'a' );
           }
        
        return testChar;
       }

    /**
     * Compares two strings with the following results: if the first string
     * is alphabetically greater than the second string, the method will 
     * return a number greater than zero (not necessarily 1); if the first 
     * string is alphabetically less than the second string, the method will 
     * return a number less than zero (not necessarily -1), and if the two
     * strings are alphabetically equal, the method returns the difference
     * in their lengths
     * <p>
     * Note: strings are converted to lower case before being compared 
     * @param one String value to be compared
     * <p>
     * Note: Uses String .length and .charAt methods
     *
     * @param other String value to be compared
     * 
     * @return integer value representing the comparison between 
     * the two strings as specified above
     */
    private static int compareStrings( String one, String other )
       {
        int lenOne = one.length();
        int lenOther = other.length();
        String oneStr = stringToLowerCase( one );
        String otherStr = stringToLowerCase( other );
        int diff, index = 0;
        
        while( index < lenOne && index < lenOther )
           {
            diff = oneStr.charAt( index ) - otherStr.charAt( index );
            
            if( diff != 0 )
               {
                return diff;
               }
            
            index++;
           }
        
        return lenOne - lenOther;
       }
    
    /**
     * Accepts all input and calculated data including the result flag,
     * and displays the appropriate result with input information
     * 
     * @param flag integer flag that indicates the result value to display, 
     * or that the input data was incorrect, as appropriate
     * 
     * @param press double value that holds the pressure if appropriate
     * @param temp double value that holds the temperature if appropriate
     * @param vol double value that holds the volume if appropriate
     * @param numMols double value that holds the number of mols if appropriate
     * @param result nothing is returned from this method
     */
    private static void displayResult( int flag, double press, 
                        double temp, double vol, double numMols, double result )
       {
        if (flag == PRESSURE_RESULT)
           {
            System.out.println( "For a system with " + numMols + " mols,\n" +
                                "and having a temperature of " + temp + '\n' +
                                "and having a volume of " + vol + '\n' +
                                "The pressure is: " + result + " N/m^2" );
           }
        else if (flag == TEMPERATURE_RESULT)
           {
            System.out.println( "For a system with " + numMols + " mols,\n" +
                                "and having a pressure of " + press + '\n' +
                                "and having a volume of " + vol + '\n' +
                                "The temperature is: " + result + " K" );
           }
        else if (flag == VOLUME_RESULT)
           {
            System.out.println( "For a system with " + numMols + " mols,\n" +
                                "and having a temperature of " + temp + '\n' +
                                "and having a pressure of " + press + '\n' +
                                "The volume is: " + result + " m^3" );
           }
        else if (flag == FAILED_INPUT)
           {
            System.out.println( "Incorrect result name entry - program"
                                    + " stopped" );  
           }
       }
    
    /**
     * Finds the result depending on the result flag (e.g., if the result
     * flag is set to PRESSURE_RESULT, this method will return the calculated
     * pressure, if the result flag is set to TEMPERATURE_RESULT, this method
     * will return the temperature, etc.)
     * <p>
     * Note: if the result flag is set to FAILED_INPUT,
     * the method will return zero
     * 
     * @param flag integer flag indicating which result is to be calculated,
     * or if zero is to be returned
     * 
     * @param press double value for input pressure if appropriate
     * 
     * @param temp double value for input temperature if appropriate
     * 
     * @param vol double value for input volume if appropriate
     * 
     * @param numMols double value for input number of mols if appropriate
     * 
     * @return calculated result or zero depending on the result flag
     */
    private static double findResult( int flag, double press, 
                                      double temp, double vol, double numMols )
       {
          
        if ( flag == PRESSURE_RESULT )
           {
            return ( numMols * CONSTANT_R * temp ) / vol;
           }
        else if ( flag == TEMPERATURE_RESULT )
           {
            return ( press * vol ) / ( numMols * CONSTANT_R );  
           }
        else if ( flag == VOLUME_RESULT )
           {
            return ( numMols * CONSTANT_R * temp ) / press;  
           }
        else
           {
            return 0.0;  
           }
        
       }
    
    /**
     * Tests the incoming string to see if it is "pressure", "temperature",
     * or "volume" and returns the appropriate constant flag 
     * (e.g., PRESSURE_RESULT, TEMPERATURE_RESULT, etc.), or returns
     * FAILED_INPUT if none of the strings are identified
     * 
     * @param inputStr String value containing input text
     * 
     * @return integer value with result flag set
     */
    private static int findResultFlag( String inputStr )
       {
          int sameString = 0;
          
          if ( compareStrings( "pressure", inputStr ) == sameString )
             {
              return PRESSURE_RESULT;
             }
          else if ( compareStrings( "temperature", inputStr ) == sameString )
             {
              return TEMPERATURE_RESULT;
             }
          else if ( compareStrings( "volume", inputStr ) == sameString) 
             {
              return VOLUME_RESULT;  
             }
          else
             {
              return FAILED_INPUT;
             }
          
       }
    
    /**
     * Converts an entire string to lower case letters; does not change
     * non-upper-case letter characters
     * 
     * @param str String value to be set to lower case
     * 
     * @return String value set to lower case
     */
    private static String stringToLowerCase( String str )
       {
        int index = 0;
        String newString = "";
        
        while( index < str.length() )
           {
            newString += charToLowerCase( str.charAt( index ) );
            
            index++;
           }
        
        return newString;
       }
    
   }