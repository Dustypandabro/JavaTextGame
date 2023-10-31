import java.util.*;
import java.io.IOException;
import java.io.*;
import java.time.*;
import java.math.*;

public class Items
{
	public String itemName;
	public String itemType;
	public int dmgIncrease = 0;
	public int itemValue = 0;
	public boolean itemEquiped = false;//add this shit
	
	public void equipItem()
	{
		itemEquiped = true;
		
	}
	
	public void dequipItem()
	{
		itemEquiped = false;
		
	}
	
	public boolean checkIfItemEquiped()
	{
		if(itemEquiped)
		{
			return true;
			
		}
		
		return false;
		
	}
	
	public String getName()
	{
		return itemName;
		
	}
	
	public void setName(String name)
	{
		itemName = name;
		
	}
	
	public String getType()
	{
		return itemType;
		
	}
	
	public void setType(String type)
	{
		itemType = type;
		
	}
	
	public int getValue()
	{
		return itemValue;
		
	}
	
	public void setvalue(int val)
	{
		itemValue = val;
		
	}
	
	public void showItemInfo()
	{
		System.out.println(getName());
		System.out.println(getType());
		System.out.println(getDmgIn());
		System.out.println(getValue());
		
	}
	
	public void setDmgIn(int dmg)
	{
		dmgIncrease = dmg;
		
	}
	
	public int getDmgIn()
	{
		return dmgIncrease;
		
	}
	
	public void createItem(String name, String type, int dmg, int val)
	{
		setName(name);
		setType(type);
		setDmgIn(dmg);
		setvalue(val);
		
	}
	
}