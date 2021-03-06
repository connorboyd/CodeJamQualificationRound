public class Interval {
	
	
//	private long min, max;
//	private long numFandQ = 0;
//	private Double doubleSqrtMin, doubleSqrtMax;
	private long sqrtMin, sqrtMax;
	
	public Interval(long minimum, long maximum)
	{
		Double doubleSqrtMin = Math.ceil( Math.sqrt(minimum) );
		sqrtMin = doubleSqrtMin.longValue();
		
		Double doubleSqrtMax = Math.floor(Math.sqrt(maximum));
		sqrtMax = doubleSqrtMax.longValue();
	}
	
	public long countInInterval()
	{
		long numFandQ = 0;
		
		for(long i = sqrtMin; i <= sqrtMax; ++i)
		{
			if(numIsPalindrome(i) && numIsPalindrome(i * i))
			{
				++numFandQ;
			}
		}
		return numFandQ;
		
		
//		for(long i = min; i <= max; ++i)
//		{
//			if(numIsPalindrome(i))
//			{
//				
//			}
//		}
		
		
		
	}
	
	private boolean numIsPalindrome(Long x)
	{
		return isPalindrome(x.toString());
	}
	
	private boolean isPalindrome(String s)
	{
		if(s.length() < 2) return true;
		
		return (s.charAt(0) == s.charAt(s.length()-1)) && isPalindrome(s.substring(1, s.length() - 1));
	}

}
