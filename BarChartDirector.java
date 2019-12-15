import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartDirector extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Director question scores");
        double[] mscore = { 3.7, 3, 4, 4.3, 2.3, 2.8, 3.4,4,4.3,2.3 }; // avg of each question for 10 questions
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Questions");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Score");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        // dataSeries1.setName("2014");
        for (int i = 0; i < 10; i++) {
            dataSeries1.getData().add(new XYChart.Data("Question " + (i + 1), mscore[i]));
        }

        barChart.getData().add(dataSeries1);

        VBox vbox = new VBox(barChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(800);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
