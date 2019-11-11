import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Group;

public class PieChartExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
			new PieChart.Data("IT",40),
			new PieChart.Data("Nursing",70),
			new PieChart.Data("Accounting",20),
			new PieChart.Data("Arts",30),
			new PieChart.Data("Engineering",18)
			);

			PieChart pChart = new PieChart(pieData);

            Group root = new Group(pChart);
			Scene scene = new Scene(root,600,400);
			primaryStage.setTitle("Pie Chart");
            primaryStage.setScene(scene);
			primaryStage.show();

		}

		public static void main(String[] args) {
			launch(args);
		}
	}