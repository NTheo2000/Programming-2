package src.RunHumanMasteR;

import org.json.simple.JSONObject;

public class Accounting_Director_Candidate extends Accounting_Employee_Candidate {

	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_ACCOUNTING = 10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_ACCOUNTING = 15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD = 5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD = 10;
	private static final double STARTING_SALARY = 90000;


	private double[] master_in_Accounting;
	private double[] master_in_other_field;
	private double[] phd_in_Accounting;
	private double[] phd_in_other_field;
	private int total_points;

	public Accounting_Director_Candidate() {
		super();
	}

	public Accounting_Director_Candidate(JSONObject candidate) {
		super(candidate);
		this.master_in_Accounting = findDegreeAndField(candidate, "Master", "Accounting", true);
		this.master_in_other_field = findDegreeAndField(candidate, "Master", "Accounting", false);
		this.phd_in_Accounting = findDegreeAndField(candidate, "PhD", "Accounting", true);
		this.phd_in_other_field = findDegreeAndField(candidate, "PhD", "Accounting", false);
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
		if (master_in_Accounting != null) {
			for(double i : master_in_Accounting) {
				sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_ACCOUNTING;
			}
		}
		if (master_in_other_field != null) {
			for(double i : master_in_other_field) {
				sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
			}
		}
		if (phd_in_Accounting != null) {
			for(double i : phd_in_Accounting) {
				sum += i * MULTIPLIER_FOR_EACH_PHD_IN_ACCOUNTING;
			}
		}
		if (phd_in_other_field != null) {
			for(double i : phd_in_other_field) {
				sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
			}
		}
		return sum;
	}

}
