
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EvaluationEmployee {

	static String[] questions = { "Is he/she willing to work harmoniously and effectively with his colleagues?",
			"Does the quantitative performance of his/her work meet the objectives of the unit he belongs to?",
			"Does the quality of his/her work respond to the objectives of the unit he belongs to?",
			"Does he/she seek to continually improve the professional knowledge required in the field of work?",
			"Is he/she prone to take decisions and initiatives to deal with and manage business affairs?",
			"Can he/she effectively organize his/her assigned work?",
			"Is he/she easily adapted to changing working conditions?",
			"Is he/she faithfully following the commandments of his/her superiors?",
			"Is he/she typical of his/her obligations?", "Is he/she communicative accessible to his/her colleagues?" };
	static Scanner sc1 = new Scanner(System.in);

	public static double questionsMenu() {
		System.out.printf("%s%n%n", "Evaluation Questions");
		System.out.printf("%s%n%s%n%s", "Question 1:" + questions[0],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree1 = null;
		boolean loop1 = true;
		while (loop1) {
			try {
				degree1 = sc1.nextLine();
				if (!(degree1.equals("1")) && !(degree1.equals("2")) && !(degree1.equals("3")) && !(degree1.equals("4"))
						&& !(degree1.equals("5")))
					throw new InputMismatchException();
				loop1 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%n%s%n%s%n%s", "Question 2:" + questions[1],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree2 = null;
		boolean loop2 = true;
		while (loop2) {
			try {
				degree2 = sc1.nextLine();
				if (!(degree2.equals("1")) && !(degree2.equals("2")) && !(degree2.equals("3")) && !(degree2.equals("4"))
						&& !(degree2.equals("5")))
					throw new InputMismatchException();
				loop2 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%n%s%n%s%n%s", "Question 3:" + questions[2],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree3 = null;
		boolean loop3 = true;
		while (loop3) {
			try {
				degree3 = sc1.nextLine();
				if (!(degree3.equals("1")) && !(degree3.equals("2")) && !(degree3.equals("3")) && !(degree3.equals("4"))
						&& !(degree3.equals("5")))
					throw new InputMismatchException();
				loop3 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%n%s%n%s%n%s", "Question 4:" + questions[3],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree4 = null;
		boolean loop4 = true;
		while (loop4) {
			try {
				degree4 = sc1.nextLine();
				if (!(degree4.equals("1")) && !(degree4.equals("2")) && !(degree4.equals("3")) && !(degree4.equals("4"))
						&& !(degree4.equals("5")))
					throw new InputMismatchException();
				loop4 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%n%s%n%s%n%s", "Question 5:" + questions[4],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree5 = null;
		boolean loop5 = true;
		while (loop5) {
			try {
				degree5 = sc1.nextLine();
				if (!(degree5.equals("1")) && !(degree5.equals("2")) && !(degree5.equals("3")) && !(degree5.equals("4"))
						&& !(degree5.equals("5")))
					throw new InputMismatchException();
				loop5 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%s%n%s%n%s", "Question 6:" + questions[5],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree6 = null;
		boolean loop6 = true;
		while (loop6) {
			try {
				degree6 = sc1.nextLine();
				if (!(degree6.equals("1")) && !(degree6.equals("2")) && !(degree6.equals("3")) && !(degree6.equals("4"))
						&& !(degree6.equals("5")))
					throw new InputMismatchException();
				loop6 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%s%n%s%n%s", "Question 7:" + questions[6],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree7 = null;
		boolean loop7 = true;
		while (loop7) {
			try {
				degree7 = sc1.nextLine();
				if (!(degree7.equals("1")) && !(degree7.equals("2")) && !(degree7.equals("3")) && !(degree7.equals("4"))
						&& !(degree7.equals("5")))
					throw new InputMismatchException();
				loop7 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%s%n%s%n%s", "Question 8:" + questions[7],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree8 = null;
		boolean loop8 = true;
		while (loop8) {
			try {
				degree8 = sc1.nextLine();
				if (!(degree8.equals("1")) && !(degree8.equals("2")) && !(degree8.equals("3")) && !(degree8.equals("4"))
						&& !(degree8.equals("5")))
					throw new InputMismatchException();
				loop8 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%s%n%s%n%s", "Question 9:" + questions[8],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree9 = null;
		boolean loop9 = true;
		while (loop9) {
			try {
				degree9 = sc1.nextLine();
				if (!(degree9.equals("1")) && !(degree9.equals("2")) && !(degree9.equals("3")) && !(degree9.equals("4"))
						&& !(degree9.equals("5")))
					throw new InputMismatchException();
				loop9 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}
		System.out.printf("%s%n%s%n%s", "Question 10:" + questions[9],
				"1 (Absolutely Disagree)   2 (Disagree)   3 (Neither Disagree Nor Agree)   4 (Agree)   5 (Absolutely Agree)",
				"Answer:");
		String degree10 = null;
		boolean loop10 = true;
		while (loop10) {
			try {
				degree10 = sc1.nextLine();
				if (!(degree10.equals("1")) && !(degree10.equals("2")) && !(degree10.equals("3"))
						&& !(degree10.equals("4")) && !(degree10.equals("5")))
					throw new InputMismatchException();
				loop10 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%n%s", "Wrong typing. Your answer should be a number from 1 to 5.");
				System.out.printf("%n%s", "Please answer again:");
			}
		}

		return (Integer.parseInt(degree1) + Integer.parseInt(degree2) + Integer.parseInt(degree3)
				+ Integer.parseInt(degree4) + Integer.parseInt(degree5) + Integer.parseInt(degree6)
				+ Integer.parseInt(degree7) + Integer.parseInt(degree8) + Integer.parseInt(degree9)
				+ Integer.parseInt(degree10)) * 0.2;

	}

	public static int mainMethod(ArrayList<ArrayList<Double>> array1, double id) {
		array1.add(new ArrayList<Double>());
		for (int i = 0; i < array1.size() - 1; i++) {
			if (array1.get(i).get(1) == id) {
				System.out.printf("%s%n%s%n", "You have already evaluated this employee.",
						"If you want to change your rating, enter number 1 else enter number 0.");
				Scanner sc2 = new Scanner(System.in);
				String ans = null;
				boolean loop1 = true;
				while (loop1) {
					try {
						ans = sc2.nextLine();
						if (!(ans.equals("1")) && !(ans.equals("0")))
							throw new InputMismatchException();
						loop1 = false;
					} catch (InputMismatchException e) {
						System.err.printf("%s", "Wrong typing. Enter either the number 1 or the number 0");
						System.out.printf("%n%s", "Please re-type:");
					}
				}
				if (ans.equals("1")) {
					array1.remove(i);
					break;
				} else
					array1.remove(array1.size() - 1);
				sc2.close();
				return 0;
			}
		}
		double average = questionsMenu();
		System.out.printf("%n%n%s     %s%n", "1.Submission", "2.Cancellation");
		System.out.print("Please select an option:");
		String ans2 = null;

		boolean loop2 = true;
		while (loop2) {
			try {
				Scanner sc3 = new Scanner(System.in);
				ans2 = sc3.nextLine();
				if (!(ans2.equals("1")) && !(ans2.equals("2")))
					throw new InputMismatchException();
				loop2 = false;
			} catch (InputMismatchException e) {
				System.err.printf("%s", "Wrong choice. Your choice should be either number 1 or number 2.");
				System.out.printf("%n%s", "Please re-type:");
			}
		}
		if (ans2.equals("1")) {
			int row = array1.size();
			array1.get(row - 1).add(0, average);
			array1.get(row - 1).add(1, id);
			return 1;
		} else
			array1.remove(array1.size() - 1);
		return 0;
	}

	public static double[] degrees(int id, int[] semesters, ArrayList<Double> array1,
			ArrayList<ArrayList<Double>> array2) {
		int row = -1;
		for (int i = 0; i <= array1.size() - 1; i++) {
			if (array1.get(i) == id) {
				row = i;
				break;
			}
		}
		double[] degrees = new double[semesters.length];
		if (row == -1) {
			System.err.println("This id was not found.");
			return degrees;
		}
		for (int i = 0; i <= semesters.length - 1; i++) {
			if (array2.get(row).size() >= semesters[i])
				degrees[i] = array2.get(row).get(semesters[i] - 1);
			else
				degrees[i] = 0;
		}
		return degrees;

	}

	public static void semester(ArrayList<ArrayList<Double>> array1, ArrayList<ArrayList<Double>> array2,
			ArrayList<Double> array3, int count1) {
		if (count1 == 1) {
			++count1;
			for (int i = 0; i <= array1.size() - 1; i++) {
				array3.add(i, array1.get(i).get(1));
				array2.add(new ArrayList<Double>());
				array2.get(i).add(0, array1.get(i).get(0));
			}
		} else {
			for (int i = 0; i <= array1.size() - 1; i++) {
				int count2 = 1;
				for (int j = 0; j <= array3.size() - 1; j++) {
					if (array1.get(i).get(1) == array3.get(j)) {
						array2.get(j).add(array2.get(j).size(), array1.get(i).get(0));
						count2 = 0;
						break;
					}
				}
				if (count2 == 1) {
					array3.add(array3.size(), array1.get(i).get(1));
					array2.add(new ArrayList<Double>());
					array2.get(array2.size() - 1).add(0, array1.get(i).get(0));
				}
			}
		}
		for (int i = 0; i <= array1.size() - 1; i++) {
			array1.remove(i);
		}
	}

}
