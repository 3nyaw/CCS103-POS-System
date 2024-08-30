package PrelimActivity1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * declare or initialize variables to access globally
	 */	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader to read input from the user
	private static String[] books = new String[10]; // Array to store details about books
	private static String[] bookID = new String[10]; // Array to store unique IDs of the books
	private static String[] bookTitle = new String[10]; // Array to store unique IDs of the books
	private static boolean[] bookRented = new boolean[10]; // Array to track whether the book is rented or not
	private static boolean[] bookReturned = new boolean[10]; // Array to track whether the book is returned or not
	private static int size = 10; // Variable to store the total number of slots
	private static int bookCount = 5; // Variable to track the current number of books
	private static int slot = 0; // Variable to store the current slot number being used for book operations
	private static int selectedBook = 0; // Variable to store the index of the book selected by the user
	private static String[] renterNames = new String[10]; // Array to store the names of people who rent books
	private static int rentCounter = 0; // Counter to keep track of the total number of rentals made
	private static String[] previousRenterNames = new String[10]; // Array to store previous renter
	private static String inputBookID; // Use to store the input of book ID from the user

	public static void main(String[] args) throws IOException {
		// Assign initial book IDs
		bookID[0] = "2023-001";
		bookID[1] = "2023-002";
		bookID[2] = "2023-003";
		bookID[3] = "2024-001";
		bookID[4] = "2024-002";
		
		bookTitle[0] = "To Kill a Mockingbird";
		bookTitle[1] = "1984";
		bookTitle[2] = "Pride and Prejudice";
		bookTitle[3] = "The Great Gatsby";
		bookTitle[4] = "The Lord of The Rings";

		// Add details for each book including ID, title, author, and price
		books[0] = bookID[0] + " | " + bookTitle[0] + " | Harper Lee | P120.00";
		books[1] = bookID[1] + " | " + bookTitle[1] + " | George Orwell | P150.00";
		books[2] = bookID[2] + " | " + bookTitle[2] + " | Jane Austen | P110.00";
		books[3] = bookID[3] + " | " + bookTitle[3] + " | F. Scott Fitzgerald | P120.00";
		books[4] = bookID[4] + " | " + bookTitle[4] + " | J.R.R. Tolkien | P130.00";

		// Set all books as not rented and returned
		for(int i = 0; i < size; i++) {
			bookRented[i] = false;
			bookReturned[i] = false;
		}

		// Show the list of books
		viewBooks(books);     

		/*
		 *  Start a loop to handle user commands
		 */
		while(true) {
			// Show the menu options to the user
			System.out.println("1. Add New Book");
			System.out.println("2. View Book Records");
			System.out.println("3. Rent a Book");
			System.out.println("4. Return Book");
			System.out.println("5. View Transaction History");
			System.out.println("6. Exit");

			// Ask the user to enter a command
			System.out.print("\nEnter command(1-6): ");
			int command = Integer.parseInt(reader.readLine());

			// Handle the user's command
			switch(command) {
			case 1: // Add a new book if there's space available
				addNewBook(books);
				break;
			case 2: 
				viewBookRecords(); // Show the records of all books
				break;
			case 3:
				rentBook(); // Rent a book
				break;
			case 4:
				returnBook(); // Return a book if any book is rented
				break;
			case 5:
				viewTransactionHistory(); // Show the history of transactions
				break;
			case 6:
				System.out.println("Exiting Program.."); // Exit the program
				return;
			default:
				System.out.println("Invalid input. Try again.\n"); // Handle invalid command input
			}
		}
	}

	//adding a book
	private static void addNewBook(String books[]) throws IOException {
		while (true) {
			// Ask user to enter a book slot number
			System.out.print("\nEnter Book Slot: ");
			slot = Integer.parseInt(reader.readLine()) - 1;
			boolean slotTaken = false;

			// Check if the chosen book slot is empty
			if(bookCount < 10) {
				if(slot >= 10 || slot < 0){
					System.out.println("Invalid input. Try again.");
					continue;
				} else if(books[slot] == null) {
					while (true) {
						System.out.println("\n---------------------");
						System.out.println("Add New Book.");
						// Ask user for a book ID
						System.out.print("\nBook ID: ");
						String inputID = reader.readLine();

						// Check if the book ID is unique
						if (uniqueID(inputID)) {
							System.out.println("Book ID already exists. Try again.");
							continue; // If not unique, the program will ask again
						} else {
							bookID[slot] = inputID;
							break; // Break loop if ID is unique
						}
					}
					
					// Get book details from user
					String title = "";
					while(true) {
						System.out.print("Title: ");
						String inputTitle = reader.readLine();
						if(uniqueTitle(inputTitle)) {
							System.out.println("Book title already exist. Try again.");
							continue;
						} else {
							bookTitle[slot] = inputTitle;
							break;
						}
					}

					System.out.print("Author: ");
					String author = reader.readLine();
					System.out.print("Rental Price: ");
					String price = reader.readLine();

					// Add book details to the specified slot
					books[slot] = bookID[slot] + " | " + bookTitle[slot] + " | " + author + " | " + price;
					slotTaken = true;
					bookCount++; // Increase the count of books
					break;

					// If the slot is already occupied by a rented book
				} else if (bookRented[slot]) {
					System.out.println("Book is rented. Try again.");
				} else { // If the slot is occupied by a non-rented book
					while (true) {
						// Inform the user that the slot is occupied and provide options
						System.out.println("\nBook slot occupied.");
						System.out.println("\n1. Choose another slot.");
						System.out.println("2. Replace book");

						// Ask user to choose an option
						System.out.print("\nEnter command(1-2): ");
						int command = Integer.parseInt(reader.readLine());
						System.out.println("\n---------------------");

						if (command == 1) {
							// Option to choose a different slot
							break;
						} else if (command == 2) {
							// Option to replace the current book in the slot
							if (bookRented[slot]) {
								System.out.println("Book is currently rented. Try again.");
								break;
							}
							replace(books, slot); // Call replace method
							break;
						} else { // If user enters an invalid option
							System.out.println("Invalid Input. Try again.");
							continue; // Continue asking for a valid option
						}
					}
				}
			} else if(slot >= 10 || slot < 0) { // Not within range of a full book slot
				System.out.println("Invalid Input. Try again.");
				continue;
				
			} else {
				// If no space is available, offer options to replace or remove a book
				System.out.println("\nNo slot available.");
				while(true) {
					System.out.println("\n[1] Remove and Replace a book?");
					System.out.println("\n[2] Exit?");
					System.out.print("\nEnter 1 to confirm: ");
					int input = Integer.parseInt(reader.readLine());
					System.out.println("\n---------------------");

					if(input == 1) { // Replace an existing book
						replace(books, slot);
						break;
					} else if (input == 2) { // To exit
						break;
					} else {
						// Handle invalid input
						System.out.println("Invalid Input. Try again.");
						continue;
					}
				}
			}
			break;
		} 
		System.out.println();
		viewBooks(books);  
	}

	/*
	 * replacing a book
	 */    
	private static void replace(String[] books, int slot) throws IOException {
		String inputID = "";
		
		while (true) {
			// Ask user to enter a new Book ID
			System.out.print("\nBook ID: ");
			inputID = reader.readLine();
			// Check if the Book ID already exists
			if (uniqueID(inputID)) {
				// If the Book ID exists, show a message and exit the loop
				System.out.println("Book ID already exists. Try again.");
				break;
			}
			break; // Break the loop if Book ID is unique
		}

		bookID[slot] = inputID;
		
		String inputTitle= "";
		
		while(true) {
			// Ask user to enter the book's title
			System.out.print("Title: ");
			inputTitle = reader.readLine();
			
			
			// Check if the Book ID already exists
			if (uniqueTitle(inputTitle)) {
				// If the Book ID exists, show a message and exit the loop
				System.out.println("Book title already exists. Try again.");
				break;
			}
			break; // Break the loop if Book ID is unique
		}
		bookTitle[slot] = inputTitle;
		
		// Ask user to enter the book's author
		System.out.print("Author: ");
		String author = reader.readLine();

		// Ask user to enter the book's rental price
		System.out.print("Rental Price: ");
		String price = reader.readLine();

		// Update the book details in the specified slot
		books[slot] = bookID[slot] + " | " + bookTitle[slot] + " | " + author + " | " + price;

		// Show a message indicating the book has been replaced
		System.out.println("Book at slot " + slot + " has been replaced.");

		// Display the updated list of books
		viewBookRecords();    
	}

	// Method to check if a given book ID is unique
	private static boolean uniqueID(String input) {
		boolean notUniqueID = false;

		// Loop through all book IDs to check for a match
		for (int i = 0; i < size; i++) {
			// If the input ID matches an existing book ID
			if (matches(input, bookID[i])) {
				notUniqueID = true; // Mark it as not unique
				break; // Stop checking further
			}
		}

		// Return true if the ID is not unique, false otherwise
		return notUniqueID;
	}
	
	private static boolean uniqueTitle(String input) {
		boolean notUniqueTitle = false;

		// Loop through all book IDs to check for a match
		for (int i = 0; i < size; i++) {
			// If the input ID matches an existing book ID
			if (matches(input, bookTitle[i])) {
				notUniqueTitle = true; // Mark it as not unique
				break; // Stop checking further
			}
		}

		// Return true if the ID is not unique, false otherwise
		return notUniqueTitle;
	}

	private static void viewBookRecords() throws IOException {
		// Print a list of available books
		System.out.println("\nAvailable Books:");
		for (int i = 0; i < size; i++) {
			// A book is considered available if it's not null and either not rented or it's rented and returned
			if (books[i] != null && (!bookRented[i] || bookReturned[i])) {
				System.out.println("Slot #" + (i + 1) + ": " + books[i]); // Show details of each book that is not rented or is returned
			}
		}

		// Print a list of rented books
		System.out.println("\nUnavailable Books (Rented):");
		for (int i = 0; i < size; i++) {
			// A book is considered rented if it's not null and rented and not yet returned
			if (books[i] != null && bookRented[i] && !bookReturned[i]) {
				// Show details of each book that is currently rented and not yet returned
				System.out.println("Slot #" + (i + 1) + ": " + books[i]);
			}
		}
		System.out.println();
	}

	/*
	 *  method for renting a book
	 */    
	private static void rentBook() throws IOException {
		// Ask user to select a book to rent
		System.out.print("Select a Book (1-10): ");
		slot = Integer.parseInt(reader.readLine()) - 1;

		// Check if the selected book is valid
		if (slot < 0 || slot >= size || books[slot] == null) {
			System.out.println("Invalid Selection");
			System.out.println();
			return;
		}
		// Check if the book is already rented
		if (bookRented[slot]) {
			System.out.println("The book is already rented out.");
			System.out.println();
			return;
		}

		// Print the details of the selected book
		System.out.println("Selected Book: " + books[slot]);

		// Ask for the name of the person renting the book
		System.out.print("Renter Name: ");
		renterNames[slot] = reader.readLine();

		// Mark the book as rented
		bookRented[slot] = true;
		if(bookRented[slot]) {
			bookReturned[slot] = false;
		}
		System.out.println("Book rented successfully!");
		System.out.println();

		rentCounter++; // Increase the rent counter

		viewBookRecords(); 
	}

	private static void returnBook() throws IOException{
		while (true) {
			if(rentCounter == 0) {
				System.out.println("\nInvalid Return. No Book is Rented.");
				continue;
			} else {
				// Show the list of books
				System.out.print("\n---------------------");
				System.out.println("\nReturn a Book");
				boolean bookIDFound = false;
				String bookDetails = " ";

				while(true) {
					// Ask for the book ID to return
					System.out.print("\nBook ID: ");
					inputBookID = reader.readLine();

					// Check if the book ID matches any rented book
					for(int i = 0; i < bookID.length; i++) {
						if(matches(inputBookID, bookID[i])) {
							bookIDFound = true; // Mark that the book ID was found
							bookDetails = books[i]; // Get the book details
							previousRenterNames[i] = renterNames[i];
							renterNames[i] = null;
							slot = i;
							break;
						}
					}

					// If book ID is found, show the details
					if(bookIDFound){
						System.out.print(bookDetails + "\n");
						break;
					} else {
						System.out.print("Book ID Mismatch, Please Try Again.");
						continue;
					}
				}

				// Mark the book as returned
				bookReturned[slot] = true;
				if(bookReturned[slot]) {
					bookRented[slot] = false;
				}

				viewBookRecords(); 
				System.out.println("\nBook Status: Available");
				System.out.println("Book Successfully Returned!\n");
				break;			
			}
		}
	}

	private static void viewTransactionHistory() {
		// Print the transaction history of rented books
		System.out.println("\n--- Transaction History ---\nRented Books");
		for (int i = 0; i < size; i++) {
			if (renterNames[i] != null) {
				// Show details of each rented book and the renter's name
				System.out.println(books[i] + "\nRenter: " + renterNames[i] + "\n");
			}
		}
		System.out.println();

		System.out.println("Returned Books");
		for (int i = 0; i < books.length; i++) {
			if (renterNames[i] == null && previousRenterNames[i] != null) {
				System.out.println(books[i] + "\nReturned by: " + previousRenterNames[i]);
			}
		}
		System.out.println();
	}

	private static void viewBooks(String books[]) {
		// Show the list of books and indicate if slots are empty
		for (int i = 0; i < size; i++) {
			if (books[i] == null) {
				System.out.println("Slot #" + (i + 1) + ": Empty");
			} else {
				System.out.println("Slot #" + (i + 1) + ": " + books[i]);
			}
		}
		System.out.println();
	}

	private static boolean matches(String str1, String str2) {
		// Check if both strings are null
		if (str1 == null && str2 == null) {
			return true;
		} else if (str1 == null || str2 == null) {
			return false; // One string is null but the other isn't
		} else if (str1.length() != str2.length()) {
			return false; // Strings have different lengths
		}
		// Compare each character of both strings
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return false; // Characters don't match
			}
		}
		return true; // All characters match
	}
}