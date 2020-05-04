package package_12;

public class TwoDimArrayClass
{

	private static final int DEFAULT_CAPACITY = 10;
	public static final int	FAILED_ACCESS = -999999;
	
	protected int[][] localTD_Array;
	protected int rowCapacity;
	protected int colCapacity;
	
	
	public TwoDimArrayClass()
	{
		rowCapacity = DEFAULT_CAPACITY;
		colCapacity = DEFAULT_CAPACITY;
		this.localTD_Array = new int[rowCapacity][colCapacity];
	}
	
	
	public TwoDimArrayClass(int rowCap, int colCap)
	{
		rowCapacity = rowCap;
		colCapacity = colCap;
		this.localTD_Array = new int[rowCapacity][colCapacity];
	}
	
	
	public TwoDimArrayClass(TwoDimArrayClass copied)
	{
		int row, column;
		
		this.rowCapacity = copied.rowCapacity;
		this.colCapacity = copied.colCapacity;
		this.localTD_Array = new int[rowCapacity][colCapacity];
		
		for (row = 0; row < rowCapacity; row++)
		{
			for (column = 0; column < colCapacity; column++)
			{
				localTD_Array[row][column] = copied.localTD_Array[row][column];
			}
		}
	}
	
	
	public int accessItemAt(int rowAccessIndex, int colAccessIndex)
	{
		if(rowAccessIndex >= 0 && rowAccessIndex < rowCapacity &&
		   colAccessIndex >= 0 && colAccessIndex < colCapacity)
	     {
	    	 return localTD_Array[rowAccessIndex][colAccessIndex];
	     }
	    return FAILED_ACCESS;
	}
	
	
	public void dumpTwoDimArray()
	{
		int rowIndex, colIndex, endOfCol = 1;
	    System.out.println("\nTwoDimArrayClass Array Dump:");
	    
	    for (rowIndex = 0; rowIndex < rowCapacity; rowIndex++)
		{
			for (colIndex = 0; colIndex < colCapacity; colIndex++)
			{
				if (localTD_Array[rowIndex][colIndex] > 0)
				{
					if (colIndex == colCapacity - endOfCol)
					{
						System.out.format("% 5d%s", 
							      localTD_Array[rowIndex][colIndex], "");
					}
					else
					{
						System.out.format("% 5d%s", 
							      localTD_Array[rowIndex][colIndex], ", ");
					}
				}
			}
			System.out.println();
		}
	    System.out.println('\n');
	}
	
	
	public int getCurrentColCapacity()
	{
		return colCapacity;
	}
	
	
	public int getCurrentRowCapacity()
	{
		return rowCapacity;
	}
	
	
	public void resize(int newRowCapacity, int newColCapacity)
	{
		int row, column;
		int[][] newArray = new int[newRowCapacity][newColCapacity];
		int currentRowCap = getCurrentRowCapacity();
		int currentColCap = getCurrentColCapacity();
		
		for (row = 0; row < Math.min(newRowCapacity, 
				    currentRowCap); row++)
		{
			for (column = 0; column < Math.min(newColCapacity, 
					currentColCap); column++)
			{
				newArray[row][column] = localTD_Array[row][column];
			}
		}
		rowCapacity = newRowCapacity;
		colCapacity = newColCapacity;
		localTD_Array = newArray;
	}
	
	
	public boolean setItemAt(int rowIndexToSet,
            int colIndexToSet,
            int newValue)
	{
		if (rowIndexToSet >= 0 && rowIndexToSet < rowCapacity &&
				colIndexToSet >= 0 && colIndexToSet < colCapacity)
		{
			localTD_Array[rowIndexToSet][colIndexToSet] = newValue;
			return true;
		}
		return false;
	}
}
