import java.util.*;
import java.io.IOException;
import java.time.*;

public class BaseCharacter
{
	public String name;
	public int health;
	public int exp;
	public int stamina;
	public int gold;
	public int magic;
	
	public String getName()
	{
		return name;
		
	}
	
	public void setName(String newName)
	{
		this.name = newName;
		
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