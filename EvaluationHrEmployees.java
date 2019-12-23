
/*
 * EvaluationHrEmployees.
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
 * This class comprises three methods by which employees of the HR department
 * are evaluated, their scores recorded and their scores retrieved. Specifically
 * it contains the following methods:evaluationMethod, getDegrees and
 * setSemester.
 * 
 * @author Dimitris Vougioukos
 *
 */

public class EvaluationHrEmployees {
	/**
	 * Contains the ratings and IDs of the employees of the HR department for the
	 * current semester.
	 */
	private static ArrayList<ArrayList<Double>> averageandidofhremployees = new ArrayList<ArrayList<Double>>();
	/** Contains the HR staff rankings for all their semesters. */
	private static ArrayList<ArrayList<Double>> degreespersemester = new ArrayList<ArrayList<Double>>();
	/**
	 * Contains the employees' IDs of the HR department and is parallel to the list
	 * degreespersemester.
	 */
	private static ArrayList<Double> idperhremployee = new ArrayList<Double>();

	static int count1 = 1;// Helpful variable.
	static int count2 = 1;// Helpful variable.
	/**
	 * Contains the lists averageandidofmarketingemployees, degreespersemester and
	 * idpermarketingemployee when reading them from file HRDepartment.
	 */
	private static Object[] arrays;

	/**
	 * Performs the evaluation of HR employees.
	 * 
	 * @param directorid the ID of the HR director.
	 * @return a number indicating whether or not the evaluation was done.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public int evaluationMethod(String directorid) throws FileNotFoundException, IOException, ParseException {
		if (count2 == 1) {
			new File("C:\\Users\\dimit\\Desktop\\HrDepartment.txt");
			ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\HRDepartment.txt",
					averageandidofhremployees, degreespersemester, idperhremployee);
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
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\HRDepartment.txt");
		averageandidofhremployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperhremployee = (ArrayList<Double>) arrays[2];
		int a = EvaluationEmployee.mainMethod(averageandidofhremployees, id);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\HRDepartment.txt", averageandidofhremployees,
				degreespersemester, idperhremployee);
		return a;
	}

	/**
	 * Retrieves the scores of a particular HR worker for some semesters.
	 * 
	 * @param id        the ID of a particular HR employee.
	 * @param semesters contains the semesters for which we obtain his/her grade.
	 * @return his/her scores in those specific semesters.
	 */
	public double[] getDegrees(int id, int[] semesters) {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\HRDepartment.txt");
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperhremployee = (ArrayList<Double>) arrays[2];
		return EvaluationEmployee.degrees(id, semesters, idperhremployee, degreespersemester);
	}

	/** Records the final results of the HR employees of this semester. */
	public void setSemester() {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\HRDepartment.txt");
		averageandidofhremployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperhremployee = (ArrayList<Double>) arrays[2];
		EvaluationEmployee.semester(averageandidofhremployees, degreespersemester, idperhremployee, count1);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\HRDepartment.txt", averageandidofhremployees,
				degreespersemester, idperhremployee);
	}

}
