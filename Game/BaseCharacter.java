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
	public int maxHealth = 100;//
	public int def = 50;
	public int strength = 20;
	public int exp = 0;
	public int level = 0;
	public int stamina = 100;
	public int gold = 0;
	
	/////////////////////////////////////////
	
	public int dealDmg()
	{
		int dmg = getStrength();
		return dmg;
		
	}
	
	public int takeDmg(int dmg)
	{
		int remHp = dmg - (getDef()/10);
		int set = getHealth() - remHp;
		setHealth(set);
		
		return remHp;
		
	}
	
	public String Say()
	{
		Scanner words = new Scanner(System.in);
		String say = words.nextLine();
		
		return say;
		
	}
	
	public void checkLevelUp()
	{
		int reqXP = 0;
		reqXP = (getLevel() * 150);
		
		if(exp > reqXP)
		{
			level++;
			
		}
		
	}
	
	/////////////////////////////////////////
	
	public int getLevel()
	{
		return level;
		
	}
	
	public int getMaxHeatlh()
	{
		return maxHealth;
		
	}
	
	public void setMaxHeatlh(int mhp)
	{
		this.maxHealth = mhp;
		
	}
	
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
		
		if(health > getMaxHeatlh())
		{
			health = getMaxHeatlh();
			
		}
		
	}
	
	public int getStrength()
	{
		return strength;
		
	}
	
	public void setStrength(int str)
	{
		this.strength = str;
		
	}
	
	public int getDef()
	{
		return def;
		
	}
	
	public void setDef(int sdef)
	{
		this.def = sdef;
		
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
	
}