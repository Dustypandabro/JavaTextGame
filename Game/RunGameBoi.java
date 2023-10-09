import java.util.*;
import java.io.IOException;
import java.time.*;

enum GameDiff
{
	EASY,
	MEDIUM,
	HARD
	
}

class RunGameBoi
{
	public int ctype = 0;
	public BaseCharacter player;
	
	public void runGame()
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
			int gdiff = diff_in.nextInt();
		
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
		
		//Set player chartype
		
		System.out.println("Choose Character type");
		System.out.println("1 - Normal");
		System.out.println("2- Wizard");
		System.out.println("3 - Barbarian");
		System.out.println("4 - Viking");
		System.out.println("5 - Hunter");
		System.out.println("6 - Deathwalker");
		
		Scanner ct = new Scanner(System.in);
		
		while(ctype == 0)
		{
			ctype = ct.nextInt();
			if (ctype > 0 && ctype < 7) 
			{
				break;
				
			} 
			else 
			{
				System.out.println("Choose the right number!");
				ctype = 0;
			}
		}
		if (ctype == 1) 
		{
			// Normal
			this.player = new BaseCharacter();
		} 
		else if (ctype == 2) 
		{
			// Wizard
			this.player = new Wizard();
		}
		
		//Fix Char select
		System.out.println(player.getType());
		
		//Scanner pname = new Scanner(System.in);
		//String playername = pname.nextLine();
		//BaseCharacter player = new BaseCharacter();
		//player.setName(playername);
		//System.out.println("the player name is: " + player.getName());
		
		//BaseCharacter wizardp = new Wizard();
		//wizardp.setName("Merlin");
		
		//System.out.println("this is wizard xp");
		//System.out.println(wizardp.getName() + " xp: " + wizardp.getXP());		
		//System.out.println("New wizard xp");
		//wizardp.setXP(100);
		//System.out.println(wizardp.getName() + " xp: " + wizardp.getXP());
		//System.out.println(" ");
		//System.out.println("this is player xp");
		//System.out.println(player.getName() + " xp: " + player.getXP());
		
		
	}
	
}