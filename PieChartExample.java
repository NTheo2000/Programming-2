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
		double [] d;
			int z=0;
			int b=0;
			d = new double[] {3.5,4,5,3.2,4.3,2.3,1.3,3.4,4.3,4.5,3.7};
			for(int i=0; i<d.length;i++) {
				if(d[i]<4) {
					z=z+1;
				}
				else {
					b=b+1;
				}
	}
		ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
            new PieChart.Data("Happy",b),
			new PieChart.Data("Unhappy",z)
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