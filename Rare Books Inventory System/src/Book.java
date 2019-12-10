//you need to change the class for searching for the ID and make it different from the book ID variable
//look at the two examples and see how they did theirs
//once you've done this you can move on 
public class Book {
	
	private int bookID;
	private String title;
	private String author;
	private int year;
	private int edition;
	private String publisher;
	private String isbn;
	private String cover;
	private String condition;
	private int price;
	private String notes;
	
	public Book(int bookID, String title, String author, int year, int edition, String publisher, String isbn, String cover, String condition, int price, String notes)
	{
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.year = year;
		this.edition = edition;
		this.publisher = publisher;
		this.isbn = isbn;
		this.cover = cover;
		this.condition = condition;
		this.price = price;
		this.notes = notes;
		
		
	}
	public Book() {
		
	}
	//@return displayString
	public String toString() {
		String displayString ="BookID = "+this.bookID+ '\n' +
				  "Title = "+this.title+ '\n' +
				  "Author = "+this.author+'\n'+
				  "Year = "+this.year+'\n'+
				  "Edition = "+this.edition+'\n'+
				  "Publisher = "+this.publisher+'\n'+
				  "isbn = "+this.isbn+'\n'+
				  "Cover = "+this.cover+'\n'+
				  "Condition = "+this.condition+'\n'+
				  "Price = "+this.price+'\n'+
				  "Notes = "+this.notes;
		
	return displayString;
	}
	/**
	 * @return the book_id
	 */
	public int getbookID() {
		return bookID;
	}
	/**
	 * @param book_id the book_id to set
	 */
	public void setbookID(int book_id) {
		bookID = book_id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the edition
	 */
	public int getEdition() {
		return edition;
	}
	/**
	 * @param edition the edition to set
	 */
	public void setEdition(int edition) {
		this.edition = edition;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the cover
	 */
	public String getCover() {
		return cover;
	}
	/**
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}

