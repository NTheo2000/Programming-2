import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EvaluationHrEmployees {
	private static ArrayList<ArrayList<Double>> averageandidofhremployees = new ArrayList<ArrayList<Double>>();

	private static ArrayList<ArrayList<Double>> degreespersemester = new ArrayList<ArrayList<Double>>();

	private static ArrayList<Double> idperhremployee = new ArrayList<Double>();

	static int count1 = 1;
	static int count2 = 1;

	private static Object[] arrays;

	public int evaluationMethod() {
		if (count2 == 1) {
			new File("C:\\Users\\dimit\\Desktop\\HrDepartment.txt");
			ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\HrDepartment.txt",
					averageandidofhremployees, degreespersemester, idperhremployee);
			count2++;
		}

		/*
		 * display ids and names of Hr Employees.
		 * 
		 */

		System.out.print("Please select and enter an id:");
		Scanner sc = new Scanner(System.in);
		double id = sc.nextDouble();
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\HrDepartment.txt");
		averageandidofhremployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperhremployee = (ArrayList<Double>) arrays[2];
		int a = EvaluationEmployee.mainMethod(averageandidofhremployees, id);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\HrDepartment.txt", averageandidofhremployees,
				degreespersemester, idperhremployee);
		return a;
	}

	public double[] getDegrees(int id, int[] semesters) {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\HrDepartment.txt");
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperhremployee = (ArrayList<Double>) arrays[2];
		return EvaluationEmployee.degrees(id, semesters, idperhremployee, degreespersemester);
	}

	public void setSemester() {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\HrDepartment.txt");
		averageandidofhremployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperhremployee = (ArrayList<Double>) arrays[2];
		EvaluationEmployee.semester(averageandidofhremployees, degreespersemester, idperhremployee, count1);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\HrDepartment.txt", averageandidofhremployees,
				degreespersemester, idperhremployee);
	}

}
