package entities;
import java.util.Scanner;

public class Input {
	private Scanner input = new Scanner(System.in);
	Boolean validation = true;

	public String getString(String msg) {
		if(validation) {
			System.out.print(msg);
			try {
				return input.nextLine();
			} catch(Exception e) {
				System.out.println(e);
				validation = false;
			}
		}
		return null;
	}

	public char getChar(String msg) {
		if(validation) {
			System.out.print(msg);
			try {
				return input.nextLine().charAt(0);
			} catch(Exception e) {
				validation = false;
				System.out.println(e);
			}
		}
		return 'a';
	}

	public int getInt(String msg) {
		if (validation) {
			System.out.print(msg);
			try {
				String s = input.nextLine();
				return Integer.parseInt(s);
			} catch(Exception e) {
				System.out.println("\n**Please Enter a number**");
				validation = false;
				System.out.println(e);
			}
		}
		return 0;
	}

	public double getDouble (String msg) {
		if(validation) {
			System.out.print(msg);
			try {
				String s = input.nextLine();
				return Double.parseDouble(s);
			} catch(Exception e) {
				System.out.println("\n**Please Enter a number**");
				System.out.println(e);
				validation = false;
			}
		}
		return 0.0;
	}
	
	public void close() {
		input.close();
	}
}
