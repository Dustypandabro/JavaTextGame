import java.util.*;
import java.io.IOException;
import java.io.*;
import java.time.*;
import java.math.*;

public class Items
{
	public String itemName;
	public String itemType;
	public int itemValue = 0;
	
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
		System.out.println(getValue());
		
	}
	
	public void createItem(String name, String type, int val)
	{
		setName(name);
		setType(type);
		setvalue(val);
		
	}
	
}