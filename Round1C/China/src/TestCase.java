import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TestCase {
	
	private ArrayList<Tribe> tribes;
	private ArrayList<Attack> attacks;
	private int numSuccesses;
	private HashMap<Integer, Integer> wall;
	private int currentIndex;
	public TestCase(ArrayList<Tribe> t)
	{
		tribes = t;
		wall = new HashMap<Integer, Integer>();
		condenseAttacks();
	}
	
	private void condenseAttacks()
	{
		attacks = new ArrayList<Attack>();
		for(int i = 0; i < tribes.size(); ++i)
		{
			attacks.addAll( tribes.get(i).getAttacks());			
		}
		Collections.sort(attacks);
	}

	
	private void doDay()
	{
		
	}
	
	private void doAttack()
	{
		Integer strength, east, west;
		strength = attacks.get(currentIndex).strength();
		east = attacks.get(currentIndex).east();
		west = attacks.get(currentIndex).west();
		
		for(int i = west; i < east; ++i)
		{
			if(!wall.containsKey(i))
			{
				++numSuccesses; return;
			}
			else
			{
				Integer wallHeight = wall.get(i);
				if(wallHeight < strength)
				{
					++numSuccesses; return;
				}
			}
			
		}
		
	}
	
	public int doTestCase()
	{
		currentIndex = 0;
		numSuccesses = 0;
		
		for(int i = 0; i < attacks.size(); ++i)
		{
			doDay();
		}
		
		return numSuccesses;
	}
}
