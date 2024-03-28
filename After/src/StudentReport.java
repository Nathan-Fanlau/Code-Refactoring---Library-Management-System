import java.util.ArrayList;

public class StudentReport {
	BookReport bookRepo = new BookReport();
	ArrayList<Student> StudentList = new ArrayList<>();
	
	public boolean compareStudent(Student student) {
		for (Student s : StudentList) {
			if(s.getRegNum().equalsIgnoreCase(student.getRegNum())) {
				System.out.println("Student with same registration number alreasy exist.");
				return false;
			}
		}
		return true;
	}
	
	public void addStudent(String name, String regNumber)
	{
		Student s = new Student(name, regNumber);
		boolean validation = compareStudent(s);

		if(validation) {
			StudentList.add(s);
		}
		else {
			System.out.println("Please try again.");
		}
	}

	public void showAllStudents()
	{
		for (Student s : StudentList) {
			System.out.println("");
			System.out.println("Student name: " + s.getStudentName());
			System.out.println("Student registration number: " + s.getRegNum());
			System.out.println("Student books count: " + s.getBooksCount());
		}
	}

	public Student searchStudentByRegNum(String regNum)
	{
		for (Student s : StudentList) {
			if(s.getRegNum().equalsIgnoreCase(regNum)) {
				return s;
			}
		}
		return null;
	}

	public void checkOutBook(Student s, Book book)
	{
		s.getBorrowedBooks().add(book);
		s.setBorrowedBooks(s.getBorrowedBooks());
		s.setBooksCount(s.getBooksCount() + 1);
	}
	
	public void displayAllBorrowedBooks(Student s) {
		for (Book b : s.getBorrowedBooks()) {
			bookRepo.printBook(b);
		}
	}

	public void checkInBook(Student s, Book book)
	{
		ArrayList<Book> removeBook = new ArrayList<>();
		removeBook.add(book);
		s.getBorrowedBooks().removeAll(removeBook);
		s.setBooksCount(s.getBooksCount() - 1);
	}
}
