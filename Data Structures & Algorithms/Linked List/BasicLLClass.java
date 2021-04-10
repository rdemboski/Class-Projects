package p7_package;


/**
 * Description: Class wrapper for a Java array, 
 * with management operations
 * 
 *  @author Michael Leverington
 * 
 */
public class BasicLLClass
   {
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
     * Member - linked list node
     */
    private class BasicNode
       {
        int value;
        
        BasicNode nextRef;
        
        public BasicNode( int newVal )
           {
            value = newVal;
            
            nextRef = null;
           }
        
        public BasicNode( BasicNode copied )
           {
            value = copied.value;
            
            nextRef = null;
           }
       }
    
    /**
     * Member - head reference
     */
    BasicNode headRef;
    
    /**
      * Default constructor, initializes array to default capacity
      * 
      */
     public BasicLLClass()
        {
         headRef = null;
        }
          
    /**
      * Copy constructor, initializes array to size and capacity of copied array, 
      * then copies only the elements up to the given size
      * 
      * @param copied BasicArrayClass object to be copied
      */
    public BasicLLClass( BasicLLClass copied )
       {
        BasicNode cpdWkgRef, lclWkgRef;
        
        if( copied.headRef != null )
           {
            cpdWkgRef = copied.headRef;
            
            lclWkgRef = new BasicNode( copied.headRef );
            
            cpdWkgRef = cpdWkgRef.nextRef;
            
            while( cpdWkgRef != null )
               {
                lclWkgRef.nextRef = new BasicNode( cpdWkgRef );
                
                lclWkgRef = lclWkgRef.nextRef;
                
                cpdWkgRef = cpdWkgRef.nextRef;
               }
           }
        
        else
           {
            headRef = null;
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
        int returnedItem;
        BasicNode locationRef = getRefAtIndex( headRef, index );
        BasicNode priorRef = getRefAtIndex( headRef, index - 1 );
        
        if( locationRef != null )
           {
            returnedItem = locationRef.value;
  
            if( controlCode == REMOVE )
               {
                if( priorRef != null )
                   {
                    priorRef.nextRef = locationRef.nextRef;                   
                   }
                 
                else
                   {
                    headRef = headRef.nextRef;
                   }
               }
            
            return returnedItem;
           }
                
        return FAILED_ACCESS;
       }
    
    /**
     * Clears array of all valid values by setting array size to zero,
     * values remain in array but are not accessible
     * 
     */
    public void clear()
       {
        headRef = null;
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
    public int getAtIndex( int accessIndex )
       {
        return accessAtIndex( RETRIEVE, accessIndex );
       }

    /**
     * Description: Gets current size of array
     * <p>
     * Note: size of array indicates number of valid or viable values 
     * in the array
     * 
     * @return integer size of array
     */
    public int getCurrentSize()
       {
        return getCurrentSizeHelper( headRef );
       }

    /**
     * Description: Gets current size of array
     * <p>
     * Note: size of array indicates number of valid or viable values 
     * in the array
     * 
     * @param wkgRef BasicNode reference starts with head reference
     * and is used for recursion
     * 
     * @return integer size of array
     */
    private int getCurrentSizeHelper( BasicNode wkgRef )
       {
        if( wkgRef != null )
           {
            return 1 + getCurrentSizeHelper( wkgRef.nextRef );
           }
        
        return 0;
       }

    /**
     * Gets reference for pseudo index using recursive process
     * 
     * @param wkgRef BasicNode reference
     * 
     * @param index integer index for pseudo element requested
     * 
     * @return BasicNode reference to element at pseudo index
     */
    private BasicNode getRefAtIndex( BasicNode wkgRef, int index )
       {
        if( index < 0 )
           {
            return null;
           }
        
        if( index > 0 && wkgRef != null )
           {
            return getRefAtIndex( wkgRef.nextRef, index - 1 );
           }
        
        return wkgRef;
       }
    
    /**
      * Tests for size of array equal to zero,
      * no valid values stored in array 
      * 
      * @return Boolean result of test for empty
      */
    public boolean isEmpty()
       {
        return headRef == null;
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
    public int removeAtIndex( int removeIndex )
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
    public boolean setAtIndex( int setIndex, int newValue, int replaceFlag )
       {
        int currentSize = getCurrentSize();
        Boolean returnBool = false;
        BasicNode wkgRef = getRefAtIndex( headRef, setIndex );
        BasicNode priorRef = getRefAtIndex( headRef, setIndex - 1 );
        
        BasicNode newNode = new BasicNode( newValue );

        if( replaceFlag == INSERT_BEFORE || replaceFlag == INSERT_AFTER )
           {
            if( isEmpty() && setIndex == 0 )
               {
                headRef = newNode;

                returnBool = true;
               }

            else if( wkgRef != null )
               {
                if( replaceFlag == INSERT_AFTER )
                   {
                    newNode.nextRef = wkgRef.nextRef;
                    
                    wkgRef.nextRef = newNode;
                   }

                // insert before in list
                else if( priorRef != null)
                   {
                    newNode.nextRef = priorRef.nextRef;
                    
                    priorRef.nextRef = newNode;
                   }
                
                // insert before at head of list
                else
                   {
                    newNode.nextRef = headRef;
                    
                    headRef = newNode;
                   }

                returnBool = true;                
               }
           }

        else if( replaceFlag == REPLACE && setIndex >= 0 
                                                    && setIndex < currentSize )
           {
            wkgRef.value = newValue;
            
            returnBool = true;
           }

        return returnBool;
       }

   }
