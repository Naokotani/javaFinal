package entities;
import java.util.Scanner;
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
		System.out.print("Order ID:");
		int order_id = in.getInt();
		System.out.print("Customer ID: ");
		int customer_id = in.getInt();
		System.out.print("Book ID: ");
		int book_id = in.getInt();
		System.out.print("Order date: ");
		String order_date = in.getString();
		System.out.print("Quantity: ");
		int quantity = in.getInt();
		String fail = "Order creation failed";


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
		for (Order i: orders) {
			System.out.println("Order ID: " + i.order_id);
			System.out.println("Customer ID: " + i.customer_id);
			System.out.println("Book ID: " + i.book_id);
			System.out.println("Date Ordered: " + i.order_date);
			System.out.println("Quantity: " + i.quantity);
		}
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
	
	public String update() {
		return "Not yet implemented";
	}

	public String destroy() {
		return "Not yet implemented";
	}
}
