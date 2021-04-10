package p5_package;

public class PolyMultiplierClass_II_S4
   {
    // Initialize Console I/O class
    private static Console_IO_Class conIO = new Console_IO_Class();
    
    // Set constant for specifying two end lines
    private static final int TWO_END_LINES = 2; 

    // Set constants for degree forms
    private static final int FIRST_DEGREE = 1; 
    private static final int SECOND_DEGREE = 2; 
    private static final int THIRD_DEGREE = 3; 

    public static void main( String[] args )
       {
        // initialize method/variables
        int coef_a = 0, coef_b = 0, coef_c = 0;
        int coef_d = 0, coef_e = 0, coef_f = 0, degreeForm;
        int first_coef = 0, second_coef = 0, third_coef = 0;
        int fourth_coef = 0, fifth_coef = 0; 
        boolean correctInput = true;
        
        // show title and instructions
        
           // show title
              // method: printString, printEndline(s)
        conIO.printString( "Polynomial Calculator, Part Deux" );
        conIO.printEndline();
        conIO.printString( "================================" );
        conIO.printEndlines( TWO_END_LINES );
        
        // show instructions
           // method: printString, printEndline(s)
        conIO.printString( "Multiplies a first degree polynomial" );
        conIO.printEndline();
        conIO.printString( "  by a first degree form: " );
        conIO.printString( "( ax + b ) * ( cx + d )" );
        conIO.printEndline();
        conIO.printString( "  or by a second degree form: " );
        conIO.printString( "( ax + b ) * ( cx^2 + dx + e )" );
        conIO.printEndline();
        conIO.printString( "  or by a third degree form: " );
        conIO.printString( "( ax + b ) * ( cx^3 + dx^2 + ex + f )" );
        conIO.printEndline();
        conIO.printString( "depending on user selection" );
        conIO.printEndlines( TWO_END_LINES );
        
        // get input from user
       
           // Ask user for degree form
              // method: promptForInt
           degreeForm = conIO.promptForInt( "Enter degree form (1-3): " );
           
           // check for incorrect user input
           if( degreeForm < FIRST_DEGREE || degreeForm > THIRD_DEGREE )
              {
               // set correct input flag to false
               correctInput = false;               
              }
           
           // check for correct input flag
           if( correctInput )
              {         
               // get coefficient a
                  // method: promptForInt
               coef_a = conIO.promptForInt( "Enter coefficient a: " );
           
               // get coefficient b
                  // method: promptForInt
               coef_b = conIO.promptForInt( "Enter coefficient b: " );
        
               // get coefficient c
                  // method: promptForInt
               coef_c = conIO.promptForInt( "Enter coefficient c: " );
     
               // get coefficient d
                  // method: promptForInt
               coef_d = conIO.promptForInt( "Enter coefficient d: " );
               
               // check for second or third degree form
               if( degreeForm >= SECOND_DEGREE )
                  {
                   // get coefficient e
                      // method: promptForInt
                   coef_e = conIO.promptForInt( "Enter coefficient e: " );
                  }
               
               // check for third degree form
               if( degreeForm == THIRD_DEGREE )
                  {
                   // get coefficient f
                      // method: promptForInt
                   coef_f = conIO.promptForInt( "Enter coefficient f: " );
                  }
              }
           
        // process polynomial math
        
        // check for correct input
        if( correctInput )
           {
            // find first coefficient
            first_coef = coef_a * coef_c;
                  
            // get second coefficient
            second_coef = coef_c * coef_b + coef_d * coef_a;
           
            // check for first degree multiplication
            if( degreeForm == FIRST_DEGREE )
               {
                third_coef = coef_b * coef_d; 
               }
            
            // otherwise, assume greater than first degree multiplication
            else
               {
                // get third coefficient
                third_coef = coef_b * coef_d + coef_a * coef_e;
                
                // check for second degree multiplication
                if( degreeForm == SECOND_DEGREE )
                   {
                    // get fourth coefficient
                    fourth_coef = coef_b * coef_e;
                   }
                
                // otherwise, assume third degree multiplication
                else
                   {
                    // get fourth coefficient
                    fourth_coef = coef_b * coef_e + coef_a * coef_f;
                    
                    // get fifth coefficient
                    fifth_coef = coef_b * coef_f;
                   }
               }
           }
        
        // show results
        
        // check for correct input
        if( correctInput )
           {
            // display first part of processed polynomial expression
               // method: printString, printEndline(s)
            conIO.printEndline();
            conIO.printString( "Result: " );
            conIO.printEndline();
            conIO.printString( "( " + coef_a + "x + " + coef_b + " )*" );
           
            // check for first degree multiplicand
            if( degreeForm == FIRST_DEGREE )
               {
                // show first degree multiplicand
                   // method: printString           
                conIO.printString( "( " + coef_c + "x + " + coef_d + " ) = " );
               
                // show product
                   // method: printString
                conIO.printString( "" + first_coef + "x^2 + " 
                                          + second_coef + "x + " + third_coef );
               }
           
            // check for second degree multiplicand
            else if( degreeForm == SECOND_DEGREE )
               {
                // show second degree multiplicand
                   // method: printString           
                conIO.printString( "( " + coef_c + "x^2 + " 
                                          + coef_d + "x + " + coef_e + ") = " );
               
                // show product
                   // method: printString
                conIO.printString( "" + first_coef + "x^3 + " 
                  + second_coef + "x^2 + " + third_coef + "x + " + fourth_coef);
               }
           
           // assume third degree multiplicand
           else
              {
               // show third degree multiplicand
                  // method: printString           
               conIO.printString( "( " + coef_c + "x^3 + " 
                      + coef_d + "x^2 + " + coef_e + "x + " + coef_f + ") = " );
               
               // show product
                  // method: printString
               conIO.printString( "" + first_coef + "x^4 + " + second_coef 
                                         + "x^3 + " + third_coef + "x^2 + " 
                                           + fourth_coef + "x + " + fifth_coef);
              }

           }
        
        // otherwise, assume incorrect input
        else
           {
            // display input error message
               // method: printString, printEndline(s)
            conIO.printEndline();
            conIO.printString( "Incorrect number of polynomial degrees" );
            conIO.printString( " entered - Program Aborted" );
           }

        // print endlines after output
           // method: printEndlines
        conIO.printEndlines( TWO_END_LINES );
           
        // end program
           // method: printString, printEndline
        conIO.printString( "Program End" );
        conIO.printEndline();        
       }
   }
