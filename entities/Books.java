package entities;
import java.util.Scanner;
import java.util.ArrayList;


public class Books {
	class Book {
		String title;
		int book_id;
		String author_name;
		int quantity;
		String genre;
		double price;
		
		public Book(String title, int book_id, String author_name,
					String genre, double price, int quantity) {
			this.title = title;
			this.book_id = book_id;
			this.author_name = author_name;
			this.genre = genre;
			this.price = price;
			this.quantity = quantity;
		}
	}

	ArrayList<Book> books = new ArrayList<>();

	public String input(Scanner input) {
		String title;
		int book_id;
		String author_name;
		String genre;
		double price;
		int quantity;

		String fail = "Book creation failed";

		try {
		System.out.print("Book ID: ");
		book_id = input.nextInt();
		input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail; 
		}

		try {
		System.out.print("Title: ");
		title = input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			title = "";
			return fail;
		}

		try {
		System.out.print("Author name: ");
		author_name = input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
		System.out.print("Genre: ");
		genre = input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
		System.out.print("Price: ");
		price = input.nextDouble();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
		System.out.print("Quanity: ");
		quantity = input.nextInt();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		Book book = new Book(title, book_id, author_name,
							 genre, price, quantity); 

		books.add(book);

		return "Book " + title + " created succesfully";
	} 

	public void list(){
		System.out.println("Current Inventory");
		System.out.println("*****************\n\n");
		for (Book i: books) {
			System.out.println("ISBN: " + i.book_id);
			System.out.println("Title: " + i.title);
			System.out.println("Author name: " + i.author_name);
			System.out.println("Genre: " + i.genre);
			System.out.println("Price: " + i.price);
			System.out.println("Quantity: " + i.quantity);
		System.out.println("\n");
		}
		System.out.println("\n*****************\n\n");

	}

	public String update() {
		return "Not yet implemented";
	}

	public String destroy() {
		return "Not yet implemented";
	}

}
