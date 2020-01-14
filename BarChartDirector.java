package GUI_Classes;

import evaluateEmployees.DataForCharts;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class BarChartDirector {
	
	/** Contains the ID of an employee. */
	private static String id2;

	public BarChartDirector(String id) {
		id2 = id;
	}


	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Scene generateChart() throws Exception {
		DataForCharts da = new DataForCharts();
        double[] mscore = da.getDataForBarChart(id2);// avg of each question for 10 questions
       System.out.println("Ok here");
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Questions");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Score");

        BarChart barChart = new BarChart(xAxis, yAxis);
        
    	barChart.setTitle("Director question scores");

        XYChart.Series dataSeries1 = new XYChart.Series();
         dataSeries1.setName("2014");
        for (int i = 0; i < 11; i++) {
            dataSeries1.getData().add(new XYChart.Data("Question " + (i + 1), mscore[i]));
        }

        barChart.getData().add(dataSeries1);

        VBox vbox = new VBox(barChart);

        Scene scene = new Scene(vbox, 400, 200);

        return scene;
    }
}
