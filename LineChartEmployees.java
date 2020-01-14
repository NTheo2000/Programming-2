package GUI_Classes;

import java.util.ArrayList;

import evaluateEmployees.EvaluationAccountingEmployees;
import evaluateEmployees.EvaluationHrEmployees;
import evaluateEmployees.EvaluationItEmployees;
import evaluateEmployees.EvaluationMarketingEmployees;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * This class creates a line chart that shows the performance of an employee
 * based on his/her scores.
 *
 * @author Nikolas Theofanopoulos
 */


public class LineChartEmployees {
    /** Contains a snapshot of class E1. */
    private static Object object2;

    /** Contains the ID of a employee. */
    private static String id2;

    /**
     * Contains the semesters for which we will create the employee performance
     * chart.
     */
    private static ArrayList<Integer> semester2;


    public LineChartEmployees(String id, ArrayList<Integer> semester, Object object) {
        id2 = id;
        semester2 = semester;
        object2 = object;
    }

    /**
     * Indicates the specifications of the graph.
     */

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
        double[] degrees;
        if (object2 instanceof EvaluationMarketingEmployees) {
            //degrees = ((EvaluationMarketingEmployees) object2).getDegrees(id2, semester2);
        } else if (object2 instanceof EvaluationHrEmployees) {
            //degrees = ((EvaluationHrEmployees) object2).getDegrees(id2, semester2);
        } else if (object2 instanceof EvaluationItEmployees) {
            //degrees = ((EvaluationItEmployees) object2).getDegrees(id2, semester2);
        } else {
            //degrees = ((EvaluationAccountingEmployees) object2).getDegrees(id2, semester2);
        }
        /*for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] != 0)
                series.getData().add(new XYChart.Data(semester2.get(i), degrees[i]));
        }*/
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        return scene;
    }
}