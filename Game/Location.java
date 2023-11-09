import java.util.*;
import java.io.IOException;
import java.time.*;
import java.io.*;

public class Location
{
	public MyLinkedList<String> Home = new MyLinkedList<String>();
	public MyLinkedList<String> FarmVillage = new MyLinkedList<String>();
	public MyLinkedList<String> Castle = new MyLinkedList<String>();
	public MyLinkedList<String> CastleKeep = new MyLinkedList<String>();
	public MyLinkedList<String> CastleGrounds = new MyLinkedList<String>();
	public MyLinkedList<String> Shack = new MyLinkedList<String>();
	public MyLinkedList<String> Mountains = new MyLinkedList<String>();
	public MyLinkedList<String> Volcano = new MyLinkedList<String>();
	public MyLinkedList<String> DarkFort = new MyLinkedList<String>();
	public MyLinkedList<String> DarkFortGround = new MyLinkedList<String>();
	public MyLinkedList<String> Dungeon = new MyLinkedList<String>();
	public MyLinkedList<String> Beach = new MyLinkedList<String>();
	public MyLinkedList<String> OceanKeep = new MyLinkedList<String>();
	
	public String currentLoc = "Home";
	
	public String getCurrentLoc()
	{
		return currentLoc;
		
	}
	
	public void setCurrentLoc(String whereTo)
	{
		this.currentLoc = whereTo;
		
	}
	
	public boolean isLocCon(MyLinkedList list, String loc)
	{
		if(list.contains(loc))
		{
			return true;
			
		}
		
		return false;
		
	}
	
	public void loc()
	{
		System.out.println("This is the world of Zagaroth");
		
		Home.append("FarmVillage");
		Home.append("Beach");
		Home.append("Mountains");
		
		FarmVillage.append("Home");
		FarmVillage.append("Mountains");
		FarmVillage.append("Shack");
		FarmVillage.append("Castle");
		FarmVillage.append("Beach");
		
		Castle.append("FarmVillage");
		Castle.append("CastleGrounds");
		Castle.append("CastleKeep");
		
		CastleGrounds.append("Castle");
		CastleGrounds.append("CastleKeep");
		
		CastleKeep.append("Castle");
		CastleKeep.append("CastleGrounds");
		
		Shack.append("FarmVillage");
		Shack.append("Mountains");
		
		Mountains.append("Home");
		Mountains.append("FarmVillage");
		Mountains.append("Shack");
		Mountains.append("Volcano");
		Mountains.append("DarkFort");
		
		Beach.append("OceanKeep");
		Beach.append("Home");
		Beach.append("FarmVillage");
		
		OceanKeep.append("Beach");
		
		Volcano.append("Mountains");
		
		DarkFort.append("Mountains");
		DarkFort.append("DarkFortGround");
		
		DarkFortGround.append("DarkFort");
		
	}
	
}