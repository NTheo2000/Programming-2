package GUI_Classes;


import java.util.ArrayList;

import evaluateEmployees.EvaluationEmployee;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * This class creates a line chart that shows the performance of an employee
 * based on his/her scores.
 * 
 * @author Nikolas Theofanopoulos, Michael-Dontas
 *
 * @param <E1> the class is generalized and E1 is the name of an another class.
 */
public class LineChartEmployees {
	private static String department2;
	/** Contains the ID of a employee. */
	private static String id2;
	
	/**
	 * Contains the semesters for which we will create the employee performance
	 * chart.
	 */
	private static ArrayList<Integer> semester2;


	public LineChartEmployees(String id, ArrayList<Integer> semester, String department) {
		id2 = id;
		semester2 = semester;
		department2 = department;
	}

	/**
	 * Indicates the specifications of the graph.
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Scene generateChart() throws Exception {
		// defining the axes
		final NumberAxis yAxis = new NumberAxis();
		final NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Number of Month");
		yAxis.setLabel("Score");
		// creating the chart
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		
		
		lineChart.setTitle("Employee Progress");
		// defining a series
		XYChart.Series series = new XYChart.Series();
		series.setName("HR APP");
		// populating the series with data
		double[] degrees = EvaluationEmployee.getDegrees(id2, semester2, department2);
		try {
			for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] != 0)
				series.getData().add(new XYChart.Data(semester2.get(i), degrees[i]));
			}
		} catch (NullPointerException e) {
		}
		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(series);
		
		return scene;
	}
}
