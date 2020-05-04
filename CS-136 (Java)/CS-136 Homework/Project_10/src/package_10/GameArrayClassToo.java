package package_10;

import java.io.*;

public class GameArrayClassToo
{
	//Constants
	private static final char COLON = ':';
	public static final int	EMPTY_ELEMENT = 0;
	private static final int END_OF_FILE_MARKER	= -1;
	private static final int MAX_INPUT_CHARS = 80;
	public static final int	NO_ELEMENT_FOUND = -999;
	private static final char SPACE_CHAR = ' ';
	private static final String	SPACE_STR = " ";
	public static final int	USED_ELEMENT = -1;
	public static final int	WIN_ELEMENT	= 1;
	
	//Member variables
	private int colCapacity;
	private int rowCapacity;
	private int[][] gameArray;
	private int gameScore;
	
	private FileWriter outFile;
	private FileReader inFile;
	
	
	//Constructors
	public GameArrayClassToo(int rowCap, int colCap)
	{
		outFile = null;
		inFile = null;
		resetGame(rowCap, colCap);
	}
	
	
	public GameArrayClassToo(GameArrayClassToo copied)
	{
		int row, column;
		outFile = null;
		inFile = null;
		
		this.gameScore = copied.gameScore;
		this.rowCapacity = copied.rowCapacity;
		this.colCapacity = copied.colCapacity;
		this.gameArray = new int[rowCapacity][colCapacity];
		
		for (row = 0; row < this.rowCapacity; row++)
		{
			for (column = 0; column < this.colCapacity; column++)
			{
				this.gameArray[row][column] = copied.gameArray[row][column];
			}
		}
	}
	
	
	//Methods
	public void cheat()
	{
		int rowIndex, colIndex;
	    System.out.println("\nCheat Screen:");
	    
	    for (rowIndex = 0; rowIndex < rowCapacity; rowIndex++)
		{
			for (colIndex = 0; colIndex < colCapacity; colIndex++)
			{
				if (elementIsClear(rowIndex, colIndex))
				{
					System.out.print('*');
				}
				else if (elementHasBeenUsed(rowIndex, colIndex))
				{
					System.out.print('X');
				}
				System.out.format("% 4d%s", 
					     gameArray[rowIndex][colIndex], "");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	private void clearGameBoard()
	{
		int row, column;
		
		for (row = 0; row < rowCapacity; row++)
		{
			for (column = 0; column < colCapacity; column++)
			{
				gameArray[row][column] = EMPTY_ELEMENT;
			}
		}
	}
	
	
	public void decrementGameScore()
	{
		gameScore--;
	}
	
	
	private int getRandBetween(int lowLimit,
			                   int highLimit)
	{
		int range = highLimit - lowLimit + 1;
	     
	    return (int)( Math.random() * range );
	}
	
	
	public boolean elementExists(int rowIndex,
			                     int colIndex)
	{
		return rowIndex >= 0 && rowIndex < rowCapacity &&
				colIndex >= 0 && colIndex < colCapacity;
	}
	
	
	public boolean elementHasBeenUsed(int rowIndex,
            int colIndex)
	{
		return gameArray[rowIndex][colIndex] == USED_ELEMENT;
	}


	public boolean elementIsClear(int rowIndex,
        int colIndex)
	{
		return gameArray[rowIndex][colIndex] == EMPTY_ELEMENT;
	}
	
	
	public int getColumnCapacity()
	{
		return colCapacity;
	}
	
	
	public int getGameScore()
	{
		return gameScore;
	}
	
	
	public int getRowCapacity()
	{
		return rowCapacity;
	}
	
	
	public int getValueAt(int rowIndex,
			              int colIndex)
	{
		int element = NO_ELEMENT_FOUND;
		
		if (elementExists(rowIndex, colIndex))
		{
			element = gameArray[rowIndex][colIndex];
		}
		return element;
	}
	
	
	public void resetGame(int rowCap,
			              int colCap)
	{
		int row, col;
		boolean changed = false;
		
		rowCapacity = rowCap;
		colCapacity = colCap;
		gameArray = new int[rowCap][colCap];
		gameScore = rowCap * colCap;
		clearGameBoard();
		setWinSpot();

		do 
		{
			changed = false;
			for (row = 0; row < rowCapacity; row++)
			{
				for (col = 0; col < colCapacity; col++)
				{
					if(setNearNeighbors(row, col))
					{
						changed = true;
					}
						
				}
			}
		} 
		while (changed);
	}
	
	
	private int readInt()
	{
		int inCharInt;
        int intValue;
		String resultStr;
        
        try
        {
        	do
        	{
        		inCharInt = inFile.read();
        	}
        	while (inCharInt <= SPACE_CHAR);
        		
        	resultStr = "";
        	
        	while (inCharInt != END_OF_FILE_MARKER && inCharInt >= '0' 
        											&& inCharInt <= '9')
        	{
        		resultStr += (char)inCharInt;
        		inCharInt = inFile.read();
        	}
        }
        
        catch (IOException ioe)
        {
        	return 0;
        }
        
        intValue = Integer.parseInt(resultStr);
        return intValue;
    }
	

	private String readString(char delimiter,
			                  int maxChars)
	{
		int inCharInt;
		int counter = 0;
		String resultStr;
		
		try
		{
			do
			{
				inCharInt = inFile.read();
				counter++;
			}
			while (inCharInt <= SPACE_CHAR && counter < maxChars);
			
			resultStr = "";
			
			while (inCharInt != END_OF_FILE_MARKER && inCharInt != delimiter
										&& counter < maxChars)
			{
				resultStr += (char)inCharInt;
				counter++;
				inCharInt = inFile.read();
			}
		}
		
		catch (IOException ioe)
		{
			return "";
		}
		
		return resultStr;
	}
	
	
	public boolean retrieveGame(String fileName)
	{
		int row, col;
		int[][] gameArray;
		
		try
		{
			inFile = new FileReader(fileName);
			
			readString(COLON, MAX_INPUT_CHARS);
			rowCapacity = readInt();
			readString(COLON, MAX_INPUT_CHARS);
			colCapacity = readInt();
			
			gameArray = new int[rowCapacity][colCapacity];
			
			gameScore = (rowCapacity * colCapacity);
			
			for (row = 0; row < rowCapacity; row++)
			{
				for (col = 0; col < colCapacity; col++)
				{
					gameArray[row][col] = readInt();
				}
			}
			
			inFile.close();
		}
		
		catch (IOException ioe)
		{
			return false;
		}
		
		return true;
	}
	
	
	public void setElementUsed(int rowIndex,
			                   int colIndex)
	{
		if (elementExists(rowIndex, colIndex))
		{
			gameArray[rowIndex][colIndex] = USED_ELEMENT;
		}
	}
	
	
	private boolean setNearNeighbors(int rowIndex,
			                         int colIndex)
	{
		boolean result = false;
		int val;
		
		if(!elementIsClear(rowIndex,colIndex))
		{
			val = gameArray[rowIndex][colIndex] + 1;

			// above
			if (elementExists(rowIndex - 1, colIndex) &&
					elementIsClear(rowIndex - 1, colIndex))
			{
				gameArray[rowIndex - 1][colIndex] = val;
				result = true;
			}
			// below
			if (elementExists(rowIndex + 1, colIndex) &&
					elementIsClear(rowIndex + 1, colIndex))
			{
				gameArray[rowIndex + 1][colIndex] = val;
				result = true;
			}
			// left
			if (elementExists(rowIndex, colIndex - 1) &&
					elementIsClear(rowIndex, colIndex - 1))
			{
				gameArray[rowIndex][colIndex - 1] = val;
				result = true;
			}
			// right
			if (elementExists(rowIndex, colIndex + 1) &&
					elementIsClear(rowIndex, colIndex + 1))
			{
				gameArray[rowIndex][colIndex + 1] = val;
				result = true;
			}
		}
		return result;
	}
	
	
	private void setWinSpot()
	{
		int row = getRandBetween(0, rowCapacity - 1);
		int col = getRandBetween(0, colCapacity - 1);
		
		gameArray[row][col] = WIN_ELEMENT;
	}
	

	public void storeGame(String fileName)
	{
		int row, col, val;
		
		try
		{
			outFile = new FileWriter(fileName);
			

			outFile.write("Number of Rows:" + SPACE_STR + rowCapacity + '\n');
			outFile.write("Number of Columns:" + SPACE_STR +
										colCapacity + '\n');
			outFile.write('\n');
			
			for (row = 0; row < rowCapacity; row++)
			{
				for (col = 0; col < colCapacity; col++)
				{
					val = getValueAt(row, col);
					
					if (val < 10)
					{
						outFile.write(SPACE_CHAR);
					}
					outFile.write(SPACE_STR + gameArray[row][col]);
					outFile.write(SPACE_CHAR);
				}
				outFile.write('\n');
			}
			outFile.write('\n');
			
			outFile.flush();
			outFile.close();
		}
		
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
