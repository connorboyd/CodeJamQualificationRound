import java.io.*;
import java.util.*;

public class Main {


	
	private static String inputFile = "input.txt";
	private static String outputFile = "output.txt";
	private static int sampleSize;
	private static List<Game> gamesList;
	public static void main(String[] args) throws IOException
	{
		readShitFromFile();
		
		
		
		
	}
	
	public static void readShitFromFile() throws IOException
	{
		Scanner myScanner = new Scanner(new FileReader(inputFile));
		sampleSize = myScanner.nextInt();
		Scanner stringScanner;
		
		for(int i = 0; i < sampleSize; ++i)
		{
			gamesList = new ArrayList<Game>(sampleSize);
			int startingKeys = myScanner.nextInt();
			int numChests = myScanner.nextInt();
			ArrayList<Integer> keyList = new ArrayList<Integer>(startingKeys);
			
			for(int j = 0; j < startingKeys; ++j)	//add starting keys
			{
				keyList.add(myScanner.nextInt());
			}
			ArrayList<Chest> chestList = new ArrayList<Chest>(numChests);
			
			for(int j = 0; j < numChests; ++j)
			{
				int keyToOpen = myScanner.nextInt();
				String keysInside = myScanner.nextLine();
				stringScanner = new Scanner(keysInside);
				ArrayList<Integer> chestKeys = new ArrayList<Integer>();
				while(stringScanner.hasNextInt())
				{
					chestKeys.add(stringScanner.nextInt());
				}
				chestList.add(new Chest(keyToOpen, chestKeys));	
			}
			gamesList.add(new Game(keyList, chestList));
		}
		
		
	}
	
	
	public static void writeShitToFile() throws IOException
	{
		
	}
}
