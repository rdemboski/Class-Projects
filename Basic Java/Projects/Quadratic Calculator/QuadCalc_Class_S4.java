package p4_package;

public class QuadCalc_Class_S4
   {
    // initialize Console I/O Class as global
    private static Console_IO_Class conIO = new Console_IO_Class();
    
    // initialize table characters
    public static final char DASH = '-';
    public static final char DOUBLE_DASH = '=';
    public static final char PIPE = '|';
    public static final char CROSS = '+';

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
    
    // initialize precision difference for testing equality
    public static final double PRECISION_OFFSET = 0.000001;
    
    public static void main(String[] args)
      {
       // initialize program/variables
      
          // initialize variables
          int coef_A, coef_B, coef_C, denominator, discriminant;
          double rootOne = 0.0, rootTwo = 0.0, discSqrRoot;
          boolean complexRootsFlag = false;
          
          // show title
             // method: printString, printEndline(s)
          conIO.printString( "Quadratic Root Finding Program" );
          conIO.printEndline();
          conIO.printString( "==============================" );
          conIO.printEndlines( TWO_ENDLINES );
          
       // get input from user
      
          // get coefficient A
             // method: promptForInt
          coef_A = conIO.promptForInt( "     Enter Coefficient A: " );
          
          // get coefficient B
             // method: promptForInt
          coef_B = conIO.promptForInt( "     Enter Coefficient B: " );
 
          // get coefficient C
             // method: promptForInt
          coef_C = conIO.promptForInt( "     Enter Coefficient C: " );
      
       // Find roots, if available
      
          // find denominator
          denominator = 2 * coef_A;
          
          // find discriminant
          discriminant = coef_B * coef_B - 4 * coef_A * coef_C;
          
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
             
              // calculate both roots
              rootOne = ( -coef_B + discSqrRoot ) / denominator;

              rootTwo = ( -coef_B - discSqrRoot ) / denominator;
             }
          
       // Display results, in table
          
          // Print table title with upper and lower lines
             // method: printChar(s), printEndline(s)
          conIO.printEndline();
          conIO.printChar( PIPE );
          conIO.printChars( TABLE_WIDTH-2, DOUBLE_DASH) ;
          conIO.printChar( PIPE );
          conIO.printEndline();
          conIO.printChar( PIPE );
          conIO.printString( "QUADRATIC ROOT RESULTS", TABLE_WIDTH-2, "CENTER" );
          conIO.printChar( PIPE );
          conIO.printEndline();        
          conIO.printChar( PIPE );
          conIO.printChars( TABLE_WIDTH-2, DASH );
          conIO.printChar( PIPE );
          conIO.printEndline();
          
          // print subtitles with lower line
             // method: printChar(s), printEndline(s)
          conIO.printChar( PIPE );
          conIO.printString( "VALUE NAME", NAME_BLOCK_WIDTH, "CENTER" );
          conIO.printChar( PIPE);
          conIO.printString( "VALUE", VALUE_BLOCK_WIDTH, "CENTER" );
          conIO.printChar( PIPE );
          conIO.printEndline();
          conIO.printChar( PIPE );
          conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
          conIO.printChar( PIPE );
          conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
          conIO.printChar( PIPE );
          conIO.printEndline();
          
          // output coefficient A
             // method: printString, printChar(s), printEndline
          conIO.printString( PIPE_SPACE );
          conIO.printString( "Coefficient A", NAME_BLOCK_WIDTH - 1, "LEFT" );
          conIO.printChar( CROSS );
          conIO.printDouble( coef_A, PRECISION, VALUE_BLOCK_WIDTH - 1, "RIGHT" );
          conIO.printString( SPACE_PIPE );
          conIO.printEndline();
          conIO.printChar( PIPE );
          conIO.printChars( NAME_BLOCK_WIDTH, DASH );
          conIO.printChar( PIPE );
          conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
          conIO.printChar( PIPE );
          conIO.printEndline();

          // output coefficient B
             // method: printString, printChar(s), printEndline
          conIO.printString( PIPE_SPACE );
          conIO.printString( "Coefficient B", NAME_BLOCK_WIDTH - 1, "LEFT" );
          conIO.printChar( CROSS );
          conIO.printDouble( coef_B, PRECISION, VALUE_BLOCK_WIDTH - 1, "RIGHT" );
          conIO.printString( SPACE_PIPE );
          conIO.printEndline();
          conIO.printChar( PIPE );
          conIO.printChars( NAME_BLOCK_WIDTH, DASH );
          conIO.printChar( PIPE );
          conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
          conIO.printChar( PIPE );
          conIO.printEndline();
       
          // output coefficient C
             // method: printString, printChar(s), printEndline
          conIO.printString( PIPE_SPACE );
          conIO.printString( "Coefficient C", NAME_BLOCK_WIDTH - 1, "LEFT" );
          conIO.printChar( CROSS );
          conIO.printDouble( coef_C, PRECISION, VALUE_BLOCK_WIDTH - 1, "RIGHT" );
          conIO.printString( SPACE_PIPE );
          conIO.printEndline();
          conIO.printChar( PIPE );
          conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
          conIO.printChar( PIPE );
          conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
          conIO.printChar( PIPE );
          conIO.printEndline();
    
          // check for complex root
          if( complexRootsFlag )
             {
              // output complex root result, with bottom table line
                 // method: printString, printChar(s), printEndline
              conIO.printString( PIPE_SPACE );
              conIO.printString( "Roots", NAME_BLOCK_WIDTH - 1, "LEFT" );
              conIO.printChar( CROSS );
              conIO.printString( "Complex", VALUE_BLOCK_WIDTH - 1, "RIGHT" );
              conIO.printString( SPACE_PIPE );
              conIO.printEndline();
              conIO.printChar( PIPE );
              conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
              conIO.printChar( PIPE );
              conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
              conIO.printChar( PIPE );
              conIO.printEndline();
             }
          
          // otherwise, check for only one root
          else if( rootOne + PRECISION_OFFSET > rootTwo 
                                       && rootOne - PRECISION_OFFSET < rootTwo )
             {
              // output single root result, with bottom table line
                 // method: printString, printChar(s), printEndline
              conIO.printString( PIPE_SPACE );
              conIO.printString( "Single Root", NAME_BLOCK_WIDTH - 1, "LEFT" );
              conIO.printChar( CROSS );
              conIO.printDouble( rootOne, PRECISION, 
                                               VALUE_BLOCK_WIDTH - 1, "RIGHT" );
              conIO.printString( SPACE_PIPE );
              conIO.printEndline();
              conIO.printChar( PIPE );
              conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
              conIO.printChar( PIPE );
              conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
              conIO.printChar( PIPE );
              conIO.printEndline();
             }

          // otherwise, assume two roots
          else
             {
              // output first root, with divider line
                 // method: printString, printChar(s), printEndline
              conIO.printString( PIPE_SPACE );
              conIO.printString( "Root One", NAME_BLOCK_WIDTH - 1, "LEFT" );
              conIO.printChar( CROSS );
              conIO.printDouble( rootOne, PRECISION, 
                                               VALUE_BLOCK_WIDTH - 1, "RIGHT" );
              conIO.printString( SPACE_PIPE );
              conIO.printEndline();
              conIO.printChar( PIPE );
              conIO.printChars( NAME_BLOCK_WIDTH, DASH );
              conIO.printChar( PIPE );
              conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
              conIO.printChar( PIPE );
              conIO.printEndline();
              
              // output first root, with divider line
                 // method: printString, printChar(s), printEndline
              conIO.printString( PIPE_SPACE );
              conIO.printString( "Root Two", NAME_BLOCK_WIDTH - 1, "LEFT" );
              conIO.printChar( CROSS );
              conIO.printDouble( rootTwo, PRECISION, 
                                            VALUE_BLOCK_WIDTH - 1, "RIGHT" );
              conIO.printString( SPACE_PIPE );
              conIO.printEndline();
              conIO.printChar( PIPE );
              conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
              conIO.printChar( PIPE );
              conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
              conIO.printChar( PIPE );
              conIO.printEndline();
             }         

          // End program notification
          
             // Show program end
                // method: printEndline, printString
             conIO.printEndline();
             conIO.printString("End Program", NAME_BLOCK_WIDTH, "LEFT");
             conIO.printEndline();

      }

   }
