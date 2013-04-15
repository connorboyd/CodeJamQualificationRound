
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
		for(int r = 0; r < rows; ++r)
		{
			for(int c = 0; c < cols; ++c)
			{
				
				if(isHigherInThreeDirections(r, c))
				{
//					System.out.println("What the fuck");
					return false;
				}
//				System.out.println("Byah");
			}
//			System.out.println("h");
		}
		return true;
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
