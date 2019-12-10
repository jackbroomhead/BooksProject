package com.booklib.menu;
import java.util.Scanner;
public class ConsoleMenu {
	/*
	 * Fields
	 */
	
	/**
	 * An array of Stings for holding menuItems
	 */
	private String[] menuItems;
	
	/**
	 * The current size of the menu
	 */
	private int menuSize = 0;
	
	/**
	 * The title of the menu
	 */
	private String title;
	
	/**
	 * The final item of the menu to be added last.  it will allow the user to quit the application.
	 */
	private String terminator;
	
	/**
	 * The maximum permitted number of menu items
	 */
	private final int MAX_MENU_SIZE = 6;
	
	/**
	 * The selection form the menu that the user has made
	 */
	private int selection;
	
	/*
	 * Constructors
	 */
	
	
	/**
	 * Constructor. Initialises the array of MenuItems
	 */
	public ConsoleMenu(){
		
		menuItems = new String[MAX_MENU_SIZE];
	}
	
	
	/*
	 * Methods
	 */

	/**
	 * Adds an item to the end of the menu
	 * 
	 * @param item		The next item to be added to the menu
	 */
	public void addItem(String item) {
		
		this.menuItems[menuSize] = item;
		menuSize++;
	}
	
	/**
	 * Adds a title to the menu
	 * 
	 * @param title		The title to be added to the menu
	 */
	public void addTitle(String title) {
	
		this.title = title;
	}
	
	/**
	 * Adds a terminator to the end of the menu.  
	 * This should be done after all the other menu items have been added.
	 * 
	 * @param terminator	The terminator for the menu (the final item)
	 */
	public void addTerminator(String terminator) {
		
		this.terminator = terminator;
		this.addItem(this.terminator);
	}
	
	/**
	 * Displays the menu in the correct order
	 */
	public void displayMenu() {
		
		String displayString;
		
		System.out.println(title);
		
		for(int i = 0; i < menuSize; i++) {

			displayString = (i + 1) + ". " + this.menuItems[i];
			System.out.println(displayString);
		}
	}
	
	/**
	 * Gets the user's selection
	 */
	public int getUserSelection() {
		
		// declare and initialise variables
		int userSelection = 0;
		boolean validSelection = false;
		Scanner sc = new Scanner(System.in);
		
		// get input and validate
		do {
		
			while (!sc.hasNextInt()) {
				System.out.println("Sorry - something went wrong here.");
				System.out.println("Selection must be a number from 1-" + menuSize + ".  Please try again.");
				this.displayMenu();

				sc.next();
			}
			
			userSelection = sc.nextInt();
			
			if ((userSelection < 1) || (userSelection > menuSize)) {
				validSelection = false;
				System.out.println("Selection must be a number from 1-" + menuSize + ".  Please try again.");
				this.displayMenu();
				
			} else {
				validSelection = true;
				System.out.println("Option " + userSelection + " selected.");
			}
			
		} while (!validSelection);
		
		this.selection = userSelection;

		return userSelection;
	}
}

