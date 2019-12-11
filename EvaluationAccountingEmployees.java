import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EvaluationAccountingEmployees {
	private static ArrayList<ArrayList<Double>> averageandidofaccountingemployees = new ArrayList<ArrayList<Double>>();

	private static ArrayList<ArrayList<Double>> degreespersemester = new ArrayList<ArrayList<Double>>();

	private static ArrayList<Double> idperaccountingemployee = new ArrayList<Double>();

	static int count1 = 1;
	static int count2 = 1;

	public static Object[] arrays;

	public int evaluationMethod() {
		if (count2 == 1) {
			new File("C:\\Users\\dimit\\Desktop\\AccountingDepartment.txt");
			ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\AccountingDepartment.txt",
					averageandidofaccountingemployees, degreespersemester, idperaccountingemployee);
			count2++;
		}

		/*
		 * display ids and names of Accounting Employees.
		 * 
		 */

		System.out.print("Please select and enter an id:");
		Scanner sc = new Scanner(System.in);
		double id = sc.nextDouble();
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\AccountingDepartment.txt");
		averageandidofaccountingemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperaccountingemployee = (ArrayList<Double>) arrays[2];
		int a = EvaluationEmployee.mainMethod(averageandidofaccountingemployees, id);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\AccountingDepartment.txt",
				averageandidofaccountingemployees, degreespersemester, idperaccountingemployee);
		return a;
	}

	public double[] getDegrees(int id, int[] semesters) {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\AccountingDepartment.txt");
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperaccountingemployee = (ArrayList<Double>) arrays[2];
		return EvaluationEmployee.degrees(id, semesters, idperaccountingemployee, degreespersemester);
	}

	public void setSemester() {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\AccountingDepartment.txt");
		averageandidofaccountingemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idperaccountingemployee = (ArrayList<Double>) arrays[2];
		EvaluationEmployee.semester(averageandidofaccountingemployees, degreespersemester, idperaccountingemployee,
				count1);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\AccountingDepartment.txt",
				averageandidofaccountingemployees, degreespersemester, idperaccountingemployee);
	}
}
