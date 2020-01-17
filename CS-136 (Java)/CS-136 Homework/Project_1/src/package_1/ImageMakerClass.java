package package_1;

public class ImageMakerClass 
   {
    private static final char SPACE = ' ';
    private static final char X_CHAR = 'X';
    private static final char ENDLINE_CHAR = '\n';
    
    //Local variables created in order to avoid using literals.
    private static final int TWO_X = 2;
    private static final int SEVEN_X = 7;
    private static final int ONE_X = 1;
    private static final int THREE_SPACES = 3;
    private static final int TWO_SPACES = 2;
    private static final int ONE_SPACE = 1;
    
    public static void main(String[] args) 
       {
        // Diamond with cross /////////////////////////////////////////////////
        // Uses only printSpace, printChar, printEndLine
        // no character literals may be used as parameters
        
        //First Line
        printSpace();
        printSpace();
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printEndLine();
        
        //Second Line
        printSpace();
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printEndLine();
        
        //Third Line
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printSpace();
        printChar(X_CHAR);
        printSpace();
        printChar(X_CHAR);
        printEndLine();
        
        //Fourth Line
        printSpace();
        printChar(X_CHAR);
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printEndLine();
        
        //Fifth Line
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printEndLine();
        
        //Sixth Line
        printSpace();
        printChar(X_CHAR);
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printEndLine();
        
        //Seventh Line
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printSpace();
        printChar(X_CHAR);
        printSpace();
        printChar(X_CHAR);
        printEndLine();
        
        //Eighth Line
        printSpace();
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printChar(X_CHAR);
        printChar(X_CHAR);
        printEndLine();
        
        //Ninth Line
        printSpace();
        printSpace();
        printSpace();
        printSpace();
        printChar(X_CHAR);
        printEndLine();
        
        printEndLine();
        
        // Square with X //////////////////////////////////////////////////////
        // Uses only printSpaces, printChars, printEndLine
        // No integer or character literals may be used as parameters
        
        //First Line
        printChars(SEVEN_X, X_CHAR);
        printEndLine();
        
        //Second Line
        printChars(TWO_X, X_CHAR);
        printSpaces(THREE_SPACES);
        printChars(TWO_X, X_CHAR);
        printEndLine();
        
        //Third Line
        printChars(ONE_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(ONE_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(ONE_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(ONE_X, X_CHAR);
        printEndLine();
        
        //Fourth Line
        printChars(ONE_X, X_CHAR);
        printSpaces(TWO_SPACES);
        printChars(ONE_X, X_CHAR);
        printSpaces(TWO_SPACES);
        printChars(ONE_X, X_CHAR);
        printEndLine();
        
        //Fifth Line
        printChars(ONE_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(ONE_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(ONE_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(ONE_X, X_CHAR);
        printEndLine();
        
        //Sixth Line
        printChars(TWO_X, X_CHAR);
        printSpaces(THREE_SPACES);
        printChars(TWO_X, X_CHAR);
        printEndLine();
        
        //Seventh Line
        printChars(SEVEN_X, X_CHAR);
        printEndLine();
        
        printEndLine();
        
        // Diamond shadow with cross //////////////////////////////////////////
        // Uses only printSpaces, printChars, printEndLine
        // No integer or character literals may be used as parameters
          
        //First Line  
        printChars(SEVEN_X, X_CHAR);
        printEndLine();
        
        //Second Line
        printChars(TWO_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(ONE_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(TWO_X, X_CHAR);
        printEndLine();
        
        //Third Line
        printChars(ONE_X, X_CHAR);
        printSpaces(TWO_SPACES);
        printChars(ONE_X, X_CHAR);
        printSpaces(TWO_SPACES);
        printChars(ONE_X, X_CHAR);
        printEndLine();
        
        //Fourth Line
        printChars(SEVEN_X, X_CHAR);
        printEndLine();
        
        //Fifth Line
        printChars(ONE_X, X_CHAR);
        printSpaces(TWO_SPACES);
        printChars(ONE_X, X_CHAR);
        printSpaces(TWO_SPACES);
        printChars(ONE_X, X_CHAR);
        printEndLine();
        
        //Sixth Line
        printChars(TWO_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(ONE_X, X_CHAR);
        printSpaces(ONE_SPACE);
        printChars(TWO_X, X_CHAR);
        printEndLine();
        
        //Seventh Line
        printChars(SEVEN_X, X_CHAR);
       }

// Supporting methods - DO NOT MODIFY THESE METHODS IN ANY WAY
    public static void printSpace()
       {
        System.out.print( SPACE );
       }
    
    public static void printChar( char outChar )
       {
        System.out.print( outChar );
       }
        
    public static void printEndLine()
       {
        System.out.print( ENDLINE_CHAR );
       }
        
    public static void printSpaces( int numSpaces )
       {
        if( numSpaces > 0 )
           {
            printSpaces( numSpaces - 1 );
            
            printSpace();
           }
       }
    
    public static void printChars( int numChars, char outChar )
       {
          if( numChars > 0 )
             {
              printChars( numChars - 1, outChar );
              
              printChar( outChar );
             }
       }
       
    
   }