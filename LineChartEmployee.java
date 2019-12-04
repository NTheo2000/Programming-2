import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class LineChartEmployee extends Application {

     public void start(Stage stage)  {
		double[] Array = {2.1,3.4,2.3};
		int[] Semester = {1,2,3,4,5,6,7,8,9,10,11,12};
		double a = Array[0];
		double b = Array[1];
		double c = Array[2];
        stage.setTitle("Line Chart");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        yAxis.setLabel("Score");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Employee Progress");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("HR APP");
        //populating the series with data
        for(int i=0;i<Array.length;i++) {
        series.getData().add(new XYChart.Data(Semester[i],Array[i]));
	}

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }
public void executeChart() {
	launch();
}

}