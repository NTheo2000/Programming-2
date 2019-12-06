/*
 * Name of class: Marketing_Director_Candidate
 * 
 * Copyright 2019 Miltiadis Tsichlis & Michael Dontas.
 */
import org.json.simple.JSONObject;

public class Marketing_Director_Candidate extends Marketing_Employee_Candidate {
/**
	 * Searches a Json file for masters and phds in Marketing Science and other fields
	 * The class reads a Json file and and finds key words in order to count the points for each candidate using fixed multipliers. 
	 * 
	 * @version 1.1 6 December 2019
	 * @author Michael Dontas & Miltiadis Tsichlis
	 */
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_MARKETING=10;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_MARKETING=15;
	private static final int MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD=5;
	private static final int MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD=10;

	private double[] master_in_marketing;
	private double[] master_in_other_field;
	private double[] phd_in_marketing;
	private double[] phd_in_other_field;
	private int total_points;

	public Marketing_Director_Candidate() {
		super();
	}

	public Marketing_Director_Candidate(JSONObject candidate) {
		super(candidate);
		this.master_in_marketing = findDegreeAndField(candidate, "Master" , "Marketing", true);
		this.master_in_other_field = findDegreeAndField(candidate, "Master", "Marketing", false);
		this.phd_in_marketing = findDegreeAndField(candidate, "PhD", "Marketing", true);
		this.phd_in_other_field = findDegreeAndField(candidate, "PhD", "Marketing", false);
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
		for(double i : master_in_marketing) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_MARKETING;
		}
		for(double i : master_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_MASTER_IN_OTHER_FIELD;
		}
		for(double i : phd_in_marketing) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_MARKETING;
		}
		for(double i : phd_in_other_field) {
			sum += i * MULTIPLIER_FOR_EACH_PHD_IN_OTHER_FIELD;
		}
		return sum;
	}

}
