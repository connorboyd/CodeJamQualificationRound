import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Game
{
	private int mySize;
	private List<Integer> motes;
	
	public Game(int size, List<Integer> others)
	{
		mySize = size;
		motes = others;
		Collections.sort(motes);
	}
	
	private boolean isPossible()
	{
		
		int currentSize = mySize;
		
		for(Integer i : motes)
		{
			System.out.println("Current size: " + currentSize);
			System.out.println("Next mote: " + i);
			if(i >= currentSize)
			{
				return false;
			}
			else
			{
				currentSize += i;
			}
		}
		
		return true;
	}
	
	
	public int numChanges()
	{
		
		if(isPossible())
		{
			return 0;
		}
		
		if(mySize == 1)
		{
			return motes.size();
		}
		
		return -1;
	}
	
}
