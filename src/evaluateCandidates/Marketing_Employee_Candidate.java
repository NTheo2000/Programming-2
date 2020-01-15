package evaluateCandidates;

import org.json.simple.JSONObject;

/**
 * Counts total points for the marketing department employee candidate Using
 * final static integers counts the points for the evaluation system we use to
 * evaluate each candidate This class extends the Candidate class.
 *
 * @version 3.1 14 Jan 2020
 * @author Michalis Dontas and Miltiadis Tsichlis
 */
public class Marketing_Employee_Candidate extends Candidate {

	private static final int MULTIPLIER_FOR_EACH_LANGUAGE = 2;
	private static final int MULTIPLIER_FOR_COMPUTER_COMPETENCE = 2;
	private static final int MULTIPLIER_FOR_EACH_YEAR_OF_EXPERIENCE = 2;
	private static final int EXTRA_POINTS_FOR_RECOMMENDATION_LETTER = 5;
	private static final double STARTING_SALARY = 95000;

	private long[] level_of_languages;
	private long level_of_computer_handling;
	private long former_experience;
	private boolean recommendation_letter;
	private int total_points;
	private String master;
	private String phd;
	private String languages;

	/**
	 * Simple constructor
	 */
	public Marketing_Employee_Candidate() {
		super();
	}

	/**
	 * Constructor with @param JSONObject candidate
	 */
	public Marketing_Employee_Candidate(JSONObject candidate) {
		super(candidate);
		this.level_of_languages = super.searchLevel_of_languages(candidate);
		this.level_of_computer_handling = super.searchLevel_of_computer_handling(candidate);
		this.former_experience = super.searchFormer_experience(candidate);
		this.recommendation_letter = super.searchRecommendation_letter(candidate);
		total_points += giveBoostByBachelor(candidate, "Marketing");
		setTotal_points();
		languages = super.languagesAsString(candidate);
		master = super.diplomaAsString(candidate, "Master");
		phd = super.diplomaAsString(candidate, "PhD");
	}

	@Override
	public double getSTARTING_SALARY() {
		return STARTING_SALARY;
	}

	@Override
	public String getLanguages() {
		return languages;
	}

	@Override
	public String getMaster() {
		return master;
	}

	@Override
	public String getPhD() {
		return phd;
	}

	@Override
	public long getLevel_of_computer_handling() {
		return level_of_computer_handling;
	}

	@Override
	public long getFormer_experience() {
		return former_experience;
	}

	@Override
	public boolean isRecommendation_letter() {
		return recommendation_letter;
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
			for (long i : level_of_languages) {
				sum += i * MULTIPLIER_FOR_EACH_LANGUAGE;
			}
		}
		sum += level_of_computer_handling * MULTIPLIER_FOR_COMPUTER_COMPETENCE
				+ former_experience * MULTIPLIER_FOR_EACH_YEAR_OF_EXPERIENCE
				+ (recommendation_letter == true ? 1 : 0) * EXTRA_POINTS_FOR_RECOMMENDATION_LETTER;
		return sum;
	}

}
