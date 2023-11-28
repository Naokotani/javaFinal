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

	public String input(Scanner input) {

		int order_id;
		int customer_id;
		int book_id;
		String order_date;
		int quantity;
		String fail = "Order creation failed";

		try {
		System.out.print("Order ID: ");
		order_id = input.nextInt();
		input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
		System.out.print("Customer ID: ");
		customer_id = input.nextInt();
		input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try{
		System.out.print("Book ID: ");
		book_id = input.nextInt();
		input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try{
		System.out.print("Order Date: ");
		order_date = input.next();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}
		
		try {
		System.out.print("quantity: ");
		quantity = input.nextInt();
		input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		Order order = new Order(order_id,
								customer_id,
								book_id,
								order_date,
								quantity);
		orders.add(order);

		return "Order created successfully.";
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
	
	public String update() {
		return "Not yet implemented";
	}

	public String destroy() {
		return "Not yet implemented";
	}
}
