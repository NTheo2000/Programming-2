package src.RunHumanMasteR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WorkersDatabase {
	private static JSONArray employeeList = new JSONArray();
	private static String[] letters = {"A","a","B","b","C","c","D","d","E","e","F","f","G","g","H","h","I","i",
			"J","j","K","k","L","l","M","m","N","n","O","o","P","p","Q","q","R","r",
			"S","s","T","t","U","u","V","v","W","w","X","x","Y","y","Z","z","!","@","#","$","%","^","&","*","?"};
	
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

			File file = new File("WorkersDatabase.json");  
			file.createNewFile();  
			FileWriter fileWriter = new FileWriter(file); 
			fileWriter.write(employeeList.toJSONString());  
			fileWriter.flush();
	        fileWriter.close();
		} catch(IOException e) {
		}
	}

	@SuppressWarnings("unchecked")
	private static JSONObject createEmployee(String full_name, long age, String nationality,
			String city_of_residence, double salary, String id, String ssn) {
		JSONObject employee = new JSONObject();
		
		employee.put("full_name", full_name);
		employee.put("age", age);
		employee.put("nationality", nationality);
		employee.put("city_of_residence", city_of_residence);
		employee.put("salary",salary);
		employee.put("ssn",ssn);
		employee.put("id",id);
		employee.put("department", Employee.findDepartment(id));
		employee.put("username", id);
		employee.put("password", generatepassword());
		return employee;
	}
	private static String generateId(int dep) {
		Random r = new Random();
		String id = String.valueOf(dep);
		for(int i = 0; i <= 6; i++) {
			id += String.valueOf(r.nextInt(10));
		}
		return id;
	}
	private static String generatepassword() {
		Random r = new Random();
		int length = r.nextInt(8) + 8;
		String passwd = "";
		int n = 0;
		for (int i = 0; i < length; i++) {
			n = r.nextInt(62);
			if (n == 61) {
				passwd += (char) r.nextInt(10);
			} else {
				passwd += letters[n];
			}
		}
		return passwd;
	}
	@SuppressWarnings("unchecked")
	public static boolean changeUsernameorPassword(Employee employee, String key, String value)
			throws FileNotFoundException, IOException, ParseException {
		boolean update = false;
		JSONParser parser = new JSONParser();
		JSONArray list = (JSONArray) parser.parse(new FileReader("WorkersDatabase.json"));
		for (Object obj : list) {
			if (((JSONObject) obj).get("id").equals(employee.getId())) {
				((JSONObject) obj).replace(key, value);
				FileWriter writer = new FileWriter("WorkersDatabase.json");
				writer.write(list.toJSONString());
				writer.flush();
				writer.close();
				update = true;
				break;
			}
		}
		return update;
	}
	public static Employee checkCredentials(String username, char[] password) {
		JSONParser parser = new JSONParser();
		Employee obj = new Employee();
		String passwd = "";
		boolean flag = true;
		if (!username.isEmpty() && !password.equals(null)) {
			try {
				JSONArray list = (JSONArray) parser.parse(new FileReader("WorkersDatabase.json"));
				for (Object o : list) {
					JSONObject employee = (JSONObject) o;
					passwd = (String) employee.get("password");
					if (employee.get("username").equals(username) && passwd.length() == password.length) {
						for (int i = 0; i < passwd.length(); i++) {
							if (password[i] != passwd.charAt(i)) {
								flag = false;
								break;
							}
						}
						if (flag) {
							obj = new Employee(employee);
							break;
						}
					}
				}
			} catch (Exception e) {
			}
		}
		return obj;
	}
	@SuppressWarnings({ "unchecked" })
	public static void addEmployeeToEmployeeList(Candidate candidate, double salary)
			throws FileNotFoundException, IOException, ParseException, ClassNotFoundException {
		String id = generateId(candidate.getDepartmentId());
		JSONParser parser = new JSONParser();
		JSONArray list_of_employees = (JSONArray) parser.parse(new FileReader("WorkersDatabase.json"));
		list_of_employees.add(createEmployee(candidate.getFull_Name(),
				candidate.getAge(), candidate.getNationality(),
				candidate.getCity_of_residence(), salary,
				id, candidate.getSsn()));
		FileWriter writer = new FileWriter("WorkersDatabase.json");
		writer.write(list_of_employees.toJSONString());
		writer.flush();  
        writer.close();
	}
	protected static ArrayList<String> getId() {
		ArrayList<String> id = new ArrayList<String>();
		for(int i=0;i<25;i++) {
			id.add(attributes[i][5]);
		}
		return id;
	}
	public static ArrayList<Employee> getEmployeesbyDirectorsDepartment(String id)
			throws FileNotFoundException, IOException, ParseException {
		int dept_code = Integer.valueOf(id.substring(0, 1));
		JSONParser parser = new JSONParser();
		JSONArray employees = (JSONArray) parser.parse(new FileReader("WorkersDatabase.json"));
		ArrayList<Employee> dep_employees = new ArrayList<Employee>();
		for (Object obj : employees) {
			 // subtract 4 from the director's dept_code in the if statement to refer to the equivalent employee's department
			if (((String) ((JSONObject) obj).get("id")).startsWith(String.valueOf(dept_code - 4))) {
				dep_employees.add(new Employee((JSONObject) obj));
			}
		}
		return dep_employees;
	}


	public static boolean isUsernameUnique(String username) {
		boolean unique = false;
		JSONParser parser = new JSONParser();
		try {
			JSONArray employees = (JSONArray) parser.parse(new FileReader("WorkersDatabase.json"));
			for (Object employee : employees) {
				if (((JSONObject) employee).get("username").equals(username)) {
					throw new Exception();
				}
			}
			unique = true;
		} catch (Exception e) {
		}
		return unique;
	}
}
