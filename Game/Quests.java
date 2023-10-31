import java.io.*;
import java.math.*;
import java.util.*;

public class Quests
{
	public String questName;
	public String questDesc;
	public boolean isComplete = false;
	public int objectives = 0;
	
	public MyLinkedList<String> obj = new MyLinkedList<>();
	
	public String getName()
	{
		return questName;
		
	}
	
	public void setName(String qName)
	{
		questName = qName;
		
	}
	
	public String getQDesc()
	{
		return questDesc;
		
	}
	
	public void setQDesc(String dName)
	{
		questDesc = dName;
		
	}
	
	public void setComplete()
	{
		isComplete = true;
		
	}
	
	public boolean isQuestDone()
	{
		if(objectives == 0)
		{
			setComplete();
			System.out.println("Quest: " + getName() + " is done!");
			return isComplete;
			
		}
		else
		{
			return isComplete;
			
		}
		
	}
	
	public void addQuestObjectives(String objective)
	{
		obj.append(objective);
		objectives++;
		
	}
	
	public void getObj()
	{
		System.out.println(obj.toString());
		
	}
	
	public void finishQuestObj()
	{
		obj.removeFirst();
		objectives--;
		
	}
	
	public void showQuestInfo()
	{
		System.out.println(getName());
		System.out.println(getQDesc());
		getObj();
		
	}
	
	public void createQuest(String name, String desc, String obj)
	{
		setName(name);
		setQDesc(desc);
		addQuestObjectives(obj);
		
	}
	
}