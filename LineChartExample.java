import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class LineChartExample extends Application {

    @Override public void start(Stage stage)  {
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
        series.getData().add(new XYChart.Data(1, 2.5));
        series.getData().add(new XYChart.Data(2, 3.1));
        series.getData().add(new XYChart.Data(3, 3.3));
        series.getData().add(new XYChart.Data(4, 3.5));
        series.getData().add(new XYChart.Data(5, 3.6));
        series.getData().add(new XYChart.Data(6, 3.8));
        series.getData().add(new XYChart.Data(7, 4.3));
        series.getData().add(new XYChart.Data(8, 4.5));
        series.getData().add(new XYChart.Data(9, 4.3));
        series.getData().add(new XYChart.Data(10, 4.2));
        series.getData().add(new XYChart.Data(11, 4.3));
        series.getData().add(new XYChart.Data(12, 4.6));

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
	}
}