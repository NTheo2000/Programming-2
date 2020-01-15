package evaluateCandidates;

import org.json.simple.JSONObject;

/**
 * Counts total points for the technology department director candidate Using
 * final static integers counts the points for the evaluation system we use to
 * evaluate each candidate This class extends the IT_Employee_Candidate class.
 *
 * @version 3.1 14 Jan 2020
 * @author Michalis Dontas and Miltiadis Tsichlis
 */
public class IT_Director_Candidate extends IT_Employee_Candidate {

	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_IT = 10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_IT = 15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD = 5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD = 10;
	private static final double STARTING_SALARY = 110000;

	private double[] master_in_IT;
	private double[] master_in_other_field;
	private double[] phd_in_IT;
	private double[] phd_in_other_field;
	private int total_points;

	/**
	 * Simple constructor
	 */
	public IT_Director_Candidate() {
		super();
	}

	/**
	 * Constructor with @param JSONObject candidate
	 */
	public IT_Director_Candidate(JSONObject candidate) {
		super(candidate);
		this.master_in_IT = findDegreeAndField(candidate, "Master", "IT", true);
		this.master_in_other_field = findDegreeAndField(candidate, "Master", "IT", false);
		this.phd_in_IT = findDegreeAndField(candidate, "PhD", "IT", true);
		this.phd_in_other_field = findDegreeAndField(candidate, "PhD", "IT", false);
		setTotal_points();
	}

	@Override
	public double getSTARTING_SALARY() {
		return STARTING_SALARY;
	}

	@Override
	public int getTotal_points() {
		return total_points;
	}

	private void setTotal_points() {
		this.total_points = total_points();
	}

	@Override
	protected int total_points() {
		int sum = super.getTotal_points();
		if (master_in_IT != null) {
			for (double i : master_in_IT) {
				sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_IT;
			}
		}
		if (master_in_other_field != null) {
			for (double i : master_in_other_field) {
				sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
			}
		}
		if (phd_in_IT != null) {
			for (double i : phd_in_IT) {
				sum += i * MULTIPLIER_FOR_EACH_PHD_IN_IT;
			}
		}
		if (phd_in_IT != null) {
			for (double i : phd_in_other_field) {
				sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
			}
		}
		return sum;
	}

}
