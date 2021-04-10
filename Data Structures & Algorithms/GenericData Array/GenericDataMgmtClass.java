package p2_package;

/**
 * Description: Class wrapper for a Java array of generic data (classes), 
 * with additional management operations
 * <p>
 * Note: Only works with class that extends Comparable, as shown 
 * in class declaration
 * <p>
 * Note: Maintains a capacity value for maximum number of items 
 * that can be stored, and a size value for the number of valid 
 * or viable data items in the array
 * 
 *  @author Michael Leverington
 * 
 */

public class GenericDataMgmtClass<GenericData extends Comparable<GenericData>>
	{
	    // constants
	    private final static int DEFAULT_CAPACITY = 10;
	    
	    // member data
	    private Object[] localArray;
	    private int arraySize, arrayCapacity;
	    
	    /**
	     * Default constructor, initializes array to default capacity (10)
	     * 
	     */
	    public GenericDataMgmtClass()
	       {
	        localArray = new Object[ DEFAULT_CAPACITY ];
	        
	        arrayCapacity = DEFAULT_CAPACITY;
	        
	        arraySize = 0;  
	       }
	    
	    /**
	     * Initializing constructor, initializes array to specified capacity
	     * 
	     * @param capacity maximum capacity specification for the array
	     * 
	     */
	    public GenericDataMgmtClass( int capacity )
	       {
	        localArray = new Object[ capacity ];
	        
	        arrayCapacity = capacity;
	        
	        arraySize = 0;  
	       }
	    
       /**
        * Accesses item in array at specified index if index 
        * within array size bounds
        * 
        * @param accessIndex index of requested element value
        * 
        * @return accessed value if successful, null if not
        */
       @SuppressWarnings( "unchecked")
       public GenericData accessItemAt( int accessIndex )
          {
           if( accessIndex >= 0 && accessIndex < arraySize )
              {
               return (GenericData)localArray[ accessIndex ];
              }
              
           return null;
          }

       /**
        * Appends item to end of array, if array is not full,
        * e.g., no more values can be added 
        * 
        * @param newValue value to be appended to array
        * 
        * @return Boolean success if appended, or failure if array was full
        */
       public boolean appendItem( GenericData newValue )
          {
           if( !isFull() )
              {
               localArray[ arraySize ] = newValue;
               
               arraySize++;
               
               return true;
              }
              
           return false;
          }

       /**
        * Clears array of all valid values by setting array size to zero,
        * values remain in array but are not accessible
        * 
        */
       public void clear()
          {
           arraySize = 0;
          }

       /**
        * Description: Gets current capacity of array
        * <p>
        * Note: capacity of array indicates number of values the array can hold
        * 
        * @return capacity of array
        */
       public int getCurrentCapacity()
          {
           return arrayCapacity;
          }

       /**
        * Description: Gets current size of array
        * <p>
        * Note: size of array indicates number of valid or viable values 
        * in the array
        * 
        * @return size of array
        */
       public int getCurrentSize()
          {
           return arraySize;
          }

       /**
        * Description: Inserts item to array at specified index if array 
        * is not full, e.g., no more values can be added
        * <p> 
        * Note: Value is inserted at given index, all data from that index 
        * to the end of the array is shifted up by one
        * 
        * @param insertIndex index of element into which value is 
        * to be inserted
        * 
        * @param newValue value to be inserted into array
        * 
        * @return Boolean success if inserted, or failure if array was full
        */
       public boolean insertData( int insertIndex, GenericData newValue )
          {
           int workingIndex;
           
           if( !isFull() && insertIndex >= 0 && insertIndex <= arraySize )
              {
               workingIndex = arraySize;
               
               while( workingIndex > insertIndex )
                  {
                   localArray[ workingIndex ] = localArray[ workingIndex - 1 ];
                   
                   workingIndex--;
                  } 
                  
               localArray[ workingIndex ] = newValue;
               
               arraySize++;
               
               return true;
              }
              
           return false;
          }

       /**
        * Tests for size of array equal to zero,
        * no valid values stored in array 
        * 
        * @return Boolean result of test for empty
        */
       public boolean isEmpty()
          {
           return arraySize == 0;
          }
          
	    /**
	     * Tests for size of array equal to capacity,
	     * no more values can be added 
	     * 
	     * @return Boolean result of test for full
	     */
	    public boolean isFull()
	       {
	        return arraySize == arrayCapacity;
	       }
	       
	    /**
	     * Description: Removes item from array at specified index if index 
	     * within array size bounds
	     * <p>
	     * Note: Each data item from the element immediately 
	     * above the remove index to the end of the array is moved down 
	     * by one element 
	     * 
	     * @param removeIndex index of element value to be removed
	     * 
	     * @return removed value if successful, null if not
	     */
       @SuppressWarnings( "unchecked")
	    public GenericData removeData( int removeIndex )
	       {
	        int workingIndex;
	        GenericData returnedItem;

	        if( removeIndex >= 0 && removeIndex < arraySize )
	           {
	            returnedItem = (GenericData)localArray[ removeIndex ];
	            
	            workingIndex = removeIndex;
	            
	            arraySize--;
	            
	            while( workingIndex < arraySize )
	               {
	                localArray[ workingIndex ] = localArray[ workingIndex + 1 ];
	                
	                workingIndex++;
	               } 
	               
	            return returnedItem;
	           }
	           
	        return null;
	       }
	       
	    /**
	     * Description: Resets array capacity, copies current size 
	     * and current size number of elements
	     * <p>
	     * Exception: Method will not resize capacity below current array capacity,
	     * returns false if this is attempted, true otherwise 
	     * 
	     * @param newCapacity new capacity to be set; must be larger 
	     * than current capacity
	     * 
	     * @return Boolean condition of resize success or failure
	     */
	    public boolean resize( int newCapacity )
	       {
	    	  Object[] newArray;
	        int workingIndex;

	        if( newCapacity > arrayCapacity )
	           {
	            newArray = new Object[ newCapacity ];
	            
	            for( workingIndex = 0; 
	                                workingIndex < arraySize; workingIndex++ )
	               {
	                newArray[ workingIndex ] = localArray[ workingIndex ];
	               } 

	            arrayCapacity = newCapacity;
	            
	            localArray = newArray;
	            
	            return true;
	           }
	           
	        return false;
	       }
	       
       /**
        * Description: Sorts elements using the bubble sort algorithm
        * <p>
        * Note: The data is sorted using the compareTo method of the given
        * data set; the compareTo method decides the key and the order
        * resulting
        * 
        */
 @SuppressWarnings( "unchecked" )
 public void runBubbleSort()
    {
     int index;
     boolean swapped = true;
     GenericData oneItem, otherItem;
     
     while( swapped )
        {
         swapped = false;
         
         for( index = 0; index < arraySize - 1; index++ )
            {
             oneItem = (GenericData)localArray[ index ];
             otherItem = (GenericData)localArray[ index + 1 ];
             
             if( oneItem.compareTo( otherItem  ) > 0 )
                {
                 swapElements( index, index + 1 );  

                 swapped = true; 
                }
             
            } // end loop across list
      
     }  // end loop while swap occurred
  
 }
          
       /**
        * Description: Sorts elements using the insertion sort algorithm
        * <p>
        * Note: The data is sorted using the compareTo method of the given
        * data set; the compareTo method decides the key and the order
        * resulting
        * 
        */
       @SuppressWarnings( "unchecked")
       public void runInsertionSort()
          {
           int listIndex, searchIndex;
           GenericData insertVal, testVal;
           boolean continueSearch;
           
           for( listIndex = 1; listIndex < arraySize; listIndex++ )
              {
               insertVal = (GenericData)localArray[ listIndex ];
               
               searchIndex = listIndex;
               
               continueSearch = true;
               
               while( continueSearch && searchIndex > 0 )
                  {
                   testVal = (GenericData)localArray[ searchIndex - 1 ];
                   
                   if( insertVal.compareTo( testVal ) < 0 )
                      {
                       localArray[ searchIndex ] 
                                                = localArray[ searchIndex - 1 ];                       

                       searchIndex--;
                      }
                   
                   else
                      {
                       continueSearch = false;
                      }
                                      
                  }  // end search loop
               
               localArray[ searchIndex ] = (Object)insertVal;
               
              }  // end list loop
          }
          
       /**
        * Description: Sorts elements using the selection sort algorithm
        * <p>
        * Note: The data is sorted using the compareTo method of the given
        * data set; the compareTo method decides the key and the order
        * resulting
        * 
        */
       @SuppressWarnings( "unchecked" )    
       public void runSelectionSort()
          {
           int listIndex, searchIndex, lowestIndex;
           GenericData lowestVal, searchVal;
           
           for( listIndex = 0; listIndex < arraySize - 1; listIndex++ )
              {
               lowestIndex = listIndex;
               
               for( searchIndex = lowestIndex + 1; 
                                     searchIndex < arraySize; searchIndex++ )
                  {
                   lowestVal = (GenericData)localArray[ lowestIndex ];
                   searchVal = (GenericData)localArray[ searchIndex ];
                   
                   if( searchVal.compareTo( lowestVal ) < 0 )
                      {
                       lowestIndex = searchIndex;
                      }
                   
                  }  // end search loop

               swapElements( lowestIndex, listIndex );
               
              }  // end list item loop
          }

       /**
        * Uses Shell's sorting algorithm to sort Generic Data
        * in an array of Objects
        * <p>
        * Shell's sorting algorithm is an optimized insertion algorithm
        */
       @SuppressWarnings( "unchecked" )
       public void runShellSort()
          {
           int gap, gapPassIndex, insertionIndex;
           GenericData tempItem, testItem;
           boolean continueSearch;
        
           for( gap = arraySize / 2; gap > 0; gap /= 2 )
              {
               for( gapPassIndex = gap; 
                                      gapPassIndex < arraySize; gapPassIndex++ )
                  {
                   tempItem = (GenericData)localArray[ gapPassIndex ];

                   insertionIndex = gapPassIndex;

                   continueSearch = true;
                   
                   while( continueSearch && insertionIndex >= gap )
                      {
                       testItem 
                              = (GenericData)localArray[ insertionIndex - gap ];
                       
                       if( testItem.compareTo( tempItem ) >  0 )
                          {
                           localArray[ insertionIndex ] 
                                           = localArray[ insertionIndex - gap ];  
                        
                           insertionIndex -= gap;
                          }
                      
                       else
                          {
                           continueSearch = false;
                          }
                       
                      }  // end search loop

                   localArray[ insertionIndex ] = tempItem;
                  }  // end list loop
           
              }  // end gap size setting loop   
       
          }
             
	    /** 
	     * Swaps one element in the local array at a given index 
	     * with another element in the array at the other given element
	     * 
	     * @param oneIndex index of one of two elements to be swapped
	     * 
	     * @param otherIndex index of second of two elements to be swapped
	     */
	    private void swapElements( int oneIndex, int otherIndex )
	       {
	        Object temp = localArray[ oneIndex ];
	        
	        localArray[ oneIndex ] = localArray[ otherIndex ];
	        
	        localArray[ otherIndex ] = temp;
	       }
	    
	}


