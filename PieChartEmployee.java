package GUI_Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.Scene;
import javafx.scene.Group;
import java.text.NumberFormat;

import evaluateEmployees.DataForCharts;

import java.math.RoundingMode;

public class PieChartEmployee {
	
	/** Contains the ID of a employee. */
	private static String id2;

	public PieChartEmployee(String id) {
		id2 = id;
	}

	public Scene generateChart() throws Exception {
		DataForCharts data = new DataForCharts();
        double [] d;
            int z=0;
            int b=0;
            int r=0;
            int w=0;
            int t=0;
            d = data.getDataForPieChart(id2);
            for(int i=0; i<d.length;i++) { //calulating how many employees are satisfied etc
                if(d[i]>0 && d[i]<=1) {
                    z=z+1;
                }
                else if(d[i]>1 && d[i]<=2) {
                    b=b+1;
                }
                else if(d[i]>2 && d[i] <=3) {
                    r=r+1;
                }
                else if(d[i]>3 && d[i]<=4) {
                    w=w+1;
                }
                else {
                    t=t+1;
                }
    }

    double a = (double)b/(double)d.length*100;
    double c = (double)z/(double)d.length*100;
    double y = (double)r/(double)d.length*100;
    double p = (double)w/(double)d.length*100;
    double n = (double)t/(double)d.length*100;
 NumberFormat format = NumberFormat.getInstance();
  format.setRoundingMode(RoundingMode.DOWN);
  format.setMaximumFractionDigits(2);

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList( //setting the data
            new PieChart.Data("Not at all Satisfied  "+ format.format(c)+"%",z),
            new PieChart.Data("Partly Satisfied  "+ format.format(a)+"%",b),
            new PieChart.Data("Satiisfied  "+format.format(y)+"%",r),
            new PieChart.Data("More than Satisfied  "+format.format(p)+"%",w),
            new PieChart.Data("Very Satisfied  "+format.format(n)+"%",t)
            );



            PieChart chart = new PieChart(pieChartData);
            chart.setLegendVisible(false);
            chart.setTitle("Pie Chart for " + d.length + " Employees");

            Group root = new Group(chart);
            Scene scene = new Scene(root,600,400);


         applyCustomColorSequence( //deciding the color of each satisfaction level
                       pieChartData,
                       "green",
                       "red",
                       "yellow",
                       "black",
                       "white"
                     );
    	return scene;
	}

   private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
	   int i = 0;
       for (PieChart.Data data : pieChartData) {
    	   data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
           i++;
       }
   }
    }