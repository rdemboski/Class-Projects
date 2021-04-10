package p2_package;

public class IndactanceCalculationClass
    {
     public static final char DASH = '-';
     public static final char DOUBLE_DASH = '=';
     public static final char PIPE = '|';
     public static final char CROSS = '+';
     
     public static final int TWO_ENDLINES = 2;
     public static final int PRECISION = 2;
     public static final int TABLE_WIDTH = 65;
     public static final int MEASURED_BLOCK_WIDTH = 20;
     public static final int NAME_BLOCK_WIDTH = 29;
     public static final int VALUE_BLOCK_WIDTH = 12;

     public static final String PIPE_SPACE = "| ";
     public static final String SPACE_PIPE = " |";
     public static final String CROSS_SPACE = "+ ";

     public static final double TWO_PI = 2.0 * Math.PI;
     
     public static void main( String[] args )
        {
         // Initialize variables
         double current, resistance, frequency, capacitance;
         double numerator, denominator;
         double result;
         
         // Initialize I/O object
         Console_IO_Class conIO = new Console_IO_Class();          
         // TODO: Write program here
         // Must use constants provided, none other
         // Must create and use variables as needed
         // May not use character or integer literals in method parameters
         // Strings are acceptable as method parameters
         // Also must use Steps 1 - 4 throughout program
         
         
        // Print title
        conIO.printString( "Indactance Calculation Program", 
                                                     NAME_BLOCK_WIDTH, "LEFT" );
        conIO.printEndline();
        conIO.printChars( NAME_BLOCK_WIDTH + 1, DOUBLE_DASH );
        conIO.printEndlines( TWO_ENDLINES );
        
        // Get inputs from user
        current = conIO.promptForDouble( "  Enter Current       (A): " );
        resistance = conIO.promptForDouble( "  Enter Resistance (Ohms): " );
        frequency = conIO.promptForDouble( "  Enter Frequency    (hz): " );
        capacitance = conIO.promptForDouble( "  Enter Capacitance   (F): " );
        
        
        //Calculating Result
        numerator = current * resistance;
        denominator = TWO_PI * frequency * capacitance;
        result = numerator / denominator;
            
        // Print table title with upper and lower lines
        conIO.printEndline();
        conIO.printChar( PIPE );
        conIO.printChars( TABLE_WIDTH-2, DOUBLE_DASH) ;
        conIO.printChar( PIPE );
        conIO.printEndline();
        conIO.printChar( PIPE );
        conIO.printString( "INDACTANCE CALCULATION PROGRAM", 
                                                      TABLE_WIDTH-2, "CENTER" );
        conIO.printChar( PIPE );
        conIO.printEndline();        
        conIO.printChar( PIPE );
        conIO.printChars( TABLE_WIDTH-2, DASH );
        conIO.printChar( PIPE );
        conIO.printEndline();
        
        // print subtitles with lower line
        conIO.printChar( PIPE );
        conIO.printString( "MEASURED", MEASURED_BLOCK_WIDTH, "CENTER" );
        conIO.printChar( PIPE );
        conIO.printString( "NAME", NAME_BLOCK_WIDTH, "CENTER" );
        conIO.printChar( PIPE);
        conIO.printString( "VALUE", VALUE_BLOCK_WIDTH, "CENTER" );
        conIO.printChar( PIPE );
        conIO.printEndline();
        conIO.printChar( PIPE );
        conIO.printChars( MEASURED_BLOCK_WIDTH, DOUBLE_DASH );
        conIO.printChar( PIPE );
        conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
        conIO.printChar( PIPE );
        conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
        conIO.printChar( PIPE );
        conIO.printEndline();
        
        //Outputting user input for coefficient A
        conIO.printString( PIPE_SPACE );
        conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printString( CROSS_SPACE );
        conIO.printString( "Current", NAME_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printChar( CROSS );
        conIO.printDouble( current, PRECISION, VALUE_BLOCK_WIDTH - 1, "RIGHT" );
        conIO.printString( SPACE_PIPE );
        conIO.printEndline();
        conIO.printChar( PIPE );
        conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( NAME_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printEndline();
        
        //Outputting user input for coefficient B
        conIO.printString( PIPE_SPACE );
        conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printString( CROSS_SPACE );
        conIO.printString( "Resistance", NAME_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printChar( CROSS );
        conIO.printDouble( resistance, PRECISION, 
                                               VALUE_BLOCK_WIDTH - 1, "RIGHT" );
        conIO.printString( SPACE_PIPE );
        conIO.printEndline();
        conIO.printChar( PIPE );
        conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( NAME_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printEndline();
        
        //Outputting user input for coefficient C       
        conIO.printString( PIPE_SPACE );
        conIO.printString( "Laboratory", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printString( CROSS_SPACE );
        conIO.printString( "Frequency", NAME_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printChar( CROSS );
        conIO.printDouble( frequency, PRECISION, 
                                               VALUE_BLOCK_WIDTH - 1, "RIGHT" );
        conIO.printString( SPACE_PIPE );
        conIO.printEndline();
        conIO.printChar( PIPE );
        conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( NAME_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printEndline();
    
        //Outputting user input for variable x
        conIO.printString( PIPE_SPACE );
        conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printString( CROSS_SPACE );
        conIO.printString( "Capacitance", NAME_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printChar( CROSS );
        conIO.printDouble( capacitance, PRECISION, 
                                               VALUE_BLOCK_WIDTH - 1, "RIGHT" );
        conIO.printString( SPACE_PIPE );
        conIO.printEndline();
        conIO.printChar( PIPE );
        conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( NAME_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printEndline();

        //Outputting result
        conIO.printString( PIPE_SPACE );
        conIO.printString( "Calculated Result", 
                                             MEASURED_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printString( CROSS_SPACE );
        conIO.printString( "Capacitive Indactance", 
                                                 NAME_BLOCK_WIDTH - 1, "LEFT" );
        conIO.printChar( CROSS );
        conIO.printDouble( result, PRECISION, VALUE_BLOCK_WIDTH - 1, "RIGHT" );
        conIO.printString( SPACE_PIPE );
        conIO.printEndline();
        conIO.printChar( PIPE );
        conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( NAME_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
        conIO.printChar( PIPE );
        conIO.printEndline();
        
        //End program notification
        conIO.printEndline();
        conIO.printString("End Program", NAME_BLOCK_WIDTH, "LEFT");

        
        
        }

    } 

