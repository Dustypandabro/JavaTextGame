import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.*;

public class Book
{
	public String createBook(String bookName)
	{
		bookName = bookName + ".txt";
		
		try
		{
			File mybook = new File(bookName);
		
			if(mybook.createNewFile())
			{
				System.out.println("Created: " + mybook.getName());
				
			}
			else
			{
				System.out.println("already exists");
				
			}
			
			return bookName;
			
		}
		catch(IOException e)
		{
			System.out.println("Error occured");
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	public void WriteInBook(String filename, String story)
	{
		try
		{
			FileWriter mywrite = new FileWriter(filename, true);
			mywrite.write(story + "\n");
			mywrite.close();
			System.out.println("Done writing");
			
		}
		catch(IOException e)
		{
			System.out.println("Error occured");
			e.printStackTrace();
			
		}
		
	}
	
	public void ReadFromBook(String readFile)
	{
		File bookfile = new File(readFile);
		
		try
		{
			Scanner myread = new Scanner(bookfile);
			
			while(myread.hasNextLine())
			{
				String data = myread.nextLine();
				System.out.println(data);
				
			}
			
			myread.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error occured");
			e.printStackTrace();
			
		}
		
	}
	
	public void DelBook(String delFile)
	{
		File delbook = new File(delFile);
		
		if(delbook.delete())
		{
			System.out.println(delbook.getName() + " is deleted!");
			
		}
		else
		{
			System.out.println("Failed the delete");
			
		}
		
	}
	
	public void book()
	{
		System.out.println("This is a book");
		
	}
	
}