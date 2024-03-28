import java.util.Arrays;
import java.util.Scanner;

public class Library {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		BookReport bookRepo = new BookReport();
		StudentReport studentRepo = new StudentReport();
		
		// Initialize data inside BookList and StudentList
		bookRepo.BookList.addAll(Arrays.asList(
				new Book(1, "Book1", "Author1", 10),
				new Book(2, "Book2", "Author2", 1),
				new Book(3, "Book3", "Author3", 16)));
		
		studentRepo.StudentList.addAll(Arrays.asList(
				new Student("John", "S001"),
				new Student("Adam", "S002"),
				new Student("Will", "S003")));
		
		while(true) {
			int choice;
			do {
				System.out.println("********************Welcome to the GFG Library!********************");
				System.out.println("				 Select From The Following Options:			 ");
				System.out.println("**********************************************************************");
				System.out.println("----------------------------------------------------------------------------------------------------------");
				System.out.println("Press 0 to Exit Application.");
				System.out.println("Press 1 to Add new Book.");
				System.out.println("Press 2 to Upgrade Quantity of a Book.");
				System.out.println("Press 3 to Search a Book.");
				System.out.println("Press 4 to Show All Books.");
				System.out.println("Press 5 to Register Student.");
				System.out.println("Press 6 to Show All Registered Students.");
				System.out.println("Press 7 to Check Out Book. ");
				System.out.println("Press 8 to Check In Book");
				System.out.println("-------------------------------------------------------------------------------------------------------");
				choice = input.nextInt();
				input.nextLine();
			} while (choice < 0 && choice > 8);
			
			switch (choice) {
			case 0:
				System.out.println("Program terminated");
				input.close();
				System.exit(1);
				break;
				
			case 1:
				int serialNumber;
				String bookName;
				String authorName;
				int initialQty;
				
				System.out.println("Serial num: ");
				serialNumber = input.nextInt();
				input.nextLine();
				
				System.out.println("Book name: ");
				bookName = input.nextLine();
				
				System.out.println("Author name: ");
				authorName = input.nextLine();
				
				System.out.println("Initial Quantity: ");
				initialQty = input.nextInt();
				input.nextLine();
				
				bookRepo.addBook(serialNumber, bookName, authorName, initialQty);
				System.out.println("Book added.");
				
				break;
				
			case 2:
				int searchSerial;
				int addQty;
				
				System.out.println("Input serial number: ");
				searchSerial = input.nextInt();
				input.nextLine();
				Book book = bookRepo.searchBySerialNumber(searchSerial);
				
				if(book != null) {
					System.out.println("Input book quantity to be added: ");
					addQty = input.nextInt();
					input.nextLine();
					
					bookRepo.addBookQty(book, addQty);
					System.out.println("Book qty added.");
				}
				else {
					System.out.println("Book doesn't exist");
				}
				
				
				break;
	
			case 3:
				System.out.println(" press 1 to Search with Book Serial No.");
				System.out.println(" Press 2 to Search with Book's Author Name.");
				int searchChoice = input.nextInt();
				
				if(searchChoice == 1) { // Search by serial number
					System.out.println("Input serial number: ");
					searchSerial = input.nextInt();
					input.nextLine();
					book = bookRepo.searchBySerialNumber(searchSerial);
					
					if(book != null) {
						bookRepo.printBook(book);
					}
					else {
						System.out.println("Book not found!");
					}
					
				}
				else if(searchChoice == 2) { // Search by author name
					System.out.println("Input author name: ");
					authorName = input.nextLine();
					book = bookRepo.searchByAuthorName(authorName);
					
					if(book != null) {
						bookRepo.printBook(book);
					}
					else {
						System.out.println("Book not found!");
					}
				}

				
				break;
	
			case 4:
				bookRepo.showAllBooks();
				break;
	
			case 5:
				String studentName;
				String regNum;
				
				System.out.println("Student name: ");
				studentName = input.nextLine();
				
				System.out.println("Registration number: ");
				regNum = input.nextLine();
				
				studentRepo.addStudent(studentName, regNum);
				System.out.println("Student added succesfully.");
				
				break;
	
			case 6:
				studentRepo.showAllStudents();
				break;
	
			case 7:
				System.out.println("Registration number: ");
				regNum = input.nextLine();
				Student s = studentRepo.searchStudentByRegNum(regNum);
				
				if(s != null) {
					if(s.getBooksCount() > 3) {
						System.out.println("Student cant borrow more than 3 books");
						break;
					}
					
					bookRepo.showAllBooks();
					
					System.out.println("Serial number of book to be borrowed: ");
					searchSerial = input.nextInt();
					input.nextLine();
					book = bookRepo.searchBySerialNumber(searchSerial);
					
					if(book != null) { // Book is found
						if(bookRepo.isAvailable(book) == false) { // Book not available
							System.out.println("Book not available");
							break;
						}
						
						studentRepo.checkOutBook(s, book);
						bookRepo.checkOutBook(book);
						System.out.println("Book succesfully checked out.");
					}
					else {
						System.out.println("Book not found");
					}
				}
				else {
					System.out.println("Student not found");
				}
				
				break;
				
			case 8:
				System.out.println("Registration number: ");
				regNum = input.nextLine();
				s = studentRepo.searchStudentByRegNum(regNum);
				
				if(s != null) {
					studentRepo.displayAllBorrowedBooks(s);
					
					System.out.println("Serial number of book to be returned: ");
					searchSerial = input.nextInt();
					input.nextLine();
					book = bookRepo.searchBySerialNumber(searchSerial);
					
					if(book != null) { // Book is found
						studentRepo.checkInBook(s, book);
						bookRepo.checkInBook(book);
						System.out.println("Book succesfully returned.");
					}
					else {
						System.out.println("Book not found");
					}
				}
				else {
					System.out.println("Student not found");
				}
				
				break;

			default:
				System.out.println("Invalid input. Please try again.");
				break;
			}
		}
	}
}
