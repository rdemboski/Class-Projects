package p6_package;

public class QuadCalc_Class_II_S4
   {
    // initialize table characters
    public static final char DASH = '-';
    public static final char DOUBLE_DASH = '=';
    public static final char PIPE = '|';
    public static final char CROSS = '+';
    
    // initialize line controls
    public static final int SOLID = 1001;
    public static final int BROKEN = 2002; 

    // initialize table string components
    public static final String PIPE_SPACE = "| ";
    public static final String SPACE_PIPE = " |";
    public static final String CROSS_SPACE = "+ ";
    
    // initialize table widths
    public static final int PRECISION = 2;
    public static final int TABLE_WIDTH = 44;
    public static final int NAME_BLOCK_WIDTH = 29;
    public static final int VALUE_BLOCK_WIDTH = 12;

    // initialize two endlines constant
    public static final int TWO_ENDLINES = 2;
    
    public static void main(String[] args)
      {
       // initialize program/variables
      
          // initialize variables
          int coef_A, coef_B, coef_C, denominator, discriminant;
          double rootOne = 0.0, rootTwo = 0.0, discSqrRoot;
          boolean complexRootsFlag = false;
          boolean oneRootFlag = false;
          
          // show title
             // method: printTitle
          printTitle( "Quadratic Root Finding Program" );
          
       // get input from user
      
          // get coefficient A
             // method: promptForCoef
          coef_A = promptForCoef( "Enter coefficient A: " );
          
          // get coefficient B
             // method: promptForCoef
          coef_B = promptForCoef( "Enter coefficient B: " );
 
          // get coefficient C
             // method: promptForCoef
          coef_C = promptForCoef( "Enter coefficient C: " );
      
       // Find roots, if available
      
          // find denominator
             // method: calcDenom
          denominator = calcDenom( coef_A );
          
          // find discriminant
             // method: calcDiscrim
          discriminant = calcDiscrim( coef_A, coef_B, coef_C );
          
          // check for no roots
          if( discriminant < 0 )
             {
              // set complex results flag to true
              complexRootsFlag = true;
             }
          
          // otherwise, assume one or two roots
          else
             {
              // find square root of discriminant
              discSqrRoot = Math.sqrt( discriminant );

              // calculate one root
              rootOne = calcRoot( coef_B, discSqrRoot, denominator );

              // check for one root
              if( discriminant == 0 )
                 {
                  // set one root flag
                  oneRootFlag = true;                  
                 }
              
              // otherwise, assume two roots
              else
                 {             
                  // calculate root two
                  rootTwo = calcRoot( coef_B, -discSqrRoot, denominator );
                 }
             }
          
       // Display results, in table
          
          // print table title with top line and vertical space
             // method: displayTableTitle
          displayTableTitle();
          
          // print table subtitle line with top divider line
             // method: displaySubTitles
          displaySubTitles();
          
          // print coefficient A with top divider line
             // method: displayDataLine
          displayDataLine( "Coefficient A", coef_A, DOUBLE_DASH );
          
          // print coefficient b with top divider line
             // method: displayDataLine
          displayDataLine( "Coefficient B", coef_B, DASH );
       
          // print coefficient A with top divider line
             // method: displayDataLine
          displayDataLine( "Coefficient C", coef_C, DASH );
    
          // check for complex root
          if( complexRootsFlag )
             {
              // output complex root result, with divider line above
                 // method: displayDataLine
              displayDataLine( "Complex Roots", 0.00, DOUBLE_DASH );
             }
          
          // otherwise, check for only one root
          else if( oneRootFlag )
             {
              // output single root result, with divider line above
                 // method: displayDataLine
              displayDataLine( "Single Root", rootOne, DOUBLE_DASH );
             }

          // otherwise, assume two roots
          else
             {
              // output first root, with divider line above
                 // method: displayDataLine
              displayDataLine( "Root One", rootOne, DOUBLE_DASH );
              
              // output second root, with divider line above
                 // method: displayDataLine
              displayDataLine( "Root Two", rootTwo, DASH );
             }         

          // display bottom table line
             // method: displayLine
          displayLine( DOUBLE_DASH, BROKEN );

          // End program notification
          
             // Show program end
                // method: displayProgramEnd
             displayProgramEnd();
      }

    /*
    Name: displayTitle
    Process: display the program title with an underline
             and extra vertical space
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: none
    Device Input/Keyboard: none
    Device Output/Monitor: title displayed as specified
    Dependencies: printString, printChars, printEndline(s) 
                  String .string utility 
    */
    public static void printTitle( String title )
       {
        // initialize method/variables
        int titleLength = title.length();

        // initialize Console I/O Class
        Console_IO_Class conIO 
                          = new Console_IO_Class();

        // print title
           // method: printString, printEndline
        conIO.printString( title );
        conIO.printEndline();
        
        // printUnderline
           // method: printChars, printEndlines
        conIO.printChars( titleLength, DOUBLE_DASH );
        conIO.printEndlines( TWO_ENDLINES );
       }
    
    /*
    Name: promptForCoef
    Process: prompt for the coefficient related to the letter parameter
    Method Input/Parameters: prompt string (String)
    Method Output/Parameters: coefficient (int)
    Method Output/Returned: none
    Device Input/Keyboard: none
    Device Output/Monitor: title displayed as specified
    Dependencies: promptForInt
    */
    public static int promptForCoef( String promptString  )
       {
        // initialize method/variables
        int returnedVal;
        
        // initialize Console I/O Class
        Console_IO_Class conIO 
                          = new Console_IO_Class();
        
        returnedVal = conIO.promptForInt( promptString );
       
        return returnedVal;
       }

    /*
    Name: calcDenom
    Process: calculates the denominator for the quadratic equation
    Method Input/Parameters: coefficient A (int)
    Method Output/Parameters: none
    Method Output/Returned: denominator (int)
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: none
    */
    public static int calcDenom( int coefficientA )
       {
        // return calculated value
        return 2 * coefficientA;
       }
    
    /*
    Name: calcDiscrim
    Process: calculates the discriminant for the quadratic equation
    Method Input/Parameters: coefficients A, B, and C (int)
    Method Output/Parameters: none
    Method Output/Returned: discriminant (int)
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: none
    */
    public static int calcDiscrim( int coefficientA, 
                                            int coefficientB, int coefficientC )
       {
        // initialize method/variables
        int bSquaredPart, subtractedPart;
        
        // calculate b squared first part
        bSquaredPart = coefficientB * coefficientB;
        
        // calculate subtracted, second part
        subtractedPart = 4 * coefficientA * coefficientC;
       
        // return second part subtracted from first part
        return bSquaredPart - subtractedPart;
       }

    /*
    Name: calcRoot
    Process: calculates one root for the quadratic equation
    Method Input/Parameters: coefficient B (int), 
                             square root of discriminant (double), 
                             and  and denominator (int)
    Method Output/Parameters: none
    Method Output/Returned: calculated root (double)
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: none
    */
    public static double calcRoot( int coefficientB, 
                                           double discSqrRoot, int denominator )
       {
        // initialize method/variables
        double numerator;
        
        // calculate numerator
        numerator = -coefficientB + discSqrRoot;
        
        // return calculated result
        return numerator / denominator;
       }

    /*
    Name: displayDataLine
    Process: displays divider line, then data name, divider, and value
    Method Input/Parameters: name (String), 
                             value (double), divider character (char)
    Method Output/Parameters: none
    Method Output/Returned: none
    Device Input/Keyboard: none
    Device Output/Monitor: data line displayed as specified
    Dependencies: printBrokenLine, printChar, printString, printEndline
    */
    public static void displayDataLine( String name, 
                                                double value, char dividerChar )
       {
        // initialize Console I/O Class
        Console_IO_Class conIO 
                         = new Console_IO_Class();

        // printDividerLine
           // method: printBrokenLine
        displayLine( dividerChar, BROKEN );
        
        // print name data
           // method: printChar, printString
        conIO.printString( PIPE_SPACE );
        conIO.printString( name, NAME_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printChar( CROSS );
        
        // print value data
           // method: printDouble, printString, printEndline
        conIO.printDouble( value, PRECISION, VALUE_BLOCK_WIDTH - 1, "RIGHT" );
        conIO.printString( SPACE_PIPE );
        conIO.printEndline();
       }

   /*
    Name: displayLine
    Process: displays divided line with given character
             and type (SOLID, BROKEN)
    Method Input/Parameters: line character (char), line type (int)
    Method Output/Parameters: none
    Method Output/Returned: none
    Device Input/Keyboard: none
    Device Output/Monitor: line displayed as specified
    Dependencies: printChar(s), printEndline
    */
    public static void displayLine( char lineChar, int lineType )
       {
        // initialize Console I/O Class
        Console_IO_Class conIO 
                         = new Console_IO_Class();

        // display line
           // method: printChar(s), printEndline
        conIO.printChar( PIPE );
        conIO.printChars( NAME_BLOCK_WIDTH, lineChar );
        
        // check for solid line
        if( lineType == SOLID )
           {
            // print given line character
               // method: printChar         
            conIO.printChar( lineChar );
           }
        
        // otherwise, assume broken line
        else
           {
            // print pipe divider
               // method: printChar
            conIO.printChar( PIPE );
           }
        
        // print remainder of line
           // method: printChar(s), printEndline
        conIO.printChars( VALUE_BLOCK_WIDTH, lineChar );
        conIO.printChar( PIPE );
        conIO.printEndline();
       }

   public static void displayProgramEnd()
     {
      // initialize Console I/O Class
      Console_IO_Class conIO 
                       = new Console_IO_Class();

      // display end line
         // method: printString, printEndline
      conIO.printEndline();
      conIO.printString("End Program", NAME_BLOCK_WIDTH, "LEFT");
      conIO.printEndline();
     }

   /*
    Name: displaySubTitles
    Process: displays divider line, then subtitles
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: none
    Device Input/Keyboard: none
    Device Output/Monitor: line and subtitles displayed as specified
    Dependencies: printChar(s), printString, printEndline
    */
    public static void displaySubTitles()
       {
        // initialize Console I/O Class
        Console_IO_Class conIO 
                         = new Console_IO_Class();

        // print divider line
           // method: displayBrokenLine
        displayLine( DASH, SOLID );
        
        // print subtitle line
           // method: printChar(s), printString, printEndline
        conIO.printChar( PIPE );
        conIO.printString( "VALUE NAME", NAME_BLOCK_WIDTH, "CENTER" );
        conIO.printChar( PIPE);
        conIO.printString( "VALUE", VALUE_BLOCK_WIDTH, "CENTER" );
        conIO.printChar( PIPE );
        conIO.printEndline();
       }

   /*
    Name: displayTableTitle
    Process: displays table top line with vertical space and main title
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: none
    Device Input/Keyboard: none
    Device Output/Monitor: table title as specified
    Dependencies: printChar(s), printString, printEndline
    */
    public static void displayTableTitle()
       {
        // initialize Console I/O Class
        Console_IO_Class conIO 
                         = new Console_IO_Class();

        // create vertical space
           // method: printEndline
        conIO.printEndline();
        
        // Print table top line
           // method: displayLine
        displayLine( DOUBLE_DASH, SOLID );

        // Print table title
           // method: printString, printChar, printEndline
        conIO.printChar( PIPE );
        conIO.printString( "QUADRATIC ROOT RESULTS", TABLE_WIDTH-2, "CENTER" );
        conIO.printChar( PIPE );
        conIO.printEndline();        
       }
    }

