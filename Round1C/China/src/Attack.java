
public class Attack implements Comparable
{
	
	int day, west, east, strength;
	
	public Attack(int d, int w, int e, int s)
	{
		day = d; west = w; east = e; strength = s;
	}
	
	public int compareTo(Object o)
	{
		if(! (o instanceof Attack))
		{
			System.err.println("Fuck you");
			System.exit(0);
		}
		Integer myDay = getDay();
		Integer theirDay = getDay();
		return myDay.compareTo(theirDay);
	}
	
	public int getDay()
	{
		return day;
	}

	
	public int west() { return west; }
	public int east() { return east; }
	public int strength() { return strength; }
}
