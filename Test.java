package evaluationEmployees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import jobHirring.WorkersDatabase;

public class Test {
	public static void evaluationDirector(int id) throws IOException {
		int w = 0;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		WorkersDatabase sc = new WorkersDatabase();
		ArrayList<String> proid = new ArrayList<String>();
		proid = sc.getId();
		for (int i = 0; i < proid.size(); i++) {
			ids.add(Integer.parseInt(proid.get(i)));
		}
		Evaluation ev = new Evaluation(ids);
		Scanner input = new Scanner(System.in);
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
