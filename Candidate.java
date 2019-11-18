
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;

public abstract class Candidate {
	
	private String full_name;
	private long age;
	private String nationality;
	private String city_of_residence;
	private long ssn;
	//add any other personal data for the candidate
	
	
	protected Candidate() {
		
	}
	
	protected Candidate(JSONObject candidate) {
		this.full_name = (String) searchPersonalDataInFile(candidate, "full_name");
		this.age = (long) searchPersonalDataInFile(candidate, "age");
		this.nationality = (String) searchPersonalDataInFile(candidate, "nationality");
		this.city_of_residence = (String) searchPersonalDataInFile(candidate, "city_of_residence");
		this.ssn = (long) searchPersonalDataInFile(candidate, "ssn");
	}

	protected Object searchPersonalDataInFile(JSONObject candidate, String keywords)  {
		return candidate.get(keywords);
	}

	protected int[] searchLevel_of_languages(JSONObject candidate) {
		@SuppressWarnings("rawtypes")
		Map languages = (Map) candidate.get("languages");
		int[] level = new int[languages.size()];
		int i = 0;
		 @SuppressWarnings({ "unchecked", "rawtypes" })
			Iterator<Map.Entry> itr1 = languages.entrySet().iterator(); 
	        while (itr1.hasNext()) { 
	            @SuppressWarnings("rawtypes")
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
		if(candidate.get("bachelor_field").equals(field)) {
			return 50;
		} else {
			return 0;
		}
	}
	protected double[] findDegreeAndField(JSONObject candidate, String degree, 
			String field, boolean this_field_or_other) {		
		//Assume that a HashMap is created to the json file 
		@SuppressWarnings("rawtypes")
		Map diplomas = (Map) candidate.get(degree); 
		int i = 0;
		double[] grades = new double[diplomas.size()];
        // iterating address Map 
        @SuppressWarnings({ "unchecked", "rawtypes" })
		Iterator<Map.Entry> itr1 = diplomas.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            @SuppressWarnings("rawtypes")
			Map.Entry pair = itr1.next(); 
            if(field.contains(pair.getKey().toString()) && this_field_or_other == true) {
    			grades[i++] = (double) pair.getValue();
            } else if(!(field.contains(pair.getKey().toString())) && this_field_or_other == false) {
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

	protected abstract int getTotal_points();
}