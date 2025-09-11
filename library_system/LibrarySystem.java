package grupp.library_system;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class LibrarySystem {
	/*Sebastian_BEGIN*/
	public static void main(String[] args) {
		ArrayList<String>  bookTitles    = new ArrayList<>();
		ArrayList<String>  bookAuthors   = new ArrayList<>();
		ArrayList<String>  bookISBN      = new ArrayList<>();
		ArrayList<Boolean> bookAvailable = new ArrayList<>();

		ArrayList<String>  borrowerNames = new ArrayList<>();
		ArrayList<String>  borrowedBooks = new ArrayList<>();
		ArrayList<String>  userNames     = new ArrayList<>();
		ArrayList<String>  phoneNumbers  = new ArrayList<>();

// TEST DATA -- BEGIN
		bookTitles.add("Harry Potter");
		bookTitles.add("Sagan om ringen");
		bookTitles.add("1984");
		bookAuthors.add("J.K. Rowling");
		bookAuthors.add("Tolkien");
		bookAuthors.add("Orwell");
		bookISBN.add("111");
		bookISBN.add("222");
		bookISBN.add("333");
		bookAvailable.add(true);
		bookAvailable.add(true);
		bookAvailable.add(false); // 1984 är utlånad

		addBook(bookTitles, bookAuthors, bookISBN, "The Glass Harbor",           "Elena Marlowe",      "9781234567897", bookAvailable);
		addBook(bookTitles, bookAuthors, bookISBN, "Clockwork Dunes",            "Rafael Ibarra",      "9789876543217", bookAvailable);
		addBook(bookTitles, bookAuthors, bookISBN, "Embers in the Snow",         "Nora Valente",       "9783141592658", bookAvailable);
		addBook(bookTitles, bookAuthors, bookISBN, "The Moonlit Ledger",         "Priya Kapoor",       "9782718281827", bookAvailable);
		addBook(bookTitles, bookAuthors, bookISBN, "Echoes of Brass",            "Jonas Lindstrom",    "9781618033987", bookAvailable);
		addBook(bookTitles, bookAuthors, bookISBN, "A Map of Small Storms",      "Lila Andersen",      "9782468013570", bookAvailable);
		addBook(bookTitles, bookAuthors, bookISBN, "Rivers of Static",           "Omar Haddad",        "9781357924683", bookAvailable);
		addBook(bookTitles, bookAuthors, bookISBN, "Between Wolves and Wind",    "Sanna Koivu",        "9781123581324", bookAvailable);
		addBook(bookTitles, bookAuthors, bookISBN, "The Orchard at Night",       "Miles Harrigan",     "9784242424244", bookAvailable);
// Fördefinierade användare
		userNames.add("Anna");
		userNames.add("Erik");
		phoneNumbers.add("070-1234567");
		phoneNumbers.add("070-7654321");
// Fördefinierat lån
		borrowerNames.add("Anna");
		borrowedBooks.add("333"); // Anna har lånat 1984
// TEST DATA -- END

		Scanner sc = new Scanner(in);
		boolean exit = false;
		while (!exit) {
			displayMainMenu();
			int choice = sc.nextInt();
			sc.nextLine(); // Takes care of trailing newline

			int bookIndex;
			String borrowerName, title, author, isbn;
			switch (choice) {
				case 1:
					displayAllBooks(bookTitles, bookAuthors, bookISBN, bookAvailable);
					break;
				case 2:
					out.print("Titel: ");
					title = sc.nextLine();
					out.print("Författare: ");
					author = sc.nextLine();
					out.print("ISBN: ");
					isbn = sc.nextLine();
					addBook(bookTitles, bookAuthors, bookISBN, title, author, isbn, bookAvailable);
					break;
				case 3:
					out.print("Låntagarens namn: ");
					borrowerName = sc.nextLine();
					out.print("Bokens index: ");
					bookIndex = Integer.parseInt(sc.nextLine());
					borrowBook(bookAvailable, borrowerNames, borrowedBooks, bookIndex, borrowerName, bookISBN);
					break;
				case 4:
					out.print("Bokens ISBN: ");
					isbn = sc.nextLine();
					returnBook(bookAvailable, borrowerNames, borrowedBooks, bookISBN, isbn);
					break;
				case 5:
					displayLibraryStatistics(bookTitles, bookAvailable,userNames);
				case 0:
					exit = true;
					break;
			}
		}
	}

	public static void displayMainMenu() {
		out.print(
			"""
			──── Biblitoekssystem ────
			  1. Visa alla böcker
			  2. Lägg till bok
			  3. Låna bok
			  4. Återlämna bok
			  5. Visa statistik
			  0. Avsluta
			"""
		);
	}

	public static void displayBookMenu() {
	}

	public static void displayLoanMenu() {
	}
	/*Sebastian_END*/

	// VALENTIN'S DEL NEDAN 👇🏽
	public static void addBook(
		ArrayList<String> titles,
		ArrayList<String> authors,
		ArrayList<String> isbn,
		String title,
		String author,
		String isbnNumber,
		ArrayList<Boolean> available
	) {
		/**
		 * TODO:
		 * Add a 'title', 'author', and 'isbn' to the provided arguments
		 */
		titles.add(title);
		authors.add(author);
		isbn.add(isbnNumber);
		/**
		 * TODO:
		 * Refactor this so that the add book method doesn't have to be aware of available books?
		 */
		available.add(true);
	}

	public static void displayAllBooks(
		ArrayList<String> titles,
		ArrayList<String> authors,
		ArrayList<String> isbn,
		ArrayList<Boolean> available
	) {
		for (int i = 0; i < titles.size(); i++) {
			out.printf("%d: %s av %s, ISBN: %s, %s%n", i, titles.get(i), authors.get(i), isbn.get(i), available.get(i) ? "INNE" : "UTLÅNAD");
		}
	}

	public static int searchBook(
		ArrayList<String> titles,
		ArrayList<String> authors,
		String searchTerm
	) {
		if (titles.contains(searchTerm)) {
			return titles.indexOf(searchTerm);
		} else if (authors.contains(searchTerm)) {
			return titles.indexOf(searchTerm);
		}

		System.out.println("No book, or author with the title/name of : " + searchTerm + " exists in the library");
		return -1;
	}
	/**
	 * VALENTIN'S DEL ÖVER 👆🏽
	 * ArrayList<Boolean> available - true/false
	 * ArrayList<String> borrowers - Namn på alla som lånar en book
	 * ArrayList<String> borrowedBooks - ISBN-nummer (bok-ID)
	 * int bookIndex
	 * String borrowerName - Namn på den som lånat boken
	 */
	public static boolean borrowBook(ArrayList<Boolean> available, ArrayList<String> borrowers, ArrayList<String> borrowedBooks, int bookIndex, String borrowerName, ArrayList<String> isbnBooks) {

		if (available.get(bookIndex) == false) {
			return false;
		}

		available.set(bookIndex, false);
		borrowers.add(borrowerName);
		borrowedBooks.add(isbnBooks.get(bookIndex));

		return true;
	}

	public static boolean returnBook(ArrayList<Boolean> available, ArrayList<String> borrowers, ArrayList<String> borrowedBooks, ArrayList<String> isbnNumbers, String isbn) {
		int isbnIndex = isbnNumbers.indexOf(isbn);
		int borrowedIndex = borrowedBooks.indexOf(isbn);
		if (isbnIndex < 0 || borrowedIndex < 0) {
			return false;
		}
		borrowedBooks.remove(borrowedIndex);
		borrowers.remove(borrowedIndex);
		available.set(isbnIndex, true);
		return true;
	}

	public static void displayBorrowedBooks(ArrayList<String> borrowers, ArrayList<String> borrowedBooks) {
		for (int index = 0; index < borrowers.size(); index++) {
			System.out.printf("%-20s has borrowed: %s", borrowers.get(index), borrowedBooks.get(index));
		}
	}

	// Användarhantering - Alexander
	public static void registerUser(
		ArrayList<String> userNames,
		ArrayList<String> phoneNumbers,
		String newUserName,
		String newUserPhoneNumber
	) {
		userNames.add(newUserName);
		phoneNumbers.add(newUserPhoneNumber);
		System.out.printf("Registered new user as %s (%s)!", newUserName, newUserPhoneNumber);
	}

	public static void displayAllUsers(ArrayList<String> userNames, ArrayList<String> phoneNumbers) {
		for (int i = 0; i < userNames.size(); i++)
			System.out.printf("%s - %s", userNames.get(i), phoneNumbers.get(i));
	}

	// searchUser -> getUserID
	public static int getUserID(ArrayList<String> userNames, String search) {
		for (int i = 0; i < userNames.size(); i++)
			if (userNames.get(i).equals(search))
				return i;

		return -1;
	}

	// Från James
	public static int countAvailableBooks(ArrayList<Boolean> Available) {
		int count = 0;
		for (Boolean aBoolean : Available) {
			if (aBoolean) {
				count++;
			}
		}
		return count;
	}

	public static int countBorrowedBooks(ArrayList<Boolean> Available) {
		int count = 0;
		for (Boolean aBoolean : Available) {
			if (!aBoolean) {
				count++;
			}
		}
		return count;
	}

	public static void displayLibraryStatistics(ArrayList<String> titles, ArrayList<Boolean> available, ArrayList<String> userNames) {
		//assuming 1-1 corresponding index positions...
		out.println("ENTRY\tTITLE\tAVAILABLE");
		for (int i = 0; i < titles.size(); i++) {
			out.println(i + "\t" + titles.get(i) + "\t" + available.get(i));
		}
		out.println("USER REGISTRY:");
		for (String user : userNames) {
			out.println(user);
		}
	}
}
