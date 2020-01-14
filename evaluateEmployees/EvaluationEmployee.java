package evaluateEmployees;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

/**
 * This class comprises three methods by which employees of the marketing
 * department are evaluated, their scores recorded and their scores retrieved.
 * Specifically it contains the following methods:evaluationMethod, getDegrees
 * and setSemester.
 * 
 * @author Dimitris Vougioukos
 *
 */
public class EvaluationEmployee {

	/** Contains the evaluation questions. */
	public static String[] questions = { "Is he/she willing to work harmoniously and effectively with his colleagues?",
			"Does the quantitative performance of his/her work meet the objectives of the unit he/she belongs to?",
			"Does the quality of his/her work respond to the objectives of the unit he/she belongs to?",
			"Does he/she seek to continually improve the professional knowledge required in the field of work?",
			"Is he/she prone to take decisions and initiatives to deal with and manage business affairs?",
			"Can he/she effectively organize his/her assigned work?",
			"Is he/she easily adapted to changing working conditions?",
			"Is he/she faithfully following the commandments of his/her superiors?",
			"Is he/she typical of his/her obligations?", "Is he/she communicative accessible to his/her colleagues?" };
	/**
	 * Contains the ratings and IDs of the employees of the marketing department for
	 * the current semester.
	 */
	public static ArrayList<ArrayList<Double>> averageandidofemployees = new ArrayList<ArrayList<Double>>();
	/** Contains the marketing staff rankings for all their semesters. */
	public static ArrayList<ArrayList<Double>> degreespersemester = new ArrayList<ArrayList<Double>>();
	/**
	 * Contains the employees' IDs of the marketing department and is parallel to
	 * the list degreespersemester.
	 */
	public static ArrayList<Double> idperemployee = new ArrayList<Double>();

	private static int count1 = 1;// Helpful variable.
	/*
	 * Contains the lists averageandidofemployees, degreespersemester and
	 * idperemployee when reading them from file MarketingDepartment.
	 */
	public static Object[] arrays;
	public static Object[] arrays2;
	public static Object[] arrays3;
	public static Object[] arrays4;

	/**
	 * Performs the evaluation of marketing employees.
	 * 
	 * @param directorid the ID of the marketing director.
	 * @return a number indicating whether or not the evaluation was done.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */

	public static void saving(int sum, String id, String department) {
		arrays = ReadingAndWritingInFile.readObject(department.concat("Department.txt"));
		averageandidofemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperemployee = (ArrayList<Double>) arrays[2];
		averageandidofemployees.add(new ArrayList<Double>());
		int row = averageandidofemployees.size();
		averageandidofemployees.get(row - 1).add(0, sum * 0.1);
		averageandidofemployees.get(row - 1).add(1, Double.parseDouble(id));
		ReadingAndWritingInFile.writeObject(department.concat("Department.txt"), averageandidofemployees,
				degreespersemester, idperemployee);
	}

