import java.util.ArrayList;
public class Tribe {
	
	private int di,ni,wi,ei,si,deltad,deltap,deltas;
	
	public Tribe(int di,int ni,int wi, int ei,int si,int deltad,int deltap,int deltas)
	{
		this.di = di;
		this.ni = ni;
		this.wi = wi;
		this.ei = ei;
		this.si = si;
		this.deltad = deltad;
		this.deltap = deltap;
		this.deltas = deltas;
	}
	
	public int attacksThatSucceed()
	{
		int count = 0;
		for(int i = 0; i < ni; ++i)
		{
			if(attackSucceeds())
			{
				
			}
		}
		
		return -1;
	}
	
	public ArrayList<Attack> getAttacks()
	{
		int d = di;
		int w = wi;
		int e = ei;
		int s = si;
		ArrayList<Attack> attacks = new ArrayList<Attack>(ni);
		for(int i = 0; i < ni; ++i)
		{
			attacks.add(new Attack(d, w, e, s));
			d += deltad; w += deltap; e += deltap; s += deltas;
		}
		
		return attacks;
	}
	
	private boolean attackSucceeds()
	{
		return false;
	}
	
}
