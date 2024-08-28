package PrelimActivity1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static String[] books = new String[10];
	private static String[] bookID = new String[10];
	private static int bookCount = 5;
	private static int slot = 0;
	private static int selectedBook = 0;
    
	public static void main(String[] args) throws IOException {
		
		bookID[0] = "2023-001";
		bookID[1] = "2023-002";
		bookID[2] = "2023-003";
		bookID[3] = "2024-001";
		bookID[4] = "2024-002";
		
		books[0] = bookID[0] + " | To Kill a Mockingbird | Harper Lee | P120.00";
		books[1] = bookID[1] + " | 1984 | George Orwell | P150.00";
		books[2] = bookID[2] + " | Pride and Prejudice | Jane Austen | P110.00";
		books[3] = bookID[3] + " | The Great Gatsby | F. Scott Fitzgerald | P120.00";
		books[4] = bookID[4] + " | The Lord of The Rings | J.R.R. Tolkien | P130.00";


		viewBooks(books);
		
		while(true) {
			System.out.println("1. Add New Book");
			System.out.println("2. View Book Records");
			System.out.println("3. Rent a Book");
			System.out.println("4. Return Book");
			System.out.println("5. View Transaction History");
			System.out.println("6. Exit");
			
			System.out.print("\nEnter command(1-6): ");
			int command = Integer.parseInt(reader.readLine());
			
			switch(command) {
			case 1:
				if(bookCount < 10) {
					System.out.println("\n---------------------");
					System.out.println("Add New Book. ");
					addNewBook(books);
				} else {
					System.out.println("\nNo slot available.");
					while(true) {
						System.out.println("\n1. Replace book");
						System.out.println("2. Remove book");
						System.out.print("\nEnter command(1-2): ");
						int input = Integer.parseInt(reader.readLine());
						System.out.println("\n---------------------");
						
						if(input == 1) {
							replace(books, slot, reader);
							break;
						} else if(input == 2) {
							remove(books, slot);
							break;
						} else {
							System.out.println("Invalid Input. Try again.");
							continue;
						}
					}
				}
				viewBooks(books);
				break;
			case 2: 
				viewBookRecords();
				break;
			case 3:
				rentBook();
				break;
			case 4:
				returnBook();
				break;
			case 5:
				viewTransactionHistory();
				break;
			case 6:
				System.out.println("Exiting Program..");
				break;
			default:
				System.out.println("Invalid input. Try again.");
				continue;
			}
			if(command == 6) 
				break;
			
		}
	}
	
	private static void addNewBook(String books[]) throws IOException{
		boolean slotTaken = false;
		while(true) {
			System.out.print("\nEnter Book Slot: ");
			slot = Integer.parseInt(reader.readLine())-1;
			if(books[slot] == null) {
				while(true) {
					System.out.print("\nBook ID: ");
					String input = reader.readLine();
					boolean notUniqueID = false;
					for(int i = 0; i < bookID.length; i++) {
						if(input.equals(bookID[i])) {
							notUniqueID = true;
							break;
				        }
					}
					if(notUniqueID) {
						System.out.println("Book ID already exist. Try again.");
						continue;
					} else {
						break;
					}
				}
				System.out.print("Title: ");
				String title = reader.readLine();
				System.out.print("Author: ");
				String author = reader.readLine();
				System.out.print("Rental Price: ");
				String price = reader.readLine();
				books[slot] = bookID[slot] + " | " + title + " | " + author + " | " + price; 
				slotTaken = true;
				bookCount++;
				break;
			} else {
				while(true) {
					System.out.println("\nBook slot occupied.");
					System.out.println("\n1. Choose another slot.");
					System.out.println("2. Replace book");
					System.out.println("3. Remove book");
					System.out.print("\nEnter command(1-3): ");
					int command = Integer.parseInt(reader.readLine());
					System.out.println("\n---------------------");
					
					if(command == 1) {
						break;
					} else if(command == 2) {
						replace(books, slot, reader);
						break;
					} else if(command == 3) {
						remove(books, slot);
						break;
					} else {
						System.out.println("Invalid Input. Try again.");
						continue;
					}
				}
			}
		}
	}

	private static void viewBookRecords() throws IOException{
		System.out.println("\nAvailable Books:");
	    for (int i = 0; i < books.length; i++) {
	        if (books[i] != null && !books[i].contains("Rented")) {
	            System.out.println("Slot #" + (i + 1) + ": " + books[i]);
	        }
	    }
	
	    System.out.println("\nUnavailable Books (Rented):");
	    for (int i = 0; i < books.length; i++) {
	        if (books[i] != null && books[i].contains("Rented")) {
	            System.out.println("Slot #" + (i + 1) + ": " + books[i]);
	        }
	    }
	    System.out.println();
	}
	
	private static void rentBook() throws IOException{
        System.out.print("Select a Book (1-10): ");
        selectedBook = Integer.parseInt(reader.readLine()) - 1;

        if(selectedBook < 0 || selectedBook >= books.length || books[selectedBook] == null) {
            System.out.println("Invalid Selection");
            System.out.println();
            return;
        }

        if (books[selectedBook].contains("Rented")) {
            System.out.println("The book is already rented out.");
            System.out.println();
            return;
        }

        System.out.println("Selected Book: " + books[selectedBook]);
        System.out.print("Renter Name: ");
        String name = reader.readLine();

        books[selectedBook] +=  (" (Rented)");
        System.out.println("Book rented successfully!");

        System.out.println();
        viewBooks(books);
	}

	private static void returnBook() throws IOException{
		while (true) {
	        viewBooks(books);

	        System.out.print("\n---------------------");
	        System.out.println("\nReturn a Book");

	        boolean bookIdFound = false;
	        String bookDetails = " ";

	        while(true) {
	            System.out.print("\nBook ID: ");
	            String bookId = reader.readLine();

	            for(int i=0; i<bookID.length; i++) {
	                if(bookId.equals(bookID[selectedBook])) {
	                    bookIdFound = true;
	                    bookDetails = books[i];
	                    break;
	                }
	            }

	            if(bookIdFound){
	                System.out.print("Book Details: " +  bookDetails + "\n");
	                System.out.println("\nBook Status: Available");
	                System.out.println("Book Successfully Returned!");
	                break;

	            } else {
	                System.out.print("Book ID Mismatch, Please Try Again.");
	                continue;
	            }
	        }
	    }		
	}

	private static void viewTransactionHistory() {
		// TODO Auto-generated method stub
		
	}

	private static void viewBooks(String books[]) {
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				System.out.println("Slot #" + (i+1) + ": Empty");
			} else {
				System.out.println("Slot #" + (i+1) + ": " + books[i]);
			}
		}
		System.out.println();
	}

	private static void replace(String[] books, int slot, BufferedReader reader2) throws IOException {
		while(true) {
			System.out.print("\nBook ID: ");
			String input = reader.readLine();
			boolean notUniqueID = false;
			for(int i = 0; i < bookID.length; i++) {
				if(input.equals(bookID[i])) {
					notUniqueID = true;
					break;
		        }
			}
			if(notUniqueID) {
				System.out.println("Book ID already exist. Try again.");
				continue;
			} else {
				break;
			}
		}

        System.out.print("Title: ");
        String title = reader.readLine();
        System.out.print("Author: ");
        String author = reader.readLine();
        System.out.print("Rental Price: ");
        String price = reader.readLine();
        books[slot] = bookID[slot] + " | " + title + " | " + author + " | " + price;
        System.out.println("Book at slot " + slot + " has been replaced.");
        viewBooks(books);
	}
	
	private static void remove(String[] book, int slot) {
        book[slot] = null;
        System.out.println("Book at slot " + slot + " has been removed.");
        bookCount--;
        viewBooks(books);
	}
}
