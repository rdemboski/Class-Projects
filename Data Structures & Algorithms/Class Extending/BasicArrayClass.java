package p6_package;

/**
 * Description: Class wrapper for a Java array, 
 * with management operations
 * 
 *  @author Michael Leverington
 * 
 */
public class BasicArrayClass
   {
    /**
     * Default constant capacity
     */
    private static final int DEFAULT_CAPACITY = 10;
    
    /**
     * Default failed access constant
     */
    public final static int FAILED_ACCESS = -999999;
          
    /**
     * Constant used for allowing setAtIndex to replace value at index
     */
    public final static int REPLACE = 1001;
    
    /**
     * Constant used for allowing setAtIndex to insert value at index
     */
    public final static int INSERT_BEFORE = 1002;
    
    /**
     * Constant used for allowing setAtIndex to insert value at index
     */
    public final static int INSERT_AFTER = 1003;
    
    /**
     * Constant used for allowing accessAtIndex to remove an item
     */
    public final static int REMOVE = 1004;
    
    /**
     * Constant used for allowing accessAtIndex to retrieve an item
     */
    public final static int RETRIEVE = 1005;
    
    /**
     * Member - integer array
     */
    private int[] localArray;
    
    /**
     * Member data
     */
    private int arraySize, arrayCapacity;
          
    /**
      * Default constructor, initializes array to default capacity
      * 
      */
     protected BasicArrayClass()
        {
         localArray = new int[ DEFAULT_CAPACITY ];
              
         arrayCapacity = DEFAULT_CAPACITY;
              
         arraySize = 0;  
        }
          
    /**
      * Initializing constructor, initializes array to specified capacity
      * 
      * @param capacity integer maximum capacity specification for the array
      * 
      */
    protected BasicArrayClass( int capacity )
       {
        if( capacity < DEFAULT_CAPACITY )
           {
            capacity = DEFAULT_CAPACITY;
           }
        
        localArray = new int[ capacity ];
              
        arrayCapacity = capacity;
              
        arraySize = 0;  
       }
          
    /**
      * Copy constructor, initializes array to size and capacity of copied array, 
      * then copies only the elements up to the given size
      * 
      * @param copied BasicArrayClass object to be copied
      */
    protected BasicArrayClass( BasicArrayClass copied )
       {
        int index;
              
        this.arrayCapacity = copied.arrayCapacity;
              
        this.arraySize = copied.arraySize;
        
        this.localArray = new int[ this.arrayCapacity ];
             
        for( index = 0; index < arraySize; index++ )
           {
            this.localArray[ index ] = copied.localArray[ index ];
           }   
       }
          
    /**
     * Utility method used by getAtIndex and removeAtIndex to access
     * and possibly remove element depending on control code
     * <p>
     * Note: Uses only one loop
     * 
     * @param controlCode integer value with either RETRIEVE or REMOVE
     * to control operations
     * 
     * @param index integer index of element to be retrieved or removed
     * 
     * @return integer value at element or FAILED_ACCESS if attempt to 
     * access data out of bounds
     */
    private int accessAtIndex( int controlCode, int index )
       {
        int workingIndex, returnedItem;

        if( index >= 0 && index < arraySize )
           {
            returnedItem = localArray[ index ];
  
            if( controlCode == REMOVE )
               {
                workingIndex = index;
                 
                arraySize--;
                  
                while( workingIndex < arraySize )
                   {
                    localArray[ workingIndex ] = localArray[ workingIndex + 1 ];
                     
                    workingIndex++;
                   } 
               }
            
            return returnedItem;
           }
                
        return FAILED_ACCESS;
       }
    
    /**
     * Description: Checks for need to resize; if this is necessary,
     * creates new array with double the original capacity,
     * loads data from original array to new one,
     * then sets localArray to new array
     * 
     */
    protected void checkForResize()
       {
        int[] newArray;
        int workingIndex;

        if( arraySize == arrayCapacity )
           {
            arrayCapacity *= 2;
           
            newArray = new int[ arrayCapacity ];
                 
            for( workingIndex = 0; workingIndex < arraySize; workingIndex++ )
               {
                newArray[ workingIndex ] = localArray[ workingIndex ];
               } 

            localArray = newArray;
           }
       }
            
    /**
     * Clears array of all valid values by setting array size to zero,
     * values remain in array but are not accessible
     * 
     */
    protected void clear()
       {
        arraySize = 0;
       }
    
    /**
     * Accesses item in array at specified index if index 
     * within array size bounds
     * <p>
     * Note: Calls accessAtIndex with RETRIEVE to conduct action
     *  
     * @param accessIndex integer index of requested element value
     * 
     * @return integer accessed value if successful, FAILED_ACCESS if not
     */
    protected int getAtIndex( int accessIndex )
       {
        return accessAtIndex( RETRIEVE, accessIndex );
       }

   /**
    * Description: Gets current capacity of array
    * <p>
    * Note: capacity of array indicates number of values the array can hold
    * 
    * @return integer capacity of array
    */
   protected int getCurrentCapacity()
      {
       return arrayCapacity;
      }

    /**
     * Description: Gets current size of array
     * <p>
     * Note: size of array indicates number of valid or viable values 
     * in the array
     * 
     * @return integer size of array
     */
    protected int getCurrentSize()
       {
        return arraySize;
       }

    /**
      * Tests for size of array equal to zero,
      * no valid values stored in array 
      * 
      * @return Boolean result of test for empty
      */
    protected boolean isEmpty()
       {
        return arraySize == 0;
       }
             
    /**
     * Description: Removes item from array at specified index 
     * if index within array size bounds
     * <p>
     * Note: Each data item from the element immediately above the remove index 
     * to the end of the array is moved down by one element 
     * <p>
     * Note: Must call accessAtIndex with REMOVE to conduct action
     * 
     * @param removeIndex integer index of element value to be removed
     * 
     * @return removed integer value if successful, FAILED_ACCESS if not
     */
    protected int removeAtIndex( int removeIndex )
       {
        return accessAtIndex( REMOVE, removeIndex );
       }
     
    /**
      * Description: sets item in array at specified index
      * <p> 
      * Note: If constant REPLACE is used, new value overwrites value
      * at given index
      * <p>
      * Note: If constant INSERT_BEFORE is used, new value is inserted prior
      * to the value at the given index moving all other elements up by one
      * <p>
      * Note: If constant INSERT_AFTER is used, new value is inserted after
      * the value at the given index moving all other elements up by one
      * <p>
      * Note: If either constant INSERT_BEFORE or INSERT_AFTER is used
      * with index zero and an empty array, new value is inserted
      * at index zero
      * <p>
      * Note: Method checks for available array capacity and adjusts it
      * as needed prior to inserting new item
      * <p>
      * Note: Method must also check for correct array boundaries depending 
      * upon INSERT/REPLACE state
      * 
      * @param setIndex integer index of element at which value is 
      * to be inserted
      * 
      * @param newValue integer value to be placed in array
      * 
      * @param replaceFlag integer flag to indicate insertion or replacement
      * in the array
      * 
      * @return Boolean success if inserted, or failure if incorrect index
      * was used
      */
    protected boolean setAtIndex( int setIndex, int newValue, int replaceFlag )
       {
        int workingIndex;
        Boolean returnBool = false;

        if( replaceFlag == INSERT_BEFORE || replaceFlag == INSERT_AFTER )
           {
            if( isEmpty() && setIndex == 0 )
               {
                localArray[ setIndex ] = newValue;

                arraySize++;

                returnBool = true;
               }

            else if( setIndex >= 0 && setIndex < arraySize )
               {
                if( replaceFlag == INSERT_AFTER )
                   {
                    setIndex++;
                   }

                checkForResize();              

                workingIndex = arraySize;

                while( workingIndex > setIndex )
                   {
                    localArray[ workingIndex ] 
                                            = localArray[ workingIndex - 1 ];

                    workingIndex--;
                   }

                localArray[ workingIndex ] = newValue;

                arraySize++;

                returnBool = true;                
               }
           }

        else if( replaceFlag == REPLACE && setIndex >= 0 
                                                    && setIndex < arraySize )
           {
            localArray[ setIndex ] = newValue;
            
            returnBool = true;
           }

        return returnBool;
       }

   }
