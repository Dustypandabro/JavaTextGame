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

public class RunGameBoi
{
	public int ctype = 0;
	public int gdiff = 1;
	public int dmgMod = 1;
	public boolean firstTime = true;
	public String bookName = "";
	public BaseCharacter player = null;
	public Book book1 = new Book();
	public Location world = new Location();
	public Inventory playerInventory = new Inventory();
	
	///////////////////////////////
	//Game settings
	
	public void SelectGamediff()
	{
		//Game Diff
		
		System.out.println("Choose game diff");
		System.out.println("1 - Easy");
		System.out.println("2- Med");
		System.out.println("3 - Hard");
		
		
		boolean diffselect = false;
		String gds = "Easy";
		
		while(diffselect != true)
		{
			Scanner diff_in = new Scanner(System.in);
			gdiff = diff_in.nextInt();
		
			if(gdiff == 1)
			{
				GameDiff gamediffs = GameDiff.EASY;
				gds = "Easy";
				System.out.println("The diff of the game is: " + gamediffs);
				diffselect = true;
			
			}
			else if(gdiff == 2)
			{
				GameDiff gamediffs = GameDiff.MEDIUM;
				gds = "Med";
				System.out.println("The diff of the game is: " + gamediffs);
				diffselect = true;
			
			}
			else if(gdiff == 3)
			{
				GameDiff gamediffs = GameDiff.HARD;
				gds = "Hard";
				System.out.println("The diff of the game is: " + gamediffs);
				diffselect = true;
			
			}
			else
			{
				System.out.println("It must be one of those numbers!");
			
			}
			
		}
		
		diffucltyModifier(gds);
		
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
	
	public void diffucltyModifier(String diff)
	{
		if(diff == "Easy")
		{
			dmgMod = 1;
			
		}
		else if(diff == "Med")
		{
			dmgMod = 2;
			
		}
		else
		{
			dmgMod = 3;
			
		}
		
	}
	
	public int RNG()
	{
		double rng = (Math.random() * 10);
		int randn = (int) rng;
		
		return randn;
		
	}
	
	///////////////////////////////
	//Battle stuff
	
	public void Battle(BaseCharacter dummy2) //BaseCharacter dummy1, BaseCharacter dummy2) //balance
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
		
		while(player.getHealth() > 0 && dummy2.getHealth() > 0)
		{
			System.out.println(" ");
			System.out.println("This is round: " + round);
			System.out.println(player.getHealth());
			
			atcdmg1 = player.dealDmg();
			int thisDmg = dummy2.takeDmg(atcdmg1);
			System.out.println("You done this amount of dmg: " + thisDmg);
			System.out.println("Enemy HP left: " + dummy2.getHealth());
			if(dummy2.getHealth() > 0)
			{
				System.out.println("Enemy turn.");
				atcdmg2 = (dummy2.dealDmg() * (dmgMod)); //Enemy attacks mod
				int thisDmg2 = player.takeDmg(atcdmg2);
				System.out.println("Enemy done this amount of dmg: " + thisDmg2);
				System.out.println("Your HP left: " + player.getHealth());
				
			}
			
			round++;
			
			if(round == 10)
			{
				killPlayer();
				
			}
			
		}
		
		if(player.getHealth() > 0)
		{
			System.out.println("You won!");
			
		}
		else
		{
			System.out.println("You lose!");
			killPlayer();
			
		}
		
	}
	
	///////////////////////////////
	//Book stuff
	
	public String nameBook(String name)
	{
		String bName = book1.createBook(name);
		
		return bName;
		
	}
	
	public void writeToBook(String bname, String text)
	{
		book1.WriteInBook(bname, text);
		
	}
	
	public void readFromBook(String bname)
	{
		book1.ReadFromBook(bname);
		
	}
	
	public void removeLastLine(String fname)
	{
		book1.removeLastLine(fname);
		
	}
	
