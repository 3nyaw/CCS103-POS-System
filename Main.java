package PrelimActivity1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader to read input from the user
	private static String[] books = new String[10]; // Array to store details about books
	private static String[] bookID = new String[10]; // Array to store unique IDs of the books
	private static boolean[] bookRented = new boolean[10]; // Array to track whether the book is rented or not
	private static int size = 10; // Variable to store the total number of slots
	private static int bookCount = 5; // Variable to track the current number of books
	private static int slot = 0; // Variable to store the current slot number being used for book operations
	private static int selectedBook = 0; // Variable to store the index of the book selected by the user
    private static String[] renterNames = new String[10]; // Array to store the names of people who rent books
    private static String name; // Variable to store the name of the current renter
    private static int rentCounter = 0; // Counter to keep track of the total number of rentals made
    
    public static void main(String[] args) throws IOException {
        
        // Set up initial book IDs
        bookID[0] = "2023-001";
        bookID[1] = "2023-002";
        bookID[2] = "2023-003";
        bookID[3] = "2024-001";
        bookID[4] = "2024-002";
        
        // Add details for each book including ID, title, author, and price
        books[0] = bookID[0] + " | To Kill a Mockingbird | Harper Lee | P120.00";
        books[1] = bookID[1] + " | 1984 | George Orwell | P150.00";
        books[2] = bookID[2] + " | Pride and Prejudice | Jane Austen | P110.00";
        books[3] = bookID[3] + " | The Great Gatsby | F. Scott Fitzgerald | P120.00";
        books[4] = bookID[4] + " | The Lord of The Rings | J.R.R. Tolkien | P130.00";
        
        // Set all books as not rented
        for(int i = 0; i < size; i++) {
            bookRented[i] = false;
        }
        
        // Show the list of books
        viewBooks(books);
        
        // Start a loop to handle user commands
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
            case 1:
                // Add a new book if there's space available
                if(bookCount < 10) {
                    System.out.println("\n---------------------");
                    System.out.println("Add New Book.");
                    addNewBook(books);
                    viewBooks(books);
                } else {
                    // If no space is available, offer options to replace or remove a book
                    System.out.println("\nNo slot available.");
                    boolean actionTaken = false;
                    while(!actionTaken) {
                        System.out.println("\n1. Replace book");
                        System.out.println("2. Remove book");
                        System.out.print("\nEnter command(1-2): ");
                        int input = Integer.parseInt(reader.readLine());
                        System.out.println("\n---------------------");

                        if(input == 1) {
                            // Replace an existing book
                            replace(books, slot, reader);
                            actionTaken = true;
                        } else if(input == 2) {
                            // Remove an existing book
                            remove(books, slot);
                            actionTaken = true;
                        } else {
                            // Handle invalid input
                            System.out.println("Invalid Input. Try again.");
                        }
                    }
                    viewBooks(books);
                }
                break;
            case 2: 
                // Show the records of all books
                viewBookRecords();
                break;
            case 3:
                // Rent a book
                rentBook();
                break;
            case 4:
                // Return a book if any book is rented
                if(rentCounter == 0) {
                    System.out.println("\nInvalid Return, Book is not Rented");
                    continue;
                } else {
                    returnBook();
                }
                break;
            case 5:
                // Show the history of transactions
                viewTransactionHistory();
                break;
            case 6:
                // Exit the program
                System.out.println("Exiting Program..");
                return;
            default:
                // Handle invalid command input
                System.out.println("Invalid input. Try again.");
                continue;
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
            if (books[slot] == null) {
                while (true) {
                    // Ask user for a book ID
                    System.out.print("\nBook ID: ");
                    String input = reader.readLine();
                    
                    // Check if the book ID is unique
                    if (uniqueID(input)) {
                        System.out.println("Book ID already exists. Try again.");
                        continue; // If not unique, the program will ask again
                    }
                    break; // Break loop if ID is unique
                }
                
                // Get book details from user
                System.out.print("Title: ");
                String title = reader.readLine();
                System.out.print("Author: ");
                String author = reader.readLine();
                System.out.print("Rental Price: ");
                String price = reader.readLine();
                
                // Add book details to the specified slot
                books[slot] = bookID[slot] + " | " + title + " | " + author + " | " + price;
                slotTaken = true;
                bookCount++; // Increase the count of books
                break;
                
            // If the slot is already occupied by a rented book
            } else if (bookRented[slot]) {
                System.out.println("Book is rented. Try again.");
            
            // If the slot is occupied by a non-rented book
            } else {
                while (true) {
                    // Inform the user that the slot is occupied and provide options
                    System.out.println("\nBook slot occupied.");
                    System.out.println("\n1. Choose another slot.");
                    System.out.println("2. Replace book");
                    System.out.println("3. Remove book");
                    
                    // Ask user to choose an option
                    System.out.print("\nEnter command(1-3): ");
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
                        replace(books, slot, reader); // Call replace method
                        break;
                    } else if (command == 3) {
                        // Option to remove the current book in the slot
                        if (consists(books[selectedBook], "Rented")) {
                            System.out.println("Book is currently rented. Try again.");
                            break;
                        }
                        remove(books, slot); // Call remove method
                        break;
                    } else {
                        // If user enters an invalid option
                        System.out.println("Invalid Input. Try again.");
                        continue; // Continue asking for a valid option
                    }
                }
            }
        }
    }

	//replacing a book
    private static void replace(String[] books, int slot, BufferedReader reader2) throws IOException {
        while (true) {
            // Ask user to enter a new Book ID
            System.out.print("\nBook ID: ");
            String input = reader.readLine();
            
            // Check if the Book ID already exists
            if (uniqueID(input)) {
                // If the Book ID exists, show a message and exit the loop
                System.out.println("Book ID already exists. Try again.");
                break;
            }
            break; // Break the loop if Book ID is unique
        }

        // Ask user to enter the book's title
        System.out.print("Title: ");
        String title = reader.readLine();
        
        // Ask user to enter the book's author
        System.out.print("Author: ");
        String author = reader.readLine();
        
        // Ask user to enter the book's rental price
        System.out.print("Rental Price: ");
        String price = reader.readLine();
        
        // Update the book details in the specified slot
        books[slot] = bookID[slot] + " | " + title + " | " + author + " | " + price;
        
        // Show a message indicating the book has been replaced
        System.out.println("Book at slot " + slot + " has been replaced.");
        
        // Display the updated list of books
        viewBooks(books);
    }

	//removing a book
 // Method to remove a book from a specific slot
    private static void remove(String[] book, int slot) {
        // Set the book at the specified slot to null (remove it)
        book[slot] = null;
        
        // Print a message indicating the book has been removed
        System.out.println("Book at slot " + slot + " has been removed.");
        
        // Decrease the count of books by one
        bookCount--;
        
        // Display the updated list of books
        viewBooks(books);
    }

    // Method to check if a given book ID is unique
    private static boolean uniqueID(String input) {
        boolean notUniqueID = false;
        
        // Loop through all book IDs to check for a match
        for (int i = 0; i < size; i++) {
            // If the input ID matches an existing book ID
            if (input.matches(bookID[i])) {
                notUniqueID = true; // Mark it as not unique
                break; // Stop checking further
            }
        }
        
        // Return true if the ID is not unique, false otherwise
        return notUniqueID;
    }


    private static void viewBookRecords() throws IOException {
        // Print a list of available books
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < size; i++) {
            if (books[i] != null && !bookRented[i]) {
                // Show details of each book that is not rented
                System.out.println("Slot #" + (i + 1) + ": " + books[i]);
            }
        }
        
        // Print a list of rented books
        System.out.println("\nUnavailable Books (Rented):");
        for (int i = 0; i < size; i++) {
            if (books[i] != null && bookRented[i]) {
                // Show details of each book that is currently rented
                System.out.println("Slot #" + (i + 1) + ": " + books[i]);
            }
        }
        System.out.println();
    }

    private static void rentBook() throws IOException {
        // Ask user to select a book to rent
        System.out.print("Select a Book (1-10): ");
        selectedBook = Integer.parseInt(reader.readLine()) - 1;

        // Check if the selected book is valid
        if (selectedBook < 0 || selectedBook >= size || books[selectedBook] == null) {
            System.out.println("Invalid Selection");
            System.out.println();
            return;
        }

        // Check if the book is already rented
        if (bookRented[selectedBook]) {
            System.out.println("The book is already rented out.");
            System.out.println();
            return;
        }

        // Print the details of the selected book
        System.out.println("Selected Book: " + books[selectedBook]);
        
        // Ask for the name of the person renting the book
        System.out.print("Renter Name: ");
        name = reader.readLine();
        renterNames[selectedBook] = name;

        // Mark the book as rented
        bookRented[selectedBook] = true;
        System.out.println("Book rented successfully!");
        System.out.println();
        
        // Increase the rent counter
        rentCounter++;
        
        // Show the updated list of books
        viewBooks(books);
    }

    private static void returnBook() throws IOException {
        while (true) {
            // Show the list of books
            viewBooks(books);
            
            System.out.print("\n---------------------");
            System.out.println("\nReturn a Book");
            
            boolean bookIdFound = false;
            String bookDetails = " ";

            while (true) {
                // Ask for the book ID to return
                System.out.print("\nBook ID: ");
                String bookId = reader.readLine();

                // Check if the book ID matches any rented book
                for (int i = 0; i < size; i++) {
                    if (bookId.matches(bookID[selectedBook])) {
                        bookIdFound = true; // Mark that the book ID was found
                        bookDetails = books[i]; // Get the book details
                        break;
                    }
                }

                // If book ID is found, show the details
                if (bookIdFound) {
                    System.out.print(bookDetails + "\n");
                    break;
                } else {
                    System.out.print("Book ID Mismatch, Please Try Again.");
                    continue; // Ask again if book ID doesn't match
                }
            }
            
            // Mark the book as available
            System.out.println("\nBook Status: Available");
            System.out.println("Book Successfully Returned!\n");
            bookRented[selectedBook] = false;
            break;
        }
    }

    private static void viewTransactionHistory() {
        // Print the transaction history of rented books
        System.out.println("\n--- Transaction History ---\nRented Books");
        for (int i = 0; i < size; i++) {
            if (renterNames[i] != null) {
                // Show details of each rented book and the renter's name
                System.out.println(books[i] + "\nRenter: " + renterNames[i]);
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

    private static boolean consists(String str1, String str2) {
        // Check if either string is null or if the second string is longer
        if (str1 == null || str2 == null || str2.length() > str1.length()) {
            return false;
        }
        
        // Lengths of the main text and the word to search
        int str1Length = str1.length();
        int str2Length = str2.length();

        // Iterate through the text
        for (int i = 0; i <= str1Length - str2Length; i++) {
            int j;
            
            // Check each character of the substring
            for (j = 0; j < str2Length; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    break; //  if characters don't match
                }
            }
            
            if (j == str2Length) {
                return true; // Found a matching substring
            }
        }
        return false; // No match found
    }	
}