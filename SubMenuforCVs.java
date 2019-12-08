import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
public class SubMenuforCVs {
	public static void main(String[] args) {
		for(;;) {
			/* Show initial Menu
			 * Show all 8 positions that are available 
			 * and wait until the manager selects one.
			 * Store the result into the variable dep.
			 * 
			 */
			String dep = null;
			JSONParser parser = new JSONParser();
			JSONArray json_candidates;
			ArrayList<Candidate> candidates = new ArrayList<Candidate>();
			try {
				json_candidates = (JSONArray) parser.parse
						("C:\\Users\\MICHAEL\\eclipse_repository\\JobBranches\\Candidates.json");
				candidates = Rankings.sortByDepartment(json_candidates, dep);
			} catch (Exception e) {
				System.out.println("An error has occured. You will be transfered to the initial Menu.");
				continue;
			}
			/*
			 * Print the sorted list and bring option
			 * for detailed CV next to each candidate.
			 * Then take as input from the user the chosen 
			 * candidate and the option to call him for an 
			 * interview or hire him immediately.
			 */
			int pos = 0;
			Candidate chosen = candidates.get(pos);
			String option = null;
			String message = null;
			try {
				if (option.toLowerCase().equals("interview")) {
					message = MakeCandidateEmployee.callForInterview(chosen, dep);
				} else {
					message = MakeCandidateEmployee.hire(chosen);
				}
			} catch (EmailNotSentException e) {
				HandleExceptions.handleEmailNotSentException(chosen.getEmail(), message);
			} catch (Exception e) {
				System.out.println("An error has occured. You will be transfered to the initial Menu.");
				continue;
			}
		}
	}

}
