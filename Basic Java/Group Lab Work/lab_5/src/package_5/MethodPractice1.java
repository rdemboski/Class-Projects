package package_5;


public class MethodPractice1
   {
    private static final char SPACE = ' ';
    private static final char HORIZONTAL_BORDER = '=';
    private static final char VERTICAL_BORDER = '|';
    private static final char ENDLINE_CHAR = '\n';

    public static void main(String[] args) 
       {
    	char bodyPart = 'O';
        int numChars;
        int numSpaces;
        
         //First line
        numChars = 17;
        printChars(numChars, HORIZONTAL_BORDER);
        printEndLine();
         
         //Second line
        numSpaces = 7;
        printChar(VERTICAL_BORDER);
        printSpaces(numSpaces);
        printChar(bodyPart);
        printSpaces(numSpaces);
        printChar(VERTICAL_BORDER);
        printEndLine();
        
         //Third line
        numSpaces = 6;
        bodyPart = '-';
        printChar(VERTICAL_BORDER);
        printSpaces(numSpaces);
        printChar(bodyPart);
        bodyPart = VERTICAL_BORDER;
        printChar(bodyPart);
        bodyPart = '-';
        printChar(bodyPart);
        printSpaces(numSpaces);
        printChar(VERTICAL_BORDER);
        printEndLine();
        
         //Fourth line
        bodyPart = '/';
        printChar(VERTICAL_BORDER);
        printSpaces(numSpaces);
        printChar(bodyPart);
        printSpace();
        
        
         
         //Fifth line
         
         
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