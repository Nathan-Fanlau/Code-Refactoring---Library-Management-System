import java.util.ArrayList;

public class BookReport {
	ArrayList<Book> BookList = new ArrayList<>();
	public static int count;
	
	public boolean compareBook(Book b1)
	{
		for (Book b : BookList) {
			if(b.getBookName().equalsIgnoreCase(b1.getAuthorName())){
				System.out.println("Book with same authorname exist.");
				return false;
			}
			
			else if(b.getSerialNumber() == b1.getSerialNumber()){
				System.out.println("Book with same serial number exist.");
				return false;
			}
		}
		return true;
	}

	public void addBook(int serialNumber, String bookName, String authorName, int initialQty)
	{
		Book book = new Book(serialNumber, bookName, authorName, initialQty);
		boolean validation = compareBook(book);
		if(validation) {
			BookList.add(book);
		}
		else {
			System.out.println("Please try again.");
		}
	}

	public Book searchBySerialNumber(int serialNum)
	{
		for (Book book : BookList) {
			if(book.getSerialNumber() == serialNum) {
				return book;
			}
		}
		return null;
	}
	
	public void addBookQty(Book book, int addQty)
	{
		book.setAvailableQuantity(book.getAvailableQuantity() + addQty);
	}

	public Book searchByAuthorName(String authorName)
	{
		for (Book book : BookList) {
			if(book.getAuthorName().equalsIgnoreCase(authorName)) {
				return book;
			}
		}
		return null;
	}
	
	public void printBook(Book book) {
		System.out.println();
		System.out.println("Serial number:" + book.getSerialNumber());
		System.out.println("Book name:" + book.getBookName());
		System.out.println("Author name:" + book.getAuthorName());
		System.out.println("Initial Quanityt:" + book.getInitialQuantity());
		System.out.println("Available quanityt:" + book.getAvailableQuantity());
	}

	public void showAllBooks()
	{
		for (Book book : BookList) {
			printBook(book);
		}
	}

	public boolean isAvailable(Book book)
	{
		return (book.getAvailableQuantity() > 0);
	}

	public void checkOutBook(Book book)
	{
		book.setAvailableQuantity(book.getAvailableQuantity() - 1);
	}

	public void checkInBook(Book book)
	{
		book.setAvailableQuantity(book.getAvailableQuantity() + 1);
	}
}
