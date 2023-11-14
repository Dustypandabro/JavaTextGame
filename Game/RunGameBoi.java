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
	public int playerActScan = 0;
	public boolean firstTime = true;
	public String bookName = "";
	public BaseCharacter player = null;
	public Book book1 = new Book();
	public Location world = new Location();
	public String prevLoc = "";
	public Inventory playerInventory = new Inventory();
	public Inventory farmVillageShopInventory = new Inventory();
	public Inventory castleShopInventory = new Inventory();
	public Inventory darkFortShopInventory = new Inventory();
	public Inventory oceanKeepShopInventory = new Inventory();
	public Reputation playerRep = new Reputation();
	
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
		
		Scanner diff_in = new Scanner(System.in);
		
		while(diffselect != true)
		{
			try
			{
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
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				diff_in.next();
				
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
		boolean charselect = false;
		
		while(charselect != true)
		{	
			try
			{
				ctype = ct.nextInt();
				
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
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				ct.next();
				
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
		
		Scanner baction = new Scanner(System.in);
		
		boolean whilewrite = true;
		boolean whilechoose = true;
		int bact = 0;
		
		while(whilechoose)
		{
			whilewrite = true;
			
			System.out.println("What would you like to do?");
			System.out.println("1. Read book.");
			System.out.println("2. Write Book.");
			System.out.println("3. Remove last line.");
			System.out.println("4. Exit.");
			
			bact = baction.nextInt();
			
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
				else if(bact == 4)
				{
					whilewrite = false;
					
				}
				else
				{
					System.out.println("Wrong number");
				
				}
			
			}
			
			System.out.println("Done, would you like to use the book again? 1.Yes or 2.No");
			
			Scanner cs = new Scanner(System.in);
			int ics = 0;
			
			try
			{
				ics = cs.nextInt();
			
				if(ics == 1)
				{
					System.out.println("what else?");
				
				}
				else if(ics == 2)
				{
					System.out.println("You close the book and think about what you wrote...");
					whilechoose = false;
				
				}
				else
				{
					System.out.println("Invalid");
					
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				cs.next();
				
			}
			
		}
		
		//book1.DelBook(bName);
		
	}
	
	///////////////////////////////
	//Shot Items
	
	public Items shortLongsword = new Items();//Barbarian
	public Items smallWarhammer = new Items();//Viking
	public Items shortStaff = new Items();//Wizard
	public Items bluntDaggers = new Items();//Hunter
	public Items shortWhip = new Items();//Deathwalker
	
	public Items originalLongsword = new Items();
	public Items longToothWarhammer = new Items();
	public Items blueStaff = new Items();
	public Items hazelDaggers = new Items();
	public Items fireWhip = new Items();
	
	public Items arthursLongsword = new Items();
	public Items nordicWarhammer = new Items();
	public Items staffOfGoodJuJU = new Items();
	public Items magicDaggers = new Items();
	public Items whipOfHades = new Items();
	
	public Items clownsLongsword = new Items();
	public Items sqweekyWarhammer = new Items();
	public Items wabbajack = new Items();
	public Items featherDaggers = new Items();
	public Items smWhip = new Items();
	
	public Items healthPotion = new Items();
	
	public void giveShopHealthPot(Inventory inv)
	{
		inv.addToInventory(healthPotion);
		
	}
	
	public void useHealthPotion()
	{
		if(playerInventory.contains(healthPotion.getName()))
		{
			player.setHealth(player.getMaxHeatlh());
			playerInventory.removeItem(healthPotion);
			
		}
		else
		{
			System.out.println("No health potion");
			
		}
		
	}
	
	///////////////////////////////
	//Shop Shit
	
	public void buyFromVendor(Inventory inv, Items buyItem)
	{
		int itemPrice = buyItem.getValue();
		int pGold = player.getGold();
		int newGold = 0;
		
		if(pGold > itemPrice)
		{
			playerInventory.addToInventory(buyItem);
			inv.removeItem(buyItem);
			
			newGold = pGold - itemPrice;
			player.setGold(newGold);
			
		}
		else
		{
			System.out.println("Not enough gold!");
			
		}
		
	}
	
	public void sellToVendor(Items sellItem, Inventory inv)
	{
		int itemPrice = sellItem.getValue();
		int pGold = player.getGold();
		int newGold = 0;
		
		playerInventory.removeItem(sellItem);
		inv.addToInventory(sellItem);
		
		newGold = pGold + itemPrice;
		player.setGold(newGold);
		
	}
	
	public void giveFarmShopShit()//balance all items
	{
		shortLongsword.createItem("Short long sword", "Long swords", 35, 150);//
		smallWarhammer.createItem("Small warhammer", "Warhammer", 3, 150);//
		shortStaff.createItem("Short staff", "Staff", 5, 150);//
		bluntDaggers.createItem("Blunt daggers", "Dagger", 3, 150);//
		shortWhip.createItem("Short whip", "Whip", 5, 150);//
		
		farmVillageShopInventory.addToInventory(shortLongsword);
		farmVillageShopInventory.addToInventory(smallWarhammer);
		farmVillageShopInventory.addToInventory(shortStaff);
		farmVillageShopInventory.addToInventory(bluntDaggers);
		farmVillageShopInventory.addToInventory(shortWhip);
		
	}
	
	public void giveCastleShopShit()
	{
		originalLongsword.createItem("Short long sword", "Long swords", 35, 150);//
		longToothWarhammer.createItem("Small warhammer", "Warhammer", 3, 150);//
		blueStaff.createItem("Short staff", "Staff", 5, 150);//
		hazelDaggers.createItem("Blunt daggers", "Dagger", 3, 150);//
		fireWhip.createItem("Short whip", "Whip", 5, 150);//
		
		castleShopInventory.addToInventory(originalLongsword);
		castleShopInventory.addToInventory(longToothWarhammer);
		castleShopInventory.addToInventory(blueStaff);
		castleShopInventory.addToInventory(hazelDaggers);
		castleShopInventory.addToInventory(fireWhip);
		
	}
	
	public void giveOceanShopShit()
	{
		arthursLongsword.createItem("Short long sword", "Long swords", 35, 150);//
		nordicWarhammer.createItem("Small warhammer", "Warhammer", 3, 150);//
		staffOfGoodJuJU.createItem("Short staff", "Staff", 5, 150);//
		magicDaggers.createItem("Blunt daggers", "Dagger", 3, 150);//
		whipOfHades.createItem("Short whip", "Whip", 5, 150);//
		
		castleShopInventory.addToInventory(arthursLongsword);
		castleShopInventory.addToInventory(nordicWarhammer);
		castleShopInventory.addToInventory(staffOfGoodJuJU);
		castleShopInventory.addToInventory(magicDaggers);
		castleShopInventory.addToInventory(whipOfHades);
		
	}
	
	public void giveDarkFortShopShit()
	{
		clownsLongsword.createItem("Short long sword", "Long swords", 35, 150);//
		sqweekyWarhammer.createItem("Small warhammer", "Warhammer", 3, 150);//
		wabbajack.createItem("Short staff", "Staff", 5, 150);//
		featherDaggers.createItem("Blunt daggers", "Dagger", 3, 150);//
		smWhip.createItem("Short whip", "Whip", 5, 150);//
		
		castleShopInventory.addToInventory(clownsLongsword);
		castleShopInventory.addToInventory(sqweekyWarhammer);
		castleShopInventory.addToInventory(wabbajack);
		castleShopInventory.addToInventory(featherDaggers);
		castleShopInventory.addToInventory(smWhip);
		
	}
	
	public void giveAllShopShit()
	{
		giveCastleShopShit();
		giveDarkFortShopShit();
		giveFarmShopShit();
		giveOceanShopShit();
		
	}
	
	public Inventory getShopInv()
	{
		String cl = world.getCurrentLoc();
		Inventory inv = new Inventory();
		
		if(cl.equals("FarmVillage"))
		{
			inv = farmVillageShopInventory;
			
		}
		else if(cl.equals("CastleGrounds"))
		{
			inv = castleShopInventory;
			
		}
		else if(cl.equals("DarkFortGround"))
		{
			inv = darkFortShopInventory;
			
		}
		else if(cl.equals("OceanKeep"))
		{
			inv = oceanKeepShopInventory;
			
		}
		else
		{
			System.out.println("Invalid.");
			
		}
		
		return inv;
		
	}
	
	public void ShopOps()//Add choosing items // recreate this method to genererilize shop and to search for dialog
	{	
		Inventory inv = getShopInv();
		
		inv.showInventory();
		
		System.out.println("Choose what to do in shop. 1/2");
		Scanner shopScan = new Scanner(System.in);
		int fvso = shopScan.nextInt();
		
		if(fvso == 1)
		{
			buyFromVendor(inv, shortLongsword);
			
		}
		else if(fvso == 2)
		{
			sellToVendor(shortLongsword, inv);

		}
		else
		{
			System.out.println("Invalid option.");
			
		}
		
		/*farmVillageShopInventory.showInventory();//EG: get shop loc and print shop intro
		
		Scanner farmVilScan = new Scanner(System.in);//while loop shop convo and what player wanna do. Generalize and maybe add mid dialog
		int fvso = farmVilScan.nextInt();
		
		System.out.println("Choose what to do in shop. 1/2");//print shop outro same as intro just dif method for outro dialog
		
		if(fvso == 1)
		{
			buyFromVendor(farmVillageShopInventory, shortLongsword);
			
		}
		else if(fvso == 2)
		{
			sellToVendor(shortLongsword, farmVillageShopInventory);

		}
		else
		{
			System.out.println("Invalid option.");
			
		}
		
		playerInventory.showInventory();
		farmVillageShopInventory.showInventory();*/
			
	}
	
	///////////////////////////////
	//Player shit
	
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
	
	public String getPrevLoc()
	{
		return prevLoc;
		
	}
	
	public void setPrevLoc(String loc)
	{
		prevLoc = loc;
		
	}
	
	public void returnPrevLocCuzRep()
	{
		System.out.println("Moving Back");
		world.setCurrentLoc(getPrevLoc());
		
	}
	
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
		setPrevLoc(world.getCurrentLoc());
		
		System.out.print("Type in location: ");
		Scanner whereTo = new Scanner(System.in);
		String loc = whereTo.nextLine();
		
		if(loc.equals("FarmVillage"))
		{
			if(checkFarmVillageRep())
			{
				moveToLoc(loc);
				
			}
			
		}
		else if(loc.equals("Castle"))
		{
			if(checkCaslteRep())
			{
				moveToLoc(loc);
				
			}
			
		}
		else if(loc.equals("DarkFort"))
		{
			if(checkDarkFortRep())
			{
				moveToLoc(loc);
				
			}
			
		}
		else if(loc.equals("OceanKeep"))
		{
			if(checkOceanKeepRep())
			{
				moveToLoc(loc);
				
			}
			
		}
		else
		{
			moveToLoc(loc);
			
		}
		
	}
	
	public void explore()
	{	
		if(world.getCurrentLoc().equals("Home"))
		{
			homeOps();
			
		}
		else if(world.getCurrentLoc().equals("FarmVillage"))
		{
			farmVillageOps();
			
		}
		else if(world.getCurrentLoc().equals("Castle"))
		{
			castleOps();
			
		}
		else if(world.getCurrentLoc().equals("CastleGrounds"))
		{
			castleGroundsOps();
			
		}
		else if(world.getCurrentLoc().equals("CastleKeep"))
		{
			castleKeepOps();
			
		}
		else if(world.getCurrentLoc().equals("Shack"))
		{
			shackOps();
			
		}
		else if(world.getCurrentLoc().equals("Mountains"))
		{
			mountainsOps();
			
		}
		else if(world.getCurrentLoc().equals("Volcano"))
		{
			volcanoOps();
			
		}
		else if(world.getCurrentLoc().equals("DarkFort"))
		{
			darkFortOps();
			
		}
		else if(world.getCurrentLoc().equals("DarkFortGround"))
		{
			darkFortGroundOps();
			
		}
		else if(world.getCurrentLoc().equals("Beach"))
		{
			beachOps();
			
		}
		else if(world.getCurrentLoc().equals("OceanKeep"))
		{
			oceanKeepOps();
			
		}
		else
		{
			System.out.println("Invalid location?");
			System.out.println("You awake awkwardly at home wondering wtf happened? Your day continues...");
			world.setCurrentLoc("Home");
			
		}
		
	}
	
	///////////////////////////////
	//Location Rep checks
	
	public boolean checkFarmVillageRep()
	{
		int fvr = playerRep.getFVRep();
		if(fvr > 95)
		{
			System.out.println("Very good rep. Rep: " + fvr);
			return true;
			
		}
		else if(fvr > 0)
		{
			System.out.println("Normal rep. Rep: " + fvr);
			return true;
			
		}
		else
		{
			System.out.println("Work on rep man. Rep: " + fvr);
			return false;
			
		}
		
	}
	
	public boolean checkCaslteRep()
	{
		int cr = playerRep.getCastleRep();
		
		if(cr > 95)
		{
			System.out.println("Very good rep.");
			return true;
			
		}
		else if(cr >= 0)
		{
			System.out.println("Normal rep " + cr);
			return true;
			
		}
		else
		{
			System.out.println("Work on rep man");
			return false;
			
		}
		
	}
	
	public boolean checkDarkFortRep()
	{
		int dfr = playerRep.getDarkFortRep();
		
		if(dfr > 95)
		{
			System.out.println("Very good rep.");
			return true;
			
		}
		else if(dfr > 0)
		{
			System.out.println("Normal rep");
			return true;
			
		}
		else
		{
			System.out.println("Work on rep man");
			return false;
			
		}
		
	}
	
	public boolean checkOceanKeepRep()
	{
		int okr = playerRep.getOceanKeepRep();
		
		if(okr > 95)
		{
			System.out.println("Very good rep.");
			return true;
			
		}
		else if(okr > 0)
		{
			System.out.println("Normal rep");
			return true;
			
		}
		else
		{
			System.out.println("Work on rep man");
			return false;
			
		}
		
	}
	
	///////////////////////////////
	//Location methods
	
	public void homeOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look at house.");
		System.out.println("2. Go to bed.");
		System.out.println("3. Eat something.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					System.out.println("You look at your beaty of a house.");
					pasb = false;
			
				}
				else if(playerActScan == 2)
				{
					System.out.println("You take a quick nap.");
					pasb = false;
			
				}
				else if(playerActScan == 3)
				{
					System.out.println("You eat a bacon and cheese sandwich.");
					pasb = false;
				
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void farmVillageOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. Look in shop.");
		System.out.println("2. Leave shop.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					ShopOps();
					pasb = false;
			
				}
				else if(playerActScan == 2)
				{
					pasb = false;
					
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void castleOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look at castle.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					System.out.println("You look at your beaty of the castle.");
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void castleGroundsOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look in Castle shop.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					ShopOps();
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void castleKeepOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. Talk to the King.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					System.out.println("The King looks at you and says 'Sup'.");
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void shackOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look at shack.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					System.out.println("You look at the shack and see something wiggle.");
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void mountainsOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look at drop.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					System.out.println("You look down and wonder what could have been.");
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void volcanoOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look at Volcano.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					System.out.println("You look at the volcano, it feels hot. Suddenly you see a door in the far, what could it be?");
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void darkFortOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look around.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					System.out.println("Everything is coverd in dark vines and it looks spooky, hope nothing bad lurks around.");
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void darkFortGroundOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look in shop.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					ShopOps();
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void beachOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look at beach.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					System.out.println("You look at your beaty of the beach and wonder what would happen if you lay down your weapon and retire with your feet in the sand. Suddenly you remeber how fucking cool you are and shout heroic!");
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	public void oceanKeepOps()
	{
		System.out.println("You are here: " + world.getCurrentLoc());
		System.out.println("What would you like to do here?");
		System.out.println(" ");
		System.out.println("1. look in ocean shop.");
		
		Scanner paScan = new Scanner(System.in);
		boolean pasb = true;
		
		while(pasb)
		{
			try
			{
				playerActScan = paScan.nextInt();
				
				if(playerActScan == 1)
				{
					ShopOps();
					pasb = false;
			
				}
				else
				{
					System.out.println("Inavlid action");
			
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				paScan.next();
				
			}
			
		}
		
	}
	
	///////////////////////////////
	//Main game method
	
	public void createGameSettings()
	{
		SelectGamediff();
		selectChar();
		world.loc();
		playerRep.Reputation();
		giveAllShopShit();
		
	}
	
	///////////////////////////////
	//Game loop
	
	public void play()
	{
		Scanner action = new Scanner(System.in);
		
		try
			{
				System.out.println("You are currently in -> " + world.getCurrentLoc());
				System.out.println("What will you like to do?");
				System.out.println("1. Explore current loc");
				System.out.println("2. Exit");
				System.out.println("3. Use book");
				System.out.println("4. Battle");
				System.out.println("5. Move");
				System.out.println("6. Inventory shit");
			
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
					//Battle(p2);
				
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
			catch(InputMismatchException e)
			{
				System.out.println("Inavlid action. Enter int.");
				action.next();
				
			}
		
	}
	
	public void runGame()
	{	
		createGameSettings();
		
		//System.out.println(playerInventory.equipedItem.getName());
		//playerInventory.equipAnItem(shortLongsword);
		//System.out.println(playerInventory.equipedItem.getName());
		
		while(isPlayeralive())
		{
			play();
			
		}
		
		System.out.println("Thanks for playing!");
		
	}
	
	///////////////////////////////
	//Demo Shit
	
	public void RepStuff()
	{
		/*playerRep.setHRep(60);
		System.out.println(playerRep.getHRep());
		System.out.println("Reset rep");
		playerRep.setHRep(60);
		System.out.println(playerRep.getHRep());
		playerRep.setHRep(60);
		System.out.println(playerRep.getHRep());
		playerRep.setHRep(-190);
		System.out.println(playerRep.getHRep());
		playerRep.setHRep(-50);
		System.out.println(playerRep.getHRep());*/
		
	}
	
	public void questShit()
	{
		/*Quests MainQuest = new Quests();
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
		MainQuest.isQuestDone();*/
		
	}
	
	public void invetoryShit() // can be used for shop
	{
		/*Items Longsword = new Items();
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
		
		System.out.println("Done");*/
		
	}
	
}