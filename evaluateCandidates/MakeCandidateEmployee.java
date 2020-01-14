package evaluationCandidate;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

/**
 * This class makes the candidate employee by when the candidate is hired.
 * 
 * @version 2.1 14 Jan 2020
 * @author MICHAEL Dontas
 *
 */

public class MakeCandidateEmployee {

	public static void hire(Candidate candidate, double salary, String dep)
			throws FileNotFoundException, ClassNotFoundException, IOException, ParseException {
		candidate.deleteCandidate(dep);
		WorkersDatabase.addEmployeeToEmployeeList(candidate, salary);
	}
}
