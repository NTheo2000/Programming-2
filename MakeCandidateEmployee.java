package EvaluateCandidates;
/**
 * This class helps the manager at hiring a candidate or calling him for an interview.
 * 
 * Contains 
 * @author MICHAEL
 *
 */


public class MakeCandidateEmployee {
	public static String callForInterview(Candidate candidate, String position) throws EmailNotSentException {
		String message = "Congratulations! You have been chosen for an interview!";
		//sendEmail(candidate.getEmail(), "Congratulations! You have been chosen for an interview!");
		return message;
	}
	
	public static boolean hire(Candidate candidate, double salary, String dep) {
		boolean update = false;
		try {
			candidate.deleteCandidate(dep);
			WorkersDatabase.addEmployeeToEmployeeList(candidate, salary);
			String message = "Congratulations! You have been hired as" + dep + "!";
			sendEmail(candidate.getEmail(), message);
			update = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}
	
	protected static void sendEmail(String address, String message) throws EmailNotSentException{
		//send email to candidate
	}
}
