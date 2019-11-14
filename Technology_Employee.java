package ergasiaprogram2;


import org.json.simple.JSONObject;

public class Technology_Employee extends Candidate{
	
	private static final int MULTIPLIER_FOR_EACH_LANGUAGE=1;
	private static final int MULTIPLIER_FOR_COMPUTER_COMPETENCE=3;
	private static final int MULTIPLIER_FOR_EACH_YEAR_OF_EXPERIENCE=2;
	private static final int EXTRA_POINTS_FOR_RECOMMENDATION_LETTER=5;
	private static final int EXTRA_POINTS_FOR_PROGRAMMING_LANGUAGE = 5;

	private int[] level_of_languages;
	private int level_of_computer_handling;
	private int former_experience;
	private boolean recommendation_letter;
	protected int programming_language;
	private int total_points= 0;

	
	public Technology_Employee() {
		super();
	}
	
	public Technology_Employee(JSONObject file) {
		super(file);
		this.level_of_languages= super.searchLevel_of_languages(file);
		this.level_of_computer_handling = super.searchLevel_of_computer_handling(file);
		this.former_experience = super.searchFormer_experience(file);
		this.programming_language = super.searchNumber_of_programming_languages(file);
		this.recommendation_letter = super.searchRecommendation_letter(file);
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
		int sum=0;
		for(int i : level_of_languages) {
			sum += i * MULTIPLIER_FOR_EACH_LANGUAGE;
		}
		sum += level_of_computer_handling * MULTIPLIER_FOR_COMPUTER_COMPETENCE + 
				former_experience * MULTIPLIER_FOR_EACH_YEAR_OF_EXPERIENCE + 
				(recommendation_letter == true ? 1 : 0) * EXTRA_POINTS_FOR_RECOMMENDATION_LETTER+ 
				programming_language * EXTRA_POINTS_FOR_PROGRAMMING_LANGUAGE;
		
		return sum;
	}

}
