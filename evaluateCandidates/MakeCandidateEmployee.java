package evaluateCandidates;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

/**
 * This class helps the manager at hiring a candidate or calling him for an interview.
 * 
 * Contains 
 * @author MICHAEL
 *
 */


public class MakeCandidateEmployee {
	
	public static void hire(Candidate candidate, double salary, String dep) throws FileNotFoundException, ClassNotFoundException, IOException, ParseException {
		candidate.deleteCandidate(dep);
		WorkersDatabase.addEmployeeToEmployeeList(candidate, salary);
	}
}
