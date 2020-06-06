import java.util.*;

public class ToDoList {
	
	private static ArrayList<String> list = new ArrayList<String>();
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String [] args)
	{
		String action;
		
		action = prompt();
		
		while(!action.contentEquals("exit"))
		{
			switch (action)
			{
				case "add an item":
					addItem();
					action = prompt();
					break;
				case "remove an item":
					removeItem();
					System.out.println();
					action = prompt();
					break;
					
				default:
					System.out.println("Sorry; that isn't an option. Try again:");
					action = prompt();
					return;	
			}
		}
		
	}
	
	private static String prompt()
	{
		String action;
		
		print();
		System.out.println("\n\tAdd an Item\t\tRemove an Item\t\tExit");
		System.out.print("What would you like to do: ");
		action = keyboard.nextLine().toLowerCase();
		
		return action;
	}
	
	private static void addItem() 
	{
		String item;
		System.out.print("Add Task: ");
		item = keyboard.nextLine();
		list.add(item);
	}
	
	private static void removeItem()
	{
		int index = 0;
		String catching;
		
		System.out.print("Remove Task Number: ");
		index = keyboard.nextInt() - 1;
		catching = keyboard.nextLine();				//without this, the previous line doesn't work and the program removes the first item on the list
													//the prompt catches the enter and because enter isn't a possible case, it says "sry; that isn't an option"
													//this catches the "enter" that you press and lets the list remove whatever you input
		list.remove(index);
	}
	
	private static void print()
	{
		System.out.println("\n\tTo Do:");
		if(list.size() == 0)
		{
			System.out.println("\t\tNone");
		}
		else
		{
			for(int i = 1; i <= list.size(); i++)
			{
				System.out.println("\t" + i + ". " + list.get(i-1));
			}
		}
	}
	
	
}
