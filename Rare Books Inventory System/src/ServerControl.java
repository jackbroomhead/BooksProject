import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * HttpServer.create creates the local host server running on port 8000
 * @author jackb
 *
 */
public class ServerControl { 

	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0); 
		
		// a context is created for each web page that you want to be available on the server
		// There needs to be a corresponding handler class for each context
		server.createContext("/retrieve", new RetrieveHandler()); server.setExecutor(null); 

		
		// default implementation of threading 
		server.start();
		System.out.println("The server is running on port 8000");
}
	/**
	 * Handler to retrieve all books from the database
	 * 
	 *
	 */
	static class RetrieveHandler implements HttpHandler {
	
		public void handle(HttpExchange t) throws IOException {
			
			ArrayList<Book> bookList = new ArrayList();
			BookDao dao = new BookDao();
			String table = "<tr>";
			try {
				bookList = dao.getBooks();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (Book b: bookList) {
				System.out.println(b.toString());
				table = table + b.htmlTable() + "</tr><tr>";					
			}

			String response = pageHeader() + table + pageFooter();

			ServerControl.writeResponse(t, response); 
		}
			
	} 
	
	/**
	 * PageHeader creates the HTML table with headings for each category
	 * @return
	 */
public static String pageHeader() {
		
		String header = "<html>"
				+ "<head></head>"
				+ "<body>"
				+ "<h1>Welcome to the Rare Books Inventory System</h1>"
				+ "<table>" +"<tr><th>" 
				+ "ID" + "</th><th>" 
				+ "Title"+ "</th><th>" 
				+ "Author" +"</th><th>" 
				+ "Year" + "</th><th>"
				+ "Edition" + "</th><th>"
				+ "Publisher" + "</th><th>"
				+ "ISBN" + "</th><th>"
				+ "Cover" + "</th><th>"
				+ "Condition" + "</th><th>"
				+ "Price" + "</th><th>"
				+ "Notes" + "</th><th>";
				
		return header;
		
	}
/**
 * Page footer ends the table, body and HTML tags
 * 
 */
public static String pageFooter() {
	
	String footer = "</table>"
			+ "<body>"
			+ "</html>";
	
	return footer;
}

/**
 * Writes the response 
 * 
 * @param httpExchange
 * @param r
 * @throws IOException
 */
public static void writeResponse(HttpExchange httpExchange, String r) throws IOException {
	
	String response  = r;
	httpExchange.sendResponseHeaders(200, response.length()); 
	OutputStream os = httpExchange.getResponseBody(); 
	os.write(response.getBytes());
	os.close();
	
}
}


					
				