package package_9;


public class TwoDArrayLabMain
{
   
   private final static int LOW_VALUE = 1;
   private final static int HIGH_VALUE = 100;
   

   public static void main(String[] args)
      {
         //declare variables, row size and column size
         //are variables not constants
         //This needs to be a square array so row size
         //and column size will be equal
         int rowSize = 4;
         int columnSize = 4;
         int rowIndex, colIndex;
         
         //declare array
         int[][] intArray = new int[rowSize][columnSize];
       
         //for loop using getRandBetween method to
         //initialize array (will need a nested for loop)
         for( rowIndex = 0; rowIndex < rowSize; rowIndex++)
            {
               for( colIndex = 0; colIndex < columnSize; colIndex++ )
                  {
                     intArray[ rowIndex ][ colIndex ] = getRandBetween( LOW_VALUE, HIGH_VALUE );
                  }
            }
         
         
         //create ArrayLabClass instance using constructor that accepts a 2d array,
         //row size and column size
         TwoDArrayLab arrayTest = new TwoDArrayLab( intArray, rowSize, columnSize );
       
         //call calc method to calculate diagonal sum for left and right sum 
         arrayTest.calcLeftSum();
         arrayTest.calcRightSum();
         
         
         //print statements for diagonal sum (use getSum() method) and 
         //array elements (use printArray() method)
         System.out.println("Left Diagonal sum is: " + arrayTest.getLeftSum());
         System.out.println("Right Diagonal sum is: " + arrayTest.getRightSum());
         System.out.println("Array values");
         arrayTest.printArray();
       
      
      }

   public static int getRandBetween( int low, int high )
      {
         int value, range = high - low + 1;
       
         value = (int)( Math.random() * range );
       
         return low + value;
      }

   

   
}
