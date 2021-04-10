package p3_package;

public class PolyMultiplierClass_S4
   {
    // Initialize Console I/O class
    private static Console_IO_Class conIO = new Console_IO_Class();
    
    // Set constant for specifying two end lines
    private static final int TWO_END_LINES = 2; 
    
    public static void main( String[] args )
       {
        // initialize method/variables
        int coef_a, coef_b, coef_c, coef_d;
        int xSqrd_coef, x_coef, constVal;
        
        // show title and instructions
        
           // show title
              // method: printString, printEndline(s)
        conIO.printString( "Polynomial Calculator" );
        conIO.printEndline();
        conIO.printString( "=====================" );
        conIO.printEndlines( TWO_END_LINES );
        
        // show instructions
           // method: printString, printEndline(s)
        conIO.printString( "Multiplies two polynomial expressions" );
        conIO.printEndline();
        conIO.printString( "  in the form: ( ax + b ) * ( cx + d )" );
        conIO.printEndlines( TWO_END_LINES );
        
        // get input from user
       
           // get coefficient a
              // method: promptForInt
           coef_a = conIO.promptForInt( "Enter coefficient a: " );
           
           // get coefficient a
              // method: promptForInt
           coef_b = conIO.promptForInt( "Enter coefficient b: " );
        
           // get coefficient a
              // method: promptForInt
           coef_c = conIO.promptForInt( "Enter coefficient c: " );
     
           // get coefficient a
              // method: promptForInt
           coef_d = conIO.promptForInt( "Enter coefficient d: " );       
       
        // process polynomial math
        
            // find x squared coefficient
            xSqrd_coef = coef_a * coef_c;
                  
            // find x coefficient
            x_coef = coef_c * coef_b + coef_d * coef_a;
           
            // find constant
            constVal = coef_b * coef_d;
                      
        // show results
       
           // display processed polynomial expression
              // method: printString, printEndline(s)
           conIO.printEndline();
           conIO.printString( "Result: " );
           conIO.printEndline();
           conIO.printString( "( " + coef_a + "x + " + coef_b + " )*" );
           conIO.printString( "( " + coef_c + "x + " + coef_d + " ) = " );
           
           conIO.printString( "" + xSqrd_coef + "x^2 + " 
                                                 + x_coef + "x + " + constVal );
           conIO.printEndlines( TWO_END_LINES );
           
        // end program
           // method: printString, printEndline
        conIO.printString( "Program End" );
        conIO.printEndline();
        
       }
   }
