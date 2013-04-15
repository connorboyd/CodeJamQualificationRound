import java.util.*;
public class Chest {
	
	private int keyToOpen;
	private List<Integer> keysInside;
	
	public Chest(int key, List<Integer> keys)
	{
		keyToOpen = key;
		keysInside = keys;
		System.out.println("Chest created");
	}
	
	
	
	
	public boolean containsKey(Integer key)
	{
		return keysInside.contains(key);
	}
	
}
