package package_9;

public class TwoDArrayLab
{
	
	// Initialize variables 
	private int rightSum, leftSum, rowSize, colSize;
	private int[][] intArray;
	
	// constructs the array to the inputed row and column sizes 
	public TwoDArrayLab(int[][] intArray, int rowSizeInput, int colSizeInput)
	{
		rowSize = rowSizeInput;
		colSize = colSizeInput;
		this.intArray = intArray;
	}
	
	// calculates the left sum 
	
	public void calcLeftSum()
	{
		int index, sum = 0;
		for (index = 0; index < colSize; index ++)
		{
			sum = sum + intArray[index][index];
		}
		leftSum = sum;
	}
	
	// calculates the right sum 
	
	public void calcRightSum()
	{
		int index, sum = 0;
		for (index = 0; index < colSize; index ++)
		{
			sum = sum + intArray[index][colSize-1-index];
		}
		rightSum = sum;
	}
	
	// returns the calculated left sum 
	
	public int getLeftSum()
	{
		return leftSum;
	}
	
	// Returns the calculated right sum 
	
	public int getRightSum()
	{
		return rightSum;
	}
	
	// Prints Array
	
	public void printArray()
	{
		int rowIndex, colIndex;
		for (rowIndex = 0; rowIndex < rowSize; rowIndex ++)
		{
			for (colIndex = 0; colIndex < colSize; colIndex ++)
			{
				
				System.out.print(intArray[rowIndex][colIndex] + " ");
				
			}
			System.out.println();
		}
	}	
}
