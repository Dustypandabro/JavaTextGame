import java.util.*;
import java.io.IOException;
import java.time.*;
import java.io.*;

public class Location
{
	public MyLinkedList<String> Home = new MyLinkedList<String>();
	public MyLinkedList<String> Castle = new MyLinkedList<String>();
	public MyLinkedList<String> Shack = new MyLinkedList<String>();
	public MyLinkedList<String> Mountains = new MyLinkedList<String>();
	
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
		//System.out.println("This is the world of Zagaroth");
		
		Home.append("Castle");
		Home.append("Shack");
		
		Castle.append("Home");
		Castle.append("Mountains");
		
		Shack.append("Home");
		
		Mountains.append("Castle");
		
		//System.out.println(getCurrentLoc());
		//setCurrentLoc("Castle");
		//System.out.println(getCurrentLoc());
		//System.out.println("Showing connected Locations");
		//System.out.println(Castle);
		
	}
	
}