	public static boolean check(String id, String department) {
		try {
			arrays = ReadingAndWritingInFile.readObject(department.concat("Department.txt"));
			averageandidofemployees = (ArrayList<ArrayList<Double>>) arrays[0];
			for (int i = 0; i < averageandidofemployees.size() - 1; i++) {
				if (averageandidofemployees.get(i).get(1) == Double.parseDouble(id)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static void delete(String id, String department) {
		arrays = ReadingAndWritingInFile.readObject(department.concat("Department.txt"));
		averageandidofemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperemployee = (ArrayList<Double>) arrays[2];
		for (int i = 0; i < averageandidofemployees.size(); i++) {
			if (averageandidofemployees.get(i).get(1) == Double.parseDouble(id)) {
				averageandidofemployees.remove(i);
			}
		}
		ReadingAndWritingInFile.writeObject(department.concat("Department.txt"), averageandidofemployees,
				degreespersemester, idperemployee);
	}

	/**
	 * Retrieves the scores of a particular marketing worker for some semesters.
	 * 
	 * @param id        the ID of a particular marketing employee.
	 * @param semesters contains the semesters for which we obtain his/her grade.
	 * @return his/her scores in those specific semesters.
	 */
	public static double[] getDegrees(String id, ArrayList<Integer> semesters, String department) {
		try {
			arrays = ReadingAndWritingInFile.readObject(department.concat("Department.txt"));
			degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
			idperemployee = (ArrayList<Double>) arrays[2];
			int row = -1;
			for (int i = 0; i <= idperemployee.size() - 1; i++) {
				if (idperemployee.get(i) == Double.parseDouble(id)) {
					row = i;
					break;
				}
			}
			double[] degrees = new double[semesters.size()];
			if (row == -1) {
				return degrees;
			}
			for (int i = 0; i <= semesters.size() - 1; i++) {
				if (degreespersemester.get(row).size() >= semesters.get(i))
					degrees[i] = degreespersemester.get(row).get(semesters.get(i) - 1);
				else
					degrees[i] = 0;
			}
			return degrees;
		} catch (Exception e) {
			return null;
		}
	}

	/** Records the final results of the marketing employees of this semester. */
	public static void setSemester() {
		arrays = ReadingAndWritingInFile.readObject("MarketingDepartment.txt");
		averageandidofemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperemployee = (ArrayList<Double>) arrays[2];
		arrays2 = ReadingAndWritingInFile.readObject("HRDepartment.txt");
		ArrayList<ArrayList<Double>> averageandidofemployees2 = (ArrayList<ArrayList<Double>>) arrays2[0];
		ArrayList<ArrayList<Double>> degreespersemester2 = (ArrayList<ArrayList<Double>>) arrays2[1];
		ArrayList<Double> idperemployee2 = (ArrayList<Double>) arrays2[2];
		arrays3 = ReadingAndWritingInFile.readObject("AccountingDepartment.txt");
		ArrayList<ArrayList<Double>> averageandidofemployees3 = (ArrayList<ArrayList<Double>>) arrays3[0];
		ArrayList<ArrayList<Double>> degreespersemester3 = (ArrayList<ArrayList<Double>>) arrays3[1];
		ArrayList<Double> idperemployee3 = (ArrayList<Double>) arrays3[2];
		arrays4 = ReadingAndWritingInFile.readObject("ITDepartment.txt");
		ArrayList<ArrayList<Double>> averageandidofemployees4 = (ArrayList<ArrayList<Double>>) arrays4[0];
		ArrayList<ArrayList<Double>> degreespersemester4 = (ArrayList<ArrayList<Double>>) arrays4[1];
		ArrayList<Double> idperemployee4 = (ArrayList<Double>) arrays4[2];
		if (count1 == 1) {
			++count1;
			for (int i = 0; i <= averageandidofemployees.size() - 1; i++) {
				idperemployee.add(i, averageandidofemployees.get(i).get(1));
				degreespersemester.add(new ArrayList<Double>());
				degreespersemester.get(i).add(0, averageandidofemployees.get(i).get(0));
			}
			for (int i = 0; i <= averageandidofemployees2.size() - 1; i++) {
				idperemployee2.add(i, averageandidofemployees2.get(i).get(1));
				degreespersemester2.add(new ArrayList<Double>());
				degreespersemester2.get(i).add(0, averageandidofemployees2.get(i).get(0));
			}
			for (int i = 0; i <= averageandidofemployees3.size() - 1; i++) {
				idperemployee3.add(i, averageandidofemployees3.get(i).get(1));
				degreespersemester3.add(new ArrayList<Double>());
				degreespersemester3.get(i).add(0, averageandidofemployees3.get(i).get(0));
			}
			for (int i = 0; i <= averageandidofemployees4.size() - 1; i++) {
				idperemployee4.add(i, averageandidofemployees4.get(i).get(1));
				degreespersemester4.add(new ArrayList<Double>());
				degreespersemester4.get(i).add(0, averageandidofemployees4.get(i).get(0));
			}
		} else {
			for (int i = 0; i <= averageandidofemployees.size() - 1; i++) {
				int count2 = 1;
				for (int j = 0; j <= idperemployee.size() - 1; j++) {
					if (averageandidofemployees.get(i).get(1) == idperemployee.get(j)) {
						degreespersemester.get(j).add(degreespersemester.get(j).size(),
								averageandidofemployees.get(i).get(0));
						count2 = 0;
						break;
					}
				}
				if (count2 == 1) {
					idperemployee.add(idperemployee.size(), averageandidofemployees.get(i).get(1));
					degreespersemester.add(new ArrayList<Double>());
					degreespersemester.get(degreespersemester.size() - 1).add(0, averageandidofemployees.get(i).get(0));
				}
			}
			for (int i = 0; i <= averageandidofemployees2.size() - 1; i++) {
				int count2 = 1;
				for (int j = 0; j <= idperemployee2.size() - 1; j++) {
					if (averageandidofemployees2.get(i).get(1) == idperemployee2.get(j)) {
						degreespersemester2.get(j).add(degreespersemester2.get(j).size(),
								averageandidofemployees2.get(i).get(0));
						count2 = 0;
						break;
					}
				}
				if (count2 == 1) {
					idperemployee2.add(idperemployee2.size(), averageandidofemployees2.get(i).get(1));
					degreespersemester2.add(new ArrayList<Double>());
					degreespersemester2.get(degreespersemester2.size() - 1).add(0,
							averageandidofemployees2.get(i).get(0));
				}
			}
			for (int i = 0; i <= averageandidofemployees3.size() - 1; i++) {
				int count2 = 1;
				for (int j = 0; j <= idperemployee3.size() - 1; j++) {
					if (averageandidofemployees3.get(i).get(1) == idperemployee3.get(j)) {
						degreespersemester3.get(j).add(degreespersemester3.get(j).size(),
								averageandidofemployees3.get(i).get(0));
						count2 = 0;
						break;
					}
				}
				if (count2 == 1) {
					idperemployee3.add(idperemployee3.size(), averageandidofemployees3.get(i).get(1));
					degreespersemester3.add(new ArrayList<Double>());
					degreespersemester3.get(degreespersemester3.size() - 1).add(0,
							averageandidofemployees3.get(i).get(0));
				}
			}
			for (int i = 0; i <= averageandidofemployees4.size() - 1; i++) {
				int count2 = 1;
				for (int j = 0; j <= idperemployee4.size() - 1; j++) {
					if (averageandidofemployees4.get(i).get(1) == idperemployee4.get(j)) {
						degreespersemester4.get(j).add(degreespersemester4.get(j).size(),
								averageandidofemployees4.get(i).get(0));
						count2 = 0;
						break;
					}
				}
				if (count2 == 1) {
					idperemployee4.add(idperemployee4.size(), averageandidofemployees4.get(i).get(1));
					degreespersemester4.add(new ArrayList<Double>());
					degreespersemester4.get(degreespersemester4.size() - 1).add(0,
							averageandidofemployees4.get(i).get(0));
				}
			}

		}
		for (int i = 0; i <= averageandidofemployees.size() - 1; i++) {
			averageandidofemployees.remove(i);
		}
		for (int i = 0; i <= averageandidofemployees2.size() - 1; i++) {
			averageandidofemployees2.remove(i);
		}
		for (int i = 0; i <= averageandidofemployees3.size() - 1; i++) {
			averageandidofemployees3.remove(i);
		}
		for (int i = 0; i <= averageandidofemployees4.size() - 1; i++) {
			averageandidofemployees4.remove(i);
		}
		ReadingAndWritingInFile.writeObject("MarketingDepartment.txt", averageandidofemployees, degreespersemester,
				idperemployee);
		ReadingAndWritingInFile.writeObject("HRDepartment.txt", averageandidofemployees2, degreespersemester2,
				idperemployee2);
		ReadingAndWritingInFile.writeObject("AccountingDepartment.txt", averageandidofemployees3, degreespersemester3,
				idperemployee3);
		ReadingAndWritingInFile.writeObject("ITDepartment.txt", averageandidofemployees4, degreespersemester4,
				idperemployee4);

	}
}