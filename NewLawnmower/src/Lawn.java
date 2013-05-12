
public class Lawn {
	
	
	private int rows, cols;
	private int[][] lawnMatrix;
	public Lawn(int r, int c, int[][] lm)
	{
		rows = r;
		cols = c;
		lawnMatrix = lm;
	}

	public boolean isPossible()
	{
		if(checkRows() || checkCols())
		{
			return false;
		}
		return true;
	}
	
	private boolean checkRows()
	{
		for(int i = 0; i < rows; ++i)
		{
			boolean hasIncreased = false;
			boolean hasDecreased = false;
			for(int j = 0; j < cols - 1; ++j)
			{
				if(lawnMatrix[i][j] > lawnMatrix[i][j+1])
				{
					hasDecreased = true;
				}
				else if(lawnMatrix[i][j] < lawnMatrix[i][j+1])
				{
					hasIncreased = true;
				}
				
				if(hasIncreased && hasDecreased)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkCols()
	{
		for(int i = 0; i < cols; ++i)
		{
			boolean hasIncreased = false;
			boolean hasDecreased = false;
			for(int j = 0; j < rows - 1; ++j)
			{
				if(lawnMatrix[j][i] > lawnMatrix[j+1][i])
				{
					hasDecreased = true;
				}
				else if(lawnMatrix[j][i] < lawnMatrix[j+1][i])
				{
					hasIncreased = true;
				}
				
				if(hasIncreased && hasDecreased)
				{
					return true;
				}
			}
			
		}
		return false;
	}
	
	
	private boolean isHigherInThreeDirections(int r, int c)
	{
		return ( isHigherNorth(r,c) || isHigherSouth(r,c) ) && ( isHigherEast(r,c) || isHigherWest(r,c) );
//		System.out.println("Sum = " + sum);
//		return sum >= 3;
	}
	
	private boolean isHigherNorth(int r, int c)
	{
		int startLength = lawnMatrix[r][c];
		for(int row = r; row >= 0; --row)
		{
			if(lawnMatrix[row][c] > startLength)
			{
//				System.out.println("Byah");
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isHigherSouth(int r, int c)
	{
		int startLength = lawnMatrix[r][c];
		for(int row = r; row < rows; ++row)
		{
			if(lawnMatrix[row][c] > startLength)
			{
//				System.out.println("Byah");
				return true;
			}
		}
		return false;
	}
	
	private boolean isHigherWest(int r, int c)
	{
		int startLength = lawnMatrix[r][c];
		for(int col = c; col >= 0; --col)
		{
			if(lawnMatrix[r][col] > startLength)
			{
//				System.out.println("Byah");
				return true;
			}
		}
		return false;
	}
	
	private boolean isHigherEast(int r, int c)
	{
		int startLength = lawnMatrix[r][c];
		for(int col = c; col < cols; ++col)
		{
			if(lawnMatrix[r][col] > startLength)
			{
//				System.out.println("Byah");
				return true;
			}
		}
		return false;
	}
	

}
