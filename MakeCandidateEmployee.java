/**
 * This class helps the manager at hiring a candidate or calling him for an interview.
 * 
 * Contains 
 * @author MICHAEL
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.json.simple.parser.ParseException;

public class MakeCandidateEmployee {
	public static String callForInterview(Candidate candidate, String position) throws EmailNotSentException {
		String message = "Congratulations! You have been chosen for an interview!";
		sendEmail(candidate.getEmail(), "Congratulations! You have been chosen for an interview!");
		return message;
	}
	
	public static String hire(Candidate candidate) throws ClassNotFoundException, 
	FileNotFoundException, IOException, ParseException, EmailNotSentException {
		double salary = setSalary();
		String id = generateId(candidate.getDepartmentId());
		WorkersDatabase.addEmployeeToEmployeeList(candidate, salary, id);
		String message = "Congratulations! You have been hired as" + Employee.findDepartment(id) + "!";
		sendEmail(candidate.getEmail(), message);
		return message;
	}
	
	private static double setSalary() {
		//set the salary
		return 100000;
	}
	
	private static String generateId(int dep) {
		Random r = new Random();
		String id = String.valueOf(dep);
		for(int i = 0; i <= 6; i++) {
			id += String.valueOf(r.nextInt(10));
		}
		return id;
	}
	
	protected static void sendEmail(String address, String message) throws EmailNotSentException{
		//send email to candidate
	}
}