	public void useBook()
	{	
		if(firstTime)
		{
			System.out.println("First time sing book. Name it!");
			Scanner bookn = new Scanner(System.in);
			String bn = bookn.nextLine();
			bookName = nameBook(bn);
			firstTime = false;
			
		}
		
		System.out.println("What would you like to do?");
		System.out.println("1. Read book.");
		System.out.println("2. Write Book.");
		System.out.println("3. Remove last line.");
		Scanner baction = new Scanner(System.in);
		int bact = baction.nextInt();
		
		boolean whilewrite = true;
		
		while(whilewrite)
		{
			if(bact == 1)
			{
				readFromBook(bookName);
				whilewrite = false;
			
			}
			else if(bact == 2)
			{
				Scanner writeBook = new Scanner(System.in);
				String writeb = writeBook.nextLine();
				writeToBook(bookName, writeb);
				whilewrite = false;
			
			}
			else if(bact == 3)
			{
				removeLastLine(bookName);
				whilewrite = false;
			
			}
			else
			{
				System.out.println("Wrong number");
			
			}
			
		}
		
		//book1.DelBook(bName);
		
	}
	
	///////////////////////////////
	//Player shit
	
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
		MainQuest.createQuest("Main", "This is the main quest", "start the quest");
		MainQuest.showQuestInfo();
		
		Quests SideQuest = new Quests();
		SideQuest.createQuest("Side", "This is the side quest", "start the quest obj");
		SideQuest.showQuestInfo();
		
