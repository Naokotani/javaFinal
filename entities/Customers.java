package entities;
import java.util.Scanner;
import java.util.ArrayList;

public class Customers {

	class Customer {
		private int customer_id;
		private String first_name;
		private String last_name;
		private String email;

		public Customer(int customer_id,
						String first_name,
						String last_name,
						String email) {

			this.customer_id = customer_id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
		}
	}

	ArrayList<Customer> customers = new ArrayList<>();

	public String input(Scanner input) {
		int customer_id;
		String first_name;
		String last_name;
		String email;
		String fail = "Customer creation failed.";

		try {
		System.out.print("Customer ID: ");
		customer_id = input.nextInt();
		input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
		System.out.print("First Name: ");
		first_name = input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
		System.out.print("Last Name: ");
		last_name = input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
		System.out.print("Email: ");
		email = input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		Customer customer = new Customer(customer_id,
										 first_name,
										 last_name,
										 email);
		customers.add(customer);

		return first_name + " " + last_name + " created successfully.";
	}

	public void list() {
		for (Customer i: customers) {
			System.out.println("Customer ID: " + i.customer_id);
			System.out.println("First Name: " + i.first_name);
			System.out.println("Last Name: " + i.last_name);
			System.out.println("Email: " + i.email);
		}
	}

	public String update() {
		return "Not yet implemented";
	}

	public String destroy() {
		return "Not yet implemented";
	}
}
