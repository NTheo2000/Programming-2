import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EvaluationMarketingEmployees {
	public static ArrayList<ArrayList<Double>> averageandidofmarketingemployees = new ArrayList<ArrayList<Double>>();

	public static ArrayList<ArrayList<Double>> degreespersemester = new ArrayList<ArrayList<Double>>();

	public static ArrayList<Double> idpermarketingemployee = new ArrayList<Double>();

	private static int count1 = 1;
	private static int count2 = 1;

	public static Object[] arrays;

	public int evaluationMethod() {
		if (count2 == 1) {
			new File("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt");
			ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt",
					averageandidofmarketingemployees, degreespersemester, idpermarketingemployee);
			count2++;
		}

		/*
		 * display ids and names of Marketing Employees.
		 * 
		 */

		System.out.print("Please select and enter an id:");
		Scanner sc = new Scanner(System.in);
		double id = sc.nextDouble();
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt");
		averageandidofmarketingemployees = (ArrayList<ArrayList<Double>>) arrays[0];
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idpermarketingemployee = (ArrayList<Double>) arrays[2];
		int a = EvaluationEmployee.mainMethod(averageandidofmarketingemployees, id);
		ReadingAndWritingInFile.writeObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt",
				averageandidofmarketingemployees, degreespersemester, idpermarketingemployee);
		return a;
	}

	public double[] getDegrees(int id, int[] semesters) {
		arrays = ReadingAndWritingInFile.readObject("C:\\Users\\dimit\\Desktop\\MarketingDepartment.txt");
		degreespersemester = (ArrayList<ArrayList<Double>>) arrays[1];
		idpermarketingemployee = (ArrayList<Double>) arrays[2];
		return EvaluationEmployee.degrees(id, semesters, idpermarketingemployee, degreespersemester);

	}

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