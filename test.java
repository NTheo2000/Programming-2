
import java.util.*;
import java.io.*;

public class test {
	public static void main(String[] args) throws IOException {
		int w = 0;
		WorkersDatabase sc = new WorkersDatabase();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids=sc.getAllEmployeeObjects();
		Evaluation ev = new Evaluation(ids));
		Scanner input = new Scanner(System.in);
		int id=8180060;
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




