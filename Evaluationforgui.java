import java.util.*;
import java.io.*;

public class Evaluationfrogui {
	public void saveAnswers() throws IOException {
		String[] questions ={"1. How is your cooperation with your manager?\n","\n2. How happy you are in our organization?\n",
													"\n3. Do you think that your manager deserves his possition?\n","\n4. How hard or easily you're considering to leave?\n",
													"\n4. How hard or easily you're considering to leave?\n","\n5. Is your manager sympahetic with you?\n","\n6. Do you think that other departments have better managers?\n",
													"\n7. Does your manager behave nice to you and to your colleagues?\n","\n8. Is your manager fair?\n","\n9. Does you manager have the same behavior to your f/m collegues?\n",
													"\n10. Do you think that you manager has the skills to be leader?\n"};
		ArrayList<Integer[]> id_scores = new ArrayList<Integer[]>();
		Employee emp = new Employee();
		int c;
		Integer id;
		id=Integer.parseInt(emp.getId());
		Integer[] arrayId_Scores = new Integer[11];
		Integer[] answers = new Integer [10];
		answers=methodForgui(questions);
		try {
			FileInputStream fis = new FileInputStream("id_scores.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			id_scores = (ArrayList<Integer[]>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (ClassNotFoundException e) {
		}
		for (int i = 0; i < id_scores.size(); i++) {
			if (arrayId_Scores[0] == id ) {
				c = i;
				arrayid_Scores=id_score.get(i);
				break;
			}
		}
		for (int i = 0; i < answers.length; i++) {
			arrayId_Scores[i + 1] = answers[i];
		}
		id_scores.set(c, arrayId_Scores);
		try {
			FileOutputStream fos = new FileOutputStream("id_scores.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(id_scores);
			oos.close();
		} catch (FileNotFoundException e) {
		}
	}
	public Integer[] methodForgui ( String [] questions ){
		Integer [] answ = new Integer [10];
		return answ;
	}
}



























