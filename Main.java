package PrelimActivity1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static String[] books = new String[10];
	private static int bookCount = 5;
    
	public static void main(String[] args) throws IOException {
		
		books[0] = "2023-001 | To Kill a Mockingbird | Harper Lee | P120.00";
		books[1] = "2023-002 | 1984 | George Orwell | P150.00";
		books[2] = "2023-003 | Pride and Prejudice | Jane Austen | P110.00";
		books[3] = "2024-001 | The Great Gatsby | F. Scott Fitzgerald | P120.00";
		books[4] = "2024-002 | The Lord of The Rings | J.R.R. Tolkien | P130.00";
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
					System.out.println("No slot available.");
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

	private static void viewTransactionHistory() {
		// TODO Auto-generated method stub
		
	}

	private static void returnBook() throws IOException{
		
		while (true) {
		System.out.print("\n---------------------");
		System.out.println("\nReturn a Book");
		
		System.out.print("\nEnter Book Slot: ");
		int slot = Integer.parseInt(reader.readLine())-1;
		
		//Checking valid slot number
		if(slot < 0 || slot >=books.length) {
			System.out.println("Invalid Slot Number, Please Try Again. ");
			continue;
		}
		//Checking book slot occupied
		if ( books[slot] != null ) {
			System.out.println("Book Slot Occupied. ");
			continue;
		}
		
		System.out.print("\nBook ID: ");
		String bookID = reader.readLine();
		System.out.print("Title: ");
		String title = reader.readLine();
		System.out.print("Author: ");
		String author = reader.readLine();
		System.out.print("Rental Price: ");
		String price = reader.readLine();
		books[slot] = bookID + " | " + title + " | " + author + " | " + price; 
		bookCount++;
		
		System.out.print("\nDetails of The Book Returned [ " + " Book Id: " + bookID + " Title: " + title + " Author: " + author + " Rental Price: " + price+ " ]");
		System.out.println();
		System.out.print("Book Status: Available \n");
		System.out.print("Book Successfully Returned!\n");
		
		
		viewBooks(books);
		break;
		}
	}
	private static void rentBook() {
		// TODO Auto-generated method stub
		
	}

	private static void viewBookRecords() {
		// TODO Auto-generated method stub
		
	}

	private static void viewBooks(String books[]) {
		System.out.println();
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				System.out.println("Slot #" + (i+1) + ": Empty");
			} else {
				System.out.println("Slot #" + (i+1) + ": " + books[i]);
			}
		}
		System.out.println();
	}

	private static void addNewBook(String book[]) throws IOException{
		boolean slotTaken = false;
		int slot = 0;
		while(true) {
			System.out.print("\nEnter Book Slot: ");
			slot = Integer.parseInt(reader.readLine())-1;
			if(book[slot] == null) {
				System.out.print("Book ID: ");
				String bookID = reader.readLine();
				System.out.print("Title: ");
				String title = reader.readLine();
				System.out.print("Author: ");
				String author = reader.readLine();
				System.out.print("Rental Price: ");
				String price = reader.readLine();
				book[slot] = bookID + " | " + title + " | " + author + " | " + price; 
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
					replace(book, slot, reader);
					break;
				} else if(command == 3) {
					remove(book, slot);
					break;
				} else {
					System.out.println("Invalid Input. Try again.");
					continue;
					}
				}
			}
		}
	}

	private static void replace(String[] book, int slot, BufferedReader reader2) throws IOException {
		System.out.print("Book ID: ");
        String bookID = reader.readLine();
        System.out.print("Title: ");
        String title = reader.readLine();
        System.out.print("Author: ");
        String author = reader.readLine();
        System.out.print("Rental Price: ");
        String price = reader.readLine();
        book[slot] = bookID + " | " + title + " | " + author + " | " + price;
        System.out.println("Book at slot " + slot + " has been replaced.");
        viewBooks(books);
	}
	
	private static void remove(String[] book, int slot) {
        book[slot] = null;
        System.out.println("Book at slot " + slot + " has been removed.");
        viewBooks(books);
	}
}