package ergasiaprogram2;

import org.json.simple.JSONObject;

public class Human_Resources_Director extends Marketing_Employee {

	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_HUMAN_RESOURCES_SCIENCE=10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_HUMAN_RESOURCES_SCIENCE=15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD=5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD=10;

	private double[] master_in_human_resources;
	private double[] master_in_other_field;
	private double[] phd_in_human_resources;
	private double[] phd_in_other_field;
	private int total_points = 0;

	public Human_Resources_Director() {
		super();
	}

	public Human_Resources_Director(JSONObject file) {
		super(file);
		this.master_in_human_resources = findDegreeAndField(file, "Master in Human_resources");
		this.master_in_other_field = findDegreeAndField(file, "Master in other field");
		this.phd_in_human_resources = findDegreeAndField(file, "PhD in Human_resources");
		this.phd_in_other_field = findDegreeAndField(file, "PhD in other field");
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
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_HUMAN_RESOURCES_SCIENCE;
		}
		for(double i : master_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
		}
		for(double i : phd_in_human_resources) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_HUMAN_RESOURCES_SCIENCE;
		}
		for(double i : phd_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
		}
		return sum;
	}

}
