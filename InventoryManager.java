import entities.*;

class InventoryManager{
	public static void main(String[] args) {
		Books books = new Books();
		Orders orders = new Orders();
		Input in = new Input();
		Boolean run = true;

		while (run == true) {
			System.out.println("Enter the correspoding letter to perform action.");
			System.out.println("n: New, l: List, u: Update, s: Sales Report, d: Delete, e: Exit\n");
			String options = "b: book, o: order\n";

			switch (in.getChar("> ")) {
			case 'n':
				System.out.println("Which would you like to create?");
				System.out.println(options);
				create(in, books, orders);
				break;
			case 'l':
				System.out.println("Which would you like to list?");
				System.out.println(options);
				read(in, books, orders);
				break;
			case 'u':
				System.out.println("Which would you like to update?");
				System.out.println(options);
				update(in, books, orders);
				break;
			case 's':
				System.out.println(options);
				String[] saleArray = orders.sales(books);
				System.out.println("**************************\n");
				System.out.println("Books sold: " + saleArray[0]);
				System.out.println("Total sales: " + saleArray[1]);
				System.out.println("\n**************************\n");
				break;
			case 'd':
				System.out.println("Which would you like to delete?");
				System.out.println(options);
				destroy(in, books, orders);
				break;
			case 'e':
				run = false;
			}
		}
		in.close();
	}

	static void create(Input in, Books books, Orders orders){
		switch (in.getChar("> ")) {
		case 'b':
			System.out.println(books.input(in));
			break;
		case 'o':
			System.out.println(orders.input(in, books));
			break;
		}
	}

	static void read(Input in, Books books, Orders orders) {
		switch (in.getChar("> ")) {
		case 'b':
			books.list();
			break;
		case 'o':
			orders.list();
			break;
		}
	}
	
	static void update(Input in, Books books, Orders orders) {
		switch (in.getChar("> ")) {
		case 'b':
			int id = in.getChar("Enter book ID: ");
			books.update(books, in, id);
			break;
		case 'o':
			// int id = in.getChar("Enter order ID: ");
			// orders.update(in, id);
			orders.list();
			break;
		}
	}
	
	static void destroy(Input in, Books books, Orders orders) {
		switch (in.getChar("> ")) {
		case 'b':
			books.list();
			break;
		case 'o':
			orders.list();
			break;
		}
	}
}
