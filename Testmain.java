import java.util.Scanner;

public class Testmain {
	// We could use this: public static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Testing alpha = new Testing("Panos");
		int id = alpha.getId();
		Testing beta = new Testing("Manos");

		while (true) {

			Menu.communicationMenu();
			int a = in.nextInt();
			Menu.answer(a, id);
			System.out.println("Do you want to continue? \nYes=0,No=1");
			a = in.nextInt();
			if (a != 0) {
				break;
			}
		}
	}
}
