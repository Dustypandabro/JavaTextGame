import java.util.*;
import java.io.IOException;
import java.time.*;

/*
Wizard-
Barbarian-
Viking-
Hunter-
Deathwalker-
*/

public class BaseCharacter
{
	public String name;
	public String type = "Normal";
	public int health = 100;
	public int def = 50;
	public int exp = 0;
	public int stamina = 100;
	public int gold = 0;
	public int magic = 0;
	
	public String getName()
	{
		return name;
		
	}
	
	public void setName(String newName)
	{
		this.name = newName;
		
	}
	
	public String getType()
	{
		return type;
		
	}
	
	public int getHealth()
	{
		return health;
		
	}
	
	public void setHealth(int hp)
	{
		this.health = hp;
		
	}
	
	public int getXP()
	{
		return exp;
		
	}
	
	public void setXP(int xp)
	{
		this.exp += xp;
		
	}
	
	public int getStam()
	{
		return stamina;
		
	}
	
	public void setStam(int stam)
	{
		this.stamina = stam;
		
	}
	
	public int getGold()
	{
		return gold;
		
	}
	
	public void setGold(int coin)
	{
		this.gold += coin;
		
	}
	
	public int getMagic()
	{
		return magic;
		
	}
	
	public void setMagic(int mana)
	{
		this.magic = mana;
		
	}
	
}