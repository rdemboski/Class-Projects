package p9_project;

/**
 * BinaryAdderClass allows values to be converted to binary values in an array
 * and then added
 * <p>
 * Note that the Least Significant Digit is always at index 0
 * 
 * @author MichaelL
 *
 */
public class BinaryAdderClass
   {
    /**
     * Constant default capacity
     * <p>
     * Will handle values less than 1 quadrillion
     * 
     */
    private final int DEFAULT_CAPACITY = 50;
    
    /**
     * constant character for space
     * <p>
     * Note: Set as character, not as integer
     */
    private final char SPACE = ' ';
    
    /**
     * Base two constant, for use in operations
     */
    private final int BASE_TWO = 2;
    
    /**
     *  binary array
     */
    private int [] bitArray;
    
    /**
     *  number of valid bits
     */
    int numBits;
    
    /**
     * Default constructor
     * 
     * Creates empty array and sets number of bits to zero
     */
    public BinaryAdderClass()
       {
        bitArray = new int[ DEFAULT_CAPACITY ];
        
        numBits = 0;
       }
    
    /**
     * Initialization constructor
     * 
     * Sets array with binary values in array along
     * with the number of valid binary digits (i.e., bits)
     * <p>
     * Note: Uses convertToBinary to set both
     * the array and the number of bits
     *
     * @param decimalValue integer value to be converted to binary
     * 
     */
    public BinaryAdderClass( int decimalValue )
       {
        // converts data to binary
        // sets both the array and the number of bits
        bitArray = convertToBinary( decimalValue );
       }
    
    /**
     * Copy constructor
     * 
     * Copies another BinaryAdderClass object into this one
     * 
     * @param copied BinaryAdderClass object to be copied into this object
     */
    public BinaryAdderClass( BinaryAdderClass copied )
       {
        int index;
        
        bitArray = new int[ DEFAULT_CAPACITY ];
        
        numBits = copied.numBits;
        
        for( index = 0; index < numBits; index++ )
           {
            bitArray[ index ] = copied.bitArray[ index ];
           }
       }

    /**
     * Add value to this object using decimal value input
     * 
     * Note: Creates temporary BinaryAdderClass object, then adds to this object
     * 
     * @param decimalValue integer value to be converted into BinaryAdderClass
     * object and then added to this object
     */
    public void addValue( int decimalValue )
       {
        BinaryAdderClass tempAddend = new BinaryAdderClass( decimalValue );
        
        addValue( tempAddend );
       }
    
    /**
     * Add value to this object using other object
     * 
     * @param addend BinaryAdderClass object to be added to this object
     */
    public void addValue( BinaryAdderClass addend )
       {
        int [] tempSum = new int[ DEFAULT_CAPACITY ];
        int index = 0;
        int bitSum, carry = 0;
        int maxBits = findMax( addend.numBits, this.numBits );
        
        while( index < maxBits )
           {
            bitSum = carry;
            
            if( index < addend.numBits )
               {
                bitSum += addend.bitArray[ index ];
               }
            
            if( index < this.numBits )
               {
                bitSum += this.bitArray[ index ];
               }
            
            tempSum[ index ] = bitSum % BASE_TWO;
            
            carry = bitSum / BASE_TWO;
            
            index++;
           }
        
        if( carry > 0 )
           {
            tempSum[ index ] = 1;
            
            index++;
           }
        
        bitArray = tempSum;
        
        numBits = index;
       }

    /**
     * convertToBinary
     * <p>
     * Note: Does not initialize bitArray here
     * 
     * @param decimalValue integer value to be converted to binary
     * 
     * @return integer array result of conversion to binary
     */
    private int [] convertToBinary( int decimalValue )
       {
        int index = 0;
        int [] tempArray = new int[ DEFAULT_CAPACITY ]; 
        
        while( decimalValue > 0 )
           {
            tempArray[ index ] = decimalValue % BASE_TWO;
            
            decimalValue /= BASE_TWO;
            
            index++;
           }
        
        numBits = index;
        
        return tempArray;
       }
    
    /**
     * display in block - right justifies array
     * 
     * @param blockSize integer size of block to create
     */
    public void displayBits( int blockSize )
       {
        int index;
        int preSpaces = blockSize - numBits;
        
        displayChars( preSpaces, SPACE );
        
        for( index = numBits - 1; index >= 0; index-- )
           {
            System.out.print( bitArray[ index ] );
           }
        
        System.out.println();
       }

    /**
     * display characters, using recursive printing strategy
     * 
     * @param numChars integer number of characters to print
     * 
     * @param outChar character to be output
     * 
     */
    public void displayChars( int numChars, char outChar )
       {
        if( numChars > 0 )
           {
            System.out.print( outChar );
            
            displayChars( numChars - 1, outChar );
           }
       }
    
    /**
     * Finds maximum of two values
     * 
     * @param valOne integer value to be compared to valOther
     * 
     * @param valOther integer value to be compared to valOne
     * 
     * @return integer value that is largest of the two
     */
    private int findMax( int valOne, int valOther )
       {
        if( valOne > valOther )
           {
            return valOne;
           }
        
        return valOther;
       }
    
    /**
     * toString, overrides Object version
     * 
     * @return String representation of array bits
     */
    @Override
    public String toString()
       {
        int index;
        String resultStr = "";
        
        for( index = numBits - 1; index >= 0; index-- )
           {
            resultStr += bitArray[ index ];
           }
        
        return resultStr; 
       }
   }
