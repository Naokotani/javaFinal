package entities;
import java.util.Scanner;

public class Input {
	private Scanner input = new Scanner(System.in);
	Boolean validation = true;

	public String getString() {
		try {
			return input.next();
		} catch(Exception e) {
			System.out.println(e);
			validation = false;
			return "Input Error";
		}
	}

	public char getChar() {
		try {
			return input.next().charAt(0);
		} catch(Exception e) {
			validation = false;
			System.out.println(e);
			return 'a';
		}
	}

	public int getInt() {
		try {
			int i = input.nextInt();
			return i;
		} catch(Exception e) {
			validation = false;
			System.out.println(e);
			return 0;
		}
	}

	public double getDouble () {
		try {
			return input.nextDouble();
		} catch(Exception e) {
			System.out.println(e);
			validation = false;
			return 0.0;
		}
	}

	public void close() {
		input.close();
	}
}
