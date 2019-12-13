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

public class ServerControl { 

	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0); 
		
		// a context is created for each web page that you want to be available on the server
		// There needs to be a corresponding handler class for each context
		server.createContext("/retrieve", new RetrieveHandler()); server.setExecutor(null); 

		
		// default implementation of threading 
		server.start();
		System.out.println("The server is up and running on port 8000");
}
	/**
	 * Handler to RETRIEVE all records from the database
	 * @author Martin Stanton
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
	
public static String pageHeader() {
		
		String header = "<html>"
				+ "<head></head>"
				+ "<body>"
				+ "<h1>Welcome to the Video Library System</h1>"
				+ "<table>";
				
		return header;
		
	}

public static String pageFooter() {
	
	String footer = "</table>"
			+ "<body>"
			+ "</html>";
	
	return footer;
}
public static void writeResponse(HttpExchange httpExchange, String r) throws IOException {
	
	String response  = r;
	httpExchange.sendResponseHeaders(200, response.length()); 
	OutputStream os = httpExchange.getResponseBody(); 
	os.write(response.getBytes());
	os.close();
	
}
}


					
				