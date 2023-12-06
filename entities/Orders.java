package entities;
import java.util.ArrayList;

public class Orders {
	class Order {
		private int order_id;
		private int customer_id;
		private int book_id;
		private String order_date;
		private int quantity;


		public Order(int order_id,
					 int customer_id,
					 int book_id,
					 String order_date,
					 int quantity) {
			this.order_id = order_id;
			this.customer_id = customer_id;
			this.book_id = book_id;
			this.order_date = order_date;
			this.quantity = quantity;
		}
	}

	ArrayList<Order> orders = new ArrayList<>();

	public String input(Input in, Books books) {
		int order_id = in.getInt("Order ID: ");
		int customer_id = in.getInt("Customer ID: ");
		int book_id = in.getInt("Book ID: ");
		String order_date = in.getString("Order Date: ");
		int quantity = in.getInt("Quantity: ");

		Boolean stockRemaining = books.updateStock(book_id, quantity);

		if (stockRemaining && in.validation) {
			Order order = new Order(order_id,
									customer_id,
									book_id,
									order_date,
									quantity);
			orders.add(order);

			return "Order created successfully.\n\n" +
				"**************************\n";
		} else if (!in.validation){
			in.validation = true;
			return "Improper input";
		} else {
			return "Insufficient stock\n\n";

		}

	} 
	
	public void list(){
		System.out.println("Orders list");
		System.out.println("\n**************************\n");
		for (Order i: orders) {
			System.out.println("Order ID: " + i.order_id);
			System.out.println("Customer ID: " + i.customer_id);
			System.out.println("Book ID: " + i.book_id);
			System.out.println("Date Ordered: " + i.order_date);
			System.out.println("Quantity: " + i.quantity);
			System.out.println("\n");
		}
		System.out.println("**************************\n");
	}

	public String[] sales(Books books) {
		int quantity = 0;
		double totalSales = 0.0;

		for (Order i: orders) {
			quantity += i.quantity;
			totalSales += books.getBookPrice(i.book_id) * i.quantity;
		}

		String[] sales = {Integer.toString(quantity), Double.toString(totalSales)};
		return sales;
	}
	public String update(Books books, Input in, int id) {
		Order order = getOrder(id);
		System.out.println("Which element would you like to update?");
		System.out.println("o: Order ID, c: Customer ID, b: Book ID, d: Order Date, q: quantity");
		String success = "Update successful";

		if (order == null) {
			return "Can't find order with ID: " + id;
		} 

		switch(in.getChar("> ")) {
		case 'o':
			int newOrderId = in.getInt("Enter new ID: ");
			if (in.validation) {
				order.order_id = newOrderId;
				return success;
			}
			break;
		case 'c':
			int newCustId = in.getInt("Enter new Customer ID: ");
			if (in.validation) {
				order.customer_id = newCustId;
				return success;
			}
			break;
		case 'a':
			int newBookId = in.getInt("Enter new Book ID: ");
			if (in.validation) {
				order.book_id = newBookId;
				return success;
			}
			break;
		case 'd':
			String newDate = in.getString("Enter new date: ");
			if (in.validation) {
				order.order_date = newDate;
				return success;
			}
			break;
		case 'q':
			int newQuant = in.getInt("Enter new quantity: ");
			if (in.validation) {
				order.quantity = newQuant;
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

	public Order getOrder(int id) {
		for (Order i: orders) {
			if (id == i.order_id) {
				return i;
			}
		}
		return null;
	}

	public String destroy(Input in, int id) {
		Order o = getOrder(id);

		if (!in.validation) {
			return "Order not found";
		}
		in.validation = true;

		if (o != null) {
			System.out.println("\n*****************\n\n");
			System.out.println("Order ID: " + o.order_id);
			System.out.println("Customer ID: " + o.customer_id);
			System.out.println("Book ID: " + o.book_id);
			System.out.println("Order date: " + o.order_date);
			System.out.println("Quantity: " + o.quantity);
			System.out.println("\n\n*****************\n");
			System.out.println("Are you sure you want to delete" + o.order_id + "?");
			System.out.println("y: delete, n: abort");
		} else {
			return "Order " + id + " not found";
		}

		while (true) {
			char res = in.getChar("> ");
			if (res == 'y') {
				orders.remove(o);
				return "Order Deleted";
			} else if (res == 'n'){
				return "aborted";
			}
		}
	}
}
