package package_9;

import javax.swing.JOptionPane;

public class GameArrayClass
{
	private final int EMPTY_ELEMENT = 0;
	private final int USED_ELEMENT = -1;
	private final int WIN_ELEMENT = 1;
	
	private int colCapacity;
	private int rowCapacity;
	private int[][] gameArray;
	
	private int gameScore;
	
	//Constructors
	public GameArrayClass(int rowCap,
			              int colCap)
	{
		rowCap = rowCapacity;
		colCap = colCapacity;
		resetGame(rowCap, colCap);
	}
	
	
	public GameArrayClass(GameArrayClass copied)
	{
		int row, column;
		
		this.gameScore = copied.gameScore;
		this.rowCapacity = copied.rowCapacity;
		this.colCapacity = copied.colCapacity;
		this.gameArray = new int[rowCapacity][colCapacity];
		
		for (row = 0; row < rowCapacity; row++)
		{
			for (column = 0; column < colCapacity; column++)
			{
				gameArray[row][column] = copied.gameArray[row][column];
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
	
	
	private int getRandBetween( int lowLimit, int highLimit ) 
    {
     int range = highLimit - lowLimit + 1;
     
     return (int)( Math.random() * range );
    }
	
	
	private boolean elementExists(int rowIndex,
			                      int colIndex)
	{
		return rowIndex >= 0 && rowIndex < rowCapacity &&
				colIndex >= 0 && colIndex < colCapacity;
	}
	
	
	private boolean elementHasBeenUsed(int rowIndex,
			                           int colIndex)
	{
		return gameArray[rowIndex][colIndex] == USED_ELEMENT;
	}
	
	
	private boolean elementIsClear(int rowIndex,
			                       int colIndex)
	{
		return gameArray[rowIndex][colIndex] == EMPTY_ELEMENT;
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
			for (row = 0; row < rowCap; row++)
			{
				for (col = 0; col < colCap; col++)
				{
					if(setNearNeighbors(row, col))
						changed = true;
					//changed |= setNearNeighbors(row, col);
				}
			}
		} 
		while (changed);
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
	
	
	public boolean tryElement()
	{
		String rowInput, colInput;
		int row, col, chosenVal;
		boolean gameOver = false;
		
		rowInput = JOptionPane.showInputDialog("Enter row index "
				+ "between 0 and 14:");
		colInput = JOptionPane.showInputDialog("Enter col index "
				+ "between 0 and 9:");
		
		row = Integer.parseInt(rowInput);
		col = Integer.parseInt(colInput);
		
		if (!elementExists(row, col))
		{
			gameScore -= 1;
			System.out.println("The element at ( " + row + ", " + col + " )"
					+ " is outside the boundaries of your game; "
					+ "your score is now " + gameScore);
			return gameOver;
		}
		if (elementHasBeenUsed(row, col))
		{
			gameScore -= 1;
			System.out.println("You have already tried the element at "
					+ "( " + row + ", " + col + " ); your score is now "
					+ gameScore);
			return gameOver;
		}
		chosenVal = gameArray[row][col];
		
		if (chosenVal != WIN_ELEMENT)
		{
			gameScore -= 1;
			System.out.println("Value " + chosenVal + " found at"
					+ " ( " + row + ", " + col + " ); your score is now "
					+ "" + gameScore);
			gameArray[row][col] = USED_ELEMENT;
			return gameOver;
		}
		
		do
		{
			System.out.println("YOU FOUND IT! Your final score is " + gameScore);
			return true;
		}
		while (!gameOver);
		
	}
		
}
