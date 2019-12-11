import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EvaluationItEmployees {
	private static ArrayList<ArrayList<Double>> averageandidofitemployees = new ArrayList<ArrayList<Double>>();

	private static ArrayList<ArrayList<Double>> degreespersemester = new ArrayList<ArrayList<Double>>();

	private static ArrayList<Double> idperitemployee = new ArrayList<Double>();

	static int count1 = 1;
	private static int count2 = 1;

	public static Object[] arrays;

	public int evaluationMethod() {
		if (count2 == 1) {
			new File("C:\\Users\\dimit\\Desktop\\ItDepartment.txt");
			ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\ItDepartment.txt",
					averageandidofitemployees, degreespersemester, idperitemployee);
			count2++;
		}

		/*
		 * display ids and names of It Employees.
		 * 
		 */

		System.out.print("Please select and enter an id:");
		Scanner sc = new Scanner(System.in);
		double id = sc.nextDouble();
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\ItDepartment.txt");
		averageandidofitemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperitemployee = (ArrayList<Double>) arrays[2];
		int a = EvaluationEmployee.mainMethod(averageandidofitemployees, id);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\ItDepartment.txt", averageandidofitemployees,
				degreespersemester, idperitemployee);
		return a;
	}

	public double[] getDegrees(int id, int[] semesters) {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\ItDepartment.txt");
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperitemployee = (ArrayList<Double>) arrays[2];
		return EvaluationEmployee.degrees(id, semesters, idperitemployee, degreespersemester);

	}

	public void setSemester() {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\ItDepartment.txt");
		averageandidofitemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperitemployee = (ArrayList<Double>) arrays[2];
		EvaluationEmployee.semester(averageandidofitemployees, degreespersemester, idperitemployee, count1);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\ItDepartment.txt", averageandidofitemployees,
				degreespersemester, idperitemployee);
	}

}
