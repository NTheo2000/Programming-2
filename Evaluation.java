import java.util.*;
import java.io.*;

public class Evaluation {
	private int[] answers = new int[10];
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer[]> id_scores = new ArrayList<Integer[]>();
	private int c;
	private boolean apan = true;
	private ArrayList<Integer> id_employee = new ArrayList<Integer>();
	private Integer[] arrayId_Scores = new Integer[11];
	private String[] questions ={"1. How is your cooperation with your manager?\n","\n2. How happy you are in our organization?\n",
											"\n3. Do you think that your manager deserves his possition?\n","\n4. How hard or easily you're considering to leave?\n",
											"\n4. How hard or easily you're considering to leave?\n","\n5. Is your manager sympahetic with you?\n","\n6. Do you think that other departments have better managers?\n",
											"\n7. Does your manager behave nice to you and to your colleagues?\n","\n8. Is your manager fair?\n","\n9. Does you manager have the same behavior to your f/m collegues?\n",
											"\n10. Do you think that you manager has the skills to be leader?\n"};

	public Evaluation(ArrayList<Integer> id_employee) {
		this.id_employee = id_employee;
	}

	public void start() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\AGGELOS\\Desktop\\Εργασία προγραμματισμού ΙΙ\\id_scores.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			id_scores = (ArrayList<Integer[]>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (ClassNotFoundException e) {
		}
	}
	public boolean idExist(int ids) throws IOException { // μεδοοσ 1//
		start();
		for (int i = 0; i < id_scores.size(); i++) {
			arrayId_Scores = id_scores.get(i);
			if (arrayId_Scores[0] == ids) {
				c = i;
				if (arrayId_Scores[1] == 0) {
					apan = false;
				}
				break;
			}
		}
		return apan;
	}

	public void questions(int ids) throws IOException { // μεθοδος 2//
		char w;
		int a;
		do {
			w = 'T';
			System.out.println("Right below are the questions of the evaluation. The valid answers are !!Integers!! 1 to 5\n");
			for (int i = 0; i < answers.length; i++) {
				System.out.println(questions[i]);
				a = 0;
				System.out.println("Answer to question no." + (i + 1));
				while (a < 1 || a > 5) {
					try {
						a = sc.nextInt();
						if (a < 1 || a > 5) {
							throw new Exception();
						}
					} catch (Exception e) {
						System.out.println("Sorry wrong input!!!");
						sc.nextLine();
					}
				}
				answers[i] = a;
			}

			System.out.println("Are you sure for your answers?\nY(Yes)\nN(No)\nQ(Quit)");
			while (w != 'Y' && w != 'N' && w != 'Q') {
				try {
					w = sc.next().charAt(0);
					if (w != 'Y' && w != 'N' && w != 'Q') {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("Sorry wrong input!!!");
					sc.nextLine();
				}
			}
			if (w == 'Y' || w == 'Q') {
				break;
			}
		} while (true);
		if (w == 'Y') {
			inputEvaluation(answers, ids);
		}
	}

	public void inputEvaluation(int[] answers, int ids) throws IOException { // method 3 //
		for (int i = 0; i < answers.length; i++) {
			arrayId_Scores[i + 1] = answers[i];
		}
		id_scores.set(c, arrayId_Scores);
		try {
			FileOutputStream fos = new FileOutputStream(
					"C:\\Users\\AGGELOS\\Desktop\\Εργασία προγραμματισμού ΙΙ\\id_scores.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(id_scores);
			oos.close();
		} catch (FileNotFoundException e) {
		}
	}
}


























