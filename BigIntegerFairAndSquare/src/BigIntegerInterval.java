//import java.math.BigInteger;
import java.math.*;
//import java.util.*;
public class BigIntegerInterval {
	
	private BigInteger sqrtMin, sqrtMax;
	private static BigInteger one = new BigInteger("1");
	private static BigInteger width;
	
	public BigIntegerInterval(BigInteger minimum, BigInteger maximum)
	{
		Double doubleSqrtMin = Math.ceil( Math.sqrt(minimum.doubleValue()) );
		
//		doubleSqrtMin.
		
		sqrtMin = new BigInteger( dropDecimals( doubleSqrtMin.toString()) );
		
		Double doubleSqrtMax = Math.floor(Math.sqrt(maximum.doubleValue() ));
		sqrtMax = new BigInteger( dropDecimals ( doubleSqrtMax.toString() ));
		
		width = maximum.subtract(minimum);
	}
	
	public long countInInterval()
	{
		long numFandQ = 0;
		
		for(BigInteger i = sqrtMin; i.compareTo(sqrtMax) <= 0; i.add(one))
		{
			if(numIsPalindrome(i) && numIsPalindrome(i.multiply(i)))
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
	
	private boolean numIsPalindrome(BigInteger x)
	{
		return isPalindrome(x.toString());
	}
	
	private boolean isPalindrome(String s)
	{
		if(s.length() < 2) return true;
		
		return (s.charAt(0) == s.charAt(s.length()-1)) && isPalindrome(s.substring(1, s.length() - 1));
	}
	
	private String dropDecimals(String s)
	{
		for(int i = 0; i < s.length(); ++i)
		{
			if(s.charAt(i) == '.')
			{
				return s.substring(0, i);
			}
		}
		
		return s;
	}

}
