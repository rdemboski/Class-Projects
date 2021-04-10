package p3_package;

public class LogN_StudentMgmtClass
   {
   /**
    * Default constructor, takes no action for this static tool clas
    */
   public LogN_StudentMgmtClass()
      {
       // no action
      }
   
   /**
    * Compares two strings character by character set to lower case
    * to see which is alphabetically greater than the other;
    * <p>
    * if all tested letters of a name are equal, then compares
    * string lengths
    * <p>
    * Results are as follows:
    * <p>
    * Alphabetically, if strOne is greater than strTwo,
    * returns value greater than zero (e.g., Susan is greater than Bill);
    * <p>
    * if strOne is less than strTwo, returns value less than zero
    * (e.g., Roger is less than Zelda);
    * <p>
    * if strOne is equal to strTwo alphabetically but is different length,
    * returns difference in length (e.g., Will is less than William)
    * <p>
    * if strOne is equal to strTwo both alphabetically and in length,
    * returns zero (e.g., Susan is equal to Susan)
    * <p>
    * Note: .length utility method may used in this method
    * 
    * @param strOne first String value to be compared
    * 
    * @param strTwo second String value to be compared
    * 
    * @return integer difference as specified
    */
   public static int compareStrings( String strOne, String strTwo )
      {
       int difference, index = 0;
       int strOneLength = strOne.length();
       int strTwoLength = strTwo.length();
       
       while( index < strOneLength && index < strTwoLength )
          {
           difference = toLowerCase( strOne.charAt( index ) )
                                    - toLowerCase( strTwo.charAt( index ) );
           
           if( difference != 0 )
              {
               return difference;
              }
           
           index++;
          }
       
       return strOneLength - strTwoLength;
      }
   
   /** Merges StudentClass objects brought in between a low and high index 
    * segment (inclusive) of an array
    * <p>
    * Note: uses locally sized single array for temporary storage
    * 
    * @param localArray StudentClass array holding unsorted values
    * 
    * @param lowIndex lowest index of array segment to be managed
    * 
    * @param middleIndex middle index of array segment to be managed
    * 
    * @param highIndex high index of array segment to be managed
    */
   private static void runMerge( StudentClass[] localArray, int lowIndex, 
                                           int middleIndex, int highIndex )
      {
       int destinationIndex, sourceIndex; 
       int lowWorkingIndex, highWorkingIndex;
       int midTempIndex, highTempIndex;
       int tempArrayCapacity = highIndex - lowIndex + 1;
       StudentClass[] tempArray = new StudentClass[ tempArrayCapacity ];
     
       // load temporary array
       for( destinationIndex = 0, sourceIndex = lowIndex; 
            sourceIndex <= highIndex ; destinationIndex++, sourceIndex++ )
          {
           tempArray[ destinationIndex ] = localArray[ sourceIndex ]; 
          }
     
       highTempIndex = highIndex - lowIndex;
       midTempIndex = highTempIndex / 2;
       lowWorkingIndex = 0; 
       highWorkingIndex = midTempIndex + 1;
       destinationIndex = lowIndex;
     
       while( lowWorkingIndex <= midTempIndex 
                                     && highWorkingIndex <= highTempIndex )
          {
           if( compareStrings( tempArray[ lowWorkingIndex ].name,  
                                      tempArray[ highWorkingIndex ].name ) < 0 )
              {
               localArray[ destinationIndex ] = tempArray[ lowWorkingIndex ];
             
               destinationIndex++; lowWorkingIndex++; 
              }
         
           else
              {
               localArray[ destinationIndex ] = tempArray[ highWorkingIndex ];
                   
               destinationIndex++; highWorkingIndex++; 
              }
          }
     
       while( lowWorkingIndex <= midTempIndex )
          {
           localArray[ destinationIndex ] = tempArray[ lowWorkingIndex ];
         
           destinationIndex++; lowWorkingIndex++; 
          }
     
       while( highWorkingIndex <= highTempIndex )
          {
           localArray[ destinationIndex ] = tempArray[ highWorkingIndex ];
         
           destinationIndex++; highWorkingIndex++;  
          }
      }


   /**
    * StudentClass data sorted using merge sort algorithm
    * <p>
    * Note: Calls runMergeSortHelper with lower and upper
    * indices of array to be sorted
    * 
    * @param localArray String array holding unsorted values
    * 
    * @param size integer value holding number of values in array
    */
   public static void runMergeSort( StudentClass[] localArray, int size )
      {
       runMergeSortHelper( localArray, 0, size - 1 );
      }
 
   /**
    * Merge sort helper, recursively breaks given array segment down 
    * to smaller segments between lowIndex and highIndex (inclusive),
    * then sorts data using merge sort method
    * 
    * @param localArray StudentClass array holding unsorted values
    * 
    * @param lowIndex lowest index of array segment to be managed;
    * this varies as the segments are broken down recursively
    * 
    * @param highIndex highest index of array segment to be managed;
    * this varies as the segments are broken down recursively
    */
   private static void runMergeSortHelper( StudentClass[] localArray, 
                                               int lowIndex, int highIndex )
      {
       int midIndex;
     
       if( lowIndex < highIndex )
          {
           midIndex = ( lowIndex + highIndex ) / 2;
         
           runMergeSortHelper( localArray, lowIndex, midIndex );
         
           runMergeSortHelper( localArray, midIndex + 1, highIndex );
         
           runMerge( localArray, lowIndex, midIndex, highIndex );
          }
      }

   /**
    * Partitions array using the first value as the partition;
    * when this method is complete the partition value is
    * in the correct location in the array
    * 
    * @param localArray StudentClass array holding unsorted values
    * 
    * @param lowIndex low index of array segment to be partitioned
    * 
    * @param highIndex high index of array segment to be partitioned
    * 
    * @return integer index of partition pivot
    */
   private static int runPartition( StudentClass[] localArray, 
                                               int lowIndex, int highIndex )
      {
       int pivotIndex = lowIndex;
       int index;
     
       for( index = pivotIndex + 1; index <= highIndex; index++ )
          {
           if( compareStrings( localArray[ index].name, 
                                            localArray[ lowIndex ].name ) <= 0 )
              {
               pivotIndex++;

               swapValues( localArray, index, pivotIndex );
              }               
          }
      
       swapValues( localArray, lowIndex, pivotIndex );
     
      return pivotIndex;
     }
 
   /**
    * Data sorted using quick sort algorithm
    * <p>
    * Note: Call runQuickSortHelper with lower and upper
    * indices of array to be sorted
    * 
    * @param localArray StudentClass array holding unsorted values
    * 
    * @param size integer value holding the number of values in the array
    */ 
   public static void runQuickSort( StudentClass[] localArray, int size )
      {
       runQuickSortHelper( localArray, 0, size - 1 );
      }
          
   /**
    * Helper method run with parameters that support
    * recursive access
    * 
    * @param localArray StudentClass array holding unsorted values
    * 
    * @param lowIndex low index of the segment of the array 
    * to be processed
    * 
    * @param highIndex high index of the segment of the array 
    * to be processed
    */
   private static void runQuickSortHelper( StudentClass[] localArray, 
                                               int lowIndex, int highIndex )
      {
       int pivot;
  
       if( lowIndex < highIndex )
          {
           pivot = runPartition( localArray, lowIndex, highIndex );

           runQuickSortHelper( localArray, lowIndex, pivot - 1 );
   
           runQuickSortHelper( localArray, pivot + 1, highIndex );
          }
      }

   /**
    * Swaps values within given array
    * 
    * @param localArray array of Strings used for swapping
    * 
    * @param indexOne integer index for one of the two items to be swapped
    * 
    * @param indexOther integer index for the other of the two items 
    * to be swapped
    */
   private static void swapValues( StudentClass[] localArray, 
                                                  int indexOne, int indexOther )
      {
       StudentClass temp = localArray[ indexOne ];
       
       localArray[ indexOne ] = localArray[ indexOther ];
       
       localArray[ indexOther ] = temp;        
      }

   /**
    * If character is upper case letter (i.e., 'A' - 'Z'),
    * changes letter to lower case (i.e., 'a' - 'z');
    * otherwise, returns character unchanged
    * 
    * @param testChar character value to be tested
    * and possibly modified
    * 
    * @return character value modified as specified
    */
   private static char toLowerCase( char testChar )
      {
       if( testChar >= 'A' && testChar <= 'Z' )
          {
           testChar = (char)( testChar - 'A' + 'a' );
          }
       
       return testChar;
      }
   }
