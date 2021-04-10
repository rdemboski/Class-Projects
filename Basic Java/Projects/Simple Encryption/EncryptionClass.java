package p8_package;

public class EncryptionClass
   {
    // console I/O instantiation
    public static Console_IO_Class conIO = new Console_IO_Class();
    
    // two end lines constant
    public static int TWO_END_LINES = 2;
    
    public static void main( String [] args )
       {
        // initialization
      
           // variables
           String keyString, toBeEncrypted, toBeDecrypted;
           char [] toEncryptArrRef, encryptedArrRef;
           char [] toDecryptArrRef, decryptedArrRef;
           int [] keyStrArrRef;
           
           // title
              // method: printString, printEndlines)
           conIO.printString( "Encryption / Decryption Program" );
           conIO.printEndlines( TWO_END_LINES );
       
        // accept first entry
      
           // provide brief description
              // method: printString, printEndline(s)
           conIO.printString( "Part one accepts a series of key integers" );
           conIO.printString( " and then a string to be encrypted." );
           conIO.printEndlines( TWO_END_LINES );
          
           // enter encryption string
              // method: promptForString
           keyString = conIO.promptForString( "Enter series of numbers: " );
          
           // enter string to be encrypted
              // method: promptForString
           toBeEncrypted = conIO.promptForString( 
                                             "Enter string to be encrypted: " );
           
        // process string
           
           // convert key string to char array
              // method: convertStringToIntArray
           keyStrArrRef = convertStringToIntArray( keyString );
           
           // convert String to char array
              // method: convertStringToCharArray
           toEncryptArrRef = convertStringToCharArray( toBeEncrypted );
           
           // encrypt the the character array
              // method: encryptString
           encryptedArrRef = encryptString( keyStrArrRef, toEncryptArrRef );
           
        // display encrypted string
           // method: displayStringWithLeader
        displayStringWithLeader( "Encrypted String: ", encryptedArrRef );
      
        // accept second entry

           // provide brief description
              // method: printString, printEndline(s)
           conIO.printEndline();
           conIO.printString( "Part two accepts a series of key integers" );
           conIO.printString( " and then a string to be decrypted." );
           conIO.printEndlines( TWO_END_LINES );
       
        // enter encryption string
           // method: promptForString
        keyString = conIO.promptForString( "Enter series of numbers: " );
       
        // enter string to be decrypted
           // method: promptForString
        toBeDecrypted = conIO.promptForString( 
                                             "Enter string to be decrypted: " );

        // process string

           // convert key string to int array
              // method: convertStringToIntArray
           keyStrArrRef = convertStringToIntArray( keyString );
     
           // convert string to char array
              // method: convertStringToCharArray
           toDecryptArrRef = convertStringToCharArray( toBeDecrypted );
                 
           // decrypt string             
              // method: decryptString
           decryptedArrRef = decryptString( keyStrArrRef, toDecryptArrRef );
           
        // display string result
           // method: displayStringWithLeader
        displayStringWithLeader( "Decrypted String: ", decryptedArrRef );
      
        // end program
           // method: printString, printEndline(s)
        conIO.printEndline();
        conIO.printString( "End Program" );
        conIO.printEndline();
       }
    
    /*
    Name: charToInt
    Process: if input character is between '0' and '9' inclusive,
             converts character to integer, otherwise makes no change
    Method Input/Parameters: input character (char)
    Method Output/Parameters: none
    Method Output/Returned: converted to integer as specified
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: none
    Notes: No ASCII values allowed (anywhere)

    */
    public static int charToInt( char testChar )
       {
        if( testChar >= '0' && testChar <= '9' )
           {
            return testChar - '0' + 0;
           }
        
        return testChar;
       }
    
    /*
    Name: convertStringToCharArray
    Process: accepts String, converts to character array
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: character array as specified (char [])
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: .length, .charAt
    Notes: utilities can't be in [] or ()    
    */
    public static char [] convertStringToCharArray( String str )
       {
        // initialize method/variables
        int index, stringLength = str.length();
        char [] charArr = new char[ stringLength ];
        
        // loop across string
        for( index = 0; index < stringLength; index++ )
           {
            // assign string character to array element
            charArr[ index ] = str.charAt( index );
           }               
        // end loop across string
        
        // return character array
        return charArr;
       }
    
    /*
    Name: convertStringToIntArray
    Process: accepts String, converts to integer array
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: integer array as specified (int [])
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: .length, .charAt, charToInt
    Notes: utilities can't be in [] or ()
    */
    public static int [] convertStringToIntArray( String str )
       {
        // initialize method/variables
        int index, stringLength = str.length();
        int [] intArr = new int[ stringLength ];
        char tempChar;
        
        // loop across string
        for( index = 0; index < stringLength; index++ )
           {
            // assign temp character from string element
            tempChar = str.charAt( index );
            
            // assign string character to array element
            intArr[ index ] = charToInt( tempChar );
           }               
        // end loop across string
        
        // return character array
        return intArr;
       }
    
    /*
    Name: decryptString
    Process: accepts key integer array and character array,
             decrypts character array
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: character array as specified (char [])
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: .length, .charAt
    Notes: utilities can't be in [] or (); no if/else
    */
    public static char [] decryptString( int [] keyArray, 
                                                         char [] toBeDecrypted )
       {
        // initialize method/variables
        int destStrIndex, srcStrIndex, keyIndex;
        int keyStrLen = keyArray.length;
        int toBeDecryptedLen = toBeDecrypted.length;
        char [] resultStr = new char[ toBeDecryptedLen ];
      
        // start loop across to be encrypted string
        for( srcStrIndex = 0, destStrIndex = 0, keyIndex = 0;
        srcStrIndex < toBeDecryptedLen; srcStrIndex++, destStrIndex++ )
           {
            // assign result str element from subtracted key 
            // and tobeDecrypted elements
            resultStr[ destStrIndex ] = (char)( toBeDecrypted[ srcStrIndex ]
                                                       - keyArray[ keyIndex ] );
      
            // update key index
            keyIndex = ( keyIndex + 1 ) % keyStrLen;
           }        
        // end loop across to be encrypted string
      
        // return array
        return resultStr;
       }

    /*
    Name: displayStringWithLeader
    Process: accepts String leader text and character array text
             displays in order
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: none
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: .length, console I/O utilities
    */
    public static void displayStringWithLeader( String leader, 
                                                        char [] outputStrArray )
       {
        // initialize method/variables
        int index, outputStrLen = outputStrArray.length;
        
        // print vertical space/divider
           // method: printEndline
        conIO.printEndline();
        
        // print leader
           // method: printString
        conIO.printString( leader );
        
        // print string

           // loop across character array
           for( index = 0; index < outputStrLen; index++ )
              {
               // output character
               conIO.printChar( outputStrArray[ index ] );
              }
           // end loop across character array
           
        // output end line
           // method: printEndline
        conIO.printEndline();       
       }
    
    /*
    Name: encryptString
    Process: accepts key integer array and character array,
             encrypts character array
    Method Input/Parameters: none
    Method Output/Parameters: none
    Method Output/Returned: character array as specified (char [])
    Device Input/Keyboard: none
    Device Output/Monitor: none
    Dependencies: .length, .charAt
    Notes: utilities can't be in [] or (); no if/else
    */
    public static char [] encryptString( int [] keyArray, 
                                                         char [] toBeEncrypted )
       {
        // initialize method/variables
        int destStrIndex, srcStrIndex, keyIndex;
        int keyStrLen = keyArray.length;
        int toBeEncryptedLen = toBeEncrypted.length;
        char [] resultStr = new char[ toBeEncryptedLen ];
        
        // start loop across to be encrypted string
        for( srcStrIndex = 0, destStrIndex = 0, keyIndex = 0;
                 srcStrIndex < toBeEncryptedLen; srcStrIndex++, destStrIndex++ )
           {
            // assign result str element from added key 
            // and tobeEncrypted elements
            resultStr[ destStrIndex ] = (char)( toBeEncrypted[ srcStrIndex ]
                                                       + keyArray[ keyIndex ] );
            
            // update key index
            keyIndex = ( keyIndex + 1 ) % keyStrLen;
           }        
        // end loop across to be encrypted string
        
        // return array
        return resultStr;
       }
    
    
   }
