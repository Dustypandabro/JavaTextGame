import java.io.*;
import java.math.*;
import java.util.*;

public class Reputation
{
	public int homeRep = 0;
	public int castleRep = 0;
	
	public int getHRep()
	{
		return homeRep;
		
	}
	
	public void setHRep(int rep)
	{
		homeRep = homeRep + rep;
		
		if(homeRep > 100)
		{
			homeRep = 100;
			System.out.println("Home Rep is at max. Rep:" + getHRep());
			
		}
		else if(homeRep < -100)
		{
			homeRep = -100;
			System.out.println("Home Rep is at lowest! Rep:" + getHRep());
			
		}
		
	}
	
	public void Reputation()
	{	
		//

	}		
	
}