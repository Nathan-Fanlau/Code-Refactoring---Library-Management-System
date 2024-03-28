import java.util.ArrayList;

public class Student {
	private String studentName;
	private String regNum;
	private int BooksCount = 0;
	ArrayList<Book> borrowedBooks = new ArrayList<>();

	public Student(String studentName, String regNum) {
		super();
		this.studentName = studentName;
		this.regNum = regNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public int getBooksCount() {
		return BooksCount;
	}

	public void setBooksCount(int booksCount) {
		BooksCount = booksCount;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
}
