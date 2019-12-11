import java.io.IOException;
import java.sql.SQLException;
import com.booklib.menu.BookMenu;
import java.util.Scanner;
public class Controller {
	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		
		BookMenu shopWindow = new BookMenu();
		BookDao bookShop = new BookDao();
		boolean carryOn = true;
		
		// Create the window
		shopWindow.buildMenu();
		
		//shopWindow.getUserSelection();
		//shopWindow.getUserSelection();
				
		while (carryOn) {
			
		
			switch (shopWindow.getUserSelection()) {
		
		
				case 1: {
					System.out.println("You chose option 1");
					System.out.println("Printing all books");
					
					for (Book d : bookShop.getAllBooks()) {
						System.out.println("---------------------");
						System.out.println(d);
					}
					System.out.println("End of Data");
					shopWindow.displayMenu();
					break;
				}
				
				case 2: {
					System.out.println("You chose option 2");
					System.out.println("Search for book based on ID");
					
				
					bookShop.getBook();	
					//need to ask and scan for the book ID and then once finding the book ID you need to link that to the .getbook and
					//make it find it in the database using 2 string method
					
					
						
						System.out.println("---------------------");
						System.out.println();	
					
					System.out.println("end of data");
					shopWindow.displayMenu();
					break;
				}
						
		 	case 3: {
					System.out.println("You chose option 3");
					System.out.println("Insert new book into database");
					
					bookShop.insertBook();
					
					System.out.println("---------------------");
					System.out.println();	
				
				System.out.println("end of data");
				shopWindow.displayMenu();
					break;
				}
				
				case 4: {
					System.out.println("you chose option 4");
					System.out.println ("Update existing book price details");
					
					
					System.out.println("---------------------");
					System.out.println();	
				
				System.out.println("end of data");
				shopWindow.displayMenu();
					break;
				}
				
				
				case 5: {
					System.out.println("You chose option 5");
					System.out.println("Delete book from database");
					
					bookShop.deleteBook();
					
					System.out.println("---------------------");
					System.out.println();	
				
				System.out.println("end of data");
				shopWindow.displayMenu();
					break;
					
				}
				case 6: {
					System.out.println("You chose option 6");
					System.out.println("Goodbye!");
					carryOn = false;
					break;
				}
			}
		}
	}
}



