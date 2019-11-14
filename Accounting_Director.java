package ergasiaprogram2;

import org.json.simple.JSONObject;

public class Accounting_Director extends Marketing_Employee {

	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_ACCOUNTING=10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_ACCOUNTING=15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD=5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD=10;

	private double[] master_in_accounting;
	private double[] master_in_other_field;
	private double[] phd_in_accounting;
	private double[] phd_in_other_field;
	private int total_points = 0;

	public Accounting_Director() {
		super();
	}

	public Accounting_Director(JSONObject file) {
		super(file);
		this.master_in_accounting = findDegreeAndField(file, "Master in Accounting");
		this.master_in_other_field = findDegreeAndField(file, "Master in other field");
		this.phd_in_accounting = findDegreeAndField(file, "PhD in Accounting");
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
		for(double i : master_in_accounting) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_ACCOUNTING;
		}
		for(double i : master_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
		}
		for(double i : phd_in_accounting) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_ACCOUNTING;
		}
		for(double i : phd_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
		}
		return sum;
	}

}
