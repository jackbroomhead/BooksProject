import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class BookDao {
/**
 * Creates and opens a connection to the database
 * 
 *
 */
private static Connection getDBConnection() {
	
	// Create a connection and specify the database name
	Connection conn = null;
	final String DATABASE_NAME = "books.sqlite";
	
	//Create the url for the database
	String url = "jdbc:sqlite:" + DATABASE_NAME;  // the URL of the database

	
	// initialise the JDBC driver class
	try {
		Class.forName("org.sqlite.JDBC");  // initialises the class named "org.sqlite.JDBC" 
	} 
	catch (ClassNotFoundException e) {
		System.out.println("Oh dear!  Have you named the database driver class correctly?");
		System.out.println(e.getMessage());
	}
	
	// get the connection object of the database
	try {
		conn = DriverManager.getConnection(url); // gets the connection for the specified database from the DriverManager class.	
	}
	catch (SQLException e) {
		System.out.println("Ooops! I can't make a connection to the specified database: " + url);
		System.out.println(e.getMessage());
	}
	
	return conn;
	
}

/**
 * Gets all Books from the database and places them unordered into an <code>ArrayList</code> of Book objects.
 * 
 * @return  BookList - An ArrayList of Book objects.
 * 
 * @throws SQLException
 */
public ArrayList<Book> getAllBooks() throws SQLException {
	
	Connection dbConnection = null;	// The database connection
	Statement statement = null;		// The statement object executes operations on the database
	ResultSet result = null;		// The ResultSet stores the data returned from the database after executing a query.
	
	String query = "SELECT * FROM books;"; // An SQL Statement (must be correct).
	ArrayList<Book> bookList = new ArrayList<>();

	
	System.out.println("Retrieving all Books...");
	
	try {
		// Connect to the database and run the query putting the result in a ResultSet called result"
		dbConnection = getDBConnection();
		statement = dbConnection.createStatement();
		System.out.println("DBQuery = " + query);
		
		result = statement.executeQuery(query);
		
		// Go through the ResultSet and extract the required information
		while(result.next()) {
			
			int bookID = result.getInt("ID");
			String title = result.getString("Title");
			String author = result.getString("Author");
			int year = result.getInt("Year");
			int edition = result.getInt("Edition");
			String publisher = result.getString("Publisher");
			String isbn = result.getString("isbn");
			String cover = result.getString("Cover");
			String condition = result.getString("Condition");
			int price = result.getInt("Price");
			String notes = result.getString("Notes");
			
			
			System.out.println(bookID + " " + title + " " + author + " " + year + " " + edition + " " + publisher + " " + isbn + " " + cover + " " + condition + " " + price + " " + notes);
			
			// Add a new book to the list using the information gathered from the ResultSet
			bookList.add(new Book(bookID, title, author, year, edition, publisher, isbn, cover, condition, price, notes));
		}
	}
	// do the following even if there is an exception
	finally { 
	
		if (result != null) { result.close(); }
		if (statement != null) { statement.close(); }
		if (dbConnection != null) { dbConnection.close(); }
	}

	return bookList;
	
}

public void getBook() throws SQLException {
	
Scanner scanner=new Scanner(System.in);
	Book temp = null;
	Connection dbConnection = null; /** The database connection */
	Statement statement = null; /** The statement object executes operations on the database */
	ResultSet result = null; /** The ResultSet stores the data returned from the database after executing a query. */
	
	/** enter the book ID to be used in the SQL selection to locate book ID */
	
	System.out.println("Enter Book ID please: ");
	int book_id = scanner.nextInt();
	
	String query = "SELECT * FROM books WHERE ID =" + book_id + ";"; // SQL Statement
	
	System.out.println("retrieving your book now");
	
	try {
		dbConnection = getDBConnection();
		statement = dbConnection.createStatement(); 
		System.out.println("DBQuery: " + query); /* run the query */
		// execute SQL query
		result = statement.executeQuery(query);

		while (result.next()) {

			int bookID = result.getInt("ID");
			String title = result.getString("Title");
			String author = result.getString("Author");
			int year = result.getInt("Year");
			int edition = result.getInt("Edition");
			String publisher = result.getString("Publisher");
			String isbn = result.getString("isbn");
			String cover = result.getString("Cover");
			String condition = result.getString("Condition");
			int price = result.getInt("Price");
			String notes = result.getString("Notes");
			
			temp = new Book(bookID, title, author, year, edition, publisher, isbn, cover, condition, price, notes);
			System.out.println(bookID + " " + title + " " + author + " " + year + " " + edition + " " + publisher + " " + isbn + " " + cover + " " + condition + " " + price + " " + notes);

		}
	} finally {
		if (result != null) {
			result.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (dbConnection != null) {
			dbConnection.close();
		}
	}
}

public void deleteBook() throws SQLException {
	
Scanner scanner=new Scanner(System.in);
	Book temp = null;
	Connection dbConnection = null; /** The database connection */
	Statement statement = null; /** The statement object executes operations on the database */
	ResultSet result = null; /** The ResultSet stores the data returned from the database after executing a query. */
	
	/** enter the book ID to be used in the SQL selection to locate book ID */
	
	System.out.println("Enter Book ID please: ");
	int book_id = scanner.nextInt();
	
	String query = "DELETE FROM books WHERE ID =" + book_id + ";"; // SQL Statement
	
	System.out.println("deleting your book now");
	
	try {
		dbConnection = getDBConnection();
		statement = dbConnection.createStatement(); 
		System.out.println("DBQuery: " + query); /* run the query */
		// execute SQL query
		result = statement.executeQuery(query);

		while (result.next()) {

			int bookID = result.getInt("ID");
			String title = result.getString("Title");
			String author = result.getString("Author");
			int year = result.getInt("Year");
			int edition = result.getInt("Edition");
			String publisher = result.getString("Publisher");
			String isbn = result.getString("isbn");
			String cover = result.getString("Cover");
			String condition = result.getString("Condition");
			int price = result.getInt("Price");
			String notes = result.getString("Notes");
			
			temp = new Book(bookID, title, author, year, edition, publisher, isbn, cover, condition, price, notes);
			System.out.println(bookID + " " + title + " " + author + " " + year + " " + edition + " " + publisher + " " + isbn + " " + cover + " " + condition + " " + price + " " + notes);

		}
	} finally {
		if (result != null) {
			result.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (dbConnection != null) {
			dbConnection.close();
		}
	}
}

public void insertBook() throws SQLException, NumberFormatException, IOException{
	Connection dbConnection = null;
	Statement statement = null;
	BufferedReader br = new BufferedReader(new
	        InputStreamReader(System.in)); 
	
	System.out.println("Enter Book ID please: ");
	int idvalue = Integer.parseInt(br.readLine());
	
	System.out.println("Enter Book title please: ");
	String titlevalue = br.readLine(); 
	
	System.out.println("Enter Author Name please: ");
	String authorvalue = br.readLine();
	
	System.out.println("Enter Year please: ");
	int yearvalue = Integer.parseInt(br.readLine());
	
	System.out.println("Enter Edition please: ");
	int editionvalue = Integer.parseInt(br.readLine());
	
	System.out.println("Enter Publisher Name please: ");
	String publishervalue = br.readLine();
	
	System.out.println("Enter ISBN please: ");
	String isbnvalue = br.readLine();
	
	System.out.println("Enter Cover please: ");
	String covervalue = br.readLine();
	
	System.out.println("Enter Condition please: ");
	String conditionvalue = br.readLine();
	
	System.out.println("Enter Price please: ");
	int pricevalue = Integer.parseInt(br.readLine());
	
	System.out.println("Enter Notes please: ");
	String notesvalue = br.readLine();
	
	String update = "INSERT INTO books (ID, Title, Author, Year, Edition, Publisher, ISBN, Cover, Condition, Price, Notes)"
			+ " VALUES("+idvalue+",'"+titlevalue+"','"+authorvalue+"',"+yearvalue+","+editionvalue+",'"+publishervalue+"','"+isbnvalue+"','"+covervalue+"','"+conditionvalue+"',"+pricevalue+",'"+notesvalue+"');";
	
	try {
		dbConnection = getDBConnection();
		statement = dbConnection.createStatement();
		System.out.println(update);
// execute SQL query
		statement.executeUpdate(update);

		System.out.println("record inserted");
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	} finally {
		if (statement != null) {
			statement.close();
		}
		if (dbConnection != null) {
			dbConnection.close();
		}
		
	}
}


public Boolean updateBook(Book book) throws SQLException {
	Connection dbConnection = null;
	Statement statement = null;

	String query = "UPDATE books " + "SET ID = '" + book.getbookID() + "'," + "Title = '"
			+ book.getTitle() + "'," + "Author= '" + book.getAuthor() + "'," + "Year= '" + book.getYear() + "Edition= '" + book.getEdition()  + "Publisher= '" + book.getPublisher() + "isbn = '" + book.getIsbn() + "Cover= '" + book.getCover() + "Condition= '" + book.getCondition() + "Price=  '" + book.getPrice() + "Notes= '" + book.getNotes() +" WHERE ID = " + book.getbookID()
			+ ";";

	try {
		dbConnection = getDBConnection();
		statement = dbConnection.createStatement();
		System.out.println(query);
		// execute SQL update
		statement.executeUpdate(query);

	} catch (SQLException e) {

		System.out.println(e.getMessage());
		return false;

	} finally {

		if (statement != null) {
			statement.close();
		}
		if (dbConnection != null) {
			dbConnection.close();
		}
	}
	return true;
}
	
}








