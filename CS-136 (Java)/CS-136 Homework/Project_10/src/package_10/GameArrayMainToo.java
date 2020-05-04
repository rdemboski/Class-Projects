package package_10;

import javax.swing.JOptionPane;

/**
 * Driver class for using GameArrayClassToo to develop game
 * 
 * @author MichaelL
 *
 */
public class GameArrayMainToo
   {

    /**
     * Main driver method
     * 
     * @param args String array of arguments
     */
    public static void main(String[] args)
       {
        int rowCap = 15, colCap = 20;
        
        // game is initialized in the constructor
        GameArrayClassToo gact = new GameArrayClassToo( rowCap, colCap );

        playGame( gact );
       }
    
    /**
     * Plays game using tools from GameArrayClassToo
     * 
     * @param game GameArrayClassToo object that was initialized in main
     */
    public static void playGame( GameArrayClassToo game )
       {
		// TODO: Implement the game play operations here
        //       using the tools provided by the GameArrayClassToo
    	
    	
    	//Really tried the best I could, it will write fine but
    	//for the life of me couldn't figure out the reading stuff.
    	//Asked for as much help as I could, together we still
    	//couldn't figure it out
 
	    //May have been close but just couldn't get it right.
    	

    	
    	String fileName, storedFileName;
    	String rowInput, colInput;
    	String retrievedGame, storedGame;
    	char retrievedChar, storedChar;
    	int row, col, chosenVal;
    	int rowCap = game.getRowCapacity() - 1;
    	int colCap = game.getColumnCapacity() - 1;
    	boolean gameWon = false;
		

		GameArrayClassToo game_2 = new GameArrayClassToo( game );
		
		
		while (gameWon == false)
		{
			
			retrievedGame = JOptionPane.showInputDialog("Do you "
					+ "want to play a previously stored game (Y/N)?");
	    	retrievedChar = retrievedGame.charAt(0);
	    	
	    	if (retrievedChar == 'Y' || retrievedChar == 'y')
	    	{
	    		fileName = JOptionPane.showInputDialog("Enter file name:");
	    		game_2.retrieveGame(fileName);
	    		game_2.cheat();
	    	}
	    	game.cheat();
	    	
	    	
	    	rowInput = JOptionPane.showInputDialog("Enter row index "
					+ "between 0 and " + rowCap + ":");
			colInput = JOptionPane.showInputDialog("Enter col index "
					+ "between 0 and " + colCap + ":");
			
			row = Integer.parseInt(rowInput);
			col = Integer.parseInt(colInput);
			
			
			if (!game.elementExists(row, col))
			{
				game.decrementGameScore();
				System.out.println("The element at ( " + row + ", " 
													+ col + " )"
						+ " is outside the boundaries of your game; "
						+ "your score is now " + game.getGameScore());
				gameWon = false;
			}
			
			
			if (game.elementHasBeenUsed(row, col))
			{
				game.decrementGameScore();
				System.out.println("You have already tried the element at "
						+ "( " + row + ", " + col + " ); your score is now "
						+ game.getGameScore());
				gameWon = false;
			}
			
			//gets a value in array
			chosenVal = game.getValueAt(row, col);
		
			if (chosenVal != GameArrayClassToo.WIN_ELEMENT)
			{
				game.decrementGameScore();
				System.out.println("Value " + chosenVal + " found at"
						+ " ( " + row + ", " + col + " ); your score is now "
						+ "" + game.getGameScore());
				chosenVal = GameArrayClassToo.USED_ELEMENT;
				gameWon = false;
			}
			
			else
			{
				System.out.println("YOU FOUND IT! Your final score is "
									+ game.getGameScore());
				gameWon = true;
			}
			
			
			if (gameWon == true)
			{
				storedGame = JOptionPane.showInputDialog("Do you "
						+ "want to store this game (Y/N)?");
				storedChar = storedGame.charAt(0);
				
				if (storedChar == 'Y' || storedChar == 'y')
				{
					storedFileName = JOptionPane.showInputDialog("Enter "
												+ "file name:");
					game_2.storeGame(storedFileName);
				}
			}
		}	
       }
   }