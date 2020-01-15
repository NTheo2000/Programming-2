package initializeApp;

import java.io.File;
import java.io.IOException;

import evaluateCandidates.CreateCandidate;
import evaluateCandidates.WorkersDatabase;
import evaluateEmployees.CreatingFiles;

public class CreateDatabases {
	public static void main(String[] args) {
		WorkersDatabase.createDatabase();
		CreateCandidate.createDatabase();
		CreatingFiles.main(null);
		System.out.println("Executed");
		try {
			new File("id_scores.json").createNewFile();
		} catch (IOException e) {
			System.exit(0);
		}
	}
}
