package ergasiaprogram2;

import org.json.simple.JSONObject;

public class Technology_Director extends Marketing_Employee {

	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_TECHNOLOGY=10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_TECHNOLOGY=15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD=5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD=10;

	private double[] master_in_technology;
	private double[] master_in_other_field;
	private double[] phd_in_technology;
	private double[] phd_in_other_field;
	private int total_points = 0;

	public Technology_Director() {
		super();
	}

	public Technology_Director(JSONObject file) {
		super(file);
		this.master_in_technology = findDegreeAndField(file, "Master in Technology");
		this.master_in_other_field = findDegreeAndField(file, "Master in other field");
		this.phd_in_technology = findDegreeAndField(file, "PhD in Technology");
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
		for(double i : master_in_technology) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_TECHNOLOGY;
		}
		for(double i : master_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
		}
		for(double i : phd_in_technology) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_TECHNOLOGY;
		}
		for(double i : phd_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
		}
		return sum;
	}

}
