import java.util.*;
import java.io.IOException;
import java.io.*;
import java.time.*;
import java.math.*;

enum GameDiff
{
	EASY,
	MEDIUM,
	HARD
	
}

class RunGameBoi
{
	public int ctype = 0;
	public int gdiff = 1;
	public BaseCharacter player = null;
	
	public void SelectGamediff()
	{
		//Game Diff
		
		System.out.println("Choose game diff");
		System.out.println("1 - Easy");
		System.out.println("2- Med");
		System.out.println("3 - Hard");
		
		
		boolean diffselect = false;
		
		while(diffselect != true)
		{
			Scanner diff_in = new Scanner(System.in);
			gdiff = diff_in.nextInt();
		
			if(gdiff == 1)
			{
				GameDiff gamediff = GameDiff.EASY;
				System.out.println("The diff of the game is: " + gamediff);
				diffselect = true;
			
			}
			else if(gdiff == 2)
			{
				GameDiff gamediff = GameDiff.MEDIUM;
				System.out.println("The diff of the game is: " + gamediff);
				diffselect = true;
			
			}
			else if(gdiff == 3)
			{
				GameDiff gamediff = GameDiff.HARD;
				System.out.println("The diff of the game is: " + gamediff);
				diffselect = true;
			
			}
			else
			{
				System.out.println("It must be one of those numbers!");
			
			}
			
		}
		
	}
	
	public void selectChar()
	{
		//Set player chartype
		
		System.out.println("Choose Character type");
		System.out.println("1 - Normal");
		System.out.println("2- Wizard");
		System.out.println("3 - Barbarian");
		System.out.println("4 - Viking");
		System.out.println("5 - Hunter");
		System.out.println("6 - Deathwalker");
		
		////////////////////////////
		
		Scanner ct = new Scanner(System.in);
		int ctype = ct.nextInt();
		boolean charselect = false;
		
		while(charselect != true)
		{
			switch(ctype)
			{
				case(1):
				{
					//Normal
					player = new BaseCharacter();
					charselect = true;
					break;
					
				}
				case(2):
				{
					//Wizard
					player = new Wizard();
					charselect = true;
					break;
					
				}
				case(3):
				{
					//Barbarian
					player = new Barbarian();
					charselect = true;
					break;
					
				}
				case(4):
				{
					//Viking
					player = new Viking();
					charselect = true;
					break;
					
				}
				case(5):
				{
					//Hunter
					player = new Hunter();
					charselect = true;
					break;
					
				}
				case(6):
				{
					//Deathwalker
					player = new Deathwalker();
					charselect = true;
					break;
					
				}
				default:
				{
					System.out.println("Must be between 1 and 6");
					
				}
				
			}
			
		}
		
		System.out.println(player.getType());
		player.setXP(100);
		System.out.println(player.getXP());
		
	}
	
	public void Battle(BaseCharacter dummy1, BaseCharacter dummy2)
	{
		//BaseCharacter p1 = new BaseCharacter();
		//BaseCharacter p2 = new Barbarian();
		//String sentence = p2.Say();
		//p2.setName("John");
		//System.out.println(p2.getName() + " said: " + sentence);
		
		//System.out.println(p1.getType());
		//System.out.println(p2.getType());
		
		//Battle(p1, p2);
		
		int atcdmg1 = 0;
		int atcdmg2 = 0;
		int round = 1;
		
		while(dummy1.getHealth() > 0 && dummy2.getHealth() > 0)
		{
			System.out.println(round);
			atcdmg1 = dummy1.dealDmg();
			dummy2.takeDmg(atcdmg1);
			System.out.println("Done this amount of dmg: " + atcdmg1);
			if(dummy2.getHealth() > 0)
			{
				atcdmg2 =dummy2.dealDmg();
				dummy1.takeDmg(atcdmg2);
				System.out.println("Done this amount of dmg: " + atcdmg2);
				
			}
			
			round++;
			
		}
		System.out.println("Jobs done");
		
	}
	
	public void testWorldshit()
	{
		//idea of how to move to next loc etc.
		//Convert number to loc and set new loc
		/*System.out.println("Testing shit now");
		int test = 1;
		
		String tests = String.valueOf(test);;
		tests = world.currentLoc;
		System.out.println(test);
		System.out.println(tests);*/
		
		System.out.println("Testing world shit");
		Location world = new Location();
		world.loc();
		System.out.println(world.getCurrentLoc());
		world.setCurrentLoc("Mountains");
		System.out.println("Showing connected Locations");
		System.out.println(world.Mountains);
		
		if(world.isLocCon(world.Castle, "Home"))
		{
			System.out.println("On our way!");
			world.setCurrentLoc("Home");
			
		}
		else
		{
			System.out.println("This doesn't work");
			
		}
		
		System.out.println("Done");
		System.out.println(world.getCurrentLoc());
		
	}
	
	public void testbOOK()
	{
		Book book1 = new Book();
		String bName = book1.createBook("Awe");
		String text = "I have writen this shit!";
		book1.WriteInBook(bName, text);
		
		book1.ReadFromBook(bName);
		
		String text2 = "And this shit!";
		book1.WriteInBook(bName, text2);
		book1.ReadFromBook(bName);
		
		book1.DelBook(bName);
		
	}
	
	public int RNG()
	{
		double rng = (Math.random() * 10);
		int randn = (int) rng;
		
		return randn;
		
	}
	
	public void RepStuff()
	{
		Reputation rep = new Reputation();
		rep.setHRep(60);
		System.out.println(rep.getHRep());
		System.out.println("Reset rep");
		rep.setHRep(60);
		System.out.println(rep.getHRep());
		rep.setHRep(60);
		System.out.println(rep.getHRep());
		rep.setHRep(-190);
		System.out.println(rep.getHRep());
		rep.setHRep(-50);
		System.out.println(rep.getHRep());
		
	}
	
	public void questShit()
	{
		Quests MainQuest = new Quests();
		MainQuest.createQuest("Main", "This is the main quest");
		MainQuest.showQuestInfo();
		
		Quests SideQuest = new Quests();
		SideQuest.createQuest("Side", "This is the side quest");
		SideQuest.showQuestInfo();
		
		MainQuest.setComplete();
		MainQuest.addQuestObjectives("Go to the Shack.");
		MainQuest.addQuestObjectives("Go to the Mountain.");
		MainQuest.addQuestObjectives("Go to the Castle.");
		MainQuest.showQuestInfo();
		MainQuest.finishQuestObj();
		MainQuest.isQuestDone();
		SideQuest.isQuestDone();
		MainQuest.finishQuestObj();
		MainQuest.finishQuestObj();
		MainQuest.showQuestInfo();
		MainQuest.isQuestDone();
		
	}
	
	public void itemStuff()
	{
		Items sword = new Items();
		sword.createItem("Sword", "Short sword", 120);
		sword.showItemInfo();
		
	}
	
	public void runGame()
	{	
		//System.out.println("Awe");
		
		itemStuff();
		
	}
	
}