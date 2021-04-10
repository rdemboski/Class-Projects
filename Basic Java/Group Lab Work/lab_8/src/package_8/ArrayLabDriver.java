package package_8;

public class ArrayLabDriver
   {
      //create constants for LOW_VALUE AND HIGH_VALUE
      static int LOW_VALUE = 1;
      static int HIGH_VALUE = 100;
      

      public static void main(String[] args)
         {
            //declare variables, array capacity is a variable not a constant
            //array capacity should be set to 20
            int capacity = 20;
            
            //declare array
            int[] intArray = new int[capacity];
          
            //for loop using getRandBetween method to
            //initialize array
            int index;
            for(index=0; index < 20; index++)
            {
            	intArray[index] = getRandBetween(LOW_VALUE, HIGH_VALUE);
            	
            }
            
            //create ArrayLabClass instance using constructor that accepts an array
            ArrayLabClass calculateArray = new ArrayLabClass(intArray);
          
            //call calc methods to calculate the values 
            calculateArray.calcMin();
            calculateArray.calcMax();
            calculateArray.calcAverage();
            
            //print statements for min, max, average and elements of
            //array. Use get methods to find these values
            System.out.println("Min value is: " + calculateArray.getMin());
            System.out.println("Max value is: " + calculateArray.getMax());
            System.out.println("Average value is: " + calculateArray.getAverage());
            calculateArray.printArray();
         }

      public static int getRandBetween( int low, int high )
         {
            int value, range = high - low + 1;
          
            value = (int)( Math.random() * range );
          
            return low + value;
         }

      

      
   }