package package_6;

import javax.swing.JOptionPane;

public class QuadraticSolverClass_2 
	{
		private static final char DOUBLE_HORIZONTAL_LINE = '=';
		private static final char ENDLINE_CHAR = '\n';
		private static final char EQUALS_SIGN = '=';
		private static final char SINGLE_HORIZONTAL_LINE = '-';
		private static final char SPACE = ' ';
		private static final char VERTICAL_LINE = '|';
		
		private static final int EQUALS_SIGN_COUNT = 1;
		private static final int FULL_LINE_BLOCK_SIZE = 41;
		private static final int LEFT_SIDE_BLOCK_SIZE = 24;
		private static final int NO_ROOTS = 5005;
		private static final int ONE_ROOT = 3003;
		private static final int RIGHT_SIDE_BLOCK_SIZE = 14;
		private static final int SINGLE_LINE = 1001;
		private static final int SINGLE_SPACE_COUNT = 1;
		private static final int STANDARD_PRECISION = 2;
		private static final int TWO_ROOTS = 4004;
		private static final int VERTICAL_LINE_COUNT = 1;
	
	
		public static void main(String args[])
		{
			double coeffA;
			double coeffB;
			double coeffC;
			
			double discriminant;
			double denominator;
			
			double rootOne, rootTwo;
			double positiveDiscrimSqrRt, negativeDiscrimSqrRt;
			
			int rootFlag;
			
			coeffA = getCoefficient("coefficient A:");
			coeffB = getCoefficient("coefficent B:");
			coeffC = getCoefficient("coefficient C:");
			
			
			discriminant = calcDiscrim(coeffA, coeffB, coeffC);
			denominator = calcDenom(coeffA);
			
			rootFlag = setRootFlag(discriminant);
			
			positiveDiscrimSqrRt = Math.sqrt(discriminant);
			negativeDiscrimSqrRt = -Math.sqrt(discriminant);
			
			rootOne = calcRoot(coeffB, positiveDiscrimSqrRt, denominator);
			rootTwo = calcRoot(coeffB, negativeDiscrimSqrRt, denominator);
			
			
			printResults(rootFlag, coeffA, coeffB, coeffC, rootOne, rootTwo);
		}
		
		
		public static double calcDenom( double cofA )
		{
			return (2 * cofA);
		}
		
		
		public static double calcDiscrim( double cofA, double cofB, 
                				  double cofC )
		{
			double discrim = ((cofB * cofB) - 4 * cofA * cofC);

			return discrim;
		}


		public static double calcRoot( double cofB, double discSqrRt,
					       double denom )
		{
			double resultRoot;
			
			resultRoot = (-cofB + discSqrRt) / denom;
			
			return resultRoot;
		}
		
		
		public static double getCoefficient( String coefLetter )
		{
    	    String resultCoeff;
    	    double result;
    	    
    	    resultCoeff = JOptionPane.showInputDialog("Enter " + coefLetter);
     		result = Double.parseDouble(resultCoeff);
     		
     		return result;
		}
		
		
		public static void printResults(int controlCode,
						double cofA, 
						double cofB, 
						double cofC, 
						double rootOne, 
						double rootTwo)
		{
		   int numChars = 1, blockSize = 41;
		   //Line 1
		   printSolidDoubleLine();
			   
		   //Line 2
		   printChars(numChars, VERTICAL_LINE);
	    	   printCenterJustifiedString("Quadratic Root Solver Program",
	    			   	       				blockSize);
	    	   printChars(numChars, VERTICAL_LINE);
	    	   printEndLine();
	    	   
	    	   //Line 3
	    	   printDividerLine(SINGLE_LINE);
	    	   
	    	   //Line 4
	    	   printChars(numChars, VERTICAL_LINE);
	    	   printChars(SINGLE_SPACE_COUNT, SPACE);
	    	   printLeftJustifiedString("Coefficient A",
	    			   	     LEFT_SIDE_BLOCK_SIZE);
	    	   printChars(EQUALS_SIGN_COUNT, EQUALS_SIGN);
	    	   printRightJustifiedDouble(cofA, STANDARD_PRECISION, 
	    			   	     RIGHT_SIDE_BLOCK_SIZE);
	    	   printChars(SINGLE_SPACE_COUNT, SPACE);
	    	   printChars(numChars, VERTICAL_LINE);
	    	   printEndLine();
	    	   
	    	   //Line 5
	    	   printDividerLine(SINGLE_LINE);
	    	   
	    	   //Line 6
	    	   printChars(numChars, VERTICAL_LINE);
	    	   printChars(SINGLE_SPACE_COUNT, SPACE);
	    	   printLeftJustifiedString("Coefficient B",
	    			   	    LEFT_SIDE_BLOCK_SIZE); 
	    	   printChars(EQUALS_SIGN_COUNT, EQUALS_SIGN);
	    	   printRightJustifiedDouble(cofB, STANDARD_PRECISION, 
	    			   	     RIGHT_SIDE_BLOCK_SIZE); 
	    	   printChars(SINGLE_SPACE_COUNT, SPACE);
	    	   printChars(numChars, VERTICAL_LINE);
	    	   printEndLine();
	    	   
	    	   //Line 7
	    	   printDividerLine(SINGLE_LINE);
	    	   
	    	   //Line 8
	    	   printChars(numChars, VERTICAL_LINE);
	    	   printChars(SINGLE_SPACE_COUNT, SPACE);
	    	   printLeftJustifiedString("Coefficient C", 
	    			   	    LEFT_SIDE_BLOCK_SIZE);
	    	   printChars(EQUALS_SIGN_COUNT, EQUALS_SIGN);
	    	   printRightJustifiedDouble(cofC, STANDARD_PRECISION, 
	    			   	     RIGHT_SIDE_BLOCK_SIZE);
	    	   printChars(SINGLE_SPACE_COUNT, SPACE);
	    	   printChars(numChars, VERTICAL_LINE);
	    	   printEndLine();
	    	   
	    	   //Line 9
	    	   printSolidDoubleLine();
	    	   
	    	   //Conditional for different types of answers
	    	   if (controlCode == NO_ROOTS)
	    	   {
		    	   printChars(numChars, VERTICAL_LINE);
		    	   printChars(SINGLE_SPACE_COUNT, SPACE);
		    	   printLeftJustifiedString("Imaginary (result)", 
		    			   	    LEFT_SIDE_BLOCK_SIZE);
		    	   printChars(EQUALS_SIGN_COUNT, EQUALS_SIGN);
		    	   printRightJustifiedString("No Roots", 
		    			   	     RIGHT_SIDE_BLOCK_SIZE);
		    	   printChars(SINGLE_SPACE_COUNT, SPACE);
		    	   printChars(numChars, VERTICAL_LINE);
		    	   printEndLine();
		    	   printSolidDoubleLine();
	    	   }
	    	   
	    	   else if (controlCode == ONE_ROOT)
	    	   {
		    	   printChars(numChars, VERTICAL_LINE);
		    	   printChars(SINGLE_SPACE_COUNT, SPACE);
		    	   printLeftJustifiedString("Root One (result)", 
		    			   	    LEFT_SIDE_BLOCK_SIZE);
		    	   printChars(EQUALS_SIGN_COUNT, EQUALS_SIGN);
		    	   printRightJustifiedDouble(rootOne, STANDARD_PRECISION, 
		    			   	     RIGHT_SIDE_BLOCK_SIZE);
		    	   printChars(SINGLE_SPACE_COUNT, SPACE);
		    	   printChars(numChars, VERTICAL_LINE);
		    	   printEndLine();
		    	   printSolidDoubleLine();
	    	   }
	    	   
	    	   else
	    	   {
		    	   printChars(numChars, VERTICAL_LINE);
		    	   printChars(SINGLE_SPACE_COUNT, SPACE);
		    	   printLeftJustifiedString("Root One (result)", 
		    			   	    LEFT_SIDE_BLOCK_SIZE);
		    	   printChars(EQUALS_SIGN_COUNT, EQUALS_SIGN);
		    	   printRightJustifiedDouble(rootOne, STANDARD_PRECISION, 
		    			   	     RIGHT_SIDE_BLOCK_SIZE);
		    	   printChars(SINGLE_SPACE_COUNT, SPACE);
		    	   printChars(numChars, VERTICAL_LINE);
		    	   printEndLine();
		    	   printDividerLine(SINGLE_LINE);
		    	   
		    	   printChars(numChars, VERTICAL_LINE);
		    	   printChars(SINGLE_SPACE_COUNT, SPACE);
		    	   printLeftJustifiedString("Root Two (result)", 
		    			   	    LEFT_SIDE_BLOCK_SIZE);
		    	   printChars(EQUALS_SIGN_COUNT, EQUALS_SIGN);
		    	   printRightJustifiedDouble(rootTwo, STANDARD_PRECISION, 
		    			   	     RIGHT_SIDE_BLOCK_SIZE);
		    	   printChars(SINGLE_SPACE_COUNT, SPACE);
		    	   printChars(numChars, VERTICAL_LINE);
		    	   printEndLine();
		    	   printSolidDoubleLine(); 
	    	   }
		}
		
		
		public static int setRootFlag( double discrim )
		{
			int flag;
			
			if (discrim < 0)
			{
				flag = NO_ROOTS;
			}
			else if (discrim == 0)
			{
				flag = ONE_ROOT;
			}
			else
			{	
				flag = TWO_ROOTS;
			}
			return flag;
		}
		
		
		//SUPPORTING METHODS
		public static void printCenterJustifiedDouble( double outVal, 
                int precision, int blockSize )
		{
			String outStr = setPrecision( outVal, precision );

			printCenterJustifiedString( outStr, blockSize );
		}
		
		
		public static void printCenterJustifiedString( String outString, 
                int blockSize )
		{
			int preSpaces = blockSize / 2 - outString.length() / 2;
			int postSpaces = blockSize - preSpaces - outString.length();

			printChars( preSpaces, SPACE );
			System.out.print( outString );
			printChars( postSpaces, SPACE );
		}
		
		
		public static void printChars( int numChars, char outChar )
	       {
	        if( numChars > 0 )
	           {
	            printChars( numChars - 1, outChar );
	                
	            System.out.print( outChar );
	           }
	       }
		
		
		public static void printDividerLine( int lineType )
        {
         printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );

         if( lineType == SINGLE_LINE )
            {
             printChars( FULL_LINE_BLOCK_SIZE, SINGLE_HORIZONTAL_LINE );
            }
         
         else
            {
             printChars( FULL_LINE_BLOCK_SIZE, DOUBLE_HORIZONTAL_LINE );
            }
         
         printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );

         printEndLine();
        }
		
		
		public static void printEndLine()
	       {
	        System.out.print( ENDLINE_CHAR );
	       }
		
		
		public static void printLeftJustifiedDouble( double outVal, 
                int precision, int blockSize )
		{
			String outStr = setPrecision( outVal, precision );

			printLeftJustifiedString( outStr, blockSize );
		}
		
		
		public static void printLeftJustifiedString( String outString, 
                int blockSize )
		{
			int postSpaces = blockSize - outString.length();

			System.out.print( outString );
			printChars( postSpaces, SPACE );
		}
		
		
		public static void printRightJustifiedDouble( double outVal, 
                int precision, int blockSize )
		{
			String outStr = setPrecision( outVal, precision );

			printRightJustifiedString( outStr, blockSize );
		}
		
		
		public static void printRightJustifiedString( String outString, 
                int blockSize )
		{
			int preSpaces = blockSize - outString.length();

			printChars( preSpaces, SPACE );
			System.out.print( outString );
		}
		
		
		public static void printSolidDoubleLine()
        {
         printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
         printChars( FULL_LINE_BLOCK_SIZE, DOUBLE_HORIZONTAL_LINE );
         printChars( VERTICAL_LINE_COUNT, VERTICAL_LINE );
         printEndLine();
        }
		
		
		public static String setPrecision( double outVal, int precision )
        {
         int tempPrecision = precision + 1;
         int wkgIntVal, outValInt = (int)outVal;
         double outValFraction = Math.abs( outVal - outValInt );
         String outValStr = "";
         
         while( tempPrecision > 1 )
            {
             outValFraction *= 10;
             
             wkgIntVal = (int)outValFraction;
             
             outValStr += wkgIntVal;
             
             outValFraction -= wkgIntVal;
             
             tempPrecision--;
            }

         outValFraction *= 100;
         
         if( outValFraction > 45 )
            {
             wkgIntVal = Integer.parseInt( outValStr ) + 1;
             
             outValStr = Integer.toString( wkgIntVal );
            }
         
         outValStr = Integer.toString( outValInt ) + "." + outValStr;
         
         return outValStr;
        }
		
	}
