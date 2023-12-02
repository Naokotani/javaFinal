package entities;
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

	public String input(Input in) {
		int book_id = in.getInt("ISBN: ");
		String title = in.getString("Title: ");
		String author_name = in.getString("Author name: ");
		String genre = in.getString("Genre: ");
		double price = in.getDouble("Price: ");
		int quantity = in.getInt("Quantity: ");

		if (in.validation) {
			Book book = new Book(title, book_id, author_name,
								 genre, price, quantity); 
			
		books.add(book);
		
		return "Book " + title + " created succesfully";
		} else {
			in.validation = true;
			return "\n**Book Creation Failed**\n";
		}
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

	public double getBookPrice(int id) {
		double price = 0.0;
		for (Book i: books) {
			if (id == i.book_id) {
				price = i.price;
			} 
		}

		if (price == 0.0) {
			System.out.println("Book ID invalid: " + id);
		}
		return price;
	}

	public Boolean updateStock(int id, int quantity) {
		Boolean isStock = false;

		itemFound:
		for (Book i: books) {
			if (id == i.book_id) {
				if (quantity <= i.quantity){
					i.quantity -= quantity;
					isStock = true;
					System.out.println("\n**************************\n");
					System.out.println("Remaining stock: " + i.quantity);
					break itemFound;
				}
			} 
		}
		return isStock;
	}

	public String update() {
		return "Not yet implemented";
	}

	public String destroy() {
		return "Not yet implemented";
	}

}
