package p1_package;

/**
 * Class for managing sets of integers,
 * has capacity to generate various sets
 * 
 * @author MichaelL
 *
 */
public class SetClass 
   {
    /**
     * constant with default array capacity
     */
    public static final int DEFAULT_ARRAY_CAPACITY = 10;
    
    /**
     * integer array for data
     */
    int[] setArray;
    
    /**
     * capacity of array
     */
    int arrayCapacity;
    
    /**
     * number of values in array
     */
    int arraySize;
    
    /**
     * constants for specifying set data
     */
    public static final int INCREMENTED = 101;
    public static final int ODD = 102;
    public static final int EVEN = 103;
    public static final int PRIME = 104;
    
    /**
     * Default constructor
     * <p>
     * Initializes set array but sets power set array to null
     */
    public SetClass()
       {
        setArray = new int[ DEFAULT_ARRAY_CAPACITY ];
        
        arrayCapacity = DEFAULT_ARRAY_CAPACITY;
        
        arraySize = 0;
       }

    /**
     * Initialization constructor
     * <p>
     * Allows specification of set array capacity
     * <p>
     * Initializes set array but sets power set array to null
     * 
     * @param initialCapacity integer that specifies array capacity
     */
    public SetClass( int initialCapacity )
       {
        setArray = new int[ initialCapacity ];
        
        arrayCapacity = initialCapacity;
        
        arraySize = 0;
       }

    /**
     * Copy constructor
     * <p>
     * Duplicates copied set class
     * <p>
     * Also responsible for correct initialization/update 
     * of power set array
     * 
     * @param copied SetClass object to be copied
     */
    public SetClass( SetClass copied)
       {
        int index;
        
        setArray = new int[ copied.arraySize  ];

        arrayCapacity = copied.arrayCapacity;
                
        arraySize = copied.arraySize;
        
        for( index = 0; index < arraySize; index++ )
           {
            setArray[ index ] = copied.setArray[ index ];
           }

       }

    /**
     * Adds integer to set
     * <p>
     * increases capacity using checkForResize if array is full
     * <p>
     * does not allow duplicate values in set
     * 
     * @param item integer value to be added to set
     */
    public void addItem( int item )
       {
        checkForResize();
        
        if( !hasElement( item ) )
           {
            setArray[ arraySize ] = item;
        
            arraySize++;
           }
       }

    /**
     * Local function tests for resize of the set array
     * <p>
     * If array needs to be resized, array capacity is doubled;
     * otherwise, no change
     * 
     * @return boolean report that resize was conducted
     */
    private boolean checkForResize()
       {
        int index;
        int[] tempArray;
        
        if( arraySize == arrayCapacity )
           {
            arrayCapacity *= 2;
            
            tempArray = new int[ arrayCapacity ];
            
            for( index = 0; index < arraySize; index++ )
               {
                tempArray[ index ] = setArray[ index ];
               }
            
            setArray = tempArray;
            
            return true;
           }
        
        return false;
       }
    
    /**
     * Returns the intersection of THIS set and the given other set
     * 
     * @param other SetClass data with which intersection is found
     * 
     * @return SetClass object with intersection of two sets
     */
    public SetClass findIntersection( SetClass other )
       {
        int index;
        SetClass intersectionSet = new SetClass();
        
        for( index = 0; index < arraySize; index++ )
           {
            if( other.hasElement( setArray[ index ] ) )
               {
                intersectionSet.addItem( setArray[ index ] );
               }
           }
        
        return intersectionSet;
       }
    
    /**
     * Returns the union of THIS set and the given other set
     * 
     * @param other SetClass data with which union is found
     * 
     * @return SetClass object with union of two sets
     */
    public SetClass findUnion( SetClass other )
       {
        int otherIndex;

        SetClass unionSet = new SetClass( this );
        
        for( otherIndex = 0; otherIndex < other.arraySize; otherIndex++ )
           {
            unionSet.addItem( other.setArray[ otherIndex ] );
           }
        
        return unionSet;
       }
    
    /**
     * Finds relative complement of THIS set in given other set
     * <p>
     * Returns other set having removed any items intersecting 
     * with THIS set
     * 
     * @param other SetClass object from which THIS SetClass items 
     * will be removed
     * 
     * @return SetClass object with data as specified
     */
    public SetClass findRelativeComplementOfThisSetIn( SetClass other )
       {
        int index;
        SetClass relCompSetClass = new SetClass( other );
        
        for( index = 0; index < arraySize; index++ )
           {
            if( relCompSetClass.hasElement( setArray[ index] ) )
               {
                relCompSetClass.removeValue( setArray[ index ] );
               }
           }
        
        return relCompSetClass;
       }
    
    /**
     * Seeks and finds prime starting at given value
     * 
     * @param value integer value to start search for prime
     * 
     * @return next prime number
     */
    private int getNextPrime( int value )
       {
        while( !isPrime( value ) )
           {
            value++;
           }
                
        return value;
       }
    
    /**
     * Tests to indicate if integer value is one
     * of the set elements
     * 
     * @param testElement integer element to be found in set
     * 
     * @return boolean result of test
     */
    public boolean hasElement( int testElement )
       {
        int index;
        
        for( index = 0; index < arraySize; index++ )
           {
            if( setArray[ index ] == testElement )
               {
                return true;
               }
           }
        
        return false;
       }
    
    /**
     * Tests for even, reports
     * 
     * @param value integer value to be tested
     * 
     * @return boolean result as specified
     */
    private boolean isEven( int value )
       {
        return ( value % 2 == 0 );
       }
    
    /**
     * Tests to indicate if given integer value is prime
     * 
     * @param testVal integer value given
     * 
     * @return boolean result of test
     */
    private boolean isPrime( int testVal )
       {
        int modVal = 2;
        int testDivide = (int)( Math.ceil( Math.sqrt( (double)testVal ) ) );
        
        while( modVal <= testDivide ) 
           {
            if( testVal % modVal == 0 )
               {
                return false;
               }
            
            modVal++;
           }
        
        return true;
       }
    
    /**
     * Tests to indicate if set is subclass of another given set
     * 
     * @param other SetClass object to be tested
     * if THIS set is a subset of it
     * 
     * @return boolean result of test
     */
    public boolean isSubsetOf( SetClass other )
       {
        int localIndex, otherIndex;
        boolean found;
        
        for( localIndex = 0; localIndex < arraySize; localIndex++ )
           {
            found = false;
            
            for( otherIndex = 0; otherIndex < other.arraySize; otherIndex++ )
               {
                if( setArray[ localIndex ] == other.setArray[ otherIndex ] )
                   {
                    found = true;
                   }
               }
            
            if( !found )
               {
                return false;
               }
           }
        
        return true;
       }
    
    /**
     * Loads a number of specified integers to set
     * <p>
     * Characteristics may be odd, even, incremented, or prime
     * <p> 
     * Parameter four is only used with INCREMENTED
     * 
     * @param startValue integer value indicates starting value
     * 
     * @param numItems integer number of items to load
     * 
     * @param valueCharacteristic integer characteristic code 
     * (ODD, EVEN, INCREMENTED, PRIME )
     * 
     * @param incrementBy integer value used to specify increment
     * if INCREMENTED characteristic is set
     */
    public void loadItems( int startValue, int numItems, 
                                   int valueCharacteristic, int incrementBy )
       {
        int index, runningValue = startValue;
        
        if( valueCharacteristic == ODD || valueCharacteristic == EVEN )
           {
            if( valueCharacteristic == ODD && isEven( runningValue ) 
                || valueCharacteristic == EVEN && !isEven( runningValue ) )
               {
                runningValue++;
               }
            
            for( index = 0; index < numItems; index++ )
               {
                addItem( runningValue );
                
                runningValue += 2;
               }
           }
        
        else if( valueCharacteristic == PRIME )
           {
            // decrement by one for the first iteration
            runningValue--;
            
            for( index = 0; index < numItems; index++ )
               {
                runningValue = getNextPrime( runningValue + 1 );
                
                addItem( runningValue );
               }
           }
        
        else  // assume incremented
           {
           for( index = 0; index < numItems; index++ )
              {
               addItem( runningValue );
               
               runningValue += incrementBy;
              }
           }
       }

    /**
     * Removes value at given index;
     * moves all succeeding data down in array
     * 
     * @param indexToRemove integer index of element value to remove
     */
    private void removeAtIndex( int indexToRemove )
       {
        int index;
        
        arraySize--;
        
        for( index = indexToRemove; index < arraySize; index++ )
           {
            setArray[ index ] = setArray[ index + 1 ];
           }
       }    
    
    /**
     * Removes value if it is found in set
     * 
     * @param valToRemove integer value to be removed
     * 
     * @return boolean result of operation success
     */
    public boolean removeValue( int valToRemove )
       {
        int index;
        boolean found = false;
        
        for( index = 0; index < arraySize; index++ )
           {
            if( setArray[ index ] == valToRemove )
               {
                removeAtIndex( index );
                
                found = true;
               }
           }
        
        return found;
       }
    
    /**
     * Provides list of set array elements
     * as comma-delimited string
     */
    @Override
    public String toString()
       {
        int index;
        String outString = "";
        
        for( index = 0; index < arraySize; index++ )
           {
            if( index > 0 )
               {
                outString += ", ";
               }
            
            outString += setArray[ index ];
           }
        
        return outString;        
       }
    
   }

    