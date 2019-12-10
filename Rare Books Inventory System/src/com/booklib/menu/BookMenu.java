package com.booklib.menu;


public class BookMenu extends ConsoleMenu {
	
	
	/**
	 * Creates the book menu
	 */
	public void buildMenu() {
		
		super.addTitle("My Bookshop");
		super.addItem("Get All Books");
		super.addItem("Get book from ID");
		super.addItem("Insert new book into database");
		super.addItem("Update book price details");
		super.addItem("Delete book from database");
		super.addTerminator("Quit");
		super.displayMenu();

	}

}



