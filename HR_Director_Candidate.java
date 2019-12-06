import org.json.simple.JSONObject;

public class HR_Director_Candidate extends HR_Employee_Candidate {

	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_HUMAN_RESOURCES=10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_HUMAN_RESOURCES=15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD=5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD=10;

	private double[] master_in_human_resources;
	private double[] master_in_other_field;
	private double[] phd_in_human_resources;
	private double[] phd_in_other_field;
	private int total_points;

	public HR_Director_Candidate() {
		super();
	}

	public HR_Director_Candidate(JSONObject candidate) {
		super(candidate);
		this.master_in_human_resources = findDegreeAndField(candidate, "Master", "HR", true);
		this.master_in_other_field = findDegreeAndField(candidate, "Master", "HR", false);
		this.phd_in_human_resources = findDegreeAndField(candidate, "PhD", "HR", true);
		this.phd_in_other_field = findDegreeAndField(candidate, "PhD", "HR", false);
		setTotal_points();
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
		for(double i : master_in_human_resources) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_HUMAN_RESOURCES;
		}
		for(double i : master_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
		}
		for(double i : phd_in_human_resources) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_HUMAN_RESOURCES;
		}
		for(double i : phd_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
		}
		return sum;
	}

}
