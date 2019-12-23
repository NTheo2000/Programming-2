/*
 * LineChartEmployees
 */
package evaluationEmployees;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * This class creates a line chart that shows the performance of an employee
 * based on his/her scores.
 * 
 * @author Nikolas Theofanopoulos
 *
 * @param <E1> the class is generalized and E1 is the name of an another class.
 */
public class LineChartEmployees<E1> extends Application {
	/** Contains a snapshot of class E1. */
	private E1 object;
	/** contains the ID of a employee. */
	private int id;
	/**
	 * contains the semesters for which we will create the employee performance
	 * chart.
	 */
	private int[] semester;

	/** This constructor registers the snapshot variables. */
	public LineChartEmployees(int id, int[] semester, E1 object) {
		this.id = id;
		this.semester = semester;
		this.object = object;
	}

	@Override
	/**
	 * Indicates the specifications of the graph.
	 */
	public void start(Stage stage) {
		stage.setTitle("Line Chart");
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
		double[] degrees = null;
		if (object instanceof EvaluationMarketingEmployees) {
			degrees = ((EvaluationMarketingEmployees) object).getDegrees(id, semester);
		} else if (object instanceof EvaluationHrEmployees) {
			degrees = ((EvaluationHrEmployees) object).getDegrees(id, semester);
		} else if (object instanceof EvaluationItEmployees) {
			degrees = ((EvaluationItEmployees) object).getDegrees(id, semester);
		} else if (object instanceof EvaluationAccountingEmployees) {
			degrees = ((EvaluationAccountingEmployees) object).getDegrees(id, semester);
		}
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] != 0)
				series.getData().add(new XYChart.Data(semester[i], degrees[i]));
		}

		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(series);

		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Executes the method start
	 */
	public void executeChart() {
		launch();
	}
}
