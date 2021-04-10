package p10_package;

/**
 * Class encrypts, stores, and decrypts messages encoded and stored in an array 
 * of long integers
 * 
 * @author MichaelL
 *
 */
public class EncryptionClassDeux
   {
    /**
     * Default capacity for square array
     */
    private final String DEFAULT_STRING = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Constant for decoding first three digits of long
     */
    private final int THREE_DIGIT_OFFSET = 1000;
    
    /**
     * Constant for decoding second three digits of long
     */
    private final int SIX_DIGIT_OFFSET = 1000000;

    /**
     * Constant for decoding third three digits of long
     */
    private final int NINE_DIGIT_OFFSET = 1000000000;

    /**
     * Constant for random index lower limit
     */
    private final int RAND_LOWER_LIMIT = 10;

    /**
     * Constant for random index upper limit
     */
    private final int RAND_UPPER_LIMIT = 99;

    /**
     * Constant for minimum string size
     */
    private final int MIN_STRING_LENGTH = 15;

    /**
     * Constant indicating used value
     */
    private final int USED_CODE = 1;

    /**
     * Constant indicating unused value
     */
    private final int UNUSED_CODE_LOW = 2;
    
    /**
     * Constant indicating unused value
     */
    private final int UNUSED_CODE_HIGH = 9;
    
    /**
     * Constant indicating control code for number only
     */
    public static final int ENUM_NUMBER_ONLY = 1001;
    
    /**
     * Constant indicating control code for character only
     */
    public static final int ENUM_CHARACTER_ONLY = 2002;
    
    /**
     * Constant indicating control code for both number and character
     */
    public static final int ENUM_BOTH = 3003;
    
    /**
     * Constant indicating tilde character
     */
    private final char TILDE_CHAR = '~';
    
    /**
     * Constant indicating caret character
     */
    private final char CARET_CHAR = '^';
    
    /**
     * Constant indicating space character
     */
    private final char SPACE_CHAR = ' ';
    
    /**
     * Constant indicating caret character
     */
    private final char RIGHT_CURLY_BRACE_CHAR = '}';
    
    /**
     * data array
     */
    private long array[][];
    
    /**
     * side capacity for square array
     */
    private int sideCapacity;
    
    /**
     * Default constructor
     * <p>
     * Creates an array with DEFAULT_STRING "abcdefghijklmnopqrstuvwxyz" 
     * and sets all the elements in it to random characters
     * <p>
     * Dependencies: createArray
     */
    EncryptionClassDeux()
       {
        array = createArray( DEFAULT_STRING );
       }
    
    /**
     * Initialization constructor 
     * <p>
     * Captures and encrypts string
     * <p>
     * Dependencies: encryptString
     * 
     * @param toEncrypt String object holding data to be encrypted
     * 
     */
    EncryptionClassDeux( String toEncrypt )
       {
        encryptString( toEncrypt );
       }
    
    /**
     * Copy constructor 
     * <p>
     * Dependencies: None
     * 
     * @param copied EncryptionClassDeux object to be copied into this object
     * 
     */
    EncryptionClassDeux( EncryptionClassDeux copied )
       {
        int rowIndex, colIndex;
        
        sideCapacity = copied.sideCapacity;
        
        array = new long[ sideCapacity ][ sideCapacity ];
        
        for( rowIndex = 0; rowIndex < sideCapacity; rowIndex++ )
           {
            for( colIndex = 0; colIndex < sideCapacity; colIndex++ )
               {
                array[ rowIndex ][ colIndex ] 
                                         = copied.array[ rowIndex ][ colIndex ];               
               }
           }
       }
    
    /**
     * Create array
     * <p>
     * Finds length of string to be encrypted; 
     * if string is less than MIN_STRING_LENGTH, 
     * length is set to MIN_STRING_LENGTH;
     * either way string length is then doubled
     * <p>
     * Finds the square root of the updated string length and sets side capacity; 
     * creates local array, then calls fillArray which sets all the elements 
     * in the array to random characters other than tilde ('~')
     * <p>
     * Returns local array to calling method
     * <p>
     * Dependencies: Math.length, Math.sqrt, fillArray
     * 
     * @param setUpString string used to find and process string length
     * 
     * @return array [][] of long values
     */
    private long [][] createArray( String setUpString )
       {
        int strLen = setUpString.length();        
        long [][] tempArr;
        
        if( strLen < MIN_STRING_LENGTH )
           {
            strLen = MIN_STRING_LENGTH; 
           }
        
        // double length of string
        strLen *= 2;
        
        sideCapacity = (int)( Math.sqrt( strLen ) );
        
        tempArr = new long[ sideCapacity ][ sideCapacity ];
        
        tempArr = fillArray( tempArr );
                
        return tempArr;
       }
    
    /**
     * displayArray
     * <p>
     * Depending on control code, array is displayed one of three ways: 
     * NUMBER_ONLY: displays array of long values; CHARACTER_ONLY: displays
     * encoded characters; BOTH: displays both numbers and characters
     * <p>
     * Uses System.out.format
     * <p>
     * Dependencies: System.out.println, System.out.format, getCharValue
     * 
     * @param ctrlCode integer control code to indicate kind of display
     */
    public void displayArray( int ctrlCode )
       {
        long number;
        int rowIndex, colIndex;
        char displayChar;
        
        System.out.println( "Array Display:" );
        
        for( rowIndex = 0; rowIndex < sideCapacity; rowIndex++ )
           {
            for( colIndex = 0; colIndex < sideCapacity; colIndex++ )
               {
                number = array[ rowIndex ][ colIndex ];
                
                displayChar = getCharValue( number );
                if( ctrlCode == ENUM_NUMBER_ONLY || ctrlCode == ENUM_BOTH )
                   {
                    System.out.format( "%11d", number );               
                   }
                
                if( ctrlCode == ENUM_CHARACTER_ONLY || ctrlCode == ENUM_BOTH )
                   {
                    System.out.format( "(\'%c\') ", displayChar );                
                   }
               }
            
            System.out.println();
           }
        
        System.out.println();
       }
    
    /**
     * decryptArray
     * <p>
     * Finds the tilde in the array, and tracks the elements of the array
     * to set the individual character values back into a String; 
     * list of characters ends with a caret ('^')
     * <p>
     * Dependencies: findTilde, getNextXPos, getNextYPos, getCharValue
     * 
     * @return String value containing decrypted text
     */
    public String decryptString()
       {
        // initialize method/variables
        long encodeVal;
        int yPos, xPos;
        char testChar;
        String resultStr = "";
        
        // find location of tilde
           // method: findTilde
        encodeVal = findTilde();
        
        // get y, x of next character
           // method: getNextYPos, getNextXPos
        yPos = getNextYPos( encodeVal );
        xPos = getNextXPos( encodeVal );
        
        // get value of tilde
        encodeVal = array[ yPos ][ xPos ];
        
        yPos = getNextYPos( encodeVal );
        
        xPos = getNextXPos( encodeVal );

        // get value of next location
        encodeVal = array[ yPos ][ xPos ];
        
        // get character at next element
           // method: getCharValue
        testChar = getCharValue( encodeVal );
     
        while( testChar != CARET_CHAR )
           {
            resultStr += testChar;            

            yPos = getNextYPos( encodeVal );
            
            xPos = getNextXPos( encodeVal );
            
            encodeVal = array[ yPos ][ xPos ];            

            testChar = getCharValue( encodeVal );
           }
        
        return resultStr;
       }
    
    /**
     * elementIsUsed
     * <p>
     * Returns true if element is used in the array, or if the current y position
     * is equal to the next y position and the current x position is equal to
     * the next x position
     * <p>
     * Dependencies: None
     * 
     * @param curYPos integer current y position to be tested
     * 
     * @param curXPos integer current x position to be tested
     * 
     * @param nextYPos integer next y position to be tested
     * 
     * @param nextXPos integer next x position to be tested
     * 
     * @return Boolean value indicating state of specified testing
     */
    private boolean elementIsUsed( int curYPos, 
                                       int curXPos, int nextYPos, int nextXPos )
       {
        long testVal = array[ nextYPos ][ nextXPos ];
        int usedFlag = (int)( testVal / NINE_DIGIT_OFFSET );
        boolean yPositionsEqual = curYPos == nextYPos;
        boolean xPositionsEqual = curXPos == nextXPos;
        
        return usedFlag == USED_CODE || ( xPositionsEqual && yPositionsEqual );
       }

    /**
     * encodeData
     * <p>
     * Encodes four parts of data into long value as ucccyyyxxx
     * where u is the used flag
     * ccc is the character Unicode/ASCII value
     * yyy is the y position of an element
     * xxx is the x position of an element
     * <p>
     * Dependencies: None
     * 
     * @param used integer value indicating that the value is part 
     * of the encrypted string, which is encoded into the long value
     * 
     * @param dataChar character value encoded into the long value
     * 
     * @param yPos integer value encoded into the long value
     * 
     * @param xPos integer value encoded into the long value
     * 
     * @return long value containing encoded data
     */
    public long encodeData( int used, char dataChar, int yPos, int xPos )
       {
        long result = used * THREE_DIGIT_OFFSET;
        
        result += (int)dataChar;
        
        result *= THREE_DIGIT_OFFSET;
        
        result += yPos;
        
        result *= THREE_DIGIT_OFFSET;
        
        return result + xPos;
       }
    
   /**
     * encryptString
     * <p>
     * Creates array using the input string which also fills array with random 
     * characters, then places characters randomly around the array starting 
     * with a tilde ('~') and ending with a caret ('^')
     * <p>
     * Each long value in the array holds a used marker, the character,
     * and the y and x position of the next character
     * <p>
     * Process generates a new random y, x pair for each character data element
     * but verifies that the y, x pair has not already been used; once these
     * are found, the long value is encoded with the used marker, the character,
     * and the next y, x positions, and placed into the array
     * <p>
     * Dependencies: {String}.length, {String}.charAt, createArray, 
     * getRandBetween, encodeData, elementIsUsed
     * 
     * @param toEncrypt String value to be encrypted
     */
    public void encryptString( String toEncrypt )
       {
        long encodeVal;
        int currentYPos, currentXPos;
        int nextYPos, nextXPos;        
        int strIndex, strLen;
        char postChar = TILDE_CHAR;

        toEncrypt += CARET_CHAR;
        
        strLen = toEncrypt.length();
        
        array = createArray( toEncrypt );

        currentYPos = getRandBetween( 0, sideCapacity - 1 );
        currentXPos = getRandBetween( 0, sideCapacity - 1 );

        for( strIndex = 0; strIndex < strLen; strIndex++ )
           {
            do
               {
                nextYPos = getRandBetween( 0, sideCapacity - 1 );
                
                nextXPos = getRandBetween( 0, sideCapacity - 1 );
                
                encodeVal = encodeData( USED_CODE, 
                                               postChar, nextYPos, nextXPos );
               }
            while( elementIsUsed( currentYPos, 
                                            currentXPos, nextYPos, nextXPos ) );
            
            array[ currentYPos ][ currentXPos ] = encodeVal;
            
            currentYPos = nextYPos;
            
            currentXPos = nextXPos;
            
            postChar = toEncrypt.charAt( strIndex );
           }
        
        encodeVal = encodeData( USED_CODE, postChar, currentYPos, currentXPos );
        
        array[ currentYPos ][ currentXPos ] = encodeVal;
       }
    
    /**
     * fillArray
     * <p>
     * Fills temporary array with a random value between UNUSED_CODE_LOW and 
     * UNUSED_CODE_HIGH, a random character other than tilde ('~'), and a 
     * randomly generated y and x location between RAND_LOWER_LIMIT and
     * RAND_UPPER_LIMIT 
     * <p>
     * Dependencies: getRandBetween, getRandomChar, encodeData
     * 
     * @param arrayToFill long [][] array to be filled with random data
     * 
     * @return long [][] array with specified random values
     */
    public long [][] fillArray( long [][] arrayToFill )
       {
        long encoded;
        int rowIndex, colIndex, randYPos, randXPos, randCode;
        char randChar;
        
        for( rowIndex = 0; rowIndex < sideCapacity; rowIndex++ )
           {
            for( colIndex = 0; colIndex < sideCapacity; colIndex++ )
               {
                randCode = getRandBetween( UNUSED_CODE_LOW, UNUSED_CODE_HIGH );
                
                randChar = getRandomChar();
                
                randYPos = getRandBetween( RAND_LOWER_LIMIT, RAND_UPPER_LIMIT );
                
                randXPos = getRandBetween( RAND_LOWER_LIMIT, RAND_UPPER_LIMIT );

                encoded = encodeData( randCode, randChar, randYPos, randXPos );
                
                arrayToFill[ rowIndex ][ colIndex ] = encoded;                
               }
          }

        return arrayToFill;
       }
    
    /**
     * findTilde
     * <p>
     * Finds tilde encoded in two dimensional array of long values
     * <p>
     * Dependencies: getCharValue, encodeData
     * 
     * @return long encoded value containing UNUSED_CODE_LOW, TILDE_CHAR,
     * and the y and x locations of the TILDE_CHAR
     */
    private long findTilde()
       {
        int rowIndex, colIndex;
        long result = 0;
        
        for( rowIndex = 0; rowIndex < sideCapacity; rowIndex++ )
           {
            for( colIndex = 0; colIndex < sideCapacity; colIndex++ )
               {
                if( getCharValue( array[ rowIndex ][ colIndex ] ) 
                                                                 == TILDE_CHAR )
                   {
                    result = encodeData( UNUSED_CODE_LOW, 
                                               TILDE_CHAR, rowIndex, colIndex );
                   }
               }
           }

        return result;
       }
    
    /**
     * getCharValue
     * <p>
     * decodes long integer to return character
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded character to retrieve
     * 
     * @return character retrieved
     */
    private char getCharValue( long encoded )
       {
        int charPos = (int)( encoded / SIX_DIGIT_OFFSET );
        
        return (char)( charPos % THREE_DIGIT_OFFSET );
       }
    
    /**
     * getRandBetween
     * <p>
     * Returns random value between low and high parameters, inclusive
     * <p>
     * Dependencies: Math.random
     * 
     * @param low integer value indicating low end of random range to generate
     * 
     * @param high integer value indicating high end of random range to generate
     * 
     * @return random value between low and high parameters, inclusive
     */
    public int getRandBetween( int low, int high )
       {
        int range = high - low + 1;
        
        return (int)( Math.random() * range + low );
       }

    /**
     * getRandomChar
     * <p>
     * Returns a Unicode/ASCII character from space (lowest printable character)
     * to right curly brace (highest printable character before tilde); 
     * tilde ('~') is never returned
     * <p>
     * Dependencies: getRandBetween
     * 
     * @return value containing random character
     */
    private char getRandomChar()
       {
        int randomVal;
        
        do
           {
            randomVal = getRandBetween( (int)SPACE_CHAR, 
                                                  (int)RIGHT_CURLY_BRACE_CHAR );
           }
        while( randomVal == (int)TILDE_CHAR );
        
        return (char)randomVal;
       }
    
    /**
     * getNextXPos
     * <p>
     * Returns the next x position from the encoded value
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded x location to retrieve
     * 
     * @return int x location retrieved
     */
    private int getNextXPos( long encoded )
       {
        return (int)( encoded % THREE_DIGIT_OFFSET );
       }

   /**
     * getNextYPos
     * <p>
     * Returns the y position from the encoded value
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded y location to retrieve
     * 
     * @return int y location retrieved
     */
    private int getNextYPos( long encoded )
       {
        int tempYPos = (int)( encoded / THREE_DIGIT_OFFSET );
        
        return tempYPos % THREE_DIGIT_OFFSET;
       }

   }

   
   