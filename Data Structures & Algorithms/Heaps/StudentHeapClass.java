package p10_package;

/**
 * Array-based StudentClass max heap class used as a priority queue
 * for StudentClass data; prioritized by GPA using StudentClass compareTo
 * 
 * @author MichaelL
 */
public class StudentHeapClass
   {
    /**
     * Initial array capacity
     */
    public final int DEFAULT_ARRAY_CAPACITY = 10;
   
    /**
     * Enumerated parent flag
     */
    public final int PARENT = 1001;
   
    /**
     * Enumerated left child flag
     */
    public final int LEFT = 2002;
   
    /**
     * Enumerated right child flag
     */
    public final int RIGHT = 3003;
   
    /**
     * Array for heap
     */
    private StudentClass[] heapArray;
   
    /**
     * Management data for array
     */
    private int arraySize, arrayCapacity;
   
    /**
     * Display flag can be set to observe
     * bubble up and trickle down operations
     */
    private boolean displayFlag;
   
    /**
     * Default constructor sets up array management
     * conditions and default display flag setting
     */
    public StudentHeapClass()
      {
       heapArray = new StudentClass[ DEFAULT_ARRAY_CAPACITY ];
       
       arrayCapacity = DEFAULT_ARRAY_CAPACITY;
       
       arraySize = 0;
      
       displayFlag = false;
      }
  
    /**
     * Copy constructor copies array and array management
     * conditions and default display flag setting
     * 
     * @param copied StudentHeapClass object to be copied 
     */
    public StudentHeapClass( StudentHeapClass copied )
      {
       int index;
       
       heapArray = new StudentClass[ copied.arrayCapacity ];
       arrayCapacity = copied.arrayCapacity;
       arraySize = copied.arraySize;
      
       displayFlag = copied.displayFlag;
       
       for( index = 0; index < arraySize; index++ )
          {
           heapArray[ index ] = new StudentClass( copied.heapArray[ index ] );
          }
      }
  
    /**
     * Accepts StudentData item and adds it to heap
     * <p>
     * Note: uses bubbleUpArrayHeap to resolve unbalanced heap
     * after data addition
     * <p>
     * Note: must check for resize before attempting to add an item
     * 
     * @param newItem StudentClass data item to be added
     */
    public void addItem( StudentClass newItem )
       {
        checkForResize();
          
        if( displayFlag )
           {
            System.out.println( "\nAdding new process: " + newItem.toString() );
           }
      
        heapArray[ arraySize ] = newItem;
           
        arraySize++;
          
        bubbleUpArrayHeap( arraySize - 1 );
       }
  
    /**
     * Recursive operation to reset data in the correct
     * order for the max heap after new data addition
     * 
     * @param currentIndex index of current item being assessed,
     * and moved up as needed
     */
    private void bubbleUpArrayHeap( int currentIndex )
       {
        int parentIndex;
        StudentClass localItem, parentItem;
      
        if( currentIndex > 0 )
           {
            localItem = heapArray[ currentIndex ];
            
            parentIndex = ( currentIndex - 1 ) / 2;
            
            parentItem = heapArray[ parentIndex ];
          
            if( localItem.compareTo( parentItem ) > 0 )
               {
                if( displayFlag )
                   {
                    System.out.println( "   - Bubble up:" );
                    System.out.println( "     - Swapping parent: " 
                            + parentItem.toString() + " with child: " 
                              + localItem.toString() );
                   }
              
                heapArray[ parentIndex ] = heapArray[ currentIndex ];
                heapArray[ currentIndex ] = parentItem;

                bubbleUpArrayHeap( parentIndex );               
               }           
           }
       }

    /**
     * Automatic resize operation used prior to any new data
     * addition in the heap
     * <p>
     * Tests for full heap array, and resizes to twice the current capacity
     * as required
     */
    private void checkForResize()
       {
        StudentClass[] tempArr;
        int index;
      
        if( arraySize == arrayCapacity )
           {
            arrayCapacity *= 2;
            
            tempArr = new StudentClass[ arrayCapacity ];
          
            for( index = 0; index < arraySize; index++ )
               {
                tempArr[ index ] = heapArray[ index ];
               }
          
            heapArray = tempArr;
           }       
       }
           
    /**
     * Tests for empty heap
     * 
     * @return boolean result of test
     */
    public boolean isEmpty()
       {
        return arraySize == 0;
       }
    
    /**
     * Removes StudentClass data item from top of max heap,
     * thus being the student with the highest GPA
     * <p>
     * Note: Uses trickleDownArrayHeap to resolve unbalanced heap
     * after data removal
     * 
     * @return StudentClass item removed
     */
    public StudentClass removeItem()
       {
        StudentClass removed = null;
      
        if( arraySize > 0 )
           {
            removed = heapArray[ 0 ];
             
            if( displayFlag )
               {
                System.out.println( "\nRemoving process: " + removed );
               }
          
            arraySize--;
            
            heapArray[ 0 ] = heapArray[ arraySize ];
          
            trickleDownArrayHeap( 0 );
           }
      
        return removed;
       }
  
    /**
     * Utility method to set the display flag for displaying
     * internal operations of the heap bubble and trickle operations
     * 
     * @param setState flag used to set the state to display, or not
     */
    public void setDisplayFlag( boolean setState )
       {
        displayFlag = setState;      
       }
  
    /**
     * Dumps array to screen as is, no filtering or management
     * 
     */    
    public void showArray()
       {
        int index;
        StudentClass outputItem;
        
        for( index = 0; index < arraySize; index++ )
           {
            outputItem = heapArray[ index ];
            
            System.out.print( outputItem.toString() + " - ");
           }
        
        System.out.println();
       }

    /**
     * Recursive operation to reset data in the correct
     * order for the max heap after data removal
     * 
     * @param currentIndex index of current item being assessed,
     * and moved down as required
     */    
    private void trickleDownArrayHeap( int currentIndex )
       {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;
        int largestFlag = PARENT;
        StudentClass leftChildData = null, rightChildData = null;
        StudentClass parentData = heapArray[ currentIndex ];

        if( leftChildIndex < arraySize )
           {
            leftChildData = heapArray[ leftChildIndex ];
            
            if( leftChildData.compareTo( parentData ) > 0 )
               {
                largestFlag = LEFT;
               }
               
            if( rightChildIndex < arraySize )
               {
                rightChildData = heapArray[ rightChildIndex ];
               
                if( rightChildData.compareTo( parentData ) > 0
                           && rightChildData.compareTo( leftChildData ) > 0 )
                   {
                    largestFlag = RIGHT;
                   } 
               }
                      
            if( largestFlag != PARENT )
               {
                System.out.println( "   - Trickle down:" );
                
                System.out.print( "     - Swapping Parent: "  
                                                      + parentData.toString() );
               
                if( largestFlag == LEFT )
                   {
                    System.out.println( " with left child: " 
                                                   + leftChildData.toString() );
                    
                    heapArray[ currentIndex ] = leftChildData;
                    heapArray[ leftChildIndex ] = parentData;
                    
                    trickleDownArrayHeap( leftChildIndex );
                   }
                   
                else  // assume right child is largest
                   {
                    System.out.println( " with right child: " 
                                                  + rightChildData.toString() );
                    
                    heapArray[ currentIndex ] = rightChildData;
                    heapArray[ rightChildIndex ] = parentData;
                    
                    trickleDownArrayHeap( rightChildIndex );            
                   }
               }
           }
       }

   }
