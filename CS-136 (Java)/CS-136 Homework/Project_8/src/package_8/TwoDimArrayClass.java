package package_8;

public class TwoDimArrayClass
{
	
	private static final int DEFAULT_MAX_CAPACITY = 100;
	private static final int DEFAULT_MIN_CAPACITY = 3;
	public static final int FAILED_ACCESS = -999999;
	
	private int[][] localTD_Array;
	private int rowCapacity;
	private int colCapacity;
	private int maxCapacity;
	
	
	public TwoDimArrayClass()
	{
		
		rowCapacity = DEFAULT_MIN_CAPACITY;
		colCapacity = DEFAULT_MIN_CAPACITY;
		maxCapacity = DEFAULT_MAX_CAPACITY;
		this.localTD_Array = new int[rowCapacity][colCapacity];
	}
	
	
	public TwoDimArrayClass(int rowCap,
			                int colCap,
			                int maxCap)
	{
		if (rowCap < DEFAULT_MIN_CAPACITY)
		{
			rowCapacity = DEFAULT_MIN_CAPACITY;
		}
		else
		{
			rowCapacity = rowCap;
		}
		if (colCap < DEFAULT_MIN_CAPACITY)
		{
			colCapacity = DEFAULT_MIN_CAPACITY;
		}
		else
		{
			colCapacity = colCap;
		}
		if(maxCap > rowCap && maxCap > colCap && maxCap > DEFAULT_MAX_CAPACITY)
		{
			maxCapacity = maxCap;
		}
		else if (rowCap > DEFAULT_MAX_CAPACITY && rowCap >= colCap)
		{
			maxCapacity = rowCap;
		}
		else if (colCap > DEFAULT_MAX_CAPACITY && colCap >= rowCap)
		{
			maxCapacity = colCap;
		}
		else
		{
			maxCapacity = DEFAULT_MAX_CAPACITY;
		}
		localTD_Array = new int[rowCapacity][colCapacity];
	}
	
	
	public TwoDimArrayClass(TwoDimArrayClass copied)
	{
		int row, column;
		
		this.maxCapacity = copied.maxCapacity;
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
	
	
	public int accessItemAt(int rowAccessIndex,
			                int colAccessIndex)
	{
		if(rowAccessIndex >= 0 && rowAccessIndex < maxCapacity)
	     {
	    	 return localTD_Array[rowAccessIndex][colAccessIndex];
	     }
	     else
	     {
	    	 return FAILED_ACCESS;
	     }
	}
	
	
	public boolean arrayIndicesWithinMaxBounds(int testedRowIndex,
			                                   int testedColIndex)
	{	
		if (testedRowIndex < maxCapacity && testedColIndex < maxCapacity)
		{
			return true;
		}
		return false;
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
	
	
	public void resize(int newRowCapacity,
			           int newColCapacity)
	{
		int row, column;
		int[][] newArray = new int[newRowCapacity][newColCapacity];
		
		for (row = 0; row < rowCapacity; row++)
		{
			for (column = 0; column < colCapacity; column++)
			{
				newArray[row][column] = localTD_Array[row][column];
			}
		}
		localTD_Array = newArray;
	}
	
	
	public boolean setItemAt(int rowIndexToSet,
			                 int colIndexToSet,
			                 int newValue)
	{
		if (rowIndexToSet > maxCapacity || colIndexToSet > maxCapacity)
		{
			return false;
		}
		else
		{
			if (rowIndexToSet >= rowCapacity && rowIndexToSet <= maxCapacity)
			{
				resize(rowIndexToSet + 1, colCapacity);
			}
			else if (colIndexToSet >= colCapacity &&
					 colIndexToSet <= maxCapacity)
			{
				resize(rowCapacity, colIndexToSet + 1);
			}
			localTD_Array[rowIndexToSet][colIndexToSet] = newValue;
			return true;
		}
	}
}
