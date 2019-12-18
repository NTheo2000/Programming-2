import org.json.simple.JSONObject;

public class IT_Employee_Candidate extends Candidate {
	
	private static final int MULTIPLIER_FOR_EACH_LANGUAGE = 2;
	private static final int MULTIPLIER_FOR_COMPUTER_COMPETENCE = 2;
	private static final int MULTIPLIER_FOR_EACH_PROGRAMMING_LANGUAGE = 5;
	private static final int MULTIPLIER_FOR_EACH_YEAR_OF_EXPERIENCE = 2;
	private static final int EXTRA_POINTS_FOR_RECOMMENDATION_LETTER = 5;
	

	private int[] level_of_languages;
	private int level_of_computer_handling;
	private int number_of_programming_languages;
	private int former_experience;
	private boolean recommendation_letter;
	private int total_points;

	
	public IT_Employee_Candidate() {
		super();
	}

	public IT_Employee_Candidate(JSONObject candidate) {
		super(candidate);
		this.level_of_languages= super.searchLevel_of_languages(candidate);
		this.level_of_computer_handling = super.searchLevel_of_computer_handling(candidate);
		this.number_of_programming_languages = super.searchNumber_of_programming_languages(candidate);
		this.former_experience = super.searchFormer_experience(candidate);
		this.recommendation_letter = super.searchRecommendation_letter(candidate);
		total_points += giveBoostByBachelor(candidate, "IT");
		setTotal_points();
	}
	
	@Override
	public int getTotal_points() {
		return total_points;
	}

	private void setTotal_points() {
		this.total_points = total_points();
	}

	protected int total_points() {
		int sum = 0;
		if (level_of_languages != null) {
			for (int i : level_of_languages) {
			sum += i * MULTIPLIER_FOR_EACH_LANGUAGE;
			}
		}
		sum += level_of_computer_handling * MULTIPLIER_FOR_COMPUTER_COMPETENCE + 
				number_of_programming_languages * MULTIPLIER_FOR_EACH_PROGRAMMING_LANGUAGE +
				former_experience * MULTIPLIER_FOR_EACH_YEAR_OF_EXPERIENCE + 
				(recommendation_letter == true ? 1 : 0) * EXTRA_POINTS_FOR_RECOMMENDATION_LETTER;

		return sum;
	}

}
