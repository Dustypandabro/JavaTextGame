import java.util.*;
import java.io.IOException;
import java.io.*;
import java.time.*;
import java.math.*;

public class Inventory
{
	public MyLinkedList<String> inventory = new MyLinkedList<>();
	public Items equipedItem = new Items();
	
	public void equipAnItem(Items item)
	{
		equipedItem.dequipItem();
		item.dequipItem();
		equipedItem = item;
		item.equipItem();
		equipedItem.equipItem();
		System.out.println("Equiped: " + equipedItem.getName());
		
	}
	
	public void showEquipedItem()
	{
		System.out.println(equipedItem.getName());
		
	}
	
	public void addToInventory(Items item)
	{
		inventory.append(item.getName());
		
	}
	
	public void removeItem(Items item)
	{
		inventory.delete(item.getName());
		
	}
	
	public void showInventory()
	{
		System.out.println("Inventory:");
		System.out.println(inventory.toString());
		
	}
	
}