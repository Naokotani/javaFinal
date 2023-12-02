import java.util.Scanner;
import entities.*;

class InventoryManager{
	public static void main(String[] args) {
		Books books = new Books();
		Orders orders = new Orders();
		Scanner input = new Scanner(System.in);
		Boolean run = true;

		while (run == true) {
			System.out.println("Enter the correspoding letter to perform action.");
			System.out.println("n: New, l: List, u: Update, s: Sales Report, d: Delete, e: Exit\n");
			System.out.print("> ");
			String options = "b: book, a: author, c: customer, o: order\n";

			switch (getRes(input)) {
			case 'n':
				System.out.println("Which would you like to create?");
				System.out.println(options);
				create(input, books, orders);
				break;
			case 'l':
				System.out.println("Which would you like to list?");
				System.out.println(options);
				read(input, books, orders);
				break;
			case 'u':
				System.out.println("Which would you like to update?");
				System.out.println(options);
				update(input, books, orders);
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
				destroy(input, books, orders);
				break;
			case 'e':
				run = false;
			}
		}
		input.close();
	} 

	static void create(Scanner input, Books books, Orders orders){
		switch (getRes(input)) {
		case 'b':
			books.input(input);
			break;
		case 'o':
			System.out.println(orders.input(input, books));
			break;
		}
	}

	static void read(Scanner input, Books books, Orders orders) {
		switch (getRes(input)) {
		case 'b':
			books.list();
			break;
		case 'o':
			orders.list();
			break;
		}
	}
	
	static void update(Scanner input, Books books, Orders orders) {
		switch (getRes(input)) {
		case 'b':
			books.list();
			break;
		case 'o':
			orders.list();
			break;
		}
	}
	
	static void destroy(Scanner input, Books books, Orders orders) {
		switch (getRes(input)) {
		case 'b':
			books.list();
			break;
		case 'o':
			orders.list();
			break;
		}
	}

	static char getRes(Scanner input) {
		try {
			System.out.print("> ");
			return input.next().charAt(0);
		} catch(Exception e) {
			return 'a';
		}
	}
}
