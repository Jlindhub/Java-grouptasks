package Uppgifter.library_system.src;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public final class LibrarySystem {
	/*Sebastian_BEGIN*/
	public static void main(String[] args) {
// these four should always be the same size and order, things will likely break if they are not
		ArrayList<String>  bookTitles    = new ArrayList<>();
		ArrayList<String>  bookAuthors   = new ArrayList<>();
		ArrayList<String>  bookISBN      = new ArrayList<>();
		ArrayList<Boolean> bookAvailable = new ArrayList<>();

// these four may vary in length, and an index value from one is not guaranteed to work in another
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
			String borrowerName, borrowerPhone, title, author, isbn, search;
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
					if (!userNames.contains(borrowerName)) {
						out.printf("Bara registrerade medlemmar kan låna böcker!%n");
						break;
					}
					out.print("Bokens index: ");
					bookIndex = Integer.parseInt(sc.nextLine());
					if(bookIndex >= bookISBN.size() || bookIndex < 0) {
						out.printf("Boken finns inte i biblioteket!%n");
						break;
					}
					borrowBook(bookAvailable, borrowerNames, borrowedBooks, bookIndex, borrowerName, bookISBN);
					break;
				case 4:
					out.print("Bokens ISBN: ");
					isbn = sc.nextLine();
					returnBook(bookAvailable, borrowerNames, borrowedBooks, bookISBN, isbn);
					break;
				case 5:
					displayBorrowedBooks(borrowerNames, borrowedBooks);
					break;
				case 6:
					out.print("Namn: ");
					borrowerName = sc.nextLine();
					out.print("Telefonnr: ");
					borrowerPhone = sc.nextLine();
					registerUser(userNames, phoneNumbers, borrowerName, borrowerPhone);
					break;
				case 7:
					displayAllUsers(userNames, phoneNumbers);
					break;
				case 8:
					out.print("Sök användare: ");
					search = sc.nextLine();
					searchUser(userNames, search);
					break;
				case 9:
					out.print("Sök bok: ");
					search = sc.nextLine();
					bookIndex = searchBook(bookTitles, bookAuthors, search);
					if (bookIndex >= 0){
						out.printf(
							"%d: %s by %s, ISBN: %s, %s%n",
							bookIndex,
							bookTitles.get(bookIndex),
							bookAuthors.get(bookIndex),
							bookISBN.get(bookIndex),
							bookAvailable.get(bookIndex) ? "INNE" : "UTLÅNAD"
						);
					}
					break;
				case 10:
					displayLibraryStatistics(bookTitles, bookAvailable,userNames);
					break;
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
			  5. Visa lånade böcker
			  6. Registrera ny medlem
			  7. Visa alla medlemmar
			  8. Sök medlem
			  9. Sök bok
			 10. Visa statistik
			  0. Avsluta
			"""
		);
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

		out.printf("No book, or author with the title/name of : %s exists in the library.%n", searchTerm);
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

    public static boolean returnBook(ArrayList<Boolean> available, ArrayList<String> borrowers, ArrayList<String> borrowedBooks, ArrayList<String> isbnNumbers, String bookToReturnISBN) {

        final int index = isbnNumbers.indexOf(bookToReturnISBN);

        if (index < 0) {
            System.out.println("Book doesn't exist. Operation failed.");
            return false;
        }

        if (available.get(index) == true)
        {
            System.out.println("Book already available. This is not intended.");
            return false;
        }

        if (borrowedBooks.size() != borrowers.size())
        {
            System.out.println("BorrowedNames and BorrowedBooks array size index doesn't match. This is not intended.");
            return false;
        }

        final int finalCheckIndex = borrowedBooks.indexOf(bookToReturnISBN);

        if (finalCheckIndex < 0)
        {
            System.out.println("This book ISBN doesn't exist in borrowedBook. This is not intended.");
            return false;
        }

        System.out.printf("%nBook with isbn %s borrowed by %s has been returned successfully.%n%n", borrowedBooks.get(finalCheckIndex), borrowers.get(finalCheckIndex));

        available.set(index, true);
        borrowedBooks.remove(finalCheckIndex);
        borrowers.remove(finalCheckIndex);

        return true;
    }

	public static void displayBorrowedBooks(ArrayList<String> borrowers, ArrayList<String> borrowedBooks) {
		for (int index = 0; index < borrowers.size(); index++) {
			System.out.printf("%-20s has borrowed: %s%n", borrowers.get(index), borrowedBooks.get(index));
		}
	}

	// Användarhantering - Alexander
    public static void registerUser(
            ArrayList<String> userNames,
            ArrayList<String> phoneNumbers,
            String newUserName,
            String newUserPhoneNumber
    ) {
        if (userNames.contains(newUserName)) {
            System.out.printf("Error! %s is already registered!%n", newUserName);
            return;
        }
        userNames.add(newUserName);
        phoneNumbers.add(newUserPhoneNumber);
        System.out.printf("Registered new user as %s (%s)!%n", newUserName, newUserPhoneNumber);
    }

    public static void displayAllUsers(ArrayList<String> userNames, ArrayList<String> phoneNumbers) {
        for (int i = 0; i < userNames.size(); i++)
            System.out.printf("%s - %s\n", userNames.get(i), phoneNumbers.get(i));
    }

    public static void searchUser(ArrayList<String> userNames, String search) {
        System.out.printf("User(s) matching search term \"%s\":\n", search);
        for (int i = 0; i < userNames.size(); i++)
            if (userNames.get(i).contains(search))
                System.out.printf("%s\n", userNames.get(i));
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