		MainQuest.setComplete();
		MainQuest.addQuestObjectives("Go to the Shack.");
		MainQuest.addQuestObjectives("Go to the Mountain.");
		MainQuest.addQuestObjectives("Go to the Castle.");
		MainQuest.showQuestInfo();
		MainQuest.finishQuestObj();
		MainQuest.finishQuestObj();
		MainQuest.isQuestDone();
		SideQuest.isQuestDone();
		MainQuest.finishQuestObj();
		MainQuest.finishQuestObj();
		MainQuest.showQuestInfo();
		MainQuest.isQuestDone();
		
	}
	
	public void invetoryShit() // can be used for shop
	{
		Items Longsword = new Items();
		Longsword.createItem("Long sword", "Long swords", 35, 150);
		
		Items sword = new Items();
		sword.createItem("Sword", "Short sword", 25, 120);
		sword.showItemInfo();
		
		playerInventory.addToInventory(sword);
		playerInventory.addToInventory(Longsword);
		playerInventory.showInventory();
		System.out.println("Removing item");
		playerInventory.removeItem(sword);
		playerInventory.showInventory();
		playerInventory.equipAnItem(sword);
		System.out.println("Item equiped");
		playerInventory.showEquipedItem();
		System.out.println("Item equiped");
		playerInventory.equipAnItem(Longsword);
		playerInventory.showEquipedItem();
		
		System.out.println("Done");
		
	}
	
	public void killPlayer()
	{
		player.setHealth(0);
		
	}
	
	public boolean isPlayeralive()
	{
		if(player.getHealth() > 0)
		{
			return true;
			
		}
		
		return false;
		
	}
	
	///////////////////////////////
	//Movement through the game
	
	public void showConLoc()
	{
		if(world.getCurrentLoc().equals("Home"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.Home);
			
		}
		else if(world.getCurrentLoc().equals("FarmVillage"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.FarmVillage);
			
		}
		else if(world.getCurrentLoc().equals("Castle"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.Castle);
			
		}
		else if(world.getCurrentLoc().equals("CastleGrounds"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.CastleGrounds);
			
		}
		else if(world.getCurrentLoc().equals("CastleKeep"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.CastleKeep);
			
		}
		else if(world.getCurrentLoc().equals("Shack"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.Shack);
			
		}
		else if(world.getCurrentLoc().equals("Mountains"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.Mountains);
			
		}
		else if(world.getCurrentLoc().equals("Volcano"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.Volcano);
			
		}
		else if(world.getCurrentLoc().equals("DarkFort"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.DarkFort);
			
		}
		else if(world.getCurrentLoc().equals("DarkFortGround"))
		{
			System.out.println("Showing connected Locations");
			System.out.println(world.DarkFortGround);
			
		}
		else if(world.getCurrentLoc().equals("Beach"))
		{
			System.out.println("Showing connected locations");
			System.out.println(world.Beach);
			
		}
		else if(world.getCurrentLoc().equals("OceanKeep"))
		{
			System.out.println("Showing connected locations");
			System.out.println(world.OceanKeep);
			
		}
		else if(world.getCurrentLoc().equals("Dungeon"))
		{
			System.out.println("Showing connected locations");
			System.out.println(world.Dungeon);
			
		}
		else
		{
			System.out.println("Nope");
			
		}
		
	}
	
	public void moveToLoc(String loc)
	{
		if(world.getCurrentLoc().equals("Home"))
		{
			if(world.isLocCon(world.Home, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("FarmVillage"))
		{
			if(world.isLocCon(world.FarmVillage, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
				
			}
			
		}
		else if(world.getCurrentLoc().equals("Castle"))
		{
			if(world.isLocCon(world.Castle, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("CastleGrounds"))
		{
			if(world.isLocCon(world.CastleGrounds, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("CastleKeep"))
		{
			if(world.isLocCon(world.CastleKeep, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("Mountains"))
		{
			if(world.isLocCon(world.Mountains, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("Volcano"))
		{
			if(world.isLocCon(world.Volcano, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("DarkFort"))
		{
			if(world.isLocCon(world.DarkFort, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("DarkFortGround"))
		{
			if(world.isLocCon(world.DarkFortGround, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("Shack"))
		{
			if(world.isLocCon(world.Shack, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("Beach"))
		{
			if(world.isLocCon(world.Beach, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("OceanKeep"))
		{
			if(world.isLocCon(world.OceanKeep, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else if(world.getCurrentLoc().equals("Dungeon"))
		{
			if(world.isLocCon(world.Dungeon, loc))
			{
				world.setCurrentLoc(loc);
				System.out.println("Moving to -> " + world.getCurrentLoc());
			
			}
			
		}
		else
		{
			System.out.println("Wrong location.");
			
		}
		
	}
	
	public void movement()
	{
		showConLoc();
		
		System.out.print("Type in location: ");
		Scanner whereTo = new Scanner(System.in);
		String loc = whereTo.nextLine();
		
		moveToLoc(loc);
		
	}
	
	public void explore() //add more locations and build
	{	
		if(world.getCurrentLoc().equals("Home"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("FarmVillage"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("Castle"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("CastleGrounds"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("CastleKeep"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("Shack"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("Mountains"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("Volcano"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("DarkFort"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("DarkFortGround"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("Beach"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else if(world.getCurrentLoc().equals("OceanKeep"))
		{
			System.out.println("You are here: " + world.getCurrentLoc());
			
		}
		else
		{
			System.out.println("Invalid location?");
			System.out.println("You awake awkwardly at home wondering wtf happened? Your day continues...");
			world.setCurrentLoc("Home");
			
		}
		
	}
	
	///////////////////////////////
	//Main game method
	
	public void createGameSettings()
	{
		SelectGamediff();
		selectChar();
		world.loc();
		
		
	}
	
	///////////////////////////////
	//Game loop
	public void runGame()
	{	
		createGameSettings();
		BaseCharacter p2 = new Barbarian();
		//System.out.println(player.getHealth());
		
		while(isPlayeralive())
		{
			System.out.println("You are currently in -> " + world.getCurrentLoc());
			System.out.println("What will you like to do?");
			System.out.println("1. Explore current loc");
			System.out.println("2. Exit");
			System.out.println("3. Use book");
			System.out.println("4. Battle");
			System.out.println("5. Move");
			System.out.println("6. Inventory shit");
			
			Scanner action = new Scanner(System.in);
			int act = action.nextInt();
			
			if(act == 1)
			{
				explore();
				
			}
			else if(act == 2)
			{
				killPlayer();
				
			}
			else if(act == 3)
			{
				useBook();
				
			}
			else if(act == 4)
			{
				Battle(p2);
				
			}
			else if(act == 5)
			{
				movement();
				
			}
			else if(act == 6)
			{
				invetoryShit();
				
			}
			else
			{
				System.out.println("Invalid");
				
			}
			
			//Battle(p2); //player, p2);
			
		}
		
		//System.out.println(world.getCurrentLoc());
		//System.out.println(dmgMod);
		System.out.println("Done");
		
	}
	
}