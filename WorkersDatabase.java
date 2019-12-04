import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WorkersDatabase {
	private static JSONArray employeeList = new JSONArray();
	private static String[][] attributes = {{"George Washington", "27", "Serbian", "London", "110000", "15653278","392457389"},
										   {"Manos Amanatidis", "33", "Greek", "Athens", "70000", "35463189","566137267"},
										   {"Mohammed Salah", "25", "Egyptian", "New York", "150000", "43564318","431654757"},
										   {"Shergeh Staikovski", "45", "Russian", "San Diego", "80000", "25455543","436895270"},
										   {"Mariah Carey", "27", "Serbian", "Athens", "110000", "32532545","436538908"},
										   {"Jack Nicholson", "37", "", "USA", "60000", "26834524","548750987"},
										   {"Nikola Milutinov", "29", "Serbian", "New York", "46000", "35634275","325347432"},
										   {"Apostolos Papadimitriou", "31", "Greek", "Athens", "76000", "14325446","483583859"},
										   {"Tony Parker", "39", "British", "New York", "93000", "45863214","431760454"},
										   {"Vicenzo Corleone", "48", "Italian", "San Diego", "124000", "23654766","436786967"},
										   {"Sam Johnson", "42", "USA", "London", "106000", "36588857","797212324"},
										   {"Andy Murray", "30", "British", "Athens", "83000", "13268754","436751290"},
										   {"Kwnstantina Apostolou", "32", "Greek", "London", "98000", "13347867","347609531"},
										   {"Donovan Mitchell", "33", "USA", "Athens", "67000", "47568321","423167538"},
										   {"Maria Sharapova", "26", "Ukranian", "New York", "59000", "34654942","436753453"},
										   {"Alex Ferguson", "27", "British", "San Diego", "88000", "47658110","231046537"},
										   {"Antonis Samaras", "27", "Greek", "London", "90000", "25760873","698754131"},
										   {"Charles Carter", "39", "USA", "New York", "58000", "16587085","124378589"},
										   {"Mario Bellineli", "41", "Italian", "London", "64000", "25867074","321467432"},
										   {"Giannis Karampelas", "43", "Greek", "San Diego", "79000", "46798701","547547987"},
										   {"Nigel Farage", "36", "British", "Athens", "175000", "56821400","432675876"},
										   {"Emily Blunt", "33", "USA", "London", "150000", "64366876","437856467"},
										   {"Dimitris Papanastasiou", "34", "Greek", "New York", "190000", "75765900","472813865"},
										   {"Matt Barnes", "38", "USA", "Athens", "110000", "84375480","798765320"},
										   {"John White", "35", "USA", "San Diego", "170000", "02142362","413653421"},
										  };
	@SuppressWarnings("unchecked")
	public static void createDatabase() {
		try {
			for(String[] attribute : attributes ) {
				employeeList.add(createEmployee(attribute[0], Integer.parseInt(attribute[1]), attribute[2], 
						attribute[3], Double.parseDouble(attribute[4]), attribute[5], attribute[6]));
			}

			File file=new File("WorkersDatabase.json");  
			file.createNewFile();  
			FileWriter fileWriter = new FileWriter(file); 
			fileWriter.write(employeeList.toJSONString());  
			fileWriter.flush();  
	        fileWriter.close();  
		
		} catch(IOException e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static JSONObject createEmployee(String full_name, long age, String nationality,
			String city_of_residence, double salary, String id, String ssn) {
		JSONObject employee = new JSONObject();
		
		employee.put("full_name", full_name);
		employee.put("age", age);
		employee.put("nationality", nationality);
		employee.put("city_of_residence", city_of_residence);
		employee.put("salary",salary);
		employee.put("ssn",ssn);
		employee.put("id",id);
		
		return employee;
	}
	
	@SuppressWarnings("unchecked")
	public static void addEmployeeToEmployeeList(JSONObject employee) {
		employeeList.add(employee); 
	}
}
