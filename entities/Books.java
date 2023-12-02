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
		Book book = getBook(id);
		if (book != null) {
			price = book.price;
		} else {
			System.out.println("Book ID invalid: " + id);
		}

		return price;
	}

	public Boolean updateStock(int id, int quantity) {
		Boolean isStock = false;
		Book b = getBook(id);
		if (quantity <= b.quantity){
			b.quantity -= quantity;
			isStock = true;
			System.out.println("\n**************************\n");
			System.out.println("Remaining stock: " + b.quantity);
		}
		return isStock;
	}

	public String update(Books books, Input in, int id) {
		Book book = getBook(id);
		System.out.println("Which element would you like to update?");
		System.out.println("i: ISBN, t: Title, a: Author name, g: genre, p: price, q: quantity");
		String success = "Update successful";

		if (book == null) {
			return "Can't find book with ISBN: " + id;
		} 

		switch(in.getChar("> ")) {
		case 'i':
			int newId = in.getInt("Enter new ID: ");
			if (in.validation) {
				book.book_id = newId;
				return success;
			}
			break;
		case 't':
			String newTitle = in.getString("Enter new title: ");
			if (in.validation) {
				book.title = newTitle;
				return success;
			}
			break;
		case 'a':
			String newName = in.getString("Enter new Author Name: ");
			if (in.validation) {
				book.author_name = newName;
				return success;
			}
			break;
		case 'g':
			String newGenre = in.getString("Enter new genre: ");
			if (in.validation) {
				book.genre = newGenre;
				return success;
			}
			break;
		case 'p':
			double newPrice = in.getDouble("Enter new price: ");
			if (in.validation) {
				book.price = newPrice;
				return success;
			}
			break;
		case 'q':
			int newQuant = in.getInt("Enter new quantity: ");
			if (in.validation) {
				book.quantity = newQuant;
				return success;
			}
			break;
		default:
			System.out.println("I didn't catch that.");
			break;
			
		}
		in.validation = true;
		return "Update Failed";

	}

	public Book getBook(int id) {
		for (Book i: books) {
			if (id == i.book_id) {
				System.out.println(i.title);
				return i;
			}
		}
		return null;
	}

	public String destroy(Input in, int id) {
		Book b = getBook(id);

		System.out.println("id in destroy: " + id);
		if (!in.validation) {

			return "Book not found";
		}
		in.validation = true;

		if (b != null) {
			System.out.println("\n*****************\n\n");
			System.out.println("ISBN: " + b.book_id);
			System.out.println("Title: " + b.title);
			System.out.println("Author name: " + b.author_name);
			System.out.println("Genre: " + b.genre);
			System.out.println("Price: " + b.price);
			System.out.println("Quantity: " + b.quantity);
			System.out.println("\n\n*****************\n");
			System.out.println("Are you sure you want to delete" + b.title + "?");
			System.out.println("y: delete, n: abort");
		} else {
			return "Book " + id + " not found";
		}

		while (true) {
			char res = in.getChar("> ");
			if (res == 'y') {
				books.remove(b);
				return "Book Deleted";
			} else if (res == 'n'){
				return "aborted";
			}
		}
	}

}
