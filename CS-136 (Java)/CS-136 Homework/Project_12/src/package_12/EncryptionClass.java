package package_12;

import java.io.*;

public class EncryptionClass extends TwoDimArrayClass
{

	public static final int	CHARACTER_DISPLAY = 5005;
	public static final int	INTEGER_DISPLAY	= 6006;
	private final int MAX_INPUT_CHARS = 256;
	private final char MINUS_SIGN = '-';
	public static final char NEWLINE_CHAR = '\n';
	public static final char UNDERSCORE_CHAR = '_';
	private final int UNPRINTABLE_CHAR_VALUE = 127;
	
	private FileReader fileIn;
	
	//constructors
	public EncryptionClass()
	{
		super();
		fileIn = null;
	}
	
	
	public EncryptionClass(int rowCap, int colCap)
	{
		super(rowCap, colCap);
		fileIn = null;
	}
	
	
	public EncryptionClass(EncryptionClass copied)
	{
		super(copied);
		fileIn = null;
	}
	
	//methods
	private boolean charInString(char testChar, String testString)
	{
		int index;
	       
        for( index = 0; index < testString.length(); index++ )
           {
            if( testChar == testString.charAt( index ) )
               {
                return true;
               }
           }
       
        return false;
	}
	
	
	public String decryptData()
	{
		int oneSideSize = getCurrentColCapacity();
	    int rowIndex, colIndex;   
	    String resultStr = "";
	    int retrievedInt;
	    boolean foundEnd = false;
	       
	    for ( rowIndex = oneSideSize - 1; rowIndex >= 0; rowIndex-- )
	       {
	        for( colIndex = oneSideSize - 1; colIndex >= 0; colIndex-- )
	           {
	            retrievedInt = accessItemAt( rowIndex,  colIndex );
	               
	            if( !foundEnd && retrievedInt != UNPRINTABLE_CHAR_VALUE )
	               {
	                resultStr += (char)retrievedInt;
	               }
	               
	            else
	               {
	                foundEnd = true;
	               }
	           }
	       }
	       
	     return resultStr;
	}
	
	
	public void displayEncryptedArray(int displayMode)
	{
		int rowIndex, colIndex;
        int oneSideSize = getCurrentColCapacity();
        int retrievedInt;
        
        if (displayMode == CHARACTER_DISPLAY)
        {
        	System.out.println( "Encrypted Array Display as Characters" );
        	//dumpTwoDimArray();
        }
        
        else if (displayMode == INTEGER_DISPLAY)
        {
        	System.out.println( "Encrypted Array Display as Integers" );
        	//dumpTwoDimArray();
        }
        
        for( rowIndex = 0; rowIndex < oneSideSize; rowIndex++ )
           {
            System.out.print( "\t");
            
            for( colIndex = 0; colIndex < oneSideSize; colIndex++ )
               {
                retrievedInt = super.accessItemAt( rowIndex,  colIndex );
                
                if (displayMode == CHARACTER_DISPLAY)
                {
                	if( retrievedInt != UNPRINTABLE_CHAR_VALUE && retrievedInt != '\n')
                    {
                     System.out.format( " %c", retrievedInt);
                    }
                 
                	else
                    {
                     System.out.print( " " + MINUS_SIGN ); 
                    }	
                }
                
                else if (displayMode == INTEGER_DISPLAY)
                {
                	if( retrievedInt != UNPRINTABLE_CHAR_VALUE)
                    {
                     System.out.format( "% 4d", retrievedInt);
                    }
                }
               }
            System.out.println();
           }
        
        System.out.println();
	}
	
	
	public void downloadData(String fileName)
	{
		FileWriter toFile;
        int outputInt;
        
        int rowIndex, colIndex, oneSideSize = getCurrentColCapacity();
       
        if( oneSideSize > 0 )
           {
            try
               {
                toFile = new FileWriter( fileName );
            
                toFile.write( "" + oneSideSize + "\r\n" );
           
                for( rowIndex = 0; rowIndex < oneSideSize; rowIndex++ )
                   {
                    for( colIndex = 0; colIndex < oneSideSize; colIndex++ )
                       {
                        outputInt = accessItemAt( rowIndex,  colIndex );
                        
                        if( outputInt < 100 )
                           {
                            toFile.write( "0" );
                           }
                        
                        toFile.write( "" + outputInt + " " );
                       }
                 
                    toFile.write( "\r\n" );
                   }

                toFile.write( "\r\n" );

                toFile.flush();
                toFile.close();
               }
       
            catch( IOException ioe )
               {
                ioe.printStackTrace();
               }
           }
	}
	
	
	public void encryptData(String toEncrypt)
	{
		int rowIndex = 0, colIndex = 0, arraySide;
        int strIndex = 0, strLength = toEncrypt.length();
        int charAsInt;
        //TwoDimArrayClass encryptedArrObject;
        
        arraySide = findIntSquareRoot( strLength + 1 );
        resize(arraySide, arraySide);
        
        //encryptedArrObject = new TwoDimArrayClass(arraySide, 
         //                                         arraySide);
        
        for( rowIndex = arraySide - 1; rowIndex >= 0; rowIndex-- )
           {
            for( colIndex = arraySide - 1; 
                                        colIndex >= 0; colIndex--, strIndex++ )
               {
                // encrypt string up to the end of it
                if( strIndex < strLength )
                   {
                    charAsInt = (int)toEncrypt.charAt( strIndex );
                    
                    super.setItemAt( rowIndex,  
                                     colIndex, charAsInt );
                   }
                
                // add unprintable character after string
                else if( strIndex == strLength )
                   {
                      super.setItemAt( rowIndex,  
                                       colIndex, UNPRINTABLE_CHAR_VALUE );
                   }
                
                // fill in all other elements with random characters/integers
                else
                   {
                    charAsInt = getRandomCharValue();
                    
                    super.setItemAt( rowIndex,  
                                     colIndex, charAsInt );
                   }
               }
           }
	}
	
	
	private int findIntSquareRoot(int value)
	{
		final double PRECISION = 0.000001;
        double lowVal = 0, highVal = value;
        double resultVal = ( lowVal + highVal ) / 2;
        double testSquare = resultVal * resultVal;
        
        while( Math.abs( value - testSquare ) > PRECISION )
           {
            if( testSquare > value )
               {
                highVal = resultVal;
               }
            
            else
               {
                lowVal = resultVal;
               }
            
            resultVal = ( lowVal + highVal ) / 2;
            testSquare = resultVal * resultVal;
           }
        
        return (int)( resultVal + 1 ); 
	}
	
	
	private int getAnInt(int maxLength)
	{
		int inCharInt;
        int index = 0;
        String strBuffer = "";
        int intValue;
        boolean negativeFlag = false;

        try
           {
            inCharInt = fileIn.read();

            // clear space up to number
            while( index < maxLength && !charInString( (char)inCharInt, 
                                                              "0123456789+-" ) )
               {
                inCharInt = fileIn.read();
               
                index++;
               }
           
            if( inCharInt == MINUS_SIGN )
               {
                negativeFlag = true;
               
                inCharInt = fileIn.read();
               }

            while( charInString( (char)inCharInt, "0123456789" ) )
               {   
                strBuffer += (char)( inCharInt );

                index++;
               
                inCharInt = fileIn.read();
               }            
           }
       
        catch( IOException ioe )
           {
            System.out.println( "INPUT ERROR: Failure to capture character" );
          
            strBuffer = "";
           }
          
        if( strBuffer.length() > 0 )
           {
            intValue = Integer.parseInt( strBuffer );
           }
        
        else
           {
            return 0;
           }
        
        if( negativeFlag )
           {
            intValue *= -1;
           }
       
        return intValue;
	}
	
	
	private int getRandomCharValue()
	{
		final int LOWEST_PRINTABLE_CHAR_VALUE = (int)( 'a' );
        final int HIGHEST_PRINTABLE_CHAR_VALUE = (int)( 'z' );
        int range = HIGHEST_PRINTABLE_CHAR_VALUE 
                                              - LOWEST_PRINTABLE_CHAR_VALUE + 1;
        
        int randVal = (int)( Math.random() * range );
       
        return randVal + LOWEST_PRINTABLE_CHAR_VALUE;
	}
	
	
	public TwoDimArrayClass uploadData(String fileName)
	{
		int rowIndex, colIndex;
        int tempInput, arrSide = 0;
        TwoDimArrayClass inputArray = null;
        
        try
           {
            // Open FileReader 
            fileIn = new FileReader( fileName );
        
            // get side length
            arrSide = getAnInt( MAX_INPUT_CHARS );           
      
            if( arrSide > 0 )
               { 
                inputArray = new TwoDimArrayClass(arrSide, arrSide);
            
                for( rowIndex = 0; rowIndex < arrSide; rowIndex++ )
                   {
                    for( colIndex = 0; colIndex < arrSide; colIndex++ )
                       {
                        tempInput = getAnInt( MAX_INPUT_CHARS );
                        
                        super.setItemAt( rowIndex,  colIndex, tempInput );                                                  
                       }
                   }
               }
            
            else
               {
                inputArray = null;
               }
            
            fileIn.close();
           }
      
        // for opening file
        catch( FileNotFoundException fnfe )
           {
            fnfe.printStackTrace();
           }
        
        // for closing file
        catch (IOException ioe)
           {
            ioe.printStackTrace();
           }
        
        return inputArray;
       }
	}

