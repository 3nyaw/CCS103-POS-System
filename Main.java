package PrelimActivity1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * declare/initialize variables to access globally
	 */	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader to read input from the user
	private static int maxBooks = 10; // Integer Variable to store the max number of slots
	private static int bookCount = 5; // Integer Variable to track the current number of books
	private static String[] books = new String[maxBooks]; // String array to store details about books
	private static String[] bookID = new String[maxBooks]; // Separate string array of book ID to store and access unique IDs of the books
	private static String inputBookID; // Use to store the input of book ID from the user
	private static String[] bookTitle = new String[maxBooks]; // Separate string array of book title to store and access unique title of the books
	private static boolean[] bookRented = new boolean[maxBooks]; // Boolean array to track whether the book is rented or not
	private static String[] renterNames = new String[maxBooks]; //String array to store the names of people who rent books
	private static String[] previousRenterNames = new String[maxBooks]; // String array to store previous renter
	private static int rentCounter = 0; // Counter to keep track of the total number of rentals made
	private static boolean[] bookReturned = new boolean[maxBooks]; // Array to track whether the book is returned or not
	private static int selectedSlot = 0; // Variable to store the current slot number being used for book operations

	public static void main(String[] args) throws IOException {
		
		// Assign initial book IDs
		bookID[0] = "2023-001";
		bookID[1] = "2023-002";
		bookID[2] = "2023-003";
		bookID[3] = "2024-001";
		bookID[4] = "2024-002";
		
		// Assign initial book titles
		bookTitle[0] = "To Kill a Mockingbird";
		bookTitle[1] = "1984";
		bookTitle[2] = "Pride and Prejudice";
		bookTitle[3] = "The Great Gatsby";
		bookTitle[4] = "The Lord of The Rings";

		// Add details for each book including ID, title, author, and rental price
		books[0] = bookID[0] + " | " + bookTitle[0] + " | Harper Lee | P120.00";
		books[1] = bookID[1] + " | " + bookTitle[1] + " | George Orwell | P150.00";
		books[2] = bookID[2] + " | " + bookTitle[2] + " | Jane Austen | P110.00";
		books[3] = bookID[3] + " | " + bookTitle[3] + " | F. Scott Fitzgerald | P120.00";
		books[4] = bookID[4] + " | " + bookTitle[4] + " | J.R.R. Tolkien | P130.00";

		// Set all books as not rented and returned
		for(int i = 0; i < maxBooks; i++) {
			bookRented[i] = false;
			bookReturned[i] = false;
		}
		// Show the list of books
		System.out.println(" +~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
		System.out.println("{ Mang Juan's Book Rental Shop }");
		System.out.println(" +~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
		viewBooks();     

		while(true) {
			// Show the menu options to the user
			System.out.println("+------------------------------+");
			System.out.println("|  What would you like to do?  |");
			System.out.println("+------------------------------+");
			System.out.println("| [1] Add New Book             |");
			System.out.println("| [2] View Book Records        |");
			System.out.println("| [3] Rent a Book              |");
			System.out.println("| [4] Return Book              |");
			System.out.println("| [5] View Transaction History |");
			System.out.println("| [6] Exit                     |");
			System.out.println("+------------------------------+");
			// Ask the user to enter a command
			System.out.print("\nEnter command(1-6): ");
			String input = reader.readLine();
			if (!isValidNumber(input)) { // Checks if the input is not a number
				System.out.println("Invalid input. Try again.\n");
				continue;
			}
			int command = Integer.parseInt(input);
			
			// Handle the user's command
			switch(command) {
			case 1: // Add a new book if there's space available
				addNewBook();
				break;
			case 2: // Show the records of all books
				viewBookRecords(); 
				break;
			case 3: // Rent a book
				rentBook(); 
				break;
			case 4: // Return a book if any book is rented
				returnBook(); 
				break;
			case 5: // Show the history of transactions
				viewTransactionHistory(); 
				break;
			case 6: // Exit the program
				System.out.println("Exiting Program.."); 
				return;
			default: // Handle invalid command input
				System.out.println("Invalid input. Please enter a number between 1 and 6.\n"); 
			}
		}
	}
	
	/*
	 * User built-in methods
	 */
	// View book storage
	private static void viewBooks() {
		// Show the list of books and indicate if slots are empty
		for (int i = 0; i < maxBooks; i++) {
			if (books[i] == null) {
				System.out.println("Slot #" + (i + 1) + ": Empty");
			} else {
				System.out.println("Slot #" + (i + 1) + ": " + books[i]);
			}
		}
		System.out.println();
	}
	
	// Adding a book
	private static void addNewBook() throws IOException {
		while (true) {
			// Ask user to enter a book slot number
			System.out.print("\nEnter Book Slot: ");
			String input = reader.readLine();
			if (!isValidNumber(input)) { // Checks if the input is not a number
				System.out.println("Invalid input. Try again.");
				continue;
			}
			selectedSlot = Integer.parseInt(input) - 1;

			// Check if the chosen book slot is empty
			if(bookCount < 10) {
				if(selectedSlot >= 10 || selectedSlot < 0){
					System.out.println("Invalid input. Try again.");
					continue;
				} else if(books[selectedSlot] == null) {
					while (true) {
						System.out.println("\n---------------------");
						System.out.println("Add New Book.");
						// Ask user for a book ID
						System.out.print("\nBook ID: ");
						String inputID = reader.readLine();

						// Check if the book ID is unique
						if (isUniqueInfo(inputID, bookID)) {
							System.out.println("Book ID already exists. Try again.");
							continue; // If not unique, the program will ask again
						} else {
							bookID[selectedSlot] = inputID;
							break; // Break loop if ID is unique
						}
					}
					
					// Get book details from user
					String title = "";
					while(true) {
						System.out.print("Title: ");
						String inputTitle = reader.readLine();
						if(isUniqueInfo(inputTitle, bookTitle)) {
							System.out.println("Book title already exist. Try again.");
							continue;
						} else {
							bookTitle[selectedSlot] = inputTitle;
							break;
						}
					}

					System.out.print("Author: ");
					String author = reader.readLine();
					System.out.print("Rental Price: ");
					String price = reader.readLine();

					// Add book details to the specified slot
					books[selectedSlot] = bookID[selectedSlot] + " | " + bookTitle[selectedSlot] + " | " + author + " | " + price;
					bookCount++; // Increase the count of books
					System.out.println();
					viewBooks();  
					System.out.println("Book has been added successfully\n.");
					break;

				} else if (bookRented[selectedSlot]) { // If the slot is already occupied by a rented book
					System.out.println("Book is rented. Try again.");
				} else { // If the slot is occupied by a non-rented book
					while (true) {
						// Inform the user that the slot is occupied and provide options
						System.out.println("\nBook slot occupied.");
						System.out.println("\n[1] Replace book");
						System.out.println("[2] Exit");

						// Ask user to choose an option
						System.out.print("\nEnter command(1-2): ");
						input = reader.readLine();

						if (!isValidNumber(input)) { // Check if the input is not a number
							System.out.println("Invalid input. Try again");
							continue;
						}
						int command = Integer.parseInt(input);
						System.out.println("\n---------------------");

						if (command == 1) { // Option to choose a different slot
							replace(books, selectedSlot); 
							break;
						} else if (command == 2) { // Option to replace a book
							break;
						} else { // If the input is not within range of options
							System.out.println("Invalid Input. Please enter a number between 1 and 2.");
							continue; // Continue asking for a valid option
						}
					}
				}
			} else if(selectedSlot >= 10 || selectedSlot < 0) { // Not within range of a full book slot
				System.out.println("Invalid Input. Try again.");
				continue;
			} else { // If no space is available, offer options to replace or remove a book
				System.out.println("\nNo slot available.");
				while(true) {
					System.out.println("\n[1] Remove and Replace a book?");
					System.out.println("\n[2] Exit?");
					System.out.print("\nEnter command(1-2): ");
					input = reader.readLine();
					System.out.println("\n---------------------");
					
					if (!isValidNumber(input)) {
						System.out.println("Invalid input. Please enter a number between 1 and 2.");
						continue;
					}
					int command = Integer.parseInt(input);
					
					if(command == 1) { // Replace an existing book
						replace(books, selectedSlot);
						break;
					} else if (command == 2) { // To exit
						break;
					} else { // Handle invalid input
						System.out.println("Invalid Input. Try again.");
						continue;
					}
				}
			}
			break;
		} 
	}
	
	// Replacing a book
	private static void replace(String[] books, int selectedSlot) throws IOException {
		String inputID = "";
		while (true) {
			// Ask user to enter a new Book ID
			System.out.print("\nBook ID: ");
			inputID = reader.readLine();
			// Check if the Book ID already exists
			if (isUniqueInfo(inputID, bookID)) {
				// If the Book ID exists, show a message and exit the loop
				System.out.println("Book ID already exists. Try again.");
				break;
			}
			break; // Break the loop if Book ID is unique
		}
		bookID[selectedSlot] = inputID;
		String inputTitle= "";
		while(true) {
			// Ask user to enter the book's title
			System.out.print("Title: ");
			inputTitle = reader.readLine();
			if (isUniqueInfo(inputTitle, bookTitle)) { // Check if the Book ID already exists
				System.out.println("Book title already exists. Try again.");
				continue;
			}
			break; // Break the loop if Book ID is unique
		}
		bookTitle[selectedSlot] = inputTitle; // Stores the input into the book title array
		// Ask user to enter the book's author
		System.out.print("Author: ");
		String author = reader.readLine();
		// Ask user to enter the book's rental price
		System.out.print("Rental Price: ");
		String price = reader.readLine();
		// Update the book details in the specified slot
		books[selectedSlot] = bookID[selectedSlot] + " | " + bookTitle[selectedSlot] + " | " + author + " | " + price;
		viewBookRecords(); // Display the updated list of books
		System.out.println("Book at slot " + (selectedSlot + 1) + " has been replaced.");
	}
	
	// Checks if a given book ID is unique
	private static boolean isUniqueInfo(String input, String bookInfo[]) {
		boolean notUniqueInfo = false;

		// Loop through all book IDs to check for a match
		for (int i = 0; i < maxBooks; i++) {
			if (matches(input, bookInfo[i])) { // If the input ID matches an existing book ID
				notUniqueInfo = true; // Mark it as not unique
				break; // Stop checking further
			}
		}
		// Return true if the ID is not unique, false otherwise
		return notUniqueInfo;
	}

	// Displays available and unavailable books
	private static void viewBookRecords() throws IOException {
		// Print a list of available books
		System.out.println("\nAvailable Books:");
		// Checks if there is a book in the slot that is not rented and has been returned then displays it.
		for (int i = 0; i < maxBooks; i++) {
			if (books[i] != null && (!bookRented[i] || bookReturned[i])) { 
				System.out.println("Slot #" + (i + 1) + ": " + books[i]); 
			}
		}

		// Print a list of rented books
		System.out.println("\nUnavailable Books (Rented):");
		// Checks if there is a book in the slot that is rented and has not been returned then displays it.
		for (int i = 0; i < maxBooks; i++) {
			if (books[i] != null && bookRented[i] && !bookReturned[i]) {
				System.out.println("Slot #" + (i + 1) + ": " + books[i]); 
			}
		}
		if (rentCounter == 0) {
			System.out.println("There are no books are unavailable.");
		}
		System.out.println();
	}

	// Renting a book  
	private static void rentBook() throws IOException {
		// Ask user to select a book to rent
		System.out.print("Select a Book (1-10): ");
		selectedSlot = Integer.parseInt(reader.readLine()) - 1;

		// Checks if the book number is within range 
		if (selectedSlot < 0 || selectedSlot >= maxBooks || books[selectedSlot] == null) {
			System.out.println("Invalid Selection");
			System.out.println();
			return;
		}
		// Checks if the book is already rented
		if (bookRented[selectedSlot]) {
			System.out.println("The book is already rented out.");
			System.out.println();
			return;
		}

		// Display the details of the selected book
		System.out.println("Selected Book: " + books[selectedSlot]);

		// Ask for the name of the person renting the book
		System.out.print("Renter Name: ");
		renterNames[selectedSlot] = reader.readLine();

		// Mark the book as rented
		bookRented[selectedSlot] = true;
		if(bookRented[selectedSlot]) {
			bookReturned[selectedSlot] = false;
		}
		rentCounter++; // Increase the rent counter
		viewBookRecords(); // Display the updated list of books
		System.out.println("Book rented successfully!");
		System.out.println();
	}
	
	// Return a book
	private static void returnBook() throws IOException{
		while (true) {
			if(rentCounter == 0) { // Checks if no book has been rented
				System.out.println("\nInvalid Return. No Book is Rented.");
				break;
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
					for(int i = 0; i < maxBooks; i++) {
						if(matches(inputBookID, bookID[i])) {
							bookIDFound = true; // Mark that the book ID was found
							bookDetails = books[i]; // Get the book details
							previousRenterNames[i] = renterNames[i]; // Stores previous renter to a separate array 
							renterNames[i] = null; // Removes current renter
							selectedSlot = i; 
							break;
						}
					}
					if(bookIDFound){ // If book ID is found, show the details
						System.out.println(bookDetails);
						break;
					} else { // Asks user again if entered book ID mismatch 
						System.out.println("Book ID Mismatch, Please Try Again.");
						continue;
					}
				}
				// Mark the book as returned
				bookReturned[selectedSlot] = true;
				if(bookReturned[selectedSlot]) {
					bookRented[selectedSlot] = false;
				}
				viewBookRecords(); // Display the updated list of books
				System.out.println("\nBook Status: Available");
				System.out.println("Book Successfully Returned!");
				rentCounter--;
				break;			
			}
		}
		System.out.println();
	}
	
	//Display the transaction history of rented and returned books
	private static void viewTransactionHistory() {
		System.out.println("\n--- Transaction History ---\n");
		System.out.println("Rented Books");
		// Checks and display if there is a rented book
		for (int i = 0; i < maxBooks; i++) { 
			if (renterNames[i] != null) {
				// Show details of each rented book and the renter's name
				System.out.println(books[i] + "\nRenter: " + renterNames[i] + "\n");
			}
		}
		System.out.println("\nReturned Books");
		// Checks and display if there is a returned book
		for (int i = 0; i < maxBooks; i++) { 
			if (renterNames[i] == null && previousRenterNames[i] != null) {
				System.out.println(books[i] + "\nReturned by: " + previousRenterNames[i]);
			} 
		}
		System.out.println();
	}
	
	// Checks if input is a number and not a character/string
	private static boolean isValidNumber(String input) {
	    if (input == null) {
	        return false;
	    }
	    int startIndex = 0;
	    // Check if the first character is a minus sign for negative numbers
	    if (input.charAt(0) == '-') {
	        if (input.length() == 1) { // If the string is just "-", it's not a valid number
	            return false;
	        }
	        startIndex = 1; // Start checking the rest of the string after the minus sign
	    }
	    // Check that the rest of the characters are digits
	    for (int i = startIndex; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if (c < '0' || c > '9') { // If any character is not a digit, return false
	            return false;
	        }
	    }
	    return true; // If all checks pass, the input is a valid integer
	}
	
	// Checks if string is equal to another string
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