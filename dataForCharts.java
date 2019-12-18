import java.util.*;
import java.io.*;
public class dataForCharts {
	private Integer[] scores = new Integer [11];
	private ArrayList<Integer[]> id_scores = new ArrayList<Integer[]>();
	private ArrayList<Integer[]> dataforcharts = new ArrayList<Integer[]>();
	Employee emp = new Employee (); /* dontas's methos */
	public void getData () throws IOException {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\AGGELOS\\Desktop\\Εργασία προγραμματισμού ΙΙ\\id_scores.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			id_scores = (ArrayList<Integer[]>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (ClassNotFoundException e) {
		}
	}
	public void method (int id)throws IOException{
		getData();
		for ( int i=0 ; i<id_scores.size();i++){
			scores= id_scores.get(i);
			if(emp.findDepartment(id)==emp.findDepartment(scores[0])){
				dataforcharts.add(scores);
			}
		}
	}
	public double[] getDataForPieChart ( int id )throws IOException {
		method(id);
		int sum;
		double[] d = new double [dataforcharts.size()];
		for(int i=0;i<dataforcharts.size();i++){
			sum=0;
			scores=dataforcharts.get(i);
			for(int y=1;y<scores.length;y++){
				sum+=scores[y];
			}
			d[i]=(sum+0.0)/10;
		}
		return d;

	}
	public double[] getDataForBarChart (int id)throws IOException{
		method(id);
		double[] m_o = {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
		for(int i=0;i<dataforcharts.size();i++){
			scores=dataforcharts.get(i);
			for(int y=0;y<scores.length;y++){
				m_o[y]+=scores[y+1];
			}
		}
		for(int i=0 ;i<10;i++){
			m_o[i]=(m_o[i]+0.0)/dataforcharts.size();
		}
		return m_o;
	}
}
























