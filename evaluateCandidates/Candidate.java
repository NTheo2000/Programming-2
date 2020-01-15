package evaluateCandidates;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Handles the candidates data
 * 
 * @version 3.2 14 Jan 2020
 * @author Michalis Dontas
 */
public abstract class Candidate implements Comparator<Candidate> {

	private String full_name;
	private long age;
	private String nationality;
	private String city_of_residence;
	private String ssn;
	private String email;

	/**
	 * Simple constructor
	 */
	public Candidate() {

	}

	/**
	 * Constructor with @param JSONObject candidate
	 */
	public Candidate(JSONObject candidate) {
		this.full_name = (String) searchPersonalDataInFile(candidate, "full_name");
		this.age = (Long) searchPersonalDataInFile(candidate, "age");
		this.nationality = (String) searchPersonalDataInFile(candidate, "nationality");
		this.city_of_residence = (String) searchPersonalDataInFile(candidate, "city_of_residence");
		this.ssn = (String) searchPersonalDataInFile(candidate, "ssn");
	}

	public abstract double getSTARTING_SALARY();

	public abstract long getLevel_of_computer_handling();

	public abstract long getFormer_experience();

	public abstract boolean isRecommendation_letter();

	public abstract String getPhD();

	public abstract String getMaster();

	public abstract String getLanguages();

	public String getFull_Name() {
		return full_name;
	}

	public long getAge() {
		return age;
	}

	public String getNationality() {
		return nationality;
	}

	public String getCity_of_residence() {
		return city_of_residence;
	}

	public String getSsn() {
		return ssn;
	}

	public String getEmail() {
		return email;
	}

	public long getNumber_of_programming_languages() {
		return 0;
	}

	protected Object searchPersonalDataInFile(JSONObject candidate, String keywords) {
		return candidate.get(keywords);
	}

