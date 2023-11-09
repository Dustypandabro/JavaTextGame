import java.io.*;
import java.math.*;
import java.util.*;

public class Reputation
{
	public int homeRep = 0; // remove this was just for demo purpose 
	public int farmVillageRep = 0;
	public int castleRep = 0;
	public int darkFortRep = 0;
	public int oceanKeepRep = 0;
	
	public int getHRep()
	{
		return homeRep;
		
	}
	
	public void setHRep(int rep)
	{
		homeRep = rep;
		
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
	
	public int getFVRep()
	{
		return farmVillageRep;
		
	}
	
	public void setFVRep(int rep)
	{
		farmVillageRep = rep;
		
		if(farmVillageRep > 100)
		{
			farmVillageRep = 100;
			System.out.println("FarmVillage Rep is at max. Rep: " + getFVRep());
			
		}
		else if(farmVillageRep < -100)
		{
			farmVillageRep = -100;
			System.out.println("FarmVillage Rep is at lowest! Rep: " + getFVRep());
			
		}
		
	}
	
	public int getCastleRep()
	{
		return castleRep;
		
	}
	
	public void setCastleRep(int rep)
	{
		castleRep = rep;
		
		if(castleRep > 100)
		{
			castleRep = 100;
			System.out.println("Castle Rep is at max. Rep: " + getCastleRep());
			
		}
		else if(castleRep < -100)
		{
			castleRep = -100;
			System.out.println("Castle Rep is at lowest! Rep: " + getCastleRep());
			
		}
		
	}
	
	public int getDarkFortRep()
	{
		return darkFortRep;
		
	}
	
	public void setDarkFortRep(int rep)
	{
		darkFortRep = rep;
		
		if(darkFortRep > 100)
		{
			darkFortRep = 100;
			System.out.println("Dark fort Rep is at max. Rep: " + getDarkFortRep());
			
		}
		else if(darkFortRep < -100)
		{
			darkFortRep = -100;
			System.out.println("Dark fort Rep is at lowest! Rep: " + getDarkFortRep());
			
		}
		
	}
	
	public int getOceanKeepRep()
	{
		return oceanKeepRep;
		
	}
	
	public void setOceanKeepRep(int rep)
	{
		oceanKeepRep = rep;
		
		if(oceanKeepRep > 100)
		{
			oceanKeepRep = 100;
			System.out.println("Ocean Keep Rep is at max. Rep: " + getOceanKeepRep());
			
		}
		else if(oceanKeepRep < -100)
		{
			oceanKeepRep = -100;
			System.out.println("Ocean Keep Rep is at lowest! Rep: " + getOceanKeepRep());
			
		}
		
	}
	
	public void Reputation()
	{	
		setCastleRep(20);
		setDarkFortRep(-70);
		setFVRep(40);
		setOceanKeepRep(10);

	}		
	
}