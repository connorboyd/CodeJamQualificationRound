
public class Days
{
	
	private int numDiamonds;
	private int x, y;
	
	public Days(int diamonds, int ex, int why)
	{
		numDiamonds = diamonds;
		x = ex;
		y = why;
	}
	
	public double getProbability()
	{
		if(x == 0 && y == 0)
		{
			if(numDiamonds != 0)
			{
				return 1.0D;
			}
		}
		
		
		return -1D;
	}
	
	
}
