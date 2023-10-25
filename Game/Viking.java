import java.util.*;
import java.io.IOException;
import java.time.*;

public class Viking extends BaseCharacter
{
	public String type = "Viking";
	public int health = 120;
	public int def = 200;
	public int strength = 20;
	public int stamina = 80;
	
	/////////////////////////////////////////
	
	@Override
	public int dealDmg()
	{
		int dmg = getStrength()/10;
		return dmg;
		
	}
	
	@Override
	public void takeDmg(int dmg)
	{
		int remHp = 0 - dmg;
		setHealth(getHealth() + remHp);
		
	}
	
	/////////////////////////////////////////
	
	@Override
	public String getType()
	{
		return type;
		
	}
	
	@Override
	public int getHealth()
	{
		return health;
		
	}
	
	@Override
	public void setHealth(int hp)
	{
		this.health = hp;
		
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
	public int getStam()
	{
		return stamina;
		
	}
	
	@Override
	public void setStam(int stam)
	{
		this.stamina = stam;
		
	}
	
}