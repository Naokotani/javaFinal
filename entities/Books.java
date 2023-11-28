package entities;
import java.util.Scanner;
import java.util.ArrayList;


public class Books {
	class Book {
		String title;
		int book_id;
		int author_id;
		String genre;
		double price;
		
		public Book(String title, int book_id, int author_id, String genre, double price) {
			this.title = title;
			this.book_id = book_id;
			this.author_id = author_id;
			this.genre = genre;
			this.price = price;
		}
	}

	ArrayList<Book> books = new ArrayList<>();

	public String input(Scanner input) {
		String title;
		int book_id;
		int author_id;
		String genre;
		double price;
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
		System.out.print("Author ID: ");
		author_id = input.nextInt();
		input.nextLine();
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

		Book book = new Book(title, book_id, author_id, genre, price); 

		books.add(book);

		return "Book " + title + " created succesfully";
	} 

	public void list(){
		for (Book i: books) {
			System.out.println("ISBN: " + i.book_id);
			System.out.println("Title: " + i.title);
			System.out.println("Author ID: " + i.author_id);
			System.out.println("Genre: " + i.genre);
			System.out.println("Price: " + i.price);
		}
	}

	public String update() {
		return "Not yet implemented";
	}

	public String destroy() {
		return "Not yet implemented";
	}

}
