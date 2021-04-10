package p7_package;

public class FunctionToolClass
   {
    public static final int MENU_BLOCK_SIZE = 30;
    
    public static final int LOW_MENU_SELECTION = 1;
    public static final int HIGH_MENU_SELECTION = 3;
    
    public static final int FIND_NEXT_PRIME = 1;
    public static final int FIND_SINE = 2;
    public static final int FIND_SQUARE_ROOT = 3;

    public static final int SINE_ITERATIONS = 9;
    public static final double PRECISION = .000001;
    public static final int LONG_PRECISION = 6;
    public static final int TWO_ENDLINES = 2;
    
    public static Console_IO_Class conIO = new Console_IO_Class();
    
    public static void main( String [] args )
       {
        // initialize program/variables
        int selection;
        double userInputVal, result;
        
        // get input
           // method: getUserSelection   
        selection = getUserSelection();

        // get input value for operations
           // method: getUserInput
        userInputVal = getUserInput( selection );
        
        // process data

           // check selection
           switch( selection )
              {
               // find next prime case
               case FIND_NEXT_PRIME:
               
                  // call find next prime
                     // method: findNextPrime
                  result = findNextPrime( (int)userInputVal );
                  
                  // break
                  break;
                  
               // find natural log case
               case FIND_SINE:
               
                  // call find natural log
                     // method: findNaturalLog
                  result = findSine( userInputVal );
                  
                  // break
                  break;
                  
               // find square root case
               default:
               
                  // call find square root
                     // method: findSquareRoot
                  result = findSquareRoot( userInputVal );
                  
                  // break
                  break;               
              }           
           // end check selection
        
           // display results
              // method: showResults
           showResults( result, selection );
       
        // end program
           // method: printString, printEndline
        conIO.printString( "Program End" );
        conIO.printEndline();
       }

    /*
    Name: displayMenu
    Process: displays menu, gets user input
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: user input (int)
    Device Input/Keyboard: none
    Device Output/Monitor: display of menu
    Dependencies: Console I/O Tools
    */
    public static int displayMenu()
       {
        // initialize method/variables
          // none
        
        // print menu header
           // method: printString, printEndline
        conIO.printString( "MENU", MENU_BLOCK_SIZE, "CENTER" );
        conIO.printEndlines( TWO_ENDLINES );
        
        // print selections
           // method: printString, printEndline
        conIO.printString( "1. Find Next Prime" );
        conIO.printEndlines( TWO_ENDLINES );
        
        conIO.printString( "2. Find Sine" );
        conIO.printEndlines( TWO_ENDLINES );
        
        conIO.printString( "3. Find Square Root" );
        conIO.printEndlines( TWO_ENDLINES );
        
        // prompt for input and return
           // method: promptForInt
        return conIO.promptForInt( "Enter your selection choice: " );
       }

    /*
    Name: findFactorial
    Process: finds factorial of value using recursion
    Method Input/Parameters: value to find factorial
    Method Output/Parameters: none
    Method Output/Returned: factorial of value (int)
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: none
    */
    public static long findFactorial( int value )
       {
        // initialize method/variables
       
        // test for value greater than one
        if( value > 1 )
           {
            // return value times its next lower factorial
            return value * findFactorial( value - 1 );
           }
        
        // fall through to return 1
        return 1;
       }

   /*
    Name: findNextPrime
    Process: loops until next prime found starting at given value
    Method Input/Parameters: starting value to search for prime (int)
    Method Output/Parameters: none
    Method Output/Returned: next prime value (int)
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: none
    */
    public static int findNextPrime( int startValue )
       {
        // initialize method/variables
       
        // loop from start value up
        while( !isPrime( startValue ) )
           {
            startValue++;
           }
        // end loop
        
        // return next prime
        return startValue;
       }

   /*
    Name: findSine
    Process: uses Taylor series to find estimated sine value
    Method Input/Parameters: value from which to find sine
    Method Output/Parameters: none
    Method Output/Returned: estimated sine (double)
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: none
    */
    public static double findSine( double value )
       {
        // initialize method/variables, including setting numerator, denominator
        double numerator = value;
        int ctr, denominatorCount = 3;
        long denominator = 1;
        double result = 0.0;
        double newElement = numerator / denominator;
        
        // loop until precision found
        for( ctr = 0; ctr < SINE_ITERATIONS; ctr++ )
           {
            result += newElement; 
                  
            numerator *= -( value * value );
            
            denominator = findFactorial( denominatorCount );
        
            denominatorCount += 2;
            
            newElement = numerator / denominator;
           }
        
        // return found result
        return result;
       }

   /*
    Name: findSquareRoot
    Process: uses divide and conquer estimation strategy for finding square root
    Method Input/Parameters: value to find square root of (double)
    Method Output/Parameters: none
    Method Output/Returned: square root of value (double)
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: Math.abs
    */
    public static double findSquareRoot( double initialVal )
       {
        // initialize method/variables with starting values
        double low = 0.0, high = initialVal;
        double mid = high / 2.0;
        double testSquare = mid * mid;
        double difference = testSquare - initialVal;
        
        // loop while absolute difference is larger than precision
        while( Math.abs( difference ) > PRECISION )
           {
            // check for test value high
            if( difference > 0.0 )
               {
                // set high to mid
                high = mid;
               }
            
            // otherwise assume test value low
            else
               {
                low = mid;
               }
           
            mid = ( high + low ) / 2.0;
            
            testSquare = mid * mid;
            
            difference = testSquare - initialVal;
           }
        
        // return estimated square root
        return mid;
       }

   /*
    Name: getUserInput
    Process: depending on which operation selected,
             shows appropriate input prompt,
             then returns user input value
    Method Input/Parameters: user selection of operation (int)
    Method Output/Parameters: none
    Method Output/Returned: input value (int)
    Device Input/Keyboard: user entry of value
    Device Output/Monitor: display of menu
    Dependencies: Console I/O Tools
    */
    public static double getUserInput( int operationSelection )
       {
        // initialize method/variables
        double userInput;
        
        // create vertical spacing
           // method: printEndline
        conIO.printEndline();
        
        // loop until correct input, > 1
        do
           {
            // select from options
            switch( operationSelection )
               {
                // find next prime selection
                case FIND_NEXT_PRIME:
               
                   // show prompt for finding prime
                      // method: printString
                   conIO.printString( "Enter start value for finding prime, " );
                  
                   // break
                   break;
                  
                // find natural log selection
                case FIND_SINE:
               
                   // show prompt for finding natural log
                      // method: printString
                   conIO.printString( "Enter value to find sine, " );
            
                   // break
                   break;
            
                // assume finding square root
                default:
                  
                   // show prompt for finding natural log
                      // method: printString
                   conIO.printString( "Enter value to find square root, " );
               
                   // break
                   break;
               }
            // end selection
           
            // provide prompt for input
               // method: promptForDouble
            userInput = conIO.promptForDouble( "must be greater than 1.0: " );
           }
        // end loop when value greater than 1.0
        while( userInput <= 1.0 );
        
        // return input
        return userInput;
       }

   /*
    Name: getUserSelection
    Process: displays menu, loops until correct input, returns valid user input
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: correct user input (int)
    Device Input/Keyboard: user entry of value
    Device Output/Monitor: display of menu
    Dependencies: Console I/O Tools
    */
    public static int getUserSelection()
       {
        // initialize method/variables
        int userSelection;
          
        // loop until correct item accepted
        do
           {
            // display menu, get result
               // method: displayMenu
           userSelection = displayMenu();
           }
        // end loop when input value is correct
        while( userSelection < LOW_MENU_SELECTION  
                                        || userSelection > HIGH_MENU_SELECTION);
          
        return userSelection;
       }
       
    /*
    Name: isPrime
    Process: tests for possible division by values up to square root of value
    Method Input/Parameters: value to test for prime (int)
    Method Output/Parameters: none
    Method Output/Returned: Boolean result of test for prime (Boolean)
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: none
    */
    public static boolean isPrime( int value )
       {
        // initialize method/variables including starting values
        int testLimit = (int)( findSquareRoot( value ) + 1 );
        int testVal;
        
        // loop from 2 to int square root of value
        for( testVal = 2; testVal <= testLimit; testVal++ )
           {
            // test for even division
            if( value % testVal == 0 )
               {
                // return false
                return false;
               }
            // end if
           }
        // end loop
        
        // return true if even division not found in loop
        return true;
       }

    /*
    Name: showResults
    Process: shows results depending on which process was specified
    Method Input/Parameters: result value (double), input selection (int)
    Method Output/Parameters: none
    Method Output/Returned: none
    Device Input/Keyboard: none
    Device Output/Monitor: display as specified
    Dependencies: Console I/O Class tools
    */
    public static void showResults( double result, int inputSelection )
       {
        // initialize method/variables
       
        // make vertical spacing
           // method: printEndline
        conIO.printEndline();
        
        // select from options
        switch( inputSelection )
           {
            // find next prime selection
            case FIND_NEXT_PRIME:
          
               // show prompt for finding prime
                  // method: printString
               conIO.printString( "Next prime value is: " + (int)result );
             
               // break
               break;
             
            // find sine selection
            case FIND_SINE:
           
               // show prompt for finding natural log
                  // method: printString
               conIO.printString( "Sine value is: " );
               conIO.printDouble( result, LONG_PRECISION );
       
               // break
               break;
       
            // assume finding square root
            default:
             
               // show prompt for finding square root
                  // method: printString
               conIO.printString( "Square root is: " );
               conIO.printDouble( result, LONG_PRECISION );
          
               // break
               break;
           }
        // end selection
        
        // end lines
           // method: printEndlines
        conIO.printEndlines( TWO_ENDLINES );
       }
    
   }  // end class

