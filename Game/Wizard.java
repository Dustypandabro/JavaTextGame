import java.util.*;
import java.io.IOException;
import java.time.*;

public class Wizard extends BaseCharacter
{
	public String type = "Wizard";
	public int health = 120;
	public int maxHealth = 120;//
	public int def = 50;
	public int strength = 20;
	public int exp = 0;
	public int stamina = 80;
	public int magic = 200;
	
	/////////////////////////////////////////
	
	@Override
	public int dealDmg()
	{
		int dmg = getStrength();
		return dmg;
		
	}
	
	@Override
	public int takeDmg(int dmg)
	{
		int remHp = dmg - (getDef()/10);
		int set = getHealth() - remHp;
		setHealth(set);
		
		return remHp;
		
	}
	
	/////////////////////////////////////////
	
	@Override
	public String getType()
	{
		return type;
		
	}
	
	@Override
	public int getMaxHeatlh()
	{
		return maxHealth;
		
	}
	
	@Override
	public int getHealth()
	{
		return this.health;
		
	}
	
	@Override
	public void setHealth(int hp)
	{
		health = hp;
		
		if(health > getMaxHeatlh())
		{
			health = getMaxHeatlh();
			
		}
		
	}
	
	@Override
	public int getStrength()
	{
		return strength;
		
	}
	
	@Override
	public void setStrength(int str)
	{
		this.strength = str;
		
	}
	
	@Override
	public int getDef()
	{
		return def;
		
	}
	
	@Override
	public void setDef(int sdef)
	{
		this.def = sdef;
		
	}
	
	@Override
	public int getXP()
	{
		return exp;
		
	}
	
	@Override
	public void setXP(int xp)
	{
		this.exp += (2 *xp);
		
	}
	
	@Override
	public int getStam()
	{
		return stamina;
		
	}
	
	@Override
	public void setStam(int stam)
	{
		this.stamina = stam;
		
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