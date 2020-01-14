package evaluateEmployees;


import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class DataForCharts {
	private Long[] scores = new Long [11];
	private ArrayList<Long[]> dataforcharts = new ArrayList<Long[]>();

	public void method (String id )throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONArray list = (JSONArray) parser.parse(new FileReader("id_scores.json"));
		for (int i = 0; i < list.size(); i++) {
			String e_id = (String) ((JSONObject) list.get(i)).get("id");
			if (id.equals(e_id)) {
				JSONObject obj = (JSONObject) ((JSONObject) list.get(i)).get("score");
				for (int j = 0; j < obj.size(); j++) {
					scores[j] = (Long) obj.get("question " + (j + 1));
				}
				dataforcharts.add(scores);
			}
		}
	}
	public double[] getDataForPieChart ( String id )throws IOException, ParseException {
		method(id);
		double sum;
		double[] d = new double [dataforcharts.size()];
		for(int i=0;i<dataforcharts.size();i++){
			sum=0;
			scores=dataforcharts.get(i);
			for(int y=1;y<scores.length;y++){
				sum+=scores[y];
			}
			d[i]=(sum)/11;
		}
		return d;

	}
	public double[] getDataForBarChart (String id)throws IOException, ParseException{
		method(id);
		double[] m_o = {0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00};
		for(int i=0;i<dataforcharts.size();i++){
			scores=dataforcharts.get(i);
			System.out.println(scores.length);
			for(int y=0;y<scores.length;y++){
				m_o[y]+=scores[y];
			}
		}
		for(int i=0 ;i<11;i++){
			m_o[i]=(m_o[i])/dataforcharts.size();
		}
		return m_o;
	}
}
