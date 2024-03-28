public class Book {
	private int serialNumber;
	private String bookName;
	private String authorName;
	private int initialQuantity;
	private int availableQuantity;

	public Book(int serialNumber, String bookName, String authorName, int initialQuantity) {
		super();
		this.serialNumber = serialNumber;
		this.bookName = bookName;
		this.authorName = authorName;
		this.initialQuantity = initialQuantity;
		this.availableQuantity = initialQuantity;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getInitialQuantity() {
		return initialQuantity;
	}

	public void setInitialQuantity(int initialQuantity) {
		this.initialQuantity = initialQuantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
}
