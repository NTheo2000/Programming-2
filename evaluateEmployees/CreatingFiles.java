
/*
 * CreatingFiles
 */

package evaluationEmployees;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class creates all the necessary records for employee evaluation.
 * 
 * @author Dimitris Vougioukos
 *
 */

public class CreatingFiles {

	public static void main(String args[]) {
		/**
		 * Contains the ratings and IDs of the employees of the marketing department for
		 * the current semester.
		 */
		ArrayList<ArrayList<Double>> averageandidofmarketingemployees = new ArrayList<ArrayList<Double>>();
		/** Contains the marketing staff rankings for all their semesters. */
		ArrayList<ArrayList<Double>> degreespersemester1 = new ArrayList<ArrayList<Double>>();

		/**
		 * Contains the employees' IDs of the marketing department and is parallel to
		 * the list degreespersemester1.
		 */
		ArrayList<Double> idpermarketingemployee = new ArrayList<Double>();
		/**
		 * Contains the ratings and IDs of the employees of the HR department for the
		 * current semester.
		 */
		ArrayList<ArrayList<Double>> averageandidofhremployees = new ArrayList<ArrayList<Double>>();
		/** Contains the HR staff rankings for all their semesters. */
		ArrayList<ArrayList<Double>> degreespersemester2 = new ArrayList<ArrayList<Double>>();
		/**
		 * Contains the employees' IDs of the HR department and is parallel to the list
		 * degreespersemester2.
		 */
		ArrayList<Double> idperhremployee = new ArrayList<Double>();
		/**
		 * Contains the ratings and IDs of the employees of the IT department for the
		 * current semester.
		 */
		ArrayList<ArrayList<Double>> averageandidofitemployees = new ArrayList<ArrayList<Double>>();
		/** Contains the IT staff rankings for all their semesters. */
		ArrayList<ArrayList<Double>> degreespersemester3 = new ArrayList<ArrayList<Double>>();
		/**
		 * Contains the employees' IDs of the IT department and is parallel to the list
		 * degreespersemester3.
		 */
		ArrayList<Double> idperitemployee = new ArrayList<Double>();
		/**
		 * Contains the ratings and IDs of the employees of the accounting department
		 * for the current semester.
		 */
		ArrayList<ArrayList<Double>> averageandidofaccountingemployees = new ArrayList<ArrayList<Double>>();
		/** Contains the accounting staff rankings for all their semesters. */
		ArrayList<ArrayList<Double>> degreespersemester4 = new ArrayList<ArrayList<Double>>();
		/**
		 * Contains the employees' IDs of the accounting department and is parallel to
		 * the list degreespersemester4.
		 */
		ArrayList<Double> idperaccountingemployee = new ArrayList<Double>();
		int times = 1;
		new File("Times.txt");
		try {
			FileOutputStream wr = new FileOutputStream("Times.txt");
			wr.write(times);
			wr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new File("MarketingDepartment.txt");
		ReadingAndWritingInFile.writeObject("MarketingDepartment.txt", averageandidofmarketingemployees,
				degreespersemester1, idpermarketingemployee);
		new File("AccountingDepartment.txt");
		ReadingAndWritingInFile.writeObject("AccountingDepartment.txt", averageandidofaccountingemployees,
				degreespersemester2, idperaccountingemployee);
		new File("HRDepartment.txt");
		ReadingAndWritingInFile.writeObject("HRDepartment.txt", averageandidofhremployees, degreespersemester3,
				idperhremployee);
		new File("ITDepartment.txt");
		ReadingAndWritingInFile.writeObject("ITDepartment.txt", averageandidofitemployees, degreespersemester4,
				idperitemployee);
		Long days = (long) 1;
		LocalDate currentdate = LocalDate.now();
		new File("Days.txt");
		ReadingAndWritingInFile.write("Days.txt", days, currentdate);
	}
}
