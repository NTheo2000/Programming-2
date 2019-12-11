
import java.util.*;
import java.io.*;

public class test {
	public static void main(String[] args) throws IOException {
		int w = 0;
		idMaker sc = new idMaker();
		Evaluation ev = new Evaluation(sc.getIdEmployee());
		Scanner input = new Scanner(System.in);
		int id;
		char an = 'n';
		do {
			System.out.println("To continue please press Y(Yes) otherwise N(No)!");
			try {
				an = input.next().charAt(0);
				if (an != 'Y' && an != 'N') {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Sorry wrong input!!!");
				input.nextLine();
				continue;
			}
			if (an == 'N') {
				break;
			} else {
				System.out.println("Please insert you id: ");
				try {
					id = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Sorry wrong input!!!");
					input.nextLine();
					continue;
				}
				if (!ev.yparxid(id)) {
					System.out.println("There's no id like this one!");
					continue;
				}
				if (ev.idExist(id)) {
					System.out.println(
							"Sorry you already have evaluated! Do you want to re-evaluate?\nIf so press Y(Yes) otherwise N(No)! ");
					an = 'w';
					while (an != 'Y' && an != 'N') {
						try {
							an = input.next().charAt(0);
							if (an != 'Y' && an != 'N') {
								throw new Exception();
							}
						} catch (Exception e) {
							System.out.println("Sorry wrong input!!!");
							input.nextLine();
						}
					}
				}
				if (an == 'Y' || (ev.idExist(id) == false)) {
					ev.questions(id);
				} else {
					break;
				}
			}
		} while (true);
	}
}




