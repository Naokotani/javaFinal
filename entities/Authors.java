package entities;
import java.util.Scanner;
import java.util.ArrayList;

public class Authors {

	class Author {
		private int author_id;
		private String name;
		private String dob;
		private String nationality;

		public Author(int author_id, String name,
					   String dob, String nationality) {
			this.author_id = author_id;
			this.name = name;
			this.dob = dob;
			this.nationality = nationality;
		}
	}

	ArrayList<Author> authors = new ArrayList<>();

	public String input(Scanner input) {
		int author_id;
		String name;
		String dob;
		String nationality;
		String fail = "Author Creation failed";

		try {
			System.out.print("Author ID: ");
			author_id = input.nextInt();
			input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
			System.out.print("name: ");
			name = input.next();
			input.nextLine();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
			System.out.print("Date of Birth: ");
			dob = input.next();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		try {
			System.out.print("Nationality: ");
			nationality = input.next();
		} catch(Exception e) {
			System.out.println(e);
			return fail;
		}

		Author author = new Author(author_id, name,
								   dob, nationality);
		authors.add(author);

		return "Author " + name + " created successfully.";
	} 

    public void list(){
		for (Author i: authors) {
			System.out.println("Author ID: " + i.author_id);
			System.out.println("Name: " + i.name);
			System.out.println("Date of Birth: " + i.dob);
			System.out.println("Nationality: " + i.nationality);
		}

	}

	public String update() {
		return "Not yet implemented";
	}

	public String destroy() {
		return "Not yet implemented";
	}
}
