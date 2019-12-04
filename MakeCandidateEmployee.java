/**
 * This class helps the manager at hiring a candidate or calling him for an interview.
 * 
 * Contains 
 * @author MICHAEL
 *
 */

import java.util.Random;

import org.json.simple.JSONObject;

public class MakeCandidateEmployee {
	public static void callForInterview(Candidate candidate, String position) {
		sendEmail(candidate.getEmail(), "Congratulations! You have been chosen for an interview!");
		System.out.printf("Interview invitation sent to %s\n", candidate.getFull_Name());
	}
	
	public static void hire(Candidate candidate) throws ClassNotFoundException {
		JSONObject employee = WorkersDatabase.createEmployee(candidate.getFull_Name(), 
				candidate.getAge(), candidate.getNationality(), 
				candidate.getCity_of_residence(), setSalary(), 
				createId(candidate.getDepartmentId()), candidate.getSsn());
		WorkersDatabase.addEmployeeToEmployeeList(employee);
		WorkersDatabase.createDatabase();
		Employee emp = new Employee(employee);
		String message = "Congratulations! You have been hired as" + emp.getDepartment() + "!";
		sendEmail(candidate.getEmail(), message);
		System.out.printf("Recruitment message sent to %s\n", candidate.getFull_Name());
	}
	
	private static double setSalary() {
		//set the salary
		return 100000;
	}
	
	private static String createId(int dep) {
		Random r = new Random();
		String id = String.valueOf(dep);
		for(int i = 0; i <= 6; i++) {
			id += String.valueOf(r.nextInt(10));
		}
		return id;
	}
	
	private static void sendEmail(String address, String message) {
		//send email to candidate
	}
}
