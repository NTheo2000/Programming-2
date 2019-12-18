import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;

public abstract class Candidate implements Comparator<Candidate> {
	
	private String full_name;
	private long age;
	private String nationality;
	private String city_of_residence;
	private String ssn;
	private String email;
	//add any other personal data for the candidate
	
	
	protected Candidate() {
		
	}
	
	protected Candidate(JSONObject candidate) {
		this.full_name = (String) searchPersonalDataInFile(candidate, "full_name");
		this.age = (long) searchPersonalDataInFile(candidate, "age");
		this.nationality = (String) searchPersonalDataInFile(candidate, "nationality");
		this.city_of_residence = (String) searchPersonalDataInFile(candidate, "city_of_residence");
		this.ssn = (String) searchPersonalDataInFile(candidate, "ssn");
	}

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
	
	protected Object searchPersonalDataInFile(JSONObject candidate, String keywords)  {
		return candidate.get(keywords);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int[] searchLevel_of_languages(JSONObject candidate) {
		Map languages = (HashMap) candidate.get("languages");
		int[] level = new int[languages.size()];
		int i = 0;
			Iterator<Map.Entry> itr1 = languages.entrySet().iterator(); 
	        while (itr1.hasNext()) { 
				Map.Entry pair = itr1.next(); 
	            level[i++] = (int) pair.getValue();
	        }
		return level;
	}
	protected int searchLevel_of_computer_handling(JSONObject candidate) {
		return (int) candidate.get("level_of_computer_handling");
	}
	protected int searchNumber_of_programming_languages(JSONObject candidate) {
		@SuppressWarnings("rawtypes")
		Map languages = (Map) candidate.get("programming_languages");
		return languages.size();
	}
	protected int searchFormer_experience(JSONObject candidate) {
		return (int) candidate.get("former_experience");
	}
	protected boolean searchRecommendation_letter(JSONObject candidate) {
		if(candidate.containsKey("recommendation_letter")) {
			return true;
		} else {
			return false;
		}
	}
	protected int giveBoostByBachelor(JSONObject candidate, String field) {
		if(candidate.get("bachelor_field") == null || !candidate.get("bachelor_field").equals(field)) {
			return 50;
		} else {
			return 0;
		}
	}
	public int getDepartmentId() throws ClassNotFoundException {
		int id = 0;
		if (this.getClass().equals(Class.forName("Marketing_Employee_Candidate"))) {
			id = 1;
		} else if (this.getClass().equals(Class.forName("Accounting_Employee_Candidate"))) {
			id = 2;
		} else if (this.getClass().equals(Class.forName("IT_Employee_Candidate"))) {
			id = 3;
		} else if (this.getClass().equals(Class.forName("HR_Employee_Candidate"))) {
			id = 4;
		} else if (this.getClass().equals(Class.forName("Marketing_Director_Candidate"))) {
			id = 5;
		} else if (this.getClass().equals(Class.forName("Accounting_Director_Candidate"))) {
			id = 6;
		} else if (this.getClass().equals(Class.forName("IT_Director_Candidate"))) {
			id = 7;
		} else if (this.getClass().equals(Class.forName("HR_Director_Candidate"))) {
			id = 8;
		} else {
			assert id<=8 && id >=1 : "Unidentified departmnet";
		}
		return id;
	}

	protected double[] findDegreeAndField(JSONObject candidate, String degree, 
		String field, boolean this_field) {		
		//Assume that a HashMap is created to the json file 
		@SuppressWarnings("rawtypes")
		Map diplomas = (HashMap) candidate.get(degree);
		int i = 0;
		double[] grades = new double[diplomas.size()];
        // iterating address Map 
        @SuppressWarnings({"unchecked", "rawtypes"})
		Iterator<Map.Entry> itr1 = diplomas.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            @SuppressWarnings("rawtypes")
			Map.Entry pair = itr1.next(); 
            if(field.contains(pair.getKey().toString()) && this_field == true) {
    			grades[i++] = (double) pair.getValue();
            } else if(!(field.contains(pair.getKey().toString())) && this_field == false) {
    			grades[i++] = (double) pair.getValue();
            }
        }
        return grades;
	}

	@Override
	public String toString() {
		return "Candidate [full_name=" + full_name + ", age=" + age + ", nationality=" + nationality
				+ ", city_of_residence=" + city_of_residence + ", ssn=" + ssn + "]";
	}
    @Override
	public int compare(Candidate o1, Candidate o2) {
	       return (int) (o2.getTotal_points() - o1.getTotal_points());
	}
	protected abstract int getTotal_points();
}