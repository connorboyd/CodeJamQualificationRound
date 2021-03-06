import java.io.IOException;

public class Game {
	
	private char[][] gameBoard = new char[4][4];
	private int caseNumber;
	private int gameState;	//0 = unknown
							//1 = X won
							//2 = O won
							//3 = Draw
							//4 = unfinished
	public Game(String gameString, int caseNum)
	{
		for(int i = 0; i < 16; ++i)
		{
			gameBoard[i / 4][i % 4] = gameString.charAt(i);
		}
		caseNumber = caseNum;
		gameState = 0;
	}
	
	public void checkGame() throws IOException
	{
		int numEmpty = 0;
		for(int i = 0; i < 16; ++i)
		{
			if(gameBoard[i / 4][i % 4] == '.')
				++numEmpty;
		}
		
		if(checkRows() || checkCols() || checkDiagonals())
		{
			//There is a winner
		}
		else if(numEmpty == 0)
		{
			gameState = 3;	//Gameboard full; Draw
		}
		else
		{
			gameState = 4; //Gameboard not full; Game not completed
		}
		printWinner();
	}
	
	private void printWinner() throws IOException
	{
//		Solver.getFileWriter().write
		Solver.getFileWriter().write("Case #" + caseNumber + ": ");
		if(gameState == 0)	//Unfinished
		{
			Solver.getFileWriter().write("Fuck you\n");
		}
		else if(gameState == 1)	//X won
		{
			Solver.getFileWriter().write("X won\n");
		}
		else if(gameState == 2) //O won
		{
			Solver.getFileWriter().write("O won\n");
		}
		else if(gameState == 3)
		{
			Solver.getFileWriter().write("Draw\n");
		}
		else if(gameState == 4)
		{
			Solver.getFileWriter().write("Game has not completed\n");
		}
		else
		{
			System.err.println("wat\n");
		}
		
	}
	
	private boolean checkRows()
	{
		for(int row = 0; row < 4; ++row)
		{	
			int numXs = 0;
			int numOs = 0;
			for(int col = 0; col < 4; ++col)
			{
				if(gameBoard[row][col] == 'X')
					++numXs;
				else if(gameBoard[row][col] == 'O')
					++numOs;
				else if(gameBoard[row][col] == 'T')
				{
					++numXs; ++numOs;
				}	
			}
			
			if(numXs == 4)
			{
				gameState = 1;
				return true;
			}
			else if(numOs == 4)
			{
				gameState = 2;
				return true;
			}
		}
		return false;
	}

	private boolean checkCols()
	{
		for(int col = 0; col < 4; ++col)
		{	
			int numXs = 0;
			int numOs = 0;
			for(int row = 0; row < 4; ++row)
			{
				if(gameBoard[row][col] == 'X')
					++numXs;
				else if(gameBoard[row][col] == 'O')
					++numOs;
				else if(gameBoard[row][col] == 'T')
				{
					++numXs; ++numOs;
				}	
			}
			
			if(numXs == 4)
			{
				gameState = 1;
				return true;
			}
			else if(numOs == 4)
			{
				gameState = 2;
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDiagonals()
	{
		int numXs = 0;
		int numOs = 0;
		
		for(int i = 0; i < 4; ++i)
		{
			if(gameBoard[i][i] == 'X')
			{
				++numXs;
			}
			else if(gameBoard[i][i] == 'O')
			{
				++numOs;
			}
			else if(gameBoard[i][i] == 'T')
			{
				++numXs; ++numOs;
			}
		}
		
		if(numXs == 4)
		{
			gameState = 1;
			return true;
		}
		else if(numOs == 4)
		{
			gameState = 2;
			return true;
		}
		
		numXs = 0; numOs = 0;
		
		for(int i = 0; i < 4; ++i)
		{
			if(gameBoard[3 - i][i] == 'X')
			{
				++numXs;
			}
			else if(gameBoard[3 - i][i] == 'O')
			{
				++numOs;
			}
			else if(gameBoard[3 - i][i] == 'T')
			{
				++numXs; ++numOs;
			}
		}
		if(numXs == 4)
		{
			gameState = 1;
			return true;
		}
		else if(numOs == 4)
		{
			gameState = 2;
			return true;
		}
		
		return false;	//Temporary
	}
}