	/**
	 * searchLevel_of_languages and counts the points for the evaluation system.
	 * 
	 * @param candidate
	 * @return level of the language.
	 */
	@SuppressWarnings({ "unchecked" })
	protected long[] searchLevel_of_languages(JSONObject candidate) {
		Map<String, Long> languages = (HashMap<String, Long>) candidate.get("languages");
		long[] level = new long[languages.size()];
		int i = 0;
		Iterator<Entry<String, Long>> itr = languages.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Long> pair = itr.next();
			level[i++] = (long) pair.getValue();
		}
		return level;
	}

	protected long searchLevel_of_computer_handling(JSONObject candidate) {
		return (Long) candidate.get("level_of_computer_handling");
	}

	protected long searchNumber_of_programming_languages(JSONObject candidate) {
		return (Long) candidate.get("programming_languages");
	}

	protected long searchFormer_experience(JSONObject candidate) {
		return (Long) candidate.get("former_experience");
	}

	protected boolean searchRecommendation_letter(JSONObject candidate) {
		if (candidate.containsKey("recommendation_letter")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * method gives extra points for each batchelor.
	 * 
	 * @param candidate
	 * @param field
	 * @return the extra points.
	 */
	protected int giveBoostByBachelor(JSONObject candidate, String field) {
		if (candidate.get("bachelor_field") == null || !candidate.get("bachelor_field").equals(field)) {
			return 50;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @return the id for each department
	 * @throws ClassNotFoundException
	 */
	public int getDepartmentId() throws ClassNotFoundException {
		int id = 0;
		if (this.getClass().equals(Class.forName("EvaluateCandidates." + "Marketing_Employee_Candidate"))) {
			id = 1;
		} else if (this.getClass().equals(Class.forName("EvaluateCandidates." + "Accounting_Employee_Candidate"))) {
			id = 2;
		} else if (this.getClass().equals(Class.forName("EvaluateCandidates." + "IT_Employee_Candidate"))) {
			id = 3;
		} else if (this.getClass().equals(Class.forName("EvaluateCandidates." + "HR_Employee_Candidate"))) {
			id = 4;
		} else if (this.getClass().equals(Class.forName("EvaluateCandidates." + "Marketing_Director_Candidate"))) {
			id = 5;
		} else if (this.getClass().equals(Class.forName("EvaluateCandidates." + "Accounting_Director_Candidate"))) {
			id = 6;
		} else if (this.getClass().equals(Class.forName("EvaluateCandidates." + "IT_Director_Candidate"))) {
			id = 7;
		} else if (this.getClass().equals(Class.forName("EvaluateCandidates." + "HR_Director_Candidate"))) {
			id = 8;
		} else {
			assert id <= 8 && id >= 1 : "Unidentified departmnet";
		}
		return id;
	}

	/**
	 * finds the degree and field and adds extra points depending on the score.
	 * 
	 * @param candidate
	 * @param degree
	 * @param field
	 * @param this_field
	 * @return the grades of the degree
	 */
	@SuppressWarnings("unchecked")
	protected double[] findDegreeAndField(JSONObject candidate, String degree, String field, boolean this_field) {
		Map<String, Double> diplomas = (HashMap<String, Double>) candidate.get(degree);
		int i = 0;
		double[] grades = new double[diplomas.size()];
		// iterating address Map
		Iterator<Entry<String, Double>> itr = diplomas.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Double> pair = itr.next();
			if (field.contains(pair.getKey().toString()) && this_field == true) {
				grades[i++] = (double) pair.getValue();
			} else if (!(field.contains(pair.getKey().toString())) && this_field == false) {
				grades[i++] = (double) pair.getValue();
			}
		}
		return grades;
	}

	/**
	 * 
	 * @param candidate
	 * @return the language
	 */
	@SuppressWarnings("unchecked")
	protected String languagesAsString(JSONObject candidate) {
		String slanguages = "";
		Map<String, Double> languages = (HashMap<String, Double>) candidate.get("languages");
		Iterator<Entry<String, Double>> itr = languages.entrySet().iterator();
		int count = 0;
		while (itr.hasNext()) {
			if (count != 0) {
				slanguages += ", ";
			}
			count++;
			Map.Entry<String, Double> pair = itr.next();
			slanguages += pair.getKey();
		}
		return slanguages;
	}

	/**
	 * finds the degrees
	 * 
	 * @param candidate
	 * @param degree
	 * @return the degree
	 */
	@SuppressWarnings("unchecked")
	protected String diplomaAsString(JSONObject candidate, String degree) {
		String diploma = "";
		Map<String, Double> degrees = (HashMap<String, Double>) candidate.get(degree);
		Iterator<Entry<String, Double>> itr = degrees.entrySet().iterator();
		int count = 0;
		while (itr.hasNext()) {
			if (count != 0) {
				diploma += ", ";
			}
			count++;
			Map.Entry<String, Double> pair = itr.next();
			diploma += pair.getKey() + ":" + pair.getValue();
		}
		return diploma;
	}

	/**
	 * deletes a candidate
	 * 
	 * @param position
	 * @return true or false if the candidate is deleted
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteCandidate(String position) {
		boolean update = false;
		JSONParser parser = new JSONParser();
		try {
			JSONArray candidates = (JSONArray) parser.parse(new FileReader("Candidates.json"));
			ArrayList<? extends Candidate> candidateList = Rankings.createListFromFile(candidates,
					(Class<? extends Candidate>) Class.forName("EvaluateCandidates." + position));
			for (int i = 0; i < candidateList.size(); i++) {
				Candidate c = candidateList.get(i);
				if (this.toString().equals(c.toString())) {
					candidates.remove(candidates.get(i));
					FileWriter writer = new FileWriter("Candidates.json");
					writer.write(candidates.toJSONString());
					writer.flush();
					writer.close();
					update = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public String toString() {
		return "Candidate [full_name=" + full_name + ", age=" + age + ", nationality=" + nationality
				+ ", city_of_residence=" + city_of_residence + ", ssn=" + ssn + "]";
	}

	/**
	 * compares the two candidates
	 */
	public int compare(Candidate o1, Candidate o2) {
		return (int) (o2.getTotal_points() - o1.getTotal_points());
	}

	public abstract int getTotal_points();
}
