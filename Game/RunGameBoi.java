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
	public void runGame()
	{
		//System.out.println("Sup");
		
		System.out.println("Choose game diff");
		System.out.println("1 - Easy");
		System.out.println("2- Med");
		System.out.println("3 - Hard");
		
		Scanner diff_in = new Scanner(System.in);
		int gdiff = diff_in.nextInt();
		boolean diffselect = false;
		
		while(diffselect != true)
		{
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
				System.out.println("Ity must be one of those 	numbers!");
			
			}
			
			BaseCharacter player = new BaseCharacter();
			player.setName("John Doe");
			System.out.println(player.getName());
			
		}
		
	}
	
}