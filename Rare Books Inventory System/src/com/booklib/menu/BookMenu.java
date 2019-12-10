package com.booklib.menu;


public class BookMenu extends ConsoleMenu {
	
	
	/**
	 * Creates the book menu
	 */
	public void buildMenu() {
		
		super.addTitle("My Bookshop");
		super.addItem("Get All Books");
		super.addItem("Get book from ID");
		super.addTerminator("Quit");
		super.displayMenu();

	}

}



