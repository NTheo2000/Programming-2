
/*
 * EvaluationMraktingEmployees
 */

package evaluationEmployees;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import jobHirring.Employee;
import jobHirring.WorkersDatabase;

/**
 * This class comprises three methods by which employees of the marketing
 * department are evaluated, their scores recorded and their scores retrieved.
 * Specifically it contains the following methods:evaluationMethod, getDegrees
 * and setSemester.
 * 
 * @author Dimitris Vougioukos
 *
 */
public class EvaluationMarketingEmployees {
	/**
	 * Contains the ratings and IDs of the employees of the marketing department for
	 * the current semester.
	 */
	public static ArrayList<ArrayList<Double>> averageandidofmarketingemployees = new ArrayList<ArrayList<Double>>();
	/** contains the marketing staff rankings for all their semesters. */
	public static ArrayList<ArrayList<Double>> degreespersemester = new ArrayList<ArrayList<Double>>();
	/**
	 * Contains the employees' IDs of the marketing department and is parallel to
	 * the list degreespersemester.
	 */
	public static ArrayList<Double> idpermarketingemployee = new ArrayList<Double>();

	private static int count1 = 1;// Helpful variable.
	private static int count2 = 1;// Helpful variable.
	/*
	 * Contains the lists averageandidofmarketingemployees, degreespersemester and
	 * idpermarketingemployee when reading them from file MarketingDepartment.
	 */
	public static Object[] arrays;

	/**
	 * Performs the evaluation of marketing employees.
	 * 
	 * @param directorid the ID of the marketing director.
	 * @return a number indicating whether or not the evaluation was done.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public int evaluationMethod(String directorid) throws FileNotFoundException, IOException, ParseException {
		if (count2 == 1) {
			new File("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt");
			ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt",
					averageandidofmarketingemployees, degreespersemester, idpermarketingemployee);
			count2++;
		}
		ArrayList<Employee> employees = WorkersDatabase.getEmployeesbyDirectorsDepartment(directorid);
		System.out.print("Please select and enter an id:");
		Scanner sc = new Scanner(System.in);
		int count3;
		boolean loop = true;
		double id = 0;
		while (loop) {
			try {
				count3 = 0;
				for (Employee emp : employees) {
					System.out.printf("%s    %s/n", emp.getFull_Name(), emp.getId());
				}
				id = sc.nextDouble();
				for (Employee emp : employees) {
					if (emp.getId().equals(id)) {
						count3 = 1;
						break;
					}
				}
				if (count3 == 0) {
					throw new InputMismatchException();
				}
				loop = false;
			} catch (InputMismatchException e) {
				System.err.println("The code you selected does not exist.");
				System.out.print("Please select again an id:");
			}
		}
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt");
		averageandidofmarketingemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idpermarketingemployee = (ArrayList<Double>) arrays[2];
		int a = EvaluationEmployee.mainMethod(averageandidofmarketingemployees, id);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt",
				averageandidofmarketingemployees, degreespersemester, idpermarketingemployee);
		return a;
	}

	/**
	 * Retrieves the scores of a particular marketing worker for some semesters.
	 * 
	 * @param id        the ID of a particular marketing employee.
	 * @param semesters contains the semesters for which we obtain his/her grade.
	 * @return his/her scores in those specific semesters.
	 */
	public double[] getDegrees(int id, int[] semesters) {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt");
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idpermarketingemployee = (ArrayList<Double>) arrays[2];
		return EvaluationEmployee.degrees(id, semesters, idpermarketingemployee, degreespersemester);

	}

	/** Records the final results of the marketing employees of this semester. */
	public void setSemester() {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt");
		averageandidofmarketingemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idpermarketingemployee = (ArrayList<Double>) arrays[2];
		EvaluationEmployee.semester(averageandidofmarketingemployees, degreespersemester, idpermarketingemployee,
				count1);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt",
				averageandidofmarketingemployees, degreespersemester, idpermarketingemployee);
	}
}
