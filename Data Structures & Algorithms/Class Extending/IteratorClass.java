package p6_package;

/**
 * Iterator class inherited from BasicArrayClass;
 * conducts iterator operations
 * 
 * @author Michael Leverington
 *
 */
public class IteratorClass extends BasicArrayClass
   {
    /**
     * Constant character for display
     */
    private final char SPACE = ' ';
    
    /**
     * Constant character for display
     */
    private final char LEFT_BRACKET = '[';
    
    /**
     * Constant character for display
     */
    private final char RIGHT_BRACKET = ']';
    
    /**
     * Current index of iterator
     */
    private int currentIndex;
    
    /**
     * Default constructor for IteratorClass
     * 
     */
    public IteratorClass()
       {
        super();
        
        currentIndex = -1;
       }
    
    /**
     * Initialization constructor for IteratorClass
     * 
     * @param initCapacity integer value at which to set initial array capacity
     */
    public IteratorClass( int initCapacity )
       {
        super( initCapacity );
        
        currentIndex = -1;
       }
    
    /**
     * Copy constructor for IteratorClass
     * 
     * @param copied IteratorClass object to be copied
     */
    public IteratorClass( IteratorClass copied )
       {
        super( copied );
        
        currentIndex = copied.currentIndex;
       }
    
    /**
     * Clears array
     */
    public void clear()
       {
        super.clear();
        
        currentIndex = -1;
       }
    
    /**
     * Gets value at iterator cursor location
     * 
     * @return integer value returned; FAILED_ACCESS if not found
     */
    public int getAtCurrent()
       {
        return getAtIndex( currentIndex );
       }
    
    /**
     * Reports if iterator cursor is at first element
     * <p>
     * Must consider whether list is empty
     *  
     * @return Boolean result of action; true if at beginning, false otherwise
     */
    public boolean isAtFirstElement()
       {
        return !isEmpty() && currentIndex == 0;
       }
    
    /**
     * Reports if iterator cursor is at last element
     * <p>
     * Must consider whether list is empty
     *  
     * @return Boolean result of action; true if at end, false otherwise
     */
    public boolean isAtLastElement()
       {
        return !isEmpty() && currentIndex == getCurrentSize() - 1;
       }
    
    /**
     * Reports if list is empty
     *  
     * @return Boolean result of action; true if empty, false otherwise
     */
    public boolean isEmpty()
       {
        return super.isEmpty();
       }
    
    /**
     * If possible, moves iterator cursor one position to the right, or next
     * <p>
     * Must consider whether list is empty
     *  
     * @return Boolean result of action; true if successful, false otherwise
     */
    public boolean moveNext()
       {
        if( !isEmpty() && !isAtLastElement() )
           {
            currentIndex++;
            
            return true;
           }
        
        return false;
       }

    /**
     * If possible, moves iterator cursor one position to the left, or previous
     * <p>
     * Must consider whether list is empty
     *  
     * @return Boolean result of action; true if successful, false otherwise
     */
    public boolean movePrev()
       {
        if( !isEmpty() && !isAtFirstElement() )
           {
            currentIndex--;
           
            return true;
           }
       
        return false;
       }
    
    /**
     * Removes and returns a data value from the iterator cursor position
     * <p>
     * Note: cursor must be located at succeeding element unless
     * last item removed
     * 
     * @return integer value removed from list, 
     * or FAILED_ACCESS if not found
     */
    public int removeAtCurrent()
       {
        int result = removeAtIndex( currentIndex );
        int currentSize = getCurrentSize();
        
        if( currentIndex >= currentSize )
           {
            currentIndex = currentSize - 1;
           }
        
        return result;
       }
    
    /**
     * Replaces value at iterator cursor with new value
     * 
     * @param newValue integer value to be inserted in list
     * 
     * @return Boolean result of action; true if successful, false otherwise
     */
    public boolean replaceAtCurrent( int newValue )
       {
        return setAtIndex( currentIndex, newValue, REPLACE );
       }
   
    /**
     * Shows space-delimited list with cursor location indicated
     */
    public void runDiagnosticDisplay()
       {
        int index;
        
        for( index = 0; index < getCurrentSize(); index++ )
           {
            if( index > 0 )
               {
                System.out.print( SPACE );
               }
            
            if( index == currentIndex )
               {
                System.out.print( LEFT_BRACKET );
               }
            
            System.out.print( getAtIndex( index ) );
            
            if( index == currentIndex )
               {
                System.out.print( RIGHT_BRACKET );
               }
           }
        
        System.out.println();
       }
    
    /**
     * Inserts new value after value at iterator cursor
     * <p>
     * Note: Current value must remain the same after data set
     * 
     * @param newValue integer value to be inserted in list
     * 
     * @return Boolean result of action; true if successful, false otherwise
     */
    public boolean setAfterCurrent( int newValue )
       {
        if( currentIndex < 0 )
           {
            currentIndex++;
           }
       
        return setAtIndex( currentIndex, newValue, INSERT_AFTER );
       }
   
    /**
     * Inserts new before value at iterator cursor
     * <p>
     * Note: Current value must remain at the same index after data set
     * 
     * @param newValue integer value to be inserted in list
     * 
     * @return Boolean result of action; true if successful, false otherwise
     */
    public boolean setBeforeCurrent( int newValue )
       {
        Boolean result;
        int setIndex = currentIndex;
        
        if( currentIndex < 0 )
           {
            setIndex++;
           }
        
        result = setAtIndex( setIndex, newValue, INSERT_BEFORE );
        
        currentIndex++;
        
        return result;
       }
   
    /**
     * Sets iterator cursor to beginning of list
     * 
     * @return Boolean result of action; true if successful, false otherwise
     */
    public boolean setToFirstElement()
       {
        if( !isEmpty() )
           {
            currentIndex = 0;
          
            return true;
           }
      
        return false;
       }
    
    /**
     * Sets iterator cursor to the end of the list
     * 
     * @return Boolean result of action; true if successful, false otherwise
     */
    public boolean setToLastElement()
       {
        if( !isEmpty() )
           {
            currentIndex = getCurrentSize() - 1;
         
            return true;
           }
     
        return false;
       }
    
   }
