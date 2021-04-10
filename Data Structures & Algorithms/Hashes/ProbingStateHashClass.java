package p11_package;

/**
 * Simple hash class that uses linear and quadratic probing
 * 
 * @author MichaelL
 *
 */
public class ProbingStateHashClass
   {
    /**
     * Table size default
     */
    private final int DEFAULT_TABLE_SIZE = 11;
    
    /**
     * Constant for returning item not found with search
     */
    public final int ITEM_NOT_FOUND = -1;
    
    /**
     * Constant for setting linear probing
     */
    public static final int LINEAR_PROBING = 101;
    
    /**
     * Constant for setting quadratic probing
     */
    public static final int QUADRATIC_PROBING = 102;
    
    /**
     * Size of the array table
     */
    private int tableSize;
    
    /**
     * Flag for setting linear or quadratic probing
     */
    private int probeFlag;
    
    /**
     * Array for hash table
     */
    private StateDataClass[] tableArray;

    /**
     * Default constructor
     * <p>
     * Initializes to default table size 
     * with probe flag set to linear probing
     */
    public ProbingStateHashClass()
       {
        tableSize = DEFAULT_TABLE_SIZE;
        probeFlag = LINEAR_PROBING;

        tableArray = new StateDataClass[ tableSize ];
        
        clearHashTable();
        
        // could be replaced by: this( DEFAULT_TABLE_SIZE, LINEAR_PROBING );
       }
    
    /**
     * Initialization constructor
     * <p>
     * Initializes to default table size 
     * with probe flag set to probe flag parameter
     *
     * @param inProbeFlag sets linear or quadratic probing
     * 
     */
    public ProbingStateHashClass( int inProbeFlag )
       {
        tableSize = DEFAULT_TABLE_SIZE;
        probeFlag = inProbeFlag;
        
        tableArray = new StateDataClass[ tableSize ];
        
        clearHashTable();
        // could be replaced by: this( DEFAULT_TABLE_SIZE, inProbeFlag );        
       }

    /**
     * Initialization constructor
     * 
     * @param inTableSize sets table size (capacity) 
     * but does not allow table size to be less than default capacity
     * 
     * @param inProbeFlag sets linear or quadratic probing
     */
    public ProbingStateHashClass( int inTableSize, int inProbeFlag )
       {
        tableSize = inTableSize;
        probeFlag = inProbeFlag;
        
        if( tableSize < DEFAULT_TABLE_SIZE )
           {
            tableSize = DEFAULT_TABLE_SIZE;
           }
        
        tableArray = new StateDataClass[ tableSize ];
        
        clearHashTable();
       }

    /**
     * Copy constructor
     * 
     * @param copied ProbingHashClass object to be copied 
     */
    public ProbingStateHashClass( ProbingStateHashClass copied )
       {
        int index;
        
        tableSize = copied.probeFlag;
        probeFlag = copied.tableSize;
        
        tableArray = new StateDataClass[ tableSize ];
        
        for( index = 0; index < tableSize; index++ )
           {
            // This test not required for grading but you should make a comment
            if( copied.tableArray[ index ] != null )
               {
                tableArray[ index ] 
                               = new StateDataClass( copied.tableArray[ index ] );
               }
            
            tableArray[ index ] = null;
           }
       }

    /**
     * Adds StateDataClass data item to hash table
     * <p>
     * Note: Uses hash index value from generateHash
     * <p>
     * Note: Shows probed index with data at the point of insertion
     * <p>
     * Note: Probe attempts are limited to the current size 
     * (capacity) of the table
     * 
     * @param newItem StateDataClass object
     * 
     * @return Boolean success of operation
     */
    public boolean addItem( StateDataClass newItem )
       {
        int wkgIndex, orgHashIndex = generateHash( newItem );
        int probeCount = 1, quadExponent = 2;
        
        wkgIndex = orgHashIndex;

        System.out.print( "Indices probed: " + wkgIndex );
        
        while( tableArray[ wkgIndex ] != null && probeCount <= tableSize )
           {
            if( probeFlag == LINEAR_PROBING )
               {
                wkgIndex = orgHashIndex + probeCount;
               }
            
            else  // assume QUADRATIC_PROBING
               {
                wkgIndex = orgHashIndex 
                                       + toPower( probeCount, quadExponent );
               }
            
            wkgIndex %= tableSize;
            
            System.out.print( ", " + wkgIndex );
            
            probeCount++;
           }
      
        System.out.println();
        
        if( probeCount <= tableSize )
           {
            System.out.println( newItem.toString() 
                                    + ", " + orgHashIndex + " -> " + wkgIndex );

            tableArray[ wkgIndex ] = newItem;
            
            return true;
           }
      
        return false;
       }
    
    /**
     * Clears hash table by setting all bins to null
     */
    public void clearHashTable()
       {
        int index;
        
        for( index = 0; index < tableSize; index++ )
           {
            tableArray[ index ] = null;
           }
       }

    /**
     * Returns item found
     * 
     * @param searchItem StateDataClass value to be found;
     * uses findItemIndex
     * 
     * @return StateDataClass item found, or null if not found
     */
    public StateDataClass findItem( StateDataClass searchItem )
       {
        int arrayIndex = findItemIndex( searchItem );
        
        if( arrayIndex != ITEM_NOT_FOUND )
           {
            return tableArray[ arrayIndex ];
           }
        
        return null;
       }
    
    /**
     * Searches for item index in hash table
     * <p>
     * Note: Uses linear or quadratic probing as configured
     * <p>
     * Note: probing attempts limited to table size (capacity)
     * <p>
     * Note: Probed indices are reported to screen
     * 
     * @param searchItem StateDataClass object to be found
     * 
     * @return integer index location of search item
     */
    private int findItemIndex( StateDataClass searchItem )
       {
        int wkgIndex, orgHashIndex = generateHash( searchItem );       
        int probeCount = 1, quadExponent = 2;
        StateDataClass currentItem = tableArray[ orgHashIndex ];
      
        wkgIndex = orgHashIndex;
        
        System.out.print( "Indices probed: " + wkgIndex );

        while( probeCount <= tableSize )
           {
            if( currentItem == null 
                                   || currentItem.compareTo( searchItem ) != 0 )
               {            
                if( probeFlag == LINEAR_PROBING )
                   {
                    wkgIndex = orgHashIndex + probeCount;
                   }
           
                else  // assume QUADRATIC_PROBING
                   {
                    wkgIndex = orgHashIndex 
                                          + toPower( probeCount, quadExponent );
                   }
          
                 wkgIndex %= tableSize;

                 System.out.print( ", " + wkgIndex );
                 
                 currentItem = tableArray[ wkgIndex ];            
               }
            
            else if( currentItem != null ) // or currentItem.compareTo( searchItem ) == 0
               {
                System.out.println();
               
                return wkgIndex;
               }
            
            probeCount++;            
           }
    
        return ITEM_NOT_FOUND;
       }
    
    /**
     * Method converts StateDataClass hash value to index
     * for use in hash table
     * <p>
     * Sums the Unicode/ASCII values of all letters in the state name;
     * then finds index
     * 
     * @param item StateDataClass object to be converted to hash value
     * 
     * @return integer hash value
     */
    public int generateHash( StateDataClass item )
       {
        int index = 0;
        int charSum = 0;
        
        while( index < item.state.length() )
           {
            charSum += (int)( item.state.charAt( index ) );
            
            index++;
           }
        
         return charSum % tableSize;
       }
 
    /**
     * Removes item from hash table
     *
     * @param toBeRemoved StateDataClass object used for requesting data
     * uses findItemIndex
     * 
     * @return StateDataClass object removed, or null if not found
     */ 
    public StateDataClass removeItem( StateDataClass toBeRemoved )
       {
        int arrayIndex = findItemIndex( toBeRemoved );
        StateDataClass tempRemoved; 
              
        if( arrayIndex != ITEM_NOT_FOUND )
           {
            tempRemoved = tableArray[ arrayIndex ];
            
            tableArray[ arrayIndex ] = null;
            
            return tempRemoved;
           }
        
        return null;
       }

    /**
     * traverses through all array bins, 
     * finds min and max number of contiguous elements,
     * and number of empty nodes;
     * also shows table loading
     *
     *<p>
     * NOTE: Generates string of used and unused bins
     * in addition to displaying results on screen
     * 
     *@return String result of hash table analysis
     *
     */
    public String showHashTableStatus()
       {
        int index, nilCount = 0, itemCount = 0;
        int minContiguous = tableSize, maxContiguous = 0;
        String outResult = "";
        
        outResult += "\nHash Table Status: ";
        
        for( index = 0; index < tableSize; index++ )
           {
            if( tableArray[ index ] == null )
               {
                if( itemCount > 0 && itemCount < minContiguous )
                   {
                    minContiguous = itemCount;
                   }
          
                nilCount++;
             
                itemCount = 0;
                
                outResult += 'N';
               }
            
            else
               {
                itemCount++;
                
                if( itemCount > maxContiguous )
                   {
                    maxContiguous = itemCount;
                   }

                outResult += 'D';
               }
            
           }

        if( itemCount > 0 && itemCount < minContiguous )
           {
            minContiguous = itemCount;
           }

        System.out.println( outResult );
        System.out.println( "\n     Minimum contiguous bins: " + minContiguous );
        System.out.println( "     Maximum contiguous bins: " + maxContiguous );
        System.out.println( "        Number of empty bins: " + nilCount );
        
        System.out.println( "\nArray Dump:");
        
        for( index = 0; index < tableSize; index++ )
           {
            if( tableArray[ index ] != null )
               {
                System.out.println( tableArray[ index ].toString() );
               }
            
            else
               {
                System.out.println( "null" );
               }
           }
        
        return outResult;
       }

    /**
     * Local recursive method to calculate exponentiation with positive integers
     * 
     * @param base base of exponentiation
     * 
     * @param exponent exponent of exponentiation
     * 
     * @return result of exponentiation calculation
     */
    private int toPower( int base, int exponent )
       {
        if( exponent > 0 )
           {
            return toPower( base, exponent - 1 ) * base;
           }
        
        return 1;
       }
    
   }
