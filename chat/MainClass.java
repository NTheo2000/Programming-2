import java.util.Scanner;

public class MainClass {
	protected static String holdid;
	public static void messages(String id) {// Caution:Files
		holdid = id;
		Scanner in = new Scanner(System.in);
		while (true) {
			Menu.communicationMenu();
			double a;
			int counter = 0;
			do {
				if (counter > 0) {
					System.out.println("Your input does not match with any option. Please try again");
				}
				a = in.nextDouble();// Caution:Exception
				counter++;
			} while (a != 0 && a != 1 && a != 2 && a != 3 && a != 4);
			if (a == 0) {
				Menu.answer(0, id);
				break;
			} else {
				Menu.answer(a, id);
			}
		}
	}

